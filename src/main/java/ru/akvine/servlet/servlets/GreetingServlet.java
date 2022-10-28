package ru.akvine.servlet.servlets;

import lombok.RequiredArgsConstructor;
import ru.akvine.servlet.pages.GreetingPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/greeting")
@RequiredArgsConstructor
public class GreetingServlet extends HttpServlet {
    private final GreetingPage greetingPage;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        greetingPage.greeting(resp);
    }
}
