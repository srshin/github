package com.brain.model.onion;


/**
* @brief 조건별 양파 생산량 도출 로직 VO
* @details
* @author "JungeunPark"
* @date 2018. 12. 11.
 */

public class OnionVO {

	String year;
	String region;
	int area;
	int output;
	int unitOutput;
	
	public OnionVO() {
		super();
	}
	
	public OnionVO(String year, int area, int output, int unitOutput) {
		super();
		this.year = year;
		this.area = area;
		this.output = output;
		this.unitOutput = unitOutput;
	}
	
	public OnionVO(String year, String region, int area, int output, int unitOutput) {
		super();
		this.year = year;
		this.region = region;
		this.area = area;
		this.output = output;
		this.unitOutput = unitOutput;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getOutput() {
		return output;
	}

	public void setOutput(int output) {
		this.output = output;
	}

	public int getUnitOutput() {
		return unitOutput;
	}

	public void setUnitOutput(int unitOutput) {
		this.unitOutput = unitOutput;
	}

	@Override
	public String toString() {
		return "OnionVO [year=" + year + ", region=" + region + ", area=" + area + ", output=" + output
				+ ", unitOutput=" + unitOutput + "]";
	}

}
