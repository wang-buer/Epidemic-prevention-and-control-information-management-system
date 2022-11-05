<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder">住户信息修改</strong>
    <div class="panel admin-panel margin-top" id="add">
      <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
      <div class="body-content">
        <form method="post" class="form-x" action="/Prevention/Member/update.do">
          <div class="form-group">
            <div class="label">
              <label>住户姓名：</label>
            </div>
            <div class="field">
              <input type="hidden" value="${member.mId}" name="mId" id="mId"/>
              <input type="text" class="input w50" value="${member.mName}" name="mName" />
              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>电话：</label>
            </div>
            <div class="field">
              <input type="text" class="input w50" name="mTel" value="${member.mTel}"  />
              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>性别：</label>
            </div>
            <div class="field">
              <c:choose>
                <c:when test="${member.mSex==1}">
                  <input type="radio"  name="mSex" value="1" checked="checked"/>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio"  name="mSex" value="0" />&nbsp;女
                </c:when>
                <c:when test="${member.mSex==0}">
                  <input type="radio"  name="mSex" value="1" />&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio"  name="mSex" value="0" checked="checked"/>&nbsp;女
                </c:when>
                <c:otherwise>
                  <input type="radio"  name="mSex" value="1" />&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio"  name="mSex" value="0" />&nbsp;女
                </c:otherwise>
              </c:choose>

              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>年龄：</label>
            </div>
            <div class="field">
              <input type="text" class="input w50" name="mAge" value="${member.mAge}"  />
              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>楼号：</label>
            </div>
            <div class="field">
              <input type="text" class="input w50" name="mHouseNum" value="${member.mHouseNum}"  />
              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>工作单位：</label>
            </div>
            <div class="field">
              <input type="text" class="input w50" name="mWorkUnit" value="${member.mWorkUnit}"  />
              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>车牌号：</label>
            </div>
            <div class="field">
              <input type="text" class="input w50" name="mCarNum" value="${member.mCarNum}"  />
              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>是否业主：</label>
            </div>
            <div class="field">
              <c:choose>
                <c:when test="${member.mIsHousehold==1}">
                  <input type="radio" name="mIsHousehold" value="1" checked="checked"/>&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="mIsHousehold" value="0" />&nbsp;否
                </c:when>
                <c:when test="${member.mIsHousehold==0}">
                  <input type="radio" name="mIsHousehold" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="mIsHousehold" value="0" checked="checked"/>&nbsp;否
                </c:when>
                <c:otherwise>
                  <input type="radio" name="mIsHousehold" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="mIsHousehold" value="0" />&nbsp;否
                </c:otherwise>
              </c:choose>
              <div class="tips"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="label">
              <label>居住小区：</label>
            </div>
            <div class="field">
              <select name="mcId">
                <option value=0>---请选择---</option>
                <c:forEach var="item" items="${cList}">
                  <c:choose>
                    <c:when test="${item.cId==member.mcId}">
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
              <label></label>
            </div>
            <div class="field">
              <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</body></html>