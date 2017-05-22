package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class JavaRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:in?noop=true")
		.choice()
		.when(header("CamelFileNameOnly").endsWith(".txt")).to("file:txt")
		.when(header("CamelFileNameOnly").endsWith(".xml")).to("file:xml").end();
		
	}


}
