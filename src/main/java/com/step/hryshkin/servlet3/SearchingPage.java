package com.step.hryshkin.servlet3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/searching_page"})
public class SearchingPage extends HttpServlet {
    private static int result;
    private static int left;
    private static int right;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            doBinarySearch(req.getParameter("answer"));

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
                    "<form action=\"/searching_page\" method=\"post\">\n" +
                    "<p align=\"center\"><input type=\"submit\" name=\"answer\" value=\"меньше\"></p>\n" +
                    "</form>\n" +
                    "</td>\n" +

                    "<td><form action=\"/victory_page\" method=\"post\">\n" +
                    "<p align=\"center\"><input type=\"submit\" value=\"угадал!\"></p>\n" +
                    "</form>\n</td>\n" +

                    "<td><form action=\"/searching_page\" method=\"post\">\n" +
                    "<p align=\"center\"><input type=\"submit\" name=\"answer\" value=\"больше\"></p>\n" +
                    "</form>\n</td>\n" +

                    "</tr>\n" +
                    "</table>" +

                    "</body>\n" +
                    "</html>");
    }

    private static void doBinarySearch (String value) {
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
