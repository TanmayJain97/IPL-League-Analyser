package com.bridgelabz.IPLanalyzer.model;

public class CricketerData {
	
	BatsmanData batsman;
	BowlerData bowler;
	
	public CricketerData(BatsmanData batsman, BowlerData bowler) {
		this.batsman = batsman;
		this.bowler = bowler;
	}

	public BatsmanData getBatsman() {
		return batsman;
	}

	public BowlerData getBowler() {
		return bowler;
	}
}