<%@ page import="bean.Shop" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Shop> shopList = (List<Shop>) application.getAttribute("shopList");
  // 第一次载入页面时，进行页面的初始化
  if (shopList == null) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/Init");
    dispatcher.forward(request, response);
  }
%>
<link rel="stylesheet" href="/image/css/box.css">
<html>
<head>
  <title>校园点餐系统</title>
</head>
<body>
<div class="header">
  <h1>头部区域</h1>
</div>

<div class="topnav" style="margin: auto">
  <a href="#">首页</a>
  <a href="#">个人中心</a>
</div>

<%--  在这个区域显示shop列表--%>
<p>AAAAAAAAAAAAAAA</p>
<p>AAAAAAAAAAAAAAA</p>
<p>AAAAAAAAAAAAAAA</p>
<p>AAAAAAAAAAAAAAA</p>
<p>AAAAAAAAAAAAAAA</p>
<%=shopList.size()%>

</body>
</html>
