package com.brain.model.weather;

/**
 * @brief 기상 관측 자료 도출 VO
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 11.
 *
 */
public class WeatherVO {

	String oneName;
	String year;
	String month;
	double average;
	double taMax;
	double taMin;
	double rnDay;
	double sunLight;
	int unitOutput;

	public WeatherVO() {
		super();
	}

	public WeatherVO(String oneName) {
		super();
		this.oneName = oneName;
	}

	public WeatherVO(String oneName, String year, String month, double average, double taMax, double taMin,
			double rnDay, double sunLight, int unitOutput) {
		super();
		this.oneName = oneName;
		this.year = year;
		this.month = month;
		this.average = average;
		this.taMax = taMax;
		this.taMin = taMin;
		this.rnDay = rnDay;
		this.sunLight = sunLight;
		this.unitOutput = unitOutput;
	}

	public String getOneName() {
		return oneName;
	}

	public void setOneName(String oneName) {
		this.oneName = oneName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getTaMax() {
		return taMax;
	}

	public void setTaMax(double taMax) {
		this.taMax = taMax;
	}

	public double getTaMin() {
		return taMin;
	}

	public void setTaMin(double taMin) {
		this.taMin = taMin;
	}

	public double getRnDay() {
		return rnDay;
	}

	public void setRnDay(double rnDay) {
		this.rnDay = rnDay;
	}

	public double getSunLight() {
		return sunLight;
	}

	public void setSunLight(double sunLight) {
		this.sunLight = sunLight;
	}

	public int getUnitOutput() {
		return unitOutput;
	}

	public void setUnitOutput(int unitOutput) {
		this.unitOutput = unitOutput;
	}

	@Override
	public String toString() {
		return "WeatherVO [oneName=" + oneName + ", year=" + year + ", month=" + month + ", average=" + average
				+ ", taMax=" + taMax + ", taMin=" + taMin + ", rnDay=" + rnDay + ", sunLight=" + sunLight
				+ ", unitOutput=" + unitOutput + "]";
	}


}
