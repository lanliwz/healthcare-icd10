package com.upupedu.healthcare.icd10.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.upupedu.util.JAXBXmlCursor;
import com.upupedu.util.Tracer;

import icd10.cm.tabular.Diag;
import icd10.cm.tabular.ICD10CMTabular;
import  static com.upupedu.util.StringUtil.append;

public class Icd10cmConverter {
	String icd10_code = null, axis1 = null, axis2 = null, axis3 = null, axis4 = null, axis5 = null, axis6 = null, axis7 = null;
	String axis1_title=null,axis1_label=null,axis1_definition=null;
	String axis2_title=null,axis2_label=null,axis2_definition=null;
	String axis3_title=null,axis3_label=null,axis3_definition=null;
	String axis4_title=null,axis4_label=null,axis4_definition=null;
	String axis5_title=null,axis5_label=null,axis5_definition=null;
	String axis6_title=null,axis6_label=null,axis6_definition=null;
	String axis7_title=null,axis7_label=null,axis7_definition=null;
	Tracer tracer = new Tracer();
	public void init(){
		tracer
				.setHeader("pkey,pkey_cat," +
						"icd10_code,axis1,axis2,axis3,axis4,axis5,axis6,axis7," +
						"title1,label1,definition1," +
						"title2,label2,definition2," +
						"title3,label3,definition3," +
						"title4,label4,definition4," +
						"title5,label5,definition5," +
						"title6,label6,definition6," +
						"title7,label7"+
						",definition7");
		tracer.setTraceFileBaseName("icd10cm_tabular_2012.csv");
		tracer.setTraceFolder("c:/icd10/");
		tracer.init();		
	}
	public void convert(){
		init();


		JAXBXmlCursor cur = new JAXBXmlCursor(ICD10CMTabular.class,"c:/icd10/icd10cm_2012_full_tabular.xml");
		cur.open();
		icd10.cm.tabular.Section section=new icd10.cm.tabular.Section();

		while((section = cur.next(icd10.cm.tabular.Section.class))!=null){

			System.out.println(section.getId());
			for (Object o3:section.getDescOrDiagOrIncludes()){
				reset();
				if(o3 instanceof String){
					System.out.println(o3);
				}
				if(o3 instanceof Diag){
					String[] l3=getIcd10((Diag) o3);
					icd10_code=l3[0];
					axis3_label=l3[1];
					List<Diag> diagl4=getNextLevelDiag((Diag) o3);
//					for (Diag o4:diagl4){
//						if(o4 instanceof JAXBElement)
//						System.out.println(((JAXBElement) o4).getName().getLocalPart()+":"+((JAXBElement) o4).getValue());
						if(diagl4.size() ==0){
							trace();
							System.out.println(icd10_code+","+axis3_label+","+axis4_label+","+axis5_label+","+axis6_label+","+axis7_label);							
						}
						else{
							for (Diag o4:diagl4){
							String[] l4=getIcd10((Diag) o4);
							icd10_code=l4[0];
							axis4_label=l4[1];
							List<Diag> diagl5=getNextLevelDiag((Diag) o4);

								if(diagl5.size() ==0){
									trace();
									System.out.println(icd10_code+","+axis3_label+","+axis4_label+","+axis5_label+","+axis6_label+","+axis7_label);	
								}
								else {
									for (Diag o5:diagl5){
									String[] l5=getIcd10((Diag) o5);
									icd10_code=l5[0];
									axis5_label=l5[1];
									List<Diag> diagl6=getNextLevelDiag((Diag) o5);
									if (diagl6.size()==0){
										trace();
										System.out.println(icd10_code+","+axis3_label+","+axis4_label+","+axis5_label+","+axis6_label+","+axis7_label);
									}
									else{
										   
											for(Diag o6:diagl6){
											String[] l6=getIcd10((Diag) o6);
											icd10_code=l6[0];
											axis6_label=l6[1];
											List<Diag> diagl7=getNextLevelDiag((Diag) o6);
											if (diagl7.size()!=0){
												for (Diag o7:diagl7){
												String[] l7=getIcd10(o7);
												icd10_code=l7[0];
												axis7_label=l7[1];
												trace();
												System.out.println(icd10_code+","+axis3_label+","+axis4_label+","+axis5_label+","+axis6_label+","+axis7_label);
											}
											}
											else {
												trace();
												System.out.println(icd10_code+","+axis3_label+","+axis4_label+","+axis5_label+","+axis6_label+","+axis7_label);
											}
										
											}
									}								
									}
									
								}
							
							
							}
						}
					
					
				}
			}

		}		
	}
	public static void main(String[] args){
		Icd10cmConverter c=new Icd10cmConverter();
		c.convert();

	}
	public List<Diag> getNextLevelDiag(Diag diag){
		List<Diag> diags = new ArrayList<Diag>();

			for (Object o8:diag.getNameOrDescOrInclusionTerm()){
				if(o8 instanceof Diag)
				diags.add((Diag) o8);
			}
			return diags;

	}
	public  String[] getIcd10(Diag diag){
		String[] icd10 = new String[2];

		for (Object o:diag.getNameOrDescOrInclusionTerm()){
			if(o instanceof JAXBElement) {
				if(((JAXBElement) o).getName().getLocalPart().equals("name"))
					icd10[0]=(String) ((JAXBElement) o).getValue();
				if(((JAXBElement) o).getName().getLocalPart().equals("desc"))
					icd10[1]=(String) ((JAXBElement) o).getValue();
			}
			
		}
		return icd10;

}
	public void reset(){
		icd10_code = null; axis1 = null; axis2 = null; axis3 = null; axis4 = null; axis5 = null; axis6 = null; axis7 = null;
		axis1_title=null;axis1_label=null;axis1_definition=null;
		axis2_title=null;axis2_label=null;axis2_definition=null;
		axis3_title=null;axis3_label=null;axis3_definition=null;
		axis4_title=null;axis4_label=null;axis4_definition=null;
		axis5_title=null;axis5_label=null;axis5_definition=null;
		axis6_title=null;axis6_label=null;axis6_definition=null;
		axis7_title=null;axis7_label=null;axis7_definition=null;
	}
	public void trace(){
		String[] axis= new String[7]; 
		char[] pos_codes=icd10_code.toCharArray();
		for(int i=0;i<pos_codes.length;i++){
			if(i>3)
				axis[i-1]=String.valueOf(pos_codes[i]);
			if(i<3)
				axis[i]=String.valueOf(pos_codes[i]);
		}
		StringBuilder flatrow= new StringBuilder();
		flatrow=append(flatrow,icd10_code);
		flatrow=append(flatrow,"icd10cm");
		flatrow=append(flatrow,icd10_code);
		flatrow=append(flatrow, axis[0]);
		flatrow=append(flatrow,axis[1]);
		flatrow=append(flatrow,axis[2] ); 
		flatrow=append(flatrow,axis[3]	); 
		flatrow=append(flatrow,axis[4] );  
		flatrow=append(flatrow,axis[5]);
		flatrow=append(flatrow,axis[6]	);									
		flatrow=append(flatrow,axis1_title );
		flatrow=append(flatrow,axis1_label );
		flatrow=append(flatrow,(axis1_definition==null?"":axis1_definition) );
		flatrow=append(flatrow,axis2_title );
		flatrow=append(flatrow,axis2_label );
		flatrow=append(flatrow,(axis2_definition==null?"":axis2_definition) );								

		flatrow=append(flatrow,axis3_title );
		flatrow=append(flatrow,axis3_label );
		flatrow=append(flatrow,axis3_definition);
		flatrow=append(flatrow,axis4_title );
		flatrow=append(flatrow,axis4_label );
		flatrow=append(flatrow,axis4_definition );								
		flatrow=append(flatrow,axis5_title );
		flatrow=append(flatrow,axis5_label );
		flatrow=append(flatrow,axis5_definition );								
		flatrow=append(flatrow,axis6_title );
		flatrow=append(flatrow,axis6_label );
		flatrow=append(flatrow,axis6_definition );								
		flatrow=append(flatrow,axis7_title );
		flatrow=append(flatrow,axis7_label);
		flatrow=append(flatrow,axis7_definition,"");
		tracer.trace(flatrow.toString());
	}

	
	
	
	
	
	

}
