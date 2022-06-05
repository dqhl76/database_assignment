<%@ page import="java.util.ArrayList" %>
<%@ page import="ucd.express.ExpressDAO" %>
<%@ page import="ucd.express.Hub" %><%--
  Created by IntelliJ IDEA.
  User: lqyue
  Date: 2022/6/5
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="hub_info.css">
</head>
<body>
<nav id='menu'>
    <input type='checkbox' id='responsive-menu' onclick='updatemenu()'><label></label>
    <ul>
        <li><a href='./fill_info.html'>Add Request</a></li>
        <li><a href='./search.html'>Search Request</a></li>
        <li><a href='./Update.html'>Update</a></li>
        <li class="login"><a href='./login.html'>Log In</a></li>
    </ul>
</nav>

<div class="hubResult">
    <%
        out.println("<h1>Hub ID & Hub Information </h1>");
        ArrayList<Hub> arrayList = ExpressDAO.getAllHub();
        out.println("<ul>");
        for (int i = 0; i < arrayList.size(); ++i) {
            out.println("<li>" + arrayList.get(i).getId() + " " + arrayList.get(i).getName() + " " + arrayList.get(i).getLocation() + "</li>");
        }
        out.println("</ul>");
    %>
</div>

</body>
</html>
