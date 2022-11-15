<%@ page import="bean.Merchant" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Shop" %>
<%@ page import="service.ShopManage" %>
<%@ page import="util.PathUtil" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  Merchant merchant = (Merchant) session.getAttribute("merchant");
  List<Shop> shopList = new ShopManage().getAllShop(merchant);
    StringBuffer stringBuffer = new StringBuffer();
    String path;
%>
<head>
    <title><%=merchant.getName()%>的商铺</title>
</head>
<link rel="stylesheet" href="/image/css/box.css">
<%--     输出商家所有商铺 --%>
<%
    stringBuffer.append("<div class=\"header\">\n" +
            "        <h1>校园点餐系统商家后台</h1>\n" +
            "        <h3>欢迎用户：" + merchant.getId() + "   " + merchant.getName() + "</h3></div>");
    stringBuffer.append("<div class=\"topnav\" style=\"margin: auto\">\n" +
            "        <a href=\"/view/index_merchant.jsp\">首页</a>\n" +
            "        <a href=\"/view/addShop.jsp\">新增商铺</a>\n" +
//            "        <a href=\"#\">订单查询</a>\n" +
            "    </div>");
    if (shopList != null) {
        stringBuffer.append("<div>");
        stringBuffer.append("<table>");

        stringBuffer.append("<div>");
        stringBuffer.append("<table>");

        stringBuffer.append("<tr>");

        stringBuffer.append("<td>");
        stringBuffer.append("门面图");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("店面名");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("操作");
        stringBuffer.append("</td>");

        stringBuffer.append("</tr>");

        for (Shop shop : shopList) {
            stringBuffer.append("<tr>");

            /*显示图片*/
            stringBuffer.append("<td>");
            path = PathUtil.getPath(shop);
            stringBuffer.append("<img src=\"" + path + "\" alt=\"" + shop.getName() + "\">");
            stringBuffer.append("</td>");

            /*显示店名*/
            stringBuffer.append("<td>");
            stringBuffer.append(shop.getName());
            stringBuffer.append("</td>");

            /*显示链接*/
            stringBuffer.append("<td>");
            stringBuffer.append("<a href=\"index_shop_merchant.jsp?id_shop=" + shop.getId_shop() + "&id_merchant=" + merchant.getId() + "\">查看</a>");
            stringBuffer.append("</td>");

            stringBuffer.append("</tr>");
        }
        stringBuffer.append("</table>");
        stringBuffer.append("</div>");

    } else {
        stringBuffer.append("你还没有商铺！");
        // TODO 提示无商铺信息
    }
%>
<body>
<%
    out.print(stringBuffer);
%>
</body>
</html>
