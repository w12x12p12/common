<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script src="${ctx }/resources/js/admin/overtimeWorkApply/overtimeWorkApply.js"></script>

	<form class="form-horizontal" role="form" id="editForm">
		<button style="margin-top: 10px;" type="button" class="btn btn-default  btn-sm" onclick="history.go(-1);">
		  <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>返回上一页
		</button>
		<input name="overtimeWorkApplyId" type="hidden" value="${overtimeWorkApply.overtimeWorkApplyId}"></input>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>overtimeWorkApplyNum</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="overtimeWorkApplyNum" value="${overtimeWorkApply.overtimeWorkApplyNum}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>employeeId</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="employeeId" value="${overtimeWorkApply.employeeId}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyType</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyType" value="${overtimeWorkApply.applyType}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyReason</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyReason" value="${overtimeWorkApply.applyReason}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyWorkContent</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyWorkContent" value="${overtimeWorkApply.applyWorkContent}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyDuration</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyDuration" value="${overtimeWorkApply.applyDuration}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyCheckStatus</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyCheckStatus" value="${overtimeWorkApply.applyCheckStatus}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyCheckProgress</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyCheckProgress" value="${overtimeWorkApply.applyCheckProgress}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>createEmployeeId</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="createEmployeeId" value="${overtimeWorkApply.createEmployeeId}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>deleted</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="deleted" value="${overtimeWorkApply.deleted}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
	</form>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="save_btn">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
	</div>
