
package edu.thu.soa2009.wiki;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeoplePage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeoplePage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PeopleList" type="{http://soa2009.thu.edu/wiki/}PeopleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeoplePage", propOrder = {
    "peopleList"
})
public class PeoplePage {

    @XmlElement(name = "PeopleList", required = true)
    protected PeopleType peopleList;

    /**
     * Gets the value of the peopleList property.
     * 
     * @return
     *     possible object is
     *     {@link PeopleType }
     *     
     */
    public PeopleType getPeopleList() {
        return peopleList;
    }

    /**
     * Sets the value of the peopleList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeopleType }
     *     
     */
    public void setPeopleList(PeopleType value) {
        this.peopleList = value;
    }

}
