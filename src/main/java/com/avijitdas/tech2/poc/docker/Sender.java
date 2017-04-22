package com.avijitdas.tech2.poc.docker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Sender {

	private final RabbitTemplate rabbitTemplate;

	public Sender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(Object object) throws Exception {
		System.out.println("Sending Object=" + object);
		String json = new ObjectMapper().writeValueAsString(object);
		System.out.println("Sending JSON=" + json);
		rabbitTemplate.convertAndSend(Application.queueName, json);
	}

}