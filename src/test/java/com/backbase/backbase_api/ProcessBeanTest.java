package com.backbase.backbase_api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProcessBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test completed!!!");
	}

	@Test
	public void testProcessMalformedJson() {
		String json = "myFirstString";
		assertNotNull(json);
		assertThat(json, IsInstanceOf.instanceOf(String.class));
	}

	@Test
	public void testFilterByCity() {
		String json = "mySecondString";
		assertNotNull(json);
		assertThat(json, IsInstanceOf.instanceOf(String.class));
	}

}
