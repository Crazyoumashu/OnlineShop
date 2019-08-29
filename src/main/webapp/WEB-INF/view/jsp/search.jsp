<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/23
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    function a() {
        $("#_input_type").val($("#select option:selected").text());
    }
</script>
<div class="searchbar">
    <form method='get' action='./goods/viewGoodByTypeAndName'>
    <div style="text-align: left;margin-top:0px; float:left; margin-left:30px; display: inline; ">
        <select id="select" style="width:150px;height:29px;" onchange="a()">
            <option value="">商品类别</option>
            <c:forEach var="type" items="${types}" varStatus="s">
                <option value="${s.index}">${type}</option>
            </c:forEach>
        </select>
        <input id="_input_type" type="hidden" name="type"/>
    </div>
    <div class="searchbox2">
            <input type='hidden' name='controller' value='site' />
            <input type='hidden' name='action' value='search_list' />
            <c:choose>
                <c:when test="${name ne null}">
                    <input class="text" type="text" name='name' autocomplete="off"
                           value="${name}" />
                </c:when>
                <c:otherwise>
                    <input class="text" type="text" name='name' autocomplete="off"
                           placeholder="输入关键字..." />
                </c:otherwise>
            </c:choose>
            <input class="btn" type="submit" value="商品搜索"
                   onclick="checkInput('word','输入关键字...');" />

    </div>
    </form>
</div>
