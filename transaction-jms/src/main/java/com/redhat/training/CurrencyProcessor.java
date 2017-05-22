package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyProcessor implements Processor{
	
	private static final Logger LOG = LoggerFactory.getLogger(CurrencyProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		LOG.debug("Attempting to process an incoming message..");

        Payments payments = exchange.getIn().getBody(Payments.class);

        if (payments.getCurrency().equals("???")) {
                    LOG.warn("Rejecting payments file with currency '???'");
            throw new Exception("Rejecting payments file with currency '???'");
        } else {
                    LOG.info("Message looks good.");
        }
		
	}

}
