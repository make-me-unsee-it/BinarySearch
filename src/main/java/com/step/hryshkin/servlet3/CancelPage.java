package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cancel_page"})
public class CancelPage extends HttpServlet {

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
            resp.getWriter().println(ResourceReader.webPageContentToString("cancel_page_source.html"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
