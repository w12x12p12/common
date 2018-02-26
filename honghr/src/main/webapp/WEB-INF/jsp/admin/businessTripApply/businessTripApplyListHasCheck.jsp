<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已审批列表</title>
</head>
<body>
	<script type="text/javascript" src="${ctx}/resources/js/admin/businessTripApply/businessTripApplyLook.js"></script>
	<form class="form-inline" role="form">
		<div class="form-group btn-group-sm z_margin_tb">
			<label class="sr-only" for="name">查询条件</label>
			<span class="show-lab label">出差人:</span> 
			<input type="text" class="form-control input-sm" name="applyEmployeeName" value="${businessTripApplyVo.applyEmployeeName}" placeholder="请输入员工姓名">
			<span class="show-lab label">所属部门:</span>
			<select name="applyDepartmentNum" class="form-control input-sm">
				<option value="default">请选择</option>
				<c:forEach items="${departmentList}" var="department">
					<option value="${department.departmentNum}" <c:if test="${department.departmentNum == businessTripApplyVo.applyDepartmentNum}">selected="selected"</c:if>>${department.departmentName}</option>
				</c:forEach>
			</select>
			<span class="show-lab label">申请日期:</span> 
			<input type="text" id="beginDate" class="Wdate form-control input-sm input-date" name="startTime" value="${param.startTime}" placeholder="请选择开始日期" onFocus="var lastDate=$dp.$('lastDate');WdatePicker({onpicked:function(){lastDate.focus();},maxDate:'#F{$dp.$D(\'lastDate\')}'})" readonly="readonly" style="background-color:#fff;">
			<span class="show-lab label">至</span>
			<input type="text" id="lastDate" class="Wdate form-control input-sm input-date" name="endTime" value="${param.endTime}" placeholder="请选择结束日期" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'beginDate\')}'})" readonly="readonly" style="background-color:#fff;"/> 
			<button type="submit" class="btn btn-primary btn-search"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button> 
		</div>
		<ul class="nav nav-list"> <li class="divider"></li> </ul>
		<div class="table-responsive">
			<table class="table table-striped w_cee_table">
				<thead>
					<tr>
						<th>出差单编号</th>
						<th>出差人</th>
						<th>所属部门</th>
						<th>出差类型</th>
						<th>出差事由</th>
						<th>出差始发地</th>
						<th>出差目的地</th>
						<th>出差开始时间</th>
						<th>出差结束时间</th>
						<th>出差时长</th>
						<th>申请日期</th>
						<th>审批人</th>
						<th>是否同意</th>
						<th>出差单状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entity" items="${page.dataList}" varStatus="status">
						<tr>
							<td style="max-width:80px;">${entity.businessTripApplyNum}</td>
							<td>${entity.applyEmployeeName}</td>
							<td>${entity.applyDepartmentName}</td>
							<td>${entity.applyTypeShow}</td>
							<td style="max-width:70px;">${entity.applyReason}</td>
							<td style="max-width:73.5px;">${entity.applyBeginProvinceName}${entity.applyBeginCityName}</td>
							<td style="max-width:73.5px;">${entity.applyEndProvinceName}${entity.applyEndCityName}</td>
							<td style="max-width:100px;"><fmt:formatDate type="both" value="${entity.applyBeginTime}" pattern="yyyy年M月d日 HH:mm" /></td>
							<td style="max-width:100px;"><fmt:formatDate type="both" value="${entity.applyEndTime}" pattern="yyyy年M月d日 HH:mm"/></td>
							<td>${entity.applyDuration}<c:if test="${entity.applyDuration!=null && entity.applyDuration!=''}">天</c:if></td>
							<td style="max-width:90px;"><fmt:formatDate type="both" value="${entity.applyDateTime}" pattern="yyyy年M月d日"/></td>
							<td>${entity.checkEmployeeName}</td>
							<td>
								<c:choose>
									<c:when test="${entity.applyIsAllowed == '0'}">否</c:when>
									<c:when test="${entity.applyIsAllowed == '1'}">是</c:when>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${entity.applyCheckStatus == '2'}">
										<span style="color:#0da903;">${entity.applyCheckStatusShow}</span>
									</c:when>
									<c:when test="${entity.applyCheckStatus == '3'}">
										<span style="color:red;">${entity.applyCheckStatusShow}</span>
									</c:when>
									<c:otherwise>
										${entity.applyCheckStatusShow}
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<button type="button" class="btn btn-default btn-sm business_look" data="${entity.businessTripApplyId}" data-toggle="modal" data-target="#myModal_look">
							  		<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>查看
								</button>
								<button type="button" class="btn btn-default btn-sm business_lookProgress" data="${entity.businessTripApplyId}" data-toggle="modal" data-target="#myModal_look_progress">
							  		<span class="glyphicon glyphicon-file" aria-hidden="true"></span>审批记录
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
	<!-- 模态框查看（Modal） -->
	<div class="modal fade d_model_box" id="myModal_look" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-show">
		 	<div class="modal-content">
		 		<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
	                	&times;
	                </button>
	                <h4 class="modal-title w_absence_title" id="myModalLabel">查看出差申请单</h4>
	            </div>
	            <div class="modal-body">
           			<div class="z_lcms_lookbox">
					    <table class="table table-bordered table-striped w_show_text" style="margin:0 auto">
					        <tr>
					            <td>出差单编号</td>
					            <td class="showBusinessTripApply show_businessTripApplyNum"></td>
					        </tr>
					        <tr>
					            <td>出差人</td>
					            <td class="showBusinessTripApply show_applyEmployeeName"></td>
					        </tr>
					        <tr>
					            <td>所属部门</td>
					            <td class="showBusinessTripApply show_applyDepartmentName"></td>
					        </tr>
					        <tr>
					        	<td>出差类型</td>
					        	<td class="showBusinessTripApply show_applyTypeShow"></td>
					        </tr>
					        <tr>
					            <td>出差事由</td>
					            <td class="showBusinessTripApply show_applyReason"></td>
					        </tr>
   						    <tr>
					            <td>出差始发地</td>
					            <td class="showBusinessTripApply show_applyBeginAddressName"></td>
					        </tr>
					        <tr>
					            <td>出差目的地</td>
					            <td class="showBusinessTripApply show_applyEndAddressName"></td>
					        </tr>
					        <tr>
					        	<td>出差开始时间</td>
					        	<td class="showBusinessTripApply show_applyBeginTime"></td>
					        </tr>
					        <tr>
					        	<td>出差结束时间</td>
					        	<td class="showBusinessTripApply show_applyEndTime"></td>
					        </tr>
					        <tr>
					        	<td>出差时长</td>
					        	<td class="showBusinessTripApply show_applyDuration"></td>
					        </tr>
					        <tr>
					        	<td>申请日期</td>
					        	<td class="showBusinessTripApply show_applyDateTime"></td>
					        </tr>
					        <tr>
					        	<td>出差单状态</td>
					        	<td class="showBusinessTripApply show_applyCheckStatusShow"></td>
					        </tr>
					        <tr>
					        	<td>审批人流程</td>
					        	<td class="showBusinessTripApply show_checkEmployeeName"></td>
					        </tr>
					    </table>
					</div>
	            </div>
		 	</div>
 		</div>
	</div>
	<!-- 模态框审批记录（Modal） -->
	<div class="modal fade d_model_box" id="myModal_look_progress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-show">
		 	<div class="modal-content">
		 		<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
	                	&times;
	                </button>
	                <h4 class="modal-title w_absence_title" id="myModalLabel">审批记录</h4>
	            </div>
	            <div class="modal-body">
           			<div class="z_lcms_lookbox">
					    <table class="table table-bordered table-striped w_show_progress" style="margin:0 auto">
					        <tr class="show_progress_title">
					            <td>审批人</td>
					            <td>审批状态</td>
					            <td>审批意见</td>
					            <td>审批时间</td>
					        </tr>
					    </table>
					</div>
	            </div>
		 	</div>
 		</div>
	</div>
</body>
</html>