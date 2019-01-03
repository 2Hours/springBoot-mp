package com.shop.hzq.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        得到session
        HttpSession session = httpServletRequest.getSession();
//        得到对象
        Object user = session.getAttribute("user");
//        判断对象是否存在
        if(user!=null){
            return true;
        }else{
//            不存在则跳转到登录页
            httpServletResponse.sendRedirect("/visit/view/login");
            return false;
        }
    }

}
