package com.brain.model.index;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.brain.model.onion.OnionVO;
import com.brain.util.OracleDBUtil;


/**
* @brief 조건별 양파 생산량 도출 로직 DAO
* @details 연별 전국 양파 총 생산량
* @author SangrimShin
* @date 2018. 12. 18.
 */

public class IndexDAO {
	
			public List<IndexVO> selectAll() {
			
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			String sql = "select o.year,area,output,unitOutput, price from onionTable  o , onionPriceTable  p "
                   +" where o.region = '전국' and o.year = p.year "
				   +" order by 1";
			IndexVO vo = null;
			List<IndexVO> list = new ArrayList<>();
			
			conn = OracleDBUtil.dbConnect();
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					String year = rs.getString("year");
					int area = rs.getInt("area");
					int output = rs.getInt("output");
					int unitOutput = rs.getInt("unitOutput");
					int price = rs.getInt("price");
					
					vo = new IndexVO(year, null, area, output, unitOutput, price);
					list.add(vo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				OracleDBUtil.dbDisconnect(rs, st, conn);
			}
			return list;		
		}
		
		
		//지정한 연도에 대한 전국 각 지역의 생산량 
		public List<OnionVO> allRegionbyYear(String year) {
				
				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;
				

				String sql = "select * from ( select  region, area,output,unitOutput from onionTable "
						+ "where region !='전국' and year =? order by  output desc ) where rownum <=6";
				OnionVO onion = null;
				List<OnionVO> list = new ArrayList<>();
				
				conn = OracleDBUtil.dbConnect();
				
				try {
					st = conn.prepareStatement(sql);
					st.setString(1,year);
					rs = st.executeQuery();
					while(rs.next()) {
						String region = rs.getString("region");
						int area = rs.getInt("area");
						int output = rs.getInt("output");
						int unitOutput = rs.getInt("unitOutput");
						onion = new OnionVO(year, region, area, output, unitOutput);
						list.add(onion);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					OracleDBUtil.dbDisconnect(rs, st, conn);
				}
				return list;		
			}
			  
		
}

