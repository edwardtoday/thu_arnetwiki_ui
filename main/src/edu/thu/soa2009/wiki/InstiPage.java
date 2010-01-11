
package edu.thu.soa2009.wiki;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstiPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstiPage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstiList" type="{http://soa2009.thu.edu/wiki/}InstiType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstiPage", propOrder = {
    "instiList"
})
public class InstiPage {

    @XmlElement(name = "InstiList", required = true)
    protected InstiType instiList;

    /**
     * Gets the value of the instiList property.
     * 
     * @return
     *     possible object is
     *     {@link InstiType }
     *     
     */
    public InstiType getInstiList() {
        return instiList;
    }

    /**
     * Sets the value of the instiList property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstiType }
     *     
     */
    public void setInstiList(InstiType value) {
        this.instiList = value;
    }

}
