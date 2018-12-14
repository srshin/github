package com.brain.weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.brain.util.OracleDBUtil;

/**
 * @brief ���� ��� ������(2015.08~2016.08) DAO
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 12.
 *
 */
public class WeatherDAO {
	
	//selectAll
		public List<WeatherVO> selectAll() {
			List<WeatherVO> allList = new ArrayList<>();
			WeatherVO weather = null;
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			String sql = "select * from weatherTable3 order by oneName, taDate";
			conn = OracleDBUtil.dbConnect();
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while (rs.next()) {
					weather = makeWeather(rs);
					allList.add(weather);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				OracleDBUtil.dbDisconnect(rs, st, conn);
			}
			return allList;
		}
	
	public List<WeatherVO> selectByOneName(String oneName) {
		List<WeatherVO> stnlist = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from weathertable3 where onename = ? order by onename, tadate";
		
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			
			st.setString(1, oneName);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				weather = makeWeather(rs);
				stnlist.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return stnlist;
	}
	
	// makeWeather
	private WeatherVO makeWeather(ResultSet rs) throws SQLException {
		String oneName = rs.getString("oneName");
		double average = rs.getDouble("average");
		double taMax = rs.getDouble("taMax");
		double taMin = rs.getDouble("taMin");
		double rnDay = rs.getDouble("rnDay");
		double sunLight = rs.getDouble("sunLight");

		WeatherVO weathervo = new WeatherVO(oneName, average, taMax, taMin, rnDay, sunLight);
		return weathervo;
	}

}
