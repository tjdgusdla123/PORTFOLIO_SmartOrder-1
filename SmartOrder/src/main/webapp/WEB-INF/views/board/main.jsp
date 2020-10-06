<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
<script
	src="${pageContext.request.contextPath}/board/js/main.js"></script>	
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
            	게시판에 오신걸 환영합니다.</span>
          </div>
        </div>
      </div>
    </div>
  	</header>

	<!-- navi -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">스마트오더</a>
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
						href="/kihooninfomation">스마트오더</a></li>
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
							href="/board/write">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/shop/orderList">글수정</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/update">글삭제</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
						</li>
					</c:if>

				</ul>
			</div>
		</div>
	</nav>
	
	<div id=getList>getlist</div>
	<%-- <table>
		<tr>
			<th width="11%">글번호</th>
			<th width="46%">제목</th>
			<th width="16%">작성자</th>
			<th width="16%">작성일</th>
			<th width="11%">조회수</th>
		</tr>
		<tr>
			<td align="right">${vo.bno}&nbsp;</td>
			<td>&nbsp; ${vo.title}</td>
			<td>&nbsp;${vo.nickname}</td>
			<td>&nbsp; ${vo.dispdate}</td>
			<td align="right"><span class="badge bg-blue">
					${vo.readcnt}</span>&nbsp;</td>
		</tr>
	</table> --%>





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