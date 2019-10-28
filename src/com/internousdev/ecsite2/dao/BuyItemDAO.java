package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private BuyItemDTO dto = new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(){
		String sql = "select id, item_name, item_price, item_stock from item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getInt("item_stock"));

			}

		}catch(Exception e){
			e.printStackTrace();

		}
		return dto;
	}

}
