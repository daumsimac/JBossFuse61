package com.redhat.training.codefirst;

import org.apache.camel.builder.RouteBuilder;

public class ConsumerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		 from("file:in?noop=true")
		 .log("body contents initial: ${body}")
		 .log("body contents final: ${body}");
		 
		
	}

}
