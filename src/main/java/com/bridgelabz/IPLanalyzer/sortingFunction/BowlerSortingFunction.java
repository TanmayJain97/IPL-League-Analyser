package com.bridgelabz.IPLanalyzer.sortingFunction;

import java.util.Comparator;

import com.bridgelabz.IPLanalyzer.model.BowlerData;

public class BowlerSortingFunction implements Comparator<BowlerData> {

	public Order sortOrder;
	
	public enum Order {
		AVG, SR, ECON, SR_4w_5w, Avg_SR
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
		case ECON:{
			if(o1.getEcon()>o2.getEcon()) return -1;
			else if(o1.getEcon()<o2.getEcon()) return 1;
			return 0;
		}
		case SR_4w_5w:{
			if(o1.getStrikeRate()==o2.getStrikeRate()) {
				if(o1.getFourW()+o1.getFiveW()>o2.getFourW()+o1.getFiveW()) return -1;
				else if(o1.getFourW()+o1.getFiveW()<o2.getFourW()+o1.getFiveW()) return 1;
				return 0;
			}
			else if(o1.getStrikeRate()<o2.getStrikeRate()) return 1;
			return -1;
		}
		case Avg_SR:{
			if(o1.getAvg()==o2.getAvg()) {
				sortOrder=Order.SR;
				this.compare(o1, o2);
			}
			else if(o1.getAvg()<o2.getAvg()) return 1;
			return -1;
		}
		}
		return 0;
	}
}