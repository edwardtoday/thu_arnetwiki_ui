
package edu.thu.soa2009.wiki;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class wikiSearchServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public wikiSearchServiceClient() {
        create0();
        Endpoint wikiPortEP = service0 .addEndpoint(new QName("http://soa2009.thu.edu/wiki/", "wikiPort"), new QName("http://soa2009.thu.edu/wiki/", "wikiHttpBinding"), "http://wiki/wikiSearch");
        endpoints.put(new QName("http://soa2009.thu.edu/wiki/", "wikiPort"), wikiPortEP);
        Endpoint wikiPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://soa2009.thu.edu/wiki/", "wikiPortTypeLocalEndpoint"), new QName("http://soa2009.thu.edu/wiki/", "wikiPortTypeLocalBinding"), "xfire.local://wikiSearchService");
        endpoints.put(new QName("http://soa2009.thu.edu/wiki/", "wikiPortTypeLocalEndpoint"), wikiPortTypeLocalEndpointEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((edu.thu.soa2009.wiki.wikiPortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://soa2009.thu.edu/wiki/", "wikiPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://soa2009.thu.edu/wiki/", "wikiHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public wikiPortType getwikiPort() {
        return ((wikiPortType)(this).getEndpoint(new QName("http://soa2009.thu.edu/wiki/", "wikiPort")));
    }

    public wikiPortType getwikiPort(String url) {
        wikiPortType var = getwikiPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public wikiPortType getwikiPortTypeLocalEndpoint() {
        return ((wikiPortType)(this).getEndpoint(new QName("http://soa2009.thu.edu/wiki/", "wikiPortTypeLocalEndpoint")));
    }

    public wikiPortType getwikiPortTypeLocalEndpoint(String url) {
        wikiPortType var = getwikiPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public static void main(String[] args) {
        

        wikiSearchServiceClient client = new wikiSearchServiceClient();
        
		//create a default service endpoint
        wikiPortType service = client.getwikiPort();
        
		//TODO: Add custom client code here
        		//
        		//service.yourServiceOperationHere();
        
		System.out.println("test client completed");
        		System.exit(0);
    }

}
