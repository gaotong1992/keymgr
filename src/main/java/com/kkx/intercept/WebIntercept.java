package com.kkx.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WebIntercept implements HandlerInterceptor{



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //判断是否处于登陆状态
        HttpSession session = request.getSession(false);
        if(session!=null){
            Object userobj = session.getAttribute("user");
            if(userobj!=null){
                return true;
            }else{
                try {
                    response.sendRedirect("login.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }else{
            try {
                response.sendRedirect("login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return  false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //System.out.println("333");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //System.out.println("1111");
    }

}
