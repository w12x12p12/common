<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人基本信息</title>
</head>
<link rel="stylesheet" href="${ctx}/resources/js/common/jQueryValidate/css/validationEngine.jquery.css">
<script src="${ctx}/resources/js/common/jQueryValidate/js/jquery.validationEngine.js"></script>
<script src="${ctx}/resources/js/common/jQueryValidate/js/jquery.validationEngine-zh_CN.js"></script> 
<body>
    <script type="text/javascript">
    $(function(){
    	$("#editForm").validationEngine({
          	submitHandler:function(form){
          		editSubmit();
         	}
      	});  
        var submit = true;
        $("#edit_submit").click(function(){
        	if(!$("form#editForm").validationEngine("validate")) return ;  
    		if(submit){
    			$.ajax({
    				url: ctx + "/admin/employee/editPersonal",
    				type: "POST",
    				async: true,
    				data: $("#editForm").serialize(),
    				beforeSend: function(){
    					submit = false;
               		},
               		success: function(data){
               			if(data == "000000"){
               				layer.msg("修改成功", {time:1000}, function(){
               					window.location.href = ctx + "/admin/employee/personal";
            				});
               			}
               		},
               		error: function(){
               			layer.msg("暂时无法提交",{time:1000});
               			submit = true;
               		}
    			});
    		}else{
    			layer.msg("正在保存,请您耐心等待",{time:1000});
    			return false;					
    		}
    	});
      });  
</script>
	<form id="editForm" role="form">
		<input type="hidden" name="employeeId" id="employeeId"
			readonly="readonly" value="${employeeId}" />
		<%-- <div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>用户名</label>
			<div class="col-sm-10">
				<input type="text" readonly="readonly" name="username" id="username"
					value="${employeePo.username }"
					class="form-control form-control_readonly">
			</div>
		</div> --%>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>姓名</label>
			<div class="col-sm-10">
				<input type="text" name="employeeName"
					id="employeeName" value="${employeePo.employeeName }" placeholder="请输入姓名"
					class="form-control form-control_readonly">
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>性别</label>
			<div class="col-sm-10">
				<label
					class="w_honghr_radio_label <c:if test="${employeePo.gender.equals('1')}">active</c:if>"
					for="man"><input type="radio"
					class="gender" name="gender" value="1"
					<c:if test="${employeePo.gender.equals('1')}">checked="checked"</c:if>>男</label>
				<label
					class="w_honghr_radio_label <c:if test="${employeePo.gender.equals('0')}">active</c:if>"
					for="woman"><input type="radio"
					class="gender" name="gender" value="0"
					<c:if test="${employeePo.gender.equals('0')}">checked="checked"</c:if>>女</label>
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>出生日期</label>
			<div class="col-sm-10">
				<input class="form-control w_date_input" name="birthday" type="text"
					placeholder="请选择出生日期" maxlength="100"
					onFocus="WdatePicker({onpicked:function(){endDate.focus();},maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',isShowClear:false})"
					readonly="readonly"
					value="<fmt:formatDate type="both" value="${employeePo.birthday}" pattern="yyyy-MM-dd"/>" />
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label for="disabledSelect" class="col-sm-2 control-label"><b
				class="z_common_star"></b>身份证号</label>
			<div class="col-sm-10">
				<input class="form-control validate[custom[idCard]]" name="idcard"
					value="${employeePo.idcard}" type="text" placeholder="请输入身份证号"
					maxlength="100"></input>
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>籍贯</label>
			<div class="col-sm-10">
				<input
					class="form-control form-control_readonly"
					type="text" name="nation" placeholder="请输入籍贯"
					value="${employeePo.nation }" />
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>通讯地址</label>
			<div class="col-sm-10">
				<input
					class="form-control form-control_readonly"
					type="text" name="address" placeholder="请输入通讯地址"
					value="${employeePo.address }" />
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>联系电话</label>
			<div class="col-sm-10">
				<input
					class="form-control form-control_readonly validate[custom[mobilephone,required]]"
					type="text" readonly="readonly" name="phoneNumber" placeholder="请输入联系电话"
					value="${employeePo.phoneNumber }" />
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>邮箱</label>
			<div class="col-sm-10">
				<input
					class="form-control form-control_readonly validate[custom[email]]"
					type="text" name="email" placeholder="请输入邮箱"
					value="${employeePo.email }" />
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>学历</label>
			<div class="col-sm-10">
				<select name="education"
					class="form-control input-sm w_overtime_type" id="select_k1"
					class="xla_k">
					<c:if test="${employeePo.education=='4' }">
						<option value="4">大专</option>
					</c:if>
					<c:if test="${employeePo.education=='5' }">
						<option value="5">本科</option>
					</c:if>
					<c:if test="${employeePo.education=='6' }">
						<option value="6">硕士</option>
					</c:if>
					<c:if test="${employeePo.education=='7' }">
						<option value="7">博士</option>
					</c:if>
					<c:if test="${employeePo.education=='8' }">
						<option value="8">博士后</option>
					</c:if>
					<c:if test="${empty employeePo.education}">
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
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label"><b
				class="z_common_star"></b>入职日期</label>
			<div class="col-sm-10">
				<input type="text" readonly="readonly" name="entryTime"
					id="entryTime"
					value="<fmt:formatDate type="both" value="${employeePo.entryTime}" pattern="yyyy-MM-dd"/>"
					class="form-control form-control_readonly">
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label "><b
				class="z_common_star"></b>参加工作时间</label>
			<div class="col-sm-10">
				<input type="text" readonly="readonly" name="workBeginTime"
					id="workBeginTime"
					value="<fmt:formatDate type="both" value="${employeePo.workBeginTime}" pattern="yyyy-MM-dd"/>"
					class="form-control form-control_readonly">
			</div>
		</div>
		<div class="form-group w_honghr_input">
			<label class="col-sm-2 control-label "><b
				class="z_common_star">*</b>个人信息修改说明</label>
			<div class="col-sm-10 w_honghr_tips">
				<p>1.各位登录后自行校对(更改)个人身份信息</p>
				<p>2.登录用户名为手机号码,若发现手机号码有误,请及时联系人力行政中心加以更改</p>
				<p>3.若参加工作时间及入职时间信息有误,请及时联系人力行政中心加以更改</p>
				<p>4.登录初始密码为(888888),请各位自行在修改密码项自行更改</p>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary save_form"
				id="edit_submit" onclick="editSubmit()">修改</button>
			<a type="button" href="${ctx}/admin/employee/personal"
				class="btn btn-default save_form" id="save_default">取消</a>
		</div>
	</form>
	<script>
//时间控件
$("#date01").jeDate({
    isinitVal:false,
    //festival:true,
    ishmsVal:false,
    minDate: '1920-01-01',
    maxDate: $.nowDate({DD:0}),
    format:"YYYY-MM-DD",
    zIndex:3000
}) 
//性别单选
$('.w_honghr_radio_label').click(function(){
    $(this).addClass('active').siblings().removeClass('active');
    $(this).siblings().find(".gender").removeAttr("checked");
    $(this).find(".gender").attr("checked",true);
    $(this).find('input').click();
})
</script>
</body>
</html>