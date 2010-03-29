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


public class SchedulerProperty extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SchedulerProperty";
	public static final String ALIAS_CONFIG_KEY = "configKey";
	public static final String ALIAS_CONFIG_VALUE = "configValue";
	public static final String ALIAS_DEFAULT_VALUE = "defaultValue";
	public static final String ALIAS_DESCRIPTION = "description";
	
	//date formats
	
	//columns START
	private java.lang.String configKey;
	private java.lang.String configValue;
	private java.lang.String defaultValue;
	private java.lang.String description;
	//columns END
	
	//注意： spring_jdbc的MetadataCreateUtils.fromTable(Entity.class) 可以读取JPA annotation的标注信息
	//现支持 @Id,@Column,@Table标注

	public SchedulerProperty(){
	}

	public SchedulerProperty(
		java.lang.String configKey
	){
		this.configKey = configKey;
	}

	@Id
	public java.lang.String getConfigKey() {
		return this.configKey;
	}
	
	public void setConfigKey(java.lang.String value) {
		this.configKey = value;
	}
	
	public java.lang.String getConfigValue() {
		return this.configValue;
	}
	
	public void setConfigValue(java.lang.String value) {
		this.configValue = value;
	}
	
	public java.lang.String getDefaultValue() {
		return this.defaultValue;
	}
	
	public void setDefaultValue(java.lang.String value) {
		this.defaultValue = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this)
			.append("ConfigKey",getConfigKey())
			.append("ConfigValue",getConfigValue())
			.append("DefaultValue",getDefaultValue())
			.append("Description",getDescription())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getConfigKey())
			.append(getConfigValue())
			.append(getDefaultValue())
			.append(getDescription())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SchedulerProperty == false) return false;
		if(this == obj) return true;
		SchedulerProperty other = (SchedulerProperty)obj;
		return new EqualsBuilder()
			.append(getConfigKey(),other.getConfigKey())
			.append(getConfigValue(),other.getConfigValue())
			.append(getDefaultValue(),other.getDefaultValue())
			.append(getDescription(),other.getDescription())
			.isEquals();
	}
}

