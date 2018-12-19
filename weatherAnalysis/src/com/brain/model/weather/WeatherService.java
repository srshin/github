package com.brain.model.weather;

import java.util.ArrayList;
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

	public List<WeatherVO> resultList(String oneName, String condition) {
		return dao.resultList(oneName, condition);
	}

	public String[][] resultString(String oneName, String condition) {

		int rowNum = 5;
		int colNum = 13;
		int row = 0;

		String[][] resultString = new String[rowNum][colNum];

		resultString[0][0] = "연도";
		resultString[0][1] = "단위생산량";
		resultString[0][2] = "8월";
		resultString[0][3] = "9월";
		resultString[0][4] = "10월";
		resultString[0][5] = "11월";
		resultString[0][6] = "12월";
		resultString[0][7] = "1월";
		resultString[0][8] = "2월";
		resultString[0][9] = "3월";
		resultString[0][10] = "4월";
		resultString[0][11] = "5월";
		resultString[0][12] = "6월";

		resultString[1][0] = "2013";
		resultString[2][0] = "2014";
		resultString[3][0] = "2015";
		resultString[4][0] = "2016";

		List<WeatherVO> resultlist = dao.resultList(oneName, condition);

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

			if (vo.getYear().equals("2013"))
				row = 1;
			else if (vo.getYear().equals("2014"))
				row = 2;
			else if (vo.getYear().equals("2015"))
				row = 3;
			else if (vo.getYear().equals("2016"))
				row = 4;
			else if (vo.getYear().equals("2017"))
				row = 5;

			if (row < rowNum)
				resultString[row][1] = Integer.toString(vo.getUnitOutput());

			int month = Integer.parseInt(vo.getMonth());

			if (month >= 8) {
				if (row < rowNum)
					resultString[row][month - 6] = value;
			} else if (month >= 1 && month <= 6) {
				// 2013년도 제외
				if (row - 1 > 0)
					resultString[row - 1][month + 6] = value;
			}

		}
		System.out.println("ResultString:");
		for (int j = 0; j < colNum; j++) {
			for (int i = 0; i < rowNum; i++) {
				System.out.print(resultString[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return resultString;
	}
}