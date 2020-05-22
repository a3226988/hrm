<%--
  Created by IntelliJ IDEA.
  User: gc
  Date: 2020/5/22
  Time: 下午 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文档管理</title>
</head>
<body>
<form action="/document/upload" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>文件上传</legend>
        文件名：<input type="text" name="filename">
        选择文件：<input type="file" name="upfile"><button>上传</button>
    </fieldset>
</form>
<table border="1">
    <tr>
        <td>序号</td><td>文件名</td><td>文件大小</td><td>文件后缀</td><td>操作</td>

    <c:forEach items="${filelist}" var="file" varStatus="i">
    <tr>
        <td>${i.count}</td><td>${file.filename}</td><td>${file.size}</td><td>${file.suffix}</td><td><a href="/document/download/${file.id}">下载</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
