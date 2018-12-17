package com.brain.model.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.brain.util.OracleDBUtil;


/**
* @brief 회원가입, 로그인 용 데이터베이스 접근 유틸
* @details
* @author "InchangJung"
* @date 2018. 12. 11.
*/
public class LoginDAO {

	public int insertUser(UserVO user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into userTable values(?,?,?) ";
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user.getId());
			st.setString(2, user.getPassword());
			st.setString(3, user.getEmail());
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}

		return result;
	}

	public UserVO loginCheck(String id, String password) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from userTable "
				+ "where id=? and password=? ";
		
		UserVO user = null;
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, password);
			
			rs = st.executeQuery();
			if(rs.next()) {
				user = makeUser(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		System.out.println("logincheck:" + user);
		return user;
	}
	
	public AdminVO loginCheck2(String id, String password) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from adminTable "
				+ "where id=? and password=? ";
		
		AdminVO admin = null;
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, password);
			
			rs = st.executeQuery();
			if(rs.next()) {
				admin = makeAdmin(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		System.out.println("logincheck2:" + admin);
		return admin;
	}

	
	
	private AdminVO makeAdmin(ResultSet rs) throws SQLException {
		
		String id = rs.getString(1);
		String password = rs.getString(2);
		String email = rs.getString(3);
		
		AdminVO admin = new AdminVO(id, password, email);
		return admin;
	}

	public UserVO IdCheck(String idc) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from userTable "
				+ "where id=? ";
		UserVO user = null;
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, idc);
			
			rs = st.executeQuery();
			if(rs.next()) {
				user = makeUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	private UserVO makeUser(ResultSet rs) throws SQLException {
		String id = rs.getString(1);
		String password = rs.getString(2);
		String email = rs.getString(3);
		
		UserVO user = new UserVO(id, password, email);
		return user;
	}

}
