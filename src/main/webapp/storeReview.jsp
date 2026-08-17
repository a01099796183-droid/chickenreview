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

		
	<div class="storeReview-name">
		<h2>${store.storeName}</h2>
	</div>

	<div class="store-info">	
		<p>${store.storeAddress}</p>
		<p>${store.storePhone}</p>
	</div>




	<!-- input 등록 / 취소 -->
	<!-- dif -->





</body>
</html>