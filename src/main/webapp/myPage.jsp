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
	
	<table class="table table-bordered text-center align-middle w-50 mx-auto mt-5">
        <tr>
            <td class="bg-light p-0">
                <a href="edit.do" class="btn btn-outline-dark w-100 py-3 fw-bold fs-5 text-decoration-none rounded-0 border-0">
                    회원 정보 수정
                </a>
            </td>
        </tr>
        <tr>
            <td class="bg-light p-0">
                <a href="addStore.do" class="btn btn-outline-dark w-100 py-3 fw-bold fs-5 text-decoration-none rounded-0 border-0">
                    지점 추가 신청
                </a>
            </td>
        </tr>
	</table>
	

</body>
</html>