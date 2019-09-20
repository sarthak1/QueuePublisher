package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RealTimeExample {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("from_date", "01-Jan-2019");
		jsonObject.put("to_date", "31-Dec-2019");
		jsonObject.put("email", "xyz@gmail.com");
		jsonObject.put("query", "select * from data");

		channel.basicPublish("", "Queue-1", null, jsonObject.toString().getBytes());

		channel.close();
		connection.close();

	}

}
