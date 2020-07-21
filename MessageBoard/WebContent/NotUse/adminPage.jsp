<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员管理页</title>

	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="icon" href="img/足球.png" type="image/x-icon">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
	<link rel="stylesheet" href="assets/css/style.css">
	
	
	
	
</head>
<body style="background-color: cornflowerblue;">
	
	<script type="text/javascript">
		function myError(){
			alert("登录失败，详情请咨询管理员！");
		}
		function mySuccess(){
			alert("登录成功！");
		}
	</script>
	
	<%	Object obj = request.getAttribute("Note");
		if(obj != null){
			
			if(obj.equals("登陆成功...")){		//此处需要修改值以使提示信息显示！
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = mySuccess();</script>
				<%
			}else if(obj.equals("fail...")){
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = myError();</script>
				<%
			}
		}
	%>
	
		<div class="header">
			<div class="headerinner">
				<ul class="headernav">
					<li class="logo">
					</li>
					<li><a href="#">主页</a></li>
					<li><a href="#"></a></li>
					<li><a href="#">留言管理</a></li>
					<li><a href="#"></a></li>
					<li><a href="#">评论管理</a></li>
					<li><a href="#">用户管理</a></li>
					<li class="list">
						<a>	&nbsp;&nbsp;${admin.id }</a>
					</li>
					
				</ul>
			</div>
		</div>

		<!-- 用户登录 -->
		<div class="member">
			<p>用户中心</p>
			<ul>
				<li>
					<img src="img/personicon.png" alt="">
					<a href="#">管理员信息</a>
				</li>
				
				<li>
					<img src="img/personicon.png" alt="">
					<a href="#">注销登录</a>
				</li>
				
				<li>
					<img src="img/personicon.png" alt="">
					<a href="#">关于我们</a>
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
		
		
</body>


</html>