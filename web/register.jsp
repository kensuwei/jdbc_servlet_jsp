<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
</head>

<body>

<form action="registerServlet" method="post">
    <table border="1" class="t1" >
        <tr>
            <td colspan="2"><h1>请输入用户信息</h1></td>
        </tr>
        <%--<tr>
            <td>编号:</td>
            <td><input type="text" name="id" value="${user.id}" readonly="readonly"/></td>
        </tr>--%>
        <input type="hidden" name="id" value="${user.id}"/>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" placeholder="请输入用户名" value="${user.username}"/></td>
        </tr>
        <tr>
            <td>用户密码:</td>
            <td><input type="password" name="password" placeholder="请输入用户密码" value="${user.password}"/></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="password" name="password123" placeholder="确认密码需与用户密码一致" value="${user.password123}"/></td>
        </tr>
        <tr>
            <td><label>性别</label></td>
            <td><input type="radio" name="sex" value="男" checked> 男
                <input type="radio" name="sex" value="女"> 女
            </td>
        </tr>
        <tr>
            <td>爱好:</td>
            <td><input type="text" name="hobbys" placeholder="请输入您感兴趣的活动" value="${user.hobbys}"/></td>
        </tr>
        <tr>
            <td>手机号:</td>
            <td><input type="text" name="phone" placeholder="请输入手机号码" value="${user.phone }"/></td>
        </tr>
        <tr>
            <td>电子邮箱:</td>
            <td><input type="email" name="email" placeholder="请输入电子邮箱" value="${user.email }"/></td>
        </tr>
        <tr>
            <td>地址:</td>
            <td><input type="text" name="addrs" placeholder="请输入常住地址" value="${user.addrs }"/></td>
        </tr>
        <tr>
            <td><label>状态</label></td>
            <td><input type="radio" name="flag" value="激活" checked>激活
                <input type="radio" name="flag" value="禁用">禁用
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
                <input type="button" value="返回" onclick="history.go(-1)"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
