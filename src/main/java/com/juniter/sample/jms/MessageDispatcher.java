package com.juniter.sample.jms;

import org.springframework.stereotype.Component;

import com.juniter.sample.conf.SampleConfigure;
import com.juniter.sample.model.Message;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

@Component
public class MessageDispatcher {

	public static final Map<String, Destination> pool = new HashMap<>();

	@Autowired
	private SampleConfigure sample;

	@Autowired
	private JmsTemplate template;

	public void send(Message msg) {
		Destination des = pool.get(msg.getTo());
		if (des == null) {
			String destinationStr = (msg.getTypeMsg() == 1 ? sample.getActivemq().getQueuePrefix()
					: sample.getActivemq().getTopicPrefix()) + msg.getTo();
			des = msg.getTypeMsg() == 1 ? new ActiveMQQueue(destinationStr) : new ActiveMQTopic(destinationStr);
			this.template.convertAndSend(des, msg.toJSON());
			pool.put(msg.getTo(), des);
		} else {
			this.template.convertAndSend(des, msg.toJSON());
		}
	}

}
