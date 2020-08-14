package com.techelevator.model;

import java.math.BigDecimal;

public class Supplies {
	private int supplyId;
	private String supplyName;
	private BigDecimal supplyCost;
	
	
	
	
public Supplies() {
		
	}
	public Supplies(int supplyId, String supplyName, BigDecimal supplyCost) {
	super();
	this.supplyId = supplyId;
	this.supplyName = supplyName;
	this.supplyCost = supplyCost;
		
	}
	public Supplies(String supplyName, BigDecimal supplyCost) {
		super();
		this.supplyName = supplyName;
		this.supplyCost = supplyCost;
	}
	
	
	
	
	
	
	public int getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}
	public String getSupplyName() {
		return supplyName;
	}
	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}
	public BigDecimal getSupplyCost() {
		return supplyCost;
	}
	public void setSupplyCost(BigDecimal supplyCost) {
		this.supplyCost = supplyCost;
	}
	

}
