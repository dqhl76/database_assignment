<%@ page import="ucd.express.Employee" %>
<%@ page import="ucd.express.ExpressDAO" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/6/1
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="login.html"%>
    <%
        String username = request.getParameter("login");
        String password = request.getParameter("password");

        Employee em = ExpressDAO.login(username, password);

        if (em != null){
            session.setAttribute("Employee", em);
            out.println("<p class= 'correct'>Welcome: " + em.getE_id() + "</p>");
        } else {
            out.println("<p class = 'wrong'>Login Failed </p>");
        }
    %>
</body>
</html>
