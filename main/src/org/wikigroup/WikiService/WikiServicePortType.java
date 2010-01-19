/**
 * WikiServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.wikigroup.WikiService;

import java.util.ArrayList;

public interface WikiServicePortType extends java.rmi.Remote {
    public ArrayList wikiSearch(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getWikiPage(java.lang.String in0) throws java.rmi.RemoteException;
}
