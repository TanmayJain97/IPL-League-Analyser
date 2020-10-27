package com.bridgelabz.IPLanalyzer.model;

import com.opencsv.bean.CsvBindByName;

public class BowlerData {
	
	@CsvBindByName(column = "POS")
	private int pos;
	@CsvBindByName(column = "PLAYER")
	private String player;
	@CsvBindByName(column = "Mat")
	private int matches;
	@CsvBindByName(column = "Inns")
	private int innings;
	@CsvBindByName(column = "Ov")
	private Double oversBowled;
	@CsvBindByName(column = "Runs")
	private int runsGiven;
	@CsvBindByName(column = "Wkts")
	private int wickets;
	@CsvBindByName(column = "BBI")
	private int bbi;
	@CsvBindByName(column = "Avg")
	private String avg;
	@CsvBindByName(column = "Econ")
	private String econ;
	@CsvBindByName(column = "SR")
	private String strikeRate;
	@CsvBindByName(column = "4w")
	private int fourW;
	@CsvBindByName(column = "5w")
	private int fiveW;
	
	//Generating getters
	
	public int getPos() {
		return pos;
	}
	public String getPlayer() {
		return player;
	}
	public int getMatches() {
		return matches;
	}
	public int getInnings() {
		return innings;
	}
	public Double getOversBowled() {
		return oversBowled;
	}
	public int getRunsGiven() {
		return runsGiven;
	}
	public int getWickets() {
		return wickets;
	}
	public int getBbi() {
		return bbi;
	}
	public Double getAvg() {
		try {
			return Double.parseDouble(avg);
		}catch(NumberFormatException ex){
			return 0.00;
		}
	}
	public Double getEcon() {
		try {
			return Double.parseDouble(econ);
		}catch(NumberFormatException ex){
			return 0.00;
		}
	}
	public Double getStrikeRate() {
		try {
			return Double.parseDouble(strikeRate);
		}catch(NumberFormatException ex){
			return 0.00;
		}
	}
	public int getFourW() {
		return fourW;
	}
	public int getFiveW() {
		return fiveW;
	}
}