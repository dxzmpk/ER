package com.leftBoundaryFeature;

import java.util.ArrayList;
import java.util.List;

public interface BoundaryAnalysis {
	public void countBoundary(List<Boundary> boundaryList);
	
	public List<Boundary> getMostFrequent(int num);
}	
