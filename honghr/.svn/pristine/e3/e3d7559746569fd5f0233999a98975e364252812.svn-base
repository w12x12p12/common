$(function(){
	$(".absence_clear").click(function(){
		var $self = $(this);
		layer.confirm("确认清空" + $self.attr("data-name") + "的去年年假吗?", {btn: ["确定","取消"]},function(){
			$.ajax({
				url: ctx + "/admin/absenceApply/clearRemainingAnnualLeaveHourLastYear",
				type: "POST",
				async: true,
				data: {
					"employeeId":$self.attr("data")
				},
				success: function(data){
					if(data == "000000"){
						layer.msg("清空成功", {time:1500}, function(){
							document.location.reload();
    					});
					}
				},
				error: function(){
					layer.msg("暂时无法清空",{time:1500});
				}
			});
		},function(){});
	});
});