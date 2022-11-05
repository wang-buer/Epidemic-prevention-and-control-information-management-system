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
    <title>文件上传</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>

<form action="/Prevention/Upload.do" method="post" enctype="multipart/form-data">
    <table width="600">
        <tr>
            <td>上传者:</td>
            <td><input class="input" type="text" name="name"/></td>
        </tr>
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        <tr style="margin-top: 32px">
            <td>上传文件:</td>
            <td><input class="input" type="file" name="myfile"/></td>
        </tr>
        <tr>

            <td colspan="2"><input class="button bg-main icon-check-square-o" type="submit" value="上传"/></td>
        </tr>
    </table>

</form>
</body>
</html>