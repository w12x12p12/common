$(function(){
	/* 点击查看 */
	$(".overtime_look").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/overtimeWorkApply/findOvertimeApplyId",
			type: "GET",
			async: false,
			data: {
				"overtimeWorkApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(overtimeWorkApplyVo){
				$(".showOvertimeApply").text("");
				$(".show_overtimeApplyNum").text(overtimeWorkApplyVo.overtimeWorkApplyNum);
				$(".show_applyEmployeeName").text(overtimeWorkApplyVo.applyEmployeeName);
				$(".show_applyDepartmentName").text(overtimeWorkApplyVo.applyDepartmentName);
				$(".show_applyTypeShow").text(overtimeWorkApplyVo.applyTypeShow);
				$(".show_applyReason").text(overtimeWorkApplyVo.applyReason);
				$(".show_applyBeginTime").text(new Date(parseInt(overtimeWorkApplyVo.applyBeginTime)).toLocaleString());
				$(".show_applyEndTime").text(new Date(parseInt(overtimeWorkApplyVo.applyEndTime)).toLocaleString());
				$(".show_applyDuration").text(overtimeWorkApplyVo.applyDuration + "小时");
				$(".show_applyDateTime").text(new Date(parseInt(overtimeWorkApplyVo.applyDateTime)).toLocaleDateString());
				$(".show_applyCheckStatusShow").text(overtimeWorkApplyVo.applyCheckStatusShow);
				var array = [];
				var overtimeWorkApplyCheckVos = overtimeWorkApplyVo.overtimeWorkApplyCheckVos;
				$(overtimeWorkApplyCheckVos).each(function(index){
					array.push(this.checkEmployeeName);
					if(index < overtimeWorkApplyCheckVos.length - 1){
						array.push("→")
					}
				});
				$(".show_checkEmployeeName").text(array.join(""));
			},
			error: function(){
				layer.msg("暂时无法查看",{time:1500});
				flag = false;
    		}
		});
		if(!flag){
			return false;
		}
	});
	/* 点击查看审批记录 */
	$(function(){
		$(".overtime_lookProgress").click(function(){
			var flag = true;
			$.ajax({
				url: ctx + "/admin/overtimeWorkApply/getovertimeApplyProgress",
				type: "GET",
				async: false,
				data: {
					"overtimeWorkApplyId": $(this).attr("data")
				},
				dataType: "JSON",
				success: function(overtimeApplyCheckVoList){
					var array = [];
					$(".show_progress_title").nextAll().remove();
					$(overtimeApplyCheckVoList).each(function(){
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
					$(".show_progress_title").after(array.join(""));
				},
				error: function(){
					layer.msg("暂时无法查看记录",{time:1500});
					flag = false;						
				}
			});
			if(!flag){
				return false;
			}
		}); 
	});
});