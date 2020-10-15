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
<title>안녕하세요 배기훈입니다.</title>
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
            	스마트 오더를 소개합니다.</span>
          </div>
        </div>
      </div>
    </div>
  	</header>

	<!-- navi -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">About</a>
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
        <p>프로젝트명 : Smart Order</p>
        <p>수행 : 배기훈 </p>
        <p>프로젝트 소개 : </p>
        <p>메뉴의 변화가 자주 있을 수 있는 식당에서 메뉴판을 가져다 주지 않아도  
            고객이 메뉴를 간편하게 볼 수 있으며 주문할 수 있는 시스템을 만들고 싶었습니다. </p>
        <p>QR코드에는 고객이 방문한 식당이름과 테이블번호가 파라미터로 들어가있습니다.</p>              
        <p>ajax를 이용하여 페이지 이동없이 원하는 메뉴 섹터의 메뉴를 가져올 수 있고, 그것에 대해 ajax를 이용하여  
            모달창에 메뉴의 상세정보를 출력합니다.  
        <p>원하는 메뉴를 카트에 담을 수 있습니다.</p>    
        <p>로그인을 하면 회원정보 수정 및 탈퇴, 로그아웃을 구현했습니다.  
        <p>Kakao API 를 이용하여 위치정보를 받아올 수 있게 구현했습니다.</p>
        
        <p><img src="${pageContext.request.contextPath}/tableImage/기훈이네김밥천국닉네임테이블1번.png" width="500" height="300"></p>
        
        <p>-회원</p>    
        <p>회원가입, 회원정보수정, 회원삭제, 닉네임 중복검사, 로그인 구현</p>
        <p>-게시판</p>
        <p>게시글작성, 게시글전체조회, 게시글상세조회, 게시글상세조회시 조회수 증가, 게시글수정(본인글 선택시), 게시글삭제(본인글 선택시)</p>
        <p>-관리자</p>
        <p>메뉴추가, 메뉴수정, 메뉴삭제, 관리자 회원정보수정 및 회원 탈퇴, 모든 게시판 글의 권한을 부여하여 삭제 구현.</p>
        <p>-메뉴</p>
        <p>메뉴조회</p>
        <p>개발환경 :</p>
        <p>Operating System: Windows 10, Mac OS X</p>
        <p>Database: MySQL </p>
        <p>Web Application Server: Apache Tomcat 9.0</p>
        <p>IDE: STS 3</p>
      	<p>Framework: Spring, MyBatis</p>
      	<p>SCM: Git Hub</p>
      	<p>Test: JUnit</p>
      	<p>Build Tool: Maven</p>
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
</html>