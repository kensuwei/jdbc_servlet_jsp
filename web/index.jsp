<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>显示</title>
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
    <script type="text/javascript">
        function onSeach1() {
            var goodsInfoName = document.getElementById("goodsInfoName").value;
            location.href = 'selectGoodsServlet?goodsInfoName='+goodsInfoName;
        }
    </script>
</head>
<body>

<p>
    商品名称<input type="text" name="goodsInfoName" id="goodsInfoName" placeholder="请输入商品名称" value="${param.goodsInfoName}"/>
    <%--<a href="selectGoodsServlet?g=${param.goodsInfoName}">查询</a>--%>
    <a href="javascript:onSeach1();">查询</a>

</p>
<table>
    <tr>
        <th align="center" colspan="10">商&nbsp;&nbsp;品&nbsp;&nbsp;列&nbsp;&nbsp;表</th>
    </tr>
    <tr>
        <td><a>编号</a></td>
        <td><a>商品名字</a></td>
        <td><a>商品图片</a></td>
        <td><a>商品价格</a></td>
        <td><a>商品简介</a></td>
        <td><a>商品库存</a></td>
        <td><a>商品状态</a></td>
        <td><a>创建人</a></td>
        <td><a>创建时间</a></td>
        <td><a>操作</a></td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id }</td>
            <td>${item.goodsInfoName }</td>
            <td><img src="upload/${item.goodsInfoPic}" width="100px" height="100px"/></td>
            <td>${item.goodsInfoPrice }</td>
            <td>${item.goodsInfoDescription }</td>
            <td>${item.goodsStock }</td>
            <td>${item.flag }</td>
            <td>${item.created }</td>
            <td>${item.createdDate }</td>
            <td><a href="deleteServlet?id=${item.id }">删除</a>|<a href="updateServlet?id=${item.id }">更改</a>|<a
                    href="selectServlet?id=${item.id }">详情</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" style="text-align: left;"><a href="add.jsp">添加商品</a></td>
    </tr>
</table>
</body>
</html>
