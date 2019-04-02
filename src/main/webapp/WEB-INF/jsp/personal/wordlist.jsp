<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.kkx.user.bean.kkxuser" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    kkxuser userobj = (kkxuser)session.getAttribute("user");

%>


<div class="table-responsive overflow">
    <table class="tile table table-bordered table-striped">
        <thead>
        <tr>
            <th>No.</th>
            <th  style="cursor: pointer;">词表名称</th>
            <th  style="cursor: pointer;">词表所属列</th>
            <th  style="cursor: pointer;">创建时间</th>
            <th  style="cursor: pointer;">主表为新</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userwordlist}" var="list" varStatus="liststatus">
            <tr class="personal_userlist_td" onclick="">
                <td>${(pagenum*pagesize-pagesize)+liststatus.count}</td>
                <td>${list.wordname}</td>
                <td>${list.wordcolname}</td>
                <td><fmt:formatDate value="${list.crtime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                <td>
                    <c:forEach items="${mapwordlist}" var="wlist" >
                        <c:if test="${list.kkxuserlinkwordid==wlist.key}">
                            <c:if test="${wlist.value==0}">
                                是
                            </c:if>
                            <c:if test="${wlist.value==1}">
                                否
                            </c:if>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${mapwordlist}" var="wlist" >
                        <c:if test="${list.kkxuserlinkwordid==wlist.key}">
                            <c:if test="${wlist.value==0}">
                                <button class="btn btn-xs btn-alt m-r-5"  onclick="moveWords(${list.kkxuserlinkwordid},'${list.wordname}')">移至主词表</button>
                            </c:if>
                            <c:if test="${wlist.value==1}">
                                已存在
                            </c:if>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="Paginatordivoneright" style="text-align: center"> <ul id="pageLimitdivoneright"  ></ul> </div>
</div>

<script type="text/javascript" >
    $.ajaxSetup ({ cache: false });

    var wpages = 1;
    $(function(){
        $("#Paginatordivoneright").find("a").css("color","white");
        var pagezongright =${pagezongright};
        var pagenumright = ${pagenumright};
        if(parseInt(pagezongright)>0){
            //分页
            $('#pageLimitdivoneright').bootstrapPaginator({
                currentPage: ${pagenumright},
                totalPages: ${pagezongright},
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
                    wpages = page;
                    //系统类型
                    var sel_cate_list = $("#sel_cate_list").val();
                    //列名称
                    var sel_son_colname = "all";
                    $("#sel_son_colname").find("select").each(function(_index,_this){
                        var thisdisplay = $(_this).css("display");
                        if(thisdisplay!="none"){
                            sel_son_colname = $(_this).val();
                        }
                    });
                    //检索字段名称
                    var searchwordval = $.trim($("#wordsearchcontent").val());
                    //存在选中用户
                    if(parseInt(usered)>0) {
                        $("#divcontentword").load("<%=basePath%>userword/userallwordmanagerlist?wordpagesize="+wpages+"&userid="+usered+"&sel_cate_list="+sel_cate_list+"&sel_son_colname="+sel_son_colname+"&searchwordval="+searchwordval);

                    }
                }
            });
        }
    });

    /**
     * 移动至主词表
     * @param _wordlinkid
     */
    function moveWords(_wordlinkid,_wordname) {
        var r=confirm("您确定把词["+_wordname+"]放入主词表吗？");
        if (r==true)
        {
            $.ajax({
               type:"post",
               url:"<%=basePath%>userword/adduserword",
               data:{
                   wordlinkid:_wordlinkid
               },
               success:function(msg){
                    if(msg=="1"){
                        //系统类型
                        var sel_cate_list = $("#sel_cate_list").val();
                        //列名称
                        var sel_son_colname = "all";
                        $("#sel_son_colname").find("select").each(function(_index,_this){
                            var thisdisplay = $(_this).css("display");
                            if(thisdisplay!="none"){
                                sel_son_colname = $(_this).val();
                            }
                        });
                        //检索字段名称
                        var searchwordval = $.trim($("#wordsearchcontent").val());
                        //存在选中用户
                        if(parseInt(usered)>0) {
                            $("#divcontentword").load("<%=basePath%>userword/userallwordmanagerlist?wordpagesize="+wpages+"&userid="+usered+"&sel_cate_list="+sel_cate_list+"&sel_son_colname="+sel_son_colname+"&searchwordval="+searchwordval);

                        }
                    }
               }
            });

        }
    }

</script>