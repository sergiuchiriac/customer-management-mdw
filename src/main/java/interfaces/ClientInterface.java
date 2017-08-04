package interfaces;

import common.APIResponse;
import elements.ClientData;
import response.ClientResponse;

public interface ClientInterface {

	ClientResponse getClients();
	APIResponse addClient(ClientData element);
	APIResponse deleteClient(Integer id);
	ClientResponse searchClient(String nome,String nif);
	
}
