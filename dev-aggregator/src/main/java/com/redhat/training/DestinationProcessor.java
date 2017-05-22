package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

final class DestinationProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String customer=null;
		String fileName = (String)in.getHeader("CamelFileNameOnly");
		
		if (fileName.startsWith("cars")){
			customer = "cars";
		}else if(fileName.startsWith("motorcycles")){
			customer = "motorcycles";
		}
		in.getHeaders().put("customer", customer);
	}
}