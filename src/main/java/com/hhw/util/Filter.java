package com.hhw.util;

import com.hhw.beans.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        if(uri.endsWith("login")||uri.endsWith("exploded/")||uri.endsWith("toLogin")||uri.endsWith("code")||uri.endsWith("index")||uri.endsWith("index.jsp")){
            chain.doFilter(request,response);
            System.out.println("奇了怪了");
            return;
        }

        Users users = (Users) request.getSession().getAttribute("user");
        if(null==users){
            System.out.println("kkkk");
            response.sendRedirect("/onlineShop_war_exploded/user/toLogin");
            return;
        }

        chain.doFilter(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
