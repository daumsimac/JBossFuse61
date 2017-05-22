package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class JavaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:in?noop=true").choice()
		.when(header("CamelFileName").endsWith(".xml")).to("file:xml")
		.when(header("CamelFileName").endsWith(".txt")).to("file:txt")
		.end();
	}

}
