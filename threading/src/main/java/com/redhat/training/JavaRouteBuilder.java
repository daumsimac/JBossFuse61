package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class JavaRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:in?noop=true")
        .log("Starting to process file: ${header.CamelFileName}")
        .split(body().tokenize("\n"))
            .bean(OrderService.class, "csvToObject")
            .to("direct:update")
        .end()
        .log("Done processing big file: ${header.CamelFileName}");

		from("direct:update")
        .bean(OrderService.class, "updateDatabase");
		
	}

}
