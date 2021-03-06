$(function(){
	/* 点击查看 */
	$(".business_look").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/businessTripApply/getBusinessTripApply",
			type: "GET",
			async: false,
			data: {
				"businessTripApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(businessTripApplyVo){
				$(".showBusinessTripApply").text("");
				$(".show_businessTripApplyNum").text(businessTripApplyVo.businessTripApplyNum);
				$(".show_applyEmployeeName").text(businessTripApplyVo.applyEmployeeName);
				$(".show_applyDepartmentName").text(businessTripApplyVo.applyDepartmentName);
				$(".show_applyTypeShow").text(businessTripApplyVo.applyTypeShow);
				$(".show_applyReason").text(businessTripApplyVo.applyReason);
				$(".show_applyBeginAddressName").text(businessTripApplyVo.applyBeginProvinceName + businessTripApplyVo.applyBeginCityName);
				$(".show_applyEndAddressName").text(businessTripApplyVo.applyEndProvinceName + businessTripApplyVo.applyEndCityName);
				$(".show_applyBeginTime").text(new Date(parseInt(businessTripApplyVo.applyBeginTime)).toLocaleString());
				$(".show_applyEndTime").text(new Date(parseInt(businessTripApplyVo.applyEndTime)).toLocaleString())
				$(".show_applyDuration").text(businessTripApplyVo.applyDuration + "天");
				$(".show_applyDateTime").text(new Date(parseInt(businessTripApplyVo.applyDateTime)).toLocaleDateString());
				$(".show_applyCheckStatusShow").text(businessTripApplyVo.applyCheckStatusShow);
				var array = [];
				var businessTripApplyCheckVos = businessTripApplyVo.businessTripApplyCheckVos;
				$(businessTripApplyCheckVos).each(function(index){
					array.push(this.checkEmployeeName);
					if(index < businessTripApplyCheckVos.length - 1){
						array.push("→");
					} 
				});
				$(".show_checkEmployeeName").text(array.join(""));
			},
			error: function(){
				layer.msg("暂时无法查看",{time:1500});
				flag = false;
    		}
		});
	}); 
	/* 点击审批记录 */
	$(".business_lookProgress").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/businessTripApply/getBusinessTripApplyProgress",
			type: "GET",
			async: false,
			data: {
				"businessTripApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(businessTripApplyCheckVoList){
				var array = [];
				$(businessTripApplyCheckVoList).each(function(){
					array.push("<tr>");
					array.push("<td>");
					if(this.checkEmployeeName){
						array.push(this.checkEmployeeName);
					}
					array.push("</td>");
					array.push("<td>");
					if(this.applyIsAllowedShow){
						array.push(this.applyIsAllowedShow);
					}
					array.push("</td>");
					array.push("<td>");
					if(this.applyCheckSuggest){
						array.push(this.applyCheckSuggest);
					}
					array.push("</td>");
					array.push("<td>");
					if(this.applyCheckTime){
						array.push(new Date(parseInt(this.applyCheckTime)).toLocaleString());
					}
					array.push("</td>");
					array.push("</tr>")
				});
				$(".show_progress_title").nextAll().remove();
				$(".show_progress_title").after(array.join(""));
			},
			error: function(){
				layer.msg("暂时无法查看进度",{time:1500});
				flag = false;						
			}
		});
		if(!flag){
			return false;
		}
	});
});