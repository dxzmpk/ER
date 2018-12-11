package com.leftBoundaryFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.tags.Tags;

public class Count {
	public List<Boundary> getBoundaryNum(String textLine){
		return null;
//		Map<String,String> boundMap = new HashMap<>();
//		String[] seperate = textLine.split("	");
//		List<Boundary> boundList = new ArrayList<>();
//		Boundary boundary = new Boundary();
//		Tags tag = Tags.getTagByName(seperate[1]);
//		boundary.setName(seperate[0]);
//		boundary.setTag(tag);
//		if(seperate[1].equals(""))
//		boundMap.put(seperate, value)
//		return boundList;
	}

	public static Map<String, Integer> typeAnalysis(List<Boundary> boundList) {
		Map<String, Integer> analysisMap = new HashMap<>();
		analysisMap.put("B-protein", 0);
		analysisMap.put("I-protein", 0);
		analysisMap.put("B-cell_type", 0);
		analysisMap.put("I-cell_type", 0);
		analysisMap.put("I-DNA", 0);
		analysisMap.put("I-RNA", 0);
		analysisMap.put("B-DNA", 0);
		analysisMap.put("B-RNA", 0);
		for(Boundary boundary : boundList) {
			Iterator<String> analyIterator = analysisMap.keySet().iterator();   
         	while (analyIterator.hasNext()) {
         		String type = (String) analyIterator.next();
         		if(boundary.getTagName().equals(type)) {
         			Integer temp = analysisMap.get(type);
         			temp++;
         			analysisMap.put(type, temp);
         		}
         	}
		}
//		Iterator<String> iterator = boundMap.keySet().iterator();                
//        while (iterator.hasNext()) {    
//         String key = (String) iterator.next();    
//         	Iterator<String> analyIterator = analysisMap.keySet().iterator();   
//         	while (analyIterator.hasNext()) {
//         		String type = (String) analyIterator.next();
//         		if(boundMap.get(key).equals(type)) {
//         			Integer temp = analysisMap.get(type);
//         			temp++;
//         			System.out.println(temp);
//         			analysisMap.put(type, temp);
//         		}
//         	}
//        }           
        System.out.println(analysisMap.toString());
		return analysisMap;
	}
}
