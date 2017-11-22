<!DOCTYPE html>
<html>
<head>
<title>Talk</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/js/stomp.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/js/im.js" charset="utf-8"></script>
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
									<input type="text" class="form-control form-control-sm"
										placeholder="identify number">
								</div>
							</div>
							<div class="form-group row">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon form-control-sm">
										<i class="fa fa-user-circle"></i>
									</div>
									<input type="text" class="form-control form-control-sm"
										placeholder="NockName">
								</div>
							</div>
							<button type="button" id="subme" class="btn btn-sm cus-button">Register</button>
						</form>
					</div>

					<div class="card-body">
						<form>
							<div class="form-group row">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon form-control-sm">
										<i class="fa fa-wechat"></i>
									</div>
									<select class="form-control form-control-sm">
										<option value="ctg001">Chat Group</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="exampleFormControlTextarea1">Message</label>
								<textarea class="form-control" id="exampleFormControlTextarea1" rows="6"></textarea>
							</div>
							<button type="button" id="subme" class="btn btn-sm cus-button">Send</button>
						</form>
					</div>

				</div>
			</div>
			<div class="col-sm-5 im-body-center" id="p2p-box">
				<div class="im-body-center-inner" id="p2p">
					<div class="row">
						<div class="col-1">
							<img src="/imgs/qq-a.png" alt="QQ" class="rounded-circle avatar">
						</div>
						<div class="col-11">
							<div class="im-message">
								<p>This is a success alert—chfasdfasdfasdeck it out!</p>
							</div>
						</div>
					</div>
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
	</div>
</body>
</html>