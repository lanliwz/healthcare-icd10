//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.26 at 10:06:31 PM EDT 
//


package icd10.pcs.tabular;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{}axis" maxOccurs="3" minOccurs="3"/>
 *         &lt;element ref="{}pcsRow" maxOccurs="unbounded"/>
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
    "axis",
    "pcsRow"
})
@XmlRootElement(name = "pcsTable")
public class PcsTable {

    @XmlElement(required = true)
    protected List<Axis> axis;
    @XmlElement(required = true)
    protected List<PcsRow> pcsRow;

    /**
     * Gets the value of the axis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the axis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAxis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Axis }
     * 
     * 
     */
    public List<Axis> getAxis() {
        if (axis == null) {
            axis = new ArrayList<Axis>();
        }
        return this.axis;
    }

    /**
     * Gets the value of the pcsRow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pcsRow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPcsRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PcsRow }
     * 
     * 
     */
    public List<PcsRow> getPcsRow() {
        if (pcsRow == null) {
            pcsRow = new ArrayList<PcsRow>();
        }
        return this.pcsRow;
    }

}
