package manager;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import org.apache.log4j.Logger;

import common.APIResponse;
import elements.ClientData;
import interfaces.ClientInterface;
import response.ClientResponse;
import services.ClientElement;
import services.ClientWS;
import services.ClientWSServiceLocator;

public class ClientManager implements ClientInterface {
	
	private static final Logger LOG = Logger.getLogger(ClientManager.class);

	public ClientResponse getClients() {

		ClientResponse response = new ClientResponse();

		ClientWSServiceLocator locator = new ClientWSServiceLocator();
		ClientWS clientWS;
		try {
			
			clientWS = locator.getClientWS();
			
			response = clientWS.getClients();
		} catch (ServiceException | RemoteException e) {
			LOG.error("Caught exception while executing service.", e);
            response = new ClientResponse();
            response.setErrorCode("FATAL");
            response.setMessage(e.getMessage());    
		}
		
		return response;

	}

	public APIResponse addClient(ClientData element) {
		APIResponse response = new APIResponse();

	
			if (element != null) {
				
				ClientWSServiceLocator locator = new ClientWSServiceLocator();
				ClientWS clientWS;
				try {
					
					clientWS = locator.getClientWS();
					
					ClientElement newClient = new ClientElement();
					newClient.setMorada(element.getMorada());
					newClient.setNif(element.getNif());
					newClient.setNome(element.getNome());
					newClient.setTelefone(element.getTelefone());
					
					response = clientWS.addClient(newClient);
				} catch (ServiceException | RemoteException e) {
					LOG.error("Caught exception while executing service.", e);
		            response = new ClientResponse();
		            response.setErrorCode("FATAL");
		            response.setMessage(e.getMessage());    
				}
				
		
			} else {
				LOG.error("Customer data is empty. ");
				response = new APIResponse("FATAL", "Os dados do cliente encontram-se vazios. ",false);
			}

		return response;
	}

	public APIResponse deleteClient(Integer id) {

		APIResponse response = new APIResponse();

		ClientWSServiceLocator locator = new ClientWSServiceLocator();
		ClientWS clientWS;
		try {
			
			clientWS = locator.getClientWS();
			
			response = clientWS.deleteClient(id);
			
		} catch (ServiceException | RemoteException e) {
			LOG.error("Caught exception while executing service.", e);
            response = new ClientResponse();
            response.setErrorCode("FATAL");
            response.setMessage(e.getMessage());    
		}

		return response;

	}

	public ClientResponse searchClient(String nome, String nif) {

		ClientResponse response = new ClientResponse();

		ClientWSServiceLocator locator = new ClientWSServiceLocator();
		ClientWS clientWS;
		try {
			
			clientWS = locator.getClientWS();
			
			response = clientWS.searchClient(nome, nif);
			
		} catch (ServiceException | RemoteException e) {
			LOG.error("Caught exception while executing service.", e);
            response = new ClientResponse();
            response.setErrorCode("FATAL");
            response.setMessage(e.getMessage());    
		}
		
		return response;

	}

}
