package com.avijitdas.tech2.poc.docker;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Receiver {

	// private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		Customer customer = null;
		System.out.println("Received Message=" + message);
		// JSON from String to Object
		try {
			customer = new ObjectMapper().readValue(message, Customer.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Received Object=" + customer);
		// latch.countDown();
	}

	// public CountDownLatch getLatch() {
	// return latch;
	// }

}