package com.juniter.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.juniter.sample.model.City;

@Mapper
public interface CityMapper {
	public City getCityById(Integer id);
	public Integer updateCityById(City city);
	public Integer addNewCity(City city);
}
