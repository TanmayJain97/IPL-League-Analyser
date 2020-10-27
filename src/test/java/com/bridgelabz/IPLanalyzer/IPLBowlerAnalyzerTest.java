package com.bridgelabz.IPLanalyzer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.IPLanalyzer.sortingFunction.BowlerSortingFunction;
import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException;

public class IPLBowlerAnalyzerTest {

	private final String BOWLER_CSV_PATH="./src/Resources/WP DP Data_02 IPL2019FactsheetMostWkts.csv";
	
	private IPLAnalyzer analyser;

	@Before
	public void init() throws CSVBuilderException {
		analyser=new IPLAnalyzer();
		analyser.readBowlerData(BOWLER_CSV_PATH);
	}

	@Test
	public void givenBowlerCSVFile_ShouldReturnCorrectCount(){
		int bowlerDataCount=analyser.getCount(analyser.bowlingList);
		assertEquals(101, bowlerDataCount);
	}

	//Test for Sorted Avg

	@Test
	public void whenSorted_ShouldReturnCorrectAvgOnTop() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.AVG).get(0)).getPlayer();
		assertEquals("Krishnappa Gowtham", PName);
	}

	@Test
	public void whenSorted_ShouldReturnCorrectAvgOnBottom() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.AVG).get(analyser.bowlingList.size()-3)).getPlayer();
		assertEquals("Liam Livingstone", PName);
	}
}