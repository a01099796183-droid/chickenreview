<%@page import="dto.UserDTO"%>
<%@page import="ck.UserDAO"%>
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
	<%
		String userId = (String) session.getAttribute("userId");
	
		UserDAO dao = new UserDAO();
    	UserDTO user = dao.getUserById(userId);
    	
    	String userName = "회원";
    	
    	if (user != null && user.getUserName() != null) {
    	    userName = user.getUserName();
    	}
	%>
<body>z

	<%@ include file="header.jsp" %>
	
	
	<div class="text-center mt-5">
	    <h2 class="fw-bold">
	        <span style="color: #ffb46f;"><%= userName %></span>님 환영합니다!
	    </h2>
	</div>
	
	<table class="table table-borderless text-center align-middle w-50 mx-auto mt-4">
	    <tr>
	        <td class="p-2">
	            <a href="edit.do" class="btn mypage-btn w-100 py-3 fw-bold fs-5 text-decoration-none rounded-2 d-block">
	                회원 정보 수정
	            </a>
	        </td>
	    </tr>
	    <tr>
	        <td class="p-2">
	            <a href="remove.do" class="btn mypage-btn w-100 py-3 fw-bold fs-5 text-decoration-none rounded-2 d-block">
	                회원 탈퇴
	            </a>
	        </td>
	    </tr>
	</table>
	

</body>
</html>