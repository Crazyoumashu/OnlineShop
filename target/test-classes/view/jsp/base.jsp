<%--
  Created by IntelliJ IDEA.
  User: 12709
  Date: 2019/7/19
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" pageEncoding="UTF-8"%>--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/shopcar.js"></script>
<script type="text/javascript" src="js/template.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/My97DatePicker/calendar.js"></script>
<script type="text/javascript">
    //用于用户中心左边菜单栏的选择项的样式
    function setSelectedClass(url){
        $('div.cont ul.list li a[href~="'+url+'"]').parent().addClass("current");
    }
</script>
