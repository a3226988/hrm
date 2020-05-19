<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" id="css-bootstrap" href="assets/css/bootstrap.css" />
		<link rel="stylesheet" id="css-app" href="assets/css/app.css" />
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-xs-10">
					<div class="card js-wizard-simple">
						<!-- Step Tabs -->
						<ul class="nav nav-tabs nav-tabs-alt nav-justified">
							<li class="active">
								<a href="#simple-step1" data-toggle="tab">1. 基本信息</a>
							</li>
							<li>
								<a href="#simple-step2" data-toggle="tab">2. 企业信息</a>
							</li>
						</ul>
						<!-- End Step Tabs -->
						<!-- Form -->
						<form class="form-horizontal" action="base_forms_wizard.html" method="post">
							<!-- Steps Content -->
							<div class="card-block tab-content">
								<!-- Step 1 -->
								<div class="tab-pane fade in m-t-md m-b-lg active" id="simple-step1">
									<div class="col-xs-12">
										<div class="form-group">
											<div class="col-xs-2">
												<label for="name">姓名</label>
												<input class="form-control input-lg" id="name" name="name" placeholder="姓名" value="张三" autocomplete="off" />
											</div>
											<div class="col-xs-3">
												<label for="phone">手机</label>
												<input class="form-control input-lg" id="phone" name="phone" placeholder="手机" value="18798762376" />
											</div>
											<div class="col-xs-2">
												<label for="sex">性别</label>
												<input class="form-control input-lg" id="sex" name="sex" placeholder="性别" value="男" autocomplete="off" />
											</div>
											<div class="col-xs-2">
												<label for="birthday">生日</label>
												<input class="form-control input-lg" id="birthday" name="birthday"  value="1998-09-17" autocomplete="off" />
											</div>
											<div class="col-xs-3">
												<label for="tel">电话</label>
												<input class="form-control input-lg" id="tel" name="tel" placeholder="座机" value="0791-0923123" autocomplete="off" />
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<div class="form-group">
											<div class="col-xs-3">
												<label for="cardid">身份证</label>
												<input class="form-control input-lg" id="cardid" name="cardid" placeholder="身份证号" value="36023192312832812" autocomplete="off" />
											</div>
											<div class="col-xs-4">
												<label for="address">住址</label>
												<input class="form-control input-lg" id="address" name="address" placeholder="住址" value="江西南昌" />
											</div>
											<div class="col-xs-2">
												<label for="qqNum">QQ</label>
												<input class="form-control input-lg" id="qqNum" name="qqNum" placeholder="QQ号" value="287731921" autocomplete="off" />
											</div>
											<div class="col-xs-3">
												<label for="email">邮件地址</label>
												<input class="form-control input-lg" id="email" name="email" placeholder="邮件地址" value="a2312lkjl@163.com" autocomplete="off" />
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<div class="form-group">
											<div class="col-xs-3">
												<label for="education">学历</label>
												<input class="form-control input-lg" id="education" name="education" placeholder="学历" value="本科" autocomplete="off" />
											</div>
											<div class="col-xs-3">
												<label for="speciality">专业</label>
												<input class="form-control input-lg" id="speciality" name="speciality"  value="计算机科学与技术" />
											</div>
											<div class="col-xs-3">
												<label for="hobby">爱好</label>
												<input class="form-control input-lg" id="hobby" name="hobby" value="足球" autocomplete="off" />
											</div>
											<div class="col-xs-3">
												<label for="race">民族</label>
												<input class="form-control input-lg" id="race" name="race" value="汉" autocomplete="off" />
											</div>
										</div>
									</div>
								</div>
								<!-- End Step 1 -->

								<!-- Step 2 -->
								<div class="tab-pane fade m-t-md m-b-lg" id="simple-step2">
									<div class="col-xs-12">
										<div class="form-group">
											<div class="col-xs-3">
												<label for="postcode">工号</label>
												<input class="form-control input-lg" id="postcode" name="postcode" placeholder="员工号" value="20190202" autocomplete="off" />
											</div>
											<div class="col-xs-3">
												<label for="deptid">部门</label>
												<select class="form-control input-lg" id="deptid" name="deptid">
													<option>技术部</option>
													<option>财务部</option>
													<option>工程部</option>
												</select>
											</div>
											<div class="col-xs-3">
												<label for="jobid">职位</label>
												<select class="form-control input-lg" id="jobid" name="jobid">
													<option>工程师</option>
													<option>会计</option>
													<option>程序员</option>
												</select>
											</div>
											<div class="col-xs-3">
												<label for="createdate">入司时间</label>
												<input class="form-control input-lg" id="createdate" name="createdate" value="2011-09-18" autocomplete="off" />
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<label for="remark">备注</label>
										<textarea class="form-control input-lg" id="remark" name="remark" rows="10" ></textarea>
									</div>
								</div>
								<!-- End Step 2 -->

								
							</div>
							<!-- End Steps Content -->

							<!-- Steps Navigation -->
							<div class="card-block b-t">
								<div class="row">
									<div class="col-xs-6">
										<button class="wizard-prev btn btn-default" type="button">上一步</button>
									</div>
									<div class="col-xs-6 text-right">
										<button class="wizard-next btn btn-default" type="button">下一步</button>
										<button class="wizard-finish btn btn-app" type="submit"><i class="ion-checkmark m-r-xs"></i> 修改</button>
									</div>
								</div>
							</div>
							<!-- End Steps Navigation -->
						</form>
						<!-- End Form -->
					</div>
					<!-- .card -->
				</div>
			</div>
		</div>
		<!-- AppUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock and App.js -->
		<script src="assets/js/core/jquery.min.js"></script>
		<script src="assets/js/core/bootstrap.min.js"></script>
		<script src="assets/js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>
		<!-- Page JS Code -->
		<script src="assets/js/pages/base_forms_wizard.js"></script>
		
	</body>
</html>
