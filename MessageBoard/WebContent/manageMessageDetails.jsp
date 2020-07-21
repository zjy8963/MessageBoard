<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理留言</title>

	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="icon" href="img/足球.png" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="icon" href="img/足球.png" type="image/x-icon">



</head>
<body style="background: url(img/sunset.png);">
	
	
	<div class="header">
		<div class="headerinner">
			<ul class="headernav">
				<li class="logo">
				</li>
				<li><a href="Demo18/adminPage.jsp">主页</a></li>
				<li><a href="#"></a></li>
				<li><a href="messageManagementServlet">留言管理</a></li>
				<li><a href="#"></a></li>
				<li><a href="#">评论管理</a></li>
				<li><a href="#"></a></li>
				<li><a href="userManagementServlet">用户管理</a></li>
				<li>&nbsp;</li>
				<li class="list">
					<a>	&nbsp;&nbsp;&nbsp;${admin.id }</a>
				</li>
			</ul>
			<!-- 用户登录 -->
			<div class="member">
				<p>用户中心</p>
				<ul>
					<li>
						<img src="../img/personicon.png" alt="">
						<a href="#">管理员信息</a>
					</li>
					
					<li>
						<img src="../img/personicon.png" alt="">
						<a href="#">注销登录</a>
					</li>
					
					<li>
						<img src="../img/personicon.png" alt="">
						<a href="#">关于我们</a>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
	<script>
			$(function() {
				/*登录*/
				$(".list a").click(function() {
					$(".member").slideToggle(500);
				});

			});
		</script>

	<div>

		<div style="height: 590px; width: 100%; opacity: 0.95;">
			<div class="modal-body"
				style="position: absolute; top: 90px; left: 330px; width: 50%; height: 78%; opacity: 0.9;">

				<div class="form-group">
					<h1 class="modal-title" id="modal-register-label">Message
						Details</h1>
					<p><font color="black">发布日期: ${message.mTime }</font></p>
					<p><font color="black">作者: ${uName }</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="black">ID: ${message.userKey }</font></p>						
					
				</div>

				<form role="form" action="#" method="post" class="registration-form"
					name="my_form" >
					
					<div class="form-group">
						<input type="text" name="title" 
							class="form-first-name form-control" 
							id="title"
							value="${message.title }" readonly>
					</div>
					
					<div class="form-group">
						<textarea name="content" 
							class="form-about-yourself form-control" 
							id="content" readonly>${message.content }</textarea>
					</div>

				</form>


			</div>

		</div>


	</div>
	
	
	
</body>
</html>