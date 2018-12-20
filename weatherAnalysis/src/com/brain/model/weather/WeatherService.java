package com.brain.model.weather;

import java.util.List;

/**
 * @brief 기상 관측 자료 도출 Service
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

	public List<WeatherVO> resultList(String oneName, String condition) {
		return dao.resultList(oneName, condition);
	}

	public String[][] resultString(String oneName, String condition) {

		String[] years = { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018" };

		int rowNum = years.length + 2;
		// System.out.println(rowNum);
		int colNum = 13;
		int row = 0;

		String[][] resultString = new String[rowNum][colNum];

		resultString[0][0] = "연도";
		resultString[0][1] = "단위생산량";
		resultString[0][2] = "(전년도)8월";
		resultString[0][3] = "9월";
		resultString[0][4] = "10월";
		resultString[0][5] = "11월";
		resultString[0][6] = "12월";
		resultString[0][7] = "(금년)1월";
		resultString[0][8] = "2월";
		resultString[0][9] = "3월";
		resultString[0][10] = "4월";
		resultString[0][11] = "5월";
		resultString[0][12] = "6월";

		int yeari = 1;
		for (String s : years) {
			resultString[yeari++][0] = s;
		}
		List<WeatherVO> resultlist = dao.resultList(oneName, condition);
		for (WeatherVO dao : resultlist) {
			System.out.println(dao);
		}
		for (WeatherVO vo : resultlist) {
			String value = null;
			// System.out.println(vo);

			if (condition.equals("average")) {
				value = Double.toString(vo.getAverage());
			} else if (condition.equals("taMax")) {
				value = Double.toString(vo.getTaMax());
			} else if (condition.equals("taMin")) {
				value = Double.toString(vo.getTaMin());
			} else if (condition.equals("rnDay")) {
				value = Double.toString(vo.getRnDay());
			} else {
				value = Double.toString(vo.getSunLight());
			}

			row = Integer.parseInt(vo.getYear()) - 1998;
			// System.out.println(row);

			if (row > 0 && row < rowNum)
				resultString[row][1] = Integer.toString(vo.getUnitOutput());

			int month = Integer.parseInt(vo.getMonth());

			if (month >= 8) {
				if (row < rowNum)
					resultString[row + 1][month - 6] = value;

			} else if (month >= 1 && month <= 6) {
				resultString[row][month + 6] = value;
			}
		}
		String[][] result2= new String[rowNum-10][colNum];
		int ii=0;
		System.out.println("ResultString:");
		for (int i = 0; i < rowNum-1; i++) {
				if(i>=1 && i<10) 
					continue;
				for (int j = 0; j < colNum; j++) {
					System.out.print(resultString[i][j] + " ");
					result2[ii][j]= resultString[i][j];
				}
				System.out.println();
				ii++;
				}
		
		System.out.println();
		return result2;
	}
}