package dto;

public class StoreDTO {
	/*
		store_id VARCHAR(15) NOT NULL PRIMARY KEY,
    	store_name VARCHAR(50) NOT NULL,          
    	store_address VARCHAR(100),               
    	store_phone VARCHAR(20)
	*/
	
	private String storeId;
	private String storeName;
	private String storeAddress;
	private String storePhone;
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	
	
}