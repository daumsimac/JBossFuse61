package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class JavaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in?noop=true")
		.choice()
		.when(header("CamelFileNameOnly").endsWith(".txt")).to("file:///home/student/JB421/labs/test-camel-support/txt")
		.when(header("CamelFileNameOnly").endsWith(".xml")).to("file:////home/student/JB421/labs/test-camel-support/xml").end();
		
	}
	
}
