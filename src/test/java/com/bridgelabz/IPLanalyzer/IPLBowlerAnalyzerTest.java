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

	//Test for Sorted SR

	@Test
	public void whenSorted_ShouldReturnCorrectSROnTop() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.AVG).get(0)).getPlayer();
		assertEquals("Krishnappa Gowtham", PName);
	}

	@Test
	public void whenSorted_ShouldReturnCorrectSROnBottom() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.AVG).get(analyser.bowlingList.size()-3)).getPlayer();
		assertEquals("Liam Livingstone", PName);
	}

	//Test for Sorted Economy

	@Test
	public void whenSorted_ShouldReturnCorrectEconomyOnTop() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.ECON).get(0)).getPlayer();
		assertEquals("Ben Cutting", PName);
	}

	@Test
	public void whenSorted_ShouldReturnCorrectEconomyOnBottom() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.ECON).get(analyser.bowlingList.size()-3)).getPlayer();
		assertEquals("Shivam Dube", PName);
	}

	//Test for Sorted SR,4w/5w

	@Test
	public void whenSorted_ShouldReturnMaxSR_Max4w_5w_OnTop() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.SR_4W_5W).get(0)).getPlayer();
		assertEquals("Krishnappa Gowtham", PName);
	}

	@Test
	public void whenSorted_ShouldReturnMinSR_Min4w_5w_OnBottom() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.SR_4W_5W).get(analyser.bowlingList.size()-1)).getPlayer();
		assertEquals("Shivam Dube", PName);
	}

	//Test for Sorted Avg,SR

	@Test
	public void whenSorted_ShouldReturnMaxAvg_MaxSROnTop() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.AVG_SR).get(0)).getPlayer();
		assertEquals("Krishnappa Gowtham", PName);
	}

	@Test
	public void whenSorted_ShouldReturnMinAvg_MinSROnBottom() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.AVG_SR).get(analyser.bowlingList.size()-1)).getPlayer();
		assertEquals("Shivam Dube", PName);
	}

	//Test for Sorted Wickets Taken,Avg

	@Test
	public void whenSorted_ShouldReturnMaxWckts_BestAvgOnTop() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.WKTS_AVG).get(0)).getPlayer();
		assertEquals("Krishnappa Gowtham", PName);
	}

	@Test
	public void whenSorted_ShouldReturnnMinWckts_LeastAvgOnBottom() throws CSVBuilderException{
		String PName=(analyser.getBowlerSortedList(BowlerSortingFunction.Order.WKTS_AVG).get(analyser.bowlingList.size()-3)).getPlayer();
		assertEquals("Liam Livingstone", PName);
	}
}