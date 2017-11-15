package com.juniter.sample.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JiGeServiceTest {

	@Autowired
	private JiGeService service;
	
	@Test
	public void testToJiGe() {
		service.toJiGe();
	}

}
