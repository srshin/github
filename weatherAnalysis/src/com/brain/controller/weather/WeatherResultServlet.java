package com.brain.controller.weather;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.model.weather.WeatherService;
import com.brain.model.weather.WeatherVO;


/**
  * @brief 기상 관측 자료 도출 Servlet2
  * @details
  * @author "HayeonBaek"
  * @date 2018. 12. 14.
  *
  */
@WebServlet("/weather/weather2.do")
public class WeatherResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WeatherService service = new WeatherService();
		
		String onename = request.getParameter("oneName");
		String tadate = request.getParameter("taDate");
		String value = request.getParameter("col");
		String[] column = value.split(",");
		
		//System.out.println("value:"+ value);
		//System.out.println(Arrays.toString(column));
		
		List<WeatherVO> resultlist = service.resultList(onename,tadate,column);
		
		request.setAttribute("resultList", resultlist); 
		
		request.getRequestDispatcher("/weather/weatherResult.jsp").forward(request, response);

	}

}
