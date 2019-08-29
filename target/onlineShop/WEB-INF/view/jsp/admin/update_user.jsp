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
    <link rel="stylesheet" href="css/admin.css" />
    <script type="text/javascript" src="js/jquery-2.0.3.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script>
        function a() {
            $("#groupid").val($("#select option:selected").text());
        }
        function b() {
            $("#status").val($("#select1 option:selected").text());
        }
        function c() {
            $("#is_paying").val($("#select2 option:selected").text());
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
        <div class="content_box">
            <div class="content form_content">
                <form action="./admin/updateUser" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="uid" value="${users.uid}">
                    <input type="hidden" name="is_paying" value="${users.is_paying}">
                    <table class="form_table" cellpadding="0" cellspacing="0">
                        <col width="150px" />
                        <col />
                        <tr>
                            <th>用户名：</th>
                            <td><input type="text" name="username" value="${users.username}"></td>
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
                        <tr>
                            <th>用户折扣：</th>
                            <td><input type="text" name="discount" value="${users.discount}"></td>
                        </tr>
                        <tr>
                            <th>用户状态：</th>
                            <td><select id="select1" style="height: 18px; width: 48px" onclick="b()">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                </select>
                                <input id="status" maxlength="1" size="3"
                                       name="status" type="hidden" value="${users.status}">
                                <label id="statusMsg">"0":下线 "1":在线 "2":已删除</label></td>
                        </tr>
                        <tr>
                            <th>用户身份：</th>
                            <td><select id="select" style="height: 18px; width: 48px" onclick="a()">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                </select>
                                <input id="groupid" maxlength="1" size="3" name="groupid" type="hidden" value="${users.groupid}">
                                <label id="roleMsg">"0":一般会员 "1":卖家 "2":管理员</label></td>
                        </tr>
<%--                        <tr>--%>
<%--                            <th>用户支付状态：</th>--%>
<%--                            <td><select id="select2" style="height: 18px; width: 48px" onclick="c()">--%>
<%--                                <option value="0">0</option>--%>
<%--                                <option value="1">1</option>--%>
<%--                                </select>--%>
<%--                                <input id="is_paying" maxlength="1" size="3"--%>
<%--                                       name="is_paying" type="hidden" value="${users.is_paying}">--%>
<%--                                <label id="payingMsg">"0":未在支付状态 "1":正在支付</label></td>--%>
<%--                        </tr>--%>
                        <tr>
                            <th>密码：</th>
                            <td><input id="password" maxlength="32" size="20"
                                       name="password" type="text" value=""><label
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
