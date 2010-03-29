
<#include "/commons/macro.ftl" />

<@override name="head">
	<title>SchedulerGroup.TABLE_ALIAS 管理</title>
	<link href="${ctx}/widgets/simpletable/simpletable.css" type="text/css" rel="stylesheet">
	<script src="${ctx}/widgets/simpletable/simpletable.js" type="text/javascript"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('simpleTableForm','${page.thisPageNumber!}','${page.pageSize!}','${pageRequest.sortColumns!}');
		});
	</script>
</@override>

<@override name="content">

<div class="queryPanel">
<form method="get" style="display: inline;">
<fieldset>
	<legend>搜索</legend>
	<table>
		<tr>	
			<td class="tdLabel">
					SchedulerGroup.ALIAS_DESCRIPTION
			</td>		
			<td>
				<input value="${pageRequest.filters.description!}"  name="s_description"  />
			</td>
		</tr>	
	</table>
</fieldset>
<div class="handleControl">
	<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/schedulergroup'"/>
	<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/schedulergroup/new'"/>
	<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/schedulergroup','items',document.forms.simpleTableForm)"/>
<div>
</form>
</div>

<form id="simpleTableForm" action="${ctx}/schedulergroup" method="get" style="display: inline;">

	<!-- auto include parameters -->
	<#list pageRequest.filters?keys as key>
		<input type="hidden" name="s_${key}" value="${pageRequest.filters[key]}"/>
	</#list>
	
	<input type="hidden" name="pageNumber" id="pageNumber" />
	<input type="hidden" name="pageSize" id="pageSize"/>
	<input type="hidden" name="sortColumns" id="sortColumns"/>
	
	<div class="gridTable">
	
		<@pageToolBar page=page pageSizeSelectList=[10,20,30]>
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</@pageToolBar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead class="tableHeader">
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="group_name" >SchedulerGroup.ALIAS_GROUP_NAME</th>
				<th sortColumn="description" >SchedulerGroup.ALIAS_DESCRIPTION</th>
				
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody class="tableBody">
		  	  <#list page.result as item>
			  <tr class="<#if item_index % 2 == 0>odd<#else>even</#if>">
				<td>${page.thisPageFirstElementNumber + item_index + 1}</td>
				<td><input type="checkbox" name="items" value="${item.groupName}"></td>
				
				<td>${item.groupName!}&nbsp;</td>
				<td>${item.description!}&nbsp;</td>
								
				<td>
					<a href="${ctx}/schedulergroup/${item.groupName}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/schedulergroup/${item.groupName}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/schedulergroup/${item.groupName}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
				</td>
			  </tr>
			  </#list>
		  </tbody>
		</table>
	
		<@pageToolBar page=page pageSizeSelectList=[10,20,30]>
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</@pageToolBar>
		
	</div>
</form>
</@override>

<@extends name="/base.ftl"/>
