<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="allPage.css"><!-- css파일 불러오기 -->
</head>
<body>	
	<%@ include file="header.jsp" %>
	
	<!-- 메인 내용 -->
<main class="main-container">
	
	<div class="main-banner">
	
		 <div class="banner-image">
        <a href="#">
            <img src ="images/kyochon.jpg" alt="교촌치킨">
        </a>
	    </div>
	
	    <div class="banner-image">
	        <a href="#">
	             <img src ="images/bhc.jpg" alt="bhc">
	        </a>
	    </div>
	
	    <div class="banner-image">
	        <a href="#">
	             <img src ="images/bbq.jpg" alt="bbq">
	        </a>
  		</div>

	</div>
	
	<div class="search-area">
		
		<input type="text" class="search-input" placeholder="검색창에 입력해주세요">	
		
		<button type="button" class="search-button"> 
			검색
		</button>
	
	</div>
	

	<div class="store-list">
	
		<!-- thum (썸네일의 줄임말 = 대표이미지) -->
		<a href="storeReview.do?storeId=1a" class="store-link">
			 <div class="store-item">
		        <div class="store-thumb"></div>
		        <div class="store-name">BHC 구로디지털점</div>
		    </div>
		</a>
		
		<a href="storeReview.do?storeId=2b" class="store-link">
		    <div class="store-item">
		        <div class="store-thumb"></div>
		        <div class="store-name">BBQ 남구로역점</div>
		    </div>
		</a>
		
		<a href="storeReview.do?storeId=3c" class="store-link">
		    <div class="store-item">
		        <div class="store-thumb"></div>
		        <div class="store-name">교촌치킨 가산디지털점</div>
		    </div>
		</a>
		
		<a href="storeReview.do?storeId=4d" class="store-link">
		    <div class="store-item">
		        <div class="store-thumb"></div>
		        <div class="store-name">60계치킨 서울가산점</div>
		    </div>
		</a>
		 
		<a href="storeReview.do?storeId=5e" class="store-link">
		    <div class="store-item">
		        <div class="store-thumb"></div>
		        <div class="store-name">굽네치킨 가산점</div>
		    </div>
		</a>	
		
	</div>

</main>
	

	<%@ include file="sideAd.jsp" %>
	<%@ include file="footer.jsp" %>
</html>	