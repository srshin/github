package com.brain.controller.admin.onion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageOnion
 */
@WebServlet("/admin/onion.do")
public class ManageOnion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession();
		
			Object sessionObjAd = session.getAttribute("admin");
			
			if(sessionObjAd == null) {
					response.sendRedirect(request.getContextPath() + "/index.jsp");
		
			} else {
				request.getRequestDispatcher("/admin/manageOnion.jsp").forward(request, response);
			}
			
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
