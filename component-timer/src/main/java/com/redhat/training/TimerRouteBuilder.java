package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class TimerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("")
		.setBody(simple("Current time is ${header.firedTime}"))
		.to("file:out");

	}

}
