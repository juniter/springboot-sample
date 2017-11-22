package com.juniter.sample;

import org.springframework.boot.SpringApplication;

import com.juniter.sample.dao.CityDao;
import com.juniter.sample.mapper.HotelMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
/*	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationSample.class, args);
	}

	private final CityDao cityDao;
	private final HotelMapper hotelMaper;
	
	public SpringBootApplicationSample(CityDao cityDao, HotelMapper hotelMaper) {
		this.cityDao = cityDao;
		this.hotelMaper = hotelMaper;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.cityDao.selectCityById(1));
		System.out.println(this.hotelMaper.selectByCityId(1));
	}*/
}
