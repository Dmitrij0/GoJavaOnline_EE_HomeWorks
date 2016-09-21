package com.gojavaonline3.dlenchuk.ee.module08;

import com.gojavaonline3.dlenchuk.ee.module08.todolist.ToDoItem;

public class ToDoRunner {

    public static void main(String[] args) {
        new ToDoItem(ToDoItem.Priority.HIGH, "First", "First ToDo");
    }

}
