<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
	<li>사이트 소개</li>
	<li>이용약관</li>
	<li>Smart Order</li>
<c:if test="${storememberinfo.result == true}">
	<li>
		<a href="user/secession">회원탈퇴</a>
	</li>
</c:if>	
	
</ul>

