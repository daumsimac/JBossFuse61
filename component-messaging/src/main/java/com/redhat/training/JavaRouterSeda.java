package com.redhat.training;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.redhat.training.routes.seda.SedaRouteBuilder;

public class JavaRouterSeda {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new SedaRouteBuilder());
		context.start();
		Thread.sleep(5000);
		
		context.stop();

	}

}
