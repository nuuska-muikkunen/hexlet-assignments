package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String message;
        if (req.getQueryString() == null) {
            message = "Hello, Guest!";
        } else {
            message = "Hello, " + req.getQueryString().substring(req.getQueryString().indexOf('=') + 1) + "!";
        }
        req.setAttribute("message", message);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, res);
    }
    // END
}
