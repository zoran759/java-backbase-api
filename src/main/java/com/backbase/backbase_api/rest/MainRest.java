package com.backbase.backbase_api.rest;

import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class MainRest extends RouteBuilder{

	/*
	 * (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 * http://localhost:8080/backbase-api/rest/find-atm?city=Leiderdorp
	 */
	@Override
	public void configure() throws Exception {
		
		onException(CamelAuthorizationException.class).handled(true)
		.transform(simple("Access Denied. Please make sure you are authenticating and/or using the correct credentials for an ADMIN user"))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, simple("401"));
			
		restConfiguration().component("servlet").port(8080).scheme("http");
		
		rest("/rest")
			.consumes("application/json").produces("application/json").get("/find-atm").route().to("bean:apiAuthenticationService").policy("admin").to("direct:findATMByCity");
		
		from("direct:findATMByCity")
		.setHeader("city", simple("${in.header.city}"))
		    .policy("admin")
	    	.to("direct:callWebservice")
			.marshal().json(JsonLibrary.Gson)
		.end();
		
	}
	
	

}
