package com.backbase.backbase_api.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Header;

import com.backbase.backbase_api.model.ATM;

public class ProcessBean {
	
	@Handler
	public void process(Exchange exchange) {
		String json = (String) exchange.getIn().getBody();

		exchange.getIn().setBody(json.substring(5));
	}

	public void filterByCity(Exchange exchange, @Header("city") String city) {
		List<ATM> filteredATMs = new ArrayList<ATM>();
		List<ATM> atms = Arrays.asList((ATM[]) exchange.getIn().getBody());
		
		for(ATM atm : atms) {
			if(atm.getAddress().getCity().equals(city))
				filteredATMs.add(atm);
		}
		
		exchange.getIn().setBody(filteredATMs);
	}
}
