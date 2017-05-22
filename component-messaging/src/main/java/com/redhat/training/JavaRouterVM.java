package com.redhat.training;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.redhat.training.routes.vm.VmRouteBuilder;
import com.redhat.training.routes.vm.VmRouteBuilder2;

public class JavaRouterVM {

	public static void main(String[] args) throws Exception {

		CamelContext contextFirst = new DefaultCamelContext();
		CamelContext contextSecond = new DefaultCamelContext();
		contextFirst.addRoutes(new VmRouteBuilder());
		contextSecond.addRoutes(new VmRouteBuilder2());
		contextFirst.start();
		contextSecond.start();
		
		Thread.sleep(5000);
		
		contextFirst.stop();
		contextSecond.stop();

	}

}
