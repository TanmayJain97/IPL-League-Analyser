package com.bridgelabz.IPLanalyzer.sortingFunction;

import java.util.Comparator;

import com.bridgelabz.IPLanalyzer.model.BowlerData;

public class BowlerSortingFunction implements Comparator<BowlerData> {

	public Order sortOrder;
	
	public enum Order {
		AVG, SR
	}
	
	public BowlerSortingFunction(Order sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(BowlerData o1, BowlerData o2) {
		
		switch(sortOrder) {
		case AVG:{
			if(o1.getAvg()>o2.getAvg()) return -1;
			else if(o1.getAvg()<o2.getAvg()) return 1;
			return 0;
		}
		case SR:{
			if(o1.getStrikeRate()>o2.getStrikeRate()) return -1;
			else if(o1.getStrikeRate()<o2.getStrikeRate()) return 1;
			return 0;
		}
		}
		return 0;
	}
}