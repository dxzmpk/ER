package com.leftBoundaryFeature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class LeftBoundaryWrapper {
	private List<Boundary> leftBoundList;
	public void setBoundaryFeature(String fileName) {
		File outputFile = new File("src/data/featureData/feature.txt");
	    BufferedWriter out = null; 
		try {
	        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));  
	        FileInput setFeatureClass = new FileInput();
	        leftBoundList = setFeatureClass.getFeature(fileName);
	        List<Boundary> wordList = setFeatureClass.getBoundMap();
	        for(Boundary word : wordList) {
	        	
	        	if(word.getName().equals("dxzmpk")) {
	        		out.write("\n");
	        		continue;
	        	}
	        	if(existsInList(word.getName())) {
	        		out.write(word.getName()+" "+"Y"+" "+word.getTagName()+"\n");
	        	} else {
	        		out.write(word.getName()+" "+"N"+" "+word.getTagName()+"\n");
	        	}
	        }
	        System.out.println("feature setted , get feature.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean existsInList(String name) {
		for(Boundary leftBoundary : leftBoundList) {
    		if(leftBoundary.getName().equals(name)) {
    			return true;
    		}
    	}
		return false;
	}
	public List<Boundary> getLeftBoundList() {
		return leftBoundList;
	}
	public void setLeftBoundList(List<Boundary> leftBoundList) {
		this.leftBoundList = leftBoundList;
	}
	}
