<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/20
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html >
<html>
<head>
    <base href="${base}/" />
    <title>商品管理</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/admin.css" />
    <script type="text/javascript" src="js/jquery-2.0.3.js"></script>
    <script type="text/javascript">
        function goPage(p) {
            $("#page").val(p);
            $("#form1").submit();
        }
        $(function() {
            $("#category").val("${goods.categoryId}");
            $("#name").val("${goods.name}");
        });

        function delGoods(id) {
            if(confirm("您确认要删除该商品吗？")){
                location.href="./goods/delete?goodsId="+id;
            }
        }
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
        <div class="headbar">
            <div class="field">
                <table class="list_table">
<%--                    <col width="40px" />--%>
                    <col width="250px" />
                    <col width="120px" />
                    <col width="70px" />
                    <col width="70px" />
                    <col width="70px" />
                    <thead>
                    <tr>
<%--                        <th>选择</th>--%>
                        <th>商品名称</th>
                        <th>分类</th>
                        <th>销售价</th>
                        <th>库存</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <form action="" method="post" name="orderForm">
            <div class="content">
                <table class="list_table">
<%--                    <col width="40px" />--%>
                    <col width="250px" />
                    <col width="120px" />
                    <col width="70px" />
                    <col width="70px" />
                    <col width="70px" />
                    <tbody>
                    <c:forEach items="${goods_list}" var="goods">
                        <tr>
<%--                            <td><input name="id[]" type="checkbox" value="1" /></td>--%>
                            <td><a href="" target="_blank" title="${goods.name}">${goods.name}</a></td>
                            <td>${goods.type}</td>
                            <td>${goods.price}</td>
                            <td>${goods.num}</td>
                            <td><a href="./saler/jumpUpdateGoods?goodsId=${goods.gid}">
                                <img class="operator" src="images/admin/icon_edit.gif" alt="编辑" /></a>
                                <!--
                                <a href="javascript:void(0)" onclick="delGoods('')">
                                    <img class="operator" src="images/admin/icon_del.gif" alt="删除" /></a>
                                -->
                             </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
        <!--
        <div class='pages_bar'>
            <a href='javascript:goPage(1)' id="first">首页</a>
            <c:forEach begin="1" end="${pageBean.totalPage}" var="p">
                <a href="javascript:goPage('${p}')">${p}</a>
            </c:forEach>
            <select onchange="goPage(this.value)">
                <c:forEach begin="1" end="${pageBean.totalPage}" var="p">
                    <option id="indeP" value="${p}">${p}</option>
                </c:forEach>
            </select> <a href='javascript:goPage(${pageBean.totalPage})' id="last">尾页</a>
            <span>当前第${pageBean.page}页/共${pageBean.totalPage}页</span>
        </div>
        -->
    </div>
    <div id="separator"></div>
</div>
</body>
</html>
