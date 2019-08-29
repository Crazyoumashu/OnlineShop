<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/20
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
    <base href="${base}/" />
    <title>商品管理</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/admin.css" />
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

        <div class="userinfo_bar">
            <b class="f12">您好，欢迎回来!</b>
        </div>

        <div class="content_box" style="border:none; float: left;">
            <h1>欢迎你！</h1>
        </div>

    </div>
    <div id="separator"></div>
</div>
</body>
</html>

