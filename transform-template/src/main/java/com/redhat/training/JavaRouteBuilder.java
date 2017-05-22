package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

public class JavaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:in?noop=true").unmarshal()
				.bindy(BindyType.Csv, "com.redhat.training")
				.to("file:out");
	}

}
