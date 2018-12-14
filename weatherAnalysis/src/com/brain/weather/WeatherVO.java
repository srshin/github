package com.brain.weather;

/**
 * @brief 기상 관측 자료(2015~2016) 도출 VO
 * @details
 * @author "HayeonBaek"
 * @date 2018. 12. 14.
 *
 */
public class WeatherVO {

	String oneName;
	String taDate;
	double average;
	double taMax;
	double taMin;
	double rnDay;
	double sunLight;

	public WeatherVO() {
		super();
	}

	public WeatherVO(String oneName, String taDate, double average, double taMax, double taMin, double rnDay,
			double sunLight) {
		super();
		this.oneName = oneName;
		this.taDate = taDate;
		this.average = average;
		this.taMax = taMax;
		this.taMin = taMin;
		this.rnDay = rnDay;
		this.sunLight = sunLight;
	}

	public WeatherVO(String oneName) {
		super();
		this.oneName = oneName;
	}

	public WeatherVO(String oneName, double average, double taMax, double taMin, double rnDay, double sunLight) {
		super();
		this.oneName = oneName;
		this.average = average;
		this.taMax = taMax;
		this.taMin = taMin;
		this.rnDay = rnDay;
		this.sunLight = sunLight;
	}

	public String getOneName() {
		return oneName;
	}

	public void setOneName(String oneName) {
		this.oneName = oneName;
	}

	public String getTaDate() {
		return taDate;
	}

	public void setTaDate(String taDate) {
		this.taDate = taDate;
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

	@Override
	public String toString() {
		return "WeatherVO [oneName=" + oneName + ", taDate=" + taDate + ", average=" + average + ", taMax=" + taMax
				+ ", taMin=" + taMin + ", rnDay=" + rnDay + ", sunLight=" + sunLight + "]";
	}

}
