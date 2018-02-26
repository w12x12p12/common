$(function(){
	var submit = true;
	/* 打开编辑休假单弹框 */
	$(".absence_edit").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/absenceApply/absenceApplyToEdit",
			type: "GET",
			async: false,
			data: {
				"absenceApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(resultMap){
				var array = [];
				var codeList = resultMap.codeList;
				var remainingDuration = resultMap.remainingDuration;
				var absenceApplyVo = resultMap.absenceApplyVo;
				var attachment = absenceApplyVo.attachment;
				var absenceApplyCheckVos = absenceApplyVo.absenceApplyCheckVos;
				$(".edit_absence_show").val("");
				$(".w_edit_absenceApplyId").val(absenceApplyVo.absenceApplyId);
				$(".w_edit_absenceApplyNum").val(absenceApplyVo.absenceApplyNum);
				$(".w_edit_applyEmployeeName").val(absenceApplyVo.applyEmployeeName);
				$(".w_edit_applyDepartmentName").val(absenceApplyVo.applyDepartmentName);
				$(".w_edit_applyReason").val(absenceApplyVo.applyReason);
				$(".w_edit_applyBeginTime").val(new Date(parseInt(absenceApplyVo.applyBeginTime)).toLocaleString('chinese',{hour12:false}).replace(/\//g,"-"));
				$(".w_edit_applyEndTime").val(new Date(parseInt(absenceApplyVo.applyEndTime)).toLocaleString('chinese',{hour12:false}).replace(/\//g,"-"));
				$(".w_edit_applyDuration").val(absenceApplyVo.applyDuration + "小时");
				$(".w_edit_applyDateTime").val(new Date(parseInt(absenceApplyVo.applyDateTime)).toLocaleDateString().replace(/\//g,"-"));
				$(".w_edit_applyCheckStatusShow").val(absenceApplyVo.applyCheckStatusShow);
				$(".w_edit_applyCheckStatus").val(absenceApplyVo.applyCheckStatus);
				$(codeList).each(function(){
					array.push("<label class='w_honghr_radio_label' title='" + this.codeName + "' >");
					if(this.codeValue == absenceApplyVo.applyType){
						array.push("<input type='radio' name='applyType' class='w_honghr_radio show_absence_applyType' value='" + this.codeValue + "' checked = 'checked' >" + this.codeName + "</input>");
					}else{
						array.push("<input type='radio' name='applyType' class='w_honghr_radio show_absence_applyType' value='" + this.codeValue + "' >" + this.codeName + "</input>");
					}
					array.push("</label>");
				});
				$(".w_absenece_type").html("");
				$(".w_absenece_type").html(array.join(""));
				if(remainingDuration && remainingDuration != "failure"){
					array = [];
					array.push("<div class='form-group show_remainingDuration'>");
					array.push("<label for='disabledSelect' class='col-sm-2 control-label'><b class='z_common_star'>*</b>剩余时长</label>");
					array.push("<div class='col-sm-10'>");
					array.push("<input type='text' class='form-control form-control_readonly' value='" + remainingDuration + "小时" + "' readonly='readonly' />");
					array.push("</div></div>");
					$(".show_remainingDuration").remove();
					$(".show_absence_applyType").parents(".form-group").after(array.join(""));
				}
				$("#picImg").attr("src",ctx + "/resources/img/noimage.png");
				if(attachment){
					$("#picImg").attr("src", ctx + attachment.attachmentUrl);
				}
				array = [];
				if(absenceApplyCheckVos){
					$(absenceApplyCheckVos).each(function(){
						array.push("<div class='w_honghr_check'><span class='w_checkEmployee' seq='" + this.applyCheckSequence + "' data='" + this.checkEmployeeId + "'>" + this.applyCheckSequence + "." + this.checkEmployeeName + "</span></div>");
					});
					if(absenceApplyCheckVos.length < 4){
						array.push("<button type='button' id='showEmployee' class='btn btn-default' data-toggle='modal' data-target='#myModal_add'>+添加</button>");
					}else{
						array.push("<button type='button' style='display:none;' id='showEmployee' class='btn btn-default' data-toggle='modal' data-target='#myModal_add'>+添加</button>");
					}
				}
				$(".w_edit_absenceApplyChecks").html("");
				$(".w_edit_absenceApplyChecks").html(array.join(""));
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
	$("#edit_absenceApplyForm").click(function(){
		var absenceType = $(".w_honghr_radio:checked").val();
		var applyReason = $(".w_edit_applyReason").val();
		var applyBeginTime = $("#startDate").val();
		var applyEndTime = $("#endDate").val();
		var $checkEmployee = $(".w_checkEmployee");
		if(validateForm(absenceType,applyReason,applyBeginTime,applyEndTime,$checkEmployee)){
			if(submit){
				$("#editForm .edit_checkEmployee").remove();
				$("#editForm .edit_checkSequence").remove();
				$checkEmployee.each(function(index){
					$("#editForm").append("<input type='hidden' name='absenceApplyChecks["+index+"].checkEmployeeId' class='edit_checkEmployee' value='" + $(this).attr("data") + "' />");
					$("#editForm").append("<input type='hidden' name='absenceApplyChecks["+index+"].applyCheckSequence' class='edit_checkSequence' value='" + $(this).attr("seq") + "' />");
				});
				$("#editForm .save_imageFile").remove();
				if($(".imageAttachment").attr("src")){
					$("#editForm").append("<input type='hidden' name='imageAttachment' value='" + $(".imageAttachment").attr("src") + "'/>");
				}
				$.ajax({
					url: ctx + "/admin/absenceApply/editForAbsenceApplyCheck",
					type: "POST",
					async: true,
					data: $("#editForm").serialize(),
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
	/* 编辑窗口打开触发 */
	$("#myModal_edit").on("shown.bs.modal",function(){
		$("#mainFrame", parent.document).height($(this).find(".modal-content").height()+50);
	});
	/* 编辑窗口关闭触发 */
	$("#myModal_edit").on("hidden.bs.modal",function(){
		$("#mainFrame", parent.document).height($("#mainFrame", parent.document).css("min-height"));
	});
	/* 提交审批 */
	$(".absence_submitCheck").click(function(){
		var $self = $(this);
		layer.confirm("确认提交审批吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/absenceApply/submitApplyCheck", 
				type: "POST",
				async: true,
				data: {
					"absenceApplyId":$self.attr("data")
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
	$(".absence_back").click(function(){
		var $self = $(this);
		layer.confirm("确认撤回吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/absenceApply/backApplyCheck",
				type: "POST",
				async: true,
				data: {
					"absenceApplyId":$self.attr("data")
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
	$(".absence_delete").click(function(){
		var $self = $(this);
		layer.confirm("确认删除吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/absenceApply/deleteAbsenceApply/" +  $self.attr("data"),
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