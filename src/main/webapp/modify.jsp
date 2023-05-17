<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>名片管理系统</title>
</head>
<body>
<h1>修改名片</h1>
<form action="/modify2" method="post">
  <input type="hidden" name="id" value="${card.id}">
  姓名：<input name="name" value="${card.name}"><br>
  年龄：<input name="age" value="${card.age}"><br>
  性别：<input name="sex" value="${card.sex}"><br>
  邮箱：<input name="email" value="${card.email}"><br>
  <input type="submit" value="提交">
</form>
</body>
</html>
