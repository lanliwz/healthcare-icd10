package com.upupedu.healthcare;

import java.util.List;

import com.aol.pubt.solrbeans.SOLRResponseBean;
import com.upupedu.healthcare.solr.ICDCodeSearchBean;

public class IcdService {
	
	private ICDCodeSearchBean.SOLR solr = new ICDCodeSearchBean.SOLR();
	
	public ICD findByCode9(String icd9code, int rows){
		
		ICD icd = new ICD();

		SOLRResponseBean<ICDCodeSearchBean> result = solr.getBean("(pkey_cat:icd9-icd10 OR pkey_cat:icd9) AND icd9_code:"+icd9code, 0, rows);
		List<ICDCodeSearchBean> icd9all= result.getBeans();
		for(ICDCodeSearchBean c:icd9all){
			if (c.getCategory().equals("icd9")){
				ICD9 icd9obj = new ICD9(icd9code,c.getIcd9Description(),c.getIcd9Abbreviation());
				
				icd.getIcd9s().add(icd9obj);

			}

			if (c.getCategory().equals("icd9-icd10")){
				SOLRResponseBean<ICDCodeSearchBean> icd10 = solr.getBean("(pkey_cat:icd10pcs OR pkey_cat:icd10cm)  AND icd_code_i:"+c.getIcd10Code()+" AND axis1:"+c.getIcd10Code().substring(0,1), 0, 5);
				List<ICDCodeSearchBean> icd10all= icd10.getBeans();
				for (ICDCodeSearchBean i10:icd10all){
					ICD10 icd10obj = new ICD10(i10.getIcd10Code());
					
					icd10obj.setIcd10Definition3(i10.getIcd10Definition3());
					icd10obj.setIcd10Label1(i10.getIcd10Label1());
					icd10obj.setIcd10Label2(i10.getIcd10Label2());
					icd10obj.setIcd10Label3(i10.getIcd10Label3());
					icd10obj.setIcd10Label4(i10.getIcd10Label4());
					icd10obj.setIcd10Label5(i10.getIcd10Label5());
					icd10obj.setIcd10Label6(i10.getIcd10Label6());
					icd10obj.setIcd10Label7(i10.getIcd10Label7());
					
					icd.getIcd10s().add(icd10obj);
				}
			}
		}
		return icd;
		
	}
	public ICD findByCode10(String icdcode, int rows){
		ICD icd = new ICD();

		SOLRResponseBean<ICDCodeSearchBean> result = solr.getBean("(pkey_cat:icd10-icd9 OR pkey_cat:icd10cm OR pkey_cat:icd10pcs) AND icd10_code:"+icdcode, 0, rows);
		List<ICDCodeSearchBean> icdall= result.getBeans();
		for(ICDCodeSearchBean c:icdall){
			if (c.getCategory().equals("icd10-icd9")){
				SOLRResponseBean<ICDCodeSearchBean> icd9 = solr.getBean("pkey_cat:icd9 AND icd9_code:"+c.getIcd9Code(), 0, 5);
				List<ICDCodeSearchBean> icd9all= icd9.getBeans();
				for (ICDCodeSearchBean i9:icd9all){
					ICD9 icd9obj = new ICD9(i9.getIcd9Code(),i9.getIcd9Description(),i9.getIcd9Abbreviation());
					
					icd.getIcd9s().add(icd9obj);
					
				}


			}

			if (c.getCategory().equals("icd10cm") || c.getCategory().equals("icd10pcs")){

					ICD10 icd10obj = new ICD10(c.getIcd10Code());
					
					icd10obj.setIcd10Definition3(c.getIcd10Definition3());
					icd10obj.setIcd10Label1(c.getIcd10Label1());
					icd10obj.setIcd10Label2(c.getIcd10Label2());
					icd10obj.setIcd10Label3(c.getIcd10Label3());
					icd10obj.setIcd10Label4(c.getIcd10Label4());
					icd10obj.setIcd10Label5(c.getIcd10Label5());
					icd10obj.setIcd10Label6(c.getIcd10Label6());
					icd10obj.setIcd10Label7(c.getIcd10Label7());
					
					icd.getIcd10s().add(icd10obj);
				}
			}
		
		return icd;
	}
	public ICD findByKeywords(String keywords,int rows){
		ICD icd = new ICD();
		SOLRResponseBean<ICDCodeSearchBean> result = solr.getBean(keywords, 0, rows);
		List<ICDCodeSearchBean> icdall= result.getBeans();
		for(ICDCodeSearchBean c:icdall){
			if (c.getCategory().equals("icd9")){

					ICD9 icd9obj = new ICD9(c.getIcd9Code(),c.getIcd9Description(),c.getIcd9Abbreviation());
					
					icd.getIcd9s().add(icd9obj);
					



			}

			else if (c.getCategory().equals("icd10cm") || c.getCategory().equals("icd10pcs")){

					ICD10 icd10obj = new ICD10(c.getIcd10Code());
					
					icd10obj.setIcd10Definition3(c.getIcd10Definition3());
					icd10obj.setIcd10Label1(c.getIcd10Label1());
					icd10obj.setIcd10Label2(c.getIcd10Label2());
					icd10obj.setIcd10Label3(c.getIcd10Label3());
					icd10obj.setIcd10Label4(c.getIcd10Label4());
					icd10obj.setIcd10Label5(c.getIcd10Label5());
					icd10obj.setIcd10Label6(c.getIcd10Label6());
					icd10obj.setIcd10Label7(c.getIcd10Label7());
					
					icd.getIcd10s().add(icd10obj);
				}
			}
		return icd;
	}
	

}
