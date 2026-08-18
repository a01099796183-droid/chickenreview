<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 상단바 -->
<div class="d-flex justify-content-between align-items-center p-5 border-bottom border-3">
    
    <% String loginUser = (String)session.getAttribute("userId"); %>
    
    <div class="header-left m-3 text-center">
    	<a href="main.do" class="header-link">홈</a> <!-- 메인로고 제일 왼쪽-->
    </div>
    
    <div class="header-right m-3 text-center">
    <% if(loginUser != null){ %>
    	<a href="addStore.do" class="header-link">가게 추가</a> <!-- 왼쪽3 -경- -->
    	<a href="myPage.do" class="header-link">마이페이지</a> 
    	<a href="logout.do" class="header-link">로그아웃</a>  <!-- 로그아웃으로 가야함 -천- -->
    <% }else{ %>
    	<a href="login.do" class="header-link">가게 추가</a> <!-- 로그인 안된 상황 -천- -->
    	<a href="login.do" class="header-link">마이페이지</a>  
    	<a href="login.do" class="header-link">로그인</a>	<!-- 제일 오른쪽 -천- --> 
    <% } %>
    </div>
    
</div>