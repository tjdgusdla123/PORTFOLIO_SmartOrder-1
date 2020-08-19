<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/register.css">
</head>
<body>
	<h1>회원정보 수정</h1>
	<div class="inner_login">
		<div class="login_myweb">
			<div id="msg" class="msg"></div>
			<form method="post" id="registerform">
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="membernickname" class="screen_out">닉네임</label> <input
								type="text" id="membernickname" name="membernickname" placeholder="변경할 닉네임을 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="memberemail" class="screen_out">이메일</label> <input
								type="email" id="memberemail" name="memberemail" value="${storememberinfo.storememberemail}" readonly="readonly">
						</div>
						<div class="inp_text">
							<label for="memberpassword" class="screen_out">비밀번호</label> <input
								type="password" id="memberpassword" name="memberpassword"
								placeholder="변경할 비밀번호를 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="memberpasswordcheck" class="screen_out">비밀번호</label> <input
								type="password" id="memberpasswordcheck" 
								placeholder="변경할 비밀번호를 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="memberphonenumber" class="screen_out">핸드폰번호</label> <input
								type="text" id="memberphonenumber" name="memberphonenumber" placeholder="변경할 핸드폰번호를 입력하세요!">
						</div>
					</div>
					<button type="button" class="btn_login" id="registerbtn">회원정보 수정</button>
					
					<div class="login_append" align="center">
						<a href="${pageContext.request.contextPath}/" class="link_find">메인으로</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/member/js/update.js"></script>
</html>