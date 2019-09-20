package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		String msg = "This is mobile";
		// String msg = "This is tv";
		// String msg = "This is ac";
		channel.basicPublish("Direct-Exchange", "mobile", null, msg.getBytes());
		// channel.basicPublish("Direct-Exchange", "tv", null, msg.getBytes());
		// channel.basicPublish("Direct-Exchange", "ac", null, msg.getBytes());

		channel.close();
		connection.close();
	}

}
