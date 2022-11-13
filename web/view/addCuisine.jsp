<%@ page import="bean.Shop" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/12
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  // 获取商铺
  // 为指定的商铺添加菜品
  Shop shop = (Shop) session.getAttribute("shop");
%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<head>
    <title>菜品添加</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/AddCuisine" method="post" enctype="multipart/form-data">
        <div>
            <p><%=shop.getName()%>-菜品添加</p>
        </div>
        <div>
            <label for="name_cuisine">请输入菜品名</label>
            <input type="text" name="name_cuisine" id="name_cuisine">
            <label for="price">请输入菜品单价</label>
            <input type="text" name="price" id="price">
            <label for="pic">请为菜品添加一张照片</label>
            <input type="file" name="pic" id="pic">
            <input type="submit" value="提交">
        </div>
    </form>
</body>
</html>
