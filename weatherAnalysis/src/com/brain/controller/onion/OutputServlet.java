package com.brain.controller.onion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.model.onion.OnionService;


 /**
* @brief 전국 양파 총생산량 연별 추이 Servlet
* @details
* @author "JungeunPark"
* @date 2018. 12. 16.
*/

@WebServlet("/onion/output.do")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//연별 전국 양파 총생산량 변화추	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OnionService service = new OnionService();
		
		request.setAttribute("regionList", service.allRegion());
		request.setAttribute("yearList", service.allYear());
		
		request.setAttribute("outputList", service.output());
		
		RequestDispatcher rd = request.getRequestDispatcher("/onion/output.jsp");
		rd.forward(request, response);
		
		
	}

}






