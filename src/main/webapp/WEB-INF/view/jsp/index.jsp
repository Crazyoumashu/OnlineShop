<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/19
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
    String path = request.getContextPath();
    String basePath=null;
    basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    int port=request.getServerPort();

    if(port==80){
        basePath=request.getScheme()+"://"+request.getServerName()+path;

    }else{
        basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

    }
    request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <base href="${base}/" />
    <title>首页_${site}</title>
    <jsp:include page="base.jsp" />
    <script type="text/javascript">
        function goPage(p) {
            location.href = "./index?page="+p;
        }
    </script>
</head>

<body class="index">
<div class="container">
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="search.jsp"></jsp:include>
    <div class="wrapper clearfix">
        <h2></h2>
        <div class="f_l">
            <!--所有商品 start-->
            <div class="box yellow m_10">
                <div class="title title3">
                    <h2>
                        <img src="images/front/new_product.gif" alt="全部商品" width="160"
                             height="36" />
                    </h2>
                </div>
                <div class="cont clearfix">
                    <ul class="prolist">

                        <%--<c:if test="${goodsesLasted==null}">--%>
                        <%--<h2>goodsesLasted = null</h2>--%>
                        <%--</c:if>--%>

                        <c:forEach items="${pageBeans.data}" var="goods">
                            <li style="overflow: hidden">
                                <!--图片
                                    加上" target="_blank" "则跳转到新页面-->
                                <a href="./goods/view?goodsId=${goods.gid}" target="_blank"><img
                                        src="goodsimage/${goods.thumbnail}" width="170" height="170" alt="" /></a>
                                <p class="pro_title">
                                    <!--标题-->
                                    <a title="" href="./goods/view?goodsId=${goods.gid}" target="_blank">${goods.name}</a>
                                </p>
                                <p class="brown">
                                    价格：<b>￥${goods.price}</b>
                                </p>
                                <!--
                                <p class="light_gray">
                                    市场价：<s>￥${goods.price}</s>
                                </p></li>
                                -->
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!--最新商品 end-->
            <div class='pages_bar'>
                <a href='javascript:goPage(1)' id="first">首页</a>
                <c:forEach begin="1" end="${pageBeans.totalPage}" var="p">
                    <a href="javascript:goPage('${p}')">${p}</a>
                </c:forEach>
                <select onchange="goPage(this.value)">
                    <c:forEach begin="1" end="${pageBeans.totalPage}" var="p">
                        <option id="indeP" value="${p}">${p}</option>
                    </c:forEach>
                </select> <a href='javascript:goPage(${pageBeans.totalPage})' id="last">尾页</a>
                <span>当前第${pageBeans.page}页/共${pageBeans.totalPage}页</span>
            </div>
        </div>
    </div>
</div>


</body>
</html>