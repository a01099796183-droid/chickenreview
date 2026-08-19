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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dto.ReviewDTO;
import dto.StoreDTO;
import dto.UserDTO;

@WebServlet("*.do")
public class ChickenController extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = "main.jsp";
		String uri = req.getRequestURI();
		String requestUri = uri.substring(uri.lastIndexOf("/"), uri.length());
		System.out.println("requestUri=" + requestUri);

		switch (requestUri) {
		case "/main.do":
	           StoreDAO storeDao = new StoreDAO();
	           ArrayList<StoreDTO> storeList = storeDao.getStoreList();
	           req.setAttribute("storeList", storeList);
	           page = "main.jsp";
	           break;
		

		case "/login.do": {
			// 단순 로그인 페이지 이동
			page = "login.jsp";
			break;
		}

		case "/loginAction.do": {
			// 입력한 아이디/비밀번호 객체 추출
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");

			ck.UserDAO dao = new ck.UserDAO();
			boolean isSuccess = dao.loginCheck(userId, userPw);

			if (isSuccess == true) {
				req.getSession().setAttribute("userId", userId);
				resp.sendRedirect("main.do");
				return;
			} else {
				req.setAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
				page = "login.jsp";
			}
			break;
		}
		//

		case "/signUp.do": {
			// 단순 회원가입 페이지 이동
			page = "signUp.jsp";
			break;
		}

		case "/insertUser.do": {
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

		case "/myPage.do": {
			page = "myPage.jsp";
			break;
		}

		case "/logout.do": {
			// 로그아웃 시 세션 제거 후 메인 화면으로 이동
			req.getSession().invalidate();
			page = "main.jsp";
			break;
		}

		case "/storeReview.do": {

			String storeId = req.getParameter("storeId");

			// 매장 정보
			StoreDAO storedao = new StoreDAO();
			dto.StoreDTO store = storedao.getStoreById(storeId);

			// 리뷰 목록
			ReviewDAO reviewdao = new ReviewDAO();
			List<dto.ReviewDTO> reviewList = reviewdao.getReviewByStoreId(storeId);

			System.out.println("리뷰 개수 = " + reviewList.size());

			// jsp에 전달
			req.setAttribute("store", store);
			req.setAttribute("reviewList", reviewList);

			page = "storeReview.jsp";
			break;
		}

		case "/reviewForm.do": {
		    
		    String storeId = req.getParameter("storeId");

		    req.setAttribute("storeId", storeId);

		    page = "reviewForm.jsp";
		    
		    break;
		}
		
		case "/reviewInsert.do": {

		    // 1. 리뷰 작성폼에서 값 받기
		    String storeId = req.getParameter("storeId");
		    String rating = req.getParameter("rating");
		    String content = req.getParameter("content");

		    // 2. 현재 로그인한 아이디 가져오기
		    String userId =
		        (String) req.getSession().getAttribute("userId");

		    // 3. 아이디로 회원정보 가져오기
		    UserDTO user = UserDAO.getUserById(userId);

		    // 4. 리뷰 객체 만들기
		    ReviewDTO review = new ReviewDTO();

		    // 5. 리뷰 객체에 값 넣기
		    review.setUserManageId(user.getUserManageId());
		    review.setStoreId(storeId);
		    review.setUserReview(content);
		    review.setUserRating(Double.parseDouble(rating));

		    // 6. DB에 리뷰 저장
		    ReviewDAO.insert(review);

		    // 7. 해당 가게 리뷰 페이지로 돌아가기
		    resp.sendRedirect("storeReview.do?storeId=" + storeId);
		    return;
		}
		

		case "/edit.do": {
			String userId = (String) req.getSession().getAttribute("userId");
			UserDTO user = UserDAO.getUserById(userId);
		    req.setAttribute("user", user);
			page = "edit.jsp";
			break;
		}
		
		case "/editAction.do" : {
		    
			// 1. JSP에서 수정한 값 받기	
			String userName = req.getParameter("userName");
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			String userAddress = req.getParameter("userAddress");
			String userPhone = req.getParameter("userPhone");
			
			// 2. 회원 객체 만들기
			UserDTO user = new UserDTO();
			
			 // 3. 객체에 수정된 정보 넣기
			user.setUserName(userName);
			user.setUserId(userId);
			user.setUserPw(userPw);
			user.setUserAddress(userAddress);
			user.setUserPhone(userPhone);
			
			UserDAO.update(user);

			page = "myPage.jsp";
			
		    break;
		}
		case "/searchStore.do": {
		    String keyword = req.getParameter("keyword");
		    StoreDAO dao = new StoreDAO();
		    // 1. 키워드로 DB 조회 (DAO에 검색용 메서드 필요)
		    List<dto.StoreDTO> searchList = dao.searchStores(keyword);
		    
		    // 2. 응답으로 보낼 HTML 코드를 직접 생성 (JSP를 거치지 않고 직접 출력)
		    resp.setContentType("text/html; charset=UTF-8");
		    PrintWriter out = resp.getWriter();
		    
		    for (dto.StoreDTO store : searchList) {
		        out.println("<a href='storeReview.do?storeId=" + store.getStoreId() + "' class='store-link'>");
		        out.println("    <div class='store-item'>");
		        out.println("        <div class='store-thumb'></div>");
		        out.println("        <div class='store-name'>" + store.getStoreName() + "</div>");
		        out.println("    </div>");
		        out.println("</a>");
		    }
		    return; // 끝! (페이지 전환 없음)
		}

		case "/remove.do": {
			page = "remove.jsp";
			break;
		}
		
		case "/removeAction.do": {
			
			//세션에서 로그인된 userId 가져오기
			HttpSession session = req.getSession(false);
			
			String userId = (session != null) ? (String) session.getAttribute("userId") : null;
			String userPw = req.getParameter("userPw");
			
			System.out.println("전송된 ID: " + userId + " / PW: " + userPw);
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			// 세션이 만료되었거나 로그인되어 있지 않은 경우
		    if (userId == null || userId.trim().isEmpty()) {
		        out.println("<script>");
		        out.println("  alert('로그인 정보가 유효하지 않습니다. 다시 로그인해 주세요.');");
		        out.println("  location.href = 'login.jsp';");
		        out.println("</script>");
		        out.flush();
		        return;
		    }
			
		    ck.UserDAO dao = new ck.UserDAO();
		    
		    boolean isDeleted = dao.deleteUser(userId, userPw);
		    
			if (!isDeleted) {
		        //비밀번호가 틀린 경우
		        out.println("<script>");
		        out.println("  alert('비밀번호가 일치하지 않습니다.');");
		        out.println("  history.back();"); // 이전 페이지로 이동
		        out.println("</script>");
		        out.flush();
		       
		        return;
		    }
			//비밀번호가 올바른 경우(탈퇴 성공 시 기존 세션 파기)
		    session.invalidate();

		    out.println("<script>");
		    out.println("  alert('회원 탈퇴가 정상적으로 완료되었습니다.');");
		    out.println("  location.href = 'login.jsp';");
		    out.println("</script>");
		    out.flush();
		    return;
		}
		
		default:
			page = "main.jsp";
			break;
		}

		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, resp);
	}
}