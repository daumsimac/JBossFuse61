package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LogProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String body = exchange.getIn().getBody(String.class);
		System.out.println("Message content:" + body);
	}

}
