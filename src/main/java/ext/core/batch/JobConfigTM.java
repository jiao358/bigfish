package ext.core.batch;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
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

public class JobConfigTM implements Runnable {
	private final static Logger logger = LogManager.getLogger(JobConfigTM.class.getName());

	@Override
	public void run() {
		ArrayBlockingQueue<StartClassMessage> queue = BatchTM.getQueue();
		while (true) {
			try {
				StartClassMessage scm = queue.take();
				logger.info("deal with class job class id :"+scm.getIdentify());
				String dayStragety = scm.getDayWeek();
				String[] time = dayStragety.split(",");
				int total = scm.getTotal();
				Calendar calendar = Calendar.getInstance();
				calendar.set(Integer.valueOf(scm.getYear()), Integer.parseInt(scm.getMonth()) - 1,
						Integer.valueOf(scm.getDay()), scm.getHour(), scm.getMin());
				int[] classDays = new int[time.length];
				for (int i = 0; i < time.length; i++) {
					classDays[i] = Integer.parseInt(time[i]);
				}
				Arrays.sort(classDays);

				int currentDate = calendar.get(Calendar.DAY_OF_WEEK);
				if (currentDate == 1) {
					currentDate = 7;
				} else {
					currentDate -= 1;
				}
				int sum = 0;
				while (total != 0) {
					int index = Arrays.binarySearch(classDays, currentDate);
					if (index < 0) {
						sum += 1;
					} else {
						if (sum == 0) {
							sum -= 1;
						}
						total -= 1;
					}
				
					sum++;
					currentDate = (currentDate + 1) % 7;
					if (currentDate == 0) {
						currentDate = 7;
					}
				}
				String daliyCron = "";
				for(int i:classDays){
					int temp = (i+1)%7;
					if(temp==0)
						temp=7;
					daliyCron +=temp+",";
				}
				daliyCron = daliyCron.substring(0, daliyCron.length()-1);
				calendar.add(Calendar.DATE, sum-1);
				String startCron = BigCont.STARTCRON+" "+scm.getDay()+" "+scm.getMonth()+" ?";
				daliyCron = "0 "+scm.getMin()+" "+scm.getHour()+" ? * "+daliyCron;

				List<String> lock = BatchTM.getRunningdutylist();
				scm.setDutyCron(daliyCron);
				synchronized(lock){
					if(lock.contains(scm.getIdentify()+scm.getGroup())){
						logger.warn("the class job duplicate class id:"+scm.getIdentify());
					}else{
						lock.add(scm.getIdentify()+scm.getGroup());
						try{
							JobDetail job = JobBuilder.newJob(StartClassJob.class).withIdentity(scm.getIdentify()+"",scm.getGroup()).build();
							job.getJobDataMap().put(BigCont.SCMESSAGE, scm);
							CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(scm.getIdentify()+"", scm.getGroup()).withSchedule(CronScheduleBuilder.cronSchedule(startCron)).build();
							BatchTM.scheduleJob(job, trigger);
						}catch (SchedulerException e) {
							logger.error("schedule scm error", e);
						}
					}
				}

			} catch (InterruptedException e) {
				logger.error("execute scm error", e);
			} 
		}
	}

}
