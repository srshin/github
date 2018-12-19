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
* @brief 회원가입 용 컨트롤 서블릿
* @details
* @author "InchangJung"
* @date 2018. 12. 11.
*/
@WebServlet("/login/signup.do")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object sessionObj = session.getAttribute("user");
		if(sessionObj != null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			request.getRequestDispatcher("/login/signup.jsp").forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
				
		UserVO user = LoginService.makeUser(request);
		LoginService service = new LoginService();
		int ret = service.insertUser(user);
		request.setAttribute("newuser", user);
		if(ret>0) {
			request.setAttribute("message", "가입을 환영합니다.");
			
		}else {
			request.setAttribute("message", "아이디가 중복되었습니다.");
		}
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		
	}

}
