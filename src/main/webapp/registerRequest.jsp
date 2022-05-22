<%--
  Created by IntelliJ IDEA.
  User: lqyue
  Date: 2022/5/7
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ucd.express.ExpressDAO" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="register.html" %>
<div class="registerResult">
    <%
        String username = request.getParameter("login");
        String phone_num = request.getParameter("phone");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String uuid = ExpressDAO.generateID();
        if (username != null) {
            ExpressDAO.addReceiver(uuid, username, address, phone_num, password);
            ExpressDAO.addSender(uuid, username, address, phone_num, password);
        }

//        out.println("Create account successfully");
    %>
</div>
<%--<a href="registerRequest.jsp">Back</a>--%>
</body>
</html>
