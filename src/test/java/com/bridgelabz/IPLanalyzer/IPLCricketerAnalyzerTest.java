package com.bridgelabz.IPLanalyzer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.IPLanalyzer.sortingFunction.CricketerSortingFunction;
import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException;

public class IPLCricketerAnalyzerTest {

	private final String BATSMAN_CSV_PATH="./src/Resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	private final String BOWLER_CSV_PATH="./src/Resources/WP DP Data_02 IPL2019FactsheetMostWkts.csv";
	
	private IPLAnalyzer analyser;
	
	@Before
	public void init() throws CSVBuilderException {
		analyser=new IPLAnalyzer();
		analyser.readBatsmanData(BATSMAN_CSV_PATH);
		analyser.readBowlerData(BOWLER_CSV_PATH);
		analyser.populateCricketerList();
	}
	
	@Test
	public void givenBatsman_BowlerCSVFile_ShouldReturnCorrectCountofCricketers(){
		int dataCount=analyser.getCount(analyser.cricketerList);
		assertEquals(101, dataCount);
	}
	
	//Test for sorted batting,Bowling avg
	
	@Test
	public void whenSorted_ShouldGiveMaxBatting_MaxBowlingAvg() throws CSVBuilderException{
		String PName=(analyser.getCricketerSortedList(CricketerSortingFunction.Order.COMBINED_AVG).get(0)).getBatsman().getPlayer();
		assertEquals("MS Dhoni", PName);
	}
}
