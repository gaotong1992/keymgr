<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10 0010
  Time: 下午 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.kkx.user.bean.kkxuser" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    kkxuser userobj = (kkxuser)session.getAttribute("user");

%>
<html>
<head>
    <meta charset="UTF-8">
    <title>中医药文献数据结构化处理系统-云平台</title>

    <!-- CSS -->
    <link href="<%=basePath%>style/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/form.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/calendar.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/style.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/icons.css" rel="stylesheet">
    <link href="<%=basePath%>style/css/generics.css" rel="stylesheet">

    <link href="<%=basePath%>style/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">




</head>
<body id="skin-blur-lights">

<header id="header" class="media">
    <a href="" id="menu-toggle"></a>
  <%--  <a class="logo pull-left" href="index.html">管理员</a>--%>

    <div class="media-body">
        <div class="media" id="top-menu">
            <div class="pull-left tm-icon">
                <a data-drawer="messages" class="drawer-toggle" href="">
               <%--     <i class="sa-top-message"></i>--%>
           <%--         <i class="n-count animated">5</i>
                    <span>消息</span>--%>
                </a>
            </div>
            <div class="pull-left tm-icon">
                <a data-drawer="notifications" class="drawer-toggle" href="">
                    <%--<i class="sa-top-updates"></i>--%>
                   <%-- <i class="n-count animated">9</i>
                    <span>更新量</span>--%>
                </a>
            </div>



            <div id="time" class="pull-right">
                <span id="hours"></span>
                :
                <span id="min"></span>
                :
                <span id="sec"></span>

                <a style="font-size:14px;margin-left: 10px;" href="<%=basePath%>out"   >注销</a>
            </div>

            <div class="media-body">
               <%-- <input type="text" class="main-search">--%>
            </div>
        </div>
    </div>
</header>

<div class="clearfix"></div>

