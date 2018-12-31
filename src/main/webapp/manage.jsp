<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>ecommerce</title>

    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <link rel="stylesheet" type="text/css" href="css/user.css"/>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="vendor/morrisjs/morris.css" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <script src="js/user.js" type="text/javascript"></script>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/metisMenu/metisMenu.min.js"></script>
    <script src="dist/js/sb-admin-2.js"></script>

    <c:if test="${empty user}">
        <script>
            top.location.href = "lrf.jsp";
        </script>
    </c:if>

</head>

<body style="font-family: '微软雅黑 Light'">

<!--引入头部-->
<div id="head_div">
    <jsp:include page="h.jsp"/>
</div>
<!--总体div-->


<div id="wrapper">

    <nav class="" role="navigation" style="margin-bottom: 0">

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="Manage.mvc">
                            <i class="fa fa-dashboard fa-fw"></i>
                            当前用户：${user.uname}
                        </a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
                            用户信息管理
                            <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a onclick="showperson(this)">
                                    当前用户信息查询
                                </a>
                            </li>
                            <li>
                                <a onclick="showchangepwd(this)">
                                    用户密码管理
                                </a>
                            </li>
                            <li>
                                <a onclick="changeinfo(this)">
                                    个人资料编辑
                                </a>
                            </li>
                            <li>
                                <a onclick="manageaddr(this)">
                                    地址管理
                                </a>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i>
                            项目管理
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a onclick="myorder(this)">我参与的项目</a>
                            </li>
                            <li>
                                <a onclick="mycomment(this)">我的评论</a>
                            </li>
                            <c:if test="${user.utype==2}">
                                <li>
                                    <a onclick="myproject(this)">我发布的项目</a>
                                </li>
                            </c:if>
                        </ul>

                    </li>

                    <li>
                        <a href="#">
                            <i> </i>
                            <i> </i>
                            <i class="fa fa-arrow-down   fa-fw"></i>
                            <i class="fa fa-arrow-down   fa-fw"></i>
                            <i class="fa fa-arrow-down   fa-fw"></i>

                            <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="Index.mvc">首页</a>
                            </li>
                            <li>
                                <a href="Checkout.mvc">注销</a>
                            </li>
                        </ul>

                    </li>
                </ul>
            </div>
        </div>
    </nav>

</div>

<div style="margin-left: 5%; padding-top: 145px;">

    <div class="rrcc" id="RightBox">
        <iframe src="manage_welcom.jsp" id="iframe" style="width: 100%;background-color: white;height: 100%;"
                frameborder="0"></iframe>
    </div>

</div>

<script type="text/javascript">
    ${sessionScope.mangetype};
</script>

</body>
