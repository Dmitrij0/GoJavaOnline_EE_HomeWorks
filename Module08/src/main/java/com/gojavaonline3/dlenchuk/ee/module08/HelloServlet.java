package com.gojavaonline3.dlenchuk.ee.module08;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getResponse(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getResponse(request, response);
    }

    private void getResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = "Using " + request.getMethod() + " Method to Read Form Data";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        PrintWriter writer = response.getWriter();
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>" +
                "<ul>\n" +
                "   <li><b>First name</b>: " + request.getParameter("first_name") + '\n' +
                "   <li><b>Last name</b>: " + request.getParameter("last_name") + '\n' +
                "</ul>\n" +
                "</body></html>");
    }

}
