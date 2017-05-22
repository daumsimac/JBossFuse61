package com.redhat.training.route;

import static org.apache.camel.component.jms.JmsComponent.jmsComponentAutoAcknowledge;

import java.util.List;

import javax.jms.ConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OrderInHeaderTest extends CamelTestSupport {

    protected CamelContext createCamelContext() throws Exception {
        CamelContext camelContext = super.createCamelContext();

        // must use persistent so the message is not lost
        ConnectionFactory connectionFactory = CamelJmsTestHelper.createPersistentConnectionFactory();
        camelContext.addComponent("jms", jmsComponentAutoAcknowledge(connectionFactory));

        return camelContext;
    }


	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new ConsumerRouteBuilder();
	}
	@Test
	public void testValidOrderNumberHeader() throws InterruptedException {
		
		MockEndpoint mockEndpoint = getMockEndpoint("mock:orderInHeader");
		template.sendBodyAndHeader("file:in?noop=true","<orderItem><id>01</id><orderId>1</orderId><description>N2PENCIL</description><companyId>01</companyId><price>0.15</price><amount>200</amount></orderItem>", Exchange.FILE_NAME, "itemOrderExample.xml");
		mockEndpoint.expectedMessageCount(1);
		mockEndpoint.expectedHeaderReceived("orderNumber", 1);
		mockEndpoint.assertIsSatisfied();
	}

	@Test
	public void testValidDestinationHeader() throws InterruptedException {
		template.sendBodyAndHeader("file:in?noop=true","<orderItem><id>01</id><orderId>1</orderId><description>N2PENCIL</description><companyId>02</companyId><price>0.15</price><amount>200</amount></orderItem>", Exchange.FILE_NAME, "itemOrderExample.xml");
		MockEndpoint mockEndpoint = getMockEndpoint("mock:orderInHeader");
		mockEndpoint.expectedMessageCount(1);
		mockEndpoint.expectedHeaderReceived("destination", "jms:queue:02");
		mockEndpoint.assertIsSatisfied();
	}
	
	@Test
	public void testNotValidAmountDestinationHeader() throws InterruptedException {
		template.sendBodyAndHeader("file:in?noop=true","<orderItem><id>01</id><orderId>1</orderId><description>N2PENCIL</description><companyId>01</companyId><price>0.15</price><amount>100</amount></orderItem>", Exchange.FILE_NAME, "itemOrderExample.xml");
		MockEndpoint mockEndpoint = getMockEndpoint("mock:finalOrder");
		mockEndpoint.expectedMessageCount(0);
		mockEndpoint.assertIsSatisfied();
	}
}
