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
@WebServlet("/weather/weatherResult.do")
public class WeatherResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WeatherService service = new WeatherService();
		
		String oneName = request.getParameter("oneName");
		String condition = request.getParameter("condition");
		
		String conditionTitle = null;
		if(condition.equals("average")) {
			conditionTitle = "평균 기온";
		} else if (condition.equals("taMax")) {
			conditionTitle = "평균 최고기온";
		} else if (condition.equals("taMin")) {
			conditionTitle = "평균최저기온";
		} else if (condition.equals("rnDay")) {
			conditionTitle = "강수량";
		} else if (condition.equals("sunLight")) {
			conditionTitle = "일조시간";
		}
		
		System.out.println("weatherResult");
		String[][] resultString = service.resultString(oneName, condition);
		
		request.setAttribute("resultString", resultString);
		
		request.setAttribute("oneName", oneName);
		request.setAttribute("conditionTitle", conditionTitle);
		
		request.getRequestDispatcher("/weather/weatherResult.jsp").forward(request, response);

	}

}
