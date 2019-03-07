<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10 0010
  Time: 下午 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <!-- CSS -->
    <link href="<%=basePath%>style/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/form.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/style.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/generics.css" rel="stylesheet">
</head>
<body id="skin-blur-lights">
<section id="login">
    <header>
        <h1>中医药文献数据结构化处理系统  -  云平台</h1>
        <p>根据中医药知识库构建的迫切需要，本项目基于中医药检索系统数据库资源，研究病症证方药针灸等数据拆分和清洗的关键技术以及书籍、公开数据库、期刊文献等不同数据源的数据采集的关键技术，构建中医药数据资源建设平台，实现从数据加工，数据清洗到数据库、知识库建立的完整流程，为中医药信息化服务。通过创新团队组建模式的研究，培养一支使用信息方法学研究和建设中医药数据的人才队伍。</p>
        <p>客户端一：中医药文献数据结构化处理系统</p>
        <p>客户端二：中医药文献数据结构化处理系统针灸</p>
    </header>

    <div class="clearfix"></div>

    <!-- Login -->
    <form class="box tile animated active" id="box-login" action="<%=basePath%>login" method="post">
        <h2 class="m-t-0 m-b-15">用户登陆</h2>
        <input name="username" type="text" class="login-control m-b-10" placeholder="请输入用户名">
        <input name="pwd" type="password" class="login-control" placeholder="密码">
        <div class="checkbox m-b-20">
            <label>
                <input type="checkbox">
                记住我
            </label>
        </div>
        <button class="btn btn-sm m-r-5"  onclick="uLogin()">登陆</button>

        <small>
            <a class="box-switcher" data-switch="box-register" href="">没有帐户，注册？</a>或者
            <a class="box-switcher" data-switch="box-reset" href="">忘记密码？</a>
        </small>
    </form>

</section>

    <script src="<%=basePath%>style/js/jquery.min.js"></script>
    <script src="<%=basePath%>style/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>style/js/icheck.js"></script>
    <script src="<%=basePath%>style/js/functions.js"></script>
    <script type="text/javascript">
        $(function() {
            $('#myModal').modal('hide')
        });

        function  uLogin() {

            $("#box-login").submit(function(){

                var uname = $.trim($("#box-login").find("input:eq(0)").val());
                var upwd = $.trim($("#box-login").find("input:eq(1)").val());
                if(uname=="" || upwd==""){
                    alert("用户名或密码不能为空。");
                    return false;
                }else{
                    return true;
                }

            });
        }
    </script>


</body>
</html>
