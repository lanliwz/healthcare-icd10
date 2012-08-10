package com.upupedu.healthcare.icd10.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.upupedu.util.Tracer;

public class Icd9to10Transformer {
	private String inputDelimit="( )+";
	private String outputDelimit=",";
	
	public String transform(String in){
		String output="";
		String[] inputs=in.split(inputDelimit);
//		output = inputs[0]+outputDelimit+inputs[1].substring(0,2)+"."+inputs[1].substring(3,inputs[1].length()-1)+outputDelimit+inputs[2];

		if (inputs[1].trim().length()>3){
			inputs[1]=inputs[1].substring(0,3)+"."+inputs[1].substring(3,inputs[1].length());
		}
		for (int i=0;i<inputs.length-1;i++){
			output=output+inputs[i]+outputDelimit;
		}
		output=output+inputs[inputs.length-1];
		output=inputs[0]+"-"+inputs[1]+outputDelimit+"icd9-icd10"+outputDelimit+output;
		return output;
		
	}
	public static void main(String[] args){
		File  f = new File("c:\\icd10\\2012_I9gem.txt");
		Tracer tracer = new Tracer();
		tracer.setHeader("pkey,pkey_cat,icd9_code,icd10_code,flags");
		tracer.setTraceFileBaseName("icd9_10gem.csv");
		tracer.setTraceFolder("c:\\icd10\\");
		tracer.init();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String line=null;
			Icd9to10Transformer t=new Icd9to10Transformer();
			while((line = bfr.readLine())!=null){
				tracer.trace(t.transform(line));
				System.out.println(t.transform(line));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
