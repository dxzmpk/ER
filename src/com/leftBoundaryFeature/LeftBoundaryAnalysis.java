package com.leftBoundaryFeature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftBoundaryAnalysis implements BoundaryAnalysis{
	ArrayList<Boundary> leftBoundary = new ArrayList<>();

	@Override
	public void countBoundary(List<Boundary> boundaryList) {
		for(Boundary boundary : boundaryList) {
			if(boundary.getTagName().startsWith("B-")) {
				int i = 0;
				for(i=0;i<leftBoundary.size();i++) {
					if(leftBoundary.get(i).getName().equals(boundary.getName())) {
						int frequency = leftBoundary.get(i).getFrequency();
						Boundary newBoundary1 = new Boundary();
						newBoundary1.setName(leftBoundary.get(i).getName());
						newBoundary1.setTagName(leftBoundary.get(i).getTagName());
						newBoundary1.setFrequency(frequency+1);
						leftBoundary.set(i, newBoundary1);
						break;
					}
				}
				if(i==leftBoundary.size()) {
					Boundary newBoundary = new Boundary();
					newBoundary.setName(boundary.getName());
					newBoundary.setFrequency(1);
					newBoundary.setTagName(boundary.getTagName());
					leftBoundary.add(newBoundary);
				}
			}
		}
		
	}
	
	
	
	
	@Override
	public List<Boundary> getMostFrequent(int num) {
		List<Boundary> mostFrequentList = new ArrayList<>();
		Comparator<Boundary> c = new Comparator<Boundary>() {
			@Override
			public int compare(Boundary o1, Boundary o2) {
				if(o1.getFrequency() < o2.getFrequency()) {
					return 1;
				}else if (o1.getFrequency() > o2.getFrequency()){
					return -1;
				}else {
					return 0;
				}
			}
		};	
		leftBoundary.sort(c);
		int i=0;
			for(Boundary boundary1 : leftBoundary) {
				mostFrequentList.add(boundary1);
				i++;
				if(i==num)break;
			}
		return mostFrequentList;
	}




	public ArrayList<Boundary> getLeftBoundary() {
		return leftBoundary;
	}

	public void setLeftBoundary(ArrayList<Boundary> leftBoundary) {
		this.leftBoundary = leftBoundary;
	}



	
	
}
