package com.bridgelabz.IPLanalyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.bridgelabz.IPLanalyzer.model.BatsmanData;
import com.bridgelabz.IPLanalyzer.model.BowlerData;
import com.bridgelabz.IPLanalyzer.model.CricketerData;
import com.bridgelabz.IPLanalyzer.sortingFunction.BatsmanSortingFunction;
import com.bridgelabz.IPLanalyzer.sortingFunction.BowlerSortingFunction;
import com.bridgelabz.IPLanalyzer.sortingFunction.CricketerSortingFunction;
import com.bridgelabz.censusAnalyzer.csvbuilder.CSVBuilderFactory;
import com.bridgelabz.censusAnalyzer.csvbuilder.ICSVBuilder;
import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException;
import com.bridgelabz.censusAnalyzer.csvbuilder.exception.CSVBuilderException.ExceptionType;

public class IPLAnalyzer {

	List<BatsmanData> battingList;
	List<BowlerData> bowlingList;
	List<CricketerData> cricketerList;

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

	public void readBowlerData(String FilePath) throws CSVBuilderException{

		try {
			Files.newBufferedReader(Paths.get(FilePath));
			Reader reader=Files.newBufferedReader(Paths.get(FilePath));

			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			bowlingList=csvBuilder.getCSVList(reader, BowlerData.class);

		}catch(IOException exception) {
			throw new CSVBuilderException("Invalid Path Name",
					ExceptionType.INVALID_FILE_PATH);
		}catch(RuntimeException exception){
			throw new CSVBuilderException("Invalid Delimitor/Head Name",
					ExceptionType.INVALID_DELIM_OR_HEAD);
		}
	}
	
	public void populateCricketerList() {
		
		for (BatsmanData batsman:battingList) {
			for (BowlerData bowler:bowlingList) {
				if(batsman.getPlayer().equals(bowler.getPlayer())) {
					CricketerData cricketer=new CricketerData(batsman, bowler);
					cricketerList.add(cricketer);
				}
			}
		}
	}

	public int getCount(List list) {
		return list.size();
	}

	public List<BatsmanData> getBatsmanSortedList(BatsmanSortingFunction.Order sortOrder) throws CSVBuilderException{
		if(battingList==null||battingList.size()==0)
			throw new CSVBuilderException("No Census Data", ExceptionType.NO_DATA);
		BatsmanSortingFunction sort=new BatsmanSortingFunction(sortOrder);
		Collections.sort(battingList,sort);
		return battingList;
	}
	
	public List<BowlerData> getBowlerSortedList(BowlerSortingFunction.Order sortOrder) throws CSVBuilderException{
		if(bowlingList==null||bowlingList.size()==0)
			throw new CSVBuilderException("No Census Data", ExceptionType.NO_DATA);
		BowlerSortingFunction sort=new BowlerSortingFunction(sortOrder);
		Collections.sort(bowlingList,sort);
		return bowlingList;
	}
	
	public List<CricketerData> getCricketerSortedList(CricketerSortingFunction.Order sortOrder) throws CSVBuilderException{
		if(cricketerList==null||cricketerList.size()==0)
			throw new CSVBuilderException("No Census Data", ExceptionType.NO_DATA);
		CricketerSortingFunction sort=new CricketerSortingFunction(sortOrder);
		Collections.sort(cricketerList,sort);
		return cricketerList;
	}
}