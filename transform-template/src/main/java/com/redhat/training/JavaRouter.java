package com.redhat.training;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaRouter {

	public static void main(String[] args) throws Exception {

		
		Map<String,String> map = new HashMap<String, String>();
		
		System.out.println(map);
		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new JavaRouteBuilder());
		context.start();
		
		Thread.sleep(5000);
		context.stop();

	}

}
