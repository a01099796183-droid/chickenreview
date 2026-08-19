<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
    <%
    if (request.getAttribute("storeList") == null) {
        response.sendRedirect("main.do");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="allPage.css"><!-- css파일 불러오기 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>	
	<%@ include file="header.jsp" %>
	
	<!-- 메인 내용 -->
<main class="main-container">
	
	<div class="main-banner">
	
		 <div class="banner-image">
        <a href="storeReview.do?storeId=3c">
            <img src ="images/kyochon.jpg" alt="교촌치킨">
        </a>
	    </div>
	
	    <div class="banner-image">
	        <a href="storeReview.do?storeId=1a">
	             <img src ="images/bhc.jpg" alt="bhc">
	        </a>
	    </div>
	
	    <div class="banner-image">
	        <a href="storeReview.do?storeId=2b">
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
	
    <div class="overflow-auto mainEdge bg-light mt-4">
         <div class="store-list">
         
              <c:forEach var="store" items="${storeList}">
                 <a href="storeReview.do?storeId=${store.storeId}" class="store-link">
                     <div class="store-item">
                         <div class="store-thumb"></div>
                         <div class="store-name">${store.storeName}</div>
                     </div>
                 </a>
             </c:forEach>
             
         </div>
      </div>
</main>

<script>
// 1. 검색창에 글자가 입력될 때마다 실행
$('.search-input').on('input', function() {
    const keyword = $(this).val(); // 입력된 값 가져오기

    // 2. jQuery AJAX 요청
    $.ajax({
        url: 'searchStore.do',
        type: 'GET',
        data: { keyword: keyword }, // 서버로 보낼 데이터
        success: function(html) {
            // 3. 성공하면 .store-list 내부를 결과로 싹 교체
            $('.store-list').html(html);
        },
        error: function(error) {
            console.log("에러 발생: ", error);
        }
    });
});
</script>
	<%@ include file="sideAd.jsp" %>
	<%@ include file="footer.jsp" %>
</body>
	

</html>	