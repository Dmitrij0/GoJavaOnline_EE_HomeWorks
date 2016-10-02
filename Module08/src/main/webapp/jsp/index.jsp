<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ToDo List</title>
</head>
<body>
<h2>Simple ToDo List</h2>
<form action="todolist" method="post">
    <h3><input type="submit" name="Add" value="Add"></h3>
    <table width="auto" border="1" align="left">
        <tr bgcolor="aqua">
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>State</th>
            <th>Priority</th>
            <th>Operations</th>
        </tr>
        <core:forEach items="${sessionScope.toDoList}" var="toDoItem">
            <tr>
                <td align="right"><core:out value="${toDoItem.getId()}"/></td>
                <td><input name="Name" type="text" value="${toDoItem.getName()}"/></td>
                <td><input name="Description" type="text" value="${toDoItem.getDescription()}"/></td>
                <td>
                    <select name="State">
                        <option value="${toDoItem.getState()}">
                            <core:out value="${toDoItem.getState().toString()}"/>
                        </option>
                        <core:forEach items="${toDoItem.nextStates()}" var="state">
                            <option value="${state}"><core:out value="${state.toString()}"/></option>
                        </core:forEach>
                    </select>
                </td>
                <td>
                    <select name="Priority">
                        <core:forEach items="${sessionScope.priorityList}" var="priority">
                            <option value="${priority}" ${priority == toDoItem.getPriority() ? 'selected' : ''}>
                                <core:out value="${priority.toString()}"/>
                            </option>
                        </core:forEach>
                    </select>
                </td>
                <td width="auto">
                    <button type="submit" name="Submit" value="${toDoItem.getId()}">Submit</button>
                    <button type="submit" name="Delete" value="${toDoItem.getId()}">Delete</button>
                </td>
            </tr>
        </core:forEach>
    </table>
</form>
</body>
</html>
