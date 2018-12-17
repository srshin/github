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

	// oneName 칼럼명 가져오기
	public List<WeatherVO> distinctOneName() {
		
		List<WeatherVO> oneNameList = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select distinct oneName from weathertable3";
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

	// taDate 칼럼명 가져오기
	public List<WeatherVO> distinctTaDate() {

		List<WeatherVO> taDateList = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select distinct substr(tadate,1,4) taDate from weathertable3 order by 1";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				weather = new WeatherVO();
				weather.setTaDate(rs.getString(1));
				taDateList.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return taDateList;

	}

	// ResultList(조건별 조회)
	public List<WeatherVO> resultList(String oneName, String taDate, String[] col) {
		
		oneName = oneName.equals("전체") ? "%" : oneName;
		taDate = taDate.equals("전체") ? "%" : taDate;

		List<WeatherVO> resultList = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql1 = "select oneName, taDate ";
		String sql2 = " from weathertable3 where oneName like ? and substr(tadate,1,4) like ?";

		for (int i = 0; i < col.length; i++) {
			sql1 += ", " + col[i];
		}

		String sql = sql1 + sql2;
		
		//System.out.println("column:" + col[0]);
		System.out.println("sql:" + sql);
		
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			
			st.setString(1, oneName);
			st.setString(2, taDate);

			rs = st.executeQuery();

			double average = 0;
			double taMax = 0;
			double taMin = 0;
			double rnDay = 0;
			double sunLight = 0;

			while (rs.next()) {
				for (int i = 0; i < col.length; i++) {

					if (col[i].equals("average")) {
						average = rs.getDouble(col[i]);
					} else if (col[i].equals("taMax")) {
						taMax = rs.getDouble(col[i]);
					} else if (col[i].equals("taMin")) {
						taMin = rs.getDouble(col[i]);
					} else if (col[i].equals("rnDay")) {
						rnDay = rs.getDouble(col[i]);
					} else {
						sunLight = rs.getDouble(col[i]);
					}
				}

				weather = new WeatherVO(rs.getString("oneName"), rs.getString("taDate"), 
						average, taMax, taMin, rnDay, sunLight);
				//System.out.println("radiolist: " + weather);
				resultList.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return resultList;
	}

	// makeWeather
	private WeatherVO makeWeather(ResultSet rs) throws SQLException {
		
		String oneName = rs.getString("oneName");
		String taDate = rs.getString("taDate");
		double average = rs.getDouble("average");
		double taMax = rs.getDouble("taMax");
		double taMin = rs.getDouble("taMin");
		double rnDay = rs.getDouble("rnDay");
		double sunLight = rs.getDouble("sunLight");

		WeatherVO weathervo = new WeatherVO(oneName, taDate, average, taMax, taMin, rnDay, sunLight);
		return weathervo;
	}

}
