
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
 *         &lt;element name="anchor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;choice>
 *           &lt;element name="Term" type="{http://soa2009.thu.edu/wiki/}TermPage"/>
 *           &lt;element name="People" type="{http://soa2009.thu.edu/wiki/}PeoplePage"/>
 *           &lt;element name="Insti" type="{http://soa2009.thu.edu/wiki/}InstiPage"/>
 *         &lt;/choice>
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
    "anchor",
    "term",
    "people",
    "insti"
})
@XmlRootElement(name = "wiki_page")
public class WikiPage {

    @XmlElement(name = "wiki_ID")
    protected int wikiID;
    @XmlElement(required = true)
    protected String anchor;
    @XmlElement(name = "Term")
    protected TermPage term;
    @XmlElement(name = "People")
    protected PeoplePage people;
    @XmlElement(name = "Insti")
    protected InstiPage insti;

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
     * Gets the value of the anchor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnchor() {
        return anchor;
    }

    /**
     * Sets the value of the anchor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnchor(String value) {
        this.anchor = value;
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link TermPage }
     *     
     */
    public TermPage getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermPage }
     *     
     */
    public void setTerm(TermPage value) {
        this.term = value;
    }

    /**
     * Gets the value of the people property.
     * 
     * @return
     *     possible object is
     *     {@link PeoplePage }
     *     
     */
    public PeoplePage getPeople() {
        return people;
    }

    /**
     * Sets the value of the people property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeoplePage }
     *     
     */
    public void setPeople(PeoplePage value) {
        this.people = value;
    }

    /**
     * Gets the value of the insti property.
     * 
     * @return
     *     possible object is
     *     {@link InstiPage }
     *     
     */
    public InstiPage getInsti() {
        return insti;
    }

    /**
     * Sets the value of the insti property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstiPage }
     *     
     */
    public void setInsti(InstiPage value) {
        this.insti = value;
    }

}
