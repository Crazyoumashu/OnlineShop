<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/23
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/23
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="css/admin.css" />
    <script type="text/javascript">
        function goPage(p) {
            $("#page").val(p);
            $("#form1").submit();
        }

        function rejectOrder(oid) {
            if(confirm("您确认要拒绝该订单吗？")){
                location.href="./saler/rejectOrder?oid="+oid;
            }
        }
        function acceptOrder(oid) {
            if(confirm("您确认要接受该订单吗？")){
                location.href="./saler/acceptOrder?oid="+oid;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div id="header">
        <jsp:include page="header.jsp"></jsp:include>
    </div>

    <div class="wrapper clearfix">
        <div class="summary">
            <div class="headbar">
                <div class="field">
                    <table class="list_table">
<%--                        <col width="40px" />--%>
                        <col width="120px" />
                        <col width="120px" />
                        <col width="120px" />
                        <col width="200px" />
                        <col width="100px" />
                        <thead>
                        <tr>
<%--                            <th>选择</th>--%>
                            <th>订单编号</th>
                            <th>用户编号</th>
                            <th>订单状态</th>
                            <th>订单提交时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <form action="" method="post" name="orderForm">
                <div class="content">
                    <table class="list_table">
<%--                        <col width="40px" />--%>
                        <col width="120px" />
                        <col width="120px" />
                        <col width="120px" />
                        <col width="200px" />
                        <col width="100px" />
                        <tbody>
                        <c:forEach items="${orders}" var="order" varStatus="s">
                            <tr>
<%--                                <td><input name="id[]" type="checkbox" value="1" /></td>--%>
                                <td><a href="" target="_blank" title="${order.oid}">${order.oid}</a></td>
                                <td>${order.uid}</td>
                                <td>${status[order.state]}</td>
                                <td>${date[s.index]}</td>

                                <td><a href="javascript:void(0)" onclick="acceptOrder('${order.oid}')">
                                    <img class="operator" src="images/admin/icon_yes.gif" alt="接受" /></a>

                                    <a href="javascript:void(0)" onclick="rejectOrder('${order.oid}')">
                                        <img class="operator" src="images/admin/icon_del.gif" alt="拒绝" /></a>

                                </td>


                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>


</body>
</html>