<section id="main" class="p-relative" role="main">

    <!-- Sidebar -->
    <aside id="sidebar">

        <!-- Sidbar Widgets -->
        <div class="side-widgets overflow">
            <!-- Profile Menu -->
            <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                <a href="" data-toggle="dropdown">
                    <img class="profile-pic animated" src="<%=basePath%>style/img/profile-pic.jpg" alt="">
                </a>
                <ul class="dropdown-menu profile-menu">
                    <li><a href="">My Profile</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                    <li><a href="">Messages</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                    <li><a href="">Settings</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                    <li><a href="">Sign Out</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                </ul>
                <h4 class="m-0"><%=userobj.getUsername()%></h4>
                <%=userobj.getUseraddress()%>
            </div>

            <!-- Calendar -->
            <div class="s-widget m-b-25">
                <div id="sidebar-calendar"></div>
            </div>


            <!-- Projects -->
            <div class="s-widget m-b-25">

            </div>
        </div>

        <!-- Side Menu -->
        <ul id="menudaohang" class="list-unstyled side-menu">
            <%if(userobj.getUsertype()==10){%>
            <li class="active">
                <a class="sa-side-home" href="javascript:void(0);" onclick="menuTab(1)">
                    <span class="menu-item">首页</span>
                </a>
            </li>
            <li>
                <a class="sa-side-folder" href="javascript:void(0);" onclick="menuTab(2)">
                    <span class="menu-item">用户管理</span>
                </a>
            </li>
            <li class="dropdown">
                <a class="sa-side-table" href="javascript:void(0);" onclick="menuTab(3)">
                    <span class="menu-item">分类词表管理</span>
                </a>
                <ul class="list-unstyled menu-item">
                    <li><a href="javascript:void(0);" onclick="menuTab(3)">CLIENT1:临床</a></li>
                    <li><a href="javascript:void(0);" onclick="menuTab(4)">CLIENT2:针灸</a></li>
                </ul>
            </li>
            <li>
                <a class="sa-side-page" href="javascript:void(0);" onclick="menuTab(5)">
                    <span class="menu-item">用户扩展词表管理</span>
                </a>
            </li>
            <%}%>

            <li>
                <a class="sa-side-page" href="javascript:void(0);" onclick="menuTab(6)">
                    <span class="menu-item">个人扩展词表管理</span>
                </a>
            </li>
            <%if(userobj.getUsertype()==10){%>
  <%--          <li>
                <a class="sa-side-chart" href="">
                    <span class="menu-item">统计图谱</span>
                </a>
            </li>
            <li>
                <a class="sa-side-ui" href="">
                    <span class="menu-item">日志管理</span>
                </a>
            </li>--%>
            <%}%>
        </ul>

    </aside>
    <!--content-->
    <!-- Content -->
    <section id="content" class="container">

    </section>


    <!-- Javascript Libraries -->
    <!-- jQuery -->
    <script src="<%=basePath%>style/js/jquery.min.js"></script> <!-- jQuery Library -->
    <script src="<%=basePath%>style/js/jquery-ui.min.js"></script> <!-- jQuery UI -->
    <script src="<%=basePath%>style/js/jquery.easing.1.3.js"></script> <!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

    <!-- Bootstrap -->
    <script src="<%=basePath%>style/js/bootstrap.min.js"></script>

    <!-- Charts -->
    <script src="<%=basePath%>style/js/charts/jquery.flot.js"></script> <!-- Flot Main -->
    <script src="<%=basePath%>style/js/charts/jquery.flot.time.js"></script> <!-- Flot sub -->
    <script src="<%=basePath%>style/js/charts/jquery.flot.animator.min.js"></script> <!-- Flot sub -->
    <script src="<%=basePath%>style/js/charts/jquery.flot.resize.min.js"></script> <!-- Flot sub - for repaint when resizing the screen -->

    <script src="<%=basePath%>style/js/sparkline.min.js"></script> <!-- Sparkline - Tiny charts -->
    <script src="<%=basePath%>style/js/easypiechart.js"></script> <!-- EasyPieChart - Animated Pie Charts -->
    <script src="<%=basePath%>style/js/charts.js"></script> <!-- All the above chart related functions -->

    <!-- Map -->
    <script src="<%=basePath%>style/js/maps/jvectormap.min.js"></script> <!-- jVectorMap main library -->
    <script src="<%=basePath%>style/js/maps/usa.js"></script> <!-- USA Map for jVectorMap -->

    <!--  Form Related -->
    <script src="<%=basePath%>style/js/icheck.js"></script> <!-- Custom Checkbox + Radio -->

    <!-- UX -->
    <script src="<%=basePath%>style/js/scroll.min.js"></script> <!-- Custom Scrollbar -->

    <!-- Other -->
    <script src="<%=basePath%>style/js/calendar.min.js"></script> <!-- Calendar -->
    <script src="<%=basePath%>style/js/feeds.min.js"></script> <!-- News Feeds -->


    <!-- All JS functions -->
    <script src="<%=basePath%>style/js/functions.js"></script>
    <!--分页-->
    <script src="<%=basePath%>style/js/bootstrap-paginator.js"></script>
    <!--分类树-->
    <script src="<%=basePath%>style/js/jquery.ztree.core.js"></script>



    <script type="text/javascript">

    $(function () {
        //连接到首页
        $("#menudaohang").find("li").removeClass("active");
        $("#menudaohang").find("li:eq(0)").addClass("active");
        $("#menudaohang").find("li:eq(0)").find("a").click();


    })

    /**
     * 导航
     * @param _num
     */
    function  menuTab(_num){
        switch(_num){
            case 1:
                //首页
                $("#menudaohang").find("li").removeClass("active");
                $("#menudaohang").find("li:eq(0)").addClass("active");
                $("#content").load("<%=basePath%>linkindex");
                break;
            case 2:
                //用户页面
                $("#menudaohang").find("li").removeClass("active");
                $("#menudaohang").find("li:eq(1)").addClass("active");
                $("#content").load("<%=basePath%>linkusermanager?pagesize=1");
                break;
            case 3:
                //词表页面 client1
                $("#menudaohang").find("li").removeClass("active");
                $("#menudaohang").find("li:eq(2)").addClass("active");
                $("#content").load("<%=basePath%>word/linkwordmanager?pagesize=1&wordtype=10&wordsearchcontent=");
                break;
            case 4:
                //词表页面 client2
                $("#menudaohang").find("li").removeClass("active");
                $("#menudaohang").find("li:eq(2)").addClass("active");
                $("#content").load("<%=basePath%>word/linkwordmanager?pagesize=1&wordtype=20&wordsearchcontent=");
                break;
            case 5:
                //用户扩展词表管理
                $("#menudaohang").find("li").removeClass("active");
                $("#menudaohang").find("li:eq(5)").addClass("active");
                $("#content").load("<%=basePath%>personal/linkpersonalwordmanager");
                break;
            case 6:
                //个人扩展词表管理
                $("#menudaohang").find("li").removeClass("active");
                $("#menudaohang").find("li:eq(6)").addClass("active");
                $("#content").load("<%=basePath%>userword/linkuserextendword");
                break;
        }
    }


    /**
     *
     * 用户增加表单
     */
    function  userAdd(){



       var sercont = $("#formuseradd").serialize();
        $.ajax({
            type:"post",
            url:"<%=basePath%>normaluseradd",
            data:sercont,
            cache:false,
            success:function(_msg){

               $('#useradd').modal('hide');

               setTimeout(function(){
                   if(_msg=="1"){
                       //增加成功了刷新
                       $("#content").load("<%=basePath%>linkusermanager?pagesize=1");
                   }
               },500);


            },
            error:function(){


            }
        });



    }

    /**
     * 删除用户
     * @param _userid
     */
    function  delUser(_userid,_pagenum) {

        var msg = window.confirm("您确定删除此用户吗？");
        if(msg==true){
            $.ajax({
                type:"post",
                url:"<%=basePath%>deluser",
                data:{
                    userid:_userid
                },
                cache:false,
                success:function(_msg){

                    setTimeout(function(){
                        if(_msg=="1"){
                            //删除成功了刷新
                            $("#content").load("<%=basePath%>linkusermanager?pagesize="+_pagenum);
                        }
                    },500);
                },
                error:function(){


                }
            });
        }
    }

    /**
     * 修改用户
     * @param _userid
     */
    function updateUser(_userid,_pagenum) {

        $.ajax({
            type:"post",
            url:"<%=basePath%>updateuser",
            data:{
                userid:_userid
            },
            cache:false,
            success:function(_content){
                var contentobj = $.parseJSON(_content);
                $("#userupdate").find("input[name='userid']").val(contentobj.userid=='null'?"":contentobj.userid);
                $("#userupdate").find("input[name='username']").val(contentobj.username=='null'?"":contentobj.username);
                $("#userupdate").find("input[name='userdanwei']").val(contentobj.useraddress=='null'?"":contentobj.useraddress);
                $("#userupdate").find("input[name='usermobile']").val(contentobj.usermobile=='null'?"":contentobj.usermobile);
                $("#userupdate").find("input[name='useremail']").val(contentobj.useremail=='null'?"":contentobj.useremail);
                $("#userupdate").find("input[name='usernote']").val(contentobj.userdesc=='null'?"":contentobj.userdesc);
                $('#userupdate').modal('show');


                $("#userauth1").prop("checked",false);
                $("#userauth2").prop("checked",false);
                if(contentobj.authstr!=""){
                    var contentobjarray = contentobj.authstr.split(",");
                    for(var j in contentobjarray){
                        if(contentobjarray[j]!=""){
                            var authobj = "#userauth"+contentobjarray[j];
                            $(authobj).prop("checked",true);
                        }
                    }
                }

                $("#userUpdateForm").unbind("click");
                $("#userUpdateForm").click(function(){
                    var sercont = $("#formuserupdate").serialize();
                    $.ajax({
                        type:"post",
                        url:"<%=basePath%>userupdateform",
                        data:sercont,
                        cache:false,
                        success:function(_msg){
                            $('#userupdate').modal('hide');
                            setTimeout(function(){
                                if(_msg=="1"){
                                    //增加成功了刷新
                                    $("#content").load("<%=basePath%>linkusermanager?pagesize="+_pagenum);
                                }
                            },500);
                        },
                        error:function(){
                        }
                    });
                });

            },
            error:function(){


            }
        });
    }


    /**
     * 修改密码
     * @param _userid
     * @param _pagenum
     */
    function  updateUserPwd(_userid,_pagenum) {


        $.ajax({
                type:"post",
                url:"<%=basePath%>updateuserpwd",
                data:{
                    userid:_userid
                },
                cache:false,
                success:function(_content){
                    var contentobj = $.parseJSON(_content);
                    $("#formuserupdatepwd").find("input[name='userid']").val(contentobj.userid=='null'?"":contentobj.userid);
                    $("#formuserupdatepwd").find("input[name='username']").val(contentobj.username=='null'?"":contentobj.username);
                    $('#userupdatepwd').modal('show');
                    $("#userUpdateFormPwd").unbind("click");
                    $("#userUpdateFormPwd").click(function(){
                        var sercont = $("#formuserupdatepwd").serialize();
                        $.ajax({
                            type:"post",
                            url:"<%=basePath%>userupdateformpwd",
                            data:sercont,
                            cache:false,
                            success:function(_msg){
                                $('#userupdatepwd').modal('hide');
                                setTimeout(function(){
                                    if(_msg=="1"){
                                        //增加成功了刷新
                                        $("#content").load("<%=basePath%>linkusermanager?pagesize="+_pagenum);
                                    }
                                },500);
                            },
                            error:function(){
                            }
                        });

                    });


                },
                error:function(){


                }
            });


    }
        
    /************************************************************************************************/
    /**
     * 删除某个词
     * @param _tableid
     * @param _pagenum
     */
    function  delWord(_tableid,_pagenum) {
        var msg = window.confirm("您确定删除这个词吗？");
        if(msg==true){
            $.ajax({
                type:"post",
                url:"<%=basePath%>word/delword",
                data:{
                    tableid:_tableid
                },
                cache:false,
                success:function(_msg){
                    setTimeout(function(){
                        if(_msg=="1"){
                            //删除成功了刷新
                            //$("#content").load("<%=basePath%>word/linkwordmanager?pagesize="+_pagenum+"&wordtype="+$("#wordwordtype").val());
                            $("#content").load("<%=basePath%>word/linkwordmanager?pagesize="+_pagenum+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val()));

                        }
                    },500);
                },
                error:function(){
                }
            });
        }
    }
    /**
     * 修改某个词
     * @param _tableid
     * @param _pagenum
     */
    function  updateWord(_tableid,_pagenum) {
        $.ajax({
            type:"post",
            url:"<%=basePath%>word/updateword",
            data:{
                tableid:_tableid
            },
            cache:false,
            success:function(_content){
                var contentobj = $.parseJSON(_content);
                $("#formwordupdate").find("input[name='tableid']").val(contentobj.tableid=='null'?"":contentobj.tableid);
                $("#formwordupdate").find("input[name='wordname']").val(contentobj.wordname=='null'?"":contentobj.wordname);
                $("#formwordupdate").find("input[name='wordcolname']").val(contentobj.wordcolname=='null'?"":contentobj.wordcolname);
                $('#updateword').modal('show');

                $("#wordUpdateForm").unbind("click");
                $("#wordUpdateForm").click(function(){
                    var sercont = $("#formwordupdate").serialize();
                    $.ajax({
                        type:"post",
                        url:"<%=basePath%>word/wordupdateform",
                        data:sercont,
                        cache:false,
                        success:function(_msg){
                            $('#updateword').modal('hide');
                            setTimeout(function(){
                                if(_msg=="1"){
                                    //修改词语成功了刷新
                                    $("#content").load("<%=basePath%>word/linkwordmanager?pagesize="+_pagenum+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val()));

                                }
                            },500);
                        },
                        error:function(){
                        }
                    });
                });


            },
            error:function(){
            }
        });
    }


    /**
     * 检索内容
     */
    function  searchWContent() {
        var scontentstr = $.trim($("#wordsearchcontent").val());
        if(scontentstr!=""){
            $("#content").load("<%=basePath%>word/linkwordmanager?pagesize=1&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+scontentstr);
        }
    }

    
    
    </script>

</body>
</html>
