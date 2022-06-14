package org.bo.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>I love you BB</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Hi world</h1>");
        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}
