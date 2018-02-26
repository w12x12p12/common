$(function(){
	$("#save_submit").click(function(){
		var password = $("#password").val();
		var newPassword = $("#newPassword").val();
		var rePassword = $("#rePassword").val();
		if(!password){
			layer.msg("请输入原密码",{time:1500});
			return false;
		}
		if(!newPassword){
			layer.msg("请输入新密码",{time:1500});
			return false;
		}
		if(!rePassword){
			layer.msg("请输入新密码确认",{time:1500});
			return false;
		}
		$.ajax({
			url: ctx + "/admin/login/editPassword",
			type: "POST",
			async: true,
			data: {
				"newPassword":rePassword
			},
			success:function(result){
				if(result=="000000"){
					layer.msg("保存成功", {time:1500}, function(){
						window.parent.location.href = ctx + "/login.jsp";
					});
				}
			},
			error: function(){
				layer.msg("暂时无法修改密码",{time:1500});
			}
		});
	});
});
function validatePassword(){
	var newPassword = $("#newPassword").val();
	var rePassword = $("#rePassword").val();
	if(newPassword && rePassword && newPassword != rePassword){
		layer.confirm("两次密码不一致", {btn: ["确定"],closeBtn: 0},function(){
			layer.closeAll();
			$("#newPassword").val("");
			$("#rePassword").val("");
		});
	}
}
function validateOldPassword(oldPassword){
	var flag = false;
	$.ajax({
		url: ctx + "/admin/employee/validateOldPassword",
		type: "GET",
		async: false,
		data: {
			"oldPassword":oldPassword
		},
		success:function(result){
			if(result=="000000"){
				flag = true;
			}
		},
		error: function(){
			layer.msg("暂时无法验证原密码",{time:1500});
		}
	});
	return flag;
}
function showValidateResult(obj){
	var oldPassword = $(obj).val();
	if(oldPassword && !validateOldPassword(oldPassword)){
		layer.confirm("原密码不正确", {btn: ["确定"],closeBtn: 0},function(){
			layer.closeAll();
			$(obj).val("");
		});
	}
}