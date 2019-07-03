/**
 * 
 */
package tech.desweb.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class that represents the clients table
 * @author smiith
 *
 */
@Data
@Entity
@Table(name = "clients")
@NamedQuery(name="Client.findByIdentification",query="Select c from Client c where c.identification = ?1")
public class Client {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid2")
	private String id;
	private String firstName;
	private String lastName;
	private String identification;
	private String address;
	private String phone;
	private String email;
	@OneToMany(mappedBy="client")
	private Set<Reservation> reservations;
	
	public Client() {
		
	}
	
	
	
}
