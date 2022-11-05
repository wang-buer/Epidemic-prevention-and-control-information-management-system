<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>账户管理</title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder">账户信息修改</strong></div>
<div class="panel admin-panel margin-top" id="add">
  <div class="body-content">
    <form method="post" class="form-x" action="/Prevention/Account/update.do">
      <div class="form-group">
        <div class="label">
          <label>账户：</label>
        </div>
        <div class="field">
          <input type="hidden" value="${account.accountID}" name="accountID" />
          <input type="text" class="input w50" value="${account.accountName}" name="accountName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="accountPassword" value="${account.accountPassword}"  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>角色：</label>
        </div>
        <div class="field">
          <c:choose>
            <c:when test="${account.accountRole==1}">
              <input type="radio" class="cls_rad" name="accountRole" value="1" checked="checked"/>管理员&nbsp;&nbsp;&nbsp;
              <input type="radio" class="cls_rad" name="accountRole" value="0"/>用户
            </c:when>
            <c:when test="${account.accountRole==0}">
              <input type="radio" class="cls_rad" name="accountRole" value="1"/>管理员&nbsp;&nbsp;&nbsp;
              <input type="radio" class="cls_rad" name="accountRole" value="0" checked="checked"/>用户
            </c:when>
            <c:otherwise>
              <input type="radio" class="cls_rad" name="accountRole" value="1"/>管理员&nbsp;&nbsp;&nbsp;
              <input type="radio" class="cls_rad" name="accountRole" value="0"/>用户
            </c:otherwise>
          </c:choose>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>账号是否停用：</label>
        </div>
        <div class="field">
          <c:choose>
            <c:when test="${account.accountIsStop==0}">
              <input type="radio" class="cls_rad" name="accountIsStop" value="0" checked="checked"/>启用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" class="cls_rad" name="accountIsStop" value="1"  />停用
            </c:when>
            <c:when test="${account.accountIsStop==1}">
              <input type="radio" class="cls_rad" name="accountIsStop" value="0" />启用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" class="cls_rad" name="accountIsStop" value="1" checked="checked"/>停用
            </c:when>
            <c:otherwise>
              <input type="radio" class="cls_rad" name="accountIsStop" value="0"/>启用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" class="cls_rad" name="accountIsStop" value="1"  />停用
            </c:otherwise>
          </c:choose>
          <div class="tips">
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 修改账户</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>