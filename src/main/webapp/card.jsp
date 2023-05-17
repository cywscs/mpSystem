<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>名片管理系统</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/card.css">
</head>
<body>

<div class="text"></div>

<div class="zhuangtai">
    <div>当前登录用户：${user.username}</div>
    <div><a href="/logout">退出登录</a> </div>
</div>


    <div class="table1">
        <table align="center" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>电子邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${cards}" var="card">
                <tr align="center">
                    <td>${card.id}</td>
                    <td>${card.name}</td>
                    <td>${card.age}</td>
                    <td>${card.sex}</td>
                    <td>${card.email}</td>
                    <td class="cz"><a style="color: #000000" href="/modify1?id=${card.id}">修改</a>
                        <a style="color: #000000" href="/cardToRecycle?id=${card.id}">移入回收站</a>
                        <a style="color: #000000" href="/deleteCard?id=${card.id}">彻底删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

<form action="<c:url value="/uploadExcel"/>" method="post" enctype="multipart/form-data">
    <input type="file" class="file1" name="file"/><br/>

<div class="nav">
    <ul class="menu">
        <li class="item">
            <a href="/card" class="link">
                <i class="fa fa-home" aria-hidden="true"></i>
                <span>首页</span>
            </a>
        </li>
        <li class="item">
            <a href="/recycle" class="link">
                <i class="fa fa-heart" aria-hidden="true"></i>
                <span>回收站</span>
            </a>
        </li>
        <li class="item">
            <a href="add.jsp" class="link">
                <i class="fa fa-plus-circle" aria-hidden="true"></i>
                <span>新建名片</span>
            </a>
        </li>
        <li class="item">
            <a href="#" class="link">
                <i class="fa fa-bell" aria-hidden="true"></i>
                <span><input type="submit" value="上传Excel"/></span>

            </a>
        </li>
        <li class="item">
            <a href="<c:url value="/downloadExcel"/>" class="link">
                <i class="fa fa-user" aria-hidden="true"></i>
                <span>导出Excel</span>
            </a>
        </li>
    </ul>
</div>

</form>

        <div class="wrapper_search">
            <form action="/selectName" id="from">
            <div class="input-data">
                <input type="text" name="name" required>
                <div class="underline"></div>
                <label>您的姓名</label>
            </div>
            <div id="subSearchDiv">
                <input type="submit" class="button" value="查询">
            </div>
            </form>
        </div>

        <br><br><br>

        <div class="upload">


        </div>

</body>
</html>
