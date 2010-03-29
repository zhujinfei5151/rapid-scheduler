/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */


package cn.org.rapid_framework.scheduler.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

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

@Controller
@RequestMapping("/schedulergroup")
public class SchedulerGroupController extends BaseRestSpringController<SchedulerGroup,java.lang.String>{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private SchedulerGroupManager schedulerGroupManager;
	
	private final String LIST_ACTION = "redirect:/schedulergroup";
		
	/** 
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性
	 **/
	public void setSchedulerGroupManager(SchedulerGroupManager manager) {
		this.schedulerGroupManager = manager;
	}
	
	/** 列表 */
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response,SchedulerGroup schedulerGroup) {
		PageRequest<Map> pageRequest = newPageRequest(request,DEFAULT_SORT_COLUMNS);
		//pageRequest.getFilters(); //add custom filters
		
		Page page = this.schedulerGroupManager.findByPageRequest(pageRequest);
		
		ModelAndView result = toModelAndView(page, pageRequest);
		result.addObject("schedulerGroup",schedulerGroup);
		result.setViewName("/schedulergroup/index");
		return result;
	}
	
	/** 进入新增 */
	@Override
	public ModelAndView _new(HttpServletRequest request,HttpServletResponse response,SchedulerGroup schedulerGroup) throws Exception {
		return new ModelAndView("/schedulergroup/new","schedulerGroup",schedulerGroup);
	}
	
	/** 显示 */
	@Override
	public ModelAndView show(@PathVariable java.lang.String id) throws Exception {
		SchedulerGroup schedulerGroup = (SchedulerGroup)schedulerGroupManager.getById(id);
		return new ModelAndView("/schedulergroup/show","schedulerGroup",schedulerGroup);
	}
	
	/** 编辑 */
	@Override
	public ModelAndView edit(@PathVariable java.lang.String id) throws Exception {
		SchedulerGroup schedulerGroup = (SchedulerGroup)schedulerGroupManager.getById(id);
		return new ModelAndView("/schedulergroup/edit","schedulerGroup",schedulerGroup);
	}
	
	/** 保存新增 */
	@Override
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,SchedulerGroup schedulerGroup) throws Exception {
		schedulerGroupManager.save(schedulerGroup);
		return new ModelAndView(LIST_ACTION);
	}
	
	/** 保存更新 */
	@Override
	public ModelAndView update(@PathVariable java.lang.String id,HttpServletRequest request,HttpServletResponse response) throws Exception {
		SchedulerGroup schedulerGroup = (SchedulerGroup)schedulerGroupManager.getById(id);
		bind(request,schedulerGroup);
		schedulerGroupManager.update(schedulerGroup);
		return new ModelAndView(LIST_ACTION);
	}
	
	/** 删除 */
	@Override
	public ModelAndView delete(@PathVariable java.lang.String id) {
		schedulerGroupManager.removeById(id);
		return new ModelAndView(LIST_ACTION);
	}

	/** 批量删除 */
	@Override
	public ModelAndView batchDelete(java.lang.String[] items) {
		for(int i = 0; i < items.length; i++) {
			schedulerGroupManager.removeById(items[i]);
		}
		return new ModelAndView(LIST_ACTION);
	}
	
}

