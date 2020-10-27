package com.bridgelabz.IPLanalyzer.sortingFunction;

import java.util.Comparator;

import com.bridgelabz.IPLanalyzer.model.CricketerData;

public class CricketerSortingFunction implements Comparator<CricketerData> {

public Order sortOrder;
	
	public enum Order {
		COMBINED_AVG, MAX_RUNS_WCKTS
	}
	
	public CricketerSortingFunction(Order sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(CricketerData o1, CricketerData o2) {
		
		switch(sortOrder) {
		case COMBINED_AVG:{
			if(o1.getBatsman().getAvg()==o2.getBatsman().getAvg()) {
				if(o1.getBowler().getAvg()>o2.getBowler().getAvg()) return -1;
				else if(o1.getBowler().getAvg()<o2.getBowler().getAvg()) return 1;
				return 0;
			}
			else  if(o1.getBatsman().getAvg()<o2.getBatsman().getAvg()) return 1;
			return -1;
		}
		case MAX_RUNS_WCKTS:{
			if(o1.getBatsman().getRuns()==o2.getBatsman().getRuns()) {
				if(o1.getBowler().getWickets()>o2.getBowler().getWickets()) return -1;
				else if(o1.getBowler().getWickets()<o2.getBowler().getWickets()) return 1;
				return 0;
			}
			else  if(o1.getBatsman().getRuns()<o2.getBatsman().getRuns()) return 1;
			return -1;
		}
		}
		return 0;
	}
}