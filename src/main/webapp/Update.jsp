<%@ page import="java.util.ArrayList" %>
<%@ page import="ucd.express.*" %><%--
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
//            If ID does not exist, an error will happen.
            int test = ExpressDAO.updateStatus(ex_id, em.getHub_id());
            if (test == 1){
                out.println("<h4 class = 'correct'>Update Successfully!</h4>");
            } else {
                out.println("<h3 class = 'wrong'> Some problems happened </h3>");
            }
            ArrayList<Status> statuses = ExpressDAO.getStatusByExpressId(ex_id);
            out.println("<ol class='updateList'>");
            for (int j = 0; j < statuses.size(); j++) {
                Hub hub = ExpressDAO.getHubById(statuses.get(j).getHub_id());
                out.println("<li >" + "<p>" + hub.getName() + "</p><p> " + hub.getLocation() + "</p><p> " + statuses.get(j).getTime() + "</p> </li>");
            }
            out.println("</ol>");
        }
    %>

</body>
</html>
