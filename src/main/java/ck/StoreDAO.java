package ck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.StoreDTO;

public class StoreDAO {

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
}
