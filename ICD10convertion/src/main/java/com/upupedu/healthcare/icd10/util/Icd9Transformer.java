package com.upupedu.healthcare.icd10.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.upupedu.util.Tracer;

public class Icd9Transformer {
	private String outputDelimit=",";

	
	public String transform(String in,int length){
		String output="";
		String[] inputs=new String[2];
		inputs[0]=in.substring(0,length-1);
		inputs[1]=in.substring(length, in.length()).replace("\""," ").replace("'"," ");
//		for (int i=0;i<inputs.length-1;i++){
//			output=output+inputs[i]+outputDelimit;
//		}
		output=inputs[0].trim()+outputDelimit+"\""+inputs[1]+"\"";
		output=inputs[0].trim()+outputDelimit+"icd9"+outputDelimit+output;
		return output;
	}

	
	public static void main(String[] args){
		File  f = new File("c:\\icd10\\icd9\\cms30_desc_long_dx.txt");
		Tracer tracer = new Tracer();
		tracer.setHeader("pkey,pkey_cat,icd9_code,desc_long");
		tracer.setTraceFileBaseName("icd9_dx_long.csv");
		tracer.setTraceFolder("c:\\icd10\\icd9\\");
		tracer.init();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String line=null;
			Icd9Transformer t=new Icd9Transformer();
			while((line = bfr.readLine())!=null){
				tracer.trace(t.transform(line,6));
				System.out.println(t.transform(line,6));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		f = new File("c:\\icd10\\icd9\\cms30_desc_short_dx.txt");
		tracer = new Tracer();
		tracer.setHeader("pkey,pkey_cat,icd9_code,desc_short");
		tracer.setTraceFileBaseName("icd9_dx_short.csv");
		tracer.setTraceFolder("c:\\icd10\\icd9\\");
		tracer.init();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String line=null;
			Icd9Transformer t=new Icd9Transformer();
			while((line = bfr.readLine())!=null){
				tracer.trace(t.transform(line,6));
				System.out.println(t.transform(line,6));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f = new File("c:\\icd10\\icd9\\cms30_desc_short_sg.txt");
		tracer = new Tracer();
		tracer.setHeader("pkey,pkey_cat,icd9_code,desc_short");
		tracer.setTraceFileBaseName("icd9_sg_short.csv");
		tracer.setTraceFolder("c:\\icd10\\icd9\\");
		tracer.init();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String line=null;
			Icd9Transformer t=new Icd9Transformer();
			while((line = bfr.readLine())!=null){
				tracer.trace(t.transform(line,5));
				System.out.println(t.transform(line,5));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f = new File("c:\\icd10\\icd9\\cms30_desc_long_sg.txt");
		tracer = new Tracer();
		tracer.setHeader("pkey,pkey_cat,icd9_code,desc_long");
		tracer.setTraceFileBaseName("icd9_sg_long.csv");
		tracer.setTraceFolder("c:\\icd10\\icd9\\");
		tracer.init();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String line=null;
			Icd9Transformer t=new Icd9Transformer();
			while((line = bfr.readLine())!=null){
				tracer.trace(t.transform(line,5));
				System.out.println(t.transform(line,5));
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
