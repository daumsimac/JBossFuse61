package com.redhat.training;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ComponentMain {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"vm://localhost");
		
		Order order = new Order();

		sendMessage(connectionFactory, "hello",order, "2014");
		String correlationId = receiveMessage(connectionFactory,"hello");
		sendMessage(connectionFactory,"helloResponse","ACK",correlationId);
		 
		
		
	}

	private static String receiveMessage(ConnectionFactory connectionFactory, String queueName)
			throws JMSException {
		Connection connectionReception = connectionFactory.createConnection();
		connectionReception.start();
		Session sessionReception = connectionReception.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue destinationReception = sessionReception.createQueue(queueName);
		MessageConsumer consumer = sessionReception.createConsumer(destinationReception);
		ObjectMessage messageReceived = (ObjectMessage) consumer.receive();
		String correlationId = messageReceived.getJMSCorrelationID();
		sessionReception.close();
		connectionReception.close();
		return correlationId;
	}

	private static void sendMessage(
			ConnectionFactory connectionFactory, String queueName,Serializable sendData, String correlationId) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue destination = session.createQueue(queueName);
		MessageProducer producer = session.createProducer(destination);
		ObjectMessage message = session.createObjectMessage(sendData);
		message.setJMSCorrelationID(correlationId);
		producer.send(message);
		session.close();
		connection.close();
	}
}
