package com.brain.model.onion;

import java.util.List;


/**
* @brief 조건별 양파 생산량 도출 로직 Service
* @details
* @author JungeunPark
* @date 2018. 12. 11.
 */

public class OnionService {
	
	OnionDAO dao = new OnionDAO();
	
	public List<OnionVO> annualTotal() {
		return dao.annualTotal();		
	}
	
	public List<OnionVO> annualTotalByRegion(String selectedRegion) {
		return dao.annualTotalByRegion(selectedRegion);
	}
	
	public List<OnionVO> allRegion() {
		return dao.allRegion();
	}
	public List<OnionVO> allRegionbyYear(String year) {
		return dao.allRegionbyYear(year);
	}

}
