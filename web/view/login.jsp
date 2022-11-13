<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/13
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<body>
    <form action="${pageContext.request.contextPath}/Login" method="get">
      <div>
        <p>欢迎使用校园点餐系统！</p>
      </div>
      <div>
        <label for="id">请输入账号</label>
        <input type="text" name="id" id="id">
        <label for="password">请输入密码</label>
        <input type="text" name="password" id="password">
        <label for="identity"></label>
          <select name="identity" id="identity">
              <option value="user">我是用户</option>
              <option value="merchant">我是商家</option>
          </select>
        <input type="submit" value="登录">
          <a href="register.jsp">账号注册</a>
      </div>
    </form>
</body>
</html>
