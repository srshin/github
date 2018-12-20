package com.brain.controller.onion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.model.onion.OnionService;
import com.brain.model.onion.OnionVO;

/**
* @brief 조건별 양파 생산량 도출 로직 Servlet
* @details 연별 전국 양파 총 생산량
* @author JungeunPark
* @date 2018. 12. 11.
 */

@WebServlet("/onion/onion.do")
public class OnionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//연별 전국 양파 총 재배면적,총 생산량, 10a 당 샹산량
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OnionService service = new OnionService();
		request.setAttribute("region", service.statesRegion());
		request.setAttribute("annualTotal", service.annualTotal());
		
		RequestDispatcher rd = request.getRequestDispatcher("/onion/onion.jsp");
		rd.forward(request, response);
		
	}

}
