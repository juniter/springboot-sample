package com.juniter.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.juniter.sample.conf.SampleConfigure;

@ServletComponentScan(basePackages = "com.juniter.sample.filter")
@EnableConfigurationProperties(SampleConfigure.class)
@SpringBootApplication
public class SpringBootApplicationSample{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationSample.class, args);
	}
}
