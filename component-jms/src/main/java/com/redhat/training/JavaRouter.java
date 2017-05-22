package com.redhat.training;


import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author student
 *
 */
public class JavaRouter {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();

		// Define JMS component with ActiveMQ factory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"vm://localhost");
		context.addComponent("jms",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		context.start();
		context.addRoutes(new JavaRouteBuilder());	
		Thread.sleep(5000);
		context.stop();
	}

}
