$(function(){
	var submit = true;
	var agree = true;
	/* 点击同意 */
	$(".absence_agree").click(function(){
		agree = true;
		var $self = $(this);
		$.ajax({
			url: ctx + "/admin/absenceApply/validateAbsenceApplyDuration",
			type: "GET",
			async: false,
			data: {
				"absenceApplyId": $self.attr("data")
			},
			dataType: "JSON",
			success: function(jsonResult){
				var code = jsonResult.errorCode;
				if(jsonResult.errorCode == "000000"){
					layer.confirm("是否填写审批意见?", {btn: ["是","否"]},function(){
						 layer.closeAll();
						 $(".w_edit_applySuggest").val("");
						 $(".suggest_absenceApplyId").val($self.attr("data"));
						 $("#myModal_suggest").modal("show");
					},function(){
						layer.confirm("确认同意吗?", {btn: ["确定","取消"]},function(){
							$.ajax({
								url: ctx + "/admin/absenceApply/agreeAbsenceApply",
								type: "POST",
								async: true,
								data: {
									"absenceApplyId": $self.attr("data")
								},
								success: function(data){
									if(data == "000000"){
										layer.msg("审批成功", {time:1500}, function(){
											document.location.reload();
				    					});
									}
								},
								error: function(){
									layer.msg("暂时无法审批",{time:1500});					
								}
							});
						});
					});
					return true;
				}else{
					if(jsonResult.errorMessage){
						layer.confirm(jsonResult.errorMessage, {btn: ["确定"],closeBtn: 0},function(){
							layer.closeAll();
						});
					}
					return false;
				}
			},
			error: function(){
				layer.msg("暂时无法审批",{time:1500});					
			}
		});
	});
	/* 点击不同意 */
	$(".absence_disAgree").click(function(){
		agree = false;
		$(".w_edit_applySuggest").val("");
		$(".suggest_absenceApplyId").val($(this).attr("data"));
	});
	/* 点击保存意见 */
	$("#edit_suggestForm").click(function(){
		var absenceApplyId = $(".suggest_absenceApplyId").val();
		var applyCheckSuggest = $(".suggest_text").val();
		if(!applyCheckSuggest){
			layer.msg("请填写审批意见",{time:1500});		
			return false;
		}
		if(submit){
			var url = "";
			if(agree){
				url = ctx + "/admin/absenceApply/agreeAbsenceApply"; 	
			}else{
				url = ctx + "/admin/absenceApply/disAgreeAbsenceApply";
			}
			$.ajax({
				url: url,
				type: "POST",
				async: true,
				data: {
					"absenceApplyId": absenceApplyId,
					"applyCheckSuggest": applyCheckSuggest
				},
				beforeSend: function(){
					submit = false;
           		},
				success: function(data){
					if(data == "000000"){
						layer.msg("审批成功", {time:1500}, function(){
							document.location.reload();
    					});
					}
				},
				error: function(){
					layer.msg("暂时无法提交",{time:1500});					
				}
			});
		}else{
			layer.msg("正在保存,请您耐心等待",{time:1500});
			return false;	
		}
	});
});