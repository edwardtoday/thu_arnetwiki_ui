
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
 *         &lt;element name="wiki_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="wiki_versionNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="editTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userEditData" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pagePart" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="editContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "wikiID",
    "wikiVersionNo",
    "editTime",
    "userEditData"
})
@XmlRootElement(name = "wiki_edit")
public class WikiEdit {

    @XmlElement(name = "wiki_ID")
    protected int wikiID;
    @XmlElement(name = "wiki_versionNo")
    protected int wikiVersionNo;
    @XmlElement(required = true)
    protected String editTime;
    @XmlElement(required = true)
    protected List<WikiEdit.UserEditData> userEditData;

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

    /**
     * Gets the value of the editTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditTime() {
        return editTime;
    }

    /**
     * Sets the value of the editTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditTime(String value) {
        this.editTime = value;
    }

    /**
     * Gets the value of the userEditData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userEditData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserEditData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WikiEdit.UserEditData }
     * 
     * 
     */
    public List<WikiEdit.UserEditData> getUserEditData() {
        if (userEditData == null) {
            userEditData = new ArrayList<WikiEdit.UserEditData>();
        }
        return this.userEditData;
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
     *         &lt;element name="pagePart" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="editContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "pagePart",
        "editContent"
    })
    public static class UserEditData {

        @XmlElement(required = true)
        protected String pagePart;
        @XmlElement(required = true)
        protected String editContent;

        /**
         * Gets the value of the pagePart property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPagePart() {
            return pagePart;
        }

        /**
         * Sets the value of the pagePart property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPagePart(String value) {
            this.pagePart = value;
        }

        /**
         * Gets the value of the editContent property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEditContent() {
            return editContent;
        }

        /**
         * Sets the value of the editContent property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEditContent(String value) {
            this.editContent = value;
        }

    }

}
