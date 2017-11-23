$(document).ready(function() {
	$('#register').click(function() {
		var identify = $('#identifyNumber').val();
		var tips = $('#messageTips');
		if (identify != null && identify != "") {
			var nick = $('#nickName').val();
			if (nick == null && nick == "")
				tips.html('请填写昵称');
			else {
				setCookie(new Person(identify, nick))
				remoteInit(identify);
				init({
					login : 'admin',
					passcode : 'admin'
				});
				tips.html('已连接到服务器，现在可以开始会话');
			}
		} else {
			tips.html('请填写标识码用以链接服务中心，标识码由字母和数字组成');
		}
		$('#messageModal').modal({
			show : true,
			keyboard : false
		})
	});

	$('#send').click(function() {
		var type = 0;
		var from = getCookie('username');
		var nick = getCookie('nick');
		var sto = $('#sendTo').val();
		var content = $('#msgarea').val();
		if (sto != null && sto != "") {
			if (sto == "ctg001")
				type = 2;
			else
				type = 1;
			send(from, sto, content, nick, type);
		} else {
			$('#messageTips').html('消息接收者不能为空');
			$('#messageModal').modal({
				show : true,
				keyboard : false
			})
		}
	});
});

function send(from, to, content, nick, type) {
	$.ajax({
		method:'POST',
		url:'/send',
		contentType: 'application/json;charset=utf-8',
		data:JSON.stringify({
			"typeMsg" : type,
			"from" : from,
			"to" : to,
			"content" : content,
			"nick" : nick,
			"date": new Date()
		})
	})
	
}

/**
 * 
 * @param msg
 *            the message
 * @type the box class
 * 
 */
function appendMessage(msg, type, id) {
	var message = nodeInstance(eval("("+msg+")"));
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
			+ msg.nick+"  "+msg.date
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
	checkCookie();
}

function init(header) {
	var url = "ws://localhost:61614/stomp";
	var client = Stomp.client(url);
	client.heartbeat.outgoing = 20000;
	client.heartbeat.incoming = 0;
	var user = getCookie('username');
	client.connect(header, function() {
		// personal
		var subId = client.subscribe('real.time.point'+user, function(message) {
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
	document.cookie = "";
	document.cookie = "username=" + escape(person.username) + "&nick="
			+ escape(person.nick) + "&";
}

function getCookie(alias) {
	if (document.cookie.length > 0) {
		var start = document.cookie.indexOf(alias + "=");
		if (start != -1) {
			start = start + alias.length + 1;
			end = document.cookie.indexOf("&", start);
			if (end != -1)
				return unescape(document.cookie.substring(start, end));
			else
				return null;
		}
	}
	return null;
}

function checkCookie() {
	var tips = $('#messageTips');
	var username = getCookie('username');
	if (username != null && username != "") {
		tips.html('欢迎回来~Mr. ' + username);
		remoteInit(username);
		init({
			login : 'admin',
			passcode : 'admin'
		});
	} else {
		tips.html('请填写标识码和昵称用以链接服务中心，标识码由字母和数字组成');
	}
	$('#messageModal').modal({
		show : true,
		keyboard : false
	})
}

function remoteInit(username) {
	$.get('/init', {
		identify : username
	}, function(data) {
		setUserList(eval(data));
	});
}

function setUserList(users) {
	var opts = "<option value='ctg001'>JavaChat</option>";
	for (i in users)
		opts += "<option value=" + users[i] + ">" + users[i] + "</option>";
	$(opts).appendTo($('#sendTo'));
}
