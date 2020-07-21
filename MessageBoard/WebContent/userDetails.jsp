<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户详情</title>
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="icon" href="img/足球.png" type="image/x-icon">
</head>
<body>
		
		<!-- 表的长度需要改一下 -->
		
		
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
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li class="list">
						<a>	&nbsp;&nbsp;&nbsp;${admin.id }</a>
					</li>
				</ul>
				
			</div>
		</div>
		
		
		<div style="background: url(img/sunset.png); height: 900px; width: 100%; opacity: 0.75;">
			<div class="modal-body" style="position: absolute; top: 90px; left: 330px;  width: 50%; height: 130%; opacity: 0.9;">
			
				<form role="form" action="userModifyServlet" method="post" class="registration-form" name="my_form">
					
					<label> ${Note } </label>
					
					<div class="form-group">
						<h1 class="modal-title" id="modal-register-label">用户详情</h1>
						<label>这是一个优秀的用户~</label>
					</div>
					
					
					
					<div class="form-group">
						<input type="text" name="phone_number" placeholder="手机号码：${user.phoneNumber }" class="form-first-name form-control"
							 id="form-first-name" value="手机号码：${user.phoneNumber }" readonly="readonly">
					</div>
					
					
					<div class="form-group">
						<input type="text" name="userName" placeholder="姓名：${user.userName }" class="form-last-name form-control" 
							 id="form-last-name" readonly="readonly">
					</div>
					
					
					<div class="form-group">
						<input type="text" name="age" placeholder="年龄：${user.age }" class="form-email form-control" id="form-email" value="年龄：${user.age }">
						
					</div>
					
					
					
					<div class="form-group">
						<input type="text" name="gender" placeholder="性别：${user.gender }" class="form-email form-control" id="pwd" readonly="readonly">
					</div>
					
					
					<!-- 得按照规范写啊！这样命名存在些问题！ -->
					<div class="form-group">
						<input type="text" name="Email" placeholder="邮箱：${user.email }" class="form-email form-control" id="form-email" value="邮箱：${user.email }">
					</div>
					
					
					<div class="form-group">
						<input type="text" name="ID" placeholder="身份ID：${user.ID }" class="form-email form-control" id="form-email" value="身份ID：${user.ID }">
					</div>
					
					<div class="form-group">
						<input type="text" name="userStatus" placeholder="用户状态：${user.userStatus }" class="form-email form-control" id="pwd" value="用户状态：${user.userStatus }">
					</div>
					
					<div class="form-group">
						<input type="text" name="pwd" placeholder="密码：${user.pwd }" class="form-email form-control" id="pwd" readonly="readonly">
					</div>
					
					<div class="form-group">
						<input type="text" name="cTime" placeholder="创建时间：${user.cTime }" class="form-email form-control" id="pwd" readonly="readonly">
					</div>
					
					
					<button type="submit" class="btn" id="button">修改</button>
				</form>
				
				
				
				
			</div>
	
		</div>
	
</body>
</html>