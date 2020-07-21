<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理员页面</title>

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
			function myNotice(){
				alert("注册成功！");
			}
		</script>
		
		<%	Object obj = session.getAttribute("NoteRegister");
			if(obj != null){
				if(obj.equals("userRegisterSuccess...")){
					%>
					<script type="text/javascript">document.getElementById("").innerHTML = myNotice();</script>
					<%
				}
			}
		%>
	
	<!-- 这个可确定为用户导航栏！ -->
	<div class="header">
		<div class="headerinner">
			<ul class="headernav">
				<li class="logo"></li>
				<li><a href="userPage.jsp">主页</a></li>
				<li><a href="#"></a></li>
				<li><a href="../messageListServlet">看大家</a></li>
				<li><a href="#"></a></li>
				<li><a href="../leaveMessage.jsp">写留言</a></li>
				<li><a href="#"></a></li>
				<li><a href="../myMessageListServlet">我的留言</a></li>
				<li><a href="#"></a></li>
				<li class="list"><a>&nbsp;&nbsp;&nbsp;${user.userName }</a></li>
			</ul>
			<!-- 用户登录 -->
			<div class="member">
				<p>用户中心</p>
				<ul>
					<li><img src="../img/personicon.png" alt=""> <a href="#">个人信息</a>
					</li>
					<li><img src="../img/personicon.png" alt=""> <a href="#">注销登录</a>
					</li>
					<li><img src="../img/personicon.png" alt=""> <a href="#">关于我们</a>
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
		
</body>		
</html>
