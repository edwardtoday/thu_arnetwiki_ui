/**
 * WikiService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.wikigroup.WikiService;

public interface WikiService extends javax.xml.rpc.Service {
    public java.lang.String getWikiServiceHttpPortAddress();

    public org.wikigroup.WikiService.WikiServicePortType getWikiServiceHttpPort() throws javax.xml.rpc.ServiceException;

    public org.wikigroup.WikiService.WikiServicePortType getWikiServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
