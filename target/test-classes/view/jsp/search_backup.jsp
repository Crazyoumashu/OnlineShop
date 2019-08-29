<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/29
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="searchbar">
    <div class="searchbox2">
        <form method='get' action='./goods/viewGoodByTypeAndName'>
            <input type='hidden' name='controller' value='site' />
            <input type='hidden' name='action' value='search_list' />
            <c:choose>
                <c:when test="${type ne null}">
                    <input class="text" type="text" name='type' autocomplete="off"
                           value="${type}" />
                </c:when>
                <c:otherwise>
                    <input class="text" type="text" name='type' autocomplete="off"
                           placeholder="请输入类别" />
                </c:otherwise>
            </c:choose>
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
        </form>
    </div>
    <%--<div class="hotwords">热门搜索：</div>--%>
</div>

<script>
    $(function() {
        $(".allsort").hover(function() {
            $('#div_allsort').show();
        }, function() {
            $('#div_allsort').hide();
        });
    });
</script>
