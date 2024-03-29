<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/19
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
<%--    <div class="logo">--%>
<%--        <a href=""><img src="images/logo.png" width="250" height="53" /></a>--%>
<%--    </div>--%>
    <ul class="shortcut">
        <li class="first"><a href="./user/toUpdate">修改个人信息</a></li>
        <%--<li class="first"><a href="order_uindex">我的账户</a></li>--%>
        <li><a href="./order/listByUser">我的订单</a></li>
        <li><a href="./shopcarts/listCarts">购物车</a></li>
        <%--<li><a href="order_listByUser">我的订单</a></li>--%>

        <!--
        <%--<c:if test="${sessionScope.user.role eq 'a'}">--%>
            <li><a href="./user/toAdminLogin">后台管理</a></li>
            <%--<li><a href="admin">后台管理</a></li>--%>
        <%--</c:if>--%>
        -->
        <li class='last'><a href="">商城主页</a></li>
    </ul>
    <p class="loginfo">
        <!-- 判断当前用户登录状态-显示不同选项-->
        <c:if test="${not empty sessionScope.user}">
            <%--${user.name}您好，欢迎您来到${site}购物！[<a href="user_logout" class="reg">安全退出</a>]--%>
            ${user.name}您好，欢迎来到${site}！[<a href="./user/logout" class="reg">安全退出</a>]
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <%--[<a href="login.jsp">登录</a> --%>
            <%--<a class="reg" href="register.jsp">免费注册</a>]--%>
            [<a href="./user/toLogin">登录</a>
            [<a href="./user/toRegister">注册</a>
            <%--<a class="reg" href="./user/toRegister">免费注册</a>--%>]
            <!--unreachable-->
            <%--<a href="WEB-INF/views/jsp/login.jsp">登录</a>--%>
            <%--<a href="WEB-INF/views/jsp/register.jsp">免费注册</a>]--%>
            <!--报错500-->
            <%--<jsp:forward page="/WEB-INF/views/jsp/login.jsp">登录</jsp:forward>--%>
            <%--<jsp:forward page="/WEB-INF/views/jsp/register.jsp">免费注册</jsp:forward>--%>
        </c:if>
    </p>
</div>
