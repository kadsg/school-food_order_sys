<%@ page import="java.util.List" %>
<%@ page import="bean.Shop" %>
<%@ page import="bean.User" %>
<%@ page import="bean.Merchant" %>
<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/11
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = (String) application.getAttribute("path");
    if (path == null) {
        // 本地文件夹
        path = "D:/JavaWeb/school-food_order_sys/web";
        application.setAttribute("path", path);
    }

    User user = (User) session.getAttribute("user");
    Merchant merchant = (Merchant) session.getAttribute("merchant");

    if (user == null && merchant == null) {
        // 没有登录信息，导航到登录界面
        response.sendRedirect("/view/login.jsp");
    } else if (user != null) {
        response.sendRedirect("/view/index_user.jsp");
    } else {
        response.sendRedirect("/view/index_merchant.jsp");
    }
%>
<link rel="stylesheet" href="/image/css/box.css">
<html>
  <head>
    <title>校园点餐系统</title>
  </head>
  <body>
  </body>
</html>
