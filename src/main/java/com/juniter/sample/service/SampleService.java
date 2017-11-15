package com.juniter.sample.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import com.juniter.sample.mapper.HotelMapper;
import com.juniter.sample.model.Hotel;

@Service
public class SampleService extends SuperService {

	private final HotelMapper hotelMapper;

	public SampleService(PlatformTransactionManager transactionManager,HotelMapper hotelMapper) {
		super(transactionManager);
		this.hotelMapper = hotelMapper;
	}

	public void sample() {
		Integer result = super.doTransaction(this::batchInsert);
		logger.error("最后执行条数：{}",result);
	}
	
	public void sampleRollback() {
		Integer result = super.doTransaction(this::batchInsert2);
		logger.error("最后执行条数：{}",result);
	}
	
	public void threadSample() {
		new Thread(()->{
			logger.info("别的线程执行this.hotelMapper.selectByCityId()方法：{}",this.hotelMapper.selectByCityId(1));
		}).start();
	}
	
	public void sayOK(){
		logger.info("JustOK");
	}

	public Integer batchInsert(Object... o) {
		Integer count = 0;
		for (int i = 0; i <= 10; i++) {
			count += this.hotelMapper.addNewCity(new Hotel().setZip("100010"+i));
		}
		return count;
	}
	
	public Integer batchInsert2(Object... o) throws Exception {
		Integer count = 0;
		for (int i = 0; i <= 10; i++) {
			count += this.hotelMapper.addNewCity(new Hotel().setZip("100010"+i));
			/*if (i>6)
				throw new Exception("测试事物回滚机制");*/
		}
		return count;
	}
}
