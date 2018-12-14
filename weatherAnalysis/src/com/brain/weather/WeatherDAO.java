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
 * @brief 기상 관측 자료(2015~2016) 도출 DAO
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 14.
 *
 */
public class WeatherDAO {

	// selectAll
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

	// selectByOneName
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

			while (rs.next()) {
				weather = makeWeather(rs);
				stnlist.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stnlist;
	}

	public List<WeatherVO> distinctOneName() {

		List<WeatherVO> onenameList = new ArrayList<>();
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
				weather = new WeatherVO(rs.getString(1));
				onenameList.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return onenameList;
	}

	public List<WeatherVO> radioList(String[] col) {
		List<WeatherVO> radiolist = new ArrayList<>();
		WeatherVO weather = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql1 = "select oneName ";
		String sql2 = " from weathertable3 where oneName = ?";

		for (int i = 1; i < col.length; i++) {
			sql1 += ", " + col[i];
		}

		System.out.println("column:" + col[0]);
		String sql = sql1 + sql2;
		System.out.println("sql:" + sql);
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, col[0]);
			rs = st.executeQuery();

			String taDate = null;
			double average = 0;
			double taMax = 0;
			double taMin = 0;
			double rnDay = 0;
			double sunLight = 0;

			while (rs.next()) {

				for (int i = 1; i < col.length; i++) {

					if (col[i].equals("taDate")) {
						taDate = rs.getString(col[i]);
					} else if (col[i].equals("average")) {
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

				weather = new WeatherVO(col[0], taDate, average, taMax, taMin, rnDay, sunLight);
				System.out.println("weather: " + weather);
				radiolist.add(weather);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return radiolist;
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
