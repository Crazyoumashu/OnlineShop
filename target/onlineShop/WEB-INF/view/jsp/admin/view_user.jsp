<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/19
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
    <base href="${base}/" />
    <title>后台管理</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/admin.css" />
    <script type="text/javascript">
        function delMember(id) {
            //alert(id);
            if (confirm("您确认要删除该用户吗？")) {
                location.href = "./admin/deleteUser?uid=" + id;
            }
        }
        function user_add() {
            location.href = "./admin/jumpAddUser";
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
                    <colgroup>
                        <col width="30px">
                        <col width="75px">
                        <col width="75px">
                        <col width="80px">
                        <col width="135px">
                        <col width="75px">
                        <col width="75px">
                        <col width="100px">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>用户名</th>
                        <th>Tel</th>
                        <th>性别</th>
                        <th>邮箱</th>
                        <th>角色</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>

        <form method="post" name="./member_list">
            <div class="content">
                <table id="list_table" class="list_table">
                    <colgroup>
                        <col width="30px">
                        <col width="75px">
                        <col width="75px">
                        <col width="80px">
                        <col width="135px">
                        <col width="75px">
                        <col width="75px">
                        <col width="100px">
                    </colgroup>
                    <tbody>
                    <c:forEach items="${users}" var="user" varStatus="s">
                        <tr>
                            <td>${s.index }</td>
                            <td title="${user.username }">${user.username }</td>
                            <td title="${user.phone_num }">${user.phone_num }</td>
                            <td title="${user.sex }">${user.sex }</td>
                            <td title="${user.email }">${user.email }</td>
                            <td title="${user.groupid }">
                                <c:if test="${user.groupid eq 2}">
                                    <span>管理员</span></c:if>
                                <c:if test="${user.groupid eq 1}">
                                    <span>卖家</span></c:if>
                                <c:if test="${user.groupid eq 0}">
                                    <span>会员</span></c:if></td>
                            <td title="${user.status }">
                                <c:if test="${user.status eq 0}">
                                    <span style="color:grey">下线</span>
                                </c:if> <c:if test="${user.status eq 1}">
                                <span style="color:blue">在线</span>
                            </c:if> <c:if test="${user.status eq 2}">
                                <span style="color:red">已删除</span>
                            </c:if></td>
                            <td><!-- 修改操作 -->
                                <a href="./admin/jumpUserUpdate?uid=${user.uid}" target="_blank"><img class="operator"
                                                                                                        src="images/admin/icon_edit.gif" alt="修改" /></a>
                                <!-- 删除操作-->
                                <a href="javascript:delMember('${user.uid }')"><img
                                        class="operator" src="images/admin/icon_del.gif" alt="删除" /></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input class="submit" type="button" id="buyNowButton"
                       value="添加用户" onclick="user_add()" />
            </div>
        </form>

    </div>
    <div id="separator"></div>
</div>

<div
        style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255);"></div>
</body>
</html>