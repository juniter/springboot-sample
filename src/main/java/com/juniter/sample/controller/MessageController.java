package com.juniter.sample.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juniter.sample.jms.MessageDispatcher;
import com.juniter.sample.model.Message;

@Controller
public class MessageController {
	@Autowired
	private MessageDispatcher dispathcer;
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public void send(@RequestBody Message message, HttpServletResponse response) {
		dispathcer.send(message);
	}
}
