<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>

	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="icon" href="img/足球.png" type="image/x-icon">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<script src="js/jquery-1.11.3.js"></script>
	<link rel="stylesheet" type="text/css" href="css/styleSlideBar.css" />
	
	
	
	
</head>
<body >
	
	
		<div class="header">
			<div class="headerinner">
				<ul class="headernav">
					<li class="logo">
					</li>
					<li><a href="#">主页</a></li>
					<li><a href="#"></a></li>
					<li><a href="#">我的好友</a></li>
					<li><a href="#"></a></li>
					<li><a href="#">我的留言</a></li>
					<li><a href="#"></a></li>
					<li><a href="#">写留言</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
					<li class="list">
						<a></a>
					</li>
					
				</ul>
			</div>
		</div>
		
		<!-- 用户登录 -->
		<div class="member">
			<p>用户中心</p>
			<ul>
				<li>
				<div class="top-big-link">
					<img src="img/personicon.png" alt="">
					<a class="launch-modal" href="#"
						data-modal-id="modal-register">用户登录</a>
				</div>
				</li>
				<li>
					<img src="img/personicon.png" alt="">
					<a href="register.jsp">用户注册</a>
				</li>
				<li>
					<img src="img/personicon.png" alt="">
					<a href="adminLogin.jsp">管理员登录</a>
				</li>
				
			</ul>
		</div>
		
		<script>
			$(function() {
				/*登录*/
				$(".list a").click(function() {
					$(".member").slideToggle(500);
				});

			});
		</script>
		
		
		
		
		
		
		

		<!-- MODAL -->
		<div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h3 class="modal-title" id="modal-register-label">用户登录</h3>
						<p>请输入已注册的手机号码和预设密码，以登录留言板系统..</p>
						<p>${Note }</p>
					</div>
					
					<div class="modal-body">
						
						<form role="form" action="userLoginServlet" method="post" class="registration-form">
							<div class="form-group">
								<input type="text" name="phoneNumber" placeholder="用户名..." 
								class="form-first-name form-control" id="form-first-name" required="required">
							</div>
							<div class="form-group">
								<input type="password" name="pwd" placeholder="密码..." 
								class="form-last-name form-control" id="form-last-name" required="required">
							</div>
							<div id="mpanel1" class="form-group" >
							</div>
							<button type="submit" class="btn" id="button">Login now!</button>
						</form>
						
					</div>
					
				</div>
			</div>
		</div>
		
		
		
		
		
		
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/verify.js" ></script>
		<script>
		
			$('#mpanel1').slideVerify({
				type : 1,		//类型
				vOffset : 8,	//误差量，根据需求自行调整
				barSize : {
					width : '42%',
					height : '58px',
				},
				ready : function() {
					document.getElementById("button").disabled = true;
				},
				success : function() {
					//alert('验证成功，添加你自己的代码！');
					document.getElementById("button").disabled = false;
				},
				error : function() {
		        	alert('验证失败，请重新验证！');
		        	document.getElementById("button").disabled = true;
				}
				
			});
			
		</script>
		
		
		<!-- Javascript -->
		<script src="assets/js/jquery-1.11.1.min.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/js/jquery.backstretch.min.js"></script>
		<script src="assets/js/scripts.js"></script>
</body>


</html>