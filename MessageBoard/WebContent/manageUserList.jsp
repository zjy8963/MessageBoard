<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理用户</title>
	
	<!-- 引入Bootstrap样式 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- 引入Bootstrap-table样式 -->
    <link rel="stylesheet" href="css/bootstrap-table.min.css">
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- BS-table -->
	<script src="js/bootstrap-table.min.js"></script>
	<!-- BS-table中文必须的js（如果不介意用英文的话这个可省略） -->
	<script src="js/bootstrap-table-zh-CN.min.js"></script>
	
	
	
	
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="icon" href="img/足球.png" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="css/styleUserTable.css">
</head>
<body style="background: url(img/sunset.png);">
	
	<script type="text/javascript">
		function myError(){
			alert("删除失败，详情请咨询技术人员！");
		}
		function mySuccess(){
			alert("删除成功！");
		}
	</script>
	
	<%	Object obj = request.getAttribute("Note");
		if(obj != null){
			
			if(obj.equals("success...")){		//此处需要修改值以使提示信息显示！
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = mySuccess();</script>
				<%
			}else {
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
	
	<!-- 分页弄不出来！ -->
	<div style="width:100%; height:700px;">
		${userTable }
	</div>
	
	
</body>
	


</html>