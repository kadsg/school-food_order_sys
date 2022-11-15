<%@ page import="bean.Shop" %>
<%@ page import="service.ShopManage" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Merchant" %>
<%@ page import="bean.Cuisine" %>
<%@ page import="service.CuisineManage" %>
<%@ page import="util.PathUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String id_shop = request.getParameter("id_shop");
    Shop shop = new ShopManage().getShopById(id_shop);
    Merchant merchant = (Merchant) session.getAttribute("merchant");
  // 将shop加入到session中以供其他页面加载
  request.getSession().setAttribute("shop", shop);
  // 获取商店菜品
  List<Cuisine> cuisineList = new CuisineManage().search(shop);
%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<head>
    <title><%=shop.getName()%></title>
</head>
<%--商家的shop界面--%>
<%
  StringBuffer stringBuffer = new StringBuffer();
  String path;
  stringBuffer.append("<div class=\"header\">\n" +
          "        <h1>校园点餐系统商家后台</h1>\n" +
          "        <h3>欢迎用户：" + merchant.getId() + "　　　　" + merchant.getName() + "</h3></div>");
  stringBuffer.append("<div class=\"topnav\" style=\"margin: auto\">\n" +
          "      <a href=\"/view/index_merchant.jsp\">首页</a>\n" +
          "      <a href=\"/view/addCuisine.jsp?id_shop=" + id_shop + "\">新增菜品</a>\n" +
          "      <a href=\"/view/deleteCuisine.jsp?id_shop=" + id_shop + "\">删除菜品</a>\n" +
          "      <a href=\"#\">修改菜品信息</a>\n" +
          "      <a href=\"/view/display_order_shop.jsp\">订单查询</a>\n" +
          "    </div>");

  if (cuisineList != null) {
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

    stringBuffer.append("</tr>");

    for (Cuisine cuisine : cuisineList) {
      stringBuffer.append("<tr>");

      /*显示图片*/
      stringBuffer.append("<td>");
      path = PathUtil.getPath(cuisine);
      stringBuffer.append("<img src=\"" + path + "\" alt=\"" + cuisine.getName() + "\" width: 50px; height: 50px>");
      stringBuffer.append("</td>");

      /*显示店名*/
      stringBuffer.append("<td>");
      stringBuffer.append(cuisine.getName());
      stringBuffer.append("</td>");

      /*显示价格*/
      stringBuffer.append("<td>");
      stringBuffer.append(cuisine.getPrice());
      stringBuffer.append("</td>");

      /*显示链接*/
      // TODO 对菜品的详细操作
//      stringBuffer.append("<td>");
//      stringBuffer.append("<a href=\"index_cuisine_merchant.jsp?id_cuisine=" + cuisine.getId_cuisine() + "\">查看</a>");
//      stringBuffer.append("</td>");

      stringBuffer.append("</tr>");
    }
    stringBuffer.append("</table>");
    stringBuffer.append("</div>");

  } else {
    stringBuffer.append("该店铺暂无菜品");
  }
%>
<body>
  <%
    out.print(stringBuffer);
  %>
</body>
</html>
