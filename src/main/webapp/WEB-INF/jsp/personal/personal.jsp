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
    .personalcolname li{
        float:left;
        list-style-type:none;
        margin-left: 20px;
    }

</style>

<!--用户-->
<div id="personaluserlist" style="width: 49%;min-height: 800px;float: left;border-right: thin solid rgba(255,255,255,0.15);padding:15px;">



</div>

<div style="width: 49%;min-height: 800px;float: left;">
    <!--分类词表-->
    <div style="border-bottom: thin solid rgba(255,255,255,0.15);min-height: 150px;padding:15px;">

        <select id="sel_cate_list" style="color: #000;width: 50%;float: left;" onchange="selonlistchang(this)">
            <option value="10" selected="selected">中医药文献数据结构化处理系统</option>
            <option value="20">中医药文献数据结构化处理系统针灸</option>
        </select>

        <div id="sel_son_colname">
            <select style="color: #000; float:left;margin-left: 10px;width: 30%;" id="selclient1" onchange="selFunwordR()">
                <option value="all" selected="selected">全部</option>
                <option value="fm">方名</option>
                <option value="jbmc">疾病名称</option>
                <option value="qk">期刊</option>
                <option value="syszb">实验室指标</option>
                <option value="ywzc">药物组成</option>
                <option value="zh">证候</option>
                <option value="zz">症状</option>
            </select>


            <select style="color: #000;display:none;float:left;margin-left: 10px;width: 30%;" id="selclient2" onchange="selFunwordR()">
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

        <div style="margin-top: 50px;">
            <input id="wordsearchcontent" value="" type="text" class="form-control input-sm m-b-10" placeholder="请输入检索词" style="width:50%;float:left;">
            <button type="submit" onclick="searchPwordsR()" class="btn btn-sm" style="float:left;line-height:20px;">检索</button>
        </div>

    </div>
    <!---扩展词表内容-->
    <div id="divcontentword">


    </div>
</div>

<script type="text/javascript">
    $.ajaxSetup ({ cache: false });
    //选中用户的id
    var usered = 0;


    $(function () {
        $("#personaluserlist").load("<%=basePath%>personal/userlist?pagesize=1");

    });

    /**
     * 链接到用户自定义分类词表
     */
    function  userUploadWord(_userid,_this) {
        //css update
        $("#tbody_1_userlist").find("tr").each(function(_index,_thisson){
            $(_thisson).css("background-color","");
        });
        $(_this).css("background-color","#A9A9A9");
        usered = _userid;
        selDate();
    }

    /**
     * 修改状态 改变值
     * @param _this
     */
    function selonlistchang(_this){
        var selval = $(_this).val();
        if(selval=="10"){
            $("#selclient1").show();
            $("#selclient2").hide();
        }else if(selval=="20"){
            $("#selclient2").show();
            $("#selclient1").hide();
        }

            selDate();
    }


    /***
     * 列
     */
    function selFunwordR() {

        selDate();
    }

    /***
     * 检索
     */
    function searchPwordsR() {
        selDate();
    }



    //获取用户数据
    function selDate(){
        //存在选中用户
        if(parseInt(usered)>0) {
            //系统类型
            var sel_cate_list = $("#sel_cate_list").val();
            //列名称
            var sel_son_colname = "all";
            $("#sel_son_colname").find("select").each(function (_index, _this) {
                var thisdisplay = $(_this).css("display");
                if (thisdisplay != "none") {
                    sel_son_colname = $(_this).val();
                }
            });
            //检索字段名称
            var searchwordval = $.trim($("#wordsearchcontent").val());

            $("#divcontentword").load("<%=basePath%>userword/userallwordmanagerlist?wordpagesize=1&userid=" + usered + "&sel_cate_list=" + sel_cate_list + "&sel_son_colname=" + sel_son_colname + "&searchwordval=" + searchwordval);
        }
    }



</script>





