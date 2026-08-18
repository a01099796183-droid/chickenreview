package ck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ReviewDTO;

public class ReviewDAO {

	public List<ReviewDTO> getReviewByStoreId(String storeId) {

		List<ReviewDTO> reviewList = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection()) {
			String sql = "SELECT * FROM reviewList WHERE store_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				ReviewDTO review = new ReviewDTO();

				review.setReviewId(rs.getInt("review_id"));
				review.setUserManageId(rs.getInt("user_m_id"));
				review.setStoreId(rs.getString("store_id"));
				review.setUserReview(rs.getString("user_review"));
				review.setUserRating(rs.getDouble("user_rating"));
				review.setCreatedAt(rs.getString("created_at"));

				reviewList.add(review);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reviewList;

	}
}


