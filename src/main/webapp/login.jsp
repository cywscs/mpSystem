<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>名片管理系统</title>
  <link rel="stylesheet" href="./css/login.css">
</head>

<body>
  <div class="box">
    <div class="left">
      <!-- 图片部分 -->
    </div>
    <div class="right">
      <!-- 登录主界面 -->
      <h4>名片管理系统</h4>
      <div id="errorMsg">${register_msg} ${error_msg} ${login_msg}</div>
      <form action="/login">
        <input type="text" placeholder="用户名" name="username" class="input">
        <input type="password" placeholder="密码" name="password" class="input">
        <input type="submit" value="Login" class="button">
      </form>
      <div class="more">
        <a href="register.jsp" >没有账号？</a>
      </div>
    </div>

  </div>
</body>

</html>