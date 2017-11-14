package com.juniter.sample.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServiceTest {
	@Autowired
	private SampleService sampleService;
	
	@Test
	public void testSample() {
		sampleService.sample();
	}
	
	@Test
	public void testSampleRollback() {
		sampleService.sampleRollback();
	}

}
