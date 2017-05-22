package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class HelloRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in?noop=true")
		 .to("file:out");
	}

}
