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
	
	
	
	
	<!-- 轮播图 -->
	<link href="RotationChart/css/bootstrap.min.css" rel="stylesheet">
	<link href="RotationChart/css/font-awesome.min.css" rel="stylesheet" >
	<link href="RotationChart/css/animate.min.css" rel="stylesheet" >
	<!-- Bootstrap bootstrap-touch-slider Slider Main Style Sheet -->
	<link href="RotationChart/css/bootstrap-touch-slider.css" rel="stylesheet" >
	
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

				
		
		
		<!-- 轮播图 -->
		
		<div id="bootstrap-touch-slider" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="5000" >

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
					<img src="images/slide1.png" alt="Bootstrap Touch Slider"  class="slide-image"/>
					<div class="bs-slider-overlay"></div>

					<div class="container">
						<div class="row">
							<!-- Slide Text Layer -->
							<div class="slide-text slide_style_left">
								<h1 data-animation="animated zoomInRight">兴趣</h1>
								<p data-animation="animated fadeInLeft">是最好的老师！</p>
							</div>
						</div>
					</div>
				</div>
				<!-- End of Slide -->

				<!-- Second Slide -->
				<div class="item">

					<!-- Slide Background   -->
					<img src="images/Take_OFF.png" alt="Bootstrap Touch Slider"  class="slide-image"/>
					<div class="bs-slider-overlay"></div>
					<!-- Slide Text Layer -->
					<!-- slide_style_right-->
					<div class="slide-text slide_style_center">
						<h1 data-animation="animated flipInX">努力</h1>
						<p data-animation="animated lightSpeedIn">让每一天更有意义！</p>
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
					<img src="images/Bombillos.png" alt="Bootstrap Touch Slider"  class="slide-image"/>
					<div class="bs-slider-overlay"></div>
					<!-- Slide Text Layer -->
					<div class="slide-text slide_style_center">
						<h1 data-animation="animated flipInX">晚安</h1>
						<p data-animation="animated fadeInRight">让世界亲吻你的梦~</p>
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