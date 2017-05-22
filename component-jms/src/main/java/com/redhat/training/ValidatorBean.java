package com.redhat.training;

import org.apache.camel.Body;
import org.apache.camel.Exchange;

public class ValidatorBean {
    public void validate(@Body String partName, Exchange exchange) {
    	
        // only motors are valid parts in this simple test bean
        if (partName.contains("N2PENCIL")) {
            exchange.getOut().setBody("Valid");
        } else {
            exchange.getOut().setBody("Invalid");
        }
    }
}
