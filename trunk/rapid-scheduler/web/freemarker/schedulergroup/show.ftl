
<#include "/commons/macro.ftl" />

<@override name="head">
	<title>SchedulerGroup.TABLE_ALIAS 信息</title>
</@override>

<@override name="content">
	<form>
		<input type="button" value="返回列表" onclick="window.location='${ctx}/schedulergroup'"/>
		<input type="button" value="后退" onclick="history.back();"/>

	<input type="hidden" id="groupName" name="groupName" value="${schedulerGroup.groupName}"/>

	<table class="formTable">
		<tr>	
			<td class="tdLabel">SchedulerGroup.ALIAS_GROUP_NAME</td>	
			<td>${schedulerGroup.groupName!}</td>
		</tr>	
		<tr>	
			<td class="tdLabel">SchedulerGroup.ALIAS_DESCRIPTION</td>	
			<td>${schedulerGroup.description!}</td>
		</tr>
	</table>
	</form>
</@override>

<@extends name="/base.ftl"/>