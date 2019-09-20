package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String msg = new String(delivery.getBody());
			System.out.println("Message received = " + msg);
		};
		channel.basicConsume("Queue-1", true, deliverCallback, consumeTag -> {
		});
	}

}
