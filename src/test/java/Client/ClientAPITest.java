package Client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import common.APIResponse;
import elements.ClientData;
import response.ClientResponse;
import services.ClientElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientAPITest {
	
	private WebResource service;
	private String morada = "RUA DAS FLORES";
	private String nome = "SERGIU CHIRIAC";
	private String nif = "259068195";
	private String telefone = "912063022";
	private Integer id = null;

	@Before
	public void initConnection() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);   
		
		URI baseURI = UriBuilder.fromUri("http://localhost:8081/Multicert_server/rest/clients/").build();
		service = client.resource(baseURI);
	}
	
	@Test
	public void testAddClient() {
		ClientData client = new ClientData();
			client.setMorada(morada);
			client.setNif(nif);
			client.setNome(nome);
			client.setTelefone(telefone);

		APIResponse addClientResponse =	service.path("addclient")
				.entity(client, MediaType.APPLICATION_XML)
				.accept(MediaType.APPLICATION_JSON)
				.post(APIResponse.class);
		validateMessage(addClientResponse);
		
	}
	
	@Test	
	public void testSearchClient() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("nif", nif);
		params.add("nome", nome);
		
		
		ClientResponse listClientResponse = service.path("search")
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON).
				get(ClientResponse.class);
		
		validateMessage(listClientResponse);
		
		ClientElement[] clients = listClientResponse.getClientElement();
		
		if(clients != null && clients.length > 0){
			for(ClientElement client : clients){
				Assert.assertTrue(nome.equals(client.getNome()));
				Assert.assertTrue(nif.equals(client.getNif()));		
				id = client.getId();
			}
		}else{
			Assert.assertTrue(clients == null);
		}
		

	}

	@Test
	public void testListAll() {
		ClientResponse listClientResponse = service.path("listall")
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		ClientElement[] clients = listClientResponse.getClientElement();
		
		if(clients != null && clients.length > 0 ){
			validateMessage(listClientResponse);
		
		}else{
			Assert.assertTrue(clients.length == 0);
		}
		
	}
	
	@Test
	public void testDeleteClient() {

		if(id != null){
			APIResponse deleteClientResponse =	service.path(id.toString())
					.accept(MediaType.APPLICATION_JSON)
					.delete(APIResponse.class);
			
			validateMessage(deleteClientResponse);
			
		}else{
			MultivaluedMap<String, String> params = new MultivaluedMapImpl();
			params.add("nif", nif);
			params.add("nome", nome);
			
			
			ClientResponse listClientResponse = service.path("search")
					.queryParams(params)
					.accept(MediaType.APPLICATION_JSON).
					get(ClientResponse.class);
			
			validateMessage(listClientResponse);
			
			ClientElement[] clients = listClientResponse.getClientElement();
			
			if(clients.length > 0){
				for(ClientElement client : clients){
					APIResponse deleteClientResponse =	service.path(client.getId().toString())
							.accept(MediaType.APPLICATION_JSON)
							.delete(APIResponse.class);
					
					validateMessage(deleteClientResponse);
				}
			}
		}
		
	}

	private void validateMessage(APIResponse resonse) {
		Assert.assertTrue(resonse != null);
		
		String message = resonse.getMessage();
		
		Assert.assertTrue("OK |" + message ,"OK".equals(resonse.getErrorCode()));
	}
	
}
