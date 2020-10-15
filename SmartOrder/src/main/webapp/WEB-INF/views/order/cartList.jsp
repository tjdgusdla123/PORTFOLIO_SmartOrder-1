<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>주문 정보</title>

<!-- 테이블 css -->
<style>
	.table-striped>tbody>tr:nth-child(odd)>td, .table-striped>tbody>tr:nth-child(odd)>th
		{
		background-color: #ffc107;
	}
</style>

<!-- jquery -->
<script
	src="${pageContext.request.contextPath}/bootstrapfile/vendor/jquery/jquery.js"></script>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrapfile/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="${pageContext.request.contextPath}/bootstrapfile/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/bootstrapfile/css/clean-blog.min.css"
	rel="stylesheet">

</head>

<body>

	<!-- header -->
	<header class="masthead" style="background-image: url('${pageContext.request.contextPath}/bootstrapfile/img/bg-masthead.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Smart Order</h1>
            <span class="subheading">
            	<c:if test="${storememberinfo.result == true}">
            	 ${storememberinfo.storemembernickname}님 반갑습니다.<br/><br/>
            	</c:if> 카트에 넣은 메뉴를 확인하세요.</span>
          </div>
        </div>
      </div>
    </div>
  	</header>

	<!-- navi -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">카트</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/">홈</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/smartorder/about">스마트오더</a></li>	
						
					<c:if test="${storememberinfo.result == null}">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/board/list">게시판</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/user/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/user/register">회원가입</a></li>

					</c:if>
					
					<c:if test="${storememberinfo.storememberverify == '0'}">
						<li class="nav-item"><a class="nav-link"
							href="/orderinfo/cartlist">카트</a></li>
						<!-- <li class="nav-item"><a class="nav-link"
							href="/#">주문내역</a></li> -->	
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/board/list">게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/update">회원정보수정</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="/user/secession">회원탈퇴</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
						</li>
					</c:if>	
						<!-- 관리자 -->
						<c:if test="${storememberinfo.storememberverify == '9'}">
							<li class="nav-item"><a class="nav-link" href="/admin">관리자</a></li>
							<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
						</c:if>
					

				</ul>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div id=getList>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>

</body>
<!-- Bootstrap core JavaScript -->
<script
	src="${pageContext.request.contextPath}/bootstrapfile/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrapfile/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script
	src="${pageContext.request.contextPath}/bootstrapfile/js/clean-blog.min.js"></script>
<script src="${pageContext.request.contextPath}/cartList/js/cartList.js"></script>
<script src="${pageContext.request.contextPath}/common/js/common.js"></script>
</html>