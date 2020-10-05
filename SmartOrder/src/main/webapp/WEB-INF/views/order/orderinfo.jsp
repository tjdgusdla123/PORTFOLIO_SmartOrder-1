<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%@ include file="../include/header.jsp"%>

	<!-- navi -->
	<%@ include file="../include/navigation.jsp"%>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<!-- 메인 메뉴 -->
				<div class="post-preview">
					<h2 class="post-title">
						<input class="btn btn-warning btn-xs" type="button"
							name="menusection" id="getmainmenu" value="메인메뉴" /> <input
							class="btn btn-warning btn-xs" type="button" name="menusection"
							id="getdrink" value="음료수" /> <input
							class="btn btn-warning btn-xs" type="button" name="menusection"
							id="getalcohol" value="주류" />
					</h2>
					<hr>
					<div id="menudata">각각의 메뉴를 눌러서 확인해 주세요</div>

					<!-- Modal -->
					<div class="modal fade" id="menuModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">메뉴 상세보기</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body" id="menudiv"></div>
								<div class="modal-footer">
									
									<button type="button" class="btn btn-secondary" data-dismiss="modal">뒤로가기
										</button>
									<button type="button" class="btn btn-primary"
										>메뉴 추가</button>	
								</div>
							</div>
						</div>
					</div>
					
						
					 

				</div>
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
<script src="${pageContext.request.contextPath}/storemenu/js/getmenu.js"></script>
</html>