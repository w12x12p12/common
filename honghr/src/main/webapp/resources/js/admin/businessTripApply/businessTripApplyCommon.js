$(function(){
	/* 根据省份查询市县 */
	$(".beginProvince,.endProvince").change(function(){
		var $self = $(this);
		var provinceId = $self.val();
		 $.ajax({
			url: ctx + "/admin/businessTripApply/getCitys",
			type: "GET",
			async: true,
			data: {
				"provinceId": provinceId
			},
			dataType: "JSON",
			success: function(cityList){
				var array = [];
				array.push("<option class='defaultChoice' value='-1'>请选择</option>");
				$(cityList).each(function(){
					array.push("<option class='defaultChoice' value='" + this.codeValue + "'>" + this.codeName + "</option>"); 
				});
				
				if($self.hasClass("beginProvince")){
					$(".w_edit_showBeginCity").html("");
					$(".w_edit_showBeginCity").html(array.join(""));
				}else{
					$(".w_edit_showEndCity").html("");
					$(".w_edit_showEndCity").html(array.join(""));
				} 
			},
			error: function(){
				layer.msg("暂时无法获取市县",{time:1500});
			}
		}); 
	});
	/* 点击添加审批人 */
	$(document).on("click", "#showEmployee", function(){
		$.ajax({
			url: ctx + "/admin/businessTripApply/showDepartmentList",
			type: "GET",
    		async: true,
    		dataType: "JSON",
    		success: function(departmentList){
    			var array = [];
    			if(departmentList){
					array.push("<option value='-1'>请选择</option>");
	    			$(departmentList).each(function(){
	    				array.push("<option value='" + this.departmentNum + "'>" + this.departmentName + "</option>")
	    			});
    			}
    			$(".showName").html("");
    			$(".showDepartment").html("");
    			$(".showName").append("<option value='-1'>请选择</option>");
    			$(".showDepartment").append(array.join(""));
    		},
    		error: function(){
				layer.msg("暂时无法获取部门",{time:1500});
    		}
		});
	});
	/* 选择审批人部门 */
	$(".showDepartment").change(function(){
		$.ajax({
			url: ctx + "/admin/businessTripApply/showCheckEmployeeList",
			type: "GET",
			async: true,
			data: {
				"departmentNum": $(this).val()
			},
			dataType: "JSON",
			success: function(employeeList){
				var array = [];
				if(employeeList){
					array.push("<option value='-1'>请选择</option>");
					$(employeeList).each(function(){
						array.push("<option value='" + this.employeeId + "'>" + this.employeeName + "</option>");
					});
				}
				$(".showName").html("");
				$(".showName").append(array.join(""));
			},
			error: function(){
				layer.msg("暂时无法获取审批人",{time:1500});
			}
		});
	});
	/* 保存审批人 */
	$("#save_checkEmployee").click(function(){
		var departmentNum = $(".showDepartment").val();
		var employeeId =  $(".showName").val();
		if(departmentNum!="-1" && employeeId!="-1"){
			var flag = true;
			$(".w_checkEmployee").each(function(){
				if($(this).attr("data") == employeeId){
					flag = false;
					return false;
				}
			});
			if(flag){
				$.ajax({
					url: ctx + "/admin/businessTripApply/getEmployeeById",
					type: "GET",
					async: true,
					data: {
						"employeeId": employeeId
					},
					dataType: "JSON",
					success: function(employee){
						var seq = 1;
						var $employee = $(".w_checkEmployee");
						if($employee.length > 0){
							$employee.each(function(){
								if(parseInt($(this).attr("seq")) > seq){
									seq = parseInt($(this).attr("seq"));
								}
							});
							seq++;
						}
						$("#showEmployee").before("<div class='w_honghr_check'><span class='w_checkEmployee' seq='" + seq + "' data='" + employee.employeeId + "'>" + seq + "." + employee.employeeName + "</span></div>");
						if($(".w_honghr_check").length == 4){
							$("#showEmployee").hide();
						}
						$("#myModal_add").modal("hide");
					},
					error: function(){
						layer.msg("暂时无法添加审批人",{time:1500});
					}
				});
			}else{
				layer.msg("已添加过该审批人",{time:1500});
			} 
		}else{
			layer.msg("请选择审批员工",{time:1500});
		}
	});
	/* 点击删除审批人 */
	$(document).on("click",".w_honghr_check",function(){
		var $checkEmployee = $(this).nextAll();
		if($checkEmployee){
			$checkEmployee.find(".w_checkEmployee").each(function(){
				var seq = parseInt($(this).attr("seq")) - 1;
				var sequenceName = $(this).text();
				var employeeName = sequenceName.substring(sequenceName.lastIndexOf("."));
				$(this).attr("seq",seq);
				$(this).text(seq + employeeName);
			});
		}
		$(this).remove();
		$("#showEmployee").show();
	});
});
/* 添加时长 */
function changeDuration(){
	var applyBeginTime = $("#startDate").val();
	var applyEndTime = $("#endDate").val();
	if(applyBeginTime && applyEndTime){
		var msec = (new Date(applyEndTime)).getTime() - (new Date(applyBeginTime)).getTime();
		var days = Math.floor(msec / (1000 * 60 * 60 * 24));
		var hours = (msec % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		var convertDay = hours == 0 ? 0 : hours >= 8 ? 1 : hours >= 4 ? 0.5 : 0;
		var time = days + convertDay;
		$(".w_edit_applyDuration").val(parseFloat(time) + "天");
	}
}
/* 表单验证 */
function validateForm(applyType, applyReason, applyBeginAddress, applyEndAddress, applyBeginTime, applyEndTime, $checkEmployee){
	if(!applyType){
		layer.msg("请选择出差类型",{time:1500});
		return false;
	}
	if(!applyReason){
		layer.msg("请填写出差事由",{time:1500});
		return false;
	}
	if(applyBeginAddress == "-1"){
		layer.msg("请选择出差始发地",{time:1500});
		return false;
	}
	if(applyEndAddress == "-1"){
		layer.msg("请选择出差目的地",{time:1500});
		return false;
	}
	if(!(applyBeginTime && applyEndTime)){
		layer.msg("请选择出差时间",{time:1500});
		return false;
	}
	if($checkEmployee.length == 0){
		layer.msg("请选择审批人",{time:1500});
		return false;
	}
	return true;
}