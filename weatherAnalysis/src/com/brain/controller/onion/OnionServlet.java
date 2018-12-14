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
		request.setAttribute("region", service.allRegion());
		request.setAttribute("annualTotal", service.annualTotal());
		
		
		List<OnionVO> annualTotal = service.annualTotal();
		String result = "['연도', '생산량(톤)', '재배면적(ha)',   '10a당 생산량(kg)'],";
		for (OnionVO vo : annualTotal) {
			String str = vo.getRegion();
				result +="[";	
				result += "'" +vo.getYear()+ "'," ;
				result += String.valueOf(vo.getOutput())+"," ; 
				result += String.valueOf(vo.getArea())+ ",";
				result += String.valueOf(vo.getUnitOutput())+"],";
		}
		String result2= result.substring(0, result.length()-1);
		System.out.println(result2);
		request.setAttribute("result", result2);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/onion/onion.jsp");
		rd.forward(request, response);
		
	}

}
