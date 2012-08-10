package com.upupedu.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tracer {
	private static Logger logger = LoggerFactory.getLogger(Tracer.class);
	public String getTraceFileBaseName() {
		return traceFileBaseName;
	}
	public void setTraceFileBaseName(String traceFileBaseName) {
		this.traceFileBaseName = traceFileBaseName;
	}
	public String getTraceFolder() {
		return traceFolder;
	}
	public void setTraceFolder(String traceFolder) {
		this.traceFolder = traceFolder;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	private String traceFileBaseName;
	private String traceFolder;
	private String header;
	private String endOfLine="\r\n";
	private SimpleDateFormat datefmt = new SimpleDateFormat("yyyyMMdd");
	private File file;
	public void init(){
		file = new File(traceFolder+traceFileBaseName);
	}
	public void trace(String message){
		FileWriter writer=null;
		try{
			if (!file.exists()){
				file.createNewFile();
				writer = new FileWriter(file,true);
				if(header !=null)
					writer.write(header+endOfLine);
			}
			else
				writer = new FileWriter(file,true);
			writer.write(message+endOfLine);
			writer.flush();
			writer.close();
		}catch(IOException e){
			logger.error(message);
		}finally{
			
		}
	}
	
	

}
