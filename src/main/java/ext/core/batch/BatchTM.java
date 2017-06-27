package ext.core.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.catalina.tribes.util.ExecutorFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ext.datasource.entity.TrxClass;
import ext.datasource.entity.TrxClassExample;
import ext.datasource.inf.ContractMapper;
import ext.datasource.inf.TrxClassMapper;

public class BatchTM {
	private static final  Scheduler workspace = init();
	private final static Logger logger = LogManager.getLogger(BatchTM.class.getName());
	private static final ArrayBlockingQueue<StartClassMessage> queue =new ArrayBlockingQueue(60);
	private static final ExecutorService service =  Executors.newSingleThreadExecutor();
	@Autowired
	private TrxClassMapper casDao;
	
	@Autowired
	private ContractMapper contDao;
	
	
	private static Scheduler init(){
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();  
		try {
		
			return schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			logger.error("init batch pool error!!");
			System.exit(0);
		}finally{
			service.execute(new JobConfigTM());
		}
		return null;
	}
	public void startWork(){
		// CLASS_STATE = 0  START LOAD
		Date now = new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		TrxClassExample casQuery = new TrxClassExample();
		casQuery.createCriteria().andClassStateEqualTo(0).andStartTimeGreaterThanOrEqualTo(now);
		List<TrxClass> classList=casDao.selectByExample(casQuery);
		for(TrxClass domain:classList){
			StartClassMessage scm = new StartClassMessage();
			try{
				Date startDate = domain.getStartTime();
				int hour  = domain.getStartHour();
				int min = domain.getStartMin();
				String yyyyMMdd = sdf.format(now).substring(0,10);
				if(yyyyMMdd.equals(sdf.format(startDate).substring(0,10))){
					String today=sdf.format(now);
					if(Integer.parseInt(today.substring(11,13))>hour)
						continue;
					else if(Integer.parseInt(today.substring(11,13))>hour && Integer.parseInt(today.substring(14,16))>min){
						continue;
					}
				}
				String schedule = domain.getStartSchedule();
				String classStartDate = sdf.format(startDate);
				
				scm.setDayWeek(schedule);
				scm.setGroup("class");
				scm.setIdentify(domain.getId()+"");
				scm.setHour(hour);
				scm.setMin(min);
				scm.setMonth(classStartDate.substring(5,7));
				scm.setYear(classStartDate.substring(0, 4));
				scm.setDay(classStartDate.substring(8,10));
			}catch (Exception e) {
				logger.error("the class encounter some error,please check "+domain.getId(),e);
				continue;
			}
			
			try {
				queue.put(scm);
			} catch (InterruptedException e) {
				logger.error("add class start job error and class id : "+domain.getId(),e);
			}
		}
		
		
	}
	public static ArrayBlockingQueue<StartClassMessage> getQueue() {
		return queue;
	}
	public static Scheduler getWorkspace() {
		return workspace;
	}
	public static void runStartWork(StartClassMessage scm) throws InterruptedException{
		queue.put(scm);
	}
	
	
	
}
