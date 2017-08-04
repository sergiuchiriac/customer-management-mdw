/**
 * ClientWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public class ClientWSServiceLocator extends org.apache.axis.client.Service implements services.ClientWSService {

    public ClientWSServiceLocator() {
    }


    public ClientWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClientWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClientWS
    private java.lang.String ClientWS_address = "http://localhost:8081/webservices/services/ClientWS";

    public java.lang.String getClientWSAddress() {
        return ClientWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClientWSWSDDServiceName = "ClientWS";

    public java.lang.String getClientWSWSDDServiceName() {
        return ClientWSWSDDServiceName;
    }

    public void setClientWSWSDDServiceName(java.lang.String name) {
        ClientWSWSDDServiceName = name;
    }

    public services.ClientWS getClientWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClientWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClientWS(endpoint);
    }

    public services.ClientWS getClientWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            services.ClientWSSoapBindingStub _stub = new services.ClientWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getClientWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClientWSEndpointAddress(java.lang.String address) {
        ClientWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (services.ClientWS.class.isAssignableFrom(serviceEndpointInterface)) {
                services.ClientWSSoapBindingStub _stub = new services.ClientWSSoapBindingStub(new java.net.URL(ClientWS_address), this);
                _stub.setPortName(getClientWSWSDDServiceName());
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
        if ("ClientWS".equals(inputPortName)) {
            return getClientWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services", "ClientWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services", "ClientWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClientWS".equals(portName)) {
            setClientWSEndpointAddress(address);
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
