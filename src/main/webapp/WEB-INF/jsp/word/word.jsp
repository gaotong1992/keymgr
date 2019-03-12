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
        <table class="table tile">
            <thead>
            <tr>
                <th>No.</th>
                <th  onclick="wordOrderByPer(this)" orderby="wordname" orderbystr="${_orderbystr}" style="cursor: pointer;">名称</th>
                <th  onclick="wordOrderByPer(this)" orderby="wordstatus" orderbystr="${_orderbystr}" style="cursor: pointer;">状态</th>
                <th  onclick="wordOrderByPer(this)" orderby="wordcolname" orderbystr="${_orderbystr}" style="cursor: pointer;">所属列</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wordlist}" var="list" varStatus="liststatus">
            <tr>
                <td>${(pagenum*pagesize-pagesize)+liststatus.count}</td>
                <td>${list.wordname}</td>
                <td><c:if test="${list.wordstatus==10}" >正常</c:if></td>
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
                var selcolval = '${selcolval}';
                shuhpage = page;
                $("#personaluserlist").load("<%=basePath%>word/linkwordmanagercontent?pagesize="+page+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val())+"&selcolval="+selcolval+"&orderby="+orderbystrstr);
            }
        });
    });


    /**
     * 检索内容
     */
    function  searchWContent() {
        var scontentstr = $.trim($("#wordsearchcontent").val());
        if(scontentstr!=""){
            var selcolval = '${selcolval}';
            $("#personaluserlist").load("<%=basePath%>word/linkwordmanagercontent?pagesize=1&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+scontentstr+"&selcolval="+selcolval+"&orderby="+orderbystrstr);
        }
    }


    /**
     * 列排序
     * @param _colname
     */
    function wordOrderByPer(_this){

        var orderby = $(_this).attr("orderby");
        var orderbystr = $(_this).attr("orderbystr");
        var orderbystrln = orderby+"$$"+orderbystr;
        orderbystrstr = orderbystrln;

        var scontentstr = $.trim($("#wordsearchcontent").val());

        var selcolval = '${selcolval}';
        $("#personaluserlist").load("<%=basePath%>word/linkwordmanagercontent?pagesize=1&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+scontentstr+"&selcolval="+selcolval+"&orderby="+orderbystrstr);


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
                            //$("#content").load("<%=basePath%>word/linkwordmanagercontent?pagesize="+_pagenum+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val()));
                            var selcolval = '${selcolval}';
                            $("#personaluserlist").load("<%=basePath%>word/linkwordmanagercontent?pagesize="+shuhpage+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val())+"&selcolval="+selcolval+"&orderby="+orderbystrstr);

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
                                    var selcolval = '${selcolval}';
                                    $("#personaluserlist").load("<%=basePath%>word/linkwordmanagercontent?pagesize="+shuhpage+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val())+"&selcolval="+selcolval+"&orderby="+orderbystrstr);

                                   // $("#content").load("<%=basePath%>word/linkwordmanagercontent?pagesize="+_pagenum+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val()));

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

</script>








