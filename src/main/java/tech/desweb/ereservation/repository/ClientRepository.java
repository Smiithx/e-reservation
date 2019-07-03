/**
 * 
 */
package tech.desweb.ereservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.desweb.ereservation.model.Client;

/**
 * interface to define the operations of the database with the client
 * @author smiit
 *
 */
public interface ClientRepository extends JpaRepository<Client, String>{
	
	/**
	 * Method definition for search clients by last name
	 * */
	public List<Client> findByLastName(String lastName);
	
	/**
	 * Method definition for search clients by identification
	 * */
	public Client findByIdentification(String identification);
}
