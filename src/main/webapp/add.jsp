<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>名片管理系统</title>
</head>
<body>
  <h1 align="center">添加名片</h1>
  <h3 align="center">当前登录用户：${user.username}</h3>
  <form action="/add" method="post">
    姓名：<input name="name"><br>
    年龄：<input name="age"><br>
    性别：<input name="sex"><br>
    邮箱：<input name="email"><br>
    <input type="submit" value="提交">
  </form>
</body>
</html>
