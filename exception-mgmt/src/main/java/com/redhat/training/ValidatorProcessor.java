package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ValidatorProcessor implements Processor {

	
	@Override
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		System.out.println(body);
	}

}
