package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.MyPageDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class MyPageDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> dto = new ArrayList<MyPageDTO>();

		String sql = "select ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date from user_buy_item_transaction ubit left join item_info_transaction iit on ubit.item_transaction_id = iit.id where ubit.item_transaction_id = ? and ubit.user_master_id = ? order by insert_date desc";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO mpdto = new MyPageDTO();
				mpdto.setId(rs.getString("id"));
				mpdto.setItemName(rs.getString("item_name"));
				mpdto.setTotalPrice(rs.getString("total_price"));
				mpdto.setTotalCount(rs.getString("total_count"));
				mpdto.setPayment(rs.getString("pay"));
				mpdto.setInsert_date(rs.getString("insert_date"));
				dto.add(mpdto);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return dto;

	}

	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{

		String sql = "delete from user_buy_item_transaction where item_transaction_id = ? and user_master_id = ?";

		PreparedStatement ps;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
