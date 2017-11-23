<!DOCTYPE html>
<html>
<head>
<title>Talk</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/css/im.css">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row im-header" style="height: 10%"></div>
		<div class="row im-body" style="height: 90%">
			<div class="col-sm-2 im-body-left">
				<div class="card text-right" style="width: 100%;">
					<div class="card-body">
						<form>
							<div class="form-group row">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon form-control-sm">
										<i class="fa fa-user-secret"></i>
									</div>
									<input id="identifyNumber" type="text" class="form-control form-control-sm"
										pattern="[0-9a-zA-z]" min=2 required placeholder="identify number">
								</div>
							</div>
							<div class="form-group row">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon form-control-sm">
										<i class="fa fa-user-circle"></i>
									</div>
									<input id="nickName" type="text"
										class="form-control form-control-sm" min=2 required placeholder="nick name">
								</div>
							</div>
							<button type="button" id="register" class="btn btn-sm cus-button">Register</button>
						</form>
					</div>

					<div class="card-body">
						<form>
							<div class="form-group row">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon form-control-sm">
										<i class="fa fa-wechat"></i>
									</div>
									<select class="form-control form-control-sm" id="sendTo">
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="msgarea">Message</label>
								<textarea class="form-control" id="msgarea"
									rows="6"></textarea>
							</div>
							<button type="button" id="send" class="btn btn-sm cus-button">Send</button>
						</form>
					</div>

				</div>
			</div>
			<div class="col-sm-5 im-body-center" id="p2p-box">
				<div class="im-body-center-inner" id="p2p">
				</div>
			</div>
			<div class="col-sm-5 im-body-right" id="p2g">
				<div class="row">
					<div class="col-1">
						<img src="/imgs/qq-a.png" alt="QQ" class="rounded-circle avatar">
					</div>
					<div class="col-11">
						<div>
							<span class="badge badge-light">赵雨航 13:32:32 PM</span>
						</div>
						<div class="im-message">
							<p>我去你在</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="messageModal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h6 class="modal-title" id="exampleModalLabel">MessageTips</h6>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" id="messageTips"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm cus-button" data-dismiss="modal"><i class ="fa fa-check"></i>OK</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/stomp.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/im.js" charset="utf-8"></script>
</body>
</html>