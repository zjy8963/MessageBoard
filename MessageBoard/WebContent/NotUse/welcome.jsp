<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>


	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="icon" href="img/足球.png" type="image/x-icon">

</head>
<body style="background-color: cornflowerblue;">


	<script type="text/javascript">
				function myFunction(){
					alert("注册成功！");
				}
			
	</script>
	<div class="header">
		<div class="headerinner">
			<ul class="headernav">
				<li class="logo"></li>
				<li><a href="#"></a></li>
				<li><a href="#">主页</a></li>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li><a href="messageListServlet">看大家</a></li>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li><a href="leaveMessage.jsp">写留言</a></li>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li class="list"><a>&nbsp;&nbsp;&nbsp;${user.userName }</a></li>
			</ul>
			<!-- 用户登录 -->
			<div class="member">
				<p>用户中心</p>
				<ul>
					<li><img src="img/personicon.png" alt=""> <a href="#">个人信息</a>
					</li>
					<li><img src="img/personicon.png" alt=""> <a href="#">注销登录</a>
					</li>
					<li><img src="img/personicon.png" alt=""> <a href="#">关于我们</a>
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

	<div style="background: url(img/RainbowTiles.png); height: 800px; width: 100%; opacity: 0.75;"></div>





</body>
</html>