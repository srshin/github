package com.brain.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.model.login.LoginService;
import com.brain.model.login.UserVO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/login/idcheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String idc = request.getParameter("idc");
		
		LoginService service = new LoginService();
		UserVO user = service.IdCheck(idc);
		
		PrintWriter Out = response.getWriter();
		
		if(user!=null) {
			Out.print("fail");
		}else {
			Out.print("success");	
		}
		
	}

}
