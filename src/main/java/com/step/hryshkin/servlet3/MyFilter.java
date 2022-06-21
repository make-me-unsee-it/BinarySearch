package com.step.hryshkin.servlet3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/searching_page")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getSession().getAttribute("check") == null) {
            if (request.getParameter("check") != null) {
                request.getSession().setAttribute("check", request.getParameter("check"));
            } else {
                ServletContext servletContext = request.getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/cancel_page");
                requestDispatcher.forward(request, servletResponse);
            }
        }
        filterChain.doFilter(request, servletResponse);
    }
}

