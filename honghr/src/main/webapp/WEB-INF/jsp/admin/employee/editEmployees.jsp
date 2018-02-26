<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${ctx}/resources/js/common/jQueryValidate/css/validationEngine.jquery.css">
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
<script src="${ctx}/resources/js/common/jQueryValidate/js/jquery.validationEngine.js"></script>
<script src="${ctx}/resources/js/common/jQueryValidate/js/jquery.validationEngine-zh_CN.js"></script> 
<script src="${ctx }/resources/js/admin/employee/employee.js"></script>
	<form role="form" id="editForm">
		<input name="employeeId" type="hidden" value="${employee.employeeId}"></input>
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>姓名</label>
			<div class="col-sm-10">
				<input class="form-control validate[required]"  name="employeeName" value="${employee.employeeName}" type="text" placeholder="请输入真实姓名" maxlength="10"></input>
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label "><b class="z_common_star"></b>性别</label>
			<div class="col-sm-10">
	             <label class="w_honghr_radio_label 
	             	<c:if test="${employee.gender.equals('1')}">active</c:if>" for="man">
	             		<input type="radio" class="gender" name="gender" value="1" 
	             	<c:if test="${employee.gender.equals('1')}">checked="checked"</c:if>>男
	             </label>
	             <label class="w_honghr_radio_label 
		             <c:if test="${employee.gender.equals('0')}">active</c:if>" for="woman">
		            	 <input type="radio" class="gender" name="gender" value="0" 
		             <c:if test="${employee.gender.equals('0')}">checked="checked"</c:if>>女
		         </label>
	   		</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>出生日期</label>
			<div class="col-sm-10">
				<input class="form-control w_date_input" name="birthday" 
					type="text" placeholder="请选择出生日期" maxlength="100"
					onFocus="WdatePicker({onpicked:function(){endDate.focus();},maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',isShowClear:false})"
					readonly="readonly"  value="<fmt:formatDate type="both" value="${employee.birthday}" pattern="yyyy-MM-dd"/>"/>
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star"></b>籍贯</label>
			<div class="col-sm-10">
				<input class="form-control"  name="nation" value="${employee.nation}" type="text" placeholder="请输入籍贯" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star"></b>通讯地址</label>
			<div class="col-sm-10">
				<input class="form-control"  name="address" value="${employee.address}" type="text" placeholder="请输入通讯地址" maxlength="100"></input>
			</div>
		</div>
		<c:if test="${!empty employee.employeeId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>手机号码</label>
			<div class="col-sm-10">
				<input  class="form-control validate[custom[mobilephone,required]]" name="phoneNumber" value="${employee.phoneNumber}" type="text" placeholder="请输入手机号码" maxlength="100"></input>
			</div>
		</div>
		</c:if>
		<c:if test="${empty employee.employeeId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star">*</b>手机号码</label>
			<div class="col-sm-10">
				<input class="form-control validate[custom[mobilephone,required]]"  name="phoneNumber" value="${employee.phoneNumber}" type="text" placeholder="请输入手机号码" maxlength="100"></input>
			</div>
		</div>
		</c:if>
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star"></b>邮箱</label>
			<div class="col-sm-10">
				<input class="form-control validate[custom[email]]"  name="email" value="${employee.email}" type="text" placeholder="请输入电子邮箱" maxlength="100"></input>
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star"></b>身份证号</label>
			<div class="col-sm-10">
				<input class="form-control validate[custom[idCard]]"  name="idcard" value="${employee.idcard}" type="text" placeholder="请输入身份证号" maxlength="100"></input>
			</div>
		</div>
	<c:if test="${empty employee.employeeId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star"></b>学历</label>
			<div class="col-sm-10 " >
				<select name="education" class="form-control input-sm w_overtime_type" id="select_k1" class="xla_k">
					<option>请选择学历</option>
					<option value="4">大专</option>
					<option value="5">本科</option>
					<option value="6">硕士</option>
					<option value="7">博士</option>
					<option value="8">博士后</option>
				</select>
			</div>
		</div>
	</c:if>
	<c:if test="${!empty employee.employeeId}">
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b class="z_common_star"></b>学历</label>
			<div class="col-sm-10">
				<select name="education" class="form-control input-sm w_overtime_type ">
					<c:if test="${employee.education eq '5'}">
						<option value="5">本科</option>
					</c:if>
					<c:if test="${employee.education eq '6'}">
						<option value="6">硕士</option>
					</c:if>
					<c:if test="${employee.education eq '7'}">
						<option value="7">博士</option>
					</c:if>
					<c:if test="${employee.education eq '8'}">
						<option value="8">博士后</option>
					</c:if>
					<c:if test="${empty employee.education}">
						<option value="">请选择学历</option>
					</c:if>
					<option value="4">大专</option>
					<option value="5">本科</option>
					<option value="6">硕士</option>
					<option value="7">博士</option>
					<option value="8">博士后</option>
				</select>
			</div>
		</div>
	</c:if>
	<div class="form-group w_honghr_input">
		<label class="col-sm-2 control-label"><b class="z_common_star">*</b>参加工作时间</label>
		<div class="col-sm-10">
			<input class="form-control w_date_input validate[required]" name="workBeginTime"
				type="text" placeholder="请选择参加工作时间" maxlength="100"
				onFocus="WdatePicker({onpicked:function(){endDate.focus();},maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',isShowClear:false})"
				readonly="readonly"
				value="<fmt:formatDate type="both" value="${employee.workBeginTime}" pattern="yyyy-MM-dd"/>"/>
			</div>
	    </div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b class="z_common_star">*</b>入职时间</label>
			<div class="col-sm-10">
				<input class="form-control w_date_input validate[required]" name="entryTime" 
				type="text" placeholder="请选择入职时间" maxlength="100" onFocus="WdatePicker({onpicked:function(){endDate.focus();},maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',isShowClear:false})" 
				readonly="readonly" value="<fmt:formatDate type="both" value="${employee.entryTime}" pattern="yyyy-MM-dd"/>"/>
			</div>
	    </div>
	</form>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="save_btn">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal" onclick="history.go(-1);">返回</button>
	</div>
<script>
//性别单选
$('.w_honghr_radio_label').click(function(){
    $(this).addClass('active').siblings().removeClass('active');
    $(this).siblings().find(".gender").removeAttr("checked");
    $(this).find(".gender").attr("checked",true);
    $(this).find('input').click();
})
</script>