<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.kkx.user.bean.kkxuser" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    kkxuser userobj = (kkxuser)session.getAttribute("user");

%>




<!-- Responsive Table -->
<div class="block-area" id="responsiveTable">
    <h3 class="block-title">${wordtypetext}</h3>
    <input style="display: none;" value="${wordtype}" id="wordwordtype" />
    <div>
        <input id="wordsearchcontent" value="${wordscontent}" type="text" class="form-control input-sm m-b-10" placeholder="请输入检索词" style="width:20%;float:left;">
        <button type="submit" onclick="searchWContent()" class="btn btn-sm" style="float:left;line-height:20px;">检索</button>

    </div>

    <div class="table-responsive overflow">
        <table class="table tile">
            <thead>
            <tr>
                <th>No.</th>
                <th>名称</th>
                <th>状态</th>
                <th>所属列</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wordlist}" var="list" varStatus="liststatus">
            <tr>
                <td>${(pagenum*pagesize-pagesize)+liststatus.count}</td>
                <td>${list.wordname}</td>
                <td>${list.wordstatus}</td>
                <td>${list.wordcolname}</td>
                <td>
                    <button class="btn btn-xs btn-alt m-r-5"  onclick="delWord(${list.tableid},${pagenum});"  >删除</button>
                    <button class="btn btn-xs btn-alt m-r-5"  onclick="updateWord(${list.tableid},${pagenum});" >修改</button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="Paginatorword" style="text-align: center"> <ul id="pageLimitword"  ></ul> </div>
    </div>
</div>





<!--修改词语表单-->
<div class="modal fade" id="updateword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"  >修改词语</h4>
            </div>
            <form   id="formwordupdate">
                <div class="modal-body"  >
                    <div style="margin-top: 15px;">
                        <input style="display: none;" name="tableid"  />
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">名称：</div><input name="wordname" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写名称">
                    </div>


                    <div  style="margin-top: 15px;">
                        <div style="float:left;line-height:30px;text-align: right;width:15%;">所属列：</div><input name="wordcolname" style="width:80%;" type="text" class="input-sm   form-control" placeholder="请填写所属列">
                    </div>


                </div>

            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="wordUpdateForm"  >保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



























<script type="text/javascript" >


    $(function(){
        $("#Paginatorword").find("a").css("color","white");
        //分页
        $('#pageLimitword').bootstrapPaginator({
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
                $("#content").load("<%=basePath%>word/linkwordmanager?pagesize="+page+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val()));
            }
        });
    });

</script>








