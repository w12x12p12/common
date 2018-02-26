$(function(){
	$("#save_btn").bind("click", Department.saveData);
});
var Department={
	//弹出编辑对话框
	showEdit : function(departmentId){
		//弹框方式
		/*$(".formError").remove();
		if(!departmentId){//新增
			this.clearData();
		}
		else{//修改
			this.fillData(departmentId);
		}
		$('#editModal').modal({keyboard: false});*/
		//页面跳转方式
		if(!departmentId) departmentId = "";
		document.location.href = ctx + "/admin/department/editDepartment?departmentId="+departmentId;
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
	fillData : function(departmentId){
		this.getData(departmentId, function(data){
			for (dataAttr in data){  
			   	 if($("#editForm [name="+dataAttr+"]")){
			   		$("#editForm [name="+dataAttr+"]").val(data[dataAttr]);
			   	 }
			  } 
		});
	},
	//保存数据
	saveData : function(){
		if(!$("form#editForm").validationEngine("validate")) return ;  
		$.ajax({
    		url: ctx+"/admin/department/saveDepartment",
    		type: "POST",
    		async: true,
    		data: $("#editForm").serialize(),
    		success: function(data){
    			if(data.errorCode =="000000"){
    				layer.msg("保存成功", {time:1000}, function(){
    					document.location.href = ctx + "/admin/department/departmentList";
    				});
    			}
    			else{
    				layer.msg(jsonResult.errorMessage,{time:1000});
    			}
    		},
    		error: function(){
    		}
    	});
	},	
	//获取数据
	getData : function(departmentId, callback){
		$.ajax({
    		url: ctx+"/admin/department/findDepartment",
    		type: "POST",
    		async: true,
    		data: {"departmentId" : departmentId},
    		success: function(data){
    			if(data.errorCode =="000000"){
    				callback(data.data);
    				return;
    			}
    			else{
    				layer.msg(jsonResult.errorMessage,{time:1000});
    			}
    		},
    		error: function(){
    		}
    	});
	},
	//删除数据
	deleteData : function(departmentId, delFlag) {
		layer.confirm("是否确认删除?", {
			btn : [ "确定", "取消" ]
		}, function() {
			$.ajax({
				url : ctx + "/admin/department/deleteDepartment",
				type : "POST",
				async : true,
				data : {
					"departmentId" : departmentId
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