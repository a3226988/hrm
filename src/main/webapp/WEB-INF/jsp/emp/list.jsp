<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" id="css-font-awesome" href="<%=request.getContextPath()%>/assets/css/font-awesome.css" />
		<link rel="stylesheet" id="css-ionicons" href="<%=request.getContextPath()%>/assets/css/ionicons.css" />
		<link rel="stylesheet" id="css-bootstrap" href="<%=request.getContextPath()%>/assets/css/bootstrap.css" />
		<link rel="stylesheet" id="css-app" href="<%=request.getContextPath()%>/assets/css/app.css" />
	</head>
	<body>
		<div class="card">
			<div class="card-block">
				<form action="/employee/list" method="post" id="searchForm">
					<input type="hidden" value="1" name="pageNum">
					<div class="row">
						<div class="form-group col-md-2">
							<select class="form-control" id="serarchJob" name="jobId">
								<option value="">请选择职位</option>
								<c:forEach items="${jobs}" var="job">
									<option <c:if test="${employee.jobId == job.id}">selected</c:if> value="${job.id}">${job.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-2">
							<select class="form-control" id="serarchDept" name="deptId">
								<option value="">请选择部门</option>
								<c:forEach items="${depts}" var="dept">
									<option <c:if test="${employee.deptId == dept.id}">selected</c:if> value="${dept.id}">${dept.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-2">
							<select class="form-control" id="serarchSex" name="sex">
								<option value="">请选择性别</option>
								<option <c:if test="${employee.sex == 1}">selected</c:if> value="1">男</option>
								<option <c:if test="${employee.sex == 0}">selected</c:if> value="0">女</option>
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
							<input class="form-control" name="qqNum" placeholder="请输入QQ号" autocomplete="off"/>
						</div>
						<div class="form-group col-md-2">
							<input class="form-control" name="address" placeholder="请输入地址" autocomplete="off"/>
						</div>
						<!-- </div>
                        <div class="row"> -->
						<div class="form-group col-md-2">
							<input class="form-control" id="searchName" name="name" placeholder="请输入员工姓名"
								   autocomplete="off" value="${employee.name}"/>
						</div>

						<div class="form-group col-md-2">
							<input class="form-control" id="searchCardId" name="cardId" placeholder="请输入身份证号"/>
						</div>
						<div class="form-group col-md-2">
							<input class="form-control" id="searchPhoneNum" name="phoneNum"
								   placeholder="请输入手机号"/>
						</div>
						<div class="form-group col-md-6">
							<button class="btn btn-success" type="submit">搜索</button>
							<button class="btn btn-danger" type="button" onclick="deletebatch()">删除选中行</button>
							<button class="btn btn-app-blue" type="button">导出选中行</button>
						</div>
					</div>
				</form>
				<form id="deletebatchform" action="/employee/batchdelete" method="post">
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
								<input type="checkbox" name="ids" value="${emp.id}"><span></span>
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
									<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip"
											title="查看详情"><i class="ion-eye"></i></button>
									<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip"
											title="编辑信息"><i class="ion-edit"></i></button>
									<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip"
											title="删除"><i class="ion-close"></i></button>
								</div>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</form>
				<div class="row">
					<div class="col-md-4" style="padding-top: 28px;">
						当前显示 <b>${pageInfo.startRow}</b>~<b>${pageInfo.endRow}</b>条数据，共<b>${pageInfo.total}</b>条
						当前第${pageInfo.pageNum}页，共${pageInfo.pages}页
					</div>
					<div class="col-md-8">
						<nav>
							<ul class="pagination">
								<li class="disabled prev">
								<%--<a href="/employee/list?pageNum=${pageInfo.pageNum-1}"><i
                                        class="ion-chevron-left"></i></a>--%>
								<a href="javascript:void(0)" onclick="page(${pageInfo.pageNum-1})" ><i	class="ion-chevron-left"></i></a>
							</li>
								<%--<c:forEach items="${pageInfo.navigatepageNums}" var="pnum">
                                    <c:if test="${pnum<5}">
                                        <li>
                                            <a href="/employee/list?pageNum=${pnum}">${pnum}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>--%>
								<c:forEach begin="1" end="${pageInfo.pageNum}" var="pnum">
									<li>
										<a href="/employee/list?pageNum=${pnum}">${pnum}</a>
									</li>
								</c:forEach>
								<c:forEach begin="${pageInfo.pageNum+1}" end="${pageInfo.pageNum+2<=pageInfo.pages?pageInfo.pageNum+2:pageInfo.pages}" var="pnum">
									<li>
										<a href="/employee/list?pageNum=${pnum}">${pnum}</a>
									</li>
								</c:forEach>

								<li class="next">
									<%--<a href="/employee/list?pageNum=${pageInfo.pageNum+1}"><i
											class="ion-chevron-right"></i></a>--%>
									<a href="javascript:void(0)" onclick="page(${pageInfo.pageNum+1})"><i	class="ion-chevron-right"></i></a>
								</li>

							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- .card-block -->
		</div>
		<!-- .card -->
		<script src="<%=request.getContextPath()%>/assets/js/core/jquery.min.js"></script>
		<script>

			function deletebatch(){
				//$("#deletebatchform").submit();
				console.log($("#deletebatchform").serializeArray())
				console.log($("#deletebatchform").serialize())
			}

			function detail(){
				location.target="main_panel";
				location.href = "detail.html";
			}
			function edit(){
				location.target="main_panel";
				location.href = "edit.html";
			}
		</script>
		<script>
			var currPage = '${pageInfo.pageNum}';
			var sumPage = '${pageInfo.pages}';
			$(".pagination li").removeClass("active");
			$(".pagination li").eq(currPage).addClass("active");
			if (currPage <= 1) {
				$(".pagination li:first").addClass("disabled");
			} else {
				$(".pagination li:first").removeClass("disabled");
			}
			if (currPage < sumPage) {
				$(".pagination li:last").removeClass("disabled");
			} else {
				$(".pagination li:last").addClass("disabled");
			}


			/*$(".pagination li.prev").click(function(){
				//获取表单，提交表单，并在表单内添加当前页面数的参数
				$("")
			});*/
			function page(pageNum){
				$("[name=pageNum]").val(pageNum);
				$("#searchForm").submit();
			}
		</script>
	</body>
</html>
