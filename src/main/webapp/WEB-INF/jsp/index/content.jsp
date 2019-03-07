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






    <!-- Messages Drawer -->
    <div id="messages" class="tile drawer animated">
        <div class="listview narrow">
            <div class="media">
                <a href="">Send a New Message</a>
                <span class="drawer-close">&times;</span>

            </div>
            <div class="overflow" style="height: 254px">
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/1.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Nadin Jackson - 2 Hours ago</small><br>
                        <a class="t-overflow" href="">Mauris consectetur urna nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu adipiscing lectus</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/2.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">David Villa - 5 Hours ago</small><br>
                        <a class="t-overflow" href="">Suspendisse in purus ut nibh placerat Cras pulvinar euismod nunc quis gravida. Suspendisse pharetra</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/3.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Harris worgon - On 15/12/2013</small><br>
                        <a class="t-overflow" href="">Maecenas venenatis enim condimentum ultrices fringilla. Nulla eget libero rhoncus, bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar, ornare turpis id</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/4.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Mitch Bradberry - On 14/12/2013</small><br>
                        <a class="t-overflow" href="">Phasellus interdum felis enim, eu bibendum ipsum tristique vitae. Phasellus feugiat massa orci, sed viverra felis aliquet quis. Curabitur vel blandit odio. Vestibulum sagittis quis sem sit amet tristique.</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/1.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Nadin Jackson - On 15/12/2013</small><br>
                        <a class="t-overflow" href="">Ipsum wintoo consectetur urna nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu adipiscing lectus</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/2.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">David Villa - On 16/12/2013</small><br>
                        <a class="t-overflow" href="">Suspendisse in purus ut nibh placerat Cras pulvinar euismod nunc quis gravida. Suspendisse pharetra</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/3.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Harris worgon - On 17/12/2013</small><br>
                        <a class="t-overflow" href="">Maecenas venenatis enim condimentum ultrices fringilla. Nulla eget libero rhoncus, bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar, ornare turpis id</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/4.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Mitch Bradberry - On 18/12/2013</small><br>
                        <a class="t-overflow" href="">Phasellus interdum felis enim, eu bibendum ipsum tristique vitae. Phasellus feugiat massa orci, sed viverra felis aliquet quis. Curabitur vel blandit odio. Vestibulum sagittis quis sem sit amet tristique.</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/5.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Wendy Mitchell - On 19/12/2013</small><br>
                        <a class="t-overflow" href="">Integer a eros dapibus, vehicula quam accumsan, tincidunt purus</a>
                    </div>
                </div>
            </div>
            <div class="media text-center whiter l-100">
                <a href=""><small>VIEW ALL</small></a>
            </div>
        </div>
    </div>

    <!-- Notification Drawer -->
    <div id="notifications" class="tile drawer animated">
        <div class="listview narrow">
            <div class="media">
                <a href="">Notification Settings</a>
                <span class="drawer-close">&times;</span>
            </div>
            <div class="overflow" style="height: 254px">
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/1.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Nadin Jackson - 2 Hours ago</small><br>
                        <a class="t-overflow" href="">Mauris consectetur urna nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu adipiscing lectus</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/2.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">David Villa - 5 Hours ago</small><br>
                        <a class="t-overflow" href="">Suspendisse in purus ut nibh placerat Cras pulvinar euismod nunc quis gravida. Suspendisse pharetra</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/3.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Harris worgon - On 15/12/2013</small><br>
                        <a class="t-overflow" href="">Maecenas venenatis enim condimentum ultrices fringilla. Nulla eget libero rhoncus, bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar, ornare turpis id</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/4.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Mitch Bradberry - On 14/12/2013</small><br>
                        <a class="t-overflow" href="">Phasellus interdum felis enim, eu bibendum ipsum tristique vitae. Phasellus feugiat massa orci, sed viverra felis aliquet quis. Curabitur vel blandit odio. Vestibulum sagittis quis sem sit amet tristique.</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/1.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">Nadin Jackson - On 15/12/2013</small><br>
                        <a class="t-overflow" href="">Ipsum wintoo consectetur urna nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu adipiscing lectus</a>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-left">
                        <img width="40" src="<%=basePath%>style/img/profile-pics/2.jpg" alt="">
                    </div>
                    <div class="media-body">
                        <small class="text-muted">David Villa - On 16/12/2013</small><br>
                        <a class="t-overflow" href="">Suspendisse in purus ut nibh placerat Cras pulvinar euismod nunc quis gravida. Suspendisse pharetra</a>
                    </div>
                </div>
            </div>
            <div class="media text-center whiter l-100">
                <a href=""><small>VIEW ALL</small></a>
            </div>
        </div>
    </div>

    <!-- Breadcrumb -->
   <%-- <ol class="breadcrumb hidden-xs">
        <li  class="active"><a href="#">中文</a></li>
        <li><a href="#">英文</a></li>
        <li><a href="#">繁体</a></li>
    </ol>
