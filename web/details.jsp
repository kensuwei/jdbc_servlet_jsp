<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>商品详情</title>
    <style type="text/css">
        table {
            border: 1px solid pink;
            margin: 0 auto;
        }

        td {
            width: 150px;
            border: 1px solid pink;
            text-align: center;
        }
    </style>
</head>
<body>${goods}
<table>
    <tr>
        <td>编号</td>
        <td>商品名字</td>
        <td>商品图片</td>
        <td>商品价格</td>
        <td>商品简介</td>
        <td>商品库存</td>
        <td>商品状态</td>
        <td>创建人</td>
        <td>创建时间</td>
    </tr>
    <c:forEach items="${goods}" var="go">
        <tr>
            <td>${go.id }</td>
            <td>${go.goodsInfoName }</td>
            <td>${go.goodsInfoPic }</td>
            <td>${go.goodsInfoPrice }</td>
            <td>${go.goodsInfoDescription }</td>
            <td>${go.goodsStock }</td>
            <td>${go.flag }</td>
            <td>${go.created }</td>
            <td>${go.createdDate }</td>
            <td><a href="index.jsp">返回</a></td>
        </tr>
    </c:forEach>
</table>
</body>--%>




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生详情</title>
</head>
<body>
<table border="1">
    <tr>
        <td>编号</td>
        <td>${goods.id}</td>
    </tr>
    <tr>
        <td>商品名字</td>
        <td>${goods.goodsInfoName}</td>
    </tr>
    <tr>
        <td>商品图片</td>
        <td><img src="upload/${goods.goodsInfoPic}" width="100px" height="100px" /></td>
    </tr>
    <tr>
        <td>商品价格</td>
        <td>${goods.goodsInfoPrice}</td>
    </tr>
    <tr>
        <td>商品简介</td>
        <td>${goods.goodsInfoDescription}</td>
    </tr>
    <tr>
        <td>商品库存</td>
        <td>${goods.goodsStock}</td>
    </tr>
    <tr>
        <td>商品状态</td>
        <td>${goods.flag}</td>
    </tr>
    <tr>
        <td>创建人</td>
        <td>${goods.created}</td>
    </tr>
    <tr>
        <td>创建时间</td>
        <td>${goods.createdDate}</td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="返回" onclick="history.back()">
        </td>
    </tr>
</table>
</body>
</html>
