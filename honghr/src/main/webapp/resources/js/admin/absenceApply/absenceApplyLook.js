$(function(){
	/* 点击查看 */
	$(".absence_look").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/absenceApply/getAbsenceApply",
			type: "GET",
			async: false,
			data: {
				"absenceApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(absenceApplyVo){
				$(".showAbsenceApply").text("");
				$(".show_absenceApplyNum").text(absenceApplyVo.absenceApplyNum);
				$(".show_applyEmployeeName").text(absenceApplyVo.applyEmployeeName);
				$(".show_applyDepartmentName").text(absenceApplyVo.applyDepartmentName);
				$(".show_applyTypeShow").text(absenceApplyVo.applyTypeShow);
				$(".show_applyReason").text(absenceApplyVo.applyReason);
				$(".show_applyBeginTime").text(new Date(parseInt(absenceApplyVo.applyBeginTime)).toLocaleString());
				$(".show_applyEndTime").text(new Date(parseInt(absenceApplyVo.applyEndTime)).toLocaleString());
				$(".show_applyDuration").text(absenceApplyVo.applyDuration + "小时");
				$(".show_applyDateTime").text(new Date(parseInt(absenceApplyVo.applyDateTime)).toLocaleDateString());
				$(".show_applyCheckStatusShow").text(absenceApplyVo.applyCheckStatusShow);
				var array = [];
				var absenceApplyCheckVos = absenceApplyVo.absenceApplyCheckVos;
				$(absenceApplyCheckVos).each(function(index){
					array.push(this.checkEmployeeName);
					if(index < absenceApplyCheckVos.length - 1){
						array.push("→");
					}
				});
				$(".show_checkEmployeeName").text(array.join(""));
				array = [];
				var attachment = absenceApplyVo.attachment;
				if(attachment){
					array.push("<tr class='show_attachment_tr' ><td>休假单附件</td>")
					array.push("<td class='showAbsenceApply show_apply_attachment'><a href='" + ctx + attachment.attachmentUrl + "' target='_blank' >点击查看</a></td></tr>");
				}
				$(".show_attachment_tr").remove();
				$(".w_show_text").append(array.join(""));
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
	/* 点击审批记录 */
	$(".absence_lookProgress").click(function(){
		var flag = true;
		$.ajax({
			url: ctx + "/admin/absenceApply/getAbsenceApplyProgress",
			type: "GET",
			async: false,
			data: {
				"absenceApplyId": $(this).attr("data")
			},
			dataType: "JSON",
			success: function(absenceApplyCheckVoList){
				var array = [];
				$(absenceApplyCheckVoList).each(function(){
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