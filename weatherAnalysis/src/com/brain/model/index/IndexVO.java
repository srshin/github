package com.brain.model.index;


/**
* @brief 조건별 양파 생산량 도출 로직 VO
* @details
* @author SangrimShin
* @date 2018. 12. 19.
 */


public class IndexVO {

	String year;
	String region;
	int area;
	int output;
	int unitOutput;
	int price;
	public IndexVO(String year, String region, int area, int output, int unitOutput, int price) {
		super();
		this.year = year;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
		return "IndexVO [year=" + year + ", price=" + price + ", region=" + region + ", area=" + area + ", output="
				+ output + ", unitOutput=" + unitOutput + "]";
	}
	
	
	
}
