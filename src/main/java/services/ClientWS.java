/**
 * ClientWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public interface ClientWS extends java.rmi.Remote {
    public response.ClientResponse getClients() throws java.rmi.RemoteException;
    public common.APIResponse addClient(services.ClientElement client) throws java.rmi.RemoteException;
    public common.APIResponse deleteClient(int id) throws java.rmi.RemoteException;
    public response.ClientResponse searchClient(java.lang.String nome, java.lang.String nif) throws java.rmi.RemoteException;
}
