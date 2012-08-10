//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.02 at 05:13:37 PM EDT 
//


package icd10.cm.tabular;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}desc"/>
 *         &lt;element ref="{}includes"/>
 *         &lt;element ref="{}useAdditionalCode"/>
 *         &lt;element ref="{}excludes1"/>
 *         &lt;element ref="{}excludes2"/>
 *         &lt;element ref="{}sectionIndex"/>
 *         &lt;element ref="{}notes"/>
 *         &lt;element ref="{}section"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nameOrDescOrIncludes"
})
@XmlRootElement(name = "chapter")
public class Chapter {

    @XmlElementRefs({
        @XmlElementRef(name = "includes", type = Includes.class),
        @XmlElementRef(name = "sectionIndex", type = SectionIndex.class),
        @XmlElementRef(name = "desc", type = JAXBElement.class),
        @XmlElementRef(name = "useAdditionalCode", type = UseAdditionalCode.class),
        @XmlElementRef(name = "excludes1", type = Excludes1 .class),
        @XmlElementRef(name = "section", type = Section.class),
        @XmlElementRef(name = "excludes2", type = Excludes2 .class),
        @XmlElementRef(name = "notes", type = Notes.class),
        @XmlElementRef(name = "name", type = JAXBElement.class)
    })
    protected List<Object> nameOrDescOrIncludes;

    /**
     * Gets the value of the nameOrDescOrIncludes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameOrDescOrIncludes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameOrDescOrIncludes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Includes }
     * {@link SectionIndex }
     * {@link UseAdditionalCode }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Section }
     * {@link Excludes1 }
     * {@link Excludes2 }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Notes }
     * 
     * 
     */
    public List<Object> getNameOrDescOrIncludes() {
        if (nameOrDescOrIncludes == null) {
            nameOrDescOrIncludes = new ArrayList<Object>();
        }
        return this.nameOrDescOrIncludes;
    }

}