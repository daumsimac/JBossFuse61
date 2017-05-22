package com.redhat.training.codefirst;

import javax.xml.ws.Endpoint;

import com.redhat.training.ws.OrderProcessorImpl;

/**
 * @author student
 * 
 */
public class ConsumerRouter {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		Endpoint endpoint = Endpoint.publish("http://localhost:9000/order", new OrderProcessorImpl());
		context.start();
		context.addRoutes(new ConsumerRouteBuilder());
		Thread.sleep(10000);
		context.stop();
		endpoint.stop();
		
	}

}
