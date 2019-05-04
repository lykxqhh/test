<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
</head>
<body><center>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
<br><br>
<h3>
    <a href="${path }/app/user">点击进入登录页面</a>
</h3></center>
</body>
</html>
