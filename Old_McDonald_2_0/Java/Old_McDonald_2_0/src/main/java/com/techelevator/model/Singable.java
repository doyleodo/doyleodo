package com.techelevator.model;

public class Singable {
	
	private int id;
	private String name;
	private String description;
	private boolean isVehicle;
	private String sound;
	private String region;
	
	
	public Singable() {
	}
	
	public Singable(int id, String name, String description, boolean isVehicle, String sound, String region) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.isVehicle = isVehicle;
		this.sound = sound;
		this.region = region;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVehicle() {
		return isVehicle;
	}

	public void setVehicle(boolean isVehicle) {
		this.isVehicle = isVehicle;
	}

	public void setAnimal(boolean isVehicle) {
		this.isVehicle = isVehicle;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	
}