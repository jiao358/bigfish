package ext.core.batch;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ext.datasource.entity.ClassRel;
import ext.datasource.entity.ClassRelExample;
import ext.datasource.entity.Contract;
import ext.datasource.entity.TrxClass;
import ext.datasource.entity.TrxClassExample;
import ext.datasource.entity.TrxDuty;
import ext.datasource.inf.ClassRelMapper;
import ext.datasource.inf.ContractMapper;
import ext.datasource.inf.TrxClassMapper;
import ext.datasource.inf.TrxDutyMapper;

public class BatchTM {
	private final static Logger logger = LogManager.getLogger(BatchTM.class.getName());
	private static final ExecutorService service =  Executors.newFixedThreadPool(2);
	private static final  Scheduler workspace = init();
	private static final ArrayBlockingQueue<StartClassMessage> queue =new ArrayBlockingQueue(60);
	private static final ArrayBlockingQueue<StartDutyMessage> dutyMessage=  new ArrayBlockingQueue(70);
	
	private static final List<String> runningDutyList = new ArrayList<String>();


	private static TrxClassMapper casDao;
	private static ContractMapper contDao;
	private static ClassRelMapper classRelDao;
	private static TrxDutyMapper dutyDao;
	
	private static Scheduler init(){
		logger.info("Batch init...");
		try {
			return StdSchedulerFactory.getDefaultScheduler();
		} catch (SchedulerException e) {
			logger.error("init batch pool error!!");
			System.exit(0);
		}finally{
			
			service.execute(new JobConfigTM());
			service.execute(new DutyConfigTM());
		}
		return null;
	}
	/**
	 * delete the all job include class and duty
	 * @param id
	 */
	public static boolean removeJob(int id){
		boolean flag = true;
		synchronized(runningDutyList){
			String classJob = id+"class";
			String dutyJob = id+"duty";
			if(runningDutyList.contains(classJob)){
				JobKey key = new JobKey(id+"","class");
				try {
					workspace.deleteJob(key);
				} catch (SchedulerException e) {
					logger.error("delete the class job error class id:"+id,e);
					flag =false;
				}
			}
			
			if(runningDutyList.contains(dutyJob)){
				JobKey key = new JobKey(id+"","duty");
				try {
					workspace.deleteJob(key);
				} catch (SchedulerException e) {
					logger.error("delete the duty job error class id:"+id,e);
					flag =false;
				}
			}
		}
		return flag;
	}
	public void startWork(){
		// CLASS_STATE = 0  START LOAD
		Date now = new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		TrxClassExample casQuery = new TrxClassExample();
		casQuery.createCriteria().andClassStateEqualTo(0).andStartTimeGreaterThan(now);
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
				scm.setIdentify(domain.getId());
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
		
		
		casQuery = new TrxClassExample();
		casQuery.createCriteria().andClassStateEqualTo(1);
		List<TrxClass> dutyList =casDao.selectByExample(casQuery);
		for(TrxClass dutyDomain : dutyList){
			StartDutyMessage sdm = new StartDutyMessage();
			sdm.setClassId(dutyDomain.getId());
			String[] time = dutyDomain.getStartSchedule().split(",");
			int[] classDays = new int[time.length];
			for (int i = 0; i < time.length; i++) {
				classDays[i] = Integer.parseInt(time[i]);
			}
			Arrays.sort(classDays);

			String daliyCron = "";
			for(int i:classDays){
				int temp = (i+1)%7;
				if(temp==0)
					temp=7;
				daliyCron +=temp+",";
			}
			
			daliyCron = "0 "+dutyDomain.getStartMin()+" "+dutyDomain.getStartMin()+" ? * "+daliyCron;
			sdm.setCron(daliyCron);
			try {
				dutyMessage.put(sdm);
			} catch (InterruptedException e) {
				logger.error("duty job init error class id :"+dutyDomain.getId(),e);
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
	
	public static void scheduleJob(JobDetail job,Trigger trigger) throws SchedulerException{
		workspace.scheduleJob(job,trigger);
	}
	
	
	
	public static TrxClassMapper getCasDao() {
		return casDao;
	}
	@Autowired
	public  void setCasDao(TrxClassMapper casDao) {
		BatchTM.casDao = casDao;
	}
	public static ContractMapper getContDao() {
		return contDao;
	}
	@Autowired
	public  void setContDao(ContractMapper contDao) {
		BatchTM.contDao = contDao;
	}
	public static ClassRelMapper getClassRelDao() {
		return classRelDao;
	}
	@Autowired
	public  void setClassRelDao(ClassRelMapper classRelDao) {
		BatchTM.classRelDao = classRelDao;
	}
	public static TrxDutyMapper getDutyDao() {
		return dutyDao;
	}
	@Autowired
	public  void setDutyDao(TrxDutyMapper dutyDao) {
		BatchTM.dutyDao = dutyDao;
	}
	public static ArrayBlockingQueue<StartDutyMessage> getDutymessage() {
		return dutyMessage;
	}
	
	public static List<String> getRunningdutylist() {
		return runningDutyList;
	}
	/**
	 * when class start , the job will update the class state
	 * @param id
	 */
	
	public static void updateCasState(int id){
		TrxClassExample casQuery  = new TrxClassExample();
		TrxClass domain = casDao.selectByPrimaryKey(id);
		domain.setClassState(1);;
	}
	
	/**
	 * get the TrxClass domain
	 */
	public static TrxClass getTrxClass(int id){
		TrxClass domain = casDao.selectByPrimaryKey(id);
		return domain;
	}
	public static void updateTrxClass(TrxClass domain){
		casDao.updateByPrimaryKey(domain);
	}
	@Transactional
	public static void dutyJobTask(int casId){
		ClassRelExample crQuery = new ClassRelExample();
		crQuery.createCriteria().andClassIdEqualTo(casId);
		List<ClassRel> crList = classRelDao.selectByExample(crQuery);
		TrxClass domain = casDao.selectByPrimaryKey(casId);
		BigDecimal rate =domain.getClassRate();
		for(ClassRel relDomain:crList){
			int contId = relDomain.getContractId();
			Contract cont = contDao.selectByPrimaryKey(contId);
			BigDecimal balance=cont.getContractBalance();
			BigDecimal amt = cont.getContractAmt();
			balance.add(rate);
			cont.setContractBalance(balance);
			if(amt.compareTo(balance)==-1){
				cont.setContractState(3);
			}
			contDao.updateByPrimaryKey(cont);
			TrxDuty duty = new TrxDuty();
			duty.setClassId(casId);
			duty.setCustomerId(relDomain.getCustomerId());
			duty.setDutyCost(rate);
			duty.setDutyStrategy(0);
			duty.setGenerateDate(new Date());
			dutyDao.insert(duty);
		}
		
	}
	
	
}
