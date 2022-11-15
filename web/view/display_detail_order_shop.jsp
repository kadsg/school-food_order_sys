<%@ page import="bean.User" %>
<%@ page import="bean.UserOrder" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Merchant" %>
<%@ page import="bean.CuisineOrder" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/15
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css"><%
    Merchant merchant = (Merchant) session.getAttribute("merchant");
    UserOrder checkingUserOrder = (UserOrder) session.getAttribute("checkingUserOrder");
    List<CuisineOrder> checkingCuisineOrderList = (List<CuisineOrder>) session.getAttribute("checkingCuisineOrderList");
%>
<%
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("<div class=\"header\">\n" +
            "        <h1>校园点餐系统商家后台</h1>\n" +
            "        <h3>欢迎用户：" + merchant.getId() + "　　　　" + merchant.getName() + "</h3></div>");
    stringBuffer.append("<div class=\"topnav\" style=\"margin: auto\">\n" +
            "  <a href=\"/view/index_shop_merchant.jsp\">回到首页</a>\n" +
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
            "        <td>" + checkingUserOrder.getId_order() + "</td>\n" +
            "        <td>" + checkingUserOrder.getName_shop() + "</td>\n" +
            "        <td>" + checkingUserOrder.getCount() + "</td>\n" +
            "        <td>" + checkingUserOrder.getTotal() + "</td>\n" +
            "        <td>" + checkingUserOrder.getTime_scheduled() + "</td>\n" +
            "        <td>" + checkingUserOrder.getTime_order() + "</td>\n" +
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

    for (CuisineOrder cuisineOrder : checkingCuisineOrderList) {
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