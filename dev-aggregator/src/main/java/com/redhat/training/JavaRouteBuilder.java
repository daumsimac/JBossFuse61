package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class JavaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//from("file:in?noop=true")
		//		.process(new DestinationProcessor())
		//		.to("file:out");
		AggregationStrategy strategy = new BodyAggregationStrategy();
		from("file:in?noop=true")
		.process(new DestinationProcessor())
		.aggregate(header("customer"), strategy).completionSize(5).to("file:out");
	}

}
