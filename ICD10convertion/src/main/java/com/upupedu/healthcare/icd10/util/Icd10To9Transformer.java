package com.upupedu.healthcare.icd10.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.upupedu.util.Tracer;

public class Icd10To9Transformer {
	private String inputDelimit="( )+";
	private String outputDelimit=",";
	
	public String transform(String in){
		String output="";
		String[] inputs=in.split(inputDelimit);
		
		if (inputs[0].trim().length()>3){
			inputs[0]=inputs[0].substring(0,3)+"."+inputs[0].substring(3,inputs[0].length());
		}
		for (int i=0;i<inputs.length-1;i++){
			output=output+inputs[i]+outputDelimit;
		}
		output=output+inputs[inputs.length-1];
		output=inputs[0]+"-"+inputs[1]+outputDelimit+"icd10-icd9"+outputDelimit+output;
		return output;
		
	}
	public static void main(String[] args){
		File  f = new File("c:\\icd10\\2012_I10gem.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			Tracer tracer = new Tracer();
			tracer.setHeader("pkey,pkey_cat,icd10_code,icd9_code,flags");
			tracer.setTraceFileBaseName("icd10_9gem.csv");
			tracer.setTraceFolder("c:\\icd10\\");
			tracer.init();
			String line=null;
			Icd10To9Transformer t=new Icd10To9Transformer();
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
