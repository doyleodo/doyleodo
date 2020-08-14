package com.techelevator.model;

import java.util.Map;

public class HZone {

	private String zone;
	private Map<String, Double> lat;
	private String temperatureRange;
	private String avgLastFrostMonth;
	private int avgLastFrostDay;
	private String avgFirstFrostMonth;
	private int avgFirstFrostDay;
	private int avgGrowingDays;

	public HZone() {
	}
	
	public HZone(String zone, String avgLastFrostMonth, int avgLastFrostDay, String avgFirstFrostMonth, 
		int avgFirstFrostDay, int avgGrowingDays) {
			this.zone = zone;
			this.avgLastFrostMonth = avgLastFrostMonth;
			this.avgLastFrostDay = avgLastFrostDay;
			this.avgFirstFrostMonth = avgFirstFrostMonth;
			this.avgFirstFrostDay = avgFirstFrostDay;
			this.avgGrowingDays = avgGrowingDays;
		}

	
	public String getAvgLastFrostMonth() {
		return avgLastFrostMonth;
	}

	public void setAvgLastFrostMonth(String avgLastFrostMonth) {
		this.avgLastFrostMonth = avgLastFrostMonth;
	}

	public int getAvgLastFrostDay() {
		return avgLastFrostDay;
	}

	public void setAvgLastFrostDay(int avgLastFrostDay) {
		this.avgLastFrostDay = avgLastFrostDay;
	}

	public String getAvgFirstFrostMonth() {
		return avgFirstFrostMonth;
	}

	public void setAvgFirstFrostMonth(String avgFirstFrostMonth) {
		this.avgFirstFrostMonth = avgFirstFrostMonth;
	}

	public int getAvgFirstFrostDay() {
		return avgFirstFrostDay;
	}

	public void setAvgFirstFrostDay(int avgFirstFrostDay) {
		this.avgFirstFrostDay = avgFirstFrostDay;
	}

	public int getAvgGrowingDays() {
		return avgGrowingDays;
	}

	public void setAvgGrowingDays(int avgGrowingDays) {
		this.avgGrowingDays = avgGrowingDays;
	}
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public Map<String, Double> getLat() {
		return lat;
	}

	public void setLat(Map<String, Double> lat) {
		this.lat = lat;
	}

	public String getTemperatureRange() {
		return temperatureRange;
	}

	public void setTemperatureRange(String temperatureRange) {
		this.temperatureRange = temperatureRange;
	}

	
	@Override
	   public String toString() {
	      return "HZone{" +
	              "zoneName=" + zone +
	              "avgLastFrostMonth=" + avgLastFrostMonth +
	              "avgLastFrostDay=" + avgLastFrostDay +
	              "avgFirstFrostMonth=" + avgFirstFrostMonth +
	              "avgFirstFrostDay=" + avgFirstFrostDay +	    
	              "avgGrowingDays=" + avgGrowingDays +
	      		  '}';
	   };
	
}
