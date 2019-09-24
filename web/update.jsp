<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>更改</title>
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <script src="js/upload.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<form action="updateServlet" method="post">
    <table border="1" class="t1">
        <tr>
            <td colspan="2"><h1>更改商品信息</h1></td>
        </tr>
        <tr>
            <td>编号:</td>
            <td><input type="text" name="id" value="${goods.id}" readonly="readonly"/></td>
        </tr>

        <tr>
            <td>商品名称:</td>
            <td><input type="text" name="goodsInfoName" value="${goods.goodsInfoName}"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <img src="upload/${goods.goodsInfoPic}" id="goodsInfoPicImg" alt="无法显示" width="100px" height="100px"/>
                <input type="hidden" name="goodsInfoPic" id="goodsInfoPic" value="${goods.goodsInfoPic}">
                <input type="button" value="上传图片" onclick="window.open('upload.jsp')">
            </td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td><input type="text" name="goodsInfoPrice" value="${goods.goodsInfoPrice}"/></td>
        </tr>
        <tr>
            <td>商品简介:</td>
            <td><input type="text" name="goodsInfoDescription" value="${goods.goodsInfoDescription}"/></td>
        </tr>
        <tr>
            <td>商品库存:</td>
            <td><input type="text" name="goodsStock" value="${goods.goodsStock}"/></td>
        </tr>
        <tr>
            <td><label>商品状态</label></td>
            <td><input type="radio" name="flag" value="激活" checked>激活
                <input type="radio" name="flag" value="禁用">禁用
            </td>
        </tr>
        <%--<tr>
            <td>创建人:</td>
            <td><input type="text" name="created" value="${goods.created}"/></td>
        </tr>--%>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
                <%--<input type="button" value="返回" οnclick="history.go(-1)"/>--%>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
