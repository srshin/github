package com.brain.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brain.model.admin.user.ManageUserService;
import com.brain.model.login.UserVO;

/**
* @brief 어드민 접속시 회원리스트에서 회원 아이디 및 이메일로 검색 기능 서블릿
* @details
* @author "InchangJung"
* @date 2018. 12. 18.
*/
@WebServlet("/admin/finduser.do")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object sessionObjAd = session.getAttribute("admin");
		
		if(sessionObjAd == null) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
	
		} else {
			
			ManageUserService u_service = new ManageUserService();
			
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			
			if(id.equals("")) id= "0";
			if(email.equals("")) email= "0";
			
			List<UserVO> list = u_service.selectIdEmail(id, email);
			request.setAttribute("userlist", list);
			
			request.getRequestDispatcher("findUser.jsp").forward(request, response);
		}
		
		
		
	}

	
}
