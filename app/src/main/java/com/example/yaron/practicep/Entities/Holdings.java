package com.example.yaron.practicep.Entities;

import com.google.gson.Gson;

public class Holdings {
	private int holdingsID;
	
	private int userID;
	
	private String symbol;
	
	private String name;

	private boolean active;
	
	private double purchasePrice;
	
	private int numberOfShares;
	
	private String purchaseDate;

	public int getHoldingsID() {
		return holdingsID;
	}

	public void setHoldingsID(int holdingsID) {
		this.holdingsID = holdingsID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
