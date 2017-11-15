package com.juniter.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniter.sample.thread.SampleThread;

@Service
public class JiGeService {
	
	@Autowired
	private SampleThread sampleThread;
	public void toJiGe() {
		Thread jige = new Thread(sampleThread);
		jige.start();
	}
}
