$(function(){
	$("#save_btn").bind("click", Employee.saveData);
});
var Employee={
	//弹出编辑对话框
	showEdit : function(employeeId){
		//页面跳转方式
		if(!employeeId) employeeId = "";
		document.location.href = ctx + "/admin/employee/editEmployee?employeeId="+employeeId;
	},	
	
	showAdd : function(employeeId){
		//页面跳转方式
		document.location.href = ctx + "/admin/employee/addEmployee";
		if(!employeeId){//新增
			this.clearData();
		}
	},	
	//清除弹出框数据
	clearData : function(){
		$("#editForm select").each(function() {
			$(this).find("option:first").prop("selected", 'selected');
		})
		$("#editForm input").each(function() {
			$(this).val("");
		})
	},
	//填充弹出框数据
	fillData : function(employeeId){
		this.getData(employeeId, function(data){
			for (dataAttr in data)  
			  {  
			   	 if($("#editForm [name="+dataAttr+"]")){
			   		$("#editForm [name="+dataAttr+"]").val(data[dataAttr]);
			   	 }
			  } 
		});
	},
	//保存数据
	saveData : function() {
		if (!$("form#editForm").validationEngine("validate"))
		return;
		$.ajax({
			url : ctx + "/admin/employee/saveEmployee",
			type : "POST",
			async : true,
			data : $("#editForm").serialize(),
			success : function(data) {
				if (data.errorCode == "000000") {
					layer.msg("保存成功", {time:1000}, function(){
						document.location.href = ctx + "/admin/employee/employeeList";
    				});
				} else {
					layer.msg(data.errorMessage,{time:1000});
				}
			},
			error : function() {
			}
		});
	},	
	// 获取数据
	getData : function(employeeId, callback) {
		$.ajax({
			url : ctx + "/admin/employee/findEmployee",
			type : "POST",
			async : true,
			data : {
				"employeeId" : employeeId
			},
			success : function(jsonResult) {
				if (jsonResult.errorCode == "000000") {
					var employee = jsonResult.data;
					employee.birthday = new Date(parseInt(employee.birthday))
							.toLocaleDateString().replace(/\//g, "-");
					employee.workBeginTime = new Date(
							parseInt(employee.workBeginTime))
							.toLocaleDateString().replace(/\//g, "-");
					employee.entryTime = new Date(parseInt(employee.entryTime))
							.toLocaleDateString().replace(/\//g, "-");
					callback(employee);
					return;
				} else {
					layer.msg(jsonResult.errorMessage,{time:1000});
				}
			},
			error : function() {
			}
		});
	},
	//删除
	deleteData : function(employeeId, delFlag) {
		layer.confirm("是否确认删除?", {btn : [ "确定", "取消" ]}, function() {
			$.ajax({
				url : ctx + "/admin/employee/deleteEmployee",
				type : "POST",
				async : true,
				data : {
					"employeeId" : employeeId
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
	},
	// 启用or禁用
	isForbided : function(employeeId, forbided) {
		$.ajax({
			url : ctx + "/admin/employee/ForbidedEmployee",
			type : "POST",
			async : true,
			data : {
				"employeeId" : employeeId,
				"forbided" : forbided
			},
			success : function(data) {
				if (data.errorCode == "000000") {
					layer.msg(data.errorMessage, {
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
	},
	//重置密码
	reSetPwd : function(employeeId) {
		$.ajax({
			url : ctx + "/admin/employee/reSetPassword",
			type : "POST",
			async : true,
			data : {"employeeId" : employeeId},
			success : function(data) {
				if (data.errorCode == "000000") {
					layer.msg(data.errorMessage, {
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
	}
}