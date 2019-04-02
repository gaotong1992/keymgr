<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.kkx.user.bean.kkxuser" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    kkxuser userobj = (kkxuser)session.getAttribute("user");

%>

<style type="text/css">
    .personal_userlist_td:hover{
        background-color: #ADADAD;
        cursor: pointer;
    }

</style>


<div class="table-responsive overflow">
    <table class="tile table table-bordered table-striped">
        <thead>
        <tr>
            <th>No.</th>
            <th>用户名</th>
            <th>状态</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody id="tbody_1_userlist">
        <c:forEach items="${userlist}" var="list" varStatus="liststatus">
            <tr class="personal_userlist_td" onclick="userUploadWord(${list.userid},this)">
                <td>${(pagenum*pagesize-pagesize)+liststatus.count}</td>
                <td>${list.username}</td>
                <td><c:if test="${list.userstatus==10}" >正常</c:if><c:if test="${list.userstatus!=10}" >其它</c:if></td>
                <td>${list.userdesc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="Paginator" style="text-align: center"> <ul id="pageLimit"  ></ul> </div>
</div>
<script type="text/javascript" >
    $.ajaxSetup ({ cache: false });

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
                $("#personaluserlist").load("<%=basePath%>personal/userlist?pagesize="+page);
            }
        });
    });


</script>

