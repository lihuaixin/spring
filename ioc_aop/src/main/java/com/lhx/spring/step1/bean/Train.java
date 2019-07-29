package com.lhx.spring.step1.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by lihuaixin on 2019/7/15 16:01
 */
@Component
public class Train implements InitializingBean, DisposableBean {
    public Train() {
        System.out.println("Train constructor……");
    }

    /**
     * bean 初始化完成时调用
     *
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train afterPropertiesSet()……");
    }

    /**
     * bean 销毁时调用
     *
     * @throws Exception
     */
    public void destroy() throws Exception {
        System.out.println("Train destroy()……");
    }
}
