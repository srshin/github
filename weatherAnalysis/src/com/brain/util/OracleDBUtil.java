package com.brain.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* @brief 오라클 DB연결 유틸
* @details
* @author "InchangJung"
* @date 2018. 12. 11.
*/
public class OracleDBUtil {

	public static Connection dbConnect() {
		Connection conn = null;
		String url="jdbc:oracle:thin:@192.168.2.93:1521:xe";
		String user="brain", password="brain";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver연결");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("db연결완료");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void dbDisconnect(ResultSet rs, Statement st, 
			Connection conn) {
			try {
				if(rs!=null) rs.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
	
}
