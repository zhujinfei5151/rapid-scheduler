/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cn.org.rapid_framework.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import static junit.framework.Assert.*;

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


public class SchedulerPropertyManagerTest extends BaseManagerTestCase{

	private SchedulerPropertyManager manager;
	
	@Autowired
	public void setSchedulerPropertyManager(SchedulerPropertyManager manager) {
		this.manager = manager;
	}

	@Override
	protected String[] getDbUnitDataFiles() {
		return new String[]{"classpath:common_testdata.xml","classpath:SchedulerProperty_testdata.xml"};
	}

	@Test
	public void crud() {
		SchedulerProperty obj = new SchedulerProperty();
		
	  	obj.setConfigValue(new java.lang.String("1"));
	  	obj.setDefaultValue(new java.lang.String("1"));
	  	obj.setDescription(new java.lang.String("1"));
		
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getConfigKey());
		
		manager.removeById(obj.getConfigKey());
		manager.getEntityDao().flush();
	
	}
}
