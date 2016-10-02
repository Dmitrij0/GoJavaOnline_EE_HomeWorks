package com.gojavaonline3.dlenchuk.ee.module08.todolist;

import com.gojavaonline3.dlenchuk.ee.module08.todolist.ToDoItem.Priority;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.gojavaonline3.dlenchuk.ee.module08.todolist.ToDoItem.*;

public class ToDoController extends HttpServlet {

    public static final String INDEX_JSP = "/jsp/index.jsp";
    public static final String TO_DO_LIST_NAME = "toDoList";
    public static final String PRIORITY_LIST_NAME = "priorityList";


    private List<ToDoItem> toDoList = new ArrayList<>();
    private List<Priority> priorityList = Arrays.asList(Priority.values());

    @Override
    public void init() throws ServletException {
        toDoList.add(new ToDoItem(toDoList.size() + 1, "First ToDo", "First ToDo Task"));
        toDoList.add(new ToDoItem(toDoList.size() + 1, "Second ToDo", "Second ToDo Task"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getResponse(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getResponse(request, response);
    }

    private void getResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(TO_DO_LIST_NAME) == null) {
            request.getSession().setAttribute(TO_DO_LIST_NAME, toDoList);
        }
        if (request.getSession().getAttribute(PRIORITY_LIST_NAME) == null) {
            request.getSession().setAttribute(PRIORITY_LIST_NAME, priorityList);
        }

        Map parameters = request.getParameterMap();

        if (parameters.containsKey("Submit")) {
            int itemIndex = Integer.valueOf(((String[]) parameters.get("Submit"))[0]) - 1;
            ToDoItem toDoItem = toDoList.get(itemIndex);
            toDoItem.setName(((String[]) parameters.get("Name"))[itemIndex]);
            toDoItem.setDescription(((String[]) parameters.get("Description"))[itemIndex]);
            toDoItem.setState(State.valueOf(((String[]) parameters.get("State"))[itemIndex]));
            toDoItem.setPriority(Priority.valueOf(((String[]) parameters.get("Priority"))[itemIndex]));
        } else if (parameters.containsKey("Delete")) {
            toDoList.remove(Integer.valueOf(((String[]) parameters.get("Delete"))[0]) - 1);
        } else if (parameters.containsKey("Add")) {
            toDoList.add(new ToDoItem(toDoList.size() + 1, "", ""));
        }

        getServletContext().getRequestDispatcher(INDEX_JSP).forward(request, response);
    }

}