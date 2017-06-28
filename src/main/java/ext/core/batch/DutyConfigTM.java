package ext.core.batch;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;

import ext.util.helper.BigCont;

public class DutyConfigTM implements Runnable{
	private final static Logger logger = LogManager.getLogger(DutyConfigTM.class.getName());
	@Override
	public void run() {
		
		ArrayBlockingQueue<StartDutyMessage> queue = BatchTM.getDutymessage();
		while(true){
			try {
				StartDutyMessage message = queue.take();
				int casId = message.getClassId();
				String group = message.getGroup();
				String cron = message.getCron();
				List<String> lock = BatchTM.getRunningdutylist();
				
				synchronized(lock){
					if(lock.contains(message.getClassId()+message.getGroup())){
						logger.warn("the duty job duplicate class id:"+casId);
					}else{
						try{
							lock.add(casId+group);
							JobDetail job = JobBuilder.newJob(StartDutyJob.class).withIdentity(casId+"",group).build();
							job.getJobDataMap().put(BigCont.SDMESSAGE, casId);
							CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(casId+"", group).withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
							BatchTM.scheduleJob(job, trigger);
						} catch (SchedulerException e) {
							logger.error("the duty task schedule error class id:"+casId,e);
						}
					}
					
					
				}
			
				
				
			} catch (InterruptedException e) {
				logger.error("the duty job receive error",e);
			}
			
			
		}
		
	}

}
