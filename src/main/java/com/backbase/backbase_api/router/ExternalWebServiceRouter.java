package com.backbase.backbase_api.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.backbase.backbase_api.model.ATM;
/**
 * Class used to execute a call to the external web service
 * URL: https://www.ing.nl/api/locator/atms/
 * @author renam
 *
 */
public class ExternalWebServiceRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:callWebservice")
			.streamCaching()
			.setHeader(Exchange.HTTP_URI, simple("https://www.ing.nl/api/locator/atms/"))
		    .to("http4://executeRequest")
		    .convertBodyTo(String.class)
		    .to("bean:processBean")
		    .unmarshal().json(JsonLibrary.Gson, ATM[].class)
		    .to("bean:processBean?method=filterByCity")
		    .end();
	}
}