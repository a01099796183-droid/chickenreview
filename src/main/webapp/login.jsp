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
	
	
	<!-- align-middle(세로 중앙 정렬), w-50(화면 절반 크기), mx-auto(가운데 정렬) -->
<table class="table table-bordered text-center align-middle w-50 mx-auto mt-5">
    
    <tr>
        <td class="bg-light fw-bold" style="width: 20%;">ID</td>
        <td style="width: 50%;">
            <input type="text" name="id" class="form-control" placeholder="아이디">
        </td>
        <td rowspan="2" style="width: 30%;">
            <button class="btn btn-primary w-100 h-100 fs-5 fw-bold">로그인</button>
        </td>
    </tr>

    <tr>
        <td class="bg-light fw-bold">PW</td>
        <td>
            <input type="password" name="pw" class="form-control" placeholder="비밀번호">
        </td>
    </tr>

    <!-- 회원가입 -->
    <tr>
        <td colspan="3" class="bg-light py-2">
            <a href="signUp.jsp" class="text-decoration-none text-dark fw-bold">회원가입</a>
        </td>
    </tr>
    
</table>
	
</body>
</html>