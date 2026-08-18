package ck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.StoreDTO;

public class StoreDAO {
	
	 public ArrayList<StoreDTO> getStoreList() {
	        ArrayList<StoreDTO> list = new ArrayList<StoreDTO>();
	        String sql = "SELECT * FROM storelist ORDER BY store_id ASC";
	        
	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	               
	            while(rs.next()) {
	                StoreDTO dto = new StoreDTO();
	                dto.setStoreId(rs.getString("store_id"));
	                dto.setStoreName(rs.getString("store_name"));
	                dto.setStoreAddress(rs.getString("store_address"));
	                dto.setStorePhone(rs.getString("store_phone"));
	                
	                list.add(dto); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        
	        return list; 
	    }
	    

    public StoreDTO getStoreById(String storeId) {

        StoreDTO store = null;

        try (Connection conn = DBUtil.getConnection()) {

            String sql = "SELECT * FROM storeList WHERE store_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, storeId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                store = new StoreDTO();

                store.setStoreId(rs.getString("store_id"));
                store.setStoreName(rs.getString("store_name"));
                store.setStoreAddress(rs.getString("store_address"));
                store.setStorePhone(rs.getString("store_phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return store;
    }
    
    public java.util.List<dto.StoreDTO> searchStores(String keyword) {
        java.util.List<dto.StoreDTO> list = new java.util.ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM storeList WHERE store_name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%"); // 앞뒤에 뭐가 붙든 포함되면 검색
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                dto.StoreDTO s = new dto.StoreDTO();
                s.setStoreId(rs.getString("store_id"));
                s.setStoreName(rs.getString("store_name"));
                list.add(s);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    
}
