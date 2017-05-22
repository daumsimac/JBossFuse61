package com.redhat.training.contractfirst;

import org.apache.camel.builder.RouteBuilder;

public class ProducerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		 from("")
		 .log("body contents final: ${body}");
	}

}
