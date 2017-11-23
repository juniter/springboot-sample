package com.juniter.sample.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

public class Message {
	private String date;
	/**
	 * 消息类型 1：p2p 2: p2group
	 */
	private Integer typeMsg;
	private String from;
	private String to;
	private String content;
	private String nick;

	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d',' yyyy h':'mm a"));
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

	public Integer getTypeMsg() {
		return typeMsg;
	}

	public Message setTypeMsg(Integer typeMsg) {
		this.typeMsg = typeMsg;
		return this;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

	public boolean valid() {
		return this.typeMsg > 0 && this.from != this.to && this.to != null;
	}

}
