package com.brain.model.weather;

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
		
	public List<WeatherVO> distinctOneName() {
		return dao.distinctOneName();
	}
	
	public List<WeatherVO> distinctTaDate() {
		return dao.distinctTaDate();
	}
	
	public List<WeatherVO> resultList(String oneName,String taDate, String[] col){
		return dao.resultList(oneName,taDate, col);
	}
	
	
}
