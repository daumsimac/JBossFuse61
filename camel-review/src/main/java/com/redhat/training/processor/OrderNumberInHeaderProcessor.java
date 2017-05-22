package com.redhat.training.processor;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import static org.apache.camel.builder.xml.XPathBuilder.xpath;
public class OrderNumberInHeaderProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
	}

}
