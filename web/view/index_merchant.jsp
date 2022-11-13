<%@ page import="bean.Merchant" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统后台</title>
</head>
<link rel="stylesheet" href="/image/css/box.css">
<%
    Merchant merchant = (Merchant) session.getAttribute("merchant");
%>
<body>
    <div class="header">
        <h1>校园点餐系统商家后台</h1>
        <h3>欢迎用户：<%=merchant.getId()%>　　　<%=merchant.getName()%></h3>
    </div>

    <div class="topnav" style="margin: auto">
        <a href="/view/checkShop.jsp">查看我的商铺</a>
        <a href="#">订单查询</a>
    </div>
</body>
</html>
