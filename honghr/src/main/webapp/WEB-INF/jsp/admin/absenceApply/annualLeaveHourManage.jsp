<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>年假时长管理</title>
</head>
<body>
	<script type="text/javascript" src="${ctx}/resources/js/admin/absenceApply/annualLeaveHourManage.js"></script>
	<form class="form-inline" role="form">
		<div class="form-group btn-group-sm z_margin_tb">
			<label class="sr-only" for="name">查询条件</label> 
			<span class="show-lab label">员工姓名:</span> 
			<input type="text" class="form-control input-sm" name="employeeName" value="${employeeVo.employeeName}" placeholder="请输入员工姓名">
			<span class="show-lab label">所属部门:</span>
			<select name="departmentNum" class="form-control input-sm">
				<option value="default">请选择</option>
				<c:forEach items="${departmentList}" var="department">
					<option value="${department.departmentNum}" <c:if test="${department.departmentNum == employeeVo.departmentNum}">selected="selected"</c:if>>${department.departmentName}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary btn-search"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
		</div>
		<ul class="nav nav-list"> <li class="divider"></li></ul>
		<div class="table-responsive">
			<table class="table table-striped w_cee_table">
				<thead>
					<tr>
						<th>编号</th>
						<th>员工姓名</th>
						<th>所属部门</th>
						<th>联系方式</th>
						<th>参加工作时间</th>
						<th>入职时间</th>
						<th>今年累计年假时长</th>
						<th>今年剩余年假时长</th>
						<th>去年累计年假时长</th>
						<th>去年剩余年假时长</th>
						<th>剩余年假总时长</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entity" items="${page.dataList}" varStatus="status">
						<tr>
							<td>${status.index+1 +(page.currentPage-1)*page.pageSize}</td>
							<td>${entity.employeeName}</td>
							<td>${entity.departmentName}</td>
							<td>${entity.phoneNumber}</td>
							<td><fmt:formatDate type="both" value="${entity.workBeginTime}" pattern="yyyy年M月d日 " /></td>
							<td><fmt:formatDate type="both" value="${entity.entryTime}" pattern="yyyy年M月d日 " /></td>
							<td>${entity.annualLeaveHourTotalThisYear}<c:if test="${entity.annualLeaveHourTotalThisYear!=null && entity.annualLeaveHourTotalThisYear!=''}">小时</c:if></td>
							<td>${entity.remainingAnnualHourThisYear}<c:if test="${entity.remainingAnnualHourThisYear!=null && entity.remainingAnnualHourThisYear!=''}">小时</c:if></td>
							<td>${entity.annualLeaveHourTotalLastYear}<c:if test="${entity.annualLeaveHourTotalLastYear!=null && entity.annualLeaveHourTotalLastYear!=''}">小时</c:if></td>
							<td>${entity.remainingAnnualHourLastYear}<c:if test="${entity.remainingAnnualHourLastYear!=null && entity.remainingAnnualHourLastYear!=''}">小时</c:if></td>
							<td>${entity.remainingAnnualHour}<c:if test="${entity.remainingAnnualHour!=null && entity.remainingAnnualHour!=''}">小时</c:if></td>
							<td>
								<button type="button" class="btn btn-default btn-sm btn-danger absence_clear" data-name="${entity.employeeName}" data = "${entity.employeeId}">
								  <span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>清空
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 分页区域 -->
			<jsp:include page="/WEB-INF/jsp/common/page.jsp"></jsp:include>
		</div>
	</form>
</body>
</html>