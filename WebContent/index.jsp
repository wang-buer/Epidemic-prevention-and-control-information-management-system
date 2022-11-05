<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>
    <img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />疫情防控信息管理中心</h1>
    <br>
  </div>
  
  <div class="head-l" style="padding-right: 350px;text-align: center;margin-top: 15px">
      
      <h5 style="text-align: center;color:#ff6600">欢迎&nbsp;&nbsp;${username}&nbsp;&nbsp;来到疫情防控信息管理系统</h5>
  </div>
  
  <div class="head-l">
         <h5 style="text-align: center;margin-top: 15px">登录时间： <fmt:formatDate value="<%=new Date()%>" pattern="yyyy年MM月dd日 hh:mm:ss"/></h5>
  </div>
  
  <div>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a class="button button-little bg-red" style="text-align: center;margin-top: 15px" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>

<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <c:if test="${role==0 || role==1 }">
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="community/CommunityList.jsp" target="right"><span class="icon-caret-right"></span>社区信息</a></li>
    <li><a href="member/MemberList.jsp" target="right"><span class="icon-caret-right"></span>居民信息</a></li>
    <li><a href="record/RecordList.jsp" target="right"><span class="icon-caret-right"></span>通行记录信息</a></li>
  </ul>
    </c:if>
    <c:if test="${role==1 }">
        <h2><span class="icon-pencil-square-o"></span>账户管理</h2>
        <ul>
            <li><a href="account/AccountList.jsp" target="right"><span class="icon-caret-right"></span>账户信息</a></li>
        </ul>
    </c:if>
    <c:if test="${role==1 }">
<%--  <h2><span class="icon-pencil-square-o"></span>文件管理</h2>--%>
<%--  <ul>--%>
<%--    <li><a href="Upload.jsp" target="right"><span class="icon-caret-right"></span>文件上传</a></li>--%>
<%--    <li><a href="Download.jsp" target="right"><span class="icon-caret-right"></span>文件下载</a></li>--%>
<%--  </ul>--%>
    </c:if>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="##" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="community/CommunityList.jsp" name="right" width="100%" height="100%">
  </iframe>

</div>

</body>
</html>