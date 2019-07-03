/**
 * 
 */
package tech.desweb.ereservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.desweb.ereservation.model.Reservation;

/**
 * @author smiit
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, String>{

	/**
	 * Method definition for search reservations
	 * */
	@Query("Select r from Reservation r where r.entryDate =:startDate and r.departureDate =:endDate  ")
	public List<Reservation> find(@Param("startDate") Date startDate, @Param("departureDate") Date endDate);
}
