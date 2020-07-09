<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jsp를 이용해서 데이터를 출력할 때는 이 코드는 거의 필수 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
	<div align="center" class="body">
		<h2>회원 정보</h2>
		<table border ="1">
			<tr class="header">
				<th width="80">회원 닉네임</th>
				<th width="200">회원 이메일</th>
				<th width="150">회원 전화번호</th>
			</tr>
			<c:forEach var="storemember" items="${list}">
				<tr class="record">
					<td width="80"><a href="detail/${storemember.memberNickname}">${storemember.memberNickname}</a></td>
					<td width="80">${storemember.memberEmail}</td>
					<td width="80" align="right">${storemember.memberPhoneNumber}</td>
				</tr>	
			</c:forEach>
		</table>
	</div>
</body>
</html>