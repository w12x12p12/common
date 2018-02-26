$(function(){
    var submit = true;
    $("#edit_submit").click(function(){
		var employeeId = $(".w_employee_name").val();
		if(employeeId == ""){
			layer.msg("请选择要分配的员工姓名",{time:1000});
			return false;
		}
		var departmentNum = $(".w_department_name").val();
		if(departmentNum == ""){
			layer.msg("请选择要分配的部门名称",{time:1000});
			return false;
		}
		var positionNum = $(".w_position_name").val();
		if(positionNum == ""){
			layer.msg("请选择要分配的职位名称",{time:1000});
			return false;
		}
		if(submit){
			$.ajax({
				url: ctx + "/admin/employeePosition/editForEmployeePostion",
				type: "POST",
				async: true,
				data: $("#editForm").serialize(),
				beforeSend: function(){
					submit = false;
           		},
           		success: function(data){
           			if(data == "000000"){
           				layer.msg("修改成功", {time:1000}, function(){
           					window.location.href = ctx + "/admin/employeePosition/employeePositionList";
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