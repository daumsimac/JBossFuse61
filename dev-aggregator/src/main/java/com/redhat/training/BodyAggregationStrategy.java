package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

final class BodyAggregationStrategy implements AggregationStrategy {
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if(oldExchange == null)
			return newExchange;
		String newBody = newExchange.getIn().getBody(String.class);
		String oldBody = newExchange.getIn().getBody(String.class);
		newBody = newBody.concat(oldBody);
		newExchange.getIn().setBody(newBody);
		return newExchange;
	}
}