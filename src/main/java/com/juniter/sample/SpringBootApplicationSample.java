package com.juniter.sample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.juniter.sample.conf.SampleConfigure;
import com.juniter.sample.dao.CityDao;
import com.juniter.sample.mapper.HotelMapper;

@ServletComponentScan(basePackages = "com.juniter.sample.filter")
@EnableConfigurationProperties(SampleConfigure.class)
@SpringBootApplication
@EnableTransactionManagement
public class SpringBootApplicationSample implements CommandLineRunner{
	public static void main(String[] args) {
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
	}
}
