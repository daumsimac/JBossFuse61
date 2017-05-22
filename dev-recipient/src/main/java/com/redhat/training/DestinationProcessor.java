package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

final class DestinationProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String recipientList="cars, motorcycles";
		String fileName = (String)in.getHeader("CamelFileNameOnly");
		
		in.getHeaders().put("destinations", recipientList);
	}
}