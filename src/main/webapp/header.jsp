<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 상단바 조각 파일 -->
<div class="header-backgroud";>
    
    <% String loginUser = (String)session.getAttribute("userId"); %>
    
    <div class="header-right">
    	<a href="main.jsp" class="header-link">홈</a> <!-- 메인로고 제일 오른쪽-->
    <div>
    
    <div class="header-left">
    <% if(loginUser != null){ %>
    	<a href="addStore.jsp" class="header-link">가게 추가</a> <!-- 왼쪽3 -경- -->
    	<a href="myPage.jsp" class="header-link">마이페이지</a> 
    	<a href="logout.jsp" class="header-link">로그아웃</a>  <!-- 로그아웃으로 가야함 -천- -->
    <% }else{ %>
    	<a href="login.jsp" class="header-link">가게 추가</a> <!-- 로그인 안된 상황 -천-  -->
    	<a href="login.jsp" class="header-link">마이페이지</a> 
    	<a href="login.jsp" class="header-link">로그인</a>	<!-- 제일 왼쪽 -천- -->
    <% } %>
    <div>
</div>