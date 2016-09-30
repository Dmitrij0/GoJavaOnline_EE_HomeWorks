<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTTP header request example</title>
</head>
<body>
<h2>HTTP header request example</h2>
<table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
        <th>Header Name</th>
        <th>Header Value(s)</th>
    </tr>
    <%
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = request.getHeader(headerName);
            out.print("<tr><td>" + headerName + "</td>\n");
            out.print("<td>" + headerValue + "</td></tr>\n");
        }
    %>
</table>
</body>
</html>
