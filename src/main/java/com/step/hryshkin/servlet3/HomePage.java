package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/homepage"})
public class HomePage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SearchingPage.resetFieldValues();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title><Бинарный поиск на сервлетах></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3 align=\"center\">Загадайте в уме число от 0 до 100</h2>\n" +
                "<form action=\"/searching_page\" method=\"post\">\n" +
                "<p align=\"center\"><input type=\"submit\" value=\"ОК!\"></p>\n" +
                "<p align=\"center\"><input type=\"checkbox\" name=\"check\" >я все понял и СОГЛАСЕН!</p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
