<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.kkx.user.bean.kkxuser" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    kkxuser userobj = (kkxuser)session.getAttribute("user");

%>

<link href="<%=basePath%>style/webuploader-0.1.5/webuploader.css" rel="stylesheet" >
<script src="<%=basePath%>style/webuploader-0.1.5/webuploader.js"></script>



<div style="width: 100%;min-height: 800px;float: left;">
    <!--分类词表-->
    <div style="border-bottom: thin solid rgba(255,255,255,0.15);min-height: 150px;padding:15px;">

        <select id="sel_cate_list" style="color: #000;float:left;" onchange="javascript:clientSel();">
            <c:forEach items="${authlist}" var="varauthlist">
                <c:if test="${varauthlist.intValue()==1}">
                    <option value="10" selected="selected">中医药文献数据结构化处理系统</option>
                </c:if>
                <c:if test="${varauthlist.intValue()==2}">
                    <option value="20">中医药文献数据结构化处理系统针灸</option>
                </c:if>
            </c:forEach>
        </select>


        <select style="color: #000;display: none;float:left;margin-left: 10px;" id="selclient1" onchange="selFunword(this)">
            <option value="all" selected="selected">全部</option>
            <option value="fm">方名</option>
            <option value="jbmc">疾病名称</option>
            <option value="qk">期刊</option>
            <option value="syszb">实验室指标</option>
            <option value="ywzc">药物组成</option>
            <option value="zh">证候</option>
            <option value="zz">症状</option>
        </select>


        <select style="color: #000;display:none;float:left;margin-left: 10px;" id="selclient2" onchange="selFunword(this)">
            <option value="all" selected="selected" >全部</option>
            <option value="qk">期刊</option>
            <option value="ywzc">药物组成</option>
            <option value="zh">证候</option>
            <option value="xwzc">穴位组成</option>
            <option value="jbmc">疾病名称</option>
            <option value="fm">方名</option>
            <option value="ff">方法</option>
            <option value="sf">手法</option>
            <option value="jl">经络</option>
        </select>



            <input id="wordsearchcontent" value="" type="text" class="form-control input-sm m-b-10" placeholder="请输入检索词" style="width:20%;float:left;margin-left: 10px;">
            <button type="submit" onclick="searchPword()" class="btn btn-sm" style="float:left;line-height:20px;">检索</button>


            <br/>
            <div style="margin-top: 60px;">
                <div id="uploader" class="wu-example">

                    <div class="btns">
                        <div id="picker" style="width:100px;float: left; ">选择文件</div>
                        <button id="ctlBtn" class="btn btn-default" style="float:left;">开始上传添加数据</button>
                        <a href="http://ocr.cintcm.ac.cn:8080/keymgr/style/wordtemplate.xlsx">上传模板下载</a>
                    </div>
                    <br/><br/>
                    <!--用来存放文件信息-->
                    <div id="thelist" class="uploader-list" style="font-size: 12px;"></div>
                </div>

            </div>






    </div>
    <!---扩展词表内容-->
    <div style="padding: 15px;" id="personaluserlist">










    </div>
</div>

