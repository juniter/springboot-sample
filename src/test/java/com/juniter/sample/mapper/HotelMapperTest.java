package com.juniter.sample.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

import com.juniter.sample.SpringBootApplicationSample;
import com.juniter.sample.model.Hotel;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT ,classes = SpringBootApplicationSample.class)
public class HotelMapperTest {

	@Autowired
	private HotelMapper hotelMapper;

	@Test
	public void selectByCityIdTest() {
		Hotel hotel = hotelMapper.selectByCityId(1);
		assertThat(hotel.getName()).isEqualTo("Conrad Treasury Place");
		assertThat(hotel.getAddress()).isEqualTo("William & George Streets");
		assertThat(hotel.getZip()).isEqualTo("4001");
	}
}
