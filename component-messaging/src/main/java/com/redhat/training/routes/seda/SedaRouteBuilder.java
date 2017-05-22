package com.redhat.training.routes.seda;

import org.apache.camel.builder.RouteBuilder;

public class SedaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in?noop=true")
		 .to("seda:inputDialog");
		from("seda:inputDialog")
		.choice()
		.when(header("CamelFileName").endsWith(".txt")).to("file:txt")
		.when(header("CamelFileName").endsWith(".xml")).to("file:xml")
		.end();
		
	}

}
