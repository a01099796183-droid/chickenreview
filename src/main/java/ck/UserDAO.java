package ck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ck.DBUtil;
import dto.UserDTO;

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

			if (rs.next()) {
				isLogin = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return isLogin;
	}

	public boolean insertUser(dto.UserDTO user) {
		boolean isSuccess = false;

		try (Connection conn = DBUtil.getConnection()) { // 디비연결

			String sql = "INSERT INTO userInfor " + "(user_id, user_name, user_pw, user_address, user_phone) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserName());
			psmt.setString(3, user.getUserPw());
			psmt.setString(4, user.getUserAddress());
			psmt.setString(5, user.getUserPhone());

			int result = psmt.executeUpdate();

			if (result > 0) {
				isSuccess = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public static void update(UserDTO user) {

		try {
			Connection conn = DBUtil.getConnection();

			String sql = "UPDATE userInfor " + "SET user_name = ?, user_pw = ?, user_address = ?, user_phone = ? "
					+ "WHERE user_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserAddress());
			pstmt.setString(4, user.getUserPhone());
			pstmt.setString(5, user.getUserId());

			System.out.println("수정하려는 userId = [" + user.getUserId() + "]");

			int result = pstmt.executeUpdate();
			System.out.println("수정된 행 수 = " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static UserDTO getUserById(String userId) {

		UserDTO user = null;

		try {
			Connection conn = DBUtil.getConnection();

			String sql = "SELECT * FROM userInfor WHERE user_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, userId);

		    ResultSet rs = pstmt.executeQuery();
		    
		    if (rs.next()) {

		        user = new UserDTO();

		        user.setUserManageId(rs.getInt("user_m_id"));
		        user.setUserName(rs.getString("user_name"));
		        user.setUserId(rs.getString("user_id"));
		        user.setUserPw(rs.getString("user_pw"));
		        user.setUserAddress(rs.getString("user_address"));
		        user.setUserPhone(rs.getString("user_phone"));
		    }
		   
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}
	
	
	public boolean deleteUser(String userId, String userPw) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    boolean isDeleted = false;

	    try {
	        conn = DBUtil.getConnection();
	        String sql = "DELETE FROM userInfor WHERE user_id = ? AND user_pw = ?";
	        
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, userId);
	        pstmt.setString(2, userPw);

	        int result = pstmt.executeUpdate();
	        if (result > 0) {
	        	if (!conn.getAutoCommit()) {
	                conn.commit();
	            }
	            isDeleted = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if(pstmt != null) pstmt.close(); } catch(Exception e) {}
	        try { if(conn != null) conn.close(); } catch(Exception e) {}
	    }

	    return isDeleted;
	}
	


}