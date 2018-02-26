<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
<title>宏程教育GEE人事管理平台</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${ctx}/resources/css/common/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/common/style.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/common/z_login.css" type="text/css" rel="stylesheet" >
<link href="${ctx}/resources/css/common/bootstrap-fileinput.css" rel="stylesheet">
<script src="${ctx}/resources/js/common/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/common/bootstrap.min.js" type="text/javascript"></script>
<!-- 引用日期插件 -->
<script src="${ctx}/resources/js/my97/WdatePicker.js" type="text/javascript"></script>
 <!-- 引用数据校验插件 -->
<link rel="stylesheet" href="${ctx}/resources/js/common/jQueryValidate/css/validationEngine.jquery.css">
<script type="text/javascript" src="${ctx}/resources/js/common/jQueryValidate/js/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/common/jQueryValidate/js/jquery.validationEngine.js"></script> 
<!-- 弹出框插件 -->
<script type="text/javascript" src="${ctx}/resources/js/common/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/module/main.js"></script>
<script>
	var ctx = "${ctx}";
</script>
</head>
<body>
<sitemesh:write property='body' />
</body>
</html>