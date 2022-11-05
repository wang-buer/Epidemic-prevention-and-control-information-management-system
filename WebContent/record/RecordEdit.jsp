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
<title></title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
  <script type="application/javascript">
    $(document).ready(function () {
      var time = new Date();
      var day = ("0" + time.getDate()).slice(-2);
      var month = ("0" + (time.getMonth() + 1)).slice(-2);
      var today = time.getFullYear() + "-" + (month) + "-" + (day);
      $('#time').val(today);
    })
  </script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder">通行记录信息修改</strong></div>
<div class="panel admin-panel margin-top" id="add">
  <div class="body-content">
    <form method="post" class="form-x" action="/Prevention/Record/update.do">
      <div class="form-group">
        <input type="hidden" name="rId" value="${record.rId}" id="rId"/>
        <div class="label">
          <label>住户姓名：</label>
        </div>
        <div class="field">
          <select name="rmId">
            <option value=0>---请选择---</option>
            <c:forEach var="men" items="${mList}">
              <c:choose>
                <c:when test="${men.mId==record.rmId}">
                  <option value="${men.mId}" selected="selected">${men.mName}</option>
                </c:when>
                <c:otherwise>
                  <option value="${men.mId}">${men.mName}</option>
                </c:otherwise>
              </c:choose>
            </c:forEach>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>社区名：</label>
        </div>
        <div class="field">
          <select name="rcId">
            <option value=0>---请选择---</option>
            <c:forEach var="item" items="${cList}">
              <c:choose>
                <c:when test="${item.cId==record.rcId}">
                  <option value="${item.cId}" selected="selected">${item.cName}</option>
                </c:when>
                <c:otherwise>
                  <option value="${item.cId}">${item.cName}</option>
                </c:otherwise>
              </c:choose>
            </c:forEach>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>是否出入本城市：</label>
        </div>
        <div class="field">
          <c:choose>
            <c:when test="${record.risOutCity==1}">
              <input type="radio" name="risOutCity" value="1" checked="checked"/>&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risOutCity" value="0" />&nbsp;否
            </c:when>
            <c:when test="${record.risOutCity==0}">
              <input type="radio" name="risOutCity" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risOutCity" value="0" checked="checked"/>&nbsp;否
            </c:when>
            <c:otherwise>
              <input type="radio" name="risOutCity" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risOutCity" value="0" />&nbsp;否
            </c:otherwise>
          </c:choose>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>是否来自疫情地区：</label>
        </div>
        <div class="field">
          <c:choose>
            <c:when test="${record.risFromHB==1}">
              <input type="radio" name="risFromHB" value="1" checked="checked"/>&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risFromHB" value="0" />&nbsp;否
            </c:when>
            <c:when test="${record.risFromHB==0}">
              <input type="radio" name="risFromHB" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risFromHB" value="0" checked="checked"/>&nbsp;否
            </c:when>
            <c:otherwise>
              <input type="radio" name="risFromHB" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risFromHB" value="0" />&nbsp;否
            </c:otherwise>
          </c:choose>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>是否是小区业主：</label>
        </div>
        <div class="field">
          <c:choose>
            <c:when test="${record.risHousehold==1}">
              <input type="radio" name="risHousehold" value="1" checked="checked"/>&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risHousehold" value="0" />&nbsp;否
            </c:when>
            <c:when test="${record.risHousehold==0}">
              <input type="radio" name="risHousehold" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risHousehold" value="0" checked="checked"/>&nbsp;否
            </c:when>
            <c:otherwise>
              <input type="radio" name="risHousehold" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="risHousehold" value="0" />&nbsp;否
            </c:otherwise>
          </c:choose>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>当前时间：</label>
        </div>
        <div class="field">
          <input type="date" id="time" class="input w50" name="rNowTime" value="${record.rNowTime}"  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 修改 </button>
        </div>
      </div>
    </form>
  </div>
</div>
</div>
</body></html>