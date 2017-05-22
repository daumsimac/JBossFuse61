package com.redhat.training.aggregation;

import static org.apache.camel.builder.xml.XPathBuilder.xpath;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class OrderAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			return newExchange;
		}
		CamelContext context = newExchange.getContext();
		Object body = newExchange.getIn().getBody();
		
		int newAmount = xpath("//orderItem/amount").evaluate(
				context, body, Integer.class);
		double newPrice = Double.parseDouble(xpath("//orderItem/price").evaluate(
				context, body));
		Double newTotal = (Double) oldExchange.getIn().getHeader("total");
		newTotal += newAmount*newPrice; 
		
		oldExchange.getIn().setHeader("total",newTotal);
		
		String newBody=String.format("<order><orderId>"+newExchange.getIn().getHeader("orderNumber")+"</orderId><totalAmount>"+newTotal+"</totalAmount></order>");
		
		oldExchange.getIn().setBody(newBody);
		oldExchange.getIn().setHeader(Exchange.FILE_NAME, "order.xml");
		return oldExchange;
	}
}
