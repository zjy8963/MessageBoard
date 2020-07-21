<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的留言</title>
	
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
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body style="background: url(img/RainbowTiles.png);">
	<script type="text/javascript">
		function myError(){
			alert("留言失败，详情请咨询管理员！");
		}
		function mySuccess(){
			alert("留言成功！");
		}
		function deleteError(){
			alert("删除留言失败，详情请咨询管理员！");
		}
		function deleteSuccess(){
			alert("删除留言成功！");
		}
	</script>
	
	<%	
		Object obj_note = request.getAttribute("NoteDelete");
		Object obj = request.getAttribute("Note");
		if(obj != null){
			
			if(obj.equals("success...")){
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = mySuccess();</script>
				<%
			}else if(obj.equals("fail...")){
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = myError();</script>
				<%
			}
		}
		if(obj_note != null){
			
			if(obj_note.equals("success...")){
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = deleteSuccess();</script>
				<%
			}else if(obj_note.equals("failed...")){
				%>
				<script type="text/javascript">document.getElementById("").innerHTML = deleteError();</script>
				<%
			}
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
	
	
	
	
	<!-- 分页弄不出来！ -->
	<div style="width:100%; height:700px;">
		${Messages }
		<script>
		    $("#rounded-corner").bootstrapTable({
		        width:300,
		        height:268,
		        pageSize: 3, //每页3条
		        pageNumber: 1,  //第1页
		        pageList: [10,25],   //在使用过程中根据情况调整每页条数.虽然你现在定义的每页3条，但你可以随时调整为10条或25条。
		        cache: false,   //不缓存
		        striped: true,
		        pagination: true,
		        search: false,
		        showRefresh: false,
		        showExport: false,
		        showFooter: true,
		        // exportTypes: ['csv', 'txt', 'xml'],
		        clickToSelect: true,
		    });
	</script>
		
	</div>
	
	
</body>
	


</html>