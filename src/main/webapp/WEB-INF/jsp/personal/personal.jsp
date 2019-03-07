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

        <select id="sel_cate_list" style="color: #000;" onchange="selonlistchang(this)">
            <option value="client1" selected="selected">中医药文献数据结构化处理系统</option>
            <option value="client2">中医药文献数据结构化处理系统针灸</option>
        </select>

        <div>
            <ul class="personalcolname">
                <li>方名&nbsp;<input type="checkbox" checked="checked" /></li>
                <li>疾病名称&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>期刊&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>实验室指标&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>药物组成&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>证候&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>症状&nbsp;<input type="checkbox" checked="checked"/></li>
            </ul>

            <ul class="personalcolname" style="display: none;">
                <li>期刊&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>药物组成&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>证候&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>穴位组成&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>疾病名称&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>方名&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>方法&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>手法&nbsp;<input type="checkbox" checked="checked"/></li>
                <li>经络&nbsp;<input type="checkbox" checked="checked"/></li>
            </ul>
        </div>


    </div>
    <!---扩展词表内容-->
    <div>


    </div>
</div>

<script type="text/javascript">



    $(function () {
        $("#personaluserlist").load("<%=basePath%>personal/userlist?pagesize=1");

    });

    /**
     * 链接到用户自定义分类词表
     */
    function  userUploadWord(_userid) {



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





