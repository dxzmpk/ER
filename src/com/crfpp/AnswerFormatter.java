package com.crfpp;

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

import com.leftBoundaryFeature.Boundary;
import com.leftBoundaryFeature.Count;
import com.leftBoundaryFeature.LeftBoundaryAnalysis;

public class AnswerFormatter {
	public static void main(String[] args) {
		File inputFile1 = new File("src/data/testData/test1Answer.txt");
		File inputFile2 = new File("src/data/testData/Genia4EReval2.raw");
		File outputFile = new File("src/data/testData/test1AnswerForamatted.txt");
		BufferedReader in1 = null;  
		BufferedReader in2 = null; 
	    BufferedWriter out = null; 
		try {
			in1 = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile1), "gbk"));  
			in2 = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile2), "gbk"));  
	        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));  
	        String line1 = ""; 
	        String line2 = "";  
	        while((line1 = in1.readLine())!=null&&(line2 = in2.readLine())!=null) {
	        	if(line2.equals("")&&(!line1.equals(""))) {
//	        		System.out.println(line1);
//	        		System.out.println("命中");
	        		out.write("\n");
	        		out.write(line1+"\n");
	        		line2 = in2.readLine();
	        		continue;
	        	}
	        	out.write(line1+"\n");
	        }
	        out.write("\n");
	        System.out.println("file formatted , get test1AnswerForamatted.txt");
	        in1.close();
	        in2.close();
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
