package com.juniter.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.juniter.sample.conf.SampleConfigure;

@EnableConfigurationProperties(SampleConfigure.class)
@SpringBootApplication
public class SpringBootApplicationSample{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationSample.class, args);
	}
}
