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
import com.leftBoundaryFeature.LeftBoundaryWrapper;

public class Predicter {
	public static void predictByModel(String testFileName,String trainFileName) {
		File inputFile = new File(testFileName);
		File outputFile = new File("src/data/testData/test1Answer.txt");
		BufferedReader in = null;  
	    BufferedWriter out = null; 
	    
	    //TAGGER
	    Tagger tagger = new Tagger("-m src/data/Model/model -v 3 -n2");
	    // clear internal context
	    tagger.clear();
		try {
			LeftBoundaryWrapper leftBoundaryWrapper = new LeftBoundaryWrapper();
//			leftBoundaryWrapper.setBoundaryFeature("src/data/trainData/Genia4ERtask1.iob2");
			leftBoundaryWrapper.setBoundaryFeature(trainFileName);
			in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "gbk"));  
	        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));  
	        String line ;  
	        while((line = in.readLine())!=null){  
	        	if(leftBoundaryWrapper.existsInList(line)) {
	        		tagger.add(line+" "+"Y");
	        	}else {
	        		tagger.add(line+" "+"N");
	        	}
	        }  
		System.out.println("column size: " + tagger.xsize());
	    System.out.println("token size: " + tagger.size());
	    System.out.println("tag size: " + tagger.ysize());

	    System.out.println("tagset information:");
//	    for (int i = 0; i < tagger.ysize(); ++i) {
//	      System.out.println("tag " + i + " " + tagger.yname(i));
//	    }
	    // parse and change internal stated as 'parsed'
	    if (!tagger.parse())
	      return;
//	    System.out.println("conditional prob=" + tagger.prob()
//	                       + " log(Z)=" + tagger.Z());
	    String myLine ;
	    for (int i = 0; i < tagger.size(); ++i) {
	    	if(tagger.x(i, 0).startsWith("###MEDLINE")) {
	    		out.write(tagger.x(i, 0)+"\n\n");
	    		continue;
	    	}
		    myLine = "";
		    myLine += (tagger.x(i, 0) + "	");
		    myLine += (tagger.y2(i));
		    out.write(myLine+"\n");
	    }

	    // when -n20 is specified, you can access nbest outputs
//	    System.out.println("nbest outputs:");
//	    for (int n = 0; n < 10; ++n) {
//	      if (! tagger.next()) break;
//	      System.out.println("nbest n=" + n + "\tconditional prob=" + tagger.prob());
//	      // you can access any information using tagger.y()...
//	    }
	    System.out.println("Predict Done , get test1Answer.txt");
	    in.close();
        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static {
		  try {
			System.loadLibrary("/lib/libcrfpp");
		    System.loadLibrary("/lib/CRFPP3");
		  } catch (UnsatisfiedLinkError e) {
		    System.err.println("Cannot load the example native code.\nMake sure your LD_LIBRARY_PATH contains \'.\'\n" + e);
		    System.exit(1);
		  }
		}
}
