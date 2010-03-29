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


public class SchedulerGroupManagerTest extends BaseManagerTestCase{

	private SchedulerGroupManager manager;
	
	@Autowired
	public void setSchedulerGroupManager(SchedulerGroupManager manager) {
		this.manager = manager;
	}

	@Override
	protected String[] getDbUnitDataFiles() {
		return new String[]{"classpath:common_testdata.xml","classpath:SchedulerGroup_testdata.xml"};
	}

	@Test
	public void crud() {
		SchedulerGroup obj = new SchedulerGroup();
		
	  	obj.setDescription(new java.lang.String("1"));
		
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getGroupName());
		
		manager.removeById(obj.getGroupName());
		manager.getEntityDao().flush();
	
	}
}
