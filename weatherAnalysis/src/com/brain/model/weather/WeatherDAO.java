package com.brain.model.weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.brain.util.OracleDBUtil;

/**
 * @brief 기상 관측 자료 도출 DAO
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 11.
 *
 */
public class WeatherDAO {

	// 전체 조회
	public List<WeatherVO> selectAll() {
		
		List<WeatherVO> allList = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select oneName, substr(taDate,1,4) year ,substr(taDate,6,2) month, average, taMax, taMin, rnDay, sunLight,o.UNITOUTPUT "
				+ " from weathertable3 w join oniontable o on w.onename = o.region " 
				+ " where w.onename = o.region and substr(w.tadate,1,4)= o.year";
		conn = OracleDBUtil.dbConnect();
		//System.out.println(sql);
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
		//System.out.println(allList);
		return allList;
	}

	// 지역명 추출
	public List<WeatherVO> distinctOneName() {
		
		List<WeatherVO> oneNameList = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select distinct oneName from weathertable3 order by 1";
		conn = OracleDBUtil.dbConnect();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				weather = new WeatherVO();
				weather.setOneName(rs.getString(1));
				oneNameList.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return oneNameList;
	}

	
	// 지역명과 기상조건에 따른 조건 조회
	public List<WeatherVO> resultList(String oneName,String condition) {
		
		List<WeatherVO> resultList = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql1 = " select w.oneName, substr(w.taDate,1,4) year, substr(w.taDate,6,2) month, o.unitoutput, " ;
		String sql2 = " from weathertable3 w full outer join oniontable o on w.oneName = o.region and substr(w.taDate,1,4)=o.year  "
					+ " where w.onename = ? order by 1";
					
		sql1 += condition;
		
		String sql = sql1 + sql2;
		System.out.println(sql);
		
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			System.out.println("지역명:"+ oneName);
			st.setString(1, oneName);

			rs = st.executeQuery();
			
			double average = 0;
			double taMax = 0;
			double taMin = 0;
			double rnDay = 0;
			double sunLight = 0;

			while (rs.next()) {
				
					if(condition.equals("average")) {
						average = rs.getDouble(condition);
					} else if (condition.equals("taMax")) {
						taMax = rs.getDouble(condition);
					} else if (condition.equals("taMin")) {
						taMin = rs.getDouble(condition);
					} else if (condition.equals("rnDay")) {
						rnDay = rs.getDouble(condition);
					} else if(condition.equals("sunLight")) {
						sunLight = rs.getDouble(condition);
					} 
				
					//System.out.println(unitOutput);
				weather = new WeatherVO(oneName, rs.getString("year"), rs.getString("month"), average, taMax, taMin, rnDay, sunLight, rs.getInt("unitOutput"));
				resultList.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		//System.out.println("resultList:"+ resultList);
		return resultList;
	}

	// makeWeather
	private WeatherVO makeWeather(ResultSet rs) throws SQLException {
		String oneName = rs.getString("oneName");
		String year = rs.getString("year");
		String month = rs.getString("month");
		double average = rs.getDouble("average");
		double taMax = rs.getDouble("taMax");
		double taMin = rs.getDouble("taMin");
		double rnDay = rs.getDouble("rnDay");
		double sunLight = rs.getDouble("sunLight");
		int unitOutput = rs.getInt("unitOutput");
		
		WeatherVO weathervo = new WeatherVO(oneName, year, month, average, taMax, taMin, rnDay, sunLight, unitOutput);
		return weathervo;
	}

}
