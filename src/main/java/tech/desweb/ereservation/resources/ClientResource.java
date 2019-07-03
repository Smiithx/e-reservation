/**
 * 
 */
package tech.desweb.ereservation.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class ClientResource {
	private final ClientService clientService;
	
	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
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
	public void deleteClient(@PathVariable("identification") String identification) {
		Client client = this.clientService.findByIdentification(identification);
		if(client != null) {
			this.clientService.delete(client);	
		}
	}
	
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
