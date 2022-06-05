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
</head>
<body>

<div class="hubResult">
    <%
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
