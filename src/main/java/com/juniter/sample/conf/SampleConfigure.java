package com.juniter.sample.conf;

import javax.validation.Valid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "sample")
@Validated
public class SampleConfigure {
	@Valid
	private final Activemq activemq = new Activemq();
	@Valid
	private final Juniter juniter = new Juniter();

	public Activemq getActivemq() {
		return activemq;
	}

	public Juniter getJuniter() {
		return juniter;
	}

	public static class Activemq {
		private String host;
		private Integer port;
		private Integer stompPort;
		private String user;
		private String passcode;
		private String topicPrefix;
		private String queuePrefix;

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		public Integer getStompPort() {
			return stompPort;
		}

		public void setStompPort(Integer stompPort) {
			this.stompPort = stompPort;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPasscode() {
			return passcode;
		}

		public void setPasscode(String passcode) {
			this.passcode = passcode;
		}

		public String getTopicPrefix() {
			return topicPrefix;
		}

		public void setTopicPrefix(String topicPrefix) {
			this.topicPrefix = topicPrefix;
		}

		public String getQueuePrefix() {
			return queuePrefix;
		}

		public void setQueuePrefix(String queuePrefix) {
			this.queuePrefix = queuePrefix;
		}
	}

	public static class Juniter {
		private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

}
