<%@ page import="ucd.express.Employee" %>
<%@ page import="ucd.express.Express" %>
<%@ page import="ucd.express.ExpressDAO" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/6/2
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Employee em = (Employee) session.getAttribute("Employee");
    if (em == null){
        response.sendRedirect("login.jsp");
    } else {
        out.println("Welcome: " + em.getE_id());
    }
%>

<%@include file="Update.html"%>
    <%
        String ex_id = request.getParameter("update");
        if (ex_id != null){
            ExpressDAO.updateStatus(ex_id, em.getHub_id());
            out.println("Update Successfully!");
        }
    %>

</body>
</html>
