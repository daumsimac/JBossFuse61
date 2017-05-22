package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.training.exception.LogException;

public class LogProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		if (body.contains("N2PENCIL")) {
			throw new LogException();
		}
	}

}
