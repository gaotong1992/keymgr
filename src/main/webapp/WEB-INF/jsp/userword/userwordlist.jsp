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
            <th onclick="wordOrderByPer(this)" orderby="wordname" orderbystr="${_orderbystr}" style="cursor: pointer;">词表名称</th>
            <th onclick="wordOrderByPer(this)" orderby="wordcolname" orderbystr="${_orderbystr}"  style="cursor: pointer;">词表所属列</th>
            <th onclick="wordOrderByPer(this)" orderby="crtime" orderbystr="${_orderbystr}"  style="cursor: pointer;">创建时间</th>
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
                    <button class="btn btn-xs btn-alt m-r-5"  onclick="updateUWord(${list.kkxuserlinkwordid},'${list.wordname}','${list.wordcolname}',${pagenum})" >修改</button>
                    <button class="btn btn-xs btn-alt m-r-5"  onclick="deleteUWord(${list.kkxuserlinkwordid},${pagenum})" style="margin-left: 10px;">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="Paginatordivone" style="text-align: center"> <ul id="pageLimitdivone"  ></ul> </div>
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
                        <input style="display: none;" name="kkxworduserid"  />
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
        $("#Paginatordivone").find("a").css("color","white");


        var pagezong =${pagezong};
        var pagenum = ${pagenum};

        if(parseInt(pagezong)>0){
            //分页
            $('#pageLimitdivone').bootstrapPaginator({
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

                    fenyecontent(page);
                }
            });
        }

    });

    
    function fenyecontent(page) {

        var client = ${client};

        var selcolval = "";
        var selcolval1 = $("#selclient1").css("display");
        var selcolval2 = $("#selclient2").css("display");
        if(selcolval1=="block"){
            selcolval = $("#selclient1").val();
        }else if(selcolval2=="block"){
            selcolval = $("#selclient2").val();
        }

        var wordsearchcontent = $.trim($("#wordsearchcontent").val());



        $("#personaluserlist").load("<%=basePath%>userword/getcontentbypwword?pagesize="+page+"&client="+client+"&selcolval="+selcolval+"&wordsearchcontent="+wordsearchcontent+"&orderby="+orderbystrstr);

    }

    /**
     * 修改词表
     * @param _userlinkwordid
     */
    function updateUWord(_userlinkwordid,_wordname,_wordcolname,_pagenum) {
        $('#updateword').modal('show');
        $("#updateword").find("input[name='wordname']").val(_wordname);
        $("#updateword").find("input[name='wordcolname']").val(_wordcolname);
        $("#updateword").find("input[name='kkxworduserid']").val(_userlinkwordid);

        $("#wordUpdateForm").unbind("click");
        $("#wordUpdateForm").click(function(){
            var sercont = $("#formwordupdate").serialize();
            $.ajax({
                type:"post",
                url:"<%=basePath%>userword/worduserupdateform",
                data:sercont,
                cache:false,
                success:function(_msg){
                    $('#updateword').modal('hide');
                    setTimeout(function(){
                        if(_msg=="1"){
                            //修改词语成功了刷新
                            //$("#content").load("<%=basePath%>word/linkwordmanager?pagesize="+_pagenum+"&wordtype="+$("#wordwordtype").val()+"&wordsearchcontent="+$.trim($("#wordsearchcontent").val()));
                            fenyecontent(_pagenum);
                        }
                    },500);
                },
                error:function(){
                }
            });


        });


    }
    /**
     * 删除词表
     * @param _userlinkwordid
     */
    function deleteUWord(_userlinkwordid,_pagenum) {

        var msg = window.confirm("您确定删除这个词吗？");
        if(msg==true){
            $.ajax({
                type:"post",
                url:"<%=basePath%>userword/delword",
                data:{
                    userlinkwordid:_userlinkwordid
                },
                cache:false,
                success:function(_msg){
                    setTimeout(function(){
                        if(_msg=="1"){
                            //删除成功了刷新
                            fenyecontent(_pagenum);
                        }
                    },500);
                },
                error:function(){
                }
            });
        }

    }




</script>