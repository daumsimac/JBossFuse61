package com.redhat.training;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaRouterTimer {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new TimerRouteBuilder());
		context.start();
		
		Thread.sleep(10000);
		
		context.stop();

	}

}
