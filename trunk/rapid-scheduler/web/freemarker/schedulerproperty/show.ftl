
<#include "/commons/macro.ftl" />

<@override name="head">
	<title>SchedulerProperty.TABLE_ALIAS 信息</title>
</@override>

<@override name="content">
	<form>
		<input type="button" value="返回列表" onclick="window.location='${ctx}/schedulerproperty'"/>
		<input type="button" value="后退" onclick="history.back();"/>

	<input type="hidden" id="configKey" name="configKey" value="${schedulerProperty.configKey}"/>

	<table class="formTable">
		<tr>	
			<td class="tdLabel">SchedulerProperty.ALIAS_CONFIG_VALUE</td>	
			<td>${schedulerProperty.configValue!}</td>
		</tr>
		<tr>	
			<td class="tdLabel">SchedulerProperty.ALIAS_DEFAULT_VALUE</td>	
			<td>${schedulerProperty.defaultValue!}</td>
		</tr>
		<tr>	
			<td class="tdLabel">SchedulerProperty.ALIAS_DESCRIPTION</td>	
			<td>${schedulerProperty.description!}</td>
		</tr>
	</table>
	</form>
</@override>

<@extends name="/base.ftl"/>