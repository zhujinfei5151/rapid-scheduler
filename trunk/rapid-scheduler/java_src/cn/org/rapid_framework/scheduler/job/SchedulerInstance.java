package cn.org.rapid_framework.scheduler.job;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import cn.org.rapid_framework.scheduler.model.SchedulerJob;

public class SchedulerInstance {
	static Scheduler scheduler = null;
	
	public static Scheduler getScheduler() {
		if(scheduler == null) {
			try {
				scheduler = StdSchedulerFactory.getDefaultScheduler();
				scheduler.start();
			} catch (SchedulerException e) {
				throw new RuntimeException("error create scheduler",e);
			}
		}
		return scheduler;
	}

	public static void setScheduler(Scheduler scheduler) {
		SchedulerInstance.scheduler = scheduler;
	}

	public static void start() throws SchedulerException {
		scheduler = StdSchedulerFactory.getDefaultScheduler();
	}
	
	public static void shutdown() throws SchedulerException {
		scheduler.shutdown();
	}
	
	public static void scheduleJob(SchedulerJob schedulerJob) throws SchedulerException, ParseException {
		JobDetail job = new JobDetail(schedulerJob.getJobName(), schedulerJob.getGroupName(), UrlInvokeJob.class);
		Trigger trigger = new CronTrigger(schedulerJob.getJobName(), schedulerJob.getGroupName(),schedulerJob.getCron());
		SchedulerInstance.getScheduler().scheduleJob(job, trigger);
	}
}
