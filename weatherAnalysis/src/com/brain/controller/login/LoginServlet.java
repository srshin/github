package com.brain.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brain.model.login.AdminVO;
import com.brain.model.login.LoginService;
import com.brain.model.login.UserVO;


/**
* @brief
* @details
* @author "InchangJung"
* @date 2018. 12. 11.
*/
@WebServlet("/login/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object sessionObj = session.getAttribute("user");
		Object sessionObjAd = session.getAttribute("admin");
		
		if(sessionObjAd == null) {
			if(sessionObj == null) {
				request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/user.do");
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserVO user = null;
		AdminVO admin = null;
		
		HttpSession session = request.getSession();
		LoginService service = new LoginService();
		
		admin = service.loginCheck2(id, password);
		
		if(admin==null) {
			//user
			
			user = service.loginCheck(id, password);
			System.out.println(id + ":" + password);
			System.out.println("유저 :" + user);
			if(user==null) {
				// 인증실패
				request.setAttribute("loginResult", "no");
				request.setAttribute("message", "아이디 또는 비밀번호 오류");
		
				RequestDispatcher rd = request.getRequestDispatcher("result2.jsp");
				rd.forward(request, response);
				
			}else {
				// user 인증 성공
				request.setAttribute("loginResult", "user");
				request.setAttribute("message", "유저 로그인성공");
				session.setMaxInactiveInterval(24*60*60);
		
				session.setAttribute("user", user);
				response.sendRedirect("../index.jsp");
				
			}
			
		} else {
			// admin 인증 성공
				request.setAttribute("loginResult", "admin");
				request.setAttribute("message", "어드민 로그인성공");
				session.setMaxInactiveInterval(24*60*60);
		
				session.setAttribute("admin", admin);
				response.sendRedirect("../admin/user.do");
			
		}	

	}

}
