package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/victory_page"})
public class VictoryPage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SearchingPage.resetFieldValues();
        req.getSession().invalidate();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title><Бинарный поиск на сервлетах></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3 align=\"center\">Йа победиль!</h2>\n" +

                "<p align=\"center\"><img src=\"https://i.pinimg.com/originals/8b/24/be/8b24be0b449268501795b2116256a3e4.jpg\"></p>\n" +

                "<form action=\"/homepage\" method=\"post\">\n" +
                "<p align=\"center\"><input type=\"submit\" value=\"Вернуться на главную\"></p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
