package com.redhat.training.routes.vm;

import org.apache.camel.builder.RouteBuilder;

public class VmRouteBuilder2 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("vm:inputDialog")
		.choice()
		.when(header("CamelFileName").endsWith(".txt")).to("file:vm-txt")
		.when(header("CamelFileName").endsWith(".xml")).to("file:vm-xml")
		.end();
		
	}

}
