package com.brain.model.login;

import javax.servlet.http.HttpServletRequest;

/**
* @brief  회원가입, 로그인용 서비스 로직
* @details
* @author "InchangJung"
* @date 2018. 12. 11.
*/
public class LoginService {
	
	LoginDAO dao = new LoginDAO();

	public static UserVO makeUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserVO user = new UserVO(id, password, email);
		return user;
	}

	public int insertUser(UserVO user) {
		
		return dao.insertUser(user);
	}

	public UserVO loginCheck(String id, String password) {
		
		return dao.loginCheck(id, password);
	}

	public UserVO IdCheck(String idc) {
		
		return dao.IdCheck(idc);
	}

	public AdminVO loginCheck2(String id, String password) {
		
		return dao.loginCheck2(id, password);
	}

}
