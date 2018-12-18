package com.brain.model.admin.user;

import java.util.List;

import com.brain.model.login.UserVO;

/**
* @brief 어드민 접속시 어드민용 비즈니스 로직
* @details
* @author "InchangJung"
* @date 2018. 12. 18.
*/
public class ManageUserService {

	ManageUserDAO dao = new ManageUserDAO();

	public List<UserVO> selectAllUser() {
		
		return dao.selectAllUser();
		
	}

	public int deleteUser(String id) {
		
		return dao.deleteUser(id);
	}

	public List<UserVO> selectIdEmail(String id, String email) {
		
		return dao.selectIdEmail(id, email);
	}

	public UserVO selectById(String userid) {
		
		return dao.selectById(userid);
	}

	public int updateUser(UserVO user) {
		
		return dao.updateUser(user);
	}
}
