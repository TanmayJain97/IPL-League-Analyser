package com.bridgelabz.IPLanalyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.bridgelabz.IPLanalyzer.model.BatsmanData;
import com.bridgelabz.IPLanalyzer.sortingFunction.BatsmanSortingFunction;
import com.bridgelabz.censusAnalyzer.csvbuilder.CSVBuilderFactory;
import com.bridgelabz.censusAnalyzer.csvbuilder.ICSVBuilder;
import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException;
import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException.ExceptionType;

public class IPLAnalyzer {
	
	List<BatsmanData> battingList;
	
	public void readBatsmanData(String FilePath) throws CSVBuilderException{
		
		try {
			Files.newBufferedReader(Paths.get(FilePath));
			Reader reader=Files.newBufferedReader(Paths.get(FilePath));
			
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			battingList=csvBuilder.getCSVList(reader, BatsmanData.class);
			
		}catch(IOException exception) {
			throw new CSVBuilderException("Invalid Path Name",
					ExceptionType.INVALID_FILE_PATH);
		}catch(RuntimeException exception){
			throw new CSVBuilderException("Invalid Delimitor/Head Name",
					ExceptionType.INVALID_DELIM_OR_HEAD);
		}
	}
	
	public int getCount(List list) {
		return list.size();
	}
	
	public List<BatsmanData> getSortedList(BatsmanSortingFunction.Order sortOrder) throws CSVBuilderException{
		if(battingList==null||battingList.size()==0)
			throw new CSVBuilderException("No Census Data", ExceptionType.NO_DATA);
		BatsmanSortingFunction sort=new BatsmanSortingFunction(sortOrder);
		Collections.sort(battingList,sort);
		return battingList;
	}
}