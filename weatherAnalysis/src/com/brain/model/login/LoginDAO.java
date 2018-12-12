package com.brain.model.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
