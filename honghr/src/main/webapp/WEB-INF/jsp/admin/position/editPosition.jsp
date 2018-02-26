<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx }/resources/js/admin/position/position.js"></script>
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
	<input name="positionId" type="hidden" value="${position.positionId}"></input>
	<div class="form-group w_honghr_input">
		<label for="disabledSelect" class="col-sm-2 control-label"><b
			class="z_common_star">*</b>职务名称</label>
		<div class="col-sm-10">
			<input class="form-control validate[required]" name="positionName"
				value="${position.positionName}" type="text" placeholder="请输入职务名称"
				maxlength="100"></input>
		</div>
	</div>
	<!-- 编辑 -->
	<c:if test="${!empty position.positionId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star"></b>直属上级</label>
			<div class="col-sm-10" title="直属上级无法修改">
				<select name="positionParentId" disabled="disabled"
					class="form-control input-sm w_overtime_type" id="select_k1">
					<c:if test="${!empty positions.positionId}">
						<option value="${positions.positionId}">${positions.positionName}</option>
					</c:if>
					<c:if test="${empty positions.positionId}">
						<option value="">请选择直属上级(不选默认为顶级)</option>
						<c:forEach var="positions" items="${positionsList}">
							<option value="${positions.positionId}">${positions.positionName}</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
		</div>
	</c:if>
	<!-- 添加 -->
	<c:if test="${empty position.positionId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b
				class="z_common_star">*</b>直属上级</label>
			<div class="col-sm-10">
				<select name="positionParentId"
					class="form-control input-sm w_overtime_type" id="select_k1">
					<c:if test="${!empty positions.positionId}">
						<option value="${positions.positionId}">${positions.positionName}</option>
					</c:if>
					<c:if test="${empty positions.positionId}">
						<option value="">请选择直属上级(不选默认为顶级)</option>
						<c:forEach var="positions" items="${positionsList}">
							<option value="${positions.positionId}">${positions.positionName}</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
		</div>
	</c:if>
	<!-- 编辑 -->
	<c:if test="${!empty position.positionId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b
				class="z_common_star"></b>对应部门</label>
			<div class="col-sm-10" title="对应部门无法修改">
				<select name="departmentId" disabled="disabled"
					class="form-control input-sm w_overtime_type" id="select_k1"
					class="xla_k">
					<c:if test="${!empty department.departmentId}">
						<option value="${department.departmentId}">${department.departmentName}</option>
					</c:if>
					<c:if test="${empty department.departmentId}">
						<option value="">请选择对应部门</option>
					</c:if>
					<c:forEach var="departments" items="${departmentList}">
						<option value="${departments.departmentId}">${departments.departmentName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</c:if>
	<!-- 添加 -->
	<c:if test="${empty position.positionId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b
				class="z_common_star">*</b>对应部门</label>
			<div class="col-sm-10">
				<select name="departmentId"
					class="form-control input-sm w_overtime_type" id="select_k1"
					class="xla_k">
					<c:if test="${!empty department.departmentId}">
						<option value="${department.departmentId}">${department.departmentName}</option>
					</c:if>
					<c:if test="${empty department.departmentId}">
						<option value="">请选择对应部门(不选默认为公司级)</option>
					</c:if>
					<c:forEach var="departments" items="${departmentList}">
						<option value="${departments.departmentId}">${departments.departmentName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</c:if>
</form>
<div class="modal-footer">
	<button type="button" class="btn btn-primary" id="save_btn">保存</button>
	<button type="button" class="btn btn-default "
		onclick="history.go(-1);">返回</button>
</div>
