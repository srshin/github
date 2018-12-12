package com.brain.weather;

import java.util.List;

/**
 * @brief 종관 기상 데이터(2015.08~2016.08) Service
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 12.
 *
 */
public class WeatherService {
	
	WeatherDAO dao = new WeatherDAO();
	
	public List<WeatherVO> selectAll() {
		return dao.selectAll();
	}
	
	public List<WeatherVO> selectByOneName(String oneName) {
		return dao.selectByOneName(oneName);
	}
}
