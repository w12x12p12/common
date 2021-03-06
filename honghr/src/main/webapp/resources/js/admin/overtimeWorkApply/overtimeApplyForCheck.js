$(function(){
	var submit = true;
	var agree = true;
	/* 点击同意 */
	$(".overtime_agree").click(function(){
		var $self = $(this)
		layer.confirm("是否填写审批意见?", {btn: ["是","否"]},function(){
			 layer.closeAll();
			 $(".w_edit_applySuggest").val("");
			 $(".suggest_overtimeApplyId").val($self.attr("data"));
			 $("#myModal_suggest").modal("show");
		},function(){
			layer.confirm("确认批准吗?", {btn: ["确定","取消"]},function(){
				$.ajax({
					url: ctx + "/admin/overtimeWorkApply/agreeOvertimeApply",
					type: "POST",
					async: true,
					data: {
						"overtimeWorkApplyId": $self.attr("data")
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
	});
	
	/* 点击不同意 */
	$(".overtime_disAgree").click(function(){
		agree = false;
		$(".w_edit_applySuggest").val("");
		$(".suggest_overtimeApplyId").val($(this).attr("data"));
	});
	
	/* 点击保存意见 */
	$("#edit_suggestForm").click(function(){
		var overtimeWorkApplyId = $(".suggest_overtimeApplyId").val();
		var applyCheckSuggest = $(".suggest_text").val();
		if(!applyCheckSuggest){
			layer.msg("请填写审批意见",{time:1500});		
			return false;
		}
		if(submit){
			var url = "";
			if(agree){
				url = ctx + "/admin/overtimeWorkApply/agreeOvertimeApply"; 	
			}else{
				url = ctx + "/admin/overtimeWorkApply/disAgreeOvertimeApply";
			}
			$.ajax({
				url: url,
				type: "POST",
				async: true,
				data: {
					"overtimeWorkApplyId": overtimeWorkApplyId,
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