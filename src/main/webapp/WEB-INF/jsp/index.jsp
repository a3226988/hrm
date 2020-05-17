<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html class="app-ui">
<head>
	<!-- Meta -->
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<!-- Document title -->
	<title>人事管理系统</title>
	<!-- Favicons -->
	<link rel="icon" href="<%=request.getContextPath()%>/assets/img/favicons/favicon.ico" />
	<!-- AppUI CSS stylesheets -->
	<link rel="stylesheet" id="css-font-awesome" href="<%=request.getContextPath()%>/assets/css/font-awesome.css" />
	<link rel="stylesheet" id="css-ionicons" href="<%=request.getContextPath()%>/assets/css/ionicons.css" />
	<link rel="stylesheet" id="css-bootstrap" href="<%=request.getContextPath()%>/assets/css/bootstrap.css" />
	<link rel="stylesheet" id="css-app" href="<%=request.getContextPath()%>/assets/css/app.css" />
	<!-- End Stylesheets -->
</head>

<body class="app-ui layout-has-drawer layout-has-fixed-header">
<div class="app-layout-canvas">
	<div class="app-layout-container">
		<!-- Drawer -->
		<aside class="app-layout-drawer">

			<!-- Drawer scroll area -->
			<div class="app-layout-drawer-scroll">
				<!-- Drawer logo -->
				<div id="logo" class="drawer-header">
					<a href="index.html"><img class="img-responsive" src="<%=request.getContextPath()%>/assets/img/logo/logo-backend.png" title="AppUI" alt="AppUI" /></a>
				</div>

				<!-- Drawer navigation -->
				<nav class="drawer-main">
					<ul class="nav nav-drawer">

						<!-- <li class="nav-item nav-drawer-header">用户管理</li>

                        <li class="nav-item active">
                            <a href="index.html"><i class="ion-ios-speedometer-outline"></i> 查询用户</a>
                        </li>

                        <li class="nav-item">
                            <a href="frontend_home.html"><i class="ion-ios-monitor-outline"></i> 新增用户</a>
                        </li> -->

						<li class="nav-item nav-drawer-header">后台管理</li>

						<li class="nav-item nav-item-has-subnav">
							<a href="javascript:void(0)"><i class="ion-ios-calculator-outline"></i> 用户管理</a>
							<ul class="nav nav-subnav">
								<li>
									<a href="">查询用户</a>
								</li>
								<li>
									<a href="">新增用户</a>
								</li>
							</ul>
						</li>

						<li class="nav-item nav-item-has-subnav">
							<a href="javascript:void(0)"><i class="ion-ios-compose-outline"></i> 部门管理</a>
							<ul class="nav nav-subnav">
								<li>
									<a href="">查询部门</a>
								</li>
								<li>
									<a href="">新增部门</a>
								</li>
							</ul>
						</li>

						<li class="nav-item nav-item-has-subnav">
							<a href="javascript:void(0)"><i class="ion-ios-list-outline"></i> 职位管理</a>
							<ul class="nav nav-subnav">
								<li>
									<a href="">查询职位</a>
								</li>
								<li>
									<a href="">新增职位</a>
								</li>
							</ul>
						</li>
					</ul>
				</nav>
				<!-- End drawer navigation -->

			</div>
			<!-- End drawer scroll area -->
		</aside>
		<!-- End drawer -->

		<!-- Header -->
		<header class="app-layout-header">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar-collapse"
								aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<button class="pull-left hidden-lg hidden-md navbar-toggle" type="button" data-toggle="layout" data-action="sidebar_toggle">
							<span class="sr-only">Toggle drawer</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="header-navbar-collapse">
						<!-- .navbar-left -->
						<ul class="nav navbar-nav navbar-right navbar-toolbar hidden-sm hidden-xs">
							<li class="dropdown">
								<a href="javascript:void(0)" data-toggle="dropdown"><i class="ion-ios-bell"></i> <span class="badge">3</span></a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li class="dropdown-header">Profile</li>
									<li>
										<a tabindex="-1" href="javascript:void(0)"><span class="badge pull-right">3</span> News </a>
									</li>
									<li>
										<a tabindex="-1" href="javascript:void(0)"><span class="badge pull-right">1</span> Messages </a>
									</li>
									<li class="divider"></li>
									<li class="dropdown-header">More</li>
									<li>
										<a tabindex="-1" href="javascript:void(0)">Edit Profile..</a>
									</li>
								</ul>
							</li>
							<li class="dropdown dropdown-profile">
								<a href="javascript:void(0)" data-toggle="dropdown">
									<span class="m-r-sm">张三 <span class="caret"></span></span>
									<img class="img-avatar img-avatar-48" src="<%=request.getContextPath()%>/assets/img/avatars/avatar3.jpg" alt="User profile pic" />
								</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li>
										<a href="">个人信息</a>
									</li>
									<li>
										<a href="">修改密码</a>
									</li>
									<li>
										<a href="">退出</a>
									</li>
								</ul>
							</li>
						</ul>
						<!-- .navbar-right -->
					</div>
				</div>
				<!-- .container-fluid -->
			</nav>
			<!-- .navbar-default -->
		</header>
		<!-- End header -->
		<main class="app-layout-content">
			<!-- Page Content -->
			<div class="container-fluid p-y-md">
				<!-- <div class="card">
                    <div class="card-header">
                        <h4>Inline Form</h4>
                    </div>
                    <div class="card-block card-block-full">
                        <form class="form-inline" action="base_forms_elements.html" method="post" onsubmit="return false;">
                            <div class="form-group">
                                <label class="sr-only" for="example-if-email">Email</label>
                                <input class="form-control" type="email" id="example-if-email" name="example-if-email" placeholder="Enter email..." />
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="example-if-password" />Password</label>
                                <input class="form-control" type="password" id="example-if-password" name="example-if-password" placeholder="Enter Password.." />
                            </div>
                            <div class="form-group m-b-0">
                                <button class="btn btn-default" type="submit">Login</button>
                            </div>
                        </form>
                    </div>
                </div> -->
				<!-- Dynamic Table Full -->
				<div class="card">
					<div class="card-header">
						<h4>员工管理</h4>
					</div>
					<div class="card-block">
						<form action="" method="post">
							<div class="row">
								<div class="form-group col-md-2">
									<select class="form-control" id="serarchJob" name="jobId">
										<option value="">请选择职位</option>
									</select>
								</div>
								<div class="form-group col-md-2">
									<select class="form-control" id="serarchDept" name="deptId">
										<option value="">请选择部门</option>
									</select>
								</div>
								<div class="form-group col-md-2">
									<select class="form-control" id="serarchSex" name="sex">
										<option value="">请选择性别</option>
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</div>
								<div class="form-group col-md-2">
									<select class="form-control" id="serarchEducation" name="education">
										<option value="">请选择学历</option>
										<option value="1">本科</option>
										<option value="0">专科</option>
									</select>
								</div>
								<div class="form-group col-md-2">
									<input class="form-control" name="qqNum" placeholder="请输入QQ号" autocomplete="off" />
								</div>
								<div class="form-group col-md-2">
									<input class="form-control" name="address" placeholder="请输入地址" autocomplete="off" />
								</div>
								<!-- </div>
                                <div class="row"> -->
								<div class="form-group col-md-2">
									<input class="form-control" id="searchName" name="name" placeholder="请输入员工姓名" autocomplete="off" />
								</div>

								<div class="form-group col-md-2">
									<input class="form-control" id="searchCardId" name="cardId" placeholder="请输入身份证号" />
								</div>
								<div class="form-group col-md-2">
									<input class="form-control" id="searchPhoneNum" name="phoneNum" placeholder="请输入手机号" />
								</div>
								<div class="form-group col-md-6">
									<button class="btn btn-success" type="submit">搜索</button>
									<button class="btn btn-danger" type="button">删除选中行</button> <button class="btn btn-app-blue" type="button">导出选中行</button>
								</div>
							</div>
						</form>
						<table class="table table-bordered table-striped table-hover ">
							<thead>
							<tr>
								<th class="w-5">
									<label class="css-input css-checkbox css-checkbox-info">
										<input type="checkbox"><span></span>
									</label>
								</th>
								<th style="width: 6%;">序号</th>
								<th class="w-10">员工名称</th>
								<th class="hidden-xs" style="width: 13%">手机</th>
								<th class="hidden-md">身份证号</th>
								<th style="width: 6%;">性别</th>
								<th style="width: 8%;">部门</th>
								<th style="width: 8%;">职位</th>
								<th class="w-10">建档日期</th>
								<th class="text-center" style="width: 9%;">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${pageInfo.list}" varStatus="i" var="emp">
							<tr>
								<td><label class="css-input css-checkbox css-checkbox-info">
									<input type="checkbox"><span></span>
								</label></td>
								<td>${i.count}</td>
								<td>${emp.name}</td>
								<td>${emp.phone}</td>
								<td>${emp.cardid}</td>
								<%--<td><c:if test="${emp.sex == 1}">
									男
								</c:if>
									<c:if test="${emp.sex == 2}">
										女
									</c:if></td>--%>
								<td>${emp.sexStr}</td>
								<td>${emp.dept.name}</td>
								<td>${emp.job.name}</td>
								<td><fmt:formatDate value="${emp.createdate}"></fmt:formatDate></td>
								<td>
									<div class="btn-group">
										<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="查看详情"><i class="ion-eye"></i></button>
										<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="编辑信息"><i class="ion-edit"></i></button>
										<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="删除"><i class="ion-close"></i></button>
									</div>
								</td>
							</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="col-md-4" style="padding-top: 28px;">
								当前显示 <b>${pageInfo.startRow}</b>~<b>${pageInfo.endRow}</b>条数据，共<b>${pageInfo.total}</b>条
								当前第${pageInfo.pageNum}页，共${pageInfo.pages}页
							</div>
							<div class="col-md-8">
								<nav>
									<ul class="pagination">
										<li class="disabled">
											<a href="/employee/list?pageNum=${pageInfo.pageNum-1}"><i class="ion-chevron-left"></i></a>
										</li>
										<li class="active">
											<a href="javascript:void(0)">1</a>
										</li>
										<li>
											<a href="/employee/list?pageNum=2">2</a>
										</li>
										<li>
											<a href="/employee/list?pageNum=3">3</a>
										</li>
										<li>
											<a href="javascript:void(0)">4</a>
										</li>
										<li>
											<a href="javascript:void(0)">5</a>
										</li>
										<li>
											<a href="/employee/list?pageNum=${pageInfo.pageNum+1}"><i class="ion-chevron-right"></i></a>
										</li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
					<!-- .card-block -->
				</div>
				<!-- .card -->
				<!-- End Dynamic Table Full -->
			</div>
			<!-- .container-fluid -->
			<!-- End Page Content -->
		</main>
	</div>
	<!-- .app-layout-container -->
</div>
<!-- .app-layout-canvas -->
<!-- Apps Modal -->
<!-- Opens from the button in the header -->
<div class="app-ui-mask-modal"></div>
<!-- AppUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock and App.js -->
<script src="<%=request.getContextPath()%>/assets/js/core/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/core/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/core/jquery.slimscroll.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/core/jquery.scrollLock.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/core/jquery.placeholder.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/app.js"></script>

</body>

</html>
