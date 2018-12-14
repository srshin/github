package com.brain.model.onion;


 /**
* @brief regionTable+OnionTable VO
* @details
* @author "JungeunPark"
* @date 2018. 12. 14.
*/

public class RegionOnionVO {

	int id;
	String region;
	String year;
	int area;
	int output;
	int unitOutput;
	
	public RegionOnionVO() {
		super();
	}

	public RegionOnionVO(int id, String region, String year, int area, int output, int unitOutput) {
		super();
		this.id = id;
		this.region = region;
		this.year = year;
		this.area = area;
		this.output = output;
		this.unitOutput = unitOutput;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
		return "RegionOnionVO [id=" + id + ", region=" + region + ", year=" + year + ", area=" + area + ", output="
				+ output + ", unitOutput=" + unitOutput + "]";
	}
	
}
