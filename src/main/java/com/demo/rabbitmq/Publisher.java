package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class Publisher {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		String[] msgArr = { "First", "Second", "Third", "Fourth" };
		for (String msg : msgArr) {
			channel.basicPublish("", "Queue-1", null, msg.getBytes());
		}

		channel.close();
		connection.close();
	}
}
