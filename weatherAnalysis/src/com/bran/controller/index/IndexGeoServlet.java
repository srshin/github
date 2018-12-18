package com.bran.controller.index;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @brief homepage ajax Google Chart servlet
 * @details 연별 전국 양파 총 생산량 chart
 * @author Sangrim Shin
 * @date 2018. 12. 17.
 */

@WebServlet("/index/indexGeo.do")
public class IndexGeoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		class GeoData {
			String name;
			String format;
			int value;

			public GeoData(String name, String format, int value) {
				super();
				this.name = name;
				this.format = format;
				this.value = value;
			}

		}
		System.out.println("indexGeo");

		JsonObject data = new JsonObject();
		JsonArray arryCols = new JsonArray();
		JsonArray arrayRows = new JsonArray();

		JsonObject col1 = new JsonObject();
		col1.addProperty("type", "string");
		col1.addProperty("label", "Country");
		arryCols.add(col1);
		JsonObject col2 = new JsonObject();
		col2.addProperty("type", "number");
		col2.addProperty("label", "Value");
		arryCols.add(col2);
		List<GeoData> list = Arrays.asList(new GeoData("KR-11", "서울특별시", 1), 
				new GeoData("KR-26","부산광역시", 2/10), 
				new GeoData("KR-27", "대구광역시", 3/10),
				new GeoData("KR-28", "인천광역시", 4), 
				new GeoData("KR-29", "광주광역시", 5), 
				new GeoData("KR-30", "대전광역시", 6), 
				new GeoData("KR-31", "울산광역시", 7),
				new GeoData("KR-41", "경기도", 8), 
				new GeoData("KR-42", "강원도", 9), 
				new GeoData("KR-43", "충청북도", 10), 
				new GeoData("KR-44", "충청남도",11),
				new GeoData("KR-45", "전라북도", 12), 
				new GeoData("KR-46", "전라남도", 13), 
				new GeoData("KR-47", "경상북도", 14), 
				new GeoData("KR-48", "경상남도", 15),
				new GeoData("KR-49", "제주도", 16));

		for (GeoData geo : list) {
			JsonArray ajaxArryRowsC = new JsonArray();
			JsonObject cell = new JsonObject();

			JsonObject ajaxObjRow1 = new JsonObject();
			ajaxObjRow1.addProperty("v", geo.name);
			ajaxObjRow1.addProperty("f", geo.format);
			ajaxArryRowsC.add(ajaxObjRow1);

			JsonObject ajaxObjRow2 = new JsonObject();
			ajaxObjRow2.addProperty("v", geo.value);
			ajaxArryRowsC.add(ajaxObjRow2);

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
