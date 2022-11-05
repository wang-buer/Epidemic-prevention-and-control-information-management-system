<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${aList==null}">
  <c:redirect url="/Account/queryAll.do"></c:redirect>
</c:if>
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
  <script type="application/javascript">

    //全选
    function checkAll(obj){
        var chks = document.getElementsByName("chk");
        for (var i = 0; i < chks.length; i++) {
            chks[i].checked = obj.checked;
        }
    }

    //跳转页
    function page_onchange(obj){
        var value= obj.value();
        window.location.href="/Account/queryAll.do?currentPageIndex="+value;
    }

    //是否删除提示
    function delete_onclick(){
      var bln = confirm("是否删除该笔资料？");
      //直接返回
      return bln;
    }

    /* 上一页和下一页禁用操作 */
    $(function(){
      //首先获取当前页及尾页页码
      var pageIndex = "${pageUtil.currentPageIndex+1}";
      var totalPage = "${pageUtil.totalPageCount}";
      if(pageIndex == 1){//当前页为首页
        $("#pPage").css("pointer-events","none");
      }
      if(pageIndex == totalPage){//当前页为尾页
        $("#nPage").css("pointer-events","none");
      }
    })

    //多笔删除
    function del(){
      var form1 = document.getElementById("form1");
      form1.action = "/IMSFEPAC/Account/deletes.do";
      form1.submit();
    }
  </script>
</head>
<body>
<div class="panel admin-panel">
  <form id="form1" role="form" name="form" action="/IMSFEPAC/Account/queryKeyWords.do" method="post">
  <div class="panel-head"><strong class="icon-reorder">账户信息列表</strong></div>
  <div class="padding border-bottom">
    <ul class="search">
      <li>
        <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加内容</button>
        <button type="button" class="button border-green"><span class="icon-check"></span><input type="checkbox" onclick="checkAll(this)" name="chkAll"> 全选</button>
        <button onclick="del()" type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        <input type="text" placeholder="请输入搜索关键字" name="accountName" id="accountName" value="${param.cName}" class="input" style="width:250px; line-height:17px;display:inline-block" />
        <input type="submit" class="button border-main icon-search" value="搜索"/></li>
      </li>
    </ul>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="10%">账户编号</th>
      <th width="20%">账户</th>
      <th width="15%">账户是否停用</th>
      <th width="10%">角色</th>
      <th width="15%">操作</th>
    </tr>
   <c:forEach items="${aList}" var="acc">
    <tr>
      <c:if test="${acc.accountRole==0 || acc.accountRole==1}">
      <td>
      <input name="chk" value="${acc.accountID}" type="checkbox" class="checkbox">
          ${acc.accountID}
      </td>
      <td>${acc.accountName}</td>
      <td><c:if test="${acc.accountIsStop==1}">停用</c:if>
          <c:if test="${acc.accountIsStop==0}">启用</c:if></td>
      <td>
          <c:if test="${acc.accountRole==0}">用户</c:if>
          <c:if test="${acc.accountRole==1}">管理员</c:if>
          <c:if test="${acc.accountRole==2}">超级管理员</c:if>
      </td>
      <td><div class="button-group">
      <a class="button border-main" href="/Prevention/Account/edit.do?accountID=${acc.accountID}"><span class="icon-edit"></span> 修改</a>
      <a onclick="return delete_onclick()" class="button border-red" href="/Prevention/Account/delete.do?accountID=${acc.accountID}"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
      </c:if>
    </tr>
   </c:forEach>
    <tr>
      <td colspan="7">
        <div class="pagelist"> <a href="/Prevention/Account/queryAll.do?currentPageIndex=${pageUtil.currentPageIndex-1}" id="pPage">上一页</a>
          总共<span id="totalCount" style="color: red">${pageUtil.totalCount}</span>条数据，
          每页<span id="pageSize" style="color: red">${pageUtil.pageSize}</span>条数据，
          共<span id="pageCount" style="color: red">${pageUtil.totalPageCount}</span>页，
          当前是第<span id="currentPageIndex" style="color: red">${pageUtil.currentPageIndex+1}</span>页&nbsp;
          <a href="/Prevention/Account/queryAll.do?currentPageIndex=${pageUtil.currentPageIndex+1}" id="nPage">下一页</a>
          <select id="page" name="page" onchange="page_onchange(this)"><!-- this代表当前整个事件对象 ，事件源，就是当前整个element对象-->
            <c:forEach begin="0" end="${pageUtil.totalPageCount-1}" var="i">
              <!--什么时候被选中？只有i==当前页才被选中  -->
              <c:choose>
                <c:when test="${i == pageUtil.currentPageIndex}">
                  <option value="${i}" selected="selected">${i+1}</option>
                </c:when>
                <c:otherwise>
                  <option value="${i}">${i+1}</option>
                </c:otherwise>
              </c:choose>

            </c:forEach>
          </select>
        </div></td>
    </tr>
    </tr>
    
  </table>
  </form>
</div>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="/Prevention/Account/add.do">
      <div class="form-group">
        <div class="label">
          <label>账户：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="accountName" data-validate="required:请输入账户名称" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="accountPassword" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>角色：</label>
        </div>
        <div class="field">
          <input type="radio" class="cls_rad" name="accountRole" value="1" checked="checked"/>管理员&nbsp;&nbsp;&nbsp;
          <input type="radio" class="cls_rad" name="accountRole" value="0"/>用户
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>账号是否停用：</label>
        </div>
        <div class="field">
          <input type="radio" class="cls_rad" name="accountIsStop" value="0" checked="checked"/>启用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="radio" class="cls_rad" name="accountIsStop" value="1"  />停用
          <div class="tips">
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 添加账户</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>