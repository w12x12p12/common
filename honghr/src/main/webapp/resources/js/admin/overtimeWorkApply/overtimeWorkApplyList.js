$(function(){
	var submit = true;
	/* 打开编辑加班单弹框 */
	$(".overtime_edit").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/overtimeWorkApply/toEditovertimeApply",
			type: "GET",
			async: false,
			data: {
				"overtimeWorkApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(resultMap){
				var codeList = resultMap.codeList;
				var overtimeWorkApplyVo = resultMap.overtimeWorkApplyVo;
				var overtimeWorkApplyCheckVos = overtimeWorkApplyVo.overtimeWorkApplyCheckVos;
				$(".edit_overtime_show").val("");
				$(".w_edit_overtimeWorkApplyId").val(overtimeWorkApplyVo.overtimeWorkApplyId);
				$(".w_edit_overtimeWorkApplyNum").val(overtimeWorkApplyVo.overtimeWorkApplyNum);
				$(".w_edit_applyEmployeeName").val(overtimeWorkApplyVo.applyEmployeeName);
				$(".w_edit_applyDepartmentName").val(overtimeWorkApplyVo.applyDepartmentName);
				$(".w_edit_applyBeginTime").val(new Date(parseInt(overtimeWorkApplyVo.applyBeginTime)).toLocaleString('chinese',{hour12:false}).replace(/\//g,"-"));
				$(".w_edit_applyEndTime").val(new Date(parseInt(overtimeWorkApplyVo.applyEndTime)).toLocaleString('chinese',{hour12:false}).replace(/\//g,"-"));
				$(".w_edit_applyReason").val(overtimeWorkApplyVo.applyReason);
				$(".w_edit_applyDuration").val(overtimeWorkApplyVo.applyDuration + "小时");
				$(".w_edit_applyDateTime").val(new Date(parseInt(overtimeWorkApplyVo.applyDateTime)).toLocaleDateString().replace(/\//g,"-"));
				$(".w_edit_applyCheckStatusShow").val(overtimeWorkApplyVo.applyCheckStatusShow);
				$(".w_edit_applyCheckStatus").val(overtimeWorkApplyVo.applyCheckStatus);
				var array = [];
				$(codeList).each(function(){
					array.push("<label class='w_honghr_radio_label' title='" + this.codeName + "'>");
					if(this.codeValue == overtimeWorkApplyVo.applyType){
						array.push("<input type='radio' name='applyType' class='w_honghr_radio show_overtime_applyType' value='" + this.codeValue + "' checked = 'checked' >"+ this.codeName + "</input>");
					}else{
						array.push("<input type='radio' name='applyType' class='w_honghr_radio show_overtime_applyType' value='" + this.codeValue + "' >"+ this.codeName + "</input>");
					}
					array.push("</label>");
				});
				$(".w_overtime_type").html("");
				$(".w_overtime_type").html(array.join(""));
				array = [];
				if(overtimeWorkApplyCheckVos){
					$(overtimeWorkApplyCheckVos).each(function(){
						array.push("<div class='w_honghr_check'><span class='w_checkEmployee' seq='" + this.applyCheckSequence + "' data='" + this.checkEmployeeId + "'>" + this.applyCheckSequence + "." + this.checkEmployeeName + "</span></div>");
					});
					if(overtimeWorkApplyCheckVos.length < 4){
						array.push("<button type='button' id='showEmployee' class='btn btn-default' data-toggle='modal' data-target='#myModal_add'>+添加</button>");
					}else{
						array.push("<button type='button' style='display:none;' id='showEmployee' class='btn btn-default' data-toggle='modal' data-target='#myModal_add'>+添加</button>");
					}
				}
				$(".w_edit_overtimeApplyChecks").html("");
				$(".w_edit_overtimeApplyChecks").html(array.join(""));
			},
			error: function(){
				layer.msg("暂时无法编辑",{time:1500});
				flag = false;
    		}
		});
		if(!flag){
			return false;
		}
	});
	/* 保存编辑 */
	$("#edit_overtimeApplyForm").click(function(){
		var overtimeType = $(".w_honghr_radio:checked").val();
		var applyReason = $(".w_edit_applyReason").val();
		var applyBeginTime = $("#startDate").val();
		var applyEndTime = $("#endDate").val();
		var $checkEmployee = $(".w_checkEmployee");
		if(validateForm(overtimeType,applyReason,applyBeginTime,applyEndTime,$checkEmployee)){
			if(submit){
			    $("#editcheckForm .edit_checkEmployee").remove();
				$("#editcheckForm .edit_checkSequence").remove();
				$checkEmployee.each(function(index){
					$("#editcheckForm").append("<input type='hidden' name='overtimeWorkApplyChecks["+index+"].checkEmployeeId' class='edit_checkEmployee' value='" + $(this).attr("data") + "' />");
					$("#editcheckForm").append("<input type='hidden' name='overtimeWorkApplyChecks["+index+"].applyCheckSequence' class='edit_checkSequence' value='" + $(this).attr("seq") + "' />");
				}); 
				$.ajax({
					url: ctx + "/admin/overtimeWorkApply/editForOvertimeApply",
					type: "POST",
					async: true,
					data: $("#editcheckForm").serialize(),
					beforeSend: function(){
						submit = false;
	           		},
	           		success: function(data){
	           			if(data == "000000"){
	           				layer.msg("保存成功", {time:1500}, function(){
	           					document.location.reload();
	        				});
	           			}
	           		},
	           		error: function(){
	           			layer.msg("暂时无法提交",{time:1500});
	           			submit = true;
	           		}
				});
			}else{
				layer.msg("正在保存,请您耐心等待",{time:1500});
				return false;					
			}
		}
	});
	/* 提交审批 */
	$(".overtime_submitCheck").click(function(){
		var $self = $(this);
		layer.confirm("确认提交加班申请吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/overtimeWorkApply/submitApplyCheck", 
				type: "POST",
				async: true,
				data: {
					"overtimeWorkApplyId":$self.attr("data")
				},
				success: function(data){
					if(data == "000000"){
						layer.msg("提交成功", {time:1500}, function(){
							document.location.reload();
    					});
					}
				},
				error: function(){
					layer.msg("暂时无法提交",{time:1500});
				}
			});
		},function(){});
	});
	/* 点击撤回 */
	$(".overtime_back").click(function(){
		var $self = $(this);
		layer.confirm("确认撤回吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/overtimeWorkApply/backApplyCheck",
				type: "POST",
				async: true,
				data: {
					"overtimeWorkApplyId":$self.attr("data")
				},
				success: function(data){
					if(data == "000000"){
						layer.msg("撤回成功", {time:1500}, function(){
							document.location.reload();
    					});
					}
				},
				error: function(){
					layer.msg("暂时无法撤回",{time:1500});
				}
			});
		},function(){});
	});
	/* 点击删除 */
	$(".overtime_delete").click(function(){
		var $self = $(this);
		layer.confirm("确认删除吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/overtimeWorkApply/deleteovertimeApply/" +  $self.attr("data"),
				type: "DELETE",
				async: true,
				success: function(data){
					if(data == "000000"){
						layer.msg("删除成功", {time:1500}, function(){
							document.location.reload();
    					});
					}
				},
				error: function(){
					layer.msg("暂时无法删除",{time:1500});
				}
			});
		},function(){});
	});
});