 $(function(){
    	var submit = true;
    	$(".save_form").click(function(){
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
					url: ctx + "/admin/employeePosition/addEmployeePositionData",
					type: "POST",
					async: true,
					data: $("#applyForm").serialize(),
					beforeSend: function(){
						submit = false;
	           		},
	           		success: function(data){
	           			if(data == "000000"){
	           				layer.msg("分配成功", {time:1000}, function(){
	           					$(".z_menu_li",window.parent.document).click().removeClass("z_active");
	           					$("#employeePositionList",parent.document).parents(".z_menu_li").click().addClass("z_active"); 
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
    