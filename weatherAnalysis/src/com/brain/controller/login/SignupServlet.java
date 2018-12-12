package com.brain.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.model.login.LoginService;
import com.brain.model.login.UserVO;
import com.brain.util.OracleDBUtil;

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
		OracleDBUtil.dbConnect();
		request.getRequestDispatcher("/login/signup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
				
		UserVO user = LoginService.makeUser(request);
		LoginService service = new LoginService();
		int ret = service.insertUser(user);
		request.setAttribute("user", user);
		if(ret>0) {
			request.setAttribute("message", "가입성공");
		}else {
			request.setAttribute("message", "가입실패");
		}
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		
	}

}
