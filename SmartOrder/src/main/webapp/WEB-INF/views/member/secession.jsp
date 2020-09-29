<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/member/css/login.css">
</head>
<body>
	<h1>회원탈퇴</h1>
	<div class="inner_login">
		<div class="login_myweb">
			<div id="msg" class="msg"></div>
			<form method="post" id="passwordcheckform">
				<fieldset>
					<legend class="screen_out">회원탈퇴</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="memberpasswordckeck" class="screen_out">비밀번호</label>
							<input type="password" id="memberpassword" name="memberpassword"
								placeholder="비밀번호를 입력하세요!">
						</div>
					</div>
					<button type="button" class="btn_login" id="pwcheckbtn">회원탈퇴</button>
					<div class="login_append"></div>
					<div class="login_append" align="center">
						<a href="../" class="link_find">뒤로가기</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>

	<div id="dialog-update" title="회원탈퇴" style="display: none">
		 
		<p>
			  <span class="ui-icon ui-icon-alert" style="float: left; margin: 12px 12px 20px 0;"></span>회원 탈퇴에
			성공하셨습니다.  
		</p>
	</div>
</body>
<script src="${pageContext.request.contextPath}/member/js/secession.js"></script>
<c:if test="${secession != null }">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

  <script>
	  $(function() {
		$("#dialog-update").dialog({
			resizable : false,
			height : "auto",
			width : 400,
			modal : true,
			buttons : {
				"닫기" : function() {
					$(this).dialog("close");
				},
			}
		});
	});
</script>

</c:if>
</html>
