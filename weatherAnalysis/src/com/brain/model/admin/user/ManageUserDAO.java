package com.brain.model.admin.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.brain.model.login.UserVO;
import com.brain.util.OracleDBUtil;

/**
* @brief 어드민 접속시 어드민 용 데이타 액세스 오브젝트
* @details
* @author "InchangJung"
* @date 2018. 12. 18.
*/
public class ManageUserDAO {

public List<UserVO> selectAllUser() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "select * from userTable order by 1";
		
		UserVO user = null;
		List<UserVO> userlist = new ArrayList<>();
		
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				user = makeUser(rs);
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return userlist;
	}

	private UserVO makeUser(ResultSet rs) throws SQLException {
		
		String id = rs.getString("id");
		String password = rs.getString("password");
		String email = rs.getString("email");
		
		UserVO user = new UserVO(id, password, email);
		return user;
	}

	public int deleteUser(String id) {
		int result = 0;
		String sql = "delete from userTable "
				+ "where id=?";
		Connection conn = OracleDBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
				
		return result;	
	}

	public List<UserVO> selectIdEmail(String id, String email) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from userTable where 1=1 ";
		
		if(!id.equals("0")) sql += " and id=" + "'" + id + "'";
		if(!email.equals("0")) sql += " and email=" + "'" + email + "'";
		
		UserVO user = null;
		List<UserVO> userlist = new ArrayList<>();
		
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				user = makeUser(rs);
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return userlist;
	}

	public UserVO selectById(String userid) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from userTable where id=" + "'" + userid + "'";
		
		UserVO user = null;
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				user = makeUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return user;
	}

	public int updateUser(UserVO user) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update userTable "
				+ " set password=?,email=? where id = ?";
		
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user.getPassword());
			st.setString(2, user.getEmail());
			st.setString(3, user.getId());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
	
		return result;
	}

}
