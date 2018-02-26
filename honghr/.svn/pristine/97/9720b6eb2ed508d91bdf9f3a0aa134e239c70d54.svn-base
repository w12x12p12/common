<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script src="${ctx }/resources/js/admin/businessTripApplyCheck/businessTripApplyCheck.js"></script>

	<form class="form-horizontal" role="form" id="editForm">
		<button style="margin-top: 10px;" type="button" class="btn btn-default  btn-sm" onclick="history.go(-1);">
		  <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>返回上一页
		</button>
		<input name="businessTripApplyCheckId" type="hidden" value="${businessTripApplyCheck.businessTripApplyCheckId}"></input>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>businessTripApplyId</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="businessTripApplyId" value="${businessTripApplyCheck.businessTripApplyId}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>checkEmployeeId</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="checkEmployeeId" value="${businessTripApplyCheck.checkEmployeeId}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyIsAllowed</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyIsAllowed" value="${businessTripApplyCheck.applyIsAllowed}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>applyCheckSuggest</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="applyCheckSuggest" value="${businessTripApplyCheck.applyCheckSuggest}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>deleted</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="deleted" value="${businessTripApplyCheck.deleted}" type="text" placeholder="请输入100字以内字符" maxlength="100"></input>
			</div>
		</div>
	</form>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="save_btn">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
	</div>
