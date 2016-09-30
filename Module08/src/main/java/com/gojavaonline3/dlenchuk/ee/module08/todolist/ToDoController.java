package com.gojavaonline3.dlenchuk.ee.module08.todolist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToDoController extends HttpServlet {

    public static final String INDEX_JSP = "/jsp/index.jsp";
    public static final String TO_DO_LIST_NAME = "todoList";

    private List<ToDoItem> toDoList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(TO_DO_LIST_NAME) == null) {
            request.getSession().setAttribute(TO_DO_LIST_NAME, toDoList);
        }
        System.out.println("ContextPath: " + getServletContext().getContextPath());
        getServletContext().getRequestDispatcher(INDEX_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(TO_DO_LIST_NAME) == null) {
            request.getSession().setAttribute(TO_DO_LIST_NAME, toDoList);
        }
        getServletContext().getRequestDispatcher(INDEX_JSP).forward(request, response);
    }

}