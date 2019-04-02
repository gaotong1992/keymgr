<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20 0020
  Time: 下午 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>抽词聚类</title>
</head>
<body>
<iframe src="http://ocr.cintcm.ac.cn:8081/solr/jl.html?userid=${userid}&domsg=${domsg}"   width="100%" height="800px">


</iframe>


<script src="<%=basePath%>style/js/jquery.min.js"></script> <!-- jQuery Library -->

</body>
</html>
