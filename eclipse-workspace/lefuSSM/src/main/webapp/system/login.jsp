<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站后台管理系统</title>
<link rel="stylesheet" type="text/css" href="include/particleground/style.css" />

</head>
<body>
	<form action="${pageContext.request.contextPath }/login.html" method="post">
	<dl class="admin_login">
		<dt>
			<strong>站点后台管理系统</strong> <em>Management System</em>
		</dt>
		<c:if test="${!empty errorMsg }">
		<dd style="text-align: center; color: red;" >
			${errorMsg }
		</dd>
		</c:if>
		<dd class="user_icon">
			<input type="text" placeholder="账号" class="login_txtbx" name="userLogId" value="${user.userLogId }"/>
		</dd>
		<dd class="pwd_icon">
			<input type="password" placeholder="密码" class="login_txtbx" name="userPassword" value="${user.userPassword }"/>
		</dd>
		<dd class="val_icon">
			<div class="checkcode">
				<input type="text" id="imgCode" name="logCode" placeholder="验证码" class="login_txtbx"> 
			</div>
			<img id="imgCode" title="点击图片刷新" src="${pageContext.request.contextPath }/code.html" style="cursor: pointer; margin-left: 10px;"/>
		</dd>
		<dd>
			<input type="submit" value="立即登陆" class="submit_btn" />
		</dd>
		<dd>
			<p>© 2017沈阳一网科技 版权所有</p>
		</dd>
	</dl>
	</form>
</body>
</html>
<!-- js -->
<script src="include/particleground/jquery.js"></script>
<script src="include/particleground/Particleground.js"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
		// 获取验证码
		$("#imgCode").click(function() {
			$("#imgCode").attr('src', $("#imgCode")[0].src + '?');
		});
	});
	
	if(top != window){
		top.location.href = window.location.href;
	}
</script>