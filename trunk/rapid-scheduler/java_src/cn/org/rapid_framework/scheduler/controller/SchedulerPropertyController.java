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
@RequestMapping("/schedulerproperty")
public class SchedulerPropertyController extends BaseRestSpringController<SchedulerProperty,java.lang.String>{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private SchedulerPropertyManager schedulerPropertyManager;
	
	private final String LIST_ACTION = "redirect:/schedulerproperty";
		
	/** 
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性
	 **/
	public void setSchedulerPropertyManager(SchedulerPropertyManager manager) {
		this.schedulerPropertyManager = manager;
	}
	
	/** 列表 */
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response,SchedulerProperty schedulerProperty) {
		PageRequest<Map> pageRequest = newPageRequest(request,DEFAULT_SORT_COLUMNS);
		//pageRequest.getFilters(); //add custom filters
		
		Page page = this.schedulerPropertyManager.findByPageRequest(pageRequest);
		
		ModelAndView result = toModelAndView(page, pageRequest);
		result.addObject("schedulerProperty",schedulerProperty);
		result.setViewName("/schedulerproperty/index");
		return result;
	}
	
	/** 进入新增 */
	@Override
	public ModelAndView _new(HttpServletRequest request,HttpServletResponse response,SchedulerProperty schedulerProperty) throws Exception {
		return new ModelAndView("/schedulerproperty/new","schedulerProperty",schedulerProperty);
	}
	
	/** 显示 */
	@Override
	public ModelAndView show(@PathVariable java.lang.String id) throws Exception {
		SchedulerProperty schedulerProperty = (SchedulerProperty)schedulerPropertyManager.getById(id);
		return new ModelAndView("/schedulerproperty/show","schedulerProperty",schedulerProperty);
	}
	
	/** 编辑 */
	@Override
	public ModelAndView edit(@PathVariable java.lang.String id) throws Exception {
		SchedulerProperty schedulerProperty = (SchedulerProperty)schedulerPropertyManager.getById(id);
		return new ModelAndView("/schedulerproperty/edit","schedulerProperty",schedulerProperty);
	}
	
	/** 保存新增 */
	@Override
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,SchedulerProperty schedulerProperty) throws Exception {
		schedulerPropertyManager.save(schedulerProperty);
		return new ModelAndView(LIST_ACTION);
	}
	
	/** 保存更新 */
	@Override
	public ModelAndView update(@PathVariable java.lang.String id,HttpServletRequest request,HttpServletResponse response) throws Exception {
		SchedulerProperty schedulerProperty = (SchedulerProperty)schedulerPropertyManager.getById(id);
		bind(request,schedulerProperty);
		schedulerPropertyManager.update(schedulerProperty);
		return new ModelAndView(LIST_ACTION);
	}
	
	/** 删除 */
	@Override
	public ModelAndView delete(@PathVariable java.lang.String id) {
		schedulerPropertyManager.removeById(id);
		return new ModelAndView(LIST_ACTION);
	}

	/** 批量删除 */
	@Override
	public ModelAndView batchDelete(java.lang.String[] items) {
		for(int i = 0; i < items.length; i++) {
			schedulerPropertyManager.removeById(items[i]);
		}
		return new ModelAndView(LIST_ACTION);
	}
	
}

