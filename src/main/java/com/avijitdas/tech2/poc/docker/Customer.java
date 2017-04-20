package com.avijitdas.tech2.poc.docker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author avijitdas
 *
 */

@Entity
class Customer {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String email;

	public Customer() {

	}

	public Customer(long id) {
		this.id = id;
	}

	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String lastname) {
		this.email = lastname;
	}

	@Override
	public String toString() {
		return "Customer [id=" + this.id + ", name=" + this.name + ", email=" + this.email + "] ";
	}

}
