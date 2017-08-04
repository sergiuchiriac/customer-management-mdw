package resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import common.APIResponse;
import elements.ClientData;
import manager.ClientManager;
import response.ClientResponse;


@Path("clients")
public class MyResource {
	private final static Logger LOG = Logger.getLogger(MyResource.class);

	ApplicationContextProvider appContext = new ApplicationContextProvider();
	ClientManager clientManager = appContext.getApplicationContext().getBean("clientManager", ClientManager.class);


	@GET
	@Path("listall")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse getAllClients() {
		ClientResponse response;

		try {
			response = clientManager.getClients();

		} catch (Exception e) {
			LOG.error("Uncaught exception in REST api level " + e.getMessage(), e);
			response = new ClientResponse();
            response.setErrorCode("FATAL");
            response.setMessage(e.getMessage());    
		}

		return response;
	}

	@POST
	@Path("addclient")
	@Produces(MediaType.APPLICATION_JSON)
	public APIResponse addClient(ClientData element) {
		APIResponse response;
		try {

			response = clientManager.addClient(element);

		} catch (Exception e) {
			LOG.error("Uncaught exception in REST api level " + e.getMessage(), e);
			response = new ClientResponse();
            response.setErrorCode("FATAL");
            response.setMessage(e.getMessage());    
		}

		return response;
	}

	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public APIResponse deleteClient(@PathParam("id") Integer id) {
		APIResponse response;
		try {

			response = clientManager.deleteClient(id);

		} catch (Exception e) {
			LOG.error("Uncaught exception in REST api level " + e.getMessage(), e);
			response = new ClientResponse();
            response.setErrorCode("FATAL");
            response.setMessage(e.getMessage());    
		}
		return response;
	}

	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse searchClient(@QueryParam("nome") String nome, @QueryParam("nif") String nif) {

		ClientResponse response;

		try {

			response = clientManager.searchClient(nome, nif);

		} catch (Exception e) {
			LOG.error("Uncaught exception in REST api level " + e.getMessage(), e);
			response = new ClientResponse();
            response.setErrorCode("FATAL");
            response.setMessage(e.getMessage());    
		}
		return response;
	}

}
