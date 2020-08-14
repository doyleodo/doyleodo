package com.techelevator.model;

public class Plot {
	private Long plotId;
	private Long plotNumber;
	private Long gardenId;
	private Long plantId;
	
	
	
	public Plot() {
		
	}
	public Long getPlotId() {
		return plotId;
	}



	public void setPlotId(Long plotId) {
		this.plotId = plotId;
	}



	public Long getPlotNumber() {
		return plotNumber;
	}



	public void setPlotNumber(Long plotNumber) {
		this.plotNumber = plotNumber;
	}



	public Long getGardenId() {
		return gardenId;
	}



	public void setGardenId(Long gardenId) {
		this.gardenId = gardenId;
	}



	public Long getPlantId() {
		return plantId;
	}



	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}

//	@Override
//	   public String toString() {
//	      return "Plot{" +
//	              "plotId=" + plotId +
//	              "plotNumber=" + plotNumber +
//	              "gardenId=" + gardenId +
//	              "plantId=" + plantId +
//	      		  '}';
//	   }


}
