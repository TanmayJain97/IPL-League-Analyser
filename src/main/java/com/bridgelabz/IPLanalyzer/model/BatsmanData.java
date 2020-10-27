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
		try {
			return Integer.parseInt(bf);
		}catch(NumberFormatException ex){
			return 0;
		}
	}
	public Double getStrikeRate() {
		try {
			return Double.parseDouble(strikeRate);
		}catch(NumberFormatException ex){
			return 0.00;
		}
	}
	public int getNoOfhundreds() {
		try {
			return Integer.parseInt(noOfhundreds);
		}catch(NumberFormatException ex){
			return 0;
		}
	}
	public int getNoOffifties() {
		try {
			return Integer.parseInt(noOffifties);
		}catch(NumberFormatException ex){
			return 0;
		}
	}
	public int getNoOffours() {
		try {
			return Integer.parseInt(noOffours);
		}catch(NumberFormatException ex){
			return 0;
		}
		
	}
	public int getNoOfsixes() {
		try {
			return Integer.parseInt(noOfsixes);
		}catch(NumberFormatException ex){
			return 0;
		}
	}
}