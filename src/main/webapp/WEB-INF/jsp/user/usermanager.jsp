<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10 0010
  Time: 下午 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.kkx.user.bean.kkxuser" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    kkxuser userobj = (kkxuser)session.getAttribute("user");

%>
<!-- Table Condensed -->
<!-- Table Striped -->
<div class="block-area" id="tableStriped">
    <h3 class="block-title">用户组</h3>
    注：Client1：中医药文献数据结构化处理系统  &nbsp;&nbsp;&nbsp;&nbsp; Client2：中医药文献数据结构化处理系统针灸
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#useradd" style="font-size:12px;paddint:auto;float:right; ">增加用户</button>

    <div class="table-responsive overflow">
        <table class="tile table table-bordered table-striped">
            <thead>
            <tr>
                <th>No.</th>
                <th>用户名</th>
                <th>状态</th>
                <th>所在单位</th>
                <th>联系电话</th>
                <th>电子邮箱</th>
                <th>备注</th>
                <th>注册时间</th>
                <th>权限</th>
                <th>绑定MAC</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>


            <c:forEach items="${userlist}" var="list" varStatus="liststatus">

                <tr>
                    <td>${(pagenum*pagesize-pagesize)+liststatus.count}</td>
                    <td>${list.username}</td>
                    <td><c:if test="${list.userstatus==10}" >正常</c:if><c:if test="${list.userstatus!=10}" >其它</c:if></td>
                    <td>${list.useraddress}</td>
                    <td>${list.usermobile}</td>
                    <td>${list.useremail}</td>
                    <td>${list.userdesc}</td>
                    <td><fmt:formatDate value="${list.crtime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                    <td>
                        <c:if test="${listauth[liststatus.index].size()>0}" >

                            <c:if test="${listauth[liststatus.index][0].authid==1}" >Client1</c:if>
                            <c:if test="${listauth[liststatus.index][0].authid==2}" >Client2</c:if>

                            <c:if test="${listauth[liststatus.index][1].authid==1}" >Client1</c:if>
                            <c:if test="${listauth[liststatus.index][1].authid==2}" >Client2</c:if>
                        </c:if>
                    </td>
                    <td>${list.token}</td>
                    <td>

                        <button class="btn btn-xs btn-alt m-r-5"  onclick="delUser(${list.userid},${pagenum});"  >删除</button>
                        <button class="btn btn-xs btn-alt m-r-5"  onclick="updateUser(${list.userid},${pagenum});" >修改</button>
                        <button class="btn btn-xs btn-alt m-r-5"  onclick="updateUserPwd(${list.userid},${pagenum});" >修改密码</button>

                    </td>
                </tr>

            </c:forEach>
            </tbody>

        </table>
        <div id="Paginator" style="text-align: center"> <ul id="pageLimit"  ></ul> </div>

    </div>
</div>







 <!--增加用户表单-->
<div class="modal fade" id="useradd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">增加用户</h4>
            </div>
            <form   id="formuseradd">
            <div class="modal-body"  >
                <div style="margin-top: 15px;">
                    <div style="float:left;line-height:30px;text-align: right;width:15%;">用户名：</div><input name="username" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写用户名">
                </div>

                <div  style="margin-top: 15px;">
                    <div style="float:left;line-height:30px;text-align: right;width:15%;">密码：</div><input name="userpwd" style="width:80%;" type="password" class="input-sm   form-control" placeholder="请填写用户密码">
                </div>

                <div  style="margin-top: 15px;">
                    <div style="float:left;line-height:30px;text-align: right;width:15%;">所在单位：</div><input name="userdanwei" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写所在单位">
                </div>

                <div  style="margin-top: 15px;">
                    <div style="float:left;line-height:30px;text-align: right;width:15%;">联系电话：</div><input name="usermobile" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写联系电话">
                </div>

                <div  style="margin-top: 15px;">
                    <div style="float:left;line-height:30px;text-align: right;width:15%;">电子邮箱：</div><input name="useremail" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写电子邮箱">
                </div>

                <div  style="margin-top: 15px;">
                    <div style="float:left;line-height:30px;text-align: right;width:15%;">备注：</div><input name="usernote" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写备注">
                </div>

                <div  style="margin-top: 15px;">
                    <div style="float:left;line-height:30px;text-align: right;width:15%;">权限：</div>
                    <div style="width:80%;line-height:30px;">
                        Client1&nbsp;:&nbsp;<input style="opacity: 1;" type="checkbox" name="userauth" value="1"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Client2&nbsp;:&nbsp;<input style="opacity: 1;" type="checkbox" name="userauth" value="2" />
                    </div>
                </div>


            </div>

            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="userAdd()">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>







<!--修改用户表单-->
<div class="modal fade" id="userupdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabelupdate">修改用户</h4>
            </div>
            <form   id="formuserupdate">
                <div class="modal-body"  >
                    <div style="margin-top: 15px;">
                        <input style="display: none;" name="userid"  />
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">用户名：</div><input name="username" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写用户名">
                    </div>


                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">所在单位：</div><input name="userdanwei" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写所在单位">
                    </div>

                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">联系电话：</div><input name="usermobile" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写联系电话">
                    </div>

                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">电子邮箱：</div><input name="useremail" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写电子邮箱">
                    </div>

                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">备注：</div><input name="usernote" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写备注">
                    </div>

                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">权限：</div>
                        <div style="width:80%;line-height:30px;">
                            Client1&nbsp;:&nbsp;<input style="opacity: 1;" id="userauth1" type="checkbox" name="userauth" value="1"   />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            Client2&nbsp;:&nbsp;<input style="opacity: 1;" id="userauth2" type="checkbox" name="userauth" value="2"  />
                        </div>
                    </div>


                </div>

            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="userUpdateForm"  >保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>








<!--修改用户密码-->
<div class="modal fade" id="userupdatepwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabelupdatepwd">修改用户密码</h4>
            </div>
            <form   id="formuserupdatepwd">
                <div class="modal-body"  >
                    <div style="margin-top: 15px;">
                        <input style="display: none;" name="userid"  />
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">用户名：</div><input name="username" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写用户名">
                    </div>

                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">新密码：</div><input name="userpwd" style="width:80%;" type="password" class="input-sm   form-control" placeholder="请填写用户密码">
                    </div>

                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">确认密码：</div><input name="userpwd2" style="width:80%;" type="password" class="input-sm   form-control" placeholder="请填写用户密码">
                    </div>

                </div>

            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="userUpdateFormPwd"  >保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>





<script type="text/javascript" >



    $(function(){

        $("#Paginator").find("a").css("color","white");
        //分页
        $('#pageLimit').bootstrapPaginator({
            currentPage: ${pagenum},
            totalPages: ${pagezong},
            size:"normal",
            bootstrapMajorVersion: 3,
            alignment:"right",
            numberOfPages:5,
            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":

                        return "首页";
                    case "prev":

                        return "上一页";
                    case "next":

                        return "下一页";
                    case "last":

                        return "末页";
                    case "page":

                        return page;
                }
            },
            onPageClicked: function (event, originalEvent, type, page) {

                $("#content").load("<%=basePath%>linkusermanager?pagesize="+page);

            }
        });
    });







</script>