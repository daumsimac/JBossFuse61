package com.redhat.training.contractfirst;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author student
 * 
 */
public class ProducerRouter {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.start();
		context.addRoutes(new ProducerRouteBuilder());
		ProducerTemplate producer = context.createProducerTemplate();
		producer.requestBody("cxf://http://localhost:9001/order?wsdlURL=src/main/resources/wsdl/order.wsdl&dataFormat=MESSAGE", "N2PENCIL");
		Thread.sleep(10000);
		context.stop();
	}

}
