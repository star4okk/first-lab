package ru.akvine.servlet.pages;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AddPage {
    public void add(HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html><body>");
        printWriter.write("<form action=\"/add.do\" method=\"post\">");
        printWriter.write("<div>");
        printWriter.write("<label>Username:</label>");
        printWriter.write("<input type=\"text\" placeholder=\"Enter username\" name=\"username\" required>");
        printWriter.write("<br>");
        printWriter.write("<label>Password:</label>");
        printWriter.write("<input type=\"password\" placeholder=\"Enter password\" name=\"password\" required>");
        printWriter.write("<br>");
        printWriter.write("<label>Phone:</label>");
        printWriter.write("<input type=\"text\" placeholder=\"Enter phone\" name=\"phone\">");
        printWriter.write("<br>");
        printWriter.write("<label>Email:</label>");
        printWriter.write("<input type=\"text\" placeholder=\"Enter email\" name=\"email\">");
        printWriter.write("<button type=\"submit\">Add</button");
        printWriter.write("</div>");
        printWriter.write("</form>");
        printWriter.write("<br>");
        printWriter.write("<a href=\"/greeting\">Main page</a>");
        printWriter.write("</body></html>");
        printWriter.close();
    }
}
