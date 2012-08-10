package com.upupedu.util;

import icd10.cm.tabular.ICD10CMTabular;
import icd10.pcs.definition.Aggregate;
import icd10.pcs.definition.ICD10PCSDefinitions;
import icd10.pcs.definition.Section;
import icd10.pcs.index.ICD10PCSIndex;
import icd10.pcs.index.Letter;
import icd10.pcs.tabular.PcsTable;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class JAXBXmlCursor implements XmlCursor {
	private String packageName="icd10.pcs.definition";
	private String xmlFileName="c:/icd10/icd10pcs_definitions_2013.xml";
	private JAXBContext ctx;
	private Unmarshaller um;
	private XMLInputFactory xmlif;
	private FileReader fr;
	private XMLEventReader xmler;
	private XMLEventReader xmlfer;
	EventFilter filter = new EventFilter() {
		public boolean accept(XMLEvent event) {
			return event.isStartElement();
		}
	};
	public JAXBXmlCursor(){

		
	}
	public JAXBXmlCursor(String packageName,String xmlFileName){
		this.packageName=packageName;
		this.xmlFileName=xmlFileName;
		
	}
	public JAXBXmlCursor(Class clazz,String xmlFileName){
		this.packageName=clazz.getPackage().getName();
		this.xmlFileName=xmlFileName;
		
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public String getSchema() {
		return packageName;
	}

	public void setSchema(String schema) {
		this.packageName = schema;
	}

	public String getXmlFileName() {
		return xmlFileName;
	}

	public void setXmlFileName(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	@Override
	public <T> T next(Class obj) {
		
	T o;
		try {
			while (xmlfer.peek() != null) {
				StartElement e = (StartElement) xmlfer.peek();
				if (e.getName().getLocalPart().equalsIgnoreCase(obj.getSimpleName())) {
					o = (T) um.unmarshal(xmler);
					return o;
				}
				else {
					xmlfer.nextEvent();
				}
			}
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void open() {
		try {
			ctx = JAXBContext.newInstance(packageName);
			um = ctx.createUnmarshaller();
			xmlif = XMLInputFactory.newFactory();
			fr = new FileReader(xmlFileName);
			xmler = xmlif.createXMLEventReader(fr);

			xmlfer = xmlif.createFilteredReader(xmler, filter);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static void main(String[] args){
		JAXBXmlCursor cur = new JAXBXmlCursor(ICD10CMTabular.class,"c:/icd10/icd10cm_2012_full_tabular.xml");
		cur.open();
		icd10.cm.tabular.Section section=new icd10.cm.tabular.Section();
//		Aggregate agg=new Aggregate();
//		while((agg = cur.next(Aggregate.class))!=null){
//			System.out.println(agg.getDevice());
//		}
		while((section = cur.next(icd10.cm.tabular.Section.class))!=null){
			System.out.println(section.getId());
		}
//		JAXBXmlCursor cur = new JAXBXmlCursor(ICD10PCSDefinitions.class,"c:/icd10/icd10pcs_definitions_2013.xml");
//		cur.open();
//		Section section=new Section();
//		Aggregate agg=new Aggregate();
//		while((agg = cur.next(Aggregate.class))!=null){
//			System.out.println(agg.getDevice());
//		}
//		while((section = cur.next(Section.class))!=null){
//			System.out.println(section.getCode());
//		}

//		cur = new JAXBXmlCursor(ICD10PCSIndex.class,"c:/icd10/icd10pcs_index_2013.xml");
//		cur.open();
//		Letter letter = new Letter();
//		while((letter = cur.next(Letter.class))!=null){
//			System.out.println(letter.getTitle());
//	}
	}
	@Override
	public <T> void open(Class T) {
		try {
			ctx = JAXBContext.newInstance(T.getPackage().getName());
			um = ctx.createUnmarshaller();
			xmlif = XMLInputFactory.newFactory();
			fr = new FileReader(xmlFileName);
			xmler = xmlif.createXMLEventReader(fr);

			xmlfer = xmlif.createFilteredReader(xmler, filter);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
