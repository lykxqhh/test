<%--
  Created by IntelliJ IDEA.
  User: 李亚飞
  Date: 2019/5/4
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";%>
<html>
<head>
    <title>添加超级英雄</title>
</head>
<body>
<center>
<form>
<table>
    <tr><td>英雄ID:</td><td><input type="text" name="id"></td></tr>
    <tr><td>英雄绰号:</td><td><input type="text" name="name"></td></tr>
    <tr><td>英雄财富:</td><td><input type="text" name="money"></td></tr>
    <tr><td colspan="2" align="center"><input type="button" value="添加" onclick="add()" ></td></tr>
</table>
</form>
<script>
    function add() {
        var form=document.forms[0];
        form.action="<%= basePath%>app/addHero";
        form.submit();
    }
</script>
</center>
</body>
</html>
