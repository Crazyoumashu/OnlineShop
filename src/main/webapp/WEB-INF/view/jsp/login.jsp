<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/19
  Time: 13:44
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
    <script type="text/javascript" src="js/jquery-2.0.3.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script>
        function a() {
            $("#groupid").val($("#select option:selected").text());
        }
    </script>
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
                <form action='./user/login' method="post">
                    <table width="515" class="form_table f_l">
                        <col width="120px" />
                        <col />
                        <tr>
                            <th>用户名：</th>
                            <%--<td><input class="gray" type="text" name="user.name"--%>
                            <td><input class="gray" type="text" name="name"
                                       id="login_info" placeholder="请输入用户名" /><span id="namemsg"></span></td>
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
                            <th>用户身份：</th>
                            <td><select id="select" style="height: 18px; width: 48px" onclick="a()">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>
                                <input id="groupid" maxlength="1" size="3" name="groupid" type="hidden" value="0">
                                <label id="roleMsg">"0":一般会员 "1":卖家 "2":管理员</label></td>
                        </tr>
                        <tr>
                            <th>验证码：</th>
                            <td><input class="gray" type="code" id="code"
                            <%--name="user.password" placeholder="请输入6-20位长度的密码" /><span--%>
                                       name="code" placeholder="请输入验证码" /><span
                                    id="codemsg"></span></td>
                            <td><img src="${codeSource}"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>${codemsg}</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="submit_login" type="submit" value="登录" /></td>
                        </tr>
                    </table>
                </form>

                <!--正常登录时
                <table width="360px" class="form_table prompt_3 f_l">
                    <col width="75px" />
                    <col />
                    <tr>
                        <th></th>
                        <td>
                            <p class="mt_10">
                                <strong class="f14">您还不是<span class="orange">${site}</span>用户
                                </strong>
                            </p>
                            <p>
                                现在免费注册成为${site}用户，便能立即享受便宜又放心的购物乐趣。<a class="blue" href="">网站首页>></a>
                            </p>
                            <p class="mt_10">
                                <a class="reg_btn" href="./user/register">注册新用户</a>
                            </p>
                        </td>
                    </tr>
                </table>
                -->
            </div>
        </div>
    </div>
</div>
</body>
</html>