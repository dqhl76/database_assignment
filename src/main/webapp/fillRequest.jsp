<%@ page import="ucd.express.ExpressDAO" %>
<%@ page import="ucd.express.Receiver" %>
<%@ page import="ucd.express.Sender" %>
<%@ page import="ucd.express.Express" %>
<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: lqyue
  Date: 2022/5/7
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="fill_info.html" %>
<div class="fillResult">
    <%
        String phone_sender = request.getParameter("phone_sender");
        String phone_receiver = request.getParameter("phone_receive");
        String content = request.getParameter("content");
        String company = request.getParameter("company");
        String uuid = ExpressDAO.generateID();

        Sender sender = ExpressDAO.getSenderByPhone(phone_sender);
        Receiver receiver = ExpressDAO.getReceiverByPhone(phone_receiver);

        String addressSender = sender.getAddress();
        String addressReceiver = receiver.getAddress();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int flag = ExpressDAO.addRequest(uuid, addressSender, addressReceiver, sender.getId(), receiver.getId(), content, company, timestamp);
        if (flag == 1)
            out.println("Create fill successfully");
        else
            out.println("Something wrong");
    %>
</div>
<%--<a href="fillRequest.jsp">Back</a>--%>
</body>
</html>
