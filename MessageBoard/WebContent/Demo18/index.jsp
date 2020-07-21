<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>主页</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet" media="all">
<link href="css/animate.min.css" rel="stylesheet" media="all">
<!-- Bootstrap bootstrap-touch-slider Slider Main Style Sheet -->
<link href="css/bootstrap-touch-slider.css" rel="stylesheet" media="all">

<link rel="stylesheet" type="text/css" href="Bar/css/head.css">
<script type="text/javascript" src="Bar/js/jquery-1.12.4.min.js"></script>
<link rel="icon" href="Bar/img/足球.png" type="image/x-icon">

<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="../assets/css/form-elements.css">
<link rel="stylesheet" href="../assets/css/style.css">
<link rel="stylesheet" type="text/css" href="../css/styleSlideBar.css" />


</head>
<body>
	<script type="text/javascript">
			function myNotice1(){
				alert("未登录，请先登录");
			}
			function myNotice2(){
				alert("查看我的留言失败，详情请咨询管理人员！");
			}
		</script>
		<%
			Object obj2 = session.getAttribute("NoteFailed");
			Object obj3 = session.getAttribute("NoteLogin");
			if(obj2 != null){
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = myNotice2();</script>
				<%
			}
			if(obj3 != null){
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = myNotice1();</script>
				<%
			}
		%>
	
	<div class="header">
		<div class="headerinner">
			<ul class="headernav">
				<li class="logo">
				</li>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li><a href="index.jsp">主页</a></li>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li><a href="#" onclick="myNotice1()">看大家</a></li>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li><a href="#" onclick="myNotice1()">写留言</a></li>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li class="list">
						<a>&nbsp;&nbsp;&nbsp;${user.userName }</a>
				</li>
			</ul>
			<!-- 用户登录 -->
			<div class="member">
				<p>用户中心</p>
				<ul>
					<li>
					<!-- 
					<img src="../img/personicon.png" alt="">
					<a href="../userLogin.jsp">用户登录</a>
					-->
					<div class="top-big-link">
						<img src="../img/personicon.png" alt="">
						<a class="launch-modal" href="#"
							data-modal-id="modal-register">用户登录</a>
					</div>
					</li>
					<li>
						<img src="../img/personicon.png" alt="">
						<a href="../register.jsp">用户注册</a>
					</li>
					<li>
						<img src="../img/personicon.png" alt="">
						<a href="../adminLogin.jsp">管理员登录</a>
					</li>
					<li>
						<img src="../img/personicon.png" alt="">
						<a href="../adminRegister.jsp">管理员注册</a>
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
	
	<div id="bootstrap-touch-slider" class="carousel bs-slider fade  
	control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="5000" >

			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
				<li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
				<li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper For Slides -->
			<div class="carousel-inner" role="listbox">

				<!-- Third Slide -->
				<div class="item active">

					<!-- Slide Background -->
					<img src="images/space.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
					<div class="bs-slider-overlay"></div>

					<div class="container">
						<div class="row">
							<!-- Slide Text Layer -->
							<div class="slide-text slide_style_center">
								<h1 data-animation="animated flipInX">来月球</h1>
								<p data-animation="animated lightSpeedIn">留个言~</p>
							</div>
						</div>
					</div>
				</div>
				<!-- End of Slide -->

				<!-- Second Slide -->
				<div class="item">

					<!-- Slide Background   -->
					<img src="images/space6.png" alt="Bootstrap Touch Slider"  class="slide-image"/>
					<div class="bs-slider-overlay"></div>
					<!-- Slide Text Layer -->
					<!-- slide_style_right-->
					<div class="slide-text slide_style_center">
						<h1 data-animation="animated flipInX">霍格沃兹</h1>
						<p data-animation="animated lightSpeedIn">招生了~</p>
					</div>
				</div>
				
				<!--animated: 
					flipInX
					lightSpeedIn
					zoomInLeft
				-- >
				<!-- End of Slide -->

				<!-- Third Slide -->
				<div class="item">
					<!-- Slide Background -->
					<img src="images/space3.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
					<div class="bs-slider-overlay"></div>
					<!-- Slide Text Layer -->
					<div class="slide-text slide_style_center">
						<h1 data-animation="animated flipInX">古灵精怪</h1>
						<p data-animation="animated fadeInRight">发表意见~</p>
					</div>
				</div>
				<!-- End of Slide -->


			</div><!-- End of Wrapper For Slides -->

			<!-- Left Control -->
			<a class="left carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="prev">
				<span class="fa fa-angle-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>

			<!-- Right Control -->
			<a class="right carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="next">
				<span class="fa fa-angle-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>

		</div> <!-- End  bootstrap-touch-slider Slider -->

<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.touchSwipe.min.js"></script>
<script src="js/bootstrap-touch-slider.js"></script>
<script type="text/javascript">
	$('#bootstrap-touch-slider').bsTouchSlider();
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
						
						<form role="form" action="../userLoginServlet" method="post" class="registration-form">
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
		<script type="text/javascript" src="../js/verify.js" ></script>
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
		<script src="../assets/js/jquery.backstretch.min.js"></script>
		<script src="../assets/js/scripts.js"></script>
		
</body>		
</html>
