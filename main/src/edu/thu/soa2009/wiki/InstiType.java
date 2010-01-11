
package edu.thu.soa2009.wiki;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="peoplelist" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paperlist" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="homepage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstiType", propOrder = {
    "location",
    "peoplelist",
    "paperlist",
    "homepage"
})
public class InstiType {

    @XmlElement(required = true)
    protected String location;
    @XmlElement(required = true)
    protected String peoplelist;
    @XmlElement(required = true)
    protected String paperlist;
    @XmlElement(required = true)
    protected String homepage;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the peoplelist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeoplelist() {
        return peoplelist;
    }

    /**
     * Sets the value of the peoplelist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeoplelist(String value) {
        this.peoplelist = value;
    }

    /**
     * Gets the value of the paperlist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaperlist() {
        return paperlist;
    }

    /**
     * Sets the value of the paperlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaperlist(String value) {
        this.paperlist = value;
    }

    /**
     * Gets the value of the homepage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomepage() {
        return homepage;
    }

    /**
     * Sets the value of the homepage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomepage(String value) {
        this.homepage = value;
    }

}
