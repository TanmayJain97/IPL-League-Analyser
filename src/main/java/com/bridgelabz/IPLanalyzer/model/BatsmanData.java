package com.bridgelabz.IPLanalyzer.model;

import com.opencsv.bean.CsvBindByName;

public class BatsmanData {
	
	@CsvBindByName(column = "POS")
	private String pos;
	@CsvBindByName(column = "PLAYER")
	private String player;
	@CsvBindByName(column = "Mat")
	private String matches;
	@CsvBindByName(column = "Inns")
	private String innings;
	@CsvBindByName(column = "NO")
	private String notOuts;
	@CsvBindByName(column = "Runs")
	private String runs;
	@CsvBindByName(column = "HS")
	private String highScore;
	@CsvBindByName(column = "Avg")
	private String avg;
	@CsvBindByName(column = "BF")
	private String bf;
	@CsvBindByName(column = "SR")
	private String strikeRate;
	@CsvBindByName(column = "100")
	private String noOfhundreds;
	@CsvBindByName(column = "50")
	private String noOffifties;
	@CsvBindByName(column = "4s")
	private String noOffours;
	@CsvBindByName(column = "6s")
	private String noOfsixes;
	
	//Generating getters
	
	public String getPos() {
		return pos;
	}
	public String getPlayer() {
		return player;
	}
	public String getMatches() {
		return matches;
	}
	public String getInnings() {
		return innings;
	}
	public String getNotOuts() {
		return notOuts;
	}
	public String getRuns() {
		return runs;
	}
	public String getHighScore() {
		return highScore;
	}
	public Double getAvg() {
		try {
			return Double.parseDouble(avg);
		}catch(NumberFormatException ex){
			return 0.00;
		}
	}
	public String getBf() {
		return bf;
	}
	public Double getStrikeRate() {
		try {
			return Double.parseDouble(strikeRate);
		}catch(NumberFormatException ex){
			return 0.00;
		}
	}
	public String getNoOfhundreds() {
		return noOfhundreds;
	}
	public String getNoOffifties() {
		return noOffifties;
	}
	public String getNoOffours() {
		return noOffours;
	}
	public String getNoOfsixes() {
		return noOfsixes;
	}
}