package com.step.hryshkin.servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/searching_page"})
public class SearchingPage extends HttpServlet {
    public static int result;
    public static String less = "меньше";
    public static String more = "больше";
    public static int left = 0;
    public static int right = 101;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (result == -1) result = 50;
        else {
            if (req.getParameter("answer").equals(less)) {
                right = result;
                result = (left + right) / 2;
            }
            else if (req.getParameter("answer").equals(more)) {
                left = result;
                result = (left + right) / 2;
            }
        }
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Бинарный поиск на сервлетах</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3 align=\"center\">вы ввели число " + result + ". Угадал?</h2>\n" +

                "<table align=\"center\">\n" +
                "<tr >\n" +
                "<td>" +
                "<form action=\"/searching_page\" method=\"get\">\n" +
                "<p align=\"center\"><input type=\"submit\" name=\"answer\" value=\"меньше\"></p>\n" +
                "</form>\n" +
                "</td>\n" +

                "<td><form action=\"/victory_page\" method=\"get\">\n" +
                "<p align=\"center\"><input type=\"submit\" value=\"угадал!\"></p>\n" +
                "</form>\n</td>\n" +

                "<td><form action=\"/searching_page\" method=\"get\">\n" +
                "<p align=\"center\"><input type=\"submit\" name=\"answer\" value=\"больше\"></p>\n" +
                "</form>\n</td>\n" +

                "</tr>\n" +
                "</table>" +

                "</body>\n" +
                "</html>");
    }
}
