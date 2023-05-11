package com.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/LoginServlet")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //判断资源路径是否相关
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/registerServlet","/register.jsp","/checkCodeServlet"};

        String s = req.getRequestURL().toString();
        System.out.println(s);
        for(String u:urls){
            if(s.contains(u)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        //1、判断session中是否有登录信息

        HttpSession session = req.getSession();
        Object student = session.getAttribute("student");

        //2.判断是否为null
        if(student!=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            req.setAttribute("login_msg","您尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
