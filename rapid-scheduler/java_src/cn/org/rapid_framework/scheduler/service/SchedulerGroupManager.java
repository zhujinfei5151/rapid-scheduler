/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cn.org.rapid_framework.scheduler.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

@Component
@Transactional
public class SchedulerGroupManager extends BaseManager<SchedulerGroup,java.lang.String>{

	private SchedulerGroupDao schedulerGroupDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSchedulerGroupDao(SchedulerGroupDao dao) {
		this.schedulerGroupDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.schedulerGroupDao;
	}
	
	@Transactional(readOnly=true)
	public Page findByPageRequest(PageRequest pr) {
		return schedulerGroupDao.findByPageRequest(pr);
	}
	
}
