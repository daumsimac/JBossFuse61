package com.redhat.training;


import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import com.redhat.training.routes.direct.DirectRouteBuilder;

public class JavaRouterDirect {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		
		
		context.addRoutes(new DirectRouteBuilder());
		context.start();
		ProducerTemplate template = context.createProducerTemplate();
		template.requestBody("direct:data", new Order());		
		Thread.sleep(5000);
		
		
		context.stop();

	}

}
