package com.example.yaron.practicep.Entities;

import com.google.gson.Gson;

import java.util.Date;

public class Stock {
	private int stockID;
	
	private int userID;
	
	private String symbol;
	
	private String name;
	
	private boolean active;
	
	private double price;
	
	private double open;
	
	private double previousClose;
	
	private double dayHigh;
	
	private double dayLow;
	
	private Date modificationDate;
	
	private Date divExDate;
	
	private Date divPayDate;
	
	private double divAnnualYield;
	
	private double divAnnualYieldPercent;
	
	private boolean favorite;

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean faverite) {
		this.favorite = faverite;
	}

	public int getStockID() {
		return stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(double previouseClose) {
		this.previousClose = previouseClose;
	}

	public double getDayHigh() {
		return dayHigh;
	}

	public void setDayHigh(double dayHigh) {
		this.dayHigh = dayHigh;
	}

	public double getDayLow() {
		return dayLow;
	}

	public void setDayLow(double dayLow) {
		this.dayLow = dayLow;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getDivExDate() {
		return divExDate;
	}

	public void setDivExDate(Date divExDate) {
		this.divExDate = divExDate;
	}

	public Date getDivPayDate() {
		return divPayDate;
	}

	public void setDivPayDate(Date divPayDate) {
		this.divPayDate = divPayDate;
	}

	public double getDivAnnualYield() {
		return divAnnualYield;
	}

	public void setDivAnnualYield(double divAnnualYield) {
		this.divAnnualYield = divAnnualYield;
	}

	public double getDivAnnualYieldPercent() {
		return divAnnualYieldPercent;
	}

	public void setDivAnnualYieldPercent(double divAnnualYieldPercent) {
		this.divAnnualYieldPercent = divAnnualYieldPercent;
	}
	
	public double getDivQuerter() {
		return divAnnualYield / 4;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
