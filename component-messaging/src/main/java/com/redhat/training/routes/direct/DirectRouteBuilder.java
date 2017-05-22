package com.redhat.training.routes.direct;

import org.apache.camel.builder.RouteBuilder;

public class DirectRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:data")
		.marshal().serialization()
		 .to("file:direct-out");
		
	}

}
