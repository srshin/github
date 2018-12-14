package com.brain.weather;

import java.util.List;

/**
 * @brief 기상관측 자료(2015~2016) 도출 Service
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 13.
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
	
	public List<WeatherVO> distinctOneName() {
		return dao.distinctOneName();
	}
	
	public List<WeatherVO> radioList(String[] column) {
		return dao.radioList(column);
	}
	
	
}
