package com.brain.model.index;

import java.util.List;

import com.brain.model.onion.OnionVO;

/**
* @brief 조건별 양파 생산량 도출 로직 Service
* @details
* @author SangrimShin
* @date 2018. 12. 18.
 */


public class IndexService {
	
	static IndexDAO dao = new IndexDAO();
	
	public List<IndexVO> selectAll() {
		return dao.selectAll();		
	}
	public List<OnionVO> selectAllRegionbyYear(String year) {
		return dao.allRegionbyYear(year);		
	}
}

