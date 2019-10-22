package com.lhx.spring.controller;

import com.lhx.spring.annotation.EnjoyController;
import com.lhx.spring.annotation.EnjoyQualifier;
import com.lhx.spring.annotation.EnjoyRequestMapping;
import com.lhx.spring.annotation.EnjoyRequestParam;
import com.lhx.spring.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lihuaixin on 2019/8/5 16:35
 */
@EnjoyController
@EnjoyRequestMapping("/order")
public class OrderController {
    @EnjoyQualifier("orderService")
    private OrderService orderService;

    @EnjoyRequestMapping("/queryOrder")
    public void queryOrder(HttpServletResponse response, HttpServletRequest request, @EnjoyRequestParam("orderId") String orderId) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write(orderService.queryOrder(orderId));
    }

    @EnjoyRequestMapping("/queryOrderView")
    public String queryOrderView(HttpServletResponse response, HttpServletRequest request, @EnjoyRequestParam("orderId") String orderId) throws IOException {
        request.setAttribute("orderId", orderId);
        return "/order.jsp";
    }
}
