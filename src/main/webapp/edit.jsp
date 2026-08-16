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
	<form action="editAction.do" method="post">
		<table class="table table-bordered text-center align-middle w-50 mx-auto mt-5">
			
			<tr>
				<td class="bg-light fw-bold">회원 정보 수정</td>
			</tr>
			<tr>
		        <td class="bg-light fw-bold" style="width: 20%;">이름</td>
		        <td style="width: 50%;">
		            <input type="text" name="userName" class="form-control">
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">ID</td>
		        <td style="width: 50%;">
		            <input type="text" name="userId" class="form-control">
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">PW</td>
		        <td style="width: 50%;">
		            <input type="text" name="userPw" class="form-control">
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">주소</td>
		        <td style="width: 50%;">
		            <input type="text" name="userAddress" class="form-control">
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">전화번호</td>
		        <td style="width: 50%;">
		            <input type="text" name="userPhone" class="form-control">
		        </td>
		    </tr>
		</table>
	</form>

</body>
</html>