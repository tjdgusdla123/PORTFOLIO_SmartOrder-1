<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<header class="masthead" style="background-image: url('${pageContext.request.contextPath}/bootstrapfile/img/bg-masthead.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Smart Order</h1>
            <span class="subheading">
            	<c:if test="${storememberinfo.result == true}">
            	 ${storememberinfo.storemembernickname}님 반갑습니다.<br/><br/>
            	</c:if> 스마트하게 메뉴를 확인하세요</span>
          </div>
        </div>
      </div>
    </div>
  </header>

 

