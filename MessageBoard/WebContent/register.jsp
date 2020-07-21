<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="icon" href="img/足球.png" type="image/x-icon">
</head>
<body>
		
		
		<!-- 表的长度需要改一下 -->
		<script type="text/javascript">
			function myNotice(){
				alert("未注册，请先注册或登录！");
			}
		</script>
		
		<div class="header">
			<div class="headerinner">
				<ul class="headernav">
					<li class="logo"></li>
					<li><a href="Demo18/userPage.jsp">主页</a></li>
					<li><a href="#"></a></li>
					<li><a href="#" onclick="myNotice()">看大家</a></li>
					<li><a href="#"></a></li>
					<li><a href="#" onclick="myNotice()">写留言</a></li>
					<li><a href="#"></a></li>
					<li><a href="myMessageListServlet">我的留言</a></li>
					<li><a href="#"></a></li>
					<li class="list"><a>&nbsp;&nbsp;&nbsp;${user.userName }</a></li>
				</ul>
				
			</div>
		</div>
		
		<script type="text/javascript">  
				    function Check() {          
				        var passwd1=document.my_form.pwd.value;  
				        var passwd2=document.my_form.pwd_check.value;
				        
				        if (passwd1 != passwd2) {
				            alert("密码不一致，请重输入");
				            document.my_form.pwd.innerText="";
				            document.my_form.pwd_check.innerText="";
				        } else {
				            
				        }
				   }  
		</script>
		
		
		
		<div style="background: url(img/RainbowTiles.png); height: 900px; width: 100%; opacity: 1;">
			<div class="modal-body" style="position: absolute; top: 90px; left: 330px;  width: 50%; height: 126%; opacity: 0.85;">
			
				
				<script>
					function validate() {
					    var pwd1 = document.getElementById("pwd").value;
					    var pwd2 = document.getElementById("pwd_check").value;
					 
					    if(pwd1 == pwd2)
					     {
					        document.getElementById("noice").innerHTML="<label><font color='green'>密码相同&nbsp;&nbsp;&nbsp;&nbsp;√</font></label>";
					        document.getElementById("button").disabled = false;
						     }
						else {
						        document.getElementById("noice").innerHTML="<label>密码不同，请再次确认</label>";
						        document.getElementById("button").disabled = true;
						     }
						}
				</script>
				
				
				
				<form role="form" action="registerServlet" method="post" class="registration-form" name="my_form">
					
					<label> ${Note } </label>
					
					<div class="form-group">
						<h1 class="modal-title" id="modal-register-label">用户注册</h1>
						<label>发言、评论、享受自由~</label>
					</div>
					
					
					
					<div class="form-group">
						<input type="text" name="phone_number" placeholder="电话号码" class="form-first-name form-control"
							 id="form-first-name" required="required">
					</div>
					
					
					<div class="form-group">
						<input type="text" name="userName" placeholder="姓名" class="form-last-name form-control" 
							 id="form-last-name" required="required">
					</div>
					
					
					<div class="form-group">
						<input type="text" name="age" placeholder="年龄" class="form-email form-control" id="form-email">
						
					</div>
					
					
					
					<div class="form-group" style="border: 1px solid #ddd; background: #f8f8f8; text-align: left; 
						line-height: 50px; color: #888; -moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px;">
						<label style="opacity:0.85;"> &nbsp;&nbsp;&nbsp;&nbsp;性别：&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<input type="radio" name="gender"  value="男">男&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="gender"  value="女">女
					</div>
					
					
					<div class="form-group">
						<input type="text" name="Email" placeholder="电子邮箱" class="form-email form-control" id="form-email">
					</div>
					
					
					
					<div class="form-group">
						<input type="text" name="ID" placeholder="身份证号（选填）" class="form-email form-control" id="form-email">
					</div>
					
					<div class="form-group">
						<input type="password" name="pwd" placeholder="密码" class="form-email form-control" id="pwd">
					</div>
					
					
					<div class="form-group">
						<input type="password" name="pwd_check" placeholder="确认密码" 
						class="form-email form-control" id="pwd_check" onkeyup="validate()">
						<span id="noice" ></span>					
					</div>
					
					
					
					<button type="submit" class="btn" id="button">提交</button>
				</form>
				
				
				
				
			</div>
	
		</div>
	
</body>
</html>