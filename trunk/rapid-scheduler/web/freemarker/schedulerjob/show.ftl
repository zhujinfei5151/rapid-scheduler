
<#include "/commons/macro.ftl" />

<@override name="head">
	<title>SchedulerJob.TABLE_ALIAS 信息</title>
</@override>

<@override name="content">
	<form>
		<input type="button" value="返回列表" onclick="window.location='${ctx}/schedulerjob'"/>
		<input type="button" value="后退" onclick="history.back();"/>

	<input type="hidden" id="jobName" name="jobName" value="${schedulerJob.jobName}"/>
	<input type="hidden" id="groupName" name="groupName" value="${schedulerJob.groupName}"/>

	<table class="formTable">
		<tr>	
			<td class="tdLabel">SchedulerJob.ALIAS_JOB_NAME</td>	
			<td>${schedulerJob.jobName!}</td>
		</tr>
		<tr>	
			<td class="tdLabel">SchedulerJob.ALIAS_GROUP_NAME</td>	
			<td>${schedulerJob.groupName!}</td>
		</tr>
		<tr>	
			<td class="tdLabel">SchedulerJob.ALIAS_CRON</td>	
			<td>${schedulerJob.cron!}</td>
		</tr>
		<tr>	
			<td class="tdLabel">SchedulerJob.ALIAS_DESCRIPTION</td>	
			<td>${schedulerJob.description!}</td>
		</tr>
		<tr>	
			<td class="tdLabel">SchedulerJob.ALIAS_URL</td>	
			<td>${schedulerJob.url!}</td>
		</tr>
		<tr>	
			<td class="tdLabel">SchedulerJob.ALIAS_STATUS</td>	
			<td>${schedulerJob.status!}</td>
		</tr>
	</table>
	</form>
</@override>

<@extends name="/base.ftl"/>