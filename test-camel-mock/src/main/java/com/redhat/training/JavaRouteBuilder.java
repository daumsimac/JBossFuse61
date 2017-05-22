package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class JavaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:topic:orders")
		.to("ftp://localhost/ftp?username=student&password=jboss");
	}
	
}
