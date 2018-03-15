$(function(){
	var submit = true;
	/* 打开编辑休假单弹框 */
	$(".business_edit").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/businessTripApply/businessTripApplyToEdit",
			type: "GET",
			async: false,
			data: {
				"businessTripApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(resultMap){
				var array = [];
				var businessTripApplyVo = resultMap.businessTripApplyVo;
				var businessTripApplyCheckVos = businessTripApplyVo.businessTripApplyCheckVos;
				var applyTypeList = resultMap.applyTypeList;
				var provinceList = resultMap.provinceList;
				var beginCityList = resultMap.beginCityList;
				var endCityList = resultMap.endCityList;
				$(".edit_business_show").val("");
				$(".w_edit_businessTripApplyId").val(businessTripApplyVo.businessTripApplyId);
				$(".w_edit_businessTripApplyNum").val(businessTripApplyVo.businessTripApplyNum);
				$(".w_edit_applyEmployeeName").val(businessTripApplyVo.applyEmployeeName);
				$(".w_edit_applyDepartmentName").val(businessTripApplyVo.applyDepartmentName);
				$(".w_edit_applyReason").val(businessTripApplyVo.applyReason);
				$(".w_edit_applyBeginTime").val(new Date(parseInt(businessTripApplyVo.applyBeginTime)).toLocaleString('chinese',{hour12:false}).replace(/\//g,"-"));
				$(".w_edit_applyEndTime").val(new Date(parseInt(businessTripApplyVo.applyEndTime)).toLocaleString('chinese',{hour12:false}).replace(/\//g,"-"));
				$(".w_edit_applyDuration").val(businessTripApplyVo.applyDuration + "天");
				$(".w_edit_applyDateTime").val(new Date(parseInt(businessTripApplyVo.applyDateTime)).toLocaleDateString().replace(/\//g,"-"));
				$(".w_edit_applyCheckStatusShow").val(businessTripApplyVo.applyCheckStatusShow);
				$(applyTypeList).each(function(){
					array.push("<label class='w_honghr_radio_label' title='" + this.codeName + "' >");
					if(this.codeValue == businessTripApplyVo.applyType){
						array.push("<input type='radio' name='applyType' class='w_honghr_radio' value='" + this.codeValue + "' checked = 'checked' >" + this.codeName + "</input>");
					}else{
						array.push("<input type='radio' name='applyType' class='w_honghr_radio' value='" + this.codeValue + "' >" + this.codeName + "</input>");
					}
					array.push("</label>");
				});
				$(".w_business_type").html("");
				$(".w_business_type").html(array.join(""));
				$(".beginProvince").html("");
				$(".endProvince").html("");
				if(provinceList){
					array = [];
					array.push("<option class='defaultChoice' value='-1'>请选择</option>");
					$(provinceList).each(function(){
						if(this.codeId == businessTripApplyVo.applyBeginProvinceId){
							array.push("<option class='defaultChoice' value='" + this.codeId + "' selected = 'selected'>" + this.codeName + "</option>");
						}else{
							array.push("<option class='defaultChoice' value='" + this.codeId + "'>" + this.codeName + "</option>");
						}
					});
					$(".beginProvince").html(array.join(""));
					array = [];
					array.push("<option class='defaultChoice' value='-1'>请选择</option>");
					$(provinceList).each(function(){
						if(this.codeId == businessTripApplyVo.applyEndProvinceId){
							array.push("<option class='defaultChoice' value='" + this.codeId + "' selected = 'selected'>" + this.codeName + "</option>");
						}else{
							array.push("<option class='defaultChoice' value='" + this.codeId + "'>" + this.codeName + "</option>");
						}
					});
					$(".endProvince").html(array.join(""));
				}
				$(".w_edit_showBeginCity").html("");
				if(beginCityList){
					array = [];
					array.push("<option class='defaultChoice' value='-1'>请选择</option>");
					$(beginCityList).each(function(){
						if(this.codeValue == businessTripApplyVo.applyBeginAddress){
							array.push("<option class='defaultChoice' value='" + this.codeValue + "' selected = 'selected'>" + this.codeName + "</option>");
						}else{
							array.push("<option class='defaultChoice' value='" + this.codeValue + "'>" + this.codeName + "</option>");
						}
					});
					$(".w_edit_showBeginCity").html(array.join(""));
				}
				$(".w_edit_showEndCity").html("");
				if(endCityList){
					array = [];
					array.push("<option class='defaultChoice' value='-1'>请选择</option>");
					$(endCityList).each(function(){
						if(this.codeValue == businessTripApplyVo.applyEndAddress){
							array.push("<option class='defaultChoice' value='" + this.codeValue + "' selected = 'selected'>" + this.codeName + "</option>");
						}else{
							array.push("<option class='defaultChoice' value='" + this.codeValue + "'>" + this.codeName + "</option>");
						}
					});
					$(".w_edit_showEndCity").html(array.join(""));
				}
				array = [];
				if(businessTripApplyCheckVos){
					$(businessTripApplyCheckVos).each(function(){
						array.push("<div class='w_honghr_check'><span class='w_checkEmployee' seq='" + this.applyCheckSequence + "' data='" + this.checkEmployeeId + "'>" + this.applyCheckSequence + "." + this.checkEmployeeName + "</span></div>");
					});
					if(businessTripApplyCheckVos.length < 4){
						array.push("<button type='button' id='showEmployee' class='btn btn-default' data-toggle='modal' data-target='#myModal_add'>+添加</button>");
					}else{
						array.push("<button type='button' style='display:none;' id='showEmployee' class='btn btn-default' data-toggle='modal' data-target='#myModal_add'>+添加</button>");
					}
				}
				$(".w_edit_businessTripApplyChecks").html("");
				$(".w_edit_businessTripApplyChecks").html(array.join(""));
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
	$("#edit_businessTripApplyForm").click(function(){
		var applyType = $(".w_honghr_radio:checked").val();
		var applyReason = $(".w_edit_applyReason").val();
		var applyBeginAddress = $(".w_edit_showBeginCity").val();
		var applyEndAddress = $(".w_edit_showEndCity").val();
		var applyBeginTime = $("#startDate").val();
		var applyEndTime = $("#endDate").val();
		var $checkEmployee = $(".w_checkEmployee");
		if(validateForm(applyType, applyReason, applyBeginAddress, applyEndAddress, applyBeginTime, applyEndTime, $checkEmployee)){
			if(submit){
				$("#editForm .edit_checkEmployee").remove();
				$("#editForm .edit_checkSequence").remove();
				$checkEmployee.each(function(index){
					$("#editForm").append("<input type='hidden' name='businessTripApplyChecks["+index+"].checkEmployeeId' class='edit_checkEmployee' value='" + $(this).attr("data") + "' />");
					$("#editForm").append("<input type='hidden' name='businessTripApplyChecks["+index+"].applyCheckSequence' class='edit_checkSequence' value='" + $(this).attr("seq") + "' />");
				});
				$.ajax({
					url: ctx + "/admin/businessTripApply/editForBusinessTripApplyCheck",
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
	$(".business_submitCheck").click(function(){
		var $self = $(this);
		layer.confirm("确认提交审批吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/businessTripApply/submitApplyCheck", 
				type: "POST",
				async: true,
				data: {
					"businessTripApplyId":$self.attr("data")
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
	$(".business_back").click(function(){
		var $self = $(this);
		layer.confirm("确认撤回吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/businessTripApply/backApplyCheck",
				type: "POST",
				async: true,
				data: {
					"businessTripApplyId":$self.attr("data")
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
	$(".business_delete").click(function(){
		var $self = $(this);
		layer.confirm("确认删除吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/businessTripApply/deleteBusinessTripApply/" +  $self.attr("data"),
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