<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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

	
<c:forEach var="review" items="${reviewList}">

    <div class="review-item">

        <div class="review-user">
            ${review.userName}
        </div>

        <div class="review-rating">
            ★ ${review.userRating}
        </div>

        <div class="review-content">
            ${review.userReview}
        </div>

    </div>

</c:forEach>
	<div class="text-center mt-4">

    <input type="button" class="btn btn-primary" value="리뷰 추가"
     onclick="location.href='reviewForm.do?storeId=${store.storeId}'">
  

</div>





</body>
</html>