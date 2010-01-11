
package edu.thu.soa2009.wiki;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TermPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TermPage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="def" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="people" type="{http://soa2009.thu.edu/wiki/}PeopleType"/>
 *         &lt;element name="papers" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Insitutions" type="{http://soa2009.thu.edu/wiki/}InstiType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TermPage", propOrder = {
    "def",
    "dataset",
    "people",
    "papers",
    "insitutions"
})
public class TermPage {

    @XmlElement(required = true)
    protected String def;
    @XmlElement(required = true)
    protected String dataset;
    @XmlElement(required = true)
    protected PeopleType people;
    @XmlElement(required = true)
    protected String papers;
    @XmlElement(name = "Insitutions", required = true)
    protected InstiType insitutions;

    /**
     * Gets the value of the def property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDef() {
        return def;
    }

    /**
     * Sets the value of the def property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDef(String value) {
        this.def = value;
    }

    /**
     * Gets the value of the dataset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataset() {
        return dataset;
    }

    /**
     * Sets the value of the dataset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataset(String value) {
        this.dataset = value;
    }

    /**
     * Gets the value of the people property.
     * 
     * @return
     *     possible object is
     *     {@link PeopleType }
     *     
     */
    public PeopleType getPeople() {
        return people;
    }

    /**
     * Sets the value of the people property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeopleType }
     *     
     */
    public void setPeople(PeopleType value) {
        this.people = value;
    }

    /**
     * Gets the value of the papers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPapers() {
        return papers;
    }

    /**
     * Sets the value of the papers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPapers(String value) {
        this.papers = value;
    }

    /**
     * Gets the value of the insitutions property.
     * 
     * @return
     *     possible object is
     *     {@link InstiType }
     *     
     */
    public InstiType getInsitutions() {
        return insitutions;
    }

    /**
     * Sets the value of the insitutions property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstiType }
     *     
     */
    public void setInsitutions(InstiType value) {
        this.insitutions = value;
    }

}
