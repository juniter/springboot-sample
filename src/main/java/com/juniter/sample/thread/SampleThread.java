package com.juniter.sample.thread;

import org.springframework.stereotype.Component;

import com.juniter.sample.service.SampleService;

@Component
public class SampleThread implements Runnable {
	private final SampleService service;
	
	public SampleThread(SampleService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.sayOK();
	}
}
