package com.redhat.training.main;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.redhat.training.route.ConsumerRouteBuilder;

public class Main {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"vm://localhost");
		context.addComponent("jms",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new ConsumerRouteBuilder());
		context.start();

		Thread.sleep(5000);

		
		context.stop();
	}

}
