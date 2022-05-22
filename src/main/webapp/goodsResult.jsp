<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/5/3
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ucd.express.ExpressDAO" %>
<%@ page import="ucd.express.Express" %>

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
        String eid = request.getParameter("expressID");
        if (eid != null) {
            Express e = ExpressDAO.getExpressByID(eid);
            out.println(e.toString());
        }
    %>
</div>
</body>
</html>
