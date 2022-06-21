package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/searching_page"})
public class SearchingPage extends HttpServlet {
    private static int result, left, right;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doBinarySearch(req.getParameter("answer"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().println(String.format(ResourceReader
                    .webPageContentToString("searching_page_source.html"), result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doBinarySearch(String value) {
        if (result == -1) result = 50;
        else {
            if (value.equals("меньше")) {
                right = result;
                result = (left + right) / 2;
            } else if (value.equals("больше")) {
                left = result;
                result = (left + right) / 2;
            }
        }
    }

    protected static void resetFieldValues() {
        result = -1;
        left = 0;
        right = 101;
    }
}
