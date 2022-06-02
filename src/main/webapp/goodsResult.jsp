<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/5/3
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ucd.express.*" %>

<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="./demo.css">
</head>
<body>
<%@include file="demo.html" %>
<%--    <a href="demo.html">Back</a>--%>
<div class="searchResult">
    <%
        out.println("<ul>");
        String eid = request.getParameter("expressID");
        if (eid.length() > 7) {
            Sender sender = ExpressDAO.getSenderByPhone(eid);
            Express[] expresses = ExpressDAO.getExpressBySenderId(sender.getId());
            for (int i = 0; i < expresses.length; ++i) {
                out.println("<li>" + expresses[i].toString());
                out.println("<ol>");
                ArrayList<Status> statuses = ExpressDAO.getStatusByExpressId(expresses[i].getId());
                for (int j = 0; j < statuses.size(); ++j) {
                    Hub hub = ExpressDAO.getHubById(statuses.get(j).getHub_id());
                    out.println("<li>" + "<p>" + hub.getName() + "</p><p> " + hub.getLocation() + "</p><p> " + statuses.get(j).getTime() + "</p> </li>");
                }
                out.println("</ol>");
                out.println("</li>");
            }
            if (expresses.length == 0) {
                out.println("Please enter a valid express id or phone number.");
            }
        } else if (eid != null) {
            Express e = ExpressDAO.getExpressByID(eid);
            out.println(e.toString());
        } else {
            out.println("Please enter a valid express id or phone number.");
        }

        out.println("</ul>");
    %>
</div>
</body>
</html>
