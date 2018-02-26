<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx }/resources/js/admin/position/position.js"></script>
<form class="form-inline" role="form">
	<div class="form-group btn-group-sm z_margin_tb">
		<label class="sr-only" for="name">查询条件</label>
		<span class="show-lab label">职位名称:</span> 
		 <input type="text"
			name="positionName" value="${positionName }"
			class="form-control input-sm" id="" placeholder="请输入职位名称进行查询">
		<button type="submit" class="btn btn-primary btn-search">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
		</button>
	</div>
	<ul class="nav nav-list">
		<li class="divider"></li>
	</ul>
	<div class="form-group  btn-group-sm" role="group" aria-label="...">
		<button type="button" class="btn btn-default btn-search"
			onclick="Position.showEdit();">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		</button>
	</div>
	<div class="table-responsive">
		<table class="table table-striped w_cee_table">
			<thead>
				<tr>
					<th>序号</th>
					<th>职务名称</th>
					<th>直属上级</th>
					<th>对应部门</th>
					<th>是否关联</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entity" items="${page.dataList}" varStatus="status">
					<tr>
						<td>${status.index+1 + (page.currentPage-1)*page.pageSize }</td>
						<td>${entity.positionName}</td>
						<td>${entity.leaderPosition}</td>
						<td>${entity.depName}</td>
						<td><c:if test="${entity.referred=='1'}">是</c:if> <c:if
								test="${entity.referred=='0'}">否</c:if></td>
						<td>
							<button type="button" class="btn btn-default btn-sm"
								onclick="Position.showEdit('${entity.positionId}');">
								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>编辑
							</button>
							<button type="button" class="btn btn-default  btn-sm btn-danger"
								onclick="Position.deleteData('${entity.positionId}');">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 分页区域 -->
		<jsp:include page="/WEB-INF/jsp/common/page.jsp"></jsp:include>
	</div>
</form>