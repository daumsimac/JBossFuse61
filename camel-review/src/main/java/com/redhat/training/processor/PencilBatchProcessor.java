package com.redhat.training.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.xml.XPathBuilder;

import com.redhat.training.exception.IllegalAmountOfPencilsException;

public class PencilBatchProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String item = (String)exchange.getIn().getBody(String.class);
		// we only sell 144 or more pencils in a batch processing. 
		Integer amount = XPathBuilder.xpath("//orderItem/amount").evaluate(exchange.getContext(), item,Integer.class);
		if(amount<=144){
			throw new IllegalAmountOfPencilsException();
		}

	}

}
