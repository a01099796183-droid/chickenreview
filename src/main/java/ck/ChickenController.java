package ck;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;

import dto.UserDTO;

=======
>>>>>>> refs/remotes/origin/main
@WebServlet("*.do")
public class ChickenController extends HttpServlet {
   
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String page = "main.jsp";
      String uri = req.getRequestURI(); 
      String requestUri = uri.substring(uri.lastIndexOf("/"), uri.length()); 
      System.out.println("requestUri=" + requestUri); 

<<<<<<< HEAD
	  switch (requestUri) {
         case "/main.do":
=======
      switch (requestUri) {
         case "/main.do":{
>>>>>>> refs/remotes/origin/main
            // 1. 로그인, 회원가입, 지점 보이게
            // 2. 지점 누르면 지점 리뷰페이지 이동
            // 3. 
            page = "main.jsp";
            break;}

         case "/login.do":{
            // 단순 로그인 페이지 이동
            page = "login.jsp";
            break;}
            
         case "/loginAction.do":{
            // 입력한 아이디/비밀번호 객체 추출
            String userId = req.getParameter("userId");
            String userPw = req.getParameter("userPw");
            
            ck.UserDAO dao = new ck.UserDAO();
            boolean isSuccess = dao.loginCheck(userId, userPw);
            
            if(isSuccess == true) {
            	req.getSession().setAttribute("userId", userId);
            	resp.sendRedirect("main.do");
            	return;
            } else {
            	req.setAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
                page = "login.jsp";
            }
            break;}
            // 

         case "/signUp.do":{
            // 단순 회원가입 페이지 이동
            page = "signUp.jsp";
            break;}

     	case "/insertUser.do":{
			// 클라이언트가 입력한 값 추출
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			String userName = req.getParameter("userName");
			String userAddress = req.getParameter("userAddress");
			String userPhone = req.getParameter("userPhone");
			
			// 추출한 값 객체에 저장
			dto.UserDTO user = new dto.UserDTO();
			user.setUserId(userId);
			user.setUserPw(userPw);
			user.setUserName(userName);
			user.setUserAddress(userAddress);
			user.setUserPhone(userPhone);
			
			// DAO 객체 생성
			UserDAO dao = new UserDAO();
			// 매서드 호출
			boolean isSuccess = dao.insertUser(user);
		    if (isSuccess) {
		        resp.sendRedirect("login.do"); 
		        return; 
		    } else {
		        req.setAttribute("msg", "회원가입에 실패했습니다.");
		        page = "/signUp.jsp"; 
		    }
		    break;
		}
            
<<<<<<< HEAD
         case "/myPage.do":
=======
         case "/mypage.do":{
>>>>>>> refs/remotes/origin/main
             page = "myPage.jsp";
             break;}

         case "/logout.do":{
             // 로그아웃 시 세션 제거 후 메인 화면으로 이동
             req.getSession().invalidate();
             page = "main.jsp";
             break;}

<<<<<<< HEAD
         case "/storeReview.do":
             page = "storeReview.jsp";
             break;
             
         case "/addStore.do":
=======
         case "/storeReview.do":{
        	 
        	  // 1. main.jsp에서 보낸 storeId 받기
        	    String storeId = req.getParameter("storeId");

        	    // 2. StoreDAO 객체 생성
        	    StoreDAO dao = new StoreDAO();

        	    // 3. storeId에 해당하는 매장 하나를 DB에서 가져오기
        	    dto.StoreDTO store = dao.getStoreById(storeId);

        	    // 4. 가져온 매장 정보를 request에 저장
        	    req.setAttribute("store", store);

        	    // 5. 리뷰 페이지로 이동
        	    page = "storeReview.jsp";
        	    break;}
         				
         
         case "/addStore.do":{
>>>>>>> refs/remotes/origin/main
            page = "addStore.jsp";
            break;}

         case "/edit.do":{
            page = "edit.jsp";
<<<<<<< HEAD
            break;
            
         case "/editAction.do":
        	 HttpSession session = req.getSession();
        	 
        	 Integer userManageId = (Integer) session.getAttribute("userManageId");
        	 if (userManageId == null) {
        		 resp.setContentType("text/html; charset=UTF-8");
        		 PrintWriter out = resp.getWriter();
        		 out.println("<script>");
        		 out.println("alert('오류가 발생했습니다. 정보를 수정할 수 없습니다.');");
        		 out.println("location.href = 'edit.do';");
        		 out.println("</script>");
        		 out.flush();
        		 return;
        	 }
        	 
        	 String loginUserId = (String) req.getSession().getAttribute("userId");
        
        	 String userName = req.getParameter("userName");
        	 String loginuserPw = req.getParameter("userPw");
             String userAddress = req.getParameter("userAddress");
             String userPhone = req.getParameter("userPhone");
             
             UserDTO user = new UserDTO();
             user.setUserManageId(userManageId);
             user.setUserId(loginUserId); 
             user.setUserName(userName);
             user.setUserPw(loginuserPw);
             user.setUserAddress(userAddress);
             user.setUserPhone(userPhone);
             
             UserDAO userData = new UserDAO();
             int result = userData.updateUser(user);
             
             if (result > 0) {
                 resp.sendRedirect("myPage.do");
                 return;
             } else {
                 resp.sendRedirect("edit.do");
             }
             break;
=======
            break;}
>>>>>>> refs/remotes/origin/main

         default:
            page = "main.jsp";
            break;
      } 
      RequestDispatcher rd = req.getRequestDispatcher(page);
      rd.forward(req, resp);
   }
}