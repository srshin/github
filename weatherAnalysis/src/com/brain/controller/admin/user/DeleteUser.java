package com.brain.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brain.model.admin.user.ManageUserService;

/**
* @brief 어드민 접속시 회원관리 중 회원 삭제 서블릿
* @details
* @author "InchangJung"
* @date 2018. 12. 18.
*/
@WebServlet("/admin/userDelete.do")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object sessionObjAd = session.getAttribute("admin");
		
		if(sessionObjAd == null) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
	
		} else {
			
			ManageUserService u_service = new ManageUserService();
			
			String uid = request.getParameter("userid");
	
					
			request.setAttribute("message", u_service.deleteUser(uid)>0?"삭제성공":"삭제실패");
			
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
