$(function(){
	var submit = true;
	/* 保存新增 */
	$(".save_form").click(function(){
		var absenceType = $(".w_honghr_radio:checked").val();
		var applyReason = $(".w_edit_applyReason").val();
		var applyBeginTime = $("#startDate").val();
		var applyEndTime = $("#endDate").val();
		var $checkEmployee = $(".w_checkEmployee");
		if(validateForm(absenceType,applyReason,applyBeginTime,applyEndTime,$checkEmployee)){
			if(submit){
				$("#applyForm .save_checkStatus").remove();
				if($(this).prop("id") == "save_default"){
					$("#applyForm").append("<input type='hidden' name='applyCheckStatus' class='save_checkStatus' value='-1' />");
				}else{
					$("#applyForm").append("<input type='hidden' name='applyCheckStatus' class='save_checkStatus' value='0' />");
				}
				$("#applyForm .save_checkEmployee").remove();
				$("#applyForm .save_checkSequence").remove();
				$checkEmployee.each(function(index){
					$("#applyForm").append("<input type='hidden' name='absenceApplyChecks["+index+"].checkEmployeeId' class='save_checkEmployee' value='" + $(this).attr("data") + "' />");
					$("#applyForm").append("<input type='hidden' name='absenceApplyChecks["+index+"].applyCheckSequence' class='save_checkSequence' value='" + $(this).attr("seq") + "' />");
				});
				$("#applyForm .save_imageFile").remove();
				if($(".imageAttachment").attr("src")){
					$("#applyForm").append("<input type='hidden' name='imageAttachment' class='save_imageFile' value='" + $(".imageAttachment").attr("src") + "'/>");
				}
				$.ajax({
					url: ctx + "/admin/absenceApply/addForAbsenceApplyCheck",
					type: "POST",
					async: true,
					data: $("#applyForm").serialize(),
					beforeSend: function(){
						submit = false;
					},
					success: function(data){
						if(data == "000000"){
							layer.msg("保存成功", {time:1500}, function(){
								$(".z_menu_li",window.parent.document).click().removeClass("z_active");
								$("#absenceApplyList",parent.document).parents(".z_menu_li").click().addClass("z_active"); 
								window.location.href = ctx + "/admin/absenceApply/absenceApplyList";
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
});