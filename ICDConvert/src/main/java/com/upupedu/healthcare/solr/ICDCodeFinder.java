package com.upupedu.healthcare.solr;

import java.util.List;

import com.aol.pubt.solrbeans.SOLRResponseBean;

public class ICDCodeFinder {
	private ICDCodeSearchBean.SOLR solr = new ICDCodeSearchBean.SOLR();
	public ICDCodeSearchBean findIcd10Detail(String icd9code){
		ICDCodeSearchBean detail = new ICDCodeSearchBean();
		SOLRResponseBean<ICDCodeSearchBean> result = solr.getBean("(pkey_cat:icd9-icd10 OR pkey_cat:icd9) AND icd9_code:"+icd9code, 0, 10);
		List<ICDCodeSearchBean> icd9all= result.getBeans();
		for(ICDCodeSearchBean c:icd9all){
			if (c.getCategory().equals("icd9")){
				detail.setIcd9Description(c.getIcd9Description());
				detail.setIcd9Abbreviation(c.getIcd9Abbreviation());

			}

			if (c.getCategory().equals("icd9-icd10")){
				detail.setIcd10Code(c.getIcd10Code());
				detail.setIcd9Code(c.getIcd9Code());
				SOLRResponseBean<ICDCodeSearchBean> icd10 = solr.getBean("(pkey_cat:icd10pcs OR pkey_cat:icd10cm)  AND icd_code_i:"+c.getIcd10Code()+" AND axis1:"+c.getIcd10Code().substring(0,1), 0, 5);
				List<ICDCodeSearchBean> icd10all= icd10.getBeans();
				for (ICDCodeSearchBean i10:icd10all){
					detail.setIcd10Definition3(i10.getIcd10Definition3());
					detail.setIcd10Label1(i10.getIcd10Label1());
					detail.setIcd10Label2(i10.getIcd10Label2());
					detail.setIcd10Label3(i10.getIcd10Label3());
					detail.setIcd10Label4(i10.getIcd10Label4());
					detail.setIcd10Label5(i10.getIcd10Label5());
					detail.setIcd10Label6(i10.getIcd10Label6());
					detail.setIcd10Label7(i10.getIcd10Label7());
				}
			}
		}
		return detail;
	}

}
