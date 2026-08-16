package ck;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;

import java.io.IOException;
@WebServlet("*.do")
public class ChickenController extends HttpServlet {
   
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String page = "main.jsp";
      String uri = req.getRequestURI(); 
      String requestUri = uri.substring(uri.lastIndexOf("/"), uri.length()); 
      System.out.println("requestUri=" + requestUri); 

      switch (requestUri) {
         case "/main.do":{
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
			Boolean isSuccess = dao.insertUser(user);
		    
		    if (isSuccess) {
		        req.getSession().setAttribute("userId", userId);
		        resp.sendRedirect("login.do"); 
		        return; 
		    } else {
		        req.setAttribute("msg", "회원가입에 실패했습니다.");
		        page = "/signUp.jsp"; 
		    }
		    break;
		}
            
         case "/mypage.do":{
             page = "myPage.jsp";
             break;}

         case "/logout.do":{
             // 로그아웃 시 세션 제거 후 메인 화면으로 이동
             req.getSession().invalidate();
             page = "main.jsp";
             break;}

         case "/storeReview.do":{
             page = "storeReview.jsp";
             break;}
         
         case "/addStore.do":{
            page = "addStore.jsp";
            break;}

         case "/edit.do":{
            page = "edit.jsp";
            break;}

         default:
            page = "main.jsp";
            break;
      } 
      RequestDispatcher rd = req.getRequestDispatcher(page);
      rd.forward(req, resp);
   }
}