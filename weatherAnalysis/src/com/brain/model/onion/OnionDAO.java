package com.brain.model.onion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.brain.util.OracleDBUtil;


/**
* @brief 조건별 양파 생산량 도출 로직 DAO
* @details 연별 전국 양파 총 생산량
* @author JungeunPark
* @date 2018. 12. 11.
 */

public class OnionDAO {
	
//연별 전국 양파 총 재배면적,총 생산량, 10a 당 샹산량
	public List<OnionVO> annualTotal() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select year,area,output,unitOutput "
						+ "from onionTable "
						+ "where region = '전국' "
						+ "order by 1";
		OnionVO onion = null;
		List<OnionVO> onionList = new ArrayList<>();
		
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String year = rs.getString("year");
				int area = rs.getInt("area");
				int output = rs.getInt("output");
				int unitOutput = rs.getInt("unitOutput");
				
				onion = new OnionVO(year, area, output, unitOutput);
				onionList.add(onion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return onionList;		
	}

}
