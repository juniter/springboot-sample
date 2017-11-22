package com.juniter.sample.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

public class Message {
	private String date;
	/**
	 * 消息类型 1：p2p 2: p2group
	 */
	private int type;
	private String from;
	private String to;
	private String content;
	private String nick;
	
	public String getDate() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d',' yyyy h':'mm a'"));
	}

	public String getFrom() {
		return from;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Message setFrom(String from) {
		this.from = from;
		return this;
	}

	public String getTo() {
		return to;
	}

	public Message setTo(String to) {
		this.to = to;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Message setContent(String content) {
		this.content = content;
		return this;
	}

	public int getType() {
		return type;
	}

	public Message setType(int type) {
		this.type = type;
		return this;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
}
