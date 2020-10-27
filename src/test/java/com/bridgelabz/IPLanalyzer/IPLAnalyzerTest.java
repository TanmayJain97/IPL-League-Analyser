package com.bridgelabz.IPLanalyzer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.IPLanalyzer.sortingFunction.BatsmanSortingFunction;
import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException;

public class IPLAnalyzerTest {

	private final String BATSMAN_CSV_PATH="./src/Resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";

	private IPLAnalyzer analyser;

	@Before
	public void init() throws CSVBuilderException {
		analyser=new IPLAnalyzer();
		analyser.readBatsmanData(BATSMAN_CSV_PATH);
	}

	@Test
	public void givenBatsmanCSVFile_ShouldReturnCorrectCount(){
		int batsmanDataCount=analyser.getCount(analyser.battingList);
		assertEquals(101, batsmanDataCount);
	}

	//Test for Sorted Avg

	@Test
	public void whenSorted_ShouldReturnCorrectAvgOnTop() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.AVG).get(0)).getPlayer();
		assertEquals("MS Dhoni", PName);
	}

	@Test
	public void whenSorted_ShouldReturnCorrectAvgOnBottom() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.AVG).get(analyser.battingList.size()-1)).getPlayer();
		assertEquals("Tim Southee", PName);
	}

	//Test for Sorted SR

	@Test
	public void whenSorted_ShouldReturnCorrectSROnTop() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.SR).get(0)).getPlayer();
		assertEquals("Ishant Sharma", PName);
	}

	@Test
	public void whenSorted_ShouldReturnCorrectSROnBottom() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.SR).get(analyser.battingList.size()-1)).getPlayer();
		assertEquals("Bhuvneshwar Kumar", PName);
	}

	//Test for Sorted Boundries

	@Test
	public void whenSorted_ShouldReturnMaxBoundriesOnTop() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.BOUNDARIES).get(0)).getPlayer();
		assertEquals("Shikhar Dhawan", PName);
	}

	@Test
	public void whenSorted_ShouldReturnCorrectMinBoundriesOnBottom() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.BOUNDARIES).get(analyser.battingList.size()-1)).getPlayer();
		assertEquals("Tim Southee", PName);
	}

	//Test for Sorted SR,Boundries

	@Test
	public void whenSorted_ShouldReturnTopSR_MaxBoundriesOnTop() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.SR_BOUNDRIES).get(0)).getPlayer();
		assertEquals("Ishant Sharma", PName);
	}

	@Test
	public void whenSorted_ShouldReturnBottomSR_MinBoundriesOnBottom() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.SR_BOUNDRIES).get(analyser.battingList.size()-1)).getPlayer();
		assertEquals("Bhuvneshwar Kumar", PName);
	}

	//Test for Sorted Avg,SR

	@Test
	public void whenSorted_ShouldReturnTopAvg_TopSROnTop() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.AVG_SR).get(0)).getPlayer();
		assertEquals("MS Dhoni", PName);
	}

	@Test
	public void whenSorted_ShouldReturnBottomBottomAvg_BottomSROnBottom() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.AVG_SR).get(analyser.battingList.size()-1)).getPlayer();
		assertEquals("Harpreet Brar", PName);
	}

	//Test for Sorted Total Runs,Avg

	@Test
	public void whenSorted_ShouldReturnMaxRuns_TopAvgOnTop() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.RUNS_AVG).get(0)).getPlayer();
		assertEquals("David Warner", PName);
	}

	@Test
	public void whenSorted_ShouldReturnMinRuns_BottomAvgOnBottom() throws CSVBuilderException{
		String PName=(analyser.getSortedList(BatsmanSortingFunction.Order.RUNS_AVG).get(analyser.battingList.size()-1)).getPlayer();
		assertEquals("Tim Southee", PName);
	}
}