<%@ page import="service.OrderManage" %>
<%@ page import="bean.CuisineOrder" %>
<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.UserOrder" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/14
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="/image/css/box.css">
<%
  String id_order = request.getParameter("id_order");
  UserOrder userOrder = new OrderManage().getUserOrderById(id_order);
  User user = (User) session.getAttribute("user");
  List<CuisineOrder> cuisineOrderList = new OrderManage().getAllCuisineOrderById(id_order);
%>
<head>
    <title>订单详情</title>
</head>
<%
  StringBuffer stringBuffer = new StringBuffer();
  String path;
  stringBuffer.append("<div class=\"header\">\n" +
          "        <h1>欢迎使用校园点餐系统</h1>\n" +
          "        <h3>欢迎用户：" + user.getId() + "　　　　" + user.getName() + "</h3></div>");
  stringBuffer.append("<div class=\"topnav\" style=\"margin: auto\">\n" +
          "  <a href=\"/view/index_user.jsp\">首页</a>\n" +
          "  <a href=\"/GetUserOrder\">我的订单</a>\n" +
          "</div>");
%>
<%
  // 订单概览
  stringBuffer.append("<div>");
  stringBuffer.append("<table>");

  stringBuffer.append("<tr>\n" +
          "        <th>订单编号</th>\n" +
          "        <th>店名</th>\n" +
          "        <th>数量</th>\n" +
          "        <th>总计</th>\n" +
          "        <th>预定时间</th>\n" +
          "        <th>下单时间</th>\n" +
          "    </tr>");

  stringBuffer.append("<tr>\n" +
          "        <td>" + userOrder.getId_order() + "</td>\n" +
          "        <td>" + userOrder.getName_shop() + "</td>\n" +
          "        <td>" + userOrder.getCount() + "</td>\n" +
          "        <td>" + userOrder.getTotal() + "</td>\n" +
          "        <td>" + userOrder.getTime_scheduled() + "</td>\n" +
          "        <td>" + userOrder.getTime_order() + "</td>\n" +
          "    </tr>");
  stringBuffer.append("</table>");
  stringBuffer.append("</div>");

  stringBuffer.append("<div>");
  stringBuffer.append("<p>详情</p>");
  stringBuffer.append("<table>");


  stringBuffer.append("<tr>\n" +
          "        <th>菜名</th>\n" +
          "        <th>数量</th>\n" +
          "        <th>小计</th>\n" +
          "    </tr>");

  for (CuisineOrder cuisineOrder : cuisineOrderList) {
    stringBuffer.append("<tr>\n" +
            "        <td>" + cuisineOrder.getName_cuisine() + "</td>\n" +
            "        <td>" + cuisineOrder.getCount() + "</td>\n" +
            "        <td>" + cuisineOrder.getTotal() + "</td>\n" +
            "    </tr>");
  }
  stringBuffer.append("</table>");
  stringBuffer.append("</div>");
%>
<body>
<%
  out.print(stringBuffer);
%>
</body>
</html>
