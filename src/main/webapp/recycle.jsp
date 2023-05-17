<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>名片管理系统</title>
    <link rel="stylesheet" href="./css/recycle.css">
</head>
<body>
<div class="text"></div>

<h1 align="center">回收站</h1>

<div class="table1">
    <table cellspacing="0" width="800">
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>电子邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${recycles}" var="recycle">
            <tr align="center">
                <td>${recycle.id}</td>
                <td>${recycle.name}</td>
                <td>${recycle.age}</td>
                <td>${recycle.sex}</td>
                <td>${recycle.email}</td>
                <td><a href="/recycleToCard?id=${recycle.id}">还原</a> <a href="/deleteRecycle?id=${recycle.id}">彻底删除</a></td>
            </tr>
        </c:forEach>
    </table>
    </div>

</body>
</html>
