<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보</title>

</head>
<body>
	<h3>기훈가게정보</h3>
	<input type = "button" name="menusection" id="getmainmenu" value="메인메뉴"/>
	<input type = "button" name="menusection" id="getalcohol" value="주류"/>
	<input type = "button" name="menusection" id="getdrink" value="음료수"/>
	
	<br/>
	
	<div id="menudata"></div>
	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/storemenu/js/getmenu.js"></script>

</html>