package com.juniter.sample.model;

import java.io.Serializable;

public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long city;

	private String name;

	private String address;

	private String zip;
	
	public Hotel() {
		this.city = 2L;
		this.name = "Seven Days Hotel";
		this.address = "BeiJing-DaXing";
		this.zip = "100010";
	}

	public Long getCity() {
		return city;
	}

	public Hotel setCity(Long city) {
		this.city = city;
		return this;
	}

	public String getName() {
		return name;
	}

	public Hotel setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Hotel setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public Hotel setZip(String zip) {
		this.zip = zip;
		return this;
	}

	@Override
	public String toString() {
		return getCity() + "," + getName() + "," + getAddress() + "," + getZip();
	}
}
