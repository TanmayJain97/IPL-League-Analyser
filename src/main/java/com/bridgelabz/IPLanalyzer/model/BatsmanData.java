package com.bridgelabz.IPLanalyzer.model;

import com.opencsv.bean.CsvBindByName;

public class BatsmanData {
	
	@CsvBindByName(column = "POS")
	private int pos;
	@CsvBindByName(column = "PLAYER")
	private String player;
	@CsvBindByName(column = "Mat")
	private int matches;
	@CsvBindByName(column = "Inns")
	private int innings;
	@CsvBindByName(column = "NO")
	private int timesNotOut;
	@CsvBindByName(column = "Runs")
	private int runs;
	@CsvBindByName(column = "HS")
	private String highScore;
	@CsvBindByName(column = "Avg")
	private String avg;
	@CsvBindByName(column = "BF")
	private int bf;
	@CsvBindByName(column = "SR")
	private Double strikeRate;
	@CsvBindByName(column = "100")
	private int noOfhundreds;
	@CsvBindByName(column = "50")
	private int noOffifties;
	@CsvBindByName(column = "4s")
	private int noOffours;
	@CsvBindByName(column = "6s")
	private int noOfsixes;
	
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
	public int getTimesNotOut() {
		return timesNotOut;
	}
	public int getRuns() {
		return runs;
	}
	public int getHighScore() {
		if(highScore.contains("*")) highScore=highScore.replace("*", "");
		try {
			return Integer.parseInt(highScore);
		}catch(NumberFormatException ex){
			return 0;
		}
	}
	public Double getAvg() {
		try {
			return Double.parseDouble(avg);
		}catch(NumberFormatException ex){
			return 0.00;
		}
	}
	public int getBf() {
		return bf;
	}
	public Double getStrikeRate() {
		return strikeRate;
	}
	public int getNoOfhundreds() {
		return noOfhundreds;
	}
	public int getNoOffifties() {
		return noOffifties;
	}
	public int getNoOffours() {
		return noOffours;
	}
	public int getNoOfsixes() {
		return noOfsixes;
	}
}