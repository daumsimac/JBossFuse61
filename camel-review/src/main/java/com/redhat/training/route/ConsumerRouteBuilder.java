package com.redhat.training.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import com.redhat.training.aggregation.OrderAggregationStrategy;
import com.redhat.training.exception.IllegalAmountOfPencilsException;
import com.redhat.training.processor.DestinationInHeaderProcessor;
import com.redhat.training.processor.OrderNumberInHeaderProcessor;
import com.redhat.training.processor.PencilBatchProcessor;
import com.redhat.training.processor.TotalInHeaderProcessor;

public class ConsumerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		
		
	}
}
