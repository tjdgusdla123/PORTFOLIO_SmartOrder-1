<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/login.css">
</head>
<body>
	<h1>회원정보 수정</h1>
	<div class="inner_login">
		<div class="login_myweb">
			<div id="msg" class="msg"></div>
			<form method="post" id="passwordcheckform" >
				<fieldset>
					<legend class="screen_out">개인정보 수정</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="memberpasswordckeck" class="screen_out">비밀번호</label> <input
								type="password" id="memberpassword" name="memberpassword"
								placeholder="비밀번호를 입력하세요!">
						</div>
					</div>
					<button type="button" class="btn_login" id="pwcheckbtn">회원정보수정</button>
					<div class="login_append">
						
					</div>
					<div class="login_append" align="center">
						<a href="#" class="link_find">아이디 찾기</a>
						<a href="#" class="link_find">비밀번호 찾기</a>
						<a href="../" class="link_find">뒤로가기</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/member/js/pwcheck.js"></script>
</html>
