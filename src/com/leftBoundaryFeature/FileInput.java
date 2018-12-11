package com.leftBoundaryFeature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileInput {
	List<Boundary> boundList = new ArrayList<>();
	public List<Boundary> getFeature(String fileName) {
		File inputFile = new File(fileName);
		File outputFile = new File("src/data/featureData/feature.txt");
		BufferedReader in = null;  
	    BufferedWriter out = null; 
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "gbk"));  
	        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));  
	        String line = "";  
	        while((line = in.readLine())!=null){  
	        	insertIntoBoundMap(line);
	        }  
	        Map<String,Integer> typeAnalysis = Count.typeAnalysis(boundList);
	        LeftBoundaryAnalysis leftBound = new LeftBoundaryAnalysis();
	        leftBound.countBoundary(boundList);
	        List<Boundary> leftBoundList = leftBound.getMostFrequent(1000);
	        int i = 0;
	        in.close();
	        out.close();
	        return leftBoundList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boundList;
	}
	
	public void insertIntoBoundMap(String textLine){
		if(textLine.equals("")) {
			Boundary boundarySpace = new Boundary();
			boundarySpace.setName("dxzmpk");
			boundarySpace.setTagName("dxzmpk");
			this.boundList.add(boundarySpace);
			return;
		}
		String[] seperate = textLine.split("	");
		Boundary boundary = new Boundary();
		if(seperate.length==2) {
			boundary.setName(seperate[0]);
			boundary.setTagName(seperate[1]);
			this.boundList.add(boundary);
		}
	}

	public List<Boundary> getBoundMap() {
		return boundList;
	}

	public void setBoundMap(List<Boundary> boundMap) {
		this.boundList = boundMap;
	}
	
	
	
}