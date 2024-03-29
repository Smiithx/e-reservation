/**
 * 
 */
package tech.desweb.ereservation.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.desweb.ereservation.model.Client;
import tech.desweb.ereservation.repository.ClientRepository;

/**
 * Class for defined the services of client
 * 
 * @author smiit
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	/**
	 * Method to perform the operation of saving a client
	 * 
	 * @param ClientVO client
	 * @return {@link Client}
	 */
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Method to perform the operation of updating a client
	 * 
	 * @param ClientVO client
	 * @return {@link Client}
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Method to perform the operation of deleting a client
	 * 
	 * @param ClientVO client
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}

	/**
	 * Method for search clients by identification
	 * 
	 * @param String identification
	 * @return {@link Client}
	 */
	public Client findByIdentification(String identification) {
		return this.clientRepository.findByIdentification(identification);
	}
	
	/**
	 * Method for search all clients
	 * 
	 * @return {@link List<Client> }
	 */
	public List<Client> findAll(){
		return this.clientRepository.findAll(); 
	}
}
