<%@ page import="bean.User" %>
<%@ page import="bean.UserOrderList" %>
<%@ page import="bean.UserOrder" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/14
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
</head>
<link rel="stylesheet" href="/image/css/box.css">
<%
    User user = (User) session.getAttribute("user");
    List<UserOrder> userOrderList = (List<UserOrder>) session.getAttribute("userOrderList");
%>
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
    stringBuffer.append("<div>");
    stringBuffer.append("<table>");

    if (userOrderList != null) {
        // 表头
        stringBuffer.append("<tr>\n" +
                "        <th>订单编号</th>\n" +
                "        <th>店名</th>\n" +
                "        <th>数量</th>\n" +
                "        <th>总计</th>\n" +
                "        <th>预定时间</th>\n" +
                "        <th>下单时间</th>\n" +
                "        <th>操作</th>\n" +
                "    </tr>");
        for (UserOrder userOrder : userOrderList) {
            stringBuffer.append("<tr>\n" +
                    "        <td>" + userOrder.getId_order() + "</td>\n" +
                    "        <td>" + userOrder.getName_shop() + "</td>\n" +
                    "        <td>" + userOrder.getCount() + "</td>\n" +
                    "        <td>" + userOrder.getTotal() + "</td>\n" +
                    "        <td>" + userOrder.getTime_scheduled() + "</td>\n" +
                    "        <td>" + userOrder.getTime_order() + "</td>\n" +
                    "        <td><a href=\"/view/display_detail_order_user.jsp?id_order=" + userOrder.getId_order() + "\">查看详情</a></td>\n" +
                    "    </tr>");
        }
    } else {
        stringBuffer.append("<p>");
        stringBuffer.append("当前没有订单");
        stringBuffer.append("</p>");
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
