<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="index.html">배기훈 포트폴리오</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/">홈</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="kihooninfomation">스마트오더</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/board/list">게시판</a>
					</li>	
				<c:if test="${storememberinfo.result == null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/user/login">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/user/register">회원가입</a></li>
					
				</c:if>
				<c:if test="${storememberinfo.result == true}">

					<!-- member.verify  이부분은 아직 미완성 -->
					<c:if test="${member.verify == 9}">
						<li><a href="/admin/index">관리자 화면</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="/shop/cartList">카트</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/shop/orderList">주문내역</a></li>
					
					<li class="nav-item"><a class="nav-link" href="/user/update">회원정보수정</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/user/secession">회원탈퇴</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/user/signout">로그아웃</a>
					</li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>
