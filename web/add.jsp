<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加</title>
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <script src="js/upload.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<form action="insertServlet" method="post">
    <table border="1" class="t1">
        <tr>
            <td colspan="2"><h1>添加商品</h1></td>
        </tr>
        <tr>
            <td>商品名称:</td>
            <td><input type="text" name="goodsInfoName"/></td>
        </tr>
        <%--<tr>
            <td>商品图片:</td>
            <td><input type="file" name="goodsInfoPic"/></td>
        </tr>--%>
        <tr>
            <td>商品图片</td>
            <td>
                <img src="upload/上传图标.jpg" id="goodsInfoPicImg" alt="无法显示" width="50px" height="50px">
                <input type="hidden" name="goodsInfoPic" id="goodsInfoPic">
                <input type="button" value="上传图片" onclick="window.open('upload.jsp')">
            </td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td><input type="text" name="goodsInfoPrice"/></td>
        </tr>
        <tr>
            <td>商品简介:</td>
            <td><input type="text" name="goodsInfoDescription"/></td>
        </tr>
        <tr>
            <td>商品库存:</td>
            <td><input type="text" name="goodsStock"/></td>
        </tr>
        <tr>
            <td><label>商品状态</label></td>
            <td><input type="radio" name="flag" value="激活" checked>激活
                <input type="radio" name="flag" value="禁用">禁用
            </td>
        </tr>
        <%--<tr>
            <td>创建人:</td>
            <td><input type="text" name="created"/></td>
        </tr>--%>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>