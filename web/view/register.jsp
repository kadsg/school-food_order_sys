<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<body>
<form action="${pageContext.request.contextPath}/Register" method="get">
  <div>
    <p>欢迎使用校园点餐系统！</p>
  </div>
  <div>
    <p>用户注册</p>
    <label for="id">请输入注册账号</label>
    <input type="text" name="id" id="id">
    <label for="password">请输入注册密码</label>
    <input type="text" name="password" id="password">
    <label for="name">请输入你的姓名</label>
    <input type="text" name="name" id="name">
    <label for="phone">请输入手机号</label>
    <input type="text" name="phone" id="phone">
    <input type="submit" value="提交">
  </div>
</form>
</body>
</html>
