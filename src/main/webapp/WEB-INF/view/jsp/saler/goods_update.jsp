<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/20
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html >
<html>
<head>
    <base href="${base}/" />
    <title>后台管理</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/admin.css" />
    <script type="text/javascript" src="js/jquery-2.0.3.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#category").val("${goods.type}");
        });
    </script>
</head>
<body>
<div class="container">
    <div id="header">
        <jsp:include page="header.jsp"></jsp:include>
    </div>
    <div id="admin_left">
        <ul class="submenu">
            <jsp:include page="left.jsp"></jsp:include>
        </ul>
        <div id="copyright"></div>
    </div>

    <div id="admin_right">
        <div class="content_box">
            <div class="content form_content">
                <%--<form action="./goods/updateoper" method="post" enctype="multipart/form-data">--%>
                <form action="./saler/updateGoods" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="gid" value="${goods.gid}">
                    <div id="table_box_1">
                        <table class="form_table">
                            <colgroup>
                                <col width="150px">
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <th>商品名称：</th>
                                <td><input class="normal" name="name" type="text"
                                           value="${goods.name}"><label>*</label></td>
                            </tr>

                            <tr>
                                <th>基本数据：</th>
                                <td>
                                    <div class="con">
                                        <table class="border_table">
                                            <thead id="goodsBaseHead">
                                            <tr>
                                                <th>库存</th>
                                                <th>价格</th>
                                            </tr>
                                            </thead>
                                            <tbody id="goodsBaseBody">
                                            <tr class="td_c">
                                                <td><input class="tiny" name="num"
                                                           type="text" value="${goods.num}" /></td>
                                                <td><input class="tiny" name="price"
                                                           type="text" value="${goods.price}" /></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>缩略图：</th>
                                <td><input type="hidden" name="thumbnail" value="${goods.thumbnail}">
                                    <img src="goodsimage/${goods.thumbnail}" width="100" height="100">
                                    <input type="file" name="pic"
                                           accept="image/jpeg,image/jpg,image/png"/></td>
                            </tr>
                            <tr>
                                <th>产品描述：</th>
                                <td><textarea rows="5" cols="5" name="described">${goods.described}</textarea></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <table class="form_table">
                        <colgroup>
                            <col width="150px">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td></td>
                            <td><button class="submit" type="submit">
                                <span>发布商品</span>
                            </button></td>
                        </tr>
                        </tbody>
                    </table>
                </form>

            </div>
        </div>
    </div>
    <div id="separator"></div>
</div>
</body>
</html>
