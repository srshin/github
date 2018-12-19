package com.brain.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brain.model.admin.user.ManageUserService;
import com.brain.model.login.UserVO;

/**
* @brief 어드민 접속시 회원 정보 수정 서블릿
* @details
* @author "InchangJung"
* @date 2018. 12. 18.
*/
@WebServlet("/admin/userUpdate.do")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Object sessionObjAd = session.getAttribute("admin");
		
		if(sessionObjAd == null) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
	
		} else {
		
			ManageUserService service = new ManageUserService();
			String userid = request.getParameter("userid");
		
			UserVO user = service.selectById(userid);
			request.setAttribute("user", user);
				
			request.getRequestDispatcher("userDetail.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Object sessionObjAd = session.getAttribute("admin");
		
		if(sessionObjAd == null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			
			ManageUserService service = new ManageUserService();
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			
			UserVO user = new UserVO(id, password, email);
			int result = service.updateUser(user);
			
			request.setAttribute("message", result>0?"수정성공":"수정실패");
			request.setAttribute("user", user);
			request.getRequestDispatcher("result2.jsp").forward(request, response);
		}	
		
	}

}
