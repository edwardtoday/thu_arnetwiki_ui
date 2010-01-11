
package edu.thu.soa2009.wiki;

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
 *         &lt;element name="wiki_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="wiki_versionNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "wikiID",
    "wikiVersionNo"
})
@XmlRootElement(name = "wiki_click")
public class WikiClick {

    @XmlElement(name = "wiki_ID")
    protected int wikiID;
    @XmlElement(name = "wiki_versionNo")
    protected int wikiVersionNo;

    /**
     * Gets the value of the wikiID property.
     * 
     */
    public int getWikiID() {
        return wikiID;
    }

    /**
     * Sets the value of the wikiID property.
     * 
     */
    public void setWikiID(int value) {
        this.wikiID = value;
    }

    /**
     * Gets the value of the wikiVersionNo property.
     * 
     */
    public int getWikiVersionNo() {
        return wikiVersionNo;
    }

    /**
     * Sets the value of the wikiVersionNo property.
     * 
     */
    public void setWikiVersionNo(int value) {
        this.wikiVersionNo = value;
    }

}
