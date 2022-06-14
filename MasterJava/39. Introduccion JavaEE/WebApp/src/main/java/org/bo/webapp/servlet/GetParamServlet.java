package org.bo.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/url-get/param")
public class GetParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String greeting = req.getParameter("greetings");
        String name = req.getParameter("name");

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>Hello World</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>A good world</h1>");
        if (name != null && greeting != null) {
            out.println("        <h2>The greetings is: " + greeting + " " + name + "</h2>");
        } else if (greeting != null) {
            out.println("        <h2>The greetings is: " + greeting + "</h2>");
        } else if (name != null) {
            out.println("        <h2>The name is: " + name + "</h2>");
        } else {
            out.println("        <h2>Parameters greetings and name don't exist</h2>");
        }
        try {
            int code = Integer.parseInt(req.getParameter("code"));
            out.println("        <h2>El code sent is: " + code + "</h2>");
        } catch (NumberFormatException numberFormatException) {
            out.println("        <h2>The code is null</h2>");
        }
        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}
