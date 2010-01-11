
package edu.thu.soa2009.wiki;

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
 *         &lt;element name="returnedList" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="wiki_hit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="wiki_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="wiki_URL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="wiki_version" maxOccurs="5">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="wiki_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="wiki_versionNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "returnedList"
})
@XmlRootElement(name = "wiki_ResultList")
public class WikiResultList {

    @XmlElement(required = true)
    protected List<WikiResultList.ReturnedList> returnedList;

    /**
     * Gets the value of the returnedList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnedList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnedList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WikiResultList.ReturnedList }
     * 
     * 
     */
    public List<WikiResultList.ReturnedList> getReturnedList() {
        if (returnedList == null) {
            returnedList = new ArrayList<WikiResultList.ReturnedList>();
        }
        return this.returnedList;
    }


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
     *         &lt;element name="wiki_hit" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="wiki_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="wiki_URL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="wiki_version" maxOccurs="5">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="wiki_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="wiki_versionNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "wikiHit",
        "wikiID",
        "wikiURL",
        "wikiVersion"
    })
    public static class ReturnedList {

        @XmlElement(name = "wiki_hit")
        protected int wikiHit;
        @XmlElement(name = "wiki_ID")
        protected int wikiID;
        @XmlElement(name = "wiki_URL", required = true)
        protected String wikiURL;
        @XmlElement(name = "wiki_version", required = true)
        protected List<WikiResultList.ReturnedList.WikiVersion> wikiVersion;

        /**
         * Gets the value of the wikiHit property.
         * 
         */
        public int getWikiHit() {
            return wikiHit;
        }

        /**
         * Sets the value of the wikiHit property.
         * 
         */
        public void setWikiHit(int value) {
            this.wikiHit = value;
        }

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
         * Gets the value of the wikiURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWikiURL() {
            return wikiURL;
        }

        /**
         * Sets the value of the wikiURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWikiURL(String value) {
            this.wikiURL = value;
        }

        /**
         * Gets the value of the wikiVersion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the wikiVersion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWikiVersion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WikiResultList.ReturnedList.WikiVersion }
         * 
         * 
         */
        public List<WikiResultList.ReturnedList.WikiVersion> getWikiVersion() {
            if (wikiVersion == null) {
                wikiVersion = new ArrayList<WikiResultList.ReturnedList.WikiVersion>();
            }
            return this.wikiVersion;
        }


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
         *         &lt;element name="wiki_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "wikiDate",
            "wikiVersionNo"
        })
        public static class WikiVersion {

            @XmlElement(name = "wiki_date", required = true)
            protected String wikiDate;
            @XmlElement(name = "wiki_versionNo")
            protected int wikiVersionNo;

            /**
             * Gets the value of the wikiDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWikiDate() {
                return wikiDate;
            }

            /**
             * Sets the value of the wikiDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWikiDate(String value) {
                this.wikiDate = value;
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

    }

}
