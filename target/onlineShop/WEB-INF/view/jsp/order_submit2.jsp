<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/24
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"></meta>
    <base href="${base}/" />
    <title>提交订单-${site}</title>
    <jsp:include page="base.jsp"></jsp:include>
    <script type="text/javascript">
        function finish() {
            location.href="./user/payForOrder?oid="+${order.oid};
        }
    </script>
</head>
<body class="second">
<div class="brand_list container_2">
    <jsp:include page="header.jsp" />

    <div class="wrapper clearfix">
        <div class="position mt_10">
            <span>您当前的位置：</span> <a href=""> 首页</a> » 成功提交订单
        </div>
        <div class="cart_box m_10">
            <div class="title">成功提交订单</div>
            <div class="cont">
                <p class="order_stats">
                    <a href="./order/listByUser" class="f_r blue">查看订单状态</a> <img width="48px"
                                                                                  height="51px" alt="" src="images/front/right.gif"><strong
                        class="f14">订单已提交</strong>
                </p>

                <div class="stats_box">
                    <h3>订单信息</h3>
                    <table width="100%" class="form_table t_l orange">
                        <col width="75px" />
                        <col />

                        <tbody>
                        <tr>
                            <th>订单编号：</th>
                            <td class="f18 bold red2">${order.oid }</td>
                        </tr>
                        <tr>
                            <th>订单金额：</th>
                            <td class="f18 bold red2">￥<b>${totalcost }</b></td>
                        </tr>
                        <tr>
                            <th>支付方式：</th>
                            <td class="f18 bold red2">${payType }</td>
                        </tr>
                        </tbody>
                    </table>


                    <div class="blue_box gray m_10" id='order_detail'>
                        <%--style='display: none'>--%>
                        <table class="form_table t_l">
                            <col width="80px" />
                            <col />
                            <tbody>
                            <tr>
                                <td class="t_r">收货人姓名：</td>
                                <td>${receiver.name}</td>
                            </tr>
                            <tr>
                                <td class="t_r">联系方式：</td>
                                <td>${receiver.phone_num}</td>
                            </tr>
                            <tr>
                                <td class="t_r">配送地点：</td>
                                <td>${receiver.address}</td>
                            </tr>
                            <tr>
                                <td class="t_r">收货时间：</td>
                                <td>${receiver.date}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <!--不是货到付款并且支付方式为线上支付-->
                    <!-- 先检查用户余额是否足够 -->
                    <input class="submit_pay" onclick="javascript:finish();" value="立即支付" />
                </div>
            </div>
        </div>
    </div>
    <!--jsp:include page="footer.jsp" /-->
</div>
</body>
</html>
