package com.juniter.sample.controller;

import java.io.IOException;

import javax.jms.Destination;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.juniter.sample.conf.SampleConfigure;
import com.juniter.sample.jms.MessageDispatcher;
import com.juniter.sample.model.Message;

@Controller
public class MessageController {
	@Autowired
	private MessageDispatcher dispathcer;
	@Autowired
	private SampleConfigure sample;

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public void send(@RequestBody Message message, HttpServletResponse response) {
		System.out.println(message.toJSON());
		if (message.valid())
			dispathcer.send(message);
	}

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public void init(@RequestParam(required = true) String identify, HttpServletResponse response) throws IOException {
		Destination destination = MessageDispatcher.pool.get(identify);
		if (destination == null) {
			String destinationStr = sample.getActivemq().getQueuePrefix() + identify;
			destination = new ActiveMQQueue(destinationStr);
			MessageDispatcher.pool.put(identify, destination);
		}
		response.getWriter().write(new Gson().toJson(MessageDispatcher.pool.keySet()));
	}
}
