<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/25
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/23
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="searchbar">
    <div class="searchbox">
        <form method='get' action='./order/listById'>
            <input type='hidden' name='controller' value='site' />
            <input type='hidden' name='action' value='search_list' />
            <c:choose>
                <c:when test="${id ne null}">
                    <input class="text" type="text" name='id' autocomplete="off"
                           placeholder="${id}" />
                </c:when>
                <c:otherwise>
                    <input class="text" type="text" name='id' autocomplete="off"
                           placeholder="输入订单ID..." />
                </c:otherwise>
            </c:choose>
            <input class="btn" type="submit" value="订单搜索"
                   onclick="checkInput('id','输入订单ID...');" />
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
