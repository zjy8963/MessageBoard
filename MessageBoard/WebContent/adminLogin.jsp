<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>

	<link rel="stylesheet" type="text/css" href="css/head.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="icon" href="img/足球.png" type="image/x-icon">
	
	<script src="js/jquery-1.11.3.js"></script>
	<link rel="stylesheet" type="text/css" href="css/styleSlideBar.css" />
</head>
<body>
	
	<script type="text/javascript">
			function myNotice(){
				alert("未登录，请先登录！");
			}
	</script>
	<!-- 滑动验证长度需要另外调 -->
	<!-- 右上角人像显示ID名，或显示admin已登录 -->
		<div class="header">
			<div class="headerinner">
				<ul class="headernav">
					<li class="logo">
					</li>
					<li><a href="Demo18/index.jsp">主页</a></li>
					<li><a href="#"></a></li>
					<li><a href="#" onclick="myNotice()">留言管理</a></li>
					<li><a href="#"></a></li>
					<li><a href="#">评论管理</a></li>
					<li><a href="#"></a></li>
					<li><a href="#" onclick="myNotice()">用户管理</a></li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li class="list">
						<a>	&nbsp;&nbsp;&nbsp;${admin.id }</a>
					</li>
					
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
		
		
		
		<div style="background: url(img/sunset.png); height: 660px; width: 100%; opacity: 0.75;">
			<div class="modal-body" style="position: absolute; top: 90px; left: 330px;  width: 50%; height: 86%; opacity: 0.9;">
			
				
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
				
				
				
				<form role="form" action="adminLoginServlet" method="post" class="registration-form" name="my_form">
					
					<div class="form-group">
						<label> ${Note } </label>
						<h1 class="modal-title" id="modal-register-label">管理员登录</h1>
						<label>每一个admin都有超能力~</label>
					</div>
					
					<div class="form-group">
						<input type="text" name="id" placeholder="ID号码" class="form-first-name form-control"
							 id="form-first-name" required="required">
					</div>
					
					<div class="form-group">
						<input type="text" name="keyWord" placeholder="动态密钥" class="form-email form-control" id="form-email">
					</div>
					
					<div class="form-group">
						<input type="password" name="pwd" placeholder="密码" class="form-email form-control" id="pwd">
					</div>
					
					<!-- 滑动验证 -->
					<div id="mpanel1" class="form-group" >
					</div>
					
					<button type="submit" class="btn" id="button">提交</button>
				</form>
				
			</div>
	
		</div>
	
	
	
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/verify.js" ></script>
		<script>
		
			$('#mpanel1').slideVerify({
				type : 1,		//类型
				vOffset : 8,	//误差量，根据需求自行调整
				barSize : {
					width : '98%',
					height : '60px',
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