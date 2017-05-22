package com.redhat.training.routes.vm;

import org.apache.camel.builder.RouteBuilder;

public class VmRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in?noop=true")
		.to("vm:inputDialog");
	}

}
