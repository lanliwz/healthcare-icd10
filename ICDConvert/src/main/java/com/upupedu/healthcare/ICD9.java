package com.upupedu.healthcare;

import java.io.Serializable;

public class ICD9 implements Serializable {
	public ICD9(String code,String desc,String abbr){
		this.icd9Code=code;
		this.icd9Abbreviation=abbr;
		this.icd9Description=desc;
		
	}
	private String icd9Code;
	private String icd9Description;
	private String icd9Abbreviation;
	public String getIcd9Code() {
		return icd9Code;
	}
	public void setIcd9Code(String icd9Code) {
		this.icd9Code = icd9Code;
	}
	public String getIcd9Description() {
		return icd9Description;
	}
	public void setIcd9Description(String icd9Description) {
		this.icd9Description = icd9Description;
	}
	public String getIcd9Abbreviation() {
		return icd9Abbreviation;
	}
	public void setIcd9Abbreviation(String icd9Abbreviation) {
		this.icd9Abbreviation = icd9Abbreviation;
	}

}
