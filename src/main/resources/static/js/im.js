$(document).ready(function() {
});

/**
 * 
 * @param msg
 *            the message
 * @type the box class
 * 
 */
function appendMessage(msg, type, id) {
	var message = nodeInstance(msg);
	$(message).appendTo(type);
	var div = document.getElementById(id);
	var box = document.getElementById(id + "-box");
	box.scrollTop = div.scrollHeight;
}

function nodeInstance(msg) {
	return "<div class='row'><div class='col-1'>\
        <img src='/imgs/qq-a.png' alt='QQ' class='rounded-circle avatar'>\
        </div>\
        <div class='col-11'>\
        <div>\
        <span class='badge badge-light'>"
			+ msg.from
			+ "</span>\
        </div>\
        <div class='im-message'>\
        <p>"
			+ msg.content
			+ "</p>\
        </div>\
        </div>\
        </div>\
        ";
}

window.onload = function() {
	var header = {
		login : 'admin',
		passcode : 'admin'
	};
	// init(header);
}

function init(header) {
	var url = "ws://localhost:61614/stomp";
	var client = Stomp.client(url);
	client.heartbeat.outgoing = 20000;
	client.heartbeat.incoming = 0;
	client.connect(header, function() {
		var subId = client.subscribe('sample.quequ.jstest', function(message) {
			if (message.body) {
				appendMessage(message.body, ".im-body-center-inner", "p2p");
			} else
				console.log('收到空消息');
		});
	}, function() {
		console.log("网络错误，无法链接到服务器");
	});
}

/**
 * 
 * @param username
 * @param nick
 * @returns
 */
function Person(username, nick) {
	this.username = username;
	this.nick = nick
}

/**
 * @example username=xxxx&nick=yyyy;
 * @param person
 * @returns
 */
function setCookie(person) {
	document.cookie = "username=" + escape(person.username) + "&nick="
			+ escape(person.nick);
}

function getCookie(alias) {
	if (document.cookie.length > 0) {
		var start = document.cookie.indexOf(alias + "=");
		if (start != -1) {
			start = start + alias.length + 1;
			end = document.cookie.indexOf("&", start);
			if (end != -1)
				end = document.cookie.length;
			return unescape(document.cookie.substring(start, end))
		}
	}
	return null;
}

function checkCookie() {
	var username = getCookie('username');
	if (username != null && username != "")
		alert('Welcome again ' + username + '!')
	else {
		username = prompt('Please enter your name:', "")
		if (username != null && username != "") {
			setCookie(new Person('yj1771','杨浚凯'))
		}
	}

}
