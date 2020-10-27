package com.bridgelabz.IPLanalyzer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException;

public class IPLAnalyzerTest {

	private final String BATSMAN_CSV_PATH="./src/Resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	
	private IPLAnalyzer analyser;
	
	@Before
	public void init() {
		analyser=new IPLAnalyzer();
	}

	@Test
	public void givenBatsmanCSVFile_ShouldReturnCorrectCount() throws CSVBuilderException{
        analyser.readBatsmanData(BATSMAN_CSV_PATH);
        int batsmanDataCount=analyser.getCount(analyser.battingList);
        assertEquals(101, batsmanDataCount);
    }
	
	@Test
	public void whenSorted_ShouldReturnCorrectAvgOnTop() throws CSVBuilderException{
        analyser.readBatsmanData(BATSMAN_CSV_PATH);
        String topName=(analyser.sortByAvg().get(0)).getPlayer();
        assertEquals("MS Dhoni", topName);
    }
	
	@Test
	public void whenSorted_ShouldReturnCorrectAvgOnBottom() throws CSVBuilderException{
        analyser.readBatsmanData(BATSMAN_CSV_PATH);
        String topName=(analyser.sortByAvg().get(analyser.battingList.size()-1)).getPlayer();
        assertEquals("Tim Southee", topName);
    }
}
