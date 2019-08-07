package com.lhx.spring.servlet;

import com.lhx.spring.annotation.EnjoyController;
import com.lhx.spring.annotation.EnjoyQualifier;
import com.lhx.spring.annotation.EnjoyRequestMapping;
import com.lhx.spring.annotation.EnjoyService;
import com.lhx.spring.handler.RequestParamHandlerService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lihuaixin on 2019/8/5 16:42
 */
public class DispatcherServlet extends HttpServlet {
    private List<String> classNames = new ArrayList<>();
    private Map<String, Object> beans = new HashMap<>();
    private Map<String, Method> handMap = new HashMap<>();


    public DispatcherServlet() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1.扫描那些类需要被实例化 class(包及包一下的class)
        doScanPackage("com.lhx");

        //2. classNames 所有bean的全类名路径
        doInstance();

        //3. 依赖注入，把service注入到controller
        iocDi();

        //4.建立controller url与method的映射关系
        handlerMapping();
    }

    private void handlerMapping() {
        if (beans.size() < 1) {
            System.out.println("handlerMapping 没有bean");
        }
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance = entry.getValue();
            Class<?> aClass = instance.getClass();
            if (aClass.isAnnotationPresent(EnjoyRequestMapping.class)) {
                EnjoyRequestMapping rootPath = aClass.getAnnotation(EnjoyRequestMapping.class);
                Method[] methods = aClass.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(EnjoyRequestMapping.class)) {
                        EnjoyRequestMapping path = method.getAnnotation(EnjoyRequestMapping.class);
                        handMap.put(rootPath.value() + path.value(), method);
                    }
                }
            }
        }
    }

    private void iocDi() {
        if (beans.size() < 1) {
            System.out.println("iocDi 没有bean");
        }
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Class<?> aClass = entry.getValue().getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(EnjoyQualifier.class)) {
                    EnjoyQualifier annotation = field.getAnnotation(EnjoyQualifier.class);
                    String value = annotation.value();
                    field.setAccessible(true);
                    try {
                        field.set(entry.getValue(), beans.get(value));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private void doInstance() {
        if (classNames.size() > 0) {
            for (String className : classNames) {
                Class<?> aClass = null;
                try {
                    aClass = Class.forName(className.replace(".class", ""));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (aClass.isAnnotationPresent(EnjoyController.class)) {
                    EnjoyController enjoyController = aClass.getAnnotation(EnjoyController.class);
                    EnjoyRequestMapping enjoyRequestMapping = aClass.getAnnotation(EnjoyRequestMapping.class);
                    String value = enjoyRequestMapping.value();
                    try {
                        Object instance = aClass.newInstance();
                        beans.put(value, instance);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                } else if (aClass.isAnnotationPresent(EnjoyService.class)) {
                    EnjoyService ejoyService = aClass.getAnnotation(EnjoyService.class);
                    String value = ejoyService.value();
                    try {
                        Object instance = aClass.newInstance();
                        beans.put(value, instance);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /**
     * 扫描那些类需要被实例化
     *
     * @param basePackage
     */
    private void doScanPackage(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
        assert url != null;
        String fileStr = url.getFile();
        File file = new File(fileStr);
        String[] list = file.list();
        assert list != null;
        for (String path : list) {
            File filePath = new File(fileStr + path);
            if (filePath.isDirectory()) {
                doScanPackage(basePackage + "." + path);
            } else {
                classNames.add(basePackage + "." + filePath.getName());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String requestURI = req.getRequestURI();
            String contextPath = req.getContextPath();
            String path = requestURI.replaceAll(contextPath, "");
            if ("/".equals(path)) {
                resp.sendRedirect(contextPath + "/index.jsp");
                return;
            }
            Method method = handMap.get(path);
            if (method == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            String[] split = path.split("/");
            Object bean = beans.get("/" + split[1]);
            RequestParamHandlerService handlerService = (RequestParamHandlerService) beans.get("requestParamHandlerService");
            Object[] args = handlerService.handler(req, resp, method, beans);
            method.invoke(bean, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
