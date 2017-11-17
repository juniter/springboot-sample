package com.juniter.sample.service;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.juniter.sample.model.City;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTransactionServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(AnnotationTransactionServiceTest.class);
	@Autowired
	private AnnotationTransactionService service;
	
	@Test
	public void testGetCityById(){
		City city= service.getCityById(2);
		logger.info("测试事物，从数据库中查询出来的数据：{}",city.toJSON());
	}

	@Test
	public void testUpdateCity() throws Exception{
		City city= new City();
		city.setId(1L);
		city.setName("xxxx");
		city.setCountry("YYYY");
		Integer i = service.updateCity(city);
		logger.info("测试事物，更新行数：{}",i);
	}

}
