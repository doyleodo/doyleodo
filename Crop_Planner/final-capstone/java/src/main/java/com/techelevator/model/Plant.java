package com.techelevator.model;

import java.math.BigDecimal;

public class Plant {
	
	private Long id;
	private String name;
	private String description;
	private int plantsPerSqFoot;
	private String sunRequirements;
	private String region;
	private BigDecimal seedlingCost;

	public Plant() {
	}
	
	public Plant(String name, String description, int plantsPerSqFoot, String sunRequirements, String region,
			BigDecimal seedCost) {
		super();
		this.name = name;
		this.description = description;
		this.plantsPerSqFoot = plantsPerSqFoot;
		this.sunRequirements = sunRequirements;
		this.region = region;
		this.seedlingCost = seedCost;
	}
	
	public Plant(Long id, String name, String description, int plantsPerSqFoot, String sunRequirements, String region,
			BigDecimal seedCost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.plantsPerSqFoot = plantsPerSqFoot;
		this.sunRequirements = sunRequirements;
		this.region = region;
		this.seedlingCost = seedCost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPlantsPerSqFoot() {
		return plantsPerSqFoot;
	}

	public void setPlantsPerSqFoot(int plantsPerSqFoot) {
		this.plantsPerSqFoot = plantsPerSqFoot;
	}

	public String getSunRequirements() {
		return sunRequirements;
	}

	public void setSunRequirements(String sunRequirements) {
		this.sunRequirements = sunRequirements;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getSeedlingCost() {
		return seedlingCost;
	}

	public void setSeedlingCost(BigDecimal seedCost) {
		this.seedlingCost = seedCost;
	}

}
