<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("path", request.getContextPath());%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${path}/app/login" method="get">
    <table align="center" border="1">
        <tr><td>用户名：</td><td><input type="text" name="username"></td></tr>
        <tr><td>密码：</td><td><input type="password" name="password"></td></tr>
        <tr><td colspan="2"  align="center"><input type="submit" value="登陆"></td></tr>
    </table>
</form>
</body>
</html>
