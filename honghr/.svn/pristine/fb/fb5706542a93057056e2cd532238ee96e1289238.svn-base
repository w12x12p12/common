<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath%>resources/js/admin/password/password.js"></script>
	<form method="post" id="editForm">
		<!-- <table class="d_home_settings_table">
			<tr>
				<td><br></td>
				<td><br></td>
			</tr>
			<tr>
				<td><br></td>
				<td><br></td>
			</tr>
			<tr>
				<td><span class="d_notNull">*</span>原密码：</td>
				<td><input type="password" id="password" class="form-control validate[required,ajax[ajaxPasswordCheck]]" onblur="showValidateResult(this);">
				</td>
			</tr>
			<tr>
				<td><span class="d_notNull">*</span>新密码：</td>
				<td><input type="password" id="newPassword" class="form-control validate[required,custom[onleNum]]" onblur="validatePassword();">
				</td>
			</tr>
			<tr>
				<td><span class="d_notNull">*</span>新密码确认：</td>
				<td><input type="password" id="rePassword" class="form-control validate[equals[Newpassword]]" onblur="validatePassword();">
				</td>
			</tr>
		</table> -->

	<div class="form-group  w_honghr_input">
		<label for="disabledSelect" class="col-sm-2 control-label"> <b
			class="z_common_star">*</b>原密码
		</label>
		<div class="col-sm-6">
			<input type="password" id="password"
				class="form-control validate[required,ajax[ajaxPasswordCheck]]"
				onblur="showValidateResult(this);" placeholder="请输入原密码"
				maxlength="100"></input>
		</div>
	</div>

	<div class="form-group  w_honghr_input">
		<label for="disabledSelect" class="col-sm-2 control-label"> <b
			class="z_common_star">*</b>新密码
		</label>
		<div class="col-sm-6">
			<input type="password" id="newPassword"
				class="form-control validate[required,custom[onleNum]]"
				onblur="validatePassword();" placeholder="请输入新密码"
				maxlength="100"></input>
		</div>
	</div>

	<div class="form-group w_honghr_input">
		<label for="disabledSelect" class="col-sm-2 control-label"> <b
			class="z_common_star">*</b>新密码确认
		</label>
		<div class="col-sm-6">
			<input type="password" id="rePassword"
				class="form-control validate[equals[Newpassword]]"
				onblur="validatePassword();" placeholder="请确认新密码"
				maxlength="100"></input>
		</div>
	</div>
</form>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="save_submit">保存</button>
		<button type="button" class="btn btn-default" onclick="back()" data-dismiss="modal">返回</button>
	</div>