<script type="text/javascript">
    $.ajaxSetup ({ cache: false });

    var orderbystrstr = "";


    $(function () {
        clientSel();
        inituploadFile();
        getContentByPWord();


    });


    //判断是哪个客户端
    function clientSel() {
        var seloneval = $("#sel_cate_list option:selected").val();
        if(seloneval=="10"){
            $("#selclient1").show();
            $("#selclient2").hide();
        }else if(seloneval=="20"){
            $("#selclient2").show();
            $("#selclient1").hide();
        }
        $("#personaluserlist").load("<%=basePath%>userword/getcontentbypwword?pagesize=1&client="+seloneval+"&selcolval=&wordsearchcontent=");

    }
    /**
     * 个人词表管理
     */
    function getContentByCenter(){



    }
  //  var wordtypeclient = $("#sel_cate_list").val();
    /**
     * 加载上传文件
     */
    function inituploadFile(){

        var uploader = WebUploader.create({
            auto:false,
            // swf文件路径
            swf: '<%=basePath%>style/webuploader-0.1.5/Uploader.swf',

            // 文件接收服务端。
            server: '<%=basePath%>userword/uploaduserword',

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false,
            fileNumLimit:1,
            formData:{
                wordtype:10
            },
            fileSizeLimit:104857600   //100m最大
        });
        // 当有文件被添加进队列的时候
        uploader.on( 'fileQueued', function( file ) {
            $("#thelist").append( '<div id="' + file.id + '" class="item">' +
                '<h4 class="info">' + file.name + '</h4>' +
                '<p class="state">等待上传...</p>' +
                '</div>' );
        });
        // 文件上传过程中创建进度条实时显示。
        uploader.on( 'uploadProgress', function( file, percentage ) {
            var $li = $( '#'+file.id ),
                $percent = $li.find('.progress .progress-bar');

            // 避免重复创建
            if ( !$percent.length ) {
                $percent = $('<div class="progress progress-striped active">' +
                    '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                    '</div>' +
                    '</div>').appendTo( $li ).find('.progress-bar');
            }

            $li.find('p.state').text('上传中');

            $percent.css( 'width', percentage * 100 + '%' );
        });
        uploader.on( 'uploadSuccess', function( file ) {

            console.log("file="+file)

            $( '#'+file.id ).find('p.state').text('更新完毕');

            setTimeout(function(){
                 $("#thelist").html("");
                 uploader.reset();

                getContentByPWord();





            },1000);

        });

        //上传之前触发
        uploader.on( 'uploadBeforeSend', function(object,data,headers) {

            var wordtypeclient = $("#sel_cate_list").val();
            data.wordtype =wordtypeclient;


        });

        uploader.on( 'uploadError', function( file ) {
            $( '#'+file.id ).find('p.state').text('上传出错');
        });

        uploader.on( 'uploadComplete', function( file ) {
            $( '#'+file.id ).find('.progress').fadeOut();
        });


        $("#ctlBtn").click(function(){

            uploader.upload();

        });
    }

    /**
     * 获取扩展词表内容
     */
    function getContentByPWord(){
        var selval = $("#sel_cate_list").val();
        $("#personaluserlist").load("<%=basePath%>userword/getcontentbypwword?pagesize=1&client="+selval+"&selcolval=&wordsearchcontent="+"&orderby=");

    }


    /**
     * 检索内容
     */
    function searchPword() {
        var selval = $("#sel_cate_list").val();//词表类型

        var selcolval = "";
        var selcolval1 = $("#selclient1").css("display");
        var selcolval2 = $("#selclient2").css("display");
        if(selcolval1=="block"){
            selcolval = $("#selclient1").val();
        }else if(selcolval2=="block"){
            selcolval = $("#selclient2").val();
        }

        var wordsearchcontent = $.trim($("#wordsearchcontent").val());

        if(wordsearchcontent!=""){

            $("#personaluserlist").load("<%=basePath%>userword/getcontentbypwword?pagesize=1&client="+selval+"&selcolval="+selcolval+"&wordsearchcontent="+wordsearchcontent+"&orderby="+orderbystrstr);
        }else{

            alert("请输入检索词！");
        }
    }

    /**
     * select 选择更新
     * @param _this
     */
    function selFunword(_this){
        var colval =  _this.value;
        var selval = $("#sel_cate_list").val();
        $("#personaluserlist").load("<%=basePath%>userword/getcontentbypwword?pagesize=1&client="+selval+"&selcolval="+colval+"&wordsearchcontent="+"&orderby="+orderbystrstr);
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

        var selval = $("#sel_cate_list").val();//词表类型

        var selcolval = "";
        var selcolval1 = $("#selclient1").css("display");
        var selcolval2 = $("#selclient2").css("display");
        if(selcolval1=="block"){
            selcolval = $("#selclient1").val();
        }else if(selcolval2=="block"){
            selcolval = $("#selclient2").val();
        }

        var wordsearchcontent = $.trim($("#wordsearchcontent").val());

        $("#personaluserlist").load("<%=basePath%>userword/getcontentbypwword?pagesize=1&client="+selval+"&selcolval="+selcolval+"&wordsearchcontent="+wordsearchcontent+"&orderby="+orderbystrstr);


    }
</script>





