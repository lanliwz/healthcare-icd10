//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.02 at 05:13:37 PM EDT 
//


package icd10.cm.tabular;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}sectionRef" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}note" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sectionRef",
    "note"
})
@XmlRootElement(name = "sectionIndex")
public class SectionIndex {

    protected List<SectionRef> sectionRef;
    protected Note note;

    /**
     * Gets the value of the sectionRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sectionRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSectionRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SectionRef }
     * 
     * 
     */
    public List<SectionRef> getSectionRef() {
        if (sectionRef == null) {
            sectionRef = new ArrayList<SectionRef>();
        }
        return this.sectionRef;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link Note }
     *     
     */
    public Note getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link Note }
     *     
     */
    public void setNote(Note value) {
        this.note = value;
    }

}