<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/register.css">
</head>
<body>
	<h1>회원가입</h1>
	<div class="inner_login">
		<div class="login_myweb">
			<div id="msg" class="msg"></div>
			<form method="post" id="registerform">
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="membernickname" class="screen_out">닉네임</label> <input
								type="text" id="membernickname" name="membernickname" placeholder="닉네임을 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="memberemail" class="screen_out">이메일</label> <input
								type="email" id="memberemail" name="memberemail" placeholder="이메일을 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="memberpassword" class="screen_out">비밀번호</label> <input
								type="password" id="memberpassword" name="memberpassword"
								placeholder="비밀번호를 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="memberpasswordcheck" class="screen_out">비밀번호</label> <input
								type="password" id="memberpasswordcheck" 
								placeholder="비밀번호를 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="memberphonenumber" class="screen_out">핸드폰번호</label> <input
								type="text" id="memberphonenumber" name="memberphonenumber" placeholder="핸드폰번호를 입력하세요!">
						</div>
					</div>
					<button type="button" class="btn_login" id="registerbtn">회원가입</button>
					
					<div class="login_append" align="center">
						<a href="#" class="link_find">아이디 찾기</a>
						<a href="#" class="link_find">비밀번호 찾기</a>
						<a href="${pageContext.request.contextPath}/" class="link_find">메인으로</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>

<script src="${pageContext.request.contextPath}/member/js/register.js"></script>
</html>