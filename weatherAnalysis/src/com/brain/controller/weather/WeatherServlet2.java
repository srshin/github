package com.brain.controller.weather;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.weather.WeatherService;
import com.brain.weather.WeatherVO;

/**
  * @brief 기상 관측 자료(2015~2016) 도출 Servlet2
  * @details
  * @author "HayeonBaek"
  * @date 2018. 12. 14.
  *
  */
@WebServlet("/weather/weather2.do")
public class WeatherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WeatherService service = new WeatherService();
		
		String value = request.getParameter("col");
		String[] test = value.split(",");
		System.out.println("value:"+ value);
		System.out.println(Arrays.toString(test));

		
		List<WeatherVO> radiolist = service.radioList(test);
		
		request.setAttribute("radioList", radiolist);
		
		request.getRequestDispatcher("/weather/weather2.jsp").forward(request, response);

	}

}
