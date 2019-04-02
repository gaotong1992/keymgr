<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10 0010
  Time: 下午 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.kkx.user.bean.kkxuser" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    kkxuser userobj = (kkxuser)session.getAttribute("user");

%>






    <!-- Breadcrumb -->
   <%-- <ol class="breadcrumb hidden-xs">
        <li  class="active"><a href="#">中文</a></li>
        <li><a href="#">英文</a></li>
        <li><a href="#">繁体</a></li>
    </ol>
--%>
    <h4 class="page-title">系统概览</h4>


    <hr class="whiter" />

    <!-- Quick Stats -->
    <div class="block-area">
        <div class="row">
            <div class="col-md-3 col-xs-6">
                <div class="tile quick-stats">
                    <div id="stats-line-2" class="pull-left"></div>
                    <div class="data">
                        <h2 data-value="98">${client1}</h2>
                        <small>中医药文献数据结构化处理系统：临床</small>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-xs-6">
                <div class="tile quick-stats media">
                    <div id="stats-line-3" class="pull-left"></div>
                    <div class="media-body">
                        <h2 data-value="1452">${client2}</h2>
                        <small>中医药文献数据结构化处理系统：针灸</small>
                    </div>
                </div>
            </div>


        </div>

    </div>

    <hr class="whiter" />




</section>

<!-- Older IE Message -->
<!--[if lt IE 9]>
<div class="ie-block">
    <h1 class="Ops">Ooops!</h1>
    <p>You are using an outdated version of Internet Explorer, upgrade to any of the following web browser in order to access the maximum functionality of this website. </p>
    <ul class="browsers">
        <li>
            <a href="https://www.google.com/intl/en/chrome/browser/">
                <img src="<%=basePath%>style/img/browsers/chrome.png" alt="">
                <div>Google Chrome</div>
            </a>
        </li>
        <li>
            <a href="http://www.mozilla.org/en-US/firefox/new/">
                <img src="<%=basePath%>style/img/browsers/firefox.png" alt="">
                <div>Mozilla Firefox</div>
            </a>
        </li>
        <li>
            <a href="http://www.opera.com/computer/windows">
                <img src="<%=basePath%>style/img/browsers/opera.png" alt="">
                <div>Opera</div>
            </a>
        </li>
        <li>
            <a href="http://safari.en.softonic.com/">
                <img src="<%=basePath%>style/img/browsers/safari.png" alt="">
                <div>Safari</div>
            </a>
        </li>
        <li>
            <a href="http://windows.microsoft.com/en-us/internet-explorer/downloads/ie-10/worldwide-languages">
                <img src="<%=basePath%>style/img/browsers/ie.png" alt="">
                <div>Internet Explorer(New)</div>
            </a>
        </li>
    </ul>
    <p>Upgrade your browser for a Safer and Faster web experience. <br/>Thank you for your patience...</p>
</div>
<![endif]-->