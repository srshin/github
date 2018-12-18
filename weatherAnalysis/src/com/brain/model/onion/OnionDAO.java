package com.brain.model.onion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.brain.util.OracleDBUtil;


/**
* @brief 조건별 양파 생산량 도출 로직 DAO
* @details 연별 전국 양파 총 생산량
* @author JungeunPark
* @date 2018. 12. 11.
 */

public class OnionDAO {
	
	// 연별 전국 양파 총 재배면적,총 생산량, 10a 당 샹산량
		public List<OnionVO> annualTotal() {
			
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			String sql = "select year,area,output,unitOutput "
							+ "from onionTable "
							+ "where region = '전국' "
							+ "order by 1";
			OnionVO onion = null;
			List<OnionVO> onionList = new ArrayList<>();
			
			conn = OracleDBUtil.dbConnect();
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					String year = rs.getString("year");
					int area = rs.getInt("area");
					int output = rs.getInt("output");
					int unitOutput = rs.getInt("unitOutput");
					
					onion = new OnionVO(year, area, output, unitOutput);
					onionList.add(onion);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				OracleDBUtil.dbDisconnect(rs, st, conn);
			}
			return onionList;		
		}
		

	// 선택된 지역의 총 생산량, 총 재배면적, 10a 당 샹산량 값 가져오기
		public List<OnionVO> annualTotalByRegion(String selectedRegion) {
			
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			String sql = "select * from onionTable where region ='" + selectedRegion +"'";
			OnionVO onion = null;
			List<OnionVO> onionList = new ArrayList<>();
			
			conn = OracleDBUtil.dbConnect();
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					String year = rs.getString("year");
					String region = rs.getString("region");
					int area = rs.getInt("area");
					int output = rs.getInt("output");
					int unitOutput = rs.getInt("unitOutput");
					
					onion = new OnionVO(year, region, area, output, unitOutput);
					onionList.add(onion);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				OracleDBUtil.dbDisconnect(rs, st, conn);
			}
			return onionList;		
		}
		
		
		// 지역명 리스트
			public List<String> allRegion() {
				
				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;
				String sql = "select region from regionTable order by id";
				String region = null;
				List<String> regionList = new ArrayList<>();
				
				conn = OracleDBUtil.dbConnect();
				
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					while(rs.next()) {
						region = rs.getString("region");
						regionList.add(region);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					OracleDBUtil.dbDisconnect(rs, st, conn);
				}
				System.out.println(regionList);
				return regionList;		
			}

			
		//연도 리스트
			public List<String> allYear() {
				
				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;
				String sql = "select distinct year from onionTable order by 1";
				String year = null;
				List<String> yearList = new ArrayList<>();
				
				conn = OracleDBUtil.dbConnect();
				
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					while(rs.next()) {
						year = rs.getString("year");
						yearList.add(year);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					OracleDBUtil.dbDisconnect(rs, st, conn);
				}
				System.out.println(yearList);
				return yearList;		
			}
			
			
	// 연간별,지역별 총생산량 추출	
			public List<OnionVO> output() {
				
				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;
				String sql = "select region, year, output from regionTable join onionTable using(region) order by id, year ";
				OnionVO output  = null;
				List<OnionVO> outputList = new ArrayList<>();
				
				conn = OracleDBUtil.dbConnect();
				
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next()) {
		
						output = new OnionVO();
						
						output.setRegion(rs.getString("region"));
						output.setYear(rs.getString("year"));
						output.setOutput(rs.getInt("output"));
						
						System.out.println(output);
						outputList.add(output);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					OracleDBUtil.dbDisconnect(rs, st, conn);
				}

				System.out.println(outputList);
				return outputList;		
			}	
			
			
	// 연간별,지역별 재배면적 추출	
					public List<OnionVO> area() {
						
						Connection conn = null;
						Statement st = null;
						ResultSet rs = null;
						String sql = "select region, year, area from regionTable join onionTable using(region) order by id, year ";
						OnionVO area  = null;
						List<OnionVO> areaList = new ArrayList<>();
						
						conn = OracleDBUtil.dbConnect();
						
						try {
							st = conn.createStatement();
							rs = st.executeQuery(sql);
							
							while(rs.next()) {
				
								area = new OnionVO();
								
								area.setRegion(rs.getString("region"));
								area.setYear(rs.getString("year"));
								area.setArea(rs.getInt("area"));
								
								System.out.println(area);
								areaList.add(area);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							OracleDBUtil.dbDisconnect(rs, st, conn);
						}

						System.out.println(areaList);
						return areaList;		
					}		
					
					
	// 연간별,지역별 생산성 추출	
					public List<OnionVO> unitOutput() {
						
						Connection conn = null;
						Statement st = null;
						ResultSet rs = null;
						String sql = "select region, year, unitOutput from regionTable join onionTable using(region) order by id, year ";
						OnionVO unitOutput  = null;
						List<OnionVO> unitOutputList = new ArrayList<>();
						
						conn = OracleDBUtil.dbConnect();
						
						try {
							st = conn.createStatement();
							rs = st.executeQuery(sql);
							
							while(rs.next()) {
				
								unitOutput = new OnionVO();
								
								unitOutput.setRegion(rs.getString("region"));
								unitOutput.setYear(rs.getString("year"));
								unitOutput.setUnitOutput(rs.getInt("unitOutput"));
								
								System.out.println(unitOutput);
								unitOutputList.add(unitOutput);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							OracleDBUtil.dbDisconnect(rs, st, conn);
						}

						System.out.println(unitOutputList);
						return unitOutputList;		
					}				
//지정한 연도에 대한 전국 각 지역의 생산량 
public List<OnionVO> allRegionbyYear(String year) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		

		String sql = "select * from ( select  region, area,output,unitOutput from onionTable "
				+ "where region !='전국' and year =? order by  output desc ) where rownum <=6";
		OnionVO onion = null;
		List<OnionVO> list = new ArrayList<>();
		
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1,year);
			rs = st.executeQuery();
			while(rs.next()) {
				String region = rs.getString("region");
				int area = rs.getInt("area");
				int output = rs.getInt("output");
				int unitOutput = rs.getInt("unitOutput");
				
				onion = new OnionVO(year, region, area, output, unitOutput);
				list.add(onion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return list;		
	}
	  
  
}

