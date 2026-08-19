<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="allPage.css">
</head>
<body>

<h2>리뷰 작성</h2>

<form action="reviewInsert.do?storeId=${storeId}" method="post">

    
    <div class="review-field">
            <label>별점</label>
            <input type="number" name="rating" min="1" max="5"
                   placeholder="1~5">
        </div>

        <div class="review-field">
            <label>리뷰 내용</label>
            <textarea name="content"
                      placeholder="맛은 어떠셨나요? 리뷰를 남겨주세요."></textarea>
        </div>

        <button type="submit" class="review-submit">
            리뷰 등록
        </button>


</form>


</body>
</html>