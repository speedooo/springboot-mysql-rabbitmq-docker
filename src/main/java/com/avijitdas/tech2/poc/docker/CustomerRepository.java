package com.avijitdas.tech2.poc.docker;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author avijitdas
 *
 */

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * This method will find an User instance in the database by its email. Note that this method is not implemented and
	 * its working code will be automatically generated from its signature by Spring Data JPA.
	 */
	public Customer findByEmail(String email);

}
