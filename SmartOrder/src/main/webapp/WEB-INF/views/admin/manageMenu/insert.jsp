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
            	<c:if test="${storememberinfo.storememberverify == '9'}">
            	 관리자 ${storememberinfo.storemembernickname}님 반갑습니다.<br/><br/>
            	 메뉴 추가 페이지 입니다.<br/>
            	</c:if></span>
          </div>
        </div>
      </div>
    </div>
  	</header>

	<!-- navi -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/admin/menu/insert">관리자 메뉴 추가</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/admin">관리자 홈</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/menu/insert">메뉴추가</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin/menu">뒤로가기</a></li>					
						<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
						
					
					<c:if test="${storememberinfo.result == null}">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/user/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/user/register">회원가입</a></li>
					</c:if>	
				</ul>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <form method="post" id="insertMenuForm" enctype="multipart/form-data">
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>메뉴 이름</label>
              <input type="text" class="form-control" placeholder="메뉴 이름을 작성해주세요." id="menuName" name="menuName" required data-validation-required-message="메뉴 이름을 작성해주세요.">
              <p id= "menuNameMsg" class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>메뉴 설명</label>
              <textarea rows="10" class="form-control" placeholder="메뉴 설명을 작성해주세요." id="menuInfo" name="menuInfo" required data-validation-required-message="메뉴 설명을 작성해주세요."></textarea>
              <p id= "menuInfoMsg" class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>메뉴섹션</label>
              	<input type="radio" id="menuSectionMain" name="menuSection" value="menuSectionMain" > 메인메뉴
	    		<input type="radio" id="menuSectionDrink" name="menuSection" value="menuSectionDrink" > 음료
	    		<input type="radio" id="menuSectionAlcohol" name="menuSection" value="menuSectionAlcohol" > 주류
              <p id= "meneSectionMsg" class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>메뉴 가격</label>
              <input type="text" class="form-control" placeholder="메뉴 가격을 작성해주세요." id="menuPrice" name="menuPrice" required data-validation-required-message="메뉴 가격을 작성해주세요.">
              <p id= "menuPriceMsg" class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              
              <label>메뉴 사진</label>
              <input type="file" class="form-control"  id="menuImage" name="menuImage" accept="image/*">
              <p id= "menuImageMsg" class="help-block text-danger"></p>
              <div style="color: red" >메뉴 사진파일 이름은 영문또는 숫자로 작성해주세요.</div>	
            </div>
          </div>
          <br>
          <div id="success"></div>
          <button type="button" class="btn btn-primary" id="insertMenuBtn">Send</button>
        </form>
      </div>
    </div>
  </div>

	<hr>

	<!-- footer -->
	<%@ include file="../../include/footer.jsp"%>

</body>
<!-- Bootstrap core JavaScript -->
<script
	src="${pageContext.request.contextPath}/bootstrapfile/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrapfile/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script
	src="${pageContext.request.contextPath}/bootstrapfile/js/clean-blog.min.js"></script>
<script src="${pageContext.request.contextPath}/common/js/common.js"></script>
<script src="${pageContext.request.contextPath}/storemenu/js/insertMenu.js"></script>

</html>