package com.juniter.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import com.juniter.sample.mapper.HotelMapper;
import com.juniter.sample.model.Hotel;

@Service
public class SampleService extends SuperService {

	@Autowired
	private HotelMapper hotelMapper;

	public SampleService(PlatformTransactionManager transactionManager) {
		super(transactionManager);
	}

	public void sample() {
		Integer result = this.doTransaction(this::batchInsert);
		System.out.println("最后执行条数：" + result);
	}
	
	public void sampleRollback() {
		Integer result = this.doTransaction(this::batchInsert2);
		System.out.println("最后执行条数：" + result);
	}

	public Integer batchInsert() {
		Integer count = 0;
		for (int i = 0; i <= 10; i++) {
			count += this.hotelMapper.addNewCity(new Hotel().setZip("100010"+i));
		}
		return count;
	}
	
	public Integer batchInsert2() throws Exception {
		Integer count = 0;
		for (int i = 0; i <= 10; i++) {
			count += this.hotelMapper.addNewCity(new Hotel().setZip("100010"+i));
			/*if (i>6)
				throw new Exception("测试事物回滚机制");*/
		}
		return count;
	}
}
