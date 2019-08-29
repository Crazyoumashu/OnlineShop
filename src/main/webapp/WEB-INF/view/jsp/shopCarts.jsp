<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/23
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"></meta>
    <base href="${base}/" />
    <title>购物车_${site}</title>
    <jsp:include page="base.jsp" />
    <script type="text/javascript">
        function finish() {
            $("#form1").submit();
        }
        function delCart(id) {
            if (confirm("您确认要删除该商品吗？")) {
                location.href = "./shopcarts/delete?gid=" + id;
            }
        }
        $(function(){
            //1. 注册事件
            $(".text").change(function(){
                //2. 验证数据的有效性
                var number = this.value; //也可以使用$(this).val();
                //isNaN(number)表示若number不是数字就返回真
                if(!isNaN(number) && parseInt(number)==number && number>0){
                    var price2 = ($(this).parent().prev().html()*$(this).attr("lang")).toFixed(2);
                    //如果合法，同步更新的数
                    $(this).attr("lang", number);
                    //找到当前标签中第一个是tr的父节点，然后拿到属性为lang的值，也就是商品的id
                    var pid = $(this).parents("tr:first").attr("lang");
                    //计算单个商品的小计，保留两位小数
                    var price = ($(this).parent().prev().html()*number).toFixed(2);
                    //alert(price2);
                    //alert(price);
                    $(this).parent().next().html(price);
                    var total_pre = Number($(".totalcost").text()).toFixed(2);
                    //alert(total_pre);
                    var total_cost = (Number(total_pre)-Number(price2)+Number(price)).toFixed(2);
                    //alert(total_cost);
                    $(".totalcost").text(Number(total_cost))
                } else {
                    //如果非法，还原为刚刚合法的数
                    this.value = $(this).attr("lang");
                }
            })
        })
    </script>
    <script id="goodsTemplate" type="text/plain">
<tr>
	<td><input type="hidden" name="orderDetails[{{index}}].goodsId" value="{{id}}" /><img src="{{thumbnail}}" width="66px"
		height="66px" alt="{{name}}"
		title="{{name}}" /></td>
	<td class="t_l"><a href="" class="blue">{{name}}</a></td>
	<td>￥<b>{{price2}}</b></td>
	<td>
		<div class="num">
			<a class="reduce" id="reduce"  href="javascript:reduce()" onclick=''>-</a>
				<input type="hidden" name="orderDetails[{{index}}].nums" value="{{goodsNum}}" id="goods_count_3_1"/>
				<input class="tiny" value="{{goodsNum}}" onblur='' type="text" id="goods_count_3">
			<a class="add" id="add" href="javascript:add()" onclick=''>+</a>
		</div>
	</td>
	<td>￥<b class="red2" id="goods_sum_3">{{price2*goodsNum}}</b></td>
	<td><a href="">删除</a></td>
</tr>
</script>
</head>
<body class="second">
<div class="brand_list container_2">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="wrapper clearfix">
        <div class="position mt_10">
            <span>您当前的位置：</span> <a href=""> 首页</a> » 购物车
        </div>
        <div class="myshopping m_10">
            <ul class="order_step">
                <li class="current"><span class="first">1、查看购物车</span></li>
                <li><span>2、填写核对订单信息</span></li>
                <li class="last"><span>3、成功提交订单</span></li>
            </ul>
        </div>
        <form action="./user/try_pay" id="form1">
            <table width="100%" class="cart_table m_10">
                <%--<col width="115px" />--%>
                <%--<col width="400px" />--%>
                <%--<col width="80px" />--%>
                <%--<col width="80px" />--%>
                <%--<col width="80px" />--%>
                <caption>查看购物车</caption>
                <thead>
                <tr>
                    <th>图片</th>
                    <th>商品名称</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                    <th class="last">操作</th>
                </tr>
                </thead>

                <tbody id="goodsList">
                <!-- varStatus ??? 此处不加报错-->
                <c:set var = "totalcost" value="0"></c:set>
                <c:forEach items="${goodsList}" var="goods" varStatus="s">
                    <!-- 此处可能传入"结算"需要的参数-->
                    <input type="hidden" name="cartList[${s.index }].id"
                           value="${cartList[s.index].id}" />
                    <input type="hidden" name="cartList[${s.index }].gid"
                           value="${goods.gid}" />
                    <!--input type="hidden" name="cartList[${s.index }].num"
                           value="${numList[s.index]}" /-->
                    <tr lang="${cartList[s.index].id}">
                        <td><img src="goodsimage/${goods.thumbnail }" width="66px" height="66px"/></td>
                        <td><a href="./goods/view?goodsId=${goods.gid}" class="blue">${goods.name}</a></td>
                        <td><fmt:formatNumber value="${user.discount*goods.price}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></td>
                        <td> <input class="text" name="cartList[${s.index }].num"
                                    value="${numList[s.index]}" lang="${numList[s.index]}"/></td>
                        <!--td>${numList[s.index]}</td-->
                        <td><fmt:formatNumber value="${user.discount*numList[s.index] * goods.price}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></td>
                        <td><!-- 删除操作-->
                            <a href="javascript:delCart('${goods.gid }')">
                                <img width="12px" height="12px" class="operator"
                                     src="images/admin/icon_del.gif" alt="删除" /></a></td>
                        <td>${msg[s.index]}</td>
                    </tr>
                    <c:set var="totalcost" value="${totalcost+user.discount*goods.price*numList[s.index]}"></c:set>
                </c:forEach>

                <tr class="stats">
                    <td colspan="8">金额总计（不含运费）：<b class="orange" id='sum_price'><span class="totalcost" id="totalPrice"><fmt:formatNumber value="${totalcost}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></span></b></td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2" class="t_l"></td>
                    <td colspan="6" class="t_r">
                        <a class="btn_continue" href="./index">继续购物</a>
                        <%--<a class="btn_pay" href="javascript:finish();">去结算</a></td>--%>
                        <input class="submit_pay" type="submit" value="去结算" />
                </tr>
                </tfoot>
            </table>
        </form>

        <!--
        <div class="box">
            <div class="title">热门商品推荐</div>
        </div>
        <ul id="scrollpic" class="prolist">
            <c:forEach begin="1" end="5">
                <li><a href=""> <img width="98px" height="106px"
                                     src="images/goods/apple.jpg" alt="苹果（Apple）iPhone 6 (A1586) 64GB"
                                     title="苹果（Apple）iPhone 6 (A1586) 64GB">
                </a>
                    <p class="pro_title">
                        <a href="">苹果（Apple）iPhone 6 (A1586) 64GB</a>
                    </p>
                    <p class="brown">
                        <b>￥5800.00</b>
                    </p> <label class="btn_orange2">
                        <input type="submit" onclick="" value="加入购物车"></label></li>
            </c:forEach>
        </ul>
        -->
    </div>
    <!--jsp:include page="footer.jsp" /-->
</div>
</body>
</html>

