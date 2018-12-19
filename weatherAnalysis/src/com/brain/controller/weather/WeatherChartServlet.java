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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/**
 * @brief 기상 ajax Google Chart Servlet
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 18.
 *
 */
@WebServlet("/weather/weatherChart.do")
public class WeatherChartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	WeatherService service = new WeatherService();
      
        String oneName = request.getParameter("oneName");
        String condition = request.getParameter("condition");
      
        String[][] resultString = service.resultString(oneName, condition);
        
        JsonObject data = new JsonObject();
        JsonArray arrayCols = new JsonArray();
        JsonArray arrayRows = new JsonArray();
       
        //String colType="number";
       
            JsonObject col = new JsonObject();
            col.addProperty("type", "string");
            col.addProperty("label", "월");
            arrayCols.add(col);
            
            for (int i = 1; i < 5; i++) {
                JsonObject cols = new JsonObject();
                cols.addProperty("type", "number");
                cols.addProperty("label", resultString[i][0]);
                arrayCols.add(cols);
            }
        
            
        for(int j=2  ; j<13; j++) {
			JsonArray ajaxArryRowsC = new JsonArray();
			JsonObject cell = new JsonObject();
				JsonObject ajaxObjRow1 = new JsonObject(); 
				JsonObject ajaxObjRow2 = new JsonObject(); 
				JsonObject ajaxObjRow3 = new JsonObject(); 
				JsonObject ajaxObjRow4 = new JsonObject(); 
				JsonObject ajaxObjRow5 = new JsonObject(); 
				ajaxObjRow1.addProperty("v", resultString[0][j]);
				ajaxArryRowsC.add(ajaxObjRow1);
				ajaxObjRow2.addProperty("v", resultString[1][j]);
				ajaxArryRowsC.add(ajaxObjRow2);
				ajaxObjRow3.addProperty("v", resultString[2][j]);
				ajaxArryRowsC.add(ajaxObjRow3);
				ajaxObjRow4.addProperty("v", resultString[3][j]);
				ajaxArryRowsC.add(ajaxObjRow4);
				ajaxObjRow5.addProperty("v", resultString[4][j]);
				ajaxArryRowsC.add(ajaxObjRow5);
				cell.add("c", ajaxArryRowsC);
				arrayRows.add(cell);
        }
        
        data.add("cols", arrayCols);
        data.add("rows", arrayRows);
        System.out.println("data:" + data);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(data);
        response.getWriter().flush();
    
    } 
}
