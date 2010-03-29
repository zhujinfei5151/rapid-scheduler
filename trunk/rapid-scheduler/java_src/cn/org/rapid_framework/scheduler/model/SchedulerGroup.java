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


public class SchedulerGroup extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SchedulerGroup";
	public static final String ALIAS_GROUP_NAME = "groupName";
	public static final String ALIAS_DESCRIPTION = "description";
	
	//date formats
	
	//columns START
	private java.lang.String groupName;
	private java.lang.String description;
	//columns END
	
	//注意： spring_jdbc的MetadataCreateUtils.fromTable(Entity.class) 可以读取JPA annotation的标注信息
	//现支持 @Id,@Column,@Table标注

	public SchedulerGroup(){
	}

	public SchedulerGroup(
		java.lang.String groupName
	){
		this.groupName = groupName;
	}

	@Id
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	
	private Set schedulerJobs = new HashSet(0);
	@Transient
	public Set<SchedulerJob> getSchedulerJobs() {
		return schedulerJobs;
	}	
	public void setSchedulerJobs(Set<SchedulerJob> schedulerJob){
		this.schedulerJobs = schedulerJob;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("GroupName",getGroupName())
			.append("Description",getDescription())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGroupName())
			.append(getDescription())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SchedulerGroup == false) return false;
		if(this == obj) return true;
		SchedulerGroup other = (SchedulerGroup)obj;
		return new EqualsBuilder()
			.append(getGroupName(),other.getGroupName())
			.append(getDescription(),other.getDescription())
			.isEquals();
	}
}

