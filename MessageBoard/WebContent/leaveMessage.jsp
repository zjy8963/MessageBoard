<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.messageboard.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言界面</title>


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
<body style="background: url(img/RainbowTiles.png);">
	
	
	<script type="text/javascript">
			function myNotice(){
				alert("您已被禁言，详情请联系管理人员！");
			}
	</script>
	<%
		User user = null;
		String button = null;
		Object obj = session.getAttribute("user");
		if(obj != null){
			user = (User)obj;
			if(user.getUserStatus().equals("forbid")){
				button = "<button type='submit' class='btn' id='button' disabled='disabled'>提交</button>";
				%>
				<script type="text/javascript">
					document.getElementById("").innerHTML = myNotice();
				</script>
				<%
			}else{
				button = "<button type='submit' class='btn' id='button'>提交</button>";
			}
		}else{
			//检测用户是否登录
			button = "<button type='submit' class='btn' id='button' disabled='disabled'>提交</button>";
		}
	%>
	
	
	<div class="header">
		<div class="headerinner">
			<ul class="headernav">
				<li class="logo"></li>
				<li><a href="Demo18/userPage.jsp">主页</a></li>
				<li><a href="#"></a></li>
				<li><a href="messageListServlet">看大家</a></li>
				<li><a href="#"></a></li>
				<li><a href="leaveMessage.jsp">写留言</a></li>
				<li><a href="#"></a></li>
				<li><a href="myMessageListServlet">我的留言</a></li>
				<li><a href="#"></a></li>
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

	<div>

		<script type="text/javascript">  
				    function Check() {          
				        var title=document.my_form.title.value;  
				        var content=document.my_form.content.value;
				        
				        
				        if(title.length > 20){
				        	alert("标题输入超过范围，请修改输入...");
				            return false;
				        }
				        if(content.length > 50){
				        	alert("内容输入超过范围，请修改输入...");
				            return false;
				        }
				   }  
		</script>
		
	
		
		<div style="height: 590px; width: 100%; opacity: 0.95;">
			<div class="modal-body"
				style="position: absolute; top: 90px; left: 330px; width: 50%; height: 78%; opacity: 0.9;">

				<div class="form-group">
					<h1 class="modal-title" id="modal-register-label">Message
						Board</h1>
					<p>发表你的想法，让更多人知道！</p>
					<p>Ideas Worth Spreading!</p>
				</div>

				<form role="form" action="leaveMessageServlet" method="post" class="registration-form"
					name="my_form" onsubmit="return Check()">
					
					
					<div class="form-group">
						<input type="text" name="title" placeholder="标题(不超过20字)..."
							class="form-first-name form-control" id="title"
							required="required">
					</div>
					
					
					
					<div class="form-group">
						<textarea name="content" placeholder="内容(不超过50字)..."
							class="form-about-yourself form-control" id="content" 
							required="required"></textarea>
					</div>
					
					<%out.print(button); %>
					
				</form>


			</div>

		</div>


	</div>
	
	
	
</body>
</html>