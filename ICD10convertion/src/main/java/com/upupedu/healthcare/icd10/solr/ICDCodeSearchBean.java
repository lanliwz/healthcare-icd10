package com.upupedu.healthcare.icd10.solr;

import java.util.List;

import com.aol.pubt.forc.annotations.Alias;
import com.aol.pubt.forc.annotations.PropertyEntry;
import com.aol.pubt.solrbeans.SOLRAwareBean;
import com.aol.pubt.solrbeans.SOLRResponseBean;


@PropertyEntry(group="solr.icd", id="ICDCodeSearchBean")
public class ICDCodeSearchBean {
    @Alias(name = "score")
    private String searchRanking;
    
    public String getSearchRanking() {
		return searchRanking;
	}

	public void setSearchRanking(String searchRanking) {
		this.searchRanking = searchRanking;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIcd10Code() {
		return icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

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

	public String getIcd10Definition3() {
		return icd10Definition3;
	}

	public void setIcd10Definition3(String icd10Definition3) {
		this.icd10Definition3 = icd10Definition3;
	}

	public String getIcd9Label1() {
		return icd9Label1;
	}

	public void setIcd9Label1(String icd9Label1) {
		this.icd9Label1 = icd9Label1;
	}

	public String getIcd9Label2() {
		return icd9Label2;
	}

	public void setIcd9Label2(String icd9Label2) {
		this.icd9Label2 = icd9Label2;
	}

	public String getIcd9Label3() {
		return icd9Label3;
	}

	public void setIcd9Label3(String icd9Label3) {
		this.icd9Label3 = icd9Label3;
	}

	public String getIcd9Label4() {
		return icd9Label4;
	}

	public void setIcd9Label4(String icd9Label4) {
		this.icd9Label4 = icd9Label4;
	}

	public String getIcd9Label5() {
		return icd9Label5;
	}

	public void setIcd9Label5(String icd9Label5) {
		this.icd9Label5 = icd9Label5;
	}

	public String getIcd9Label6() {
		return icd9Label6;
	}

	public void setIcd9Label6(String icd9Label6) {
		this.icd9Label6 = icd9Label6;
	}

	public String getIcd9Label7() {
		return icd9Label7;
	}

	public void setIcd9Label7(String icd9Label7) {
		this.icd9Label7 = icd9Label7;
	}

	@Alias(name = "pkey")
    private String key;
    
    @Alias(name = "pkey_cat")
    private String category;
    
    @Alias(name = "icd10_code")
    private String icd10Code;
    
    @Alias(name = "icd9_code")
    private String icd9Code;
    
    @Alias(name = "desc_long")
    private String icd9Description;
    
    @Alias(name = "desc_short")
    private String icd9Abbreviation;
    
    @Alias(name = "definition3")
    private String icd10Definition3;
    
    @Alias(name = "label1")
    private String icd9Label1;
    
    @Alias(name = "label2")
    private String icd9Label2;
    
    @Alias(name = "label3")
    private String icd9Label3;
    
    @Alias(name = "label4")
    private String icd9Label4;
    
    @Alias(name = "label5")
    private String icd9Label5;
    
    @Alias(name = "label6")
    private String icd9Label6;
    
    @Alias(name = "label7")
    private String icd9Label7;
    
    public String toString()
    {
        StringBuilder sbuilder = new StringBuilder();
        for( java.lang.reflect.Field f: this.getClass().getDeclaredFields()){
        	try {
				sbuilder.append(f.getName()).append("=").append(f.get(this)==null?"":f.get(this)).append("\n");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }


        return sbuilder.toString();
    }
    public static final class SOLR
    {
        private final SOLRAwareBean<ICDCodeSearchBean> solr = 
            new SOLRAwareBean<ICDCodeSearchBean>(ICDCodeSearchBean.class);

        /** 
         * @param query
         * @param count
         * @return
         */
        public List<ICDCodeSearchBean> getBeans(String query, int count)
        {
            return getBeans(query, 0, count);
        }

        /**
         * @param query
         * @param count
         * @return
         */
        public List<ICDCodeSearchBean> getBeans(String query, int start, int count)
        {
            SOLRResponseBean<ICDCodeSearchBean> bean = solr.getResponseBean(query, start, count);
            return bean.getBeans();
        }
        
        public SOLRResponseBean<ICDCodeSearchBean> getBean(String query, int start, int count)
        {
            return solr.getResponseBean(query, start, count);
        }
    }
}
