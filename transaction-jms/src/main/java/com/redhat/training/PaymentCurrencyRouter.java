package com.redhat.training;

import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentCurrencyRouter extends SpringRouteBuilder{
    private static final Logger LOG = LoggerFactory.getLogger(PaymentCurrencyRouter.class);
	
	@Override
	public void configure() throws Exception {
        // Initialize the Jaxb context so that Camel can marshal/unmarshal
        JaxbDataFormat jaxb = new JaxbDataFormat(true);
	jaxb.setContextPath("com.redhat.training");
	errorHandler(noErrorHandler());
		
		// From the incoming queue
		from( "activemq:queue:incomingPayments" )
			.convertBodyTo( String.class )
			// Unmarshal the XML content to Java using JAXB
			.unmarshal( jaxb )
			// Do some processing on the message
			.process(new CurrencyProcessor())
			// Send the result to the target queue
			.marshal( jaxb )
			.convertBodyTo( String.class )
			.to( "activemq:queue:outgoingPayments" );

        LOG.info("Configured Tx MS Message Processor for Source URI: 'activemq:queue:incomingPayments'");
	}

}
