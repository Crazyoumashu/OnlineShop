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
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <script type="text/javascript" src="js/jquery-2.0.3.js"></script>
    <script type="text/javascript">
        function goPage(p) {
            $("#page").val(p);
            $("#form1").submit();
        }

        function deleteOrder(oid) {
            if(confirm("您确认要取消该订单吗？")){
                location.href="./user/deleteOrder?oid="+oid;
            }
        }
        function payForOrder(oid) {
            if(confirm("您确认要支付该订单吗？")){
                location.href="./user/payForOrder?oid="+oid;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div id="header">
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="searchOrder.jsp"></jsp:include>
    </div>

    <div class="wrapper clearfix">
        <div class="summary2">
        <div class="headbar">
            <div class="field">
                <table class="list_table">
<%--                    <col width="80px" />--%>
                    <col width="240px" />
                    <col width="240px" />
                    <col width="140px" />
                    <col width="800px"/>
                    <col width="200px" />
                    <thead>
                    <tr>
<%--                        <th>选择</th>--%>
                        <th>订单编号</th>
                        <th>商户编号</th>
                        <th>订单状态</th>
                        <th>订单成交时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <form action="" method="post" name="orderForm">
            <div class="content">
                <table class="list_table">
<%--                    <col width="80px" />--%>
                    <col width="240px" />
                    <col width="240px" />
                    <col width="140px" />
                    <col width="800px" />
                    <col width="200px" />
                    <tbody>
                    <c:forEach items="${orders}" var="order" varStatus="s">
                        <c:if test="${order.state!=4}">
                        <tr>
<%--                            <td><input name="id[]" type="checkbox" value="1" /></td>--%>
                            <td><a href="" target="_blank" title="${order.oid}">${order.oid}</a></td>
                            <td>${order.sid}</td>
                            <td>${status[order.state]}</td>
                            <td>${date[s.index]}</td>
                            <td><a href="javascript:void(0)" onclick="payForOrder('${order.oid}')">
                                <img class="operator" src="images/admin/icon_yes.gif" alt="支付" /></a>

                                <a href="javascript:void(0)" onclick="deleteOrder('${order.oid}')">
                                    <img class="operator" src="images/admin/icon_del.gif" alt="取消" /></a>

                            </td>

                        </tr>
                        </c:if>
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
