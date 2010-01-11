
package edu.thu.soa2009.wiki;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.thu.soa2009.wiki package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.thu.soa2009.wiki
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WikiEdit }
     * 
     */
    public WikiEdit createWikiEdit() {
        return new WikiEdit();
    }

    /**
     * Create an instance of {@link WikiSearch }
     * 
     */
    public WikiSearch createWikiSearch() {
        return new WikiSearch();
    }

    /**
     * Create an instance of {@link PeopleType }
     * 
     */
    public PeopleType createPeopleType() {
        return new PeopleType();
    }

    /**
     * Create an instance of {@link PeoplePage }
     * 
     */
    public PeoplePage createPeoplePage() {
        return new PeoplePage();
    }

    /**
     * Create an instance of {@link TermPage }
     * 
     */
    public TermPage createTermPage() {
        return new TermPage();
    }

    /**
     * Create an instance of {@link WikiEdit.UserEditData }
     * 
     */
    public WikiEdit.UserEditData createWikiEditUserEditData() {
        return new WikiEdit.UserEditData();
    }

    /**
     * Create an instance of {@link WikiPage }
     * 
     */
    public WikiPage createWikiPage() {
        return new WikiPage();
    }

    /**
     * Create an instance of {@link WikiResultList }
     * 
     */
    public WikiResultList createWikiResultList() {
        return new WikiResultList();
    }

    /**
     * Create an instance of {@link WikiClick }
     * 
     */
    public WikiClick createWikiClick() {
        return new WikiClick();
    }

    /**
     * Create an instance of {@link WikiResultList.ReturnedList }
     * 
     */
    public WikiResultList.ReturnedList createWikiResultListReturnedList() {
        return new WikiResultList.ReturnedList();
    }

    /**
     * Create an instance of {@link InstiPage }
     * 
     */
    public InstiPage createInstiPage() {
        return new InstiPage();
    }

    /**
     * Create an instance of {@link InstiType }
     * 
     */
    public InstiType createInstiType() {
        return new InstiType();
    }

    /**
     * Create an instance of {@link WikiResultList.ReturnedList.WikiVersion }
     * 
     */
    public WikiResultList.ReturnedList.WikiVersion createWikiResultListReturnedListWikiVersion() {
        return new WikiResultList.ReturnedList.WikiVersion();
    }

}
