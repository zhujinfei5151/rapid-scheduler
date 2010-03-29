
<#include "/commons/macro.ftl" />

<@override name="head">
	<title>SchedulerJob.TABLE_ALIAS 管理</title>
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
					SchedulerJob.ALIAS_JOB_NAME
			</td>		
			<td>
				<input value="${pageRequest.filters.jobName!}"  name="s_jobName"  />
			</td>
			<td class="tdLabel">
					SchedulerJob.ALIAS_GROUP_NAME
			</td>		
			<td>
				<input value="${pageRequest.filters.groupName!}"  name="s_groupName"  />
			</td>
			<td class="tdLabel">
					SchedulerJob.ALIAS_CRON
			</td>		
			<td>
				<input value="${pageRequest.filters.cron!}"  name="s_cron"  />
			</td>
			<td class="tdLabel">
					SchedulerJob.ALIAS_DESCRIPTION
			</td>		
			<td>
				<input value="${pageRequest.filters.description!}"  name="s_description"  />
			</td>
			<td class="tdLabel">
					SchedulerJob.ALIAS_URL
			</td>		
			<td>
				<input value="${pageRequest.filters.url!}"  name="s_url"  />
			</td>
		</tr>	
		<tr>	
			<td class="tdLabel">
					SchedulerJob.ALIAS_STATUS
			</td>		
			<td>
				<input value="${pageRequest.filters.status!}"  name="s_status"  />
			</td>
		</tr>	
	</table>
</fieldset>
<div class="handleControl">
	<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/schedulerjob'"/>
	<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/schedulerjob/new'"/>
	<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/schedulerjob','items',document.forms.simpleTableForm)"/>
<div>
</form>
</div>

<form id="simpleTableForm" action="${ctx}/schedulerjob" method="get" style="display: inline;">

	<!-- auto include parameters -->
	<#list pageRequest.filters?keys as key>
		<input type="hidden" name="s_${key}" value="${pageRequest.filters[key]}"/>
	</#list>
	
	<input type="hidden" name="pageNumber" id="pageNumber" />
	<input type="hidden" name="pageSize" id="pageSize"/>
	<input type="hidden" name="sortColumns" id="sortColumns"/>
	
	<div class="gridTable">
	
		<@pageToolBar page=page>
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</@pageToolBar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead class="tableHeader">
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="job_name" >SchedulerJob.ALIAS_JOB_NAME</th>
				<th sortColumn="group_name" >SchedulerJob.ALIAS_GROUP_NAME</th>
				<th sortColumn="cron" >SchedulerJob.ALIAS_CRON</th>
				<th sortColumn="description" >SchedulerJob.ALIAS_DESCRIPTION</th>
				<th sortColumn="url" >SchedulerJob.ALIAS_URL</th>
				<th sortColumn="status" >SchedulerJob.ALIAS_STATUS</th>
				
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody class="tableBody">
		  	  <#list page.result as item>
			  <tr class="<#if item_index % 2 == 0>odd<#else>even</#if>">
				<td>${page.thisPageFirstElementNumber + item_index + 1}</td>
				<td><input type="checkbox" name="items" value="${item.jobName}"></td>
				
				<td>${item.jobName!}&nbsp;</td>
				<td>${item.groupName!}&nbsp;</td>
				<td>${item.cron!}&nbsp;</td>
				<td>${item.description!}&nbsp;</td>
				<td>${item.url!}&nbsp;</td>
				<td>${item.status!}&nbsp;</td>
								
				<td>
					<a href="${ctx}/schedulerjob/${item.jobName}/${item.groupName}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/schedulerjob/${item.jobName}/${item.groupName}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/schedulerjob/${item.jobName}/${item.groupName}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
				</td>
			  </tr>
			  </#list>
		  </tbody>
		</table>
	
		<@pageToolBar page=page>
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</@pageToolBar>
		
	</div>
</form>
</@override>

<@extends name="/base.ftl"/>
