$(function(){
	var submit = true;
	var agree = true;
	/* 点击同意 */
	$(".business_agree").click(function(){
		agree = true;
		var $self = $(this);
		layer.confirm("是否填写审批意见?", {btn: ["是","否"]},function(){
			layer.closeAll();
			$(".w_edit_applySuggest").val("");
			$(".suggest_businessTripApplyId").val($self.attr("data"));
			$("#myModal_suggest").modal("show");
		},function(){
			layer.confirm("确认同意吗?", {btn: ["确定","取消"]},function(){
				$.ajax({
					url: ctx + "/admin/businessTripApply/agreeBusinessTripApply",
					type: "POST",
					async: true,
					data: {
						"businessTripApplyId": $self.attr("data")
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
	$(".business_disAgree").click(function(){
		agree = false;
		$(".w_edit_applySuggest").val("");
		$(".suggest_businessTripApplyId").val($(this).attr("data"));
	});
	/* 点击保存意见 */
	$("#edit_suggestForm").click(function(){
		var businessTripApplyId = $(".suggest_businessTripApplyId").val();	
		var applyCheckSuggest = $(".suggest_text").val();
		if(!applyCheckSuggest){
			layer.msg("请填写审批意见",{time:1500});		
			return false;
		}
		if(submit){
			var url = "";
			if(agree){
				url = ctx + "/admin/businessTripApply/agreeBusinessTripApply"; 	
			}else{
				url = ctx + "/admin/businessTripApply/disAgreeBusinessTripApply";
			}
			$.ajax({
				url: url,
				type: "POST",
				async: true,
				data: {
					"businessTripApplyId": businessTripApplyId,
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