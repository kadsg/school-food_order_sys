<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/11/12
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/box.css">
<head>
    <title>添加商铺</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/AddShop" method="post" enctype="multipart/form-data">
        <div>
            <p>添加商铺</p>
        </div>
        <div>
            <label for="id_merchant">请输入商家账号</label>
            <input type="text" name="id_merchant" id="id_merchant">
            <label for="name_shop">请输入店名</label>
            <input type="text" name="name_shop" id="name_shop">
            <label for="pic">请选择店面图片</label>
            <input type="file" name="pic" id="pic">
            <input type="submit" value="提交">
        </div>
    </form>
</body>
</html>
