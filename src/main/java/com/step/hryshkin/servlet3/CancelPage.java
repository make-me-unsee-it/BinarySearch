package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cancel_page"})
public class CancelPage extends HttpServlet {

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
                "<h3 align=\"center\">Нажми \"СОГЛАСЕН\", дружище!</h2>\n" +

                // картинка!

                "<form action=\"/homepage\" method=\"post\">\n" +
                "<p align=\"center\"><input type=\"submit\" value=\"Вернуться на главную\"></p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
