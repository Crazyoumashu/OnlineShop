package com.hhw.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        context.setAttribute("base", context.getContextPath());
        context.setAttribute("site", "楚江网上商城");
    }
}

