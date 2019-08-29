<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/8/2
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <base href="${base}/" />
    <meta charset="utf-8" />
    <title>用户登录_${site}</title>
    <link rel="stylesheet" type="text/css" href="css/index.css" />
</head>

<body class="second">
<div class="brand_list container_2">
    <jsp:include page="header.jsp"></jsp:include>

    <div class="wrapper clearfix">
        <div class="wrap_box">
            <h3 class="notice">已注册用户，请登录</h3>
            <p class="tips">欢迎来到我们的网站，如果您已是本站会员请登录</p>
            <div class="box login_box clearfix">
                <%--<form action='user_login' method="post">--%>
                <form action='./user/login2' method="post">
                    <input type="hidden" name="name" value="${user.username}">
                    <table width="515" class="form_table f_l">
                        <col width="120px" />
                        <col />
                        <tr>
                            <th>用户名：</th>
                            <%--<td><input class="gray" type="text" name="user.name"--%>
                            <td>${user.username}<span id="namemsg"></span></td>
                        </tr>
                        <tr>
                            <th>密码：</th>
                            <td><input class="gray" type="password" id="password"
                            <%--name="user.password" placeholder="请输入6-20位长度的密码" /><span--%>
                                       name="password" placeholder="请输入密码" /><span
                                    id="pwdmsg"></span></td>
                            <td>${msg}</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="submit_login" type="submit" value="登录" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
