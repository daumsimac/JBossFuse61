package com.redhat.training;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaRouterLog {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new LogRouteBuilder());
		context.start();
		Thread.sleep(5000);
		
		context.stop();

	}

}
