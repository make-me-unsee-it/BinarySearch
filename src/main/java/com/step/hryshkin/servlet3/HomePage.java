package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/homepage"})
public class HomePage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        SearchingPage.resetFieldValues();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().println(ResourceReader.webPageContentToString("homepage_source.html"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
