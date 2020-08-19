<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
<li>
<p id ="addr"></p>
</li>
<c:if test="${storememberinfo.result == null}">
	<li>
		<a href="${pageContext.request.contextPath}/user/login">로그인</a>
	</li>
	<li>
		<a href="${pageContext.request.contextPath}/user/register">회원가입</a>
	</li>
</c:if>
<c:if test="${storememberinfo.result == true}">

<!-- member.verify  이부분은 아직 미완성 -->
<c:if test="${member.verify == 9}">
<li>
	<a href="/admin/index">관리자 화면</a>	
</li>	
</c:if>

	<li>
		${storememberinfo.storemembernickname}님 환영합니다.
	</li>
	<li>
		<a href="/shop/cartList">카트 리스트</a>
	</li>
	<li>
		<a href="/shop/orderList">주문 리스트</a>
	</li>
	<li>
		<a href="/shop/orderList">게시판</a>
	</li>
	<li>
		<a href="user/update">회원정보수정</a>
	</li>
	<li>
		<a href="user/signout">로그아웃</a>
	</li>
</c:if>

</ul>

<script>
setInterval(function() {
	navigator.geolocation.getCurrentPosition(function(position) {
		var loc = position.coords.latitude + ":" + position.coords.longitude
		$.ajax({
			url:"address",
			data:{"loc":loc},
			dataType:"json",
			success:function(data){
				document.getElementById('addr').innerHTML= "현재위치:" + data.address			}
		});
	});
}, 10000)
</script>
