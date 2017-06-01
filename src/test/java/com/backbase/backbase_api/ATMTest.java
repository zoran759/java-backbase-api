package com.backbase.backbase_api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.backbase.backbase_api.model.ATM;
import com.backbase.backbase_api.model.ATM.Address;

public class ATMTest {

	private ATM atm;
	private Address address;
	
	@Before
	public void setUp() throws Exception {
		atm = new ATM();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test completed!!");
	}

	@Test
	public void testSetAddress() {
		address = atm.new Address();
		atm.setAddress(address);
		
		assertNotNull(address);
		assertThat(address, IsInstanceOf.instanceOf(Address.class));
	}

    @Test
	public void testSetDistance() {
		Double distance = new Double(2.67);
		
		assertNotNull(distance);
		assertThat(distance, IsInstanceOf.instanceOf(Double.class));
	}

    @Test
	public void testSetType() {
		String type = "ING";
		
		assertNotNull(type);
		assertThat(type, IsInstanceOf.instanceOf(String.class));
	}

}
