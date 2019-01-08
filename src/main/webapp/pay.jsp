<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>pay</title>

    <!--引入jquery-->
    <script src="js/jquery.js" type="text/javascript"></script>
    <!--引入登陆组成忘记密码-->
    <script src="js/lrf.js" type="text/javascript"></script>
    <!--插入页脚-->
    <script src="js/footer.js" type="text/javascript"></script>
    <!--LRF样式 -->
    <link rel="stylesheet" type="text/css" href="css/lrf.css"/>
    <!--页脚样式-->
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>

</head>

<body style="font-family: '微软雅黑 Light';font-weight: bold">
<img id="logo" src="images/logo.png"/>

<div id="bg"></div>

<div style="border-radius: 20px;color:indianred;width: 100%;position: absolute;z-index: 4;font-size: 30px;">
    <img src="images/pay.jpg" style="margin-left: 40%" alt="pay">
    <input type="button" value="已完成支付" onclick="pay();" style="margin-left: 45%">
</div>

<!--撑出页脚-->
<div id="blank"></div>
<script type="text/javascript">

    function pay() {
        var jumpurl = "${url}";
        window.location.href = "" + jumpurl + "";
    }

</script>
</body>

</html>