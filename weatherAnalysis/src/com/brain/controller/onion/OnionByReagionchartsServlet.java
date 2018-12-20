package com.brain.controller.onion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brain.model.onion.OnionService;
import com.brain.model.onion.OnionVO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
* @brief 지역선택 ajax Google Chart servlet
* @details 연별 전국 양파 총 생산량
* @author Sangrim Shin
* @date 2018. 12. 17.
 */

@WebServlet("/onion/onionByRegionCharts.do")
public class OnionByReagionchartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OnionVO> list = null;
		String selectedRegion = request.getParameter("region");
		OnionService service = new OnionService();
		
		if(selectedRegion== null || selectedRegion.equals("")) {
			 list = service.annualTotal();
		} else {
			System.out.println(selectedRegion);
			 list = service.annualTotalByRegion(selectedRegion);
		}
		System.out.println("onionChart");
		System.out.println(list);
		JsonObject data = new JsonObject();
		JsonArray arryCols = new JsonArray();
		JsonArray arrayRows = new JsonArray();
 		String[][] colvals = {{ "string", "연도"}, 
 				
				{ "number", "생산량 (톤)"},
				{ "number", "단위생산량 (10a/kg)"},
				{ "number", "재배면적 (ha)"},
		};
		for (String[] s: colvals) {
			JsonObject col = new JsonObject();
			col.addProperty("type", s[0]);
			col.addProperty("label", s[1]);
			arryCols.add(col);
		}		
		for (OnionVO vo : list) {
			JsonArray ajaxArryRowsC = new JsonArray();
			JsonObject cell = new JsonObject();
				JsonObject ajaxObjRow1 = new JsonObject(); 
				JsonObject ajaxObjRow2 = new JsonObject(); 
				JsonObject ajaxObjRow3 = new JsonObject(); 
				JsonObject ajaxObjRow4 = new JsonObject(); 

				ajaxObjRow1.addProperty("v", vo.getYear());
				ajaxArryRowsC.add(ajaxObjRow1);
				ajaxObjRow2.addProperty("v", vo.getOutput());
				ajaxArryRowsC.add(ajaxObjRow2);
				ajaxObjRow3.addProperty("v", vo.getUnitOutput());
				ajaxArryRowsC.add(ajaxObjRow3);
				ajaxObjRow4.addProperty("v", vo.getArea());
				ajaxArryRowsC.add(ajaxObjRow4);
				
				cell.add("c", ajaxArryRowsC);
				arrayRows.add(cell);
		}
		data.add("cols", arryCols);
		data.add("rows", arrayRows);
 		System.out.println(data.toString());
		response.setContentType("application/json;charset=UTF-8");
 		response.getWriter().print(data);
		response.getWriter().flush();
	}

}
