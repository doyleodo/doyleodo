package com.techelevator.model;

public class Garden {
	private Long userId;
	private Long gardenId;
	private Long gardenLength;
	private Long gardenWidth;
	private String gardenName;
	
	public Garden() {
		
	}
	public Garden(Long userId, Long gardenId, Long gardenLength, Long gardenWidth) {
		super();
		this.userId = userId;
		this.gardenId = gardenId;
		this.gardenLength = gardenLength;
		this.gardenWidth = gardenWidth;
		
	}
	public Garden(Long gardenId, Long gardenLength, Long gardenWidth) {
		super();
		this.gardenId = gardenId;
		this.gardenLength = gardenLength;
		this.gardenWidth = gardenWidth;
	}
	public Garden(Long gardenLength, Long gardenWidth) {
		super();
		this.gardenLength = gardenLength;
		this.gardenWidth = gardenWidth;
		
	}
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getGardenId() {
		return gardenId;
	}
	public void setGardenId(Long gardenId) {
		this.gardenId = gardenId;
	}
	public Long getGardenLength() {
		return gardenLength;
	}
	public void setGardenLength(Long gardenLength) {
		this.gardenLength = gardenLength;
	}
	public Long getGardenWidth() {
		return gardenWidth;
	}
	public void setGardenWidth(Long gardenWidth) {
		this.gardenWidth = gardenWidth;
	}
	public String getGardenName() {
		return gardenName;
	}
	public void setGardenName(String gardenName) {
		this.gardenName = gardenName;
	}

	 @Override
	   public String toString() {
	      return "Garden{" +
	              "gardenId=" + gardenId +
	              ", userId='" + userId +
	           	  ", gardenLength=" + gardenLength +
	      		  ", gardenWidth=" + gardenWidth +
	      		  ", gardenName=" + gardenName +
	      		  '}';
	   }
	 
	 
}
