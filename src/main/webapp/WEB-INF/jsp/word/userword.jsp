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

<style type="text/css">
    .personalcolname li{
        float:left;
        list-style-type:none;
        margin-left: 20px;
    }

</style>




<!-- Responsive Table -->
<div class="block-area" id="responsiveTable">
    <div style="float: left;">
        <div  style="float: left;">
            <h3 class="block-title">${wordtypetext}</h3>
            <input style="display: none;" value="${wordtype}" id="wordwordtype" />
        </div>
        <div  style="float: left;">
            <select style="color: #000;display: none;float:left;margin-left: 10px;margin-top: 10px;" id="selclient1" onchange="selFunword(this)">
                <option value="all" selected="selected">全部</option>
                <option value="fm">方名</option>
                <option value="jbmc">疾病名称</option>
                <option value="qk">期刊</option>
                <option value="syszb">实验室指标</option>
                <option value="ywzc">药物组成</option>
                <option value="zh">证候</option>
                <option value="zz">症状</option>
            </select>
            <select style="color: #000;display:none;float:left;margin-left: 10px;margin-top: 10px;" id="selclient2" onchange="selFunword(this)">
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
        </div>
    </div>
    <div>
        <input id="wordsearchcontent" value="${wordscontent}" type="text" class="form-control input-sm m-b-10" placeholder="请输入检索词" style="width:20%;float:left;">
        <button type="submit" onclick="searchWContent()" class="btn btn-sm" style="float:left;line-height:20px;">检索</button>
    </div>


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





<!--用户-->
<div id="personaluserlist" style="width: 99%;min-height: 800px;float: left;border-right: thin solid rgba(255,255,255,0.15);padding:15px;">



</div>


<script type="text/javascript">
    $.ajaxSetup ({ cache: false });
    var  shuhpage = 1;
    var orderbystrstr = "";

    $(function () {
        clientSel();
        inituploadFile();
    });



    /**
     * 加载上传文件
     */
    function inituploadFile(){

        var uploader = WebUploader.create({
            auto:false,
            // swf文件路径
            swf: '<%=basePath%>style/webuploader-0.1.5/Uploader.swf',

            // 文件接收服务端。
            server: '<%=basePath%>word/uploaduserword',

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
                clientSel();
            },1000);

        });

        //上传之前触发
        uploader.on( 'uploadBeforeSend', function(object,data,headers) {

            var seloneval = ${wordtype};
            data.wordtype =seloneval;


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
     * 链接到用户自定义分类词表
     */
    function  userUploadWord(_userid) {



    }

    //判断是哪个客户端
    function clientSel() {
        var seloneval = ${wordtype};
        $("#personaluserlist").load("<%=basePath%>word/linkwordmanagercontent?pagesize=1&wordtype="+seloneval+"&wordsearchcontent=&selcolval=all",function(){
            if(seloneval=="10"){
                $("#selclient1").show();
                $("#selclient2").hide();
            }else if(seloneval=="20"){
                $("#selclient2").show();
                $("#selclient1").hide();
            }
        });
    }

    /**
     * select 选择更新
     * @param _this
     */
    function selFunword(_this){
        var colval =  _this.value;
        var seloneval = ${wordtype};
        //$("#personaluserlist").load("<%=basePath%>userword/getcontentbypwword?pagesize=1&client="+selval+"&selcolval="+colval+"&wordsearchcontent="+"&orderby=");
        $("#personaluserlist").load("<%=basePath%>word/linkwordmanagercontent?pagesize=1&wordtype="+seloneval+"&wordsearchcontent=&selcolval="+colval+"&orderby="+orderbystrstr);

    }
    /**
     * 修改状态 改变值
     * @param _this
     */
    function selonlistchang(_this){
        var selval = $(_this).val();
        if(selval=="client1"){
            $(".personalcolname:eq(0)").show();
            $(".personalcolname:eq(1)").hide();
        }else if(selval=="client2"){
            $(".personalcolname:eq(1)").show();
            $(".personalcolname:eq(0)").hide();
        }
    }



</script>





