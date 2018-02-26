<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script src="${ctx }/resources/js/admin/applyPermission/applyPermission.js"></script>

	<form class="form-horizontal" role="form" id="editForm">
		<button style="margin-top: 10px;" type="button" class="btn btn-default  btn-sm" onclick="history.go(-1);">
		  <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>返回上一页
		</button>
		<input name="applyPermissionId" type="hidden" value="${applyPermission.applyPermissionId}"></input>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>employeeId</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="employeeId" value="${applyPermission.employeeId}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>departmentId</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="departmentId" value="${applyPermission.departmentId}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>checkPermission</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="checkPermission" value="${applyPermission.checkPermission}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>checkLevel</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="checkLevel" value="${applyPermission.checkLevel}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>deleted</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="deleted" value="${applyPermission.deleted}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
	</form>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="save_btn">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
	</div>
