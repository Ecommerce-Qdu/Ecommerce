<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<head>

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/lrf.js"></script>
    <script type="text/javascript" src="js/tolrf.js"></script>

    <%--<link rel="stylesheet" type="text/css" href="css/menu.css"/>--%>
    <link rel="stylesheet" type="text/css" href="css/logo.css"/>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/mian.css"/>
    <script type="text/javascript" src="layui/layui.js"></script>

</head>

<body class="lay-blog">
<div class="header"  style="position: fixed;top: 0;width: 100%;z-index: 9">
    <div class="header-wrap">
        <h1 class="logo pull-left">
            <a href="Index.mvc">
                <img src="images/logo.png" alt="" id="logo" class="logo-img">
            </a>
        </h1>

        <div class="blog-nav pull-left">
            <ul class="layui-nav pull-left">
                <li class="layui-nav-item layui-this">
                    <a href="Index.mvc">首页</a>
                </li>
                <li class="layui-nav-item">
                    <a href="Projectlist.mvc?type=1">最新项目</a>
                </li>
                <li class="layui-nav-item">
                    <a href="Projectlist.mvc?type=0">最热项目</a>
                </li>
                <li class="layui-nav-item">
                    <a href="Projectlist.mvc?type=2">最多支持</a>
                </li>
                <c:if test="${user.utype==2}">
                    <li class="layui-nav-item">
                        <a href="addproject.jsp" target="_top">发布项目</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="manage.jsp?mangetype=myproject" target="_top">我的项目</a>
                    </li>
                </c:if>
            </ul>
        </div>

        <form class="layui-form blog-seach pull-left" onsubmit="search();">
            <div class="layui-form-item blog-sewrap">
                <div class="layui-input-block blog-sebox">
                    <input id="inputsearch" type="text" autocomplete="off"
                           class="input"/>
                    <i class="layui-icon layui-icon-search" onclick="search();"></i>
                    <input type="submit" style="display: none;"/>

                    <%-- 阻止回车提交--%>

                </div>
            </div>
        </form>

        <div class="blog-nav pull-right" style="color: #fff;">
            <c:if test="${sessionScope.user==null}">
                <div onclick="tolrfr();" class="top_nav">
                    <i class="layui-icon layui-icon-username"></i>
                    用户注册
                </div>
                <div onclick="tolrfl();" class="top_nav">

                    <i class="layui-icon layui-icon-username"></i>
                    登陆
                </div>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <div onclick="toUser();" class="top_nav">
                    <i class="layui-icon layui-icon-username"></i>
                        ${sessionScope.user.uname}的个人中心
                </div>
                <div onclick="toExit();" class="top_nav">
                    <i class="layui-icon layui-icon-username"></i>
                    注销
                </div>
            </c:if>
        </div>
    </div>
</div>

<script type="text/javascript">
    layui.config({
        base: 'static/js/'
    }).use('blog');

    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });

    function search() {
        var param = document.getElementById("inputsearch").value;
        location.href = "Projectlist.mvc?type=6&searchstr=" + param;
    }
</script>
</body>