package com.upupedu.healthcare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ICD implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ICD9> icd9s=new ArrayList<ICD9>();
	private List<ICD10> icd10s=new ArrayList<ICD10>();
	public List<ICD9> getIcd9s() {
		return icd9s;
	}
	public void setIcd9s(List<ICD9> icd9s) {
		this.icd9s = icd9s;
	}
	public List<ICD10> getIcd10s() {
		return icd10s;
	}
	public void setIcd10s(List<ICD10> icd10s) {
		this.icd10s = icd10s;
	}
	
	
	

	

}
