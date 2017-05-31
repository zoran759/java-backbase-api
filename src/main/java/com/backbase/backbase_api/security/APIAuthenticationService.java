package com.backbase.backbase_api.security;

import javax.security.auth.Subject;

import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class APIAuthenticationService implements Processor {
	
	public void process(Exchange exchange) throws Exception {
        // get the username and password from the HTTP header
        // http://en.wikipedia.org/wiki/Basic_access_authentication
		if(exchange.getIn().getHeader("Authorization", String.class) == null) {
			throw new CamelAuthorizationException("There is no credentials provided", exchange);
		}
		
		String userpass = new String(Base64.decodeBase64(exchange.getIn().getHeader("Authorization", String.class).split(" ")[1]));
		
        String[] tokens = userpass.split(":");
         
        // create an Authentication object
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(tokens[0], tokens[1]);
 
        // wrap it in a Subject
        Subject subject = new Subject();
        subject.getPrincipals().add(authToken);
 
        // place the Subject in the In message
        exchange.getIn().setHeader(Exchange.AUTHENTICATION, subject);
 
        // you could also do this if useThreadSecurityContext is set to true
        // SecurityContextHolder.getContext().setAuthentication(authToken);
    }

}
