<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
</head>
<body>
	<h3>기훈가게정보</h3>
	<input type = "button" name="menusection" id="getmainmenu" value="메인메뉴"/>
	<input type = "button" name="menusection" id="getalcohol" value="주류"/>
	<input type = "button" name="menusection" id="getdrink" value="음료수"/>
	
	<br/>
	
	<div id="menudata"></div>
	
	
	<div id="menudiv" title="메뉴 상세정보"></div>
 
	<!-- <button id="opener">Open Dialog</button> -->
 
 	
 	

</body>
<script src="${pageContext.request.contextPath}/storemenu/js/getmenu.js"></script>
</html>