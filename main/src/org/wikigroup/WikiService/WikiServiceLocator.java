/**
 * WikiServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.wikigroup.WikiService;

public class WikiServiceLocator extends org.apache.axis.client.Service implements org.wikigroup.WikiService.WikiService {

    public WikiServiceLocator() {
    }


    public WikiServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WikiServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WikiServiceHttpPort
    private java.lang.String WikiServiceHttpPort_address = "http://166.111.134.235:8080/soaWiki/services/WikiService";

    public java.lang.String getWikiServiceHttpPortAddress() {
        return WikiServiceHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WikiServiceHttpPortWSDDServiceName = "WikiServiceHttpPort";

    public java.lang.String getWikiServiceHttpPortWSDDServiceName() {
        return WikiServiceHttpPortWSDDServiceName;
    }

    public void setWikiServiceHttpPortWSDDServiceName(java.lang.String name) {
        WikiServiceHttpPortWSDDServiceName = name;
    }

    public org.wikigroup.WikiService.WikiServicePortType getWikiServiceHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WikiServiceHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWikiServiceHttpPort(endpoint);
    }

    public org.wikigroup.WikiService.WikiServicePortType getWikiServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.wikigroup.WikiService.WikiServiceHttpBindingStub _stub = new org.wikigroup.WikiService.WikiServiceHttpBindingStub(portAddress, this);
            _stub.setPortName(getWikiServiceHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWikiServiceHttpPortEndpointAddress(java.lang.String address) {
        WikiServiceHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.wikigroup.WikiService.WikiServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.wikigroup.WikiService.WikiServiceHttpBindingStub _stub = new org.wikigroup.WikiService.WikiServiceHttpBindingStub(new java.net.URL(WikiServiceHttpPort_address), this);
                _stub.setPortName(getWikiServiceHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WikiServiceHttpPort".equals(inputPortName)) {
            return getWikiServiceHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wikigroup.org/WikiService", "WikiService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wikigroup.org/WikiService", "WikiServiceHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WikiServiceHttpPort".equals(portName)) {
            setWikiServiceHttpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
