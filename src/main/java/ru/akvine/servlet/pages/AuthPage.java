package ru.akvine.servlet.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akvine.servlet.service.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthPage {
    private final AddPage addPage;

    public void login(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html><body>");
        printWriter.write("<form action=\"/authenticate/login.do\" method=\"post\">");
        printWriter.write("<div>");
        printWriter.write("<label>Username:</label>");
        printWriter.write("<input type=\"text\" placeholder=\"Enter username\" name=\"username\" required>");
        printWriter.write("<br>");
        printWriter.write("<label>Password:</label>");
        printWriter.write("<input type=\"password\" placeholder=\"Enter password\" name=\"password\" required>");
        printWriter.write("<br>");
        printWriter.write("<button type=\"submit\">Login</button");
        printWriter.write("</div>");
        printWriter.write("</form>");

        printWriter.write("</body></html>");
        printWriter.close();
    }

    public void success(HttpServletResponse response, User user) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        if (user.getRole().equals("ADMIN")) {
            addPage.add(response);
        } else {
            printWriter.write("<html><body>");
            printWriter.write(String.valueOf(new Date()));
            printWriter.write("<br>");
            printWriter.write("<a href=\"/greeting\">Main page</a>");
            printWriter.write("</body></html>");
            printWriter.close();
        }
    }

    public void failure(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html><body>");
        printWriter.write("<h1>Wrong credentials</h1>");
        printWriter.write("<a href=\"/greeting\">Main page</a>");
        printWriter.write("</body></html>");
        printWriter.close();
    }
}
