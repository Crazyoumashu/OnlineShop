<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/29
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/23
  Time: 16:56
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

</head>
<body>
<div class="container">
    <div id="header">
        <jsp:include page="header.jsp"></jsp:include>
    </div>
    <div id="admin_right">
        <div class="content_box">
            <div class="content form_content">
                <form action="./user/userRegister" method="post" enctype="multipart/form-data">
                    <table class="form_table" cellpadding="0" cellspacing="0">
                        <col width="150px" />
                        <tr>
                            <th>用户用户名：</th>
                            <td><input type="text" name="username" value=""></td>
                        </tr>
                        <col />
                        <tr>
                            <th>用户姓名：</th>
                            <td><input type="text" name="name" value=""></td>
                        </tr>
                        <tr>
                            <th>邮箱：</th>
                            <td><input type="text" name="email" value=""></td>
                        </tr>
                        <tr>
                            <th>性别：</th>
                            <td><input type="text" name="sex" value=""></td>
                        </tr>
                        <tr>
                            <th>电话：</th>
                            <td><input type="text" name="phone_num" value=""></td>
                        </tr>
                        <tr>
                            <th>用户身份：</th>
                            <td><input id="groupid" maxlength="1" size="3"
                                       name="groupid" type="text" value="">
                                <!--label id="roleMsg">"0":会员 "1":卖家 "2":管理员</label--></td>
                            <td><label id="roleMsg">"0":会员 "1":卖家 </label></td>
                        </tr>
                        <tr>
                            <th>密码：</th>
                            <td><input id="password" maxlength="32" size="20"
                                       name="password" type="text" value=""><label
                                    id="passwordMsg"></label></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button class="submit" type="submit">
                                <span>确定注册</span>
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

