<%--
  Created by IntelliJ IDEA.
  User: 李亚飞
  Date: 2019/5/3
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--使用标签库--%>
<% String appPath = request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+appPath+"/"; %>
<html>
<style type="text/css">
    h2{
       color: blue;
    }
</style>
<head>
    <title>超级英雄信息</title>
</head>
<body><center>
    <h2>复仇者联盟财富表</h2>
    <form>
<table border="2">
    <tr>
        <th>英雄ID</th>
        <th>英雄绰号</th>
        <th>英雄财富</th>
        <th>操作</th>
    </tr>


    <c:forEach var="hero" items="${requestScope.get('list')}" varStatus="status">
        <tr>
            <td>${hero.id}</td>
            <td>${hero.name}</td>
            <td>${hero.money}</td>

            <td>
                <a href="${path}/app/toUpdate?id=${hero.id}">更改</a> |<%--保存传送了修改操作需要的ID--%>
                <a href="${path}/app/delete?id=${hero.id}">删除</a>
            </td>
        </tr>
    </c:forEach><%--循环输出所有英雄--%>
    <tr><td colspan="4" align="center"><input type="button" value="添加超级英雄" onclick="add()"/></td></tr>
</table>
    </form>
</center>
<script>
    function add() {
        var form=document.forms[0];
        form.action="<%= basePath%>app/toAddHero"
        form.submit();
    }
</script>
</body>
