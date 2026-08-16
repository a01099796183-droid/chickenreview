<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="allPage.css"><!-- css파일 불러오기 -->
</head>
<body>
    <jsp:include page="header.jsp" />
  
<form action="insertUser.do" method="post">
	<!-- align-middle(세로 중앙 정렬), w-50(화면 절반 크기), mx-auto(가운데 정렬) -->
	<table class="table table-bordered text-center align-middle w-50 mx-auto mt-5">
	    
	    <tr>
	        <td class="bg-light fw-bold" style="width: 30%;">ID</td>
	        <td style="width: 70%;">
	            <input type="text" name="userId" class="form-control" placeholder="아이디를 입력해주세요" required>
	        </td>
	    </tr>
	
	    <tr>
	        <td class="bg-light fw-bold">PW</td>
	        <td>
	            <input type="password" name="userPw" class="form-control" placeholder="비밀번호를 입력해주세요" required>
	        </td>
	    </tr>
	    
	    <tr>
	        <td class="bg-light fw-bold">이름</td>
	        <td>
	            <input type="text" name="userName" class="form-control" placeholder="이름을 입력해주세요" required>
	        </td>
	    </tr>
	      
	    <tr>
	        <td class="bg-light fw-bold">주소</td>
	        <td>
	            <input type="text" name="userAddress" class="form-control" placeholder="주소를 입력해주세요">
	        </td>
	    </tr>
	      
	    <tr>
	        <td class="bg-light fw-bold">전화번호</td>
	        <td>
	            <input type="text" name="userPhone" class="form-control" placeholder="전화번호를 입력해주세요">
	        </td>
	    </tr>
	
	    <tr>
	        <td colspan="2" class="bg-light py-3">
	        	<input type="submit" value="회원가입 완료" class="btn btn-primary px-5 fw-bold">
	        	<a href="login.do" class="btn btn-secondary ms-2 fw-bold">취소</a>
	        </td>
	    </tr>
	    
	</table>
</form>
    
</body>
</html>