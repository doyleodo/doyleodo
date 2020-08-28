package com.techelevator.model;

public class Vehicle {

	private String name;
	private String sound;
	private String region;
	
	public Vehicle() {
	}
	
	public Vehicle(String name, String sound, String region) {
		super();
		this.name = name;
		this.sound = sound;
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
		
}