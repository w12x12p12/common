<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待审批列表</title>
</head>
<body>
	<script type="text/javascript" src="${ctx}/resources/js/admin/overtimeWorkApply/overtimeApplyForLook.js"></script>
	<script type="text/javascript" src="${ctx}/resources/js/admin/overtimeWorkApply/overtimeApplyForCheck.js"></script>
	<form class="form-inline" role="form">
		<div class="form-group btn-group-sm z_margin_tb">
			<label class="sr-only" for="name">查询条件</label> 
			<span class="show-lab label">加班人:</span> 
			<input type="text" class="form-control input-sm" name="applyEmployeeName" value="${overtimeWorkApplyVo.applyEmployeeName}" placeholder="请输入员工姓名">
			<span class="show-lab label">所属部门:</span>
			<select name="applyDepartmentNum" class="form-control input-sm">
				<option value="default">请选择</option>
				<c:forEach items="${departmentList}" var="department">
					<option value="${department.departmentNum}" <c:if test="${department.departmentNum == overtimeWorkApplyVo.applyDepartmentNum}">selected="selected"</c:if>>${department.departmentName}</option>
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
						<th>加班单编号</th>
						<th>加班人</th>
						<th>所属部门</th>
						<th>加班性质</th>
						<th>加班原因</th>
						<th>加班开始时间</th>
						<th>加班结束时间</th>
						<th>加班时长</th>
						<th>申请日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entity" items="${page.dataList}" varStatus="status">
						<tr>
							<td>${entity.overtimeWorkApplyNum}</td>
							<td>${entity.applyEmployeeName}</td>
							<td>${entity.applyDepartmentName}</td>
							<td>${entity.applyTypeShow}</td>
							<td style="max-width:85px;">${entity.applyReason}</td>
							<td><fmt:formatDate type="both" value="${entity.applyBeginTime}" pattern="yyyy年MM月dd日 HH:mm"/></td>
							<td><fmt:formatDate type="both" value="${entity.applyEndTime}" pattern="yyyy年MM月dd日 HH:mm"/></td>
							<td>${entity.applyDuration}<c:if test="${entity.applyDuration!=null && entity.applyDuration!=''}">小时</c:if></td>
							<td><fmt:formatDate type="both" value="${entity.applyDateTime}" pattern="yyyy年MM月dd日 "/></td>
							<td>
								<button type="button" class="btn btn-default btn-sm overtime_look" data="${entity.overtimeWorkApplyId}" data-toggle="modal" data-target="#myModal_look">
							  		<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>查看
								</button>
								<button type="button" class="btn btn-default btn-sm overtime_lookProgress" data="${entity.overtimeWorkApplyId}" data-toggle="modal" data-target="#myModal_look_progress">
							  		<span class="glyphicon glyphicon-file" aria-hidden="true"></span>审批记录
								</button>
								<button type="button" class="btn btn-default btn-sm overtime_agree" data="${entity.overtimeWorkApplyId}">
								    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>同意
								</button>
								<button type="button" class="btn btn-default btn-sm btn-danger overtime_disAgree" data="${entity.overtimeWorkApplyId}" data-toggle="modal" data-target="#myModal_suggest">
								    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>不同意
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
	<!-- 模态框审批意见（Modal） -->
	<div class="modal fade d_model_box" id="myModal_suggest" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-show">
		 	<div class="modal-content">
		 		<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
	                	&times;
	                </button>
	                <h4 class="modal-title w_overtime_title" id="myModalLabel">审批意见</h4>
	            </div>
	            <div class="modal-body">
	            	<form id="editForm" class="form-horizontal" role="form">
	            		<input type="hidden" class="w_edit_applySuggest suggest_overtimeApplyId">
					    <div class="form-group">
							<div class="col-sm-12">
								<textarea class="form-control w_show_textArea w_edit_applySuggest suggest_text"></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="edit_suggestForm">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>
	            </div>
		 	</div>
 		</div>
	</div>
	<!-- 模态框查看进度（Modal） -->
	<div class="modal fade d_model_box" id="myModal_look_progress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-show">
		 	<div class="modal-content">
		 		<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
	                	&times;
	                </button>
	                <h4 class="modal-title w_overtime_title" id="myModalLabel">审批记录</h4>
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
	<!-- 模态框查看（Modal） -->
	<div class="modal fade d_model_box" id="myModal_look" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-show">
		 	<div class="modal-content">
		 		<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
	                	&times;
	                </button>
	                <h4 class="modal-title w_overtime_title" id="myModalLabel">查看加班申请单</h4>
	            </div>
	            <div class="modal-body">
           			<div class="z_lcms_lookbox">
					    <table class="table table-bordered table-striped w_show_text" style="margin:0 auto">
					        <tr>
					            <td>加班单编号</td>
					            <td class="showOvertimeApply show_overtimeApplyNum"></td>
					        </tr>
					        <tr>
					            <td>加班人</td>
					            <td class="showOvertimeApply show_applyEmployeeName"></td>
					        </tr>
					        <tr>
					            <td>所属部门</td>
					            <td class="showOvertimeApply show_applyDepartmentName"></td>
					        </tr>
					        <tr>
					        	<td>加班性质</td>
					        	<td class="showOvertimeApply show_applyTypeShow"></td>
					        </tr>
    						    <tr>
					            <td>加班原因</td>
					            <td class="showOvertimeApply show_applyReason"></td>
					        </tr>
					        <tr>
					        	<td>加班开始时间</td>
					        	<td class="showOvertimeApply show_applyBeginTime"></td>
					        </tr>
					        <tr>
					        	<td>加班结束时间</td>
					        	<td class="showOvertimeApply show_applyEndTime"></td>
					        </tr>
					        <tr>
					        	<td>加班时长</td>
					        	<td class="showOvertimeApply show_applyDuration"></td>
					        </tr>
					        <tr>
					        	<td>申请日期</td>
					        	<td class="showOvertimeApply show_applyDateTime"></td>
					        </tr>
					        <tr>
					        	<td>加班单状态</td>
					        	<td class="showOvertimeApply show_applyCheckStatusShow"></td>
					        </tr>
					        <tr>
					        	<td>审批人流程</td>
					        	<td class="showOvertimeApply show_checkEmployeeName"></td>
					        </tr>
					    </table>
					</div>
	            </div>
		 	</div>
 		</div>
	</div>
</body>
</html>		