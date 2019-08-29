<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/24
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <base href="${base}/" />
    <title>核对订单信息-${site}</title>
    <jsp:include page="base.jsp" />
    <script type="text/javascript">
        function finish() {
            var payType = $("#paymentBox input[name='payType']:checked")
                .val();
            if (payType != "预存款支付") {
                alert("很抱歉，本系统暂不支持该种支付方式！请选择预存款支付！");
            } else {
                $("#form1").submit();
            }
        }
    </script>
    <%--var payType = $("#paymentBox input[name='order.payType']:checked")--%>
    <%--.val();--%>
</head>
<body class="second">
<div class="brand_list container_2">
    <jsp:include page="header.jsp" />
    <div class="wrapper clearfix">
        <h2></h2>
        <div class="main f_l">
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

                        <li style="overflow: hidden">
                            <!--图片
                                加上" target="_blank" "则跳转到新页面-->
                            <a href="./goods/view?goodsId=${goods.gid}" target="_blank"><img
                            <%--<a href="./goods/view?goods.id=${goods.id}" target="_blank"><img--%>
                                    src="goodsimage/${goods.thumbnail}" width="170" height="170" alt="" /></a>
                            <p class="pro_title">
                                <!--标题-->
                                <a title="" href="./goods/view?goodsId=${goods.gid}" target="_blank">${goods.name}</a>
                            </p>
                            <p class="brown">
                                价格：<b>￥${goods.price}</b>
                            </p>
                            <p class="brown">
                                数量：<b>￥${num}</b>
                            </p>
                            <p class="brown">
                                金额小计：<b>￥${cost}</b>
                            </p>

                            <!--
                                <p class="light_gray">
                                    市场价：<s>￥${goods.price}</s>
                                </p></li>
                                -->
                    </ul>
                    <p class="brown">
                        价格：<b>￥${cost}</b>
                    </p>
                </div>
            </div>
            <!--订单商品 end-->
        </div>
    </div>
    <div class="wrapper clearfix">
        <form action="./order/settle_one" method="post">
            <input type="hidden" name="gid" value="${goods.gid}">
            <input type="hidden" name="num" value="${num}">
            <table class="form_table" cellpadding="0" cellspacing="0">
                <col width="150px" />
                <col />

                <tr>
                    <th>姓名：</th>
                    <td><input class="normal" name="name" type="text" value="">
                        <label>*</label></td>
                </tr>
                <tr>
                    <th>邮编：</th>
                    <td><input type="text" name="postcode" /></td>
                </tr>
                <tr>
                    <th>地址：</th>
                    <td><input type="text" name="address" /></td>
                </tr>
                <tr>
                    <th>配送日期：</th>
                    <td><input type="text" name="date" /></td>
                </tr>
                <tr>
                    <th>电话：</th>
                    <td><input type="text" name="phone_num" /></td>
                </tr>
                <tr>
                    <th>用户支付方式：</th>
                    <td><input  maxlength="1" size="3"
                                name="payingTool" type="text">
                        <label id="payingMsg">"0":支付宝 "1":微信 "2":银联</label></td>
                </tr>

                <tr>
                    <td></td>
                    <td><button class="submit" type="submit">
                        <span>确定提交订单</span>
                    </button></td>
                </tr>
            </table>
        </form>
    </div>
    <jsp:include page="footer.jsp" />
</div>
</body>
</html>


