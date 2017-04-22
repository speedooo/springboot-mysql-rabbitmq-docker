package com.avijitdas.tech2.poc.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author avijitdas
 *
 */
@RestController
public class Controller {

	private static int hitCount = 0;

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private Sender sender;

	@RequestMapping("/")
	public String home() {
		Customer customer = this.repository.findAll().iterator().next(); // first record
		String welcomeMsg = "Welcome " + customer.getName();
		System.out.println("[home][" + (++hitCount) + "] welcomeMsg=" + welcomeMsg);
		return welcomeMsg;
	}

	/**
	 * GET /create --> Create a new customer and save it in the database.<br>
	 * /create?email=[email]&name=[name]
	 */
	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, String email) {
		String customerId = "";
		try {
			Customer customer = new Customer(name, email);
			repository.save(customer);
			customerId = String.valueOf(customer.getId());

			sender.send(customer);
		} catch (Exception ex) {
			return "Error creating the customer: " + ex.toString();
		}

		String response = "Customer succesfully created with id=" + customerId + " & name=" + name;
		System.out.println("[create] " + response);
		return response;
	}

	/**
	 * GET /getByEmail --> Return the name for the customer having the passed email <br>
	 * /getByEmail?email=[email]
	 */
	// @RequestMapping("/getByEmail")
	// @ResponseBody
	// public String getByEmail(String email) {
	// String response = "";
	// try {
	// Customer customer = repository.findByEmail(email);
	// response = "The customer name is: " + customer.getName();
	// } catch (Exception ex) {
	// response = "Customer not found";
	// }
	//
	// System.out.println("[getByEmail] " + response);
	// return response;
	//
	// }

	/**
	 * GET /update --> Update the name and the email for the customer in the database having the passed id.<br>
	 * /update?id=[id]&email=[email]&name=[name]
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateCustomer(long id, String name, String email) {
		Customer customer = new Customer();
		try {
			customer = repository.findOne(id);
			customer.setName(name);
			customer.setEmail(email);
			repository.save(customer);
		} catch (Exception ex) {
			return "Error updating the customer: " + ex.toString();
		}

		String response = "Customer succesfully updated! " + customer != null ? customer.toString() : null;
		System.out.println("[update] " + response);
		return response;
	}

	/**
	 * GET /delete --> Delete the customer having the passed id.<br>
	 * /delete?id=[id]
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		String response = "";
		try {
			Customer customer = new Customer(id);
			repository.delete(customer);
		} catch (Exception ex) {
			response = "Error deleting the customer:" + ex.toString();
		}

		response = "Customer succesfully deleted with id=" + id;
		System.out.println("[update] " + response);
		return response;
	}

	@RequestMapping("/showAll")
	@ResponseBody
	public String showAll() {
		String response = "";
		Iterable<Customer> customers = this.repository.findAll();
		for (Customer customer : customers) {
			response += customer.toString() + "<br>";
		}
		System.out.println("[showAll] " + response);
		return response;
	}
}
