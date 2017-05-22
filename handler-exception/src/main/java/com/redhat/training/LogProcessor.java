package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LogProcessor implements Processor {

	
	@Override
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		exchange.getIn().setBody(body+" concatenate with LogProcessor");
	}

}
