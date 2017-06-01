package com.backbase.backbase_api;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.backbase.backbase_api.router.ExternalWebServiceRouter;

public class MainTest extends CamelTestSupport{
    
	@Test
	public void testEndpoints() {
		assertNotNull(context.hasEndpoint("direct:callWebservice"));
	}
	
	protected RouteBuilder createRouteBuilder() throws Exception {
	    return new ExternalWebServiceRouter();
	}
}
