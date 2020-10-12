<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>주문 정보</title>

	<!-- 테이블 css -->
	<style>
		.table-striped>tbody>tr:nth-child(odd)>td,
		.table-striped>tbody>tr:nth-child(odd)>th {
			background-color: #ffc107;
		}
		.modal-content{
		overflow-y: initial !important
		}
		.modal-body{
		height: 500px;
		overflow-y: auto;
		}
		
	</style>

	<!-- jquery -->
	<script src="${pageContext.request.contextPath}/bootstrapfile/vendor/jquery/jquery.js"></script>

	<!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/bootstrapfile/vendor/bootstrap/css/bootstrap.min.css"
		rel="stylesheet">

	<!-- Custom fonts for this template -->
	<link href="${pageContext.request.contextPath}/bootstrapfile/vendor/fontawesome-free/css/all.min.css"
		rel="stylesheet" type="text/css">
	<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet'
		type='text/css'>
	<link
		href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
		rel='stylesheet' type='text/css'>

	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/bootstrapfile/css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

	<!-- header -->
	<header class="masthead"
		style="background-image: url('${pageContext.request.contextPath}/bootstrapfile/img/bg-masthead.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading">
						<h1>Smart Order</h1>
						<span class="subheading">
							<c:if test="${storememberinfo.storememberverify == '9'}">
								
								메뉴관리 페이지 입니다.<br /><br />
								메뉴를 선택하면 수정 및 삭제가 가능합니다.
							</c:if>
						</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- navi -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">관리자 메뉴관리</a>
			<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/admin">관리자 홈</a></li>

					<c:if test="${storememberinfo.result == null}">
						<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/user/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/user/register">회원가입</a></li>
					</c:if>
					<!-- 관리자 -->
					<c:if test="${storememberinfo.storememberverify == '9'}">
						<li class="nav-item"><a class="nav-link" href="/admin/info/update">관리자정보수정</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin/info/delete">관리자회원탈퇴</a></li>
						
						<li class="nav-item"><a class="nav-link" href="/admin">뒤로가기</a></li>	
						<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>


	<!-- Main Content -->


	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>

</body>
<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrapfile/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrapfile/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="${pageContext.request.contextPath}/bootstrapfile/js/clean-blog.min.js"></script>
<script src="${pageContext.request.contextPath}/common/js/common.js"></script>

</html>