<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx }/resources/js/admin/department/department.js"></script>
<style>
.formError{
	position:absolute;
	top:46px !important;
	left:-106px !important;
}
.formError .formErrorArrow{
	margin-left:101px;
}
</style>
<form role="form" id="editForm">
	<input name="departmentId" type="hidden" value="${department.departmentId}"></input>
	<!-- 编辑 -->
	<c:if test="${!empty department.departmentId }">
		<div class="form-group w_honghr_input " >
			<label for="disabledSelect" class="col-sm-2 control-label"><b
				class="z_common_star"></b>直属部门</label>
			<div class="col-sm-10" title="直属部门无法修改">
				<select name="departmentParentId"
					class="form-control input-sm w_overtime_type" id="select_k1"
					class="xla_k" disabled="disabled">
					<option value="${departmentParent.departmentId}">${departmentParent.departmentName}</option>
				</select>
			</div>
	</c:if>
	<!-- 添加 -->
	<c:if test="${empty department.departmentId }">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b
				class="z_common_star">*</b>直属部门</label>
			<div class="col-sm-10">
				<select name="departmentParentId"
					class="form-control input-sm w_overtime_type" id="select_k1"
					class="xla_k">
					<option value="">请选择项目直属部门(不选默认为顶级)</option>
					<c:forEach var="department" items="${list}">
						<option value="${department.departmentId}">${department.departmentName}</option>
					</c:forEach>
				</select>
			</div>
	</c:if>
	</div>
	<div class="form-group w_honghr_input">
		<label for="disabledSelect" class="col-sm-2 control-label"><b
			class="z_common_star">*</b>部门名称</label>
		<div class="col-sm-10">
			<input class="form-control validate[required]" name="departmentName"
				value="${department.departmentName}" type="text"
				placeholder="请输入部门名称" maxlength="100"></input>
		</div>
	</div>
	<div class="form-group w_honghr_input">
		<label for="disabledSelect" class="col-sm-2 control-label"><b
			class="z_common_star"></b>部门简介</label>
		<div class="col-sm-10">
			<input class="form-control validate[required]"
				name="departmentIntroduction" type="text"
				value="${department.departmentIntroduction}" placeholder="请输入部门简介"
				maxlength="100"></input>
		</div>
	</div>
</form>
<div class="modal-footer">
	<button type="button" class="btn btn-primary" id="save_btn">保存</button>
	<button type="button" class="btn btn-default " onclick="history.go(-1);">返回</button>
</div>
