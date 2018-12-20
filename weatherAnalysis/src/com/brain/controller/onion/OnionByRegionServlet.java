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
* @brief 지역선택 ajax 반영 servlet
* @details 연별 전국 양파 총 생산량
* @author JungeunPark
* @date 2018. 12. 12.
 */

@WebServlet("/onion/onionByRegion.do")
public class OnionByRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selectedRegion = request.getParameter("region");
		
		OnionService service = new OnionService();
		
		request.setAttribute("totalByRegion", service.annualTotalByRegion(selectedRegion));
		
		RequestDispatcher rd = request.getRequestDispatcher("/onion/onionByRegion.jsp");
		rd.forward(request, response);
		
	}

}