--%>
    <h4 class="page-title">系统概览</h4>

    <!-- Shortcuts -->
    <div class="block-area shortcut-area">
        <a class="shortcut tile" href="">
            <img src="<%=basePath%>style/img/shortcuts/money.png" alt="">
            <small class="t-overflow">Client1</small>
        </a>
        <a class="shortcut tile" href="">
            <img src="<%=basePath%>style/img/shortcuts/twitter.png" alt="">
            <small class="t-overflow">Client2</small>
        </a>

    </div>

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

    <!-- Main Widgets -->

    <div class="block-area">
        <div class="row">
            <div class="col-md-8">


                <!--  Recent Postings -->
                <div class="row">
                    <div class="col-md-6">
                        <div class="tile">
                            <h2 class="tile-title">用户词表更新记录-Client1</h2>
                            <div class="tile-config dropdown">
                                <a data-toggle="dropdown" href="" class="tile-menu"></a>
                                <ul class="dropdown-menu animated pull-right text-right">
                                    <li><a href="">Refresh</a></li>
                                    <li><a href="">Settings</a></li>
                                </ul>
                            </div>

                            <div class="listview narrow">
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/1.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2 小时前 . 高彤</small><br/>
                                        <a class="t-overflow" href="">枸杞子</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/2.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">5 小时前 . 刘芳</small><br/>
                                        <a class="t-overflow" href="">鹿茸</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/3.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2019年1月13日 . 卡卡西</small><br/>
                                        <a class="t-overflow" href="">当归</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/4.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2019年1月13日 . 郭聪明</small><br/>
                                        <a class="t-overflow" href="">鹿茸</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/5.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2019年1月13日 . 高火火</small><br/>
                                        <a class="t-overflow" href="">燕窝</a>

                                    </div>
                                </div>
                                <div class="media p-5 text-center l-100">
                                    <a href=""><small>VIEW ALL</small></a>
                                </div>
                            </div>
                        </div>
                    </div>





                    <div class="col-md-6">
                        <div class="tile">
                            <h2 class="tile-title">用户词表更新记录-Client2</h2>
                            <div class="tile-config dropdown">
                                <a data-toggle="dropdown" href="" class="tile-menu"></a>
                                <ul class="dropdown-menu animated pull-right text-right">
                                    <li><a href="">Refresh</a></li>
                                    <li><a href="">Settings</a></li>
                                </ul>
                            </div>

                            <div class="listview narrow">
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/1.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2 小时前 . 高彤</small><br/>
                                        <a class="t-overflow" href="">枸杞子</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/2.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">5 小时前 . 刘芳</small><br/>
                                        <a class="t-overflow" href="">鹿茸</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/3.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2019年1月13日 . 卡卡西</small><br/>
                                        <a class="t-overflow" href="">当归</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/4.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2019年1月13日 . 郭聪明</small><br/>
                                        <a class="t-overflow" href="">鹿茸</a>

                                    </div>
                                </div>
                                <div class="media p-l-5">
                                    <div class="pull-left">
                                        <img width="40" src="<%=basePath%>style/img/profile-pics/5.jpg" alt="">
                                    </div>
                                    <div class="media-body">
                                        <small class="text-muted">2019年1月13日 . 高火火</small><br/>
                                        <a class="t-overflow" href="">燕窝</a>

                                    </div>
                                </div>
                                <div class="media p-5 text-center l-100">
                                    <a href=""><small>VIEW ALL</small></a>
                                </div>
                            </div>
                        </div>
                    </div>




                </div>
                <div class="clearfix"></div>
            </div>

            <div class="col-md-4">


                <!-- Activity -->
                <div class="tile">
                    <h2 class="tile-title">每日数据速递</h2>
                    <div class="tile-config dropdown">
                        <a data-toggle="dropdown" href="" class="tile-menu"></a>
                        <ul class="dropdown-menu pull-right text-right">
                            <li><a href="">Refresh</a></li>
                            <li><a href="">Settings</a></li>
                        </ul>
                    </div>

                    <div class="listview narrow">

                        <div class="media">
                            <div class="pull-right">
                                <div class="counts">367892</div>
                            </div>
                            <div class="media-body">
                                <h6>抽取数量：</h6>
                            </div>
                        </div>

                        <div class="media">
                            <div class="pull-right">
                                <div class="counts">2012</div>
                            </div>
                            <div class="media-body">
                                <h6>校对数量：</h6>
                            </div>
                        </div>

                        <div class="media">
                            <div class="pull-right">
                                <div class="counts">56312</div>
                            </div>
                            <div class="media-body">
                                <h6>上传PDF数量：</h6>
                            </div>
                        </div>

                        <div class="media">
                            <div class="pull-right">
                                <div class="counts">785879</div>
                            </div>
                            <div class="media-body">
                                <h6>导出数量：</h6>
                            </div>
                        </div>
                        <div class="media">
                            <div class="pull-right">
                                <div class="counts">68</div>
                            </div>
                            <div class="media-body">
                                <h6>使用人数：</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>


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