<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/24
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/20
  Time: 17:18
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

                        <c:forEach items="${goodses}" var="goods" varStatus="status">
                        <li style="overflow: hidden">
                            <!--图片
                                加上" target="_blank" "则跳转到新页面-->
                            <a href="./goods/view?goodsId=${goods.gid}" target="_blank"><img
                                <%--<a href="./goods/view?goods.id=${goods.id}" target="_blank"><img--%>
                                    src="${goods.thumbnail}" width="170" height="170" alt="" /></a>
                            <p class="pro_title">
                                <!--标题-->
                                <a title="" href="./goods/view?goodsId=${goods.gid}" target="_blank">${goods.name}</a>
                            </p>
                            <p class="brown">
                                价格：<b>￥${goods.price}</b>
                            </p>
                            <p class="brown">
                                数量：<b>￥${num[status.index]}</b>
                            </p>
                            <p class="brown">
                                金额小计：<b>￥${cost[status.index]}</b>
                            </p>

                            <!--
                                <p class="light_gray">
                                    市场价：<s>￥${goods.price}</s>
                                </p></li>
                                -->
                            </c:forEach>
                    </ul>
                    <p class="brown">
                        价格：<b>￥${totalcost}</b>
                    </p>
                </div>
            </div>
            <!--订单商品 end-->
        </div>
    </div>
    <div class="wrapper clearfix">
        <form action="./order/settle" method="post">
            <input type="hidden" name="gid" value="${gidList}">
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
                    <td><input type="text" name="phone_num" /></td><
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
        <form action='./order/submit' method='post' name='order_form'
              id="form1">
            <%--<form action='order_submit' method='post' name='order_form'--%>
            <%--id="form1">--%>

            <input type='hidden' name='opr' value='add' /> <input type='hidden'
                                                                  name='totalmoney' value='${goods.price2*nums}' />

            <div class="cart_box m_10">
                <div class="title">填写核对订单信息</div>
                <div class="cont">

                    <!--地址管理 开始-->
                    <div class="wrap_box">
                        <h3>
                            <span class="orange">收货人信息</span>
                        </h3>
                        <!--收货表单信息 开始-->
                        <div class="prompt_4 m_10" id='address_often'>
                            <strong>常用收货地址</strong>
                            <ul class="addr_list">
                                <c:forEach items="${addresses}" var="address">
                                    <%--坑爹！！数据库addressid,entity系addressID--%>
                                    <li><label><input class="radio" name="addressId"
                                                      <c:if test="${address.isDefault eq 1}">checked</c:if>
                                                      type="radio" value="${address.id }" />
                                            ${address.accept }&nbsp;&nbsp;&nbsp;&nbsp;${address.province }
                                            ${address.city } ${address.area } ${address.address } </label></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!--地址管理 结束-->
                    <div class="wrap_box" id="deliveryBox">
                        <h3>
                            <span class="orange">配送方式</span>
                        </h3>
                        <!--配送修改 开始-->
                        <table width="100%" class="border_table m_10" id="delivery_form"
                               style="display: table;">
                            <colgroup>
                                <col width="180px">
                                <col>
                            </colgroup>
                            <tbody id="deliveryFormTrBox">
                            <tr>
                                <th><label><input type="radio"
                                                  name="deliveryType" paytype="0" alt="20.00" checked
                                                  value="快递">快递</label></th>
                                <td>直接由第三方物流公司配送 运费：￥20.00 &nbsp;&nbsp;</td>
                            </tr>
                            <tr>
                                <th><label><input type="radio"
                                                  name="deliveryType" paytype="0" alt="10.00"
                                                  value="EMS">EMS</label></th>
                                <td>运费：￥10.00 &nbsp;&nbsp;</td>
                            </tr>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>指定送货时间：</th>
                                <td><label class="attr"> <input type="radio"
                                                                name="deliveryTime" checked="checked" value="任意">任意
                                </label> <label class="attr"> <input type="radio"
                                                                     name="deliveryTime" value="周一到周五">周一到周五
                                </label> <label class="attr"><input type="radio"
                                                                    name="deliveryTime" value="周末">周末</label></td>
                            </tr>
                            </tfoot>
                        </table>
                        <!--配送修改 结束-->
                    </div>
                    <!--配送方式 结束-->

                    <!--支付方式 开始-->
                    <div class="wrap_box" id='paymentBox'>
                        <h3>
                            <span class="orange">支付方式</span>
                        </h3>

                        <table width="100%" class="border_table" id='payment_form'>
                            <col width="200px" />
                            <col />

                            <tr>
                                <th><label><input class="radio"
                                                  name="payType" checked alt="0" title="预存款支付"
                                                  type="radio" value="预存款支付" />预存款支付</label></th>
                                <td>支付手续费：￥0</td>
                            </tr>
                            <tr>
                                <th><label><input class="radio"
                                                  name="payType" alt="0" title="支付宝" type="radio"
                                                  value="支付宝" />支付宝</label></th>
                                <td>支付手续费：￥0</td>
                            </tr>
                            <tr>
                                <th><label><input class="radio"
                                                  name="payType" checked alt="0" title="货到付款"
                                                  type="radio" value="货到付款" />货到付款</label></th>
                                <td>支付手续费：￥0</td>
                            </tr>
                        </table>
                    </div>
                    <!--支付方式 结束-->
                    <!--购买清单 开始-->
                    <div class="wrap_box">
                        <h3>
                            <span class="orange">购买的商品</span>
                        </h3>

                        <table width="100%" class="cart_table t_c">
                            <col width="115px" />
                            <col />
                            <col width="80px" />
                            <col width="80px" />
                            <col width="80px" />
                            <thead>
                            <tr>
                                <th>图片</th>
                                <th>商品名称</th>
                                <th>单价</th>
                                <th>数量</th>
                                <th class="last">小计</th>
                            </tr>
                            </thead>

                            <!-- 商品展示 开始-->
                            <tbody>
                            <c:set var="totalMoney" value="0"></c:set>
                            <c:forEach items="${orderDetails}" var="orderDetail" varStatus="s">
                                <input type="hidden" name="orderDetailList[${s.index }].goodsId"
                                       value="${orderDetail.goods.id}" />
                                <input type="hidden" name="orderDetailList[${s.index }].nums"
                                       value="${orderDetail.nums}" />

                                <!--实售价-->
                                <input type="hidden" name="orderDetailList[${s.index }].dealrice"
                                       value="${ orderDetail.goods.price2}" />
                                <tr>
                                    <td><img src="${orderDetail.goods.thumbnail }"
                                             width="66px" height="66px" alt="${orderDetail.goods.name }"
                                             title="${orderDetail.goods.name }" /></td>
                                    <td class="t_l"><a href="" class="blue">${orderDetail.goods.name }</a></td>
                                    <td>￥<b>${orderDetail.goods.price2 }</b></td>
                                    <td>${orderDetail.nums }</td>
                                    <td>￥<b class="red2">${orderDetail.goods.price2*orderDetail.nums  }</b></td>
                                </tr>
                                <c:set var="totalMoney"
                                       value="${totalMoney+orderDetail.goods.price2*orderDetail.nums }"></c:set>
                                <!-- 商品展示 结束-->
                            </c:forEach>
                            </tbody>
                        </table>
                        <input type="hidden" name="totalMoney" value="${totalMoney }" />
                        <%--<input type="hidden" name="orderDetailList" value="${orderDetails}" />--%>
                    </div>
                    <!--购买清单 结束-->

                </div>
            </div>

            <!--金额结算-->
            <div class="cart_box" id='amountBox'>
                <div class="cont_2">
                    <strong>结算信息</strong>
                    <div class="pink_box">
                        <p class="f14 t_l">
                            商品总金额：<b>${totalMoney}</b> + 运费总计：<b id='delivery_fee_show'>0.00</b>
                        </p>
                    </div>
                    <hr class="dashed" />
                    <div class="pink_box gray m_10">
                        <table width="100%" class="form_table t_l">
                            <col width="220px" />
                            <col />
                            <col width="250px" />
                            <tr>
                                <td class="t_r"><b class="price f14">应付总额：<span
                                        class="red2">￥<b id='final_sum'>${totalMoney }</b></span>元
                                </b></td>
                            </tr>
                        </table>
                    </div>
                    <p class="m_10 t_r">
                        <input onclick="javascript:finish();" class="submit_order" />
                    </p>
                </div>
            </div>

        </form>

    </div>
    <jsp:include page="footer.jsp" />
</div>
</body>
</html>


