package ck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ck.DBUtil; 

public class UserDAO {
	
	public boolean loginCheck(String userId, String userPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isLogin = false; 
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "SELECT user_id FROM userInfor WHERE user_id = ? AND user_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw); 
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isLogin = true; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}
		}
		
		return isLogin; 
	}
}