<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>게시판</title>

<!-- jquery -->
<script
	src="${pageContext.request.contextPath}/bootstrapfile/vendor/jquery/jquery.js"></script>
	
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

	<script src="${pageContext.request.contextPath}/board/js/main.js"></script>
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
							게시판에 오신걸 환영합니다.</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- navi -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">게시판</a>
			<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/">홈</a></li>
					<li class="nav-item"><a class="nav-link" href="/smartorder/about">스마트오더</a></li>
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
						<li class="nav-item"><a class="nav-link" href="/board/write">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="#">내글보기</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
						</li>
					</c:if>

				</ul>
			</div>
		</div>
	</nav>

	<div class="container" id=getList></div>

	<!-- BoardDetailModal -->
	<div class="modal fade" id="boardDetailModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">게시글 상세보기</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="boardDetail"></div>
				<div class="modal-footer">

					<button type="button" class="btn btn-secondary" data-dismiss="modal">뒤로가기</button>
					<div id=updateModal></div>
					<div id=deleteModal></div>

				</div>
			</div>
		</div>
	</div>

	<!-- BoardUpdateModal -->
	<div class="modal fade" id="boardUpdateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">게시글 수정</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" id="boardUpdateForm" enctype="multipart/form-data">
						<div class="control-group" style="display:none">
							<div class="form-group floating-label-form-group controls">
								<label>글번호</label> <input type="text" class="form-control" placeholder="글번호"
									id="boardNo" name="boardNo" readonly>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="form-group floating-label-form-group controls">
								<label>제목</label> <input type="text" class="form-control" placeholder="제목"
									id="boardTitle" name="boardTitle" required
									data-validation-required-message="제목을 작성해 주세요.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="form-group floating-label-form-group controls">
								<label>내용</label>
								<textarea rows="10" class="form-control" placeholder="글을 작성해 주세요." id="boardContent"
									name="boardContent" required
									data-validation-required-message="내용을 작성해주세요."></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="form-group floating-label-form-group controls">
								<label>이미지</label> <input type="file" class="form-control" id="boardFile"
									name="boardFile" accept="image/*">
								<p class="help-block text-danger"></p>
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
									id="boardUpdatePassword" name="memberpassword" required
									data-validation-required-message="비밀번호를 입력해 주세요.">
							</form>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>

				</div>
				<div class="modal-footer">

					<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
					<button id="updateBtn" onclick="boardUpdate()" type="button" class="btn btn-primary">수정
					</button>

				</div>
			</div>
		</div>
	</div>




	<!-- BoardDeleteModal -->
	<div class="modal fade" id="boardDeleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">게시글 삭제</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">글을 삭제하시겠습니까?<br />글을 삭제하면 복구할 수 없습니다.<br /><br />글 삭제를 위해 비밀번호를 입력하세요.<br />
					<div id='pwcheckmsg'></div>
					<form method="post" id="passwordcheckform">
						<input type="password" id="memberpassword" name="memberpassword">
					</form>
				</div>

				<div class="modal-footer">

					<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
					<button type="button" id="deleteBtn" onclick="boardDelete()" class="btn btn-primary">삭제
					</button>

				</div>
			</div>
		</div>
	</div>

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