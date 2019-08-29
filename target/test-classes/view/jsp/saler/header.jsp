<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/20
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<div class="logo">--%>
<%--    <a href=""><img src="images/logo.png" width="250" height="53" /></a>--%>
<%--</div>--%>
<p>
    <a href="">退出管理</a> <a href="./saler/toIndex">后台首页</a> <a href="./index" target='_blank'>商城首页</a>
    <span>您好&nbsp;<label class='bold'>${sessionScope.user.name}</label>，当前身份&nbsp;<label
            class='bold'>
			<c:if test="${sessionScope.user.groupid eq 1}"></c:if>
		卖家</label></span>
</p>
