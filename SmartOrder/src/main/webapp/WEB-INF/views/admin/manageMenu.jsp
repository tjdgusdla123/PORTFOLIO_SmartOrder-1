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
						<li class="nav-item"><a class="nav-link" href="/admin/menu/insert">메뉴추가</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin">뒤로가기</a></li>	
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
				<!-- 메인 메뉴 -->
				<div class="post-preview">
					<h2 class="post-title">
						<input class="btn btn-warning btn-xs" type="button" name="menusection" id="getmainmenu"
							value="메인메뉴" /> <input class="btn btn-warning btn-xs" type="button" name="menusection"
							id="getdrink" value="음료수" /> <input class="btn btn-warning btn-xs" type="button"
							name="menusection" id="getalcohol" value="주류" />
					</h2>
					<hr>
					<div id="menudata">각각의 메뉴를 눌러서 확인해 주세요</div>

					<!-- MenuDetailModal -->
					<div class="modal fade" id="menuModal" tabindex="-1" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">메뉴 상세보기</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body" id="menudiv"></div>
								<div class="modal-footer">

									<button type="button" class="btn btn-secondary" data-dismiss="modal">뒤로가기
									</button>
									<div id=updateModal></div>
									<div id=deleteModal></div>
								</div>
							</div>
						</div>
					</div>

					<!-- MenuUpdateModal -->
					<div class="modal fade" id="menuUpdateModal" tabindex="-1" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">메뉴 수정</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form method="post" id="menuUpdateForm" enctype="multipart/form-data">
										<div class="control-group" style="display:none">
											<div class="form-group floating-label-form-group controls">
												<label>메뉴코드</label> <input type="text" class="form-control"
													placeholder="메뉴 코드" id="menuCode" name="menuCode" readonly>
												<p class="help-block text-danger"></p>
											</div>
										</div>
										<div class="control-group">
											<div class="form-group floating-label-form-group controls">
												<label>메뉴 이름</label> <input type="text" class="form-control"
													placeholder="메뉴 이름을 작성해주세요." id="menuName" name="menuName" required
													data-validation-required-message="제목을 작성해 주세요.">
												<p class="help-block text-danger"></p>
											</div>
										</div>
										<div class="control-group">
											<div class="form-group floating-label-form-group controls">
												<label>메뉴 설명</label>
												<textarea rows="5" class="form-control" placeholder="메뉴 설명을 작성해주세요."
													id="menuInfo" name="menuInfo" required
													data-validation-required-message="메뉴 설명을 작성해주세요."></textarea>
												<p id="menuInfoMsg" class="help-block text-danger"></p>
											</div>
										</div>
										<div class="control-group">
											<div class="form-group floating-label-form-group controls">
												<label>메뉴섹션</label>
												<input type="radio" id="menuSectionMain" name="menuSection"
													value="menuSectionMain"> 메인메뉴
												<input type="radio" id="menuSectionDrink" name="menuSection"
													value="menuSectionDrink"> 음료
												<input type="radio" id="menuSectionAlcohol" name="menuSection"
													value="menuSectionAlcohol"> 주류
												<p id="meneSectionMsg" class="help-block text-danger"></p>
											</div>
										</div>
										<div class="control-group">
											<div class="form-group floating-label-form-group controls">
												<label>메뉴 가격</label>
												<input type="text" class="form-control" placeholder="메뉴 가격을 작성해주세요."
													id="menuPrice" name="menuPrice" required
													data-validation-required-message="메뉴 가격을 작성해주세요.">
												<p id="menuPriceMsg" class="help-block text-danger"></p>
											</div>
										</div>
										<div class="control-group">
											<div class="form-group floating-label-form-group controls">

												<label>메뉴 사진</label>
												<input type="file" class="form-control" id="menuImage" name="menuImage"
													accept="image/*">
												<p id="menuImageMsg" class="help-block text-danger"></p>
												<div style="color: red">메뉴 사진파일 이름은 영문또는 숫자로 작성해주세요.</div>
											</div>
										</div>
									</form>

									<div class="control-group">
										<div class="form-group floating-label-form-group controls">
											<div id="updatePasswordCheckmsg"></div>
											<label>비밀번호 확인</label>
											<form method="post" id="updatePasswordcheckform">
												<input type="password" class="form-control" placeholder="비밀번호를 입력해 주세요."
													id="menuUpdatePassword" name="memberpassword" required
													data-validation-required-message="비밀번호를 입력해 주세요.">
											</form>
											<p id="updatePasswordCheckmsg" class="help-block text-danger"></p>
										</div>
									</div>
									<br>

								</div>
								<div class="modal-footer">

									<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
									<button id="updateBtn" onclick="menuUpdate()" type="button"
										class="btn btn-primary">수정
									</button>

								</div>
							</div>
						</div>
					</div>

					<!-- MenuDeleteModal -->
					<div class="modal fade" id="menuDeleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">게시글 삭제</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">글을 삭제하시겠습니까?<br />글을 삭제하면 복구할 수 없습니다.<br /><br />글 삭제를 위해 비밀번호를
									입력하세요.<br />
									<div id='pwcheckmsg'></div>
									<form method="post" id="passwordcheckform">
										<input type="password" id="memberpassword" name="memberpassword">
									</form>
								</div>

								<div class="modal-footer">

									<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
									<button type="button" id="deleteBtn" onclick="menuDelete()"
										class="btn btn-primary">삭제
									</button>

								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>

	<hr>

	<hr>

	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>

</body>
<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrapfile/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrapfile/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="${pageContext.request.contextPath}/bootstrapfile/js/clean-blog.min.js"></script>
<script src="${pageContext.request.contextPath}/storemenu/js/getmenu.js"></script>
<script src="${pageContext.request.contextPath}/common/js/common.js"></script>

</html>