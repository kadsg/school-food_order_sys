<%@ page import="bean.Shop" %>
<%@ page import="service.ShopManage" %>
<%@ page import="bean.Cuisine" %>
<%@ page import="service.CuisineManage" %>
<%@ page import="java.util.List" %>
<%@ page import="util.PathUtil" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<%
    String id_shop = request.getParameter("id_shop");
    Shop shop = new ShopManage().getShopById(id_shop);
    User user = (User) session.getAttribute("user");
    // 获取商店菜品
    List<Cuisine> cuisineList = new CuisineManage().search(shop);
%>
<%
    StringBuffer stringBuffer = new StringBuffer();
    String path;
    stringBuffer.append("<div class=\"header\">\n" +
            "        <h1>欢迎使用校园点餐系统</h1>\n" +
            "        <h3>欢迎用户：" + user.getId() + "　　　　" + user.getName() + "</h3></div>");
    stringBuffer.append("<div class=\"topnav\" style=\"margin: auto\">\n" +
            "      <a href=\"/view/index_user.jsp\">返回首页</a>\n" +
            "      <a href=\"/GetUserOrder\">订单查询</a>\n" +
            "    </div>");

    if (cuisineList != null) {
        stringBuffer.append("<form action=\"/Buy\">");
        stringBuffer.append("<div>");
        stringBuffer.append("<table>");

        stringBuffer.append("<tr>");

        stringBuffer.append("<td>");
        stringBuffer.append("菜品图");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("菜名");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("单价（元）");
        stringBuffer.append("</td>");

        stringBuffer.append("<td>");
        stringBuffer.append("选择");
        stringBuffer.append("</td>");

        stringBuffer.append("</tr>");

        for (Cuisine cuisine : cuisineList) {
            stringBuffer.append("<tr>");

            /*显示图片*/
            stringBuffer.append("<td>");
            path = PathUtil.getPath(cuisine);
            stringBuffer.append("<img src=\"" + path + "\" alt=\"" + cuisine.getName() + "\" width: 50px; height: 50px>");
            stringBuffer.append("</td>");

            /*显示菜名*/
            stringBuffer.append("<td>");
            stringBuffer.append(cuisine.getName());
            stringBuffer.append("</td>");

            /*显示价格*/
            stringBuffer.append("<td>");
            stringBuffer.append(cuisine.getPrice());
            stringBuffer.append("</td>");

            /*复选框*/
            stringBuffer.append("<td>");
            stringBuffer.append("<input type=\"checkbox\" name=\"cuisine\" value=\"" + cuisine.getId_cuisine() + "\">");
            stringBuffer.append("</td>");

            stringBuffer.append("</tr>");
        }
        stringBuffer.append("</table>");

        stringBuffer.append("<div>");
        stringBuffer.append("<label for=\"time\">请选择预定时间</label>");
        stringBuffer.append("<input type=\"datetime-local\" step=\"01\" id=\"time\" name=\"time\">");
        stringBuffer.append("<br>");
        stringBuffer.append("<div>");

        stringBuffer.append("<input type=\"hidden\" name=\"id_shop\" value=\"" + shop.getId_shop() + "\">");
        stringBuffer.append("<input type=\"submit\" value=\"下单\" onclick= >");

        stringBuffer.append("</div>");
        stringBuffer.append("</form>");

    } else {
        stringBuffer.append("<div>");
        stringBuffer.append("<p>该店铺暂无菜品<p>");
        stringBuffer.append("</div>");
    }
%>
<head>
    <title><%=shop.getName()%></title>
</head>
<body>
<%
    out.print(stringBuffer);
%>
</body>
</html>
