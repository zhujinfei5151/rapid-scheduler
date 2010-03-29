/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */


package cn.org.rapid_framework.scheduler.controller;

import java.text.ParseException;
import java.util.Map;

import javacommon.base.BaseRestSpringController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.scheduler.job.SchedulerInstance;
import cn.org.rapid_framework.scheduler.job.UrlInvokeJob;
import cn.org.rapid_framework.scheduler.model.SchedulerJob;
import cn.org.rapid_framework.scheduler.service.SchedulerJobManager;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/schedulerjob")
public class SchedulerJobController extends BaseRestSpringController<SchedulerJob,java.lang.String>{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private SchedulerJobManager schedulerJobManager;
	
	private final String LIST_ACTION = "redirect:/schedulerjob";
	
	/** 
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性
	 **/
	public void setSchedulerJobManager(SchedulerJobManager manager) {
		this.schedulerJobManager = manager;
	}
	
	/** 列表 */
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response,SchedulerJob schedulerJob) {
		PageRequest<Map> pageRequest = newPageRequest(request,DEFAULT_SORT_COLUMNS);
		//pageRequest.getFilters(); //add custom filters
		
		Page page = this.schedulerJobManager.findByPageRequest(pageRequest);
		
		ModelAndView result = toModelAndView(page, pageRequest);
		result.addObject("schedulerJob",schedulerJob);
		result.setViewName("/schedulerjob/index");
		return result;
	}
	
	/** 进入新增 */
	@Override
	public ModelAndView _new(HttpServletRequest request,HttpServletResponse response,SchedulerJob schedulerJob) throws Exception {
		return new ModelAndView("/schedulerjob/new","schedulerJob",schedulerJob);
	}
	
	/** 显示 */
	@RequestMapping(value="/{jobName}/{groupName}",method=RequestMethod.GET)
	public ModelAndView show(@PathVariable java.lang.String jobName,@PathVariable String groupName) throws Exception {
		SchedulerJob schedulerJob = (SchedulerJob)schedulerJobManager.getById(new SchedulerJob(jobName,groupName));
		return new ModelAndView("/schedulerjob/show","schedulerJob",schedulerJob);
	}
	
	/** 编辑 */
	@RequestMapping(value="/{jobName}/{groupName}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable java.lang.String jobName,@PathVariable String groupName) throws Exception {
		SchedulerJob schedulerJob = (SchedulerJob)schedulerJobManager.getById(new SchedulerJob(jobName,groupName));
		return new ModelAndView("/schedulerjob/edit","schedulerJob",schedulerJob);
	}
	
	/** 保存新增 */
	@Override
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,SchedulerJob schedulerJob) throws Exception {
		schedulerJobManager.save(schedulerJob);
		SchedulerInstance.scheduleJob(schedulerJob);
		return new ModelAndView(LIST_ACTION);
	}
	
	/** 保存更新 */
	@RequestMapping(value="/{jobName}/{groupName}",method=RequestMethod.PUT)
	public ModelAndView update(@PathVariable java.lang.String jobName,@PathVariable String groupName,HttpServletRequest request,HttpServletResponse response) throws Exception {
		SchedulerJob schedulerJob = (SchedulerJob)schedulerJobManager.getById(new SchedulerJob(jobName,groupName));
		bind(request,schedulerJob);
		schedulerJobManager.update(schedulerJob);
		return new ModelAndView(LIST_ACTION);
	}
	
	/** 删除 */
	@RequestMapping(value="/{jobName}/{groupName}",method=RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable java.lang.String jobName,@PathVariable String groupName) {
		schedulerJobManager.removeById(new SchedulerJob(jobName,groupName));
		return new ModelAndView(LIST_ACTION);
	}

//	/** 批量删除 */
//	@Override
//	public ModelAndView batchDelete(java.lang.String[] items) {
//		for(int i = 0; i < items.length; i++) {
//			schedulerJobManager.removeById(items[i]);
//		}
//		return new ModelAndView(LIST_ACTION);
//	}
	
}

