package com.brain.controller.weather;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.model.weather.WeatherService;
import com.brain.model.weather.WeatherVO;


/**
  * @brief 기상 관측 자료 도출 Servlet
  * @details
  * @author "HayeonBaek"
  * @date 2018. 12. 14.
  *
  */
@WebServlet("/weather/weather.do")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		WeatherService service = new WeatherService();
		
		List<WeatherVO> nameList = service.distinctOneName(); 
		List<WeatherVO> allList = service.selectAll();
		
		System.out.println("Weather");
		request.setAttribute("oneName", nameList); 
		request.setAttribute("allList", allList); 

		request.getRequestDispatcher("/weather/weather.jsp").forward(request, response);

	}

}
