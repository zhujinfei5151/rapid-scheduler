/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cn.org.rapid_framework.scheduler.dao;

import java.util.List;

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


public class SchedulerGroupDaoTest extends BaseDaoTestCase{
	
	private SchedulerGroupDao dao;
	
	@Autowired
	public void setSchedulerGroupDao(SchedulerGroupDao dao) {
		this.dao = dao;
	}

	@Override
	protected String[] getDbUnitDataFiles() {
		return new String[]{"classpath:common_testdata.xml","classpath:SchedulerGroup_testdata.xml"};
	}
	
	@Test
	public void findByPageRequest() {
		int pageNumber = 1;
		int pageSize = 10;
		
		PageRequest<Map> pageRequest = new PageRequest(new HashMap());
		pageRequest.setPageNumber(pageNumber);
		pageRequest.setPageSize(pageSize);
		pageRequest.setSortColumns(null);
		
		pageRequest.getFilters().put("description", "1");
		
		Page page = dao.findByPageRequest(pageRequest);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
}
