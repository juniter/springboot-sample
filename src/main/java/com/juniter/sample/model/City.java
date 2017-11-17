package com.juniter.sample.model;

import java.io.Serializable;

import com.google.gson.Gson;

public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String state;

	private String country;

	public Long getId() {
		return this.id;
	}

	public City setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public City setName(String name) {
		this.name = name;
		return this;
	}

	public String getState() {
		return this.state;
	}

	public City setState(String state) {
		this.state = state;
		return this;
	}

	public String getCountry() {
		return this.country;
	}

	public City setCountry(String country) {
		this.country = country;
		return this;
	}

	@Override
	public String toString() {
		return getId() + "," + getName() + "," + getState() + "," + getCountry();
	}
	
	public String toJSON() {
		return new Gson().toJson(this);
	}
}
