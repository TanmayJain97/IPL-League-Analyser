package com.bridgelabz.IPLanalyzer.sortingFunction;

import java.util.Comparator;

import com.bridgelabz.IPLanalyzer.model.BatsmanData;

public class BatsmanSortingFunction implements Comparator<BatsmanData>{

	public enum Order {
		AVG, SR, BOUNDARIES, SR_BOUNDRIES, AVG_SR, RUNS_AVG, HUNDREDS_AVG
	}

	public Order sortOrder;

	public BatsmanSortingFunction(Order sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(BatsmanData o1, BatsmanData o2) {

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
		case BOUNDARIES:{
			if(o1.getNoOffours()+o1.getNoOfsixes()>o2.getNoOffours()+o1.getNoOfsixes()) return -1;
			else if(o1.getNoOffours()+o1.getNoOfsixes()<o2.getNoOffours()+o1.getNoOfsixes()) return 1;
			return 0;
		}
		case SR_BOUNDRIES:{
			if(o1.getStrikeRate()==o2.getStrikeRate()) {
				sortOrder=Order.BOUNDARIES;
				return this.compare(o1, o2);
			}
			else if(o1.getStrikeRate()<o2.getStrikeRate()) return 1;
			return -1;
		}
		case AVG_SR:{
			if(o1.getAvg()==o2.getAvg()) {
				sortOrder=Order.SR;
				return this.compare(o1, o2);
			}
			else if(o1.getAvg()<o2.getAvg()) return 1;
			return -1;
		}
		case RUNS_AVG:{
			if(o1.getRuns()==o2.getRuns()) {
				sortOrder=Order.AVG;
				return this.compare(o1, o2);
			}
			else if(o1.getRuns()<o2.getRuns()) return 1;
			return -1;
		}
		case HUNDREDS_AVG:{
			if(o1.getNoOfhundreds()==o2.getNoOfhundreds()) {
				sortOrder=Order.AVG;
				return this.compare(o1, o2);
			}
			else if(o1.getNoOfhundreds()<o2.getNoOfhundreds()) return 1;
			return -1;
		}
		}
		return 0;
	}
}
