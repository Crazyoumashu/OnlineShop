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
            $("#form1").submit();
        }
    </script>
    <%--var payType = $("#paymentBox input[name='order.payType']:checked")--%>
    <%--.val();--%>
</head>
<body class="second">
<div class="brand_list container_2">
    <jsp:include page="header.jsp" />
    <div class="wrapper clearfix">
        <div class="position mt_10">
            <span>您当前的位置：</span> <a href=""> 首页</a> » 填写核对订单信息
        </div>
        <form action='./order/settle_one' method='post' name='order_form'
              id="form1">
            <input type="hidden" name="gid" value="${goods.gid}">
            <input type="hidden" name="num" value="${num}">
            <%--<form action='order_submit' method='post' name='order_form'--%>
            <%--id="form1">--%>


            <div class="cart_box m_10">
                <div class="title">填写核对订单信息</div>
                <div class="cont">

                    <!--收件人信息 开始-->
                    <div class="wrap_box" id='receiverBox'>
                        <h3>
                            <span class="orange">收件人信息</span>
                        </h3>

                        <table width="100%" class="border_table" id='receiver_form'>
                            <col width="200px" />
                            <col />

                            <tr>
                                <th>姓名</th>
                                <td><input class="normal" name="name" type="text" value="${receiver.name}">
                                    <label>*</label></td>
                            </tr>
                            <tr>
                                <th>邮编</th>
                                <td><input type="text" name="postcode" value="${receiver.postcode}"/></td>
                            </tr>
                            <tr>
                                <th>地址</th>
                                <td><input type="text" name="address" value="${receiver.address}"/></td>
                            </tr>
                            <tr>
                                <th>配送日期：</th>
                                <td><input name='date' class="Wdate" type="text" autocomplete="off" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})"/></td>
                            </tr>
                            <tr>
                                <th>电话：</th>
                                <td><input type="text" name="phone_num" value="${receiver.phone_num}"/></td>
                            </tr>
                        </table>
                    </div>
                    <!--收件人信息结束-->
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
                                                  name="payType" checked alt="0" title="微信"
                                                  type="radio" value="预存款支付" />微信</label></th>
                                <c:set var="fee"
                                       value="2"></c:set>
                                <td>支付手续费：￥2</td>
                            </tr>
                            <tr>
                                <th><label><input class="radio"
                                                  name="payType" alt="0" title="支付宝" type="radio"
                                                  value="支付宝" />支付宝</label></th>
                                <c:set var="fee"
                                       value="2"></c:set>
                                <td>支付手续费：￥2</td>
                            </tr>
                            <tr>
                                <th><label><input class="radio"
                                                  name="payType" checked alt="0" title="银联"
                                                  type="radio" value="银联" />银联</label></th>
                                <c:set var="fee"
                                       value="2"></c:set>
                                <td>支付手续费：￥2</td>
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
                            <col width="80px">
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
                                <input type="hidden" name="gid"
                                       value="${goods.gid}" />
                                <input type="hidden" name="num"
                                       value="${num}" />

                                <tr>
                                    <td><img src="goodsimage/${goods.thumbnail }"
                                             width="66px" height="66px" alt="${goods.name }"
                                             title="${goods.name}" /></td>
                                    <td class="t_l"><a href="" class="blue">${goods.name }</a></td>
                                    <td>￥<b>${goods.price}</b></td>
                                    <td>${num}</td>
                                    <td>￥<b class="red2">${cost}</b></td>
                                </tr>
                                <!-- 商品展示 结束-->
                            </tbody>
                        </table>
                        <%--<input type="hidden" name="orderDetailList" value="${orderDetails}" />--%>
                    </div>
                    <!--购买清单 结束-->

                </div>
            </div>
            <input type='hidden' name='totalcost' value='${cost+fee}'/>
            <!--金额结算-->
            <div class="cart_box" id='amountBox'>
                <div class="cont_2">
                    <strong>结算信息</strong>
                    <div class="pink_box">
                        <p class="f14 t_l">
                            商品总金额：<b>${cost}</b> + 手续费总计：<b id='delivery_fee_show'>${fee}</b>
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
                                        class="red2">￥<b id='final_sum'>${cost+fee}</b></span>元
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
</div>
</body>
</html>
