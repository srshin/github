package com.brain.controller.weather;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.weather.WeatherService;
import com.brain.weather.WeatherVO;


/**
  * @brief 종관 기상 데이터(2015.08~2016.08) Servlet
  * @details
  * @author "HayeonBaek"
  * @date 2018. 12. 12.
  *
  */
@WebServlet("/weather/weather.do")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		WeatherService service = new WeatherService();
		List<WeatherVO> list = service.selectAll();

		request.setAttribute("allList", list);

		request.getRequestDispatcher("/weather/weather.jsp").forward(request, response);

	}

}
