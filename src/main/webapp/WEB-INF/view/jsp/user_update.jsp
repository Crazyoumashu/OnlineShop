<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/23
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/20
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <base href="${base}/" />
    <title>后台管理</title>
    <meta charset="utf-8" />
    <!--link rel="stylesheet" href="css/admin.css" /-->
    <jsp:include page="base.jsp" />
    <script>
        function a() {
            $("#groupid").val($("#select option:selected").text());
        }
    </script>
</head>
<body>
<div class="container">
    <div id="header">
        <jsp:include page="header.jsp"></jsp:include>
    </div>
    <div id="admin_right">
    <div class="content_box">
            <div class="content form_content">
                <form action="./user/updateUser" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="uid" value="${users.uid}">
                    <input type="hidden" name="username" value="${users.username}">
                    <input type="hidden" name="status" value="${users.status}">
                    <input type="hidden" name="groupid" value="${users.groupid}">
                    <input type="hidden" name="is_paying" value="${users.is_paying}">
                    <input type="hidden" name="discount" value="${users.discount}">
                    <table class="form_table" cellpadding="0" cellspacing="0">
                        <col width="150px" />
                        <col />
                        <tr>
                            <th>用户名：</th>
                            <td>${users.username}</td>
                        </tr>
                        <tr>
                            <th>用户姓名：</th>
                            <td><input type="text" name="name" value="${users.name}"></td>
                        </tr>
                        <tr>
                            <th>邮箱：</th>
                            <td><input type="text" name="email" value="${users.email}"></td>
                        </tr>
                        <tr>
                            <th>性别：</th>
                            <td><input type="text" name="sex" value="${users.sex}"></td>
                        </tr>
                        <tr>
                            <th>电话：</th>
                            <td><input type="text" name="phone_num" value="${users.phone_num}"></td>
                        </tr>
<%--                        <tr>--%>
<%--                            <th>用户折扣：</th>--%>
<%--                            <td><input type="text" name="discount" value="${users.discount}"></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <th>用户状态：</th>--%>
<%--                            <td><input id="status" maxlength="1" size="3"--%>
<%--                                       name="status" type="text" value="${users.status}"></td>--%>
<%--                            <td><label id="statusMsg">"0":下线 "1":在线 "2":已删除</label></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <th>用户身份：</th>--%>
<%--                            <td><select id="select" onchange="a()">--%>
<%--                                <option value="0">0</option>--%>
<%--                                <option value="1">1</option>--%>
<%--                                <option value="2">2</option>--%>
<%--                            </select>--%>
<%--                                <input id="groupid" maxlength="1" size="3"--%>
<%--                                       name="groupid" type="hidden" value="${users.groupid}">--%>
<%--                                <!--label id="roleMsg">"0":会员 "1":卖家 "2":管理员</label--></td>--%>
<%--                            <td><label id="roleMsg">"0":会员 "1":卖家 "2":管理员</label></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <th>用户支付状态：</th>--%>
<%--                            <td><input id="is_paying" maxlength="1" size="3"--%>
<%--                                       name="is_paying" type="text" value="${users.is_paying}"></td>--%>
<%--                            <td><label id="payingMsg">"0":未在支付状态 "1":正在支付</label></td>--%>
<%--                        </tr>--%>
                        <tr>
                            <th>密码：</th>
                            <td><input name="password" type="text" value=""><label
                                    id="passwordMsg"></label></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button class="submit" type="submit">
                                <span>确定修改</span>
                            </button></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <div id="separator"></div>
</div>

</body>
</html>
