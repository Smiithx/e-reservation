/**
 * 
 */
package tech.desweb.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class that represents the reservations table
 * @author smiit
 *
 */
@Data
@Entity
@Table(name="reservations")
public class Reservation {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid2")
	private String id;
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	private int numberPeople;
	private String description;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	public Reservation() {
		
	}
}
