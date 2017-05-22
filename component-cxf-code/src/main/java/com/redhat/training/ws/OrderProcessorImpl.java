package com.redhat.training.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.redhat.training.ws.OrderProcessor", 
serviceName = "orderProcessor")
public class OrderProcessorImpl implements OrderProcessor {

	@WebMethod
	public int getAvailableItems(String itemName) {
		if("PENCIL".equals(itemName)){
			return 0;
		}else{
			return 100;
		}
		
	}

}