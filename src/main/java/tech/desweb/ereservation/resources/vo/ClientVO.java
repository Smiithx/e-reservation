/**
 * 
 */
package tech.desweb.ereservation.resources.vo;

import lombok.Data;

/**
 * Class that represents the clients table
 * 
 * @author smiith
 *
 */
@Data
public class ClientVO {
	private String firstName;
	private String lastName;
	private String identification;
	private String address;
	private String phone;
	private String email;

	public ClientVO() {

	}

}
