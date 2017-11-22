package com.juniter.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juniter.sample.annotation.SampleTx;
import com.juniter.sample.mapper.CityMapper;
import com.juniter.sample.model.City;

@Service
@Transactional(readOnly = true)
public class AnnotationTransactionService {
	@Autowired
	private CityMapper cityMapper;

	public City getCityById(Integer id) {
		return this.cityMapper.getCityById(id);
	}

	@SampleTx
	public Integer updateCity(City city) throws Exception {
		for (int i = 0; i <= 5; i++) {
			this.cityMapper.addNewCity(new City().setName("City-" + i).setCountry("China").setState("S-" + i));
			/*if (i > 4)
				throw new Exception("测试事物回滚机制");*/
		}
		return this.cityMapper.updateCityById(city);
	}
}
