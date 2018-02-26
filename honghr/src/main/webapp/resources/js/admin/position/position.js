$(function(){
	$("#save_btn").bind("click", Position.saveData);
});
var Position={
	//弹出编辑对话框
	showEdit : function(positionId){
		//弹框方式
		/*$(".formError").remove();
		if(!positionId){//新增
			this.clearData();
		}
		else{//修改
			this.fillData(positionId);
		}
		$('#editModal').modal({keyboard: false});*/
		//页面跳转方式
		if(!positionId) positionId = "";
		document.location.href = ctx + "/admin/position/editPosition?positionId="+positionId;
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
	fillData : function(positionId){
		this.getData(positionId, function(data){
			for (dataAttr in data)  
			  {  
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
    		url: ctx+"/admin/position/savePosition",
    		type: "POST",
    		async: true,
    		data: $("#editForm").serialize(),
    		success: function(data){
    			if(data.errorCode =="000000"){
    				layer.msg("保存成功", {time:1000}, function(){
    					document.location.href = ctx + "/admin/position/positionList";
    				});
    			}
    			else{
    				Dialog.showError(data.errorMessage);
    			}
    		},
    		error: function(){
    		}
    	});
	},	
	//获取数据
	getData : function(positionId, callback){
		$.ajax({
    		url: ctx+"/admin/position/findPosition",
    		type: "POST",
    		async: true,
    		data: {"positionId" : positionId},
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
	deleteData : function(positionId, delFlag) {
		layer.confirm("是否确认删除?", {
			btn : [ "确定", "取消" ]
		}, function() {
			$.ajax({
				url : ctx + "/admin/position/deletePosition",
				type : "POST",
				async : true,
				data : {
					"positionId" : positionId
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
}