package services;

public class ClientWSProxy implements services.ClientWS {
  private String _endpoint = null;
  private services.ClientWS clientWS = null;
  
  public ClientWSProxy() {
    _initClientWSProxy();
  }
  
  public ClientWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initClientWSProxy();
  }
  
  private void _initClientWSProxy() {
    try {
      clientWS = (new services.ClientWSServiceLocator()).getClientWS();
      if (clientWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)clientWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)clientWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (clientWS != null)
      ((javax.xml.rpc.Stub)clientWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public services.ClientWS getClientWS() {
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS;
  }
  
  public response.ClientResponse getClients() throws java.rmi.RemoteException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.getClients();
  }
  
  public common.APIResponse addClient(services.ClientElement client) throws java.rmi.RemoteException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.addClient(client);
  }
  
  public common.APIResponse deleteClient(int id) throws java.rmi.RemoteException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.deleteClient(id);
  }
  
  public response.ClientResponse searchClient(java.lang.String nome, java.lang.String nif) throws java.rmi.RemoteException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.searchClient(nome, nif);
  }
  
  
}