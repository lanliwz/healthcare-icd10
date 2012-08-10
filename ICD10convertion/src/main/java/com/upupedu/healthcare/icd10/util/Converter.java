package com.upupedu.healthcare.icd10.util;

import icd10.pcs.tabular.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.upupedu.util.Tracer;

public class Converter {
	public void convert(String xmlFileName,String csvFileName){
		
	}
	public static void main(String[] args) {
		Converter jb = new Converter();
		Tracer tracer = new Tracer();
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
		tracer.setTraceFileBaseName("icd10pcs_tabular_2013.csv");
		tracer.setTraceFolder("c:/icd10/");
		tracer.init();
		String icd10_code = null, axis1 = null, axis2 = null, axis3 = null, axis4 = null, axis5 = null, axis6 = null, axis7 = null;
		String axis1_title=null,axis1_label=null,axis1_definition=null;
		String axis2_title=null,axis2_label=null,axis2_definition=null;
		String axis3_title=null,axis3_label=null,axis3_definition=null;
		String axis4_title=null,axis4_label=null,axis4_definition=null;
		String axis5_title=null,axis5_label=null,axis5_definition=null;
		String axis6_title=null,axis6_label=null,axis6_definition=null;
		String axis7_title=null,axis7_label=null,axis7_definition=null;

		try {
			JAXBContext ctx = JAXBContext.newInstance("icd10.pcs.tabular");
			Unmarshaller um = ctx.createUnmarshaller();
			XMLInputFactory xmlif = XMLInputFactory.newFactory();
			FileReader fr = new FileReader("c:/icd10/icd10pcs_tabular_2013.xml");
			XMLEventReader xmler = xmlif.createXMLEventReader(fr);
			EventFilter filter = new EventFilter() {
				public boolean accept(XMLEvent event) {
					return event.isStartElement();
				}
			};
			XMLEventReader xmlfer = xmlif.createFilteredReader(xmler, filter);
			while (xmlfer.peek() != null) {
				StartElement e = (StartElement) xmlfer.peek();
				PcsTable o = null;
				StringBuilder icd10Code1_3 = new StringBuilder();
				List<Label> label4=null;
				List<Label> label5=null;
				List<Label> label6=null;
				List<Label> label7=null;
				if (e.getName().getLocalPart().equals("pcsTable")) {
					o = (PcsTable) um.unmarshal(xmler);

					for (Axis a : o.getAxis()) {
						icd10Code1_3.append(a.getLabel().get(0).getCode());
						if (a.getPos() == 1){
							axis1 = a.getLabel().get(0).getCode();
							axis1_title=a.getTitle();
							axis1_label=a.getLabel().get(0).getValue();
							axis1_definition=a.getDefinition();
						}
							
						else if (a.getPos() == 2){
							axis2 = a.getLabel().get(0).getCode();
							axis2_title=a.getTitle();
							axis2_label=a.getLabel().get(0).getValue();
							axis2_definition=a.getDefinition();
						}
						else if (a.getPos() == 3){
							axis3 = a.getLabel().get(0).getCode();
							axis3_title=a.getTitle();
							axis3_label=a.getLabel().get(0).getValue();
							axis3_definition=a.getDefinition();
						}

					}

					for (PcsRow row : o.getPcsRow()) {
						
						for (Axis a : row.getAxis()) {

							if (a.getPos() == 4){
								label4=a.getLabel();
								axis4_title=a.getTitle();
								axis4_definition=a.getDefinition();
								
							}
							else if (a.getPos() == 5){
								label5=a.getLabel();
								axis5_title=a.getTitle();
								axis5_definition=a.getDefinition();
								
							}
							else if (a.getPos() == 6){
								label6=a.getLabel();
								axis6_title=a.getTitle();
								axis6_definition=a.getDefinition();
								
							}
							else if (a.getPos() == 7){
								label7=a.getLabel();
								axis7_title=a.getTitle();
								axis7_definition=a.getDefinition();

							}
						}

						for (Label l4:label4){
							axis4=l4.getCode();
							axis4_label=l4.getValue();
							for(Label l5:label5){
								axis5=l5.getCode();
								axis5_label=l5.getValue();
								for(Label l6:label6){
									axis6=l6.getCode();
									axis6_label=l6.getValue();
									for (Label l7:label7){
										axis7=l7.getCode();
										axis7_label=l7.getValue();
										icd10_code = icd10Code1_3.toString() + "."
										+ axis4+axis5+axis6+axis7;
										StringBuilder flatrow= new StringBuilder();
										flatrow=append(flatrow,icd10_code);
										flatrow=append(flatrow,"icd10pcs");
										flatrow=append(flatrow,icd10_code);
										flatrow=append(flatrow, axis1);
										flatrow=append(flatrow,axis2);
										flatrow=append(flatrow,axis3 ); 
										flatrow=append(flatrow,axis4	); 
										flatrow=append(flatrow,axis5 );  
										flatrow=append(flatrow,axis6 );
										flatrow=append(flatrow,axis7	);									
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
;
										tracer.trace(flatrow.toString());
										System.out.println(flatrow.toString());										
										
									}
								}
							}
						}
						

					}

				}
				else
					xmlfer.nextEvent();
					

			}

		} catch (JAXBException e) {

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static StringBuilder append(StringBuilder sb,String column,String delimit){
		sb.append("\"").append((column==null?"":column)).append("\"").append(delimit);
		return sb;
	}
	public static StringBuilder append(StringBuilder sb,String column){
		return append(sb,column,",");

	}
}
