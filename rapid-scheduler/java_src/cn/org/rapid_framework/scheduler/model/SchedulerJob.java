/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cn.org.rapid_framework.scheduler.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import javax.persistence.*;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import cn.org.rapid_framework.scheduler.model.*;
import cn.org.rapid_framework.scheduler.dao.*;
import cn.org.rapid_framework.scheduler.service.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SchedulerJob extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SchedulerJob";
	public static final String ALIAS_JOB_NAME = "jobName";
	public static final String ALIAS_GROUP_NAME = "groupName";
	public static final String ALIAS_CRON = "cron";
	public static final String ALIAS_DESCRIPTION = "description";
	public static final String ALIAS_URL = "url";
	public static final String ALIAS_STATUS = "status";
	
	//date formats
	
	//columns START
	private java.lang.String jobName;
	private java.lang.String groupName;
	private java.lang.String cron;
	private java.lang.String description;
	private java.lang.String url;
	private java.lang.String status;
	//columns END
	
	//注意： spring_jdbc的MetadataCreateUtils.fromTable(Entity.class) 可以读取JPA annotation的标注信息
	//现支持 @Id,@Column,@Table标注

	public SchedulerJob(){
	}

	public SchedulerJob(
		java.lang.String jobName,
		java.lang.String groupName
	){
		this.jobName = jobName;
		this.groupName = groupName;
	}

	@Id
	public java.lang.String getJobName() {
		return this.jobName;
	}
	
	public void setJobName(java.lang.String value) {
		this.jobName = value;
	}
	
	@Id
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
	
	public java.lang.String getCron() {
		return this.cron;
	}
	
	public void setCron(java.lang.String value) {
		this.cron = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	
	private SchedulerGroup schedulerGroup;
	@Transient
	public SchedulerGroup getSchedulerGroup() {
		return schedulerGroup;
	}	
	public void setSchedulerGroup(SchedulerGroup schedulerGroup){
		this.schedulerGroup = schedulerGroup;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("JobName",getJobName())
			.append("GroupName",getGroupName())
			.append("Cron",getCron())
			.append("Description",getDescription())
			.append("Url",getUrl())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getJobName())
			.append(getGroupName())
			.append(getCron())
			.append(getDescription())
			.append(getUrl())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SchedulerJob == false) return false;
		if(this == obj) return true;
		SchedulerJob other = (SchedulerJob)obj;
		return new EqualsBuilder()
			.append(getJobName(),other.getJobName())
			.append(getGroupName(),other.getGroupName())
			.append(getCron(),other.getCron())
			.append(getDescription(),other.getDescription())
			.append(getUrl(),other.getUrl())
			.append(getStatus(),other.getStatus())
			.isEquals();
	}
}

