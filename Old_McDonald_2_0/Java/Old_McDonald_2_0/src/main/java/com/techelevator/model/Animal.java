package com.techelevator.model;

public class Animal {
	
	private String name;
	private String region;
	private String sound;
	
	public Animal() {
	}
	
	public Animal(String name, String region, String sound) {
		this.name = name;
		this.region = region;
		this.sound = sound;
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