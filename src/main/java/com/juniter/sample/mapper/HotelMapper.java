package com.juniter.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.juniter.sample.model.Hotel;

@Mapper
public interface HotelMapper {
	Hotel selectByCityId(int city_id);
}
