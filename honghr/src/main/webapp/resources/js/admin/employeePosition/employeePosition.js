var EmployeePosition = {
	// 删除数据
	deleteData : function(employeePositionId, delFlag) {
		layer.confirm("是否确认删除?", {
			btn : [ "确定", "取消" ]
		}, function() {
			$.ajax({
				url : ctx + "/admin/employeePosition/deleteEmployeePosition",
				type : "POST",
				async : true,
				data : {
					"employeePositionId" : employeePositionId
				},
				success : function(data) {
					if (data.errorCode == "000000") {
						layer.msg("删除成功", {
							time : 1000
						}, function() {
							document.location.reload();
						});
					} else {
						layer.msg(data.errorMessage, {
							time : 1000
						});
					}
				},
				error : function() {
				}
			});
		}, function() {
		});
	}
}