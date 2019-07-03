/**
 * 
 */
package tech.desweb.ereservation.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.desweb.ereservation.model.Client;
import tech.desweb.ereservation.resources.vo.ClientVO;
import tech.desweb.ereservation.services.ClientService;

/**
 * Class that represent the web service client
 * @author smiit
 *
 */
@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {
	private final ClientService clientService;
	
	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	@ApiOperation(value = "Create Client",notes = "Service for create new client")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message = "The client has been created successfully!"),
			@ApiResponse(code = 400,message = "Invalid request")
	})
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO){
		Client client = new Client();
		client.setFirstName(clientVO.getFirstName());
		client.setLastName(clientVO.getLastName());
		client.setIdentification(clientVO.getIdentification());
		client.setAddress(clientVO.getAddress());
		client.setPhone(clientVO.getPhone());
		client.setEmail(clientVO.getEmail());
		return new ResponseEntity<>(this.clientService.create(client),HttpStatus.CREATED);
	}
	
	@PutMapping("/{identification}")
	@ApiOperation(value = "Update Client",notes = "Service for update client")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "The client has been updated successfully!"),
			@ApiResponse(code = 404,message = "The client has not been found")
	})
	public ResponseEntity<Client> updateClient(@PathVariable("identification") String identification,ClientVO clientVO){
		Client client = this.clientService.findByIdentification(identification);
		if(client == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			client.setFirstName(clientVO.getFirstName());
			client.setLastName(clientVO.getLastName());
			client.setIdentification(clientVO.getIdentification());
			client.setAddress(clientVO.getAddress());
			client.setPhone(clientVO.getPhone());
			client.setEmail(clientVO.getEmail());
			return new ResponseEntity<>(this.clientService.update(client),HttpStatus.OK);	
		}
	}
	
	@DeleteMapping("/{identification}")
	@ApiOperation(value = "Delete Client",notes = "Service for delete client")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "The client has been deleted successfully!"),
			@ApiResponse(code = 404,message = "The client has not been found")
	})
	public void deleteClient(@PathVariable("identification") String identification) {
		Client client = this.clientService.findByIdentification(identification);
		if(client != null) {
			this.clientService.delete(client);	
		}
	}
	
	@GetMapping
	@ApiOperation(value = "List Client",notes = "Service for list client")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "The clients has been found!"),
			@ApiResponse(code = 404,message = "The clients has not been found")
	})
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
