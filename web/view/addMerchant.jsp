<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/12
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家注册</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<body>
    <form action="${pageContext.request.contextPath}/AddMerchant" method="get">
      <div>
        <p>商户注册</p>
      </div>
      <div>
        <label for="id_merchant">请输入账号</label>
        <input type="text" name="id_merchant" id="id_merchant">
        <label for="password">请输入密码</label>
        <input type="text" name="password" id="password">
        <label for="name_merchant">请输入姓名</label>
        <input type="text" name="name_merchant" id="name_merchant">
        <label for="phone">请输入手机号</label>
        <input type="text" name="phone" id="phone">
        <input type="submit" value="提交">
      </div>
    </form>
</body>
</html>
