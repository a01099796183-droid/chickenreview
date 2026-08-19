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
	
<form action="loginAction.do" method="post">
	<!-- align-middle(세로 중앙 정렬), w-100(화면 절반 크기), mx-auto(가운데 정렬) -->
	<table class="table table-bordered text-center align-middle w-100 mx-auto mt-4">
	    
	    <tr>
	        <td class="bg-light fw-bold" style="width: 20%;">ID</td>
	        <td style="width: 50%;">
	            <input type="text" name="userId" class="form-control" placeholder="아이디" tabindex="1">
	        </td>
	        <td rowspan="2" style="width: 30%;">
	            <input type="submit" value="로그인" class="btn login-submit-btn w-100 h-100 fs-5 fw-bold" tabindex="3">
	        </td>
	    </tr>
	
	    <tr>
	        <td class="bg-light fw-bold">PW</td>
	        <td>
	            <input type="password" name="userPw" class="form-control" placeholder="비밀번호" tabindex="2">
	        </td>
	    </tr>
	
	    <tr>
	        <td colspan="3" class="bg-light py-2">
	        	<a href="signUp.do" class="text-decoration-none signup-link fw-bold">회원가입</a>
	        </td>
	    </tr>
	    
	</table>
</form>

</body>
</html>