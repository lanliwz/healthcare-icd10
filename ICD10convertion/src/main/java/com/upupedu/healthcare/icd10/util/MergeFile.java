package com.upupedu.healthcare.icd10.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.upupedu.util.Tracer;

public class MergeFile {
	private String outputDelimit=",";
	public String[] transform(String in,int length){
		String output="";
		String[] inputs=new String[2];
		inputs[0]=in.substring(0,length-1).trim();
		inputs[1]="\""+in.substring(length, in.length()).replace("\""," ").replace("'"," ")+"\"";

		return inputs;
	}
	public void merge(String id){
		File  f1 = new File("c:\\icd10\\icd9\\cms30_desc_short_"+id+".txt");
		List<String> lookup = new ArrayList<String>();
		File  f2 = new File("c:\\icd10\\icd9\\icd9_"+id+"_long.csv");
		Tracer tracer = new Tracer();
		tracer.setHeader("pkey,pkey_cat,icd9_code,desc_long,desc_short");
		tracer.setTraceFileBaseName("icd9_"+id+ ".csv");
		tracer.setTraceFolder("c:\\icd10\\icd9\\");
		tracer.init();
		try {
			FileReader fr = new FileReader(f1);
			BufferedReader bfr = new BufferedReader(fr);
			String line=null;

			while((line = bfr.readLine())!=null){
				lookup.add(this.transform(line,6)[1]);
			}
			
			fr=new FileReader(f2);
			bfr = new BufferedReader(fr);
			int l=0;
			while((line = bfr.readLine())!=null){
				if (l>0){
				line = line+","+ lookup.get(l-1);
				tracer.trace(line);
				}
				l++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		MergeFile m = new MergeFile();
		m.merge("sg");
		m.merge("dx");
	}
	

}
