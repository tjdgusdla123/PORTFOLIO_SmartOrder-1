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
<title>게시판 글쓰기</title>
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
	<header class="masthead"
		style="background-image: url('${pageContext.request.contextPath}/bootstrapfile/img/bg-masthead.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading">
						<h1>Smart Order</h1>
						<span class="subheading"> 스마트 오더를 소개합니다.</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- navi -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.html">스마트오더</a>
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
						href="kihooninfomation">스마트오더</a></li>
					<li class="nav-item"><a class="nav-link" href="/board/list">게시판</a>
					</li>
					<c:if test="${storememberinfo.result == null}">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/user/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/user/register">회원가입</a></li>

					</c:if>
					<c:if test="${storememberinfo.result == true}">

						<!-- member.verify  이부분은 아직 미완성 -->
						<c:if test="${member.verify == 9}">
							<li><a href="/admin/index">관리자 화면</a></li>
						</c:if>
						<li class="nav-item"><a class="nav-link"
							href="/shop/cartList">카트</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/shop/orderList">주문내역</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/update">회원정보수정</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="/user/secession">회원탈퇴</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
						</li>
					</c:if>

				</ul>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
        <!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
        <!-- To use the contact form, your site must be on a live web host with PHP! The form will not work locally! -->
        <form method="post" id="boardWriteForm">
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>제목</label>
              <input type="text" class="form-control" placeholder="제목" id="boardTitle" name="boardTitle" required data-validation-required-message="제목을 작성해 주세요.">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>내용</label>
              <textarea rows="10" class="form-control" placeholder="글을 작성해 주세요." id="boardContent" name="boardContent" required data-validation-required-message="내용을 작성해주세요."></textarea>
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <br>
          <div id="success"></div>
          <button type="button" class="btn btn-primary" id="boardWriteBtn">Send</button>
        </form>
      </div>
    </div>
  </div>

	<hr>
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
	<script
		src="${pageContext.request.contextPath}/board/js/write.js"></script>	
		
</html>