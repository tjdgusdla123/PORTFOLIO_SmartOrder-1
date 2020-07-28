<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<form id = menuform>
	<h3>기훈가게정보<h3><br/>
	<input type = "button" name="menusection" id="getmainmenu" value="메인메뉴"/>
	<input type = "button" name="menusection" id="getalcohol" value="주류"/>
	<input type = "button" name="menusection" id="getdrink" value="음료수"/>
	</form>
	<br/>
	<br/>
	<div id ="menudata">
	정보
	</div>
</body>
<script type="text/javascript"src="${pageContext.request.contextPath}/storemenu/js/getmainmenu.js"></script>
</html>