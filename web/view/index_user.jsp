<%@ page import="bean.Shop" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.User" %>
<%@ page import="util.PathUtil" %>
<%@ page import="service.ShopManage" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Shop> shopList = new ShopManage().getAllShop();
  User user = (User) session.getAttribute("user");
  // 第一次载入页面时，进行页面的初始化
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

  if (shopList != null) {
    stringBuffer.append("<tr>");

    stringBuffer.append("<td>");
    stringBuffer.append("门店图");
    stringBuffer.append("</td>");

    stringBuffer.append("<td>");
    stringBuffer.append("店名");
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

      /*点击进入店铺*/
      stringBuffer.append("<a href=\"index_shop_user.jsp?id_shop=" + shop.getId_shop() + "\">查看</a>");
      stringBuffer.append("</td>");

      stringBuffer.append("</tr>");
    }
  }
  stringBuffer.append("</table>");
  stringBuffer.append("</div>");

%>
<link rel="stylesheet" href="/image/css/box.css">
<html>
<head>
  <title>校园点餐系统</title>
</head>
<body>
<%
  out.print(stringBuffer);
%>
</body>
</html>
