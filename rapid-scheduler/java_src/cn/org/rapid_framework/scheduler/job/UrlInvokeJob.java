package cn.org.rapid_framework.scheduler.job;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.org.rapid_framework.scheduler.model.SchedulerJob;
import cn.org.rapid_framework.scheduler.service.SchedulerJobManager;
import cn.org.rapid_framework.util.ApplicationContextHolder;

public class UrlInvokeJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		String name = jobDetail.getName();
		String group = jobDetail.getGroup();
		SchedulerJobManager manager = (SchedulerJobManager)ApplicationContextHolder.getBean("schedulerJobManager");
		SchedulerJob schedulerJob = manager.getById(new SchedulerJob(name,group));
		try {
			invokeUrl(schedulerJob.getUrl()+"?"+toUrlParams(schedulerJob));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String toUrlParams(SchedulerJob schedulerJob) {
		return null;
	}

	public static void invokeUrl(String stringUrl) throws IOException {
		URL url = new URL(stringUrl);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("X-RAPID-CRON", "true");
		conn.setConnectTimeout(30 * 1000);
		conn.setReadTimeout(30 * 1000);
		conn.connect();
		System.out.println(conn.getHeaderFields());
//		System.out.println(conn.getHeaderFields());
//		System.out.println("content:"+IOUtils.toString(conn.getInputStream(),"GBK"));
	}

}
