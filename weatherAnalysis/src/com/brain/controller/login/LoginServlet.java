package com.brain.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if(sessionObj != null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		LoginService service = new LoginService();
		UserVO user = service.loginCheck(id, password);
		HttpSession session = request.getSession();
		
		if(user==null) {
			//인증실패
			request.setAttribute("loginResult", "no");
			request.setAttribute("message", "로그인실패");
	
			RequestDispatcher rd = request.getRequestDispatcher("result2.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("loginResult", "yes");
			request.setAttribute("message", "로그인성공");
	
			session.setAttribute("user", user);
			response.sendRedirect("../index.jsp");
		}
		
		
		
	}

}
