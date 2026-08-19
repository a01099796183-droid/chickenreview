package dto;

public class ReviewDTO {
	/*
		review_id INT AUTO_INCREMENT PRIMARY KEY, 
    	user_m_id INT NOT NULL,                   
    	store_id VARCHAR(15) NOT NULL,
    	user_review TEXT,
    	user_rating DECIMAL(2,1) NOT NULL,
    	created_at DATETIME DEFAULT CURRENT_TIMESTAMP
	*/
	
	private int reviewId;
	private int userManageId;
	private String storeId;
	private String userReview;
	private double userRating;
	private String createdAt;
	private String userName;

	public String getUserName() {
	    return userName;
	}

	public void setUserName(String userName) {
	    this.userName = userName;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getUserManageId() {
		return userManageId;
	}
	public void setUserManageId(int userManageId) {
		this.userManageId = userManageId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getUserReview() {
		return userReview;
	}
	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}
	public double getUserRating() {
		return userRating;
	}
	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}