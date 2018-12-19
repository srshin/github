package com.brain.controller.onion;

import java.io.IOException;
import java.util.Arrays;
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
* @brief 생산성 변화추이 chart
* @details
* @author "JungeunPark"
* @date 2018. 12. 19.
*/
@WebServlet("/onion/unitOutputChart.do")
public class unitOutputChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<OnionVO> list = null;
		OnionService service = new OnionService();
		list = service.unitOutput();		
		System.out.println("unitOutputChart");
		System.out.println(list);
	
		JsonObject data = new JsonObject();
		JsonArray arryCols = new JsonArray();
		JsonArray arrayRows = new JsonArray();
		
		List<String> cities = service.top5Region();
		System.out.println(cities);
		List<String> years = service.allYear();
		System.out.println(years);
		String[][] colvals = new String[6][];
		int idx=0;
		colvals[idx] = new String[]{"string", "연도"};
		String colType = "number";		
		for(String city : cities) {
			colvals[++idx] = new String[]{colType,city};
		}		
		for (String[] s : colvals) {
			System.out.println(Arrays.toString(s));
			JsonObject col = new JsonObject();
			col.addProperty("type", s[0]);
			col.addProperty("label", s[1]);
			System.out.println(col);
			arryCols.add(col);
		}
		
		for(String year : years) {
			JsonObject cell = new JsonObject();
			JsonObject ajaxObjYear = new JsonObject();
			JsonArray ajaxArryRowsC = new JsonArray();
			ajaxObjYear.addProperty("v", year);
			ajaxArryRowsC.add(ajaxObjYear);
				for(String city : cities) {					
	            	for (OnionVO vo : list) {
	            		if(vo.getRegion().equals(city)&& vo.getYear().equals(year)) {
	        	            JsonObject ajaxObjRow1 = new JsonObject();	            			
						ajaxObjRow1.addProperty("v", vo.getUnitOutput());
						ajaxArryRowsC.add(ajaxObjRow1);
						break;
					}
				}
			}
			cell.add("c", ajaxArryRowsC);
			arrayRows.add(cell);
		}		
		data.add("cols", arryCols);
		data.add("rows", arrayRows);
		response.setContentType("application/json;charset=UTF-8");
 		response.getWriter().print(data);
		response.getWriter().flush();
		}
}


