<%@ page import="bean.Shop" %>
<%@ page import="bean.UserOrder" %>
<%@ page import="java.util.List" %>
<%@ page import="service.OrderManage" %>
<%@ page import="bean.ShopOrder" %>
<%@ page import="bean.Merchant" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/14
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商铺订单</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<%
    // 获取当前商铺
    Shop shop = (Shop) session.getAttribute("shop");
    String id_shop = shop.getId_shop();

    // 获取当前商家
    Merchant merchant = (Merchant) session.getAttribute("merchant");
    // 获取商铺的所有订单
    List<ShopOrder> shopOrderList = new OrderManage().getAllOrderOfShop(shop);
%>
<%
    // 添加固定表头
    StringBuffer stringBuffer = new StringBuffer();
    String path;
    stringBuffer.append("<div class=\"header\">\n" +
            "        <h1>校园点餐系统商家后台</h1>\n" +
            "        <h3>欢迎用户：" + merchant.getId() + "　　　　" + merchant.getName() + "</h3></div>");
    stringBuffer.append("<div class=\"topnav\" style=\"margin: auto\">\n" +
            "      <a href=\"/view/index_merchant.jsp\">首页</a>\n" +
            "      <a href=\"addCuisine.jsp?id_shop=" + id_shop + "\">新增菜品</a>\n" +
            "      <a href=\"#\">修改菜品信息</a>\n" +
            "      <a href=\"/view/display_order_shop.jsp\">订单查询</a>\n" +
            "    </div>");
%>
<%
    // 显示主体
    if (shopOrderList != null) {

        stringBuffer.append("<div>");
        stringBuffer.append("<table>");

        stringBuffer.append("<tr>");

        stringBuffer.append("<td>");
        stringBuffer.append("订单号");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("下单时间");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("数量");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("小计（元）");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("操作");
        stringBuffer.append("</td>");

        stringBuffer.append("</tr>");

        for (ShopOrder shopOrder : shopOrderList) {
            stringBuffer.append("<tr>");

            /*订单号*/
            stringBuffer.append("<td>");
            stringBuffer.append(shopOrder.getId_order());
            stringBuffer.append("</td>");

            /*下单时间*/
            stringBuffer.append("<td>");
            stringBuffer.append(shopOrder.getTime_order());
            stringBuffer.append("</td>");

            /*数量*/
            stringBuffer.append("<td>");
            stringBuffer.append(shopOrder.getCount());
            stringBuffer.append("</td>");

            /*小计*/
            stringBuffer.append("<td>");
            stringBuffer.append(shopOrder.getTotal());
            stringBuffer.append("</td>");

            /*操作*/
            // TODO
            stringBuffer.append("<td>");
            stringBuffer.append("<a href=\"/CheckOrderOfShop?id_order=" + shopOrder.getId_order() + "\">查看详情</a>");
            stringBuffer.append("</td>");

            stringBuffer.append("</tr>");
        }

        stringBuffer.append("</table>");
        stringBuffer.append("</div>");

    } else {
        stringBuffer.append("该店铺暂无订单");
    }
%>
<body>
<%
    out.print(stringBuffer);
%>
</body>
</html>
