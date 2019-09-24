<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
</head>

<body>
<form action="loginServlet" method="post">
    <table border="1" class="t1">
        <tr>
            <td colspan="2"><h1>用户登录</h1></td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" value="${user.username}"/></td>
        </tr>
        <tr>
            <td>用户密码:</td>
            <td><input type="password" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录"/>
                <a href="register.jsp">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
