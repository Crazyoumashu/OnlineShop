<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/19
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="${base}/" />
    <meta charset="utf-8" />
    <title>${goods.name}_${site}</title>
    <style>
        span{
            color:red;
            font-size: large;
        }
    </style>
    <jsp:include page="base.jsp" />
    <script type="text/javascript">
        function buy_now() {
            location.href = "order_add.jsp";
        }
        $(function() {
            $('[name="showButton"]>label').click(
                function() {
                    $(this).siblings().removeClass('current');
                    if ($(this).hasClass('current') == false) {
                        $(this).addClass('current');
                    }
                    $('[name="showBox"]>div').addClass('hidden');
                    $('[name="showBox"]>div:eq('+ $(this).index() + ')').removeClass('hidden');
                });

            $("#add").on("click", function() {
                $("#buyNums").val(parseInt($("#buyNums").val()) + 1);
            });
            $("#reduce").on("click", function() {
                if ($("#buyNums").val() == 1) {
                    return;
                }
                $("#buyNums").val(parseInt($("#buyNums").val()) - 1);
            });

        });

        function order_add() {
            location.href = "./user/try_pay_one?gid=${goods.gid}&num="
                + $("#buyNums").val();
        }

        //加入购物车
        function joinCart() {
            if(confirm("确定要将此商品加入购物车吗？"))
            location.href = "./shopcarts/addCarts?gid=${goods.gid}&num="
                + $("#buyNums").val();
        }

        function closeCartDiv(){
            $("#product_myCart").hide();
        }
    </script>
    <!-- 有修改 见注释-->
    <!--// location.href = "./order/add?orderDetails[0].goodsId=WHAT&orderDetails[0].nums="-->
    <%--<table width="100%" class="list_table m_10 mt_10">--%>

</head>
<body class="index">
<div id="content"></div>
<div class="container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="wrapper clearfix">
        <div class="summary">
            <h2>${goods.name}</h2>
            <!--基本信息区域-->
            <ul>
                <li id="priceLi">销售价：<b class="price red2"><span
                        class="f30" id="real_price">￥${goods.price}</span></b></li>
                <li>库存：现货<span>(<label id="data_storeNums">${goods.num}</label>)
					</span></li>
            </ul>
            <div class="current">
                <dl class="m_10 clearfix">
                    <dt>购买数量：</dt>
                    <dd>
                        <input class="gray_t f_l" type="text" id="buyNums" value="1"
                               maxlength="5" />
                        <div class="resize">
                            <a class="add" id="add"></a> <a class="reduce" id="reduce"></a>
                        </div>
                    </dd>
                </dl>
                <input class="submit_buy" type="button" id="buyNowButton"
                       value="立即购买" onclick="order_add()" />

                <div class="shop_cart" style="z-index: 1">
                    <input class="submit_join" type="button" id="joinCarButton"
                           onclick="joinCart();" value="加入购物车" />

                    <div class="shopping" id="product_myCart" style='display: none'>
                        <dl class="cart_stats">
                            <dt class="gray f14 bold">
                                <a class="close_2 f_r" href="javascript:closeCartDiv();"
                                   title="关闭">关闭</a> <img src="images/front/right_s.gif"
                                                          width="24" height="24" alt="" />成功加入购物车
                            </dt>
                            <dd class="gray">
                                目前选购商品共<b class="orange" name='mycart_count'></b>件<span>合计：<b
                                    name='mycart_sum'></b></span>
                            </dd>
                            <dd>
                                <a class="btn_blue bold" href="">进入购物车</a><a
                                    class="btn_blue bold" href="javascript:void(0)" onclick="">继续购物>></a>
                            </dd>
                        </dl>
                    </div>
                </div>


            </div>
            <span>${numMsg}</span>
        </div>

        <!--图片放大镜-->
        <div>
            <div class="pic_show"
                 style="width: 435px; height: 435px; position: relative; z-index: 5; padding-bottom: 5px;">
                <img src="goodsimage/${goods.thumbnail}" title="${goods.name}"
                     style="border: none; width: 435px; height: 435px"
                     alt="${goods.name}" />
            </div>
        </div>
    </div>

    <div class="wrapper clearfix container_2">
        <!--滑动面tab标签-->
        <div class="main f_r" style="overflow: hidden">
            <div class="uc_title" name="showButton">
                <%--<label class="current"><span>商品详情</span></label> <label><span>顾客评价(0)</span></label>--%>
                <label class="current"><span>商品详情</span></label>
            </div>
            <div name="showBox">
                <!-- 商品详情 start -->
                <div>${goods.described}</div>
                <!-- 商品详情 end -->

            </div>
        </div>
    </div>

</div>
</body>
</html>
