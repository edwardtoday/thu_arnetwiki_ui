package org.wikigroup.WikiService;

import java.util.ArrayList;

public class WikiServicePortTypeProxy implements org.wikigroup.WikiService.WikiServicePortType {
  private String _endpoint = null;
  private org.wikigroup.WikiService.WikiServicePortType wikiServicePortType = null;
  
  public WikiServicePortTypeProxy() {
    _initWikiServicePortTypeProxy();
  }
  
  public WikiServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWikiServicePortTypeProxy();
  }
  
  private void _initWikiServicePortTypeProxy() {
    try {
      wikiServicePortType = (new org.wikigroup.WikiService.WikiServiceLocator()).getWikiServiceHttpPort();
      if (wikiServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wikiServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wikiServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wikiServicePortType != null)
      ((javax.xml.rpc.Stub)wikiServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.wikigroup.WikiService.WikiServicePortType getWikiServicePortType() {
    if (wikiServicePortType == null)
      _initWikiServicePortTypeProxy();
    return wikiServicePortType;
  }
  
  public ArrayList wikiSearch(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (wikiServicePortType == null)
      _initWikiServicePortTypeProxy();
    return wikiServicePortType.wikiSearch(in0, in1);
  }
  
  public java.lang.String getWikiPage(java.lang.String in0) throws java.rmi.RemoteException{
    if (wikiServicePortType == null)
      _initWikiServicePortTypeProxy();
    return wikiServicePortType.getWikiPage(in0);
  }
  
  
}