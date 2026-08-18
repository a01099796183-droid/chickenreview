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
				<td class="bg-light text-center fw-bold fs-5 py-3" colspan="2">회원 정보 수정</td>
			</tr>
			<tr>
		        <td class="bg-light fw-bold" style="width: 20%;">이름</td>
		        <td style="width: 50%;">
		            <input type="text" name="userName" value="${user.userName}" class="form-control" required>
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">ID</td>
		        <td style="width: 50%;">
		            <input type="text" name="userId" value="${user.userId}" class="form-control" required>
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">PW</td>
		        <td style="width: 50%;">
		            <input type="password" name="userPw" value="${user.userPw}" class="form-control" required>
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">주소</td>
		        <td style="width: 50%;">
		            <input type="text" name="userAddress" value="${user.userAddress}" class="form-control">
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-light fw-bold" style="width: 20%;">전화번호</td>
		        <td style="width: 50%;">
		            <input type="text" name="userPhone" value="${user.userPhone}" class="form-control">
		        </td>
		    </tr>
		    <tr>
		    	<td colspan="2">
                    <button type="submit" class="btn btn-primary w-100">수정</button>
                </td>
            </tr>
		</table>
	</form>

</body>
</html>