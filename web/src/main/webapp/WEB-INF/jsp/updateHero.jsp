<%--
  Created by IntelliJ IDEA.
  User: 李亚飞
  Date: 2019/5/4
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<body>

    <form action="" name="userForm">
        <input type="hidden" name="id" value="${hero.id}"/>
        英雄名称：<input type="text" name="name" value="${hero.name}"/>
        财富：<input type="text" name="money" value="${hero.money}"/>
        <input type="button" value="提交" onclick="update()"/>
    </form>
    <script type="text/javascript">
        function update() {
            var form = document.forms[0];
            form.action = "<%= basePath%>app/update";
            form.submit();
        }
    </script>
</body>
</html>

