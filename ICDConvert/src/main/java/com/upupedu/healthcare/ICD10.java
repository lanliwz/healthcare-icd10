package com.upupedu.healthcare;

import java.io.Serializable;



public class ICD10 implements Serializable {

    private String icd10Code;
    
    private String icd10Definition3;
    
    private String icd10Label1;
    
   
    private String icd10Label2;
    
 
    private String icd10Label3;
   
    private String icd10Label4;
   
    private String icd10Label5;
   
    private String icd10Label6;
    
    private String icd10Label7;
    
    public ICD10(String code){
    	this.icd10Code=code;
    }

	public String getIcd10Code() {
		return icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

	public String getIcd10Definition3() {
		return icd10Definition3;
	}

	public void setIcd10Definition3(String icd10Definition3) {
		this.icd10Definition3 = icd10Definition3;
	}

	public String getIcd10Label1() {
		return icd10Label1;
	}

	public void setIcd10Label1(String icd10Label1) {
		this.icd10Label1 = icd10Label1;
	}

	public String getIcd10Label2() {
		return icd10Label2;
	}

	public void setIcd10Label2(String icd10Label2) {
		this.icd10Label2 = icd10Label2;
	}

	public String getIcd10Label3() {
		return icd10Label3;
	}

	public void setIcd10Label3(String icd10Label3) {
		this.icd10Label3 = icd10Label3;
	}

	public String getIcd10Label4() {
		return icd10Label4;
	}

	public void setIcd10Label4(String icd10Label4) {
		this.icd10Label4 = icd10Label4;
	}

	public String getIcd10Label5() {
		return icd10Label5;
	}

	public void setIcd10Label5(String icd10Label5) {
		this.icd10Label5 = icd10Label5;
	}

	public String getIcd10Label6() {
		return icd10Label6;
	}

	public void setIcd10Label6(String icd10Label6) {
		this.icd10Label6 = icd10Label6;
	}

	public String getIcd10Label7() {
		return icd10Label7;
	}

	public void setIcd10Label7(String icd10Label7) {
		this.icd10Label7 = icd10Label7;
	}
    

}
