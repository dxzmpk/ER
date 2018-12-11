package com.test;

import java.io.IOException;
import java.util.Map;

import com.crfpp.Predicter;

public class Test {

	public static void main(String[] args) {
		//运行测试文件
		Predicter.predictByModel("src/data/testData/Genia4EReval2.raw","src/data/trainData/Genia4ERtask1.iob2");
//		String shpath="src/JNLPBA2004_eval/evalIOB2.pl";   //程序路径
//	    Process process =null;
//	    String command1 = "perl - version";
//	    try { 
//	      Runtime.getRuntime().exec(command1 ).waitFor(); 
//	    } catch (IOException e1) { 
//	        e1.printStackTrace(); 
//	    }catch (InterruptedException e) { 
//	         e.printStackTrace(); 
//	    }
	}
}
