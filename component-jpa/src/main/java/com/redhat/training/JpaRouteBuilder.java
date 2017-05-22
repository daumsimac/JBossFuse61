package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

public class JpaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("")
		.marshal().bindy(BindyType.Csv, "com.redhat.training.entity")
		.to("file:out");

	}

}
