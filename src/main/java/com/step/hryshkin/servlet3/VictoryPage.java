package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/victory_page"})
public class VictoryPage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        SearchingPage.resetFieldValues();
        req.getSession().invalidate();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().println(ResourceReader.webPageContentToString("victory_page_source.html"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
