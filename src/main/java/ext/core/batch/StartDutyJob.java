package ext.core.batch;

import java.math.BigDecimal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ext.datasource.entity.TrxClass;
import ext.util.helper.BigCont;

public class StartDutyJob implements Job{
	private final static Logger logger = LogManager.getLogger(StartDutyJob.class.getName());

	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		
		int casId = Integer.parseInt(job.getJobDetail().getJobDataMap().get(BigCont.SDMESSAGE).toString());
		TrxClass domain=BatchTM.getTrxClass(casId);
		int state= domain.getClassState();
		if(state==3){
			logger.warn("the class state is reover!");
			return;
		}
		if(state==0){
			domain.setClassState(1);
		}
		int currentSchool = domain.getCurrentSchool();
		int school = domain.getSchool();
		BigDecimal rage = domain.getClassRate();
		
		if(currentSchool<school){
			currentSchool ++;
			domain.setCurrentSchool(currentSchool);
			BatchTM.updateTrxClass(domain);
			//now start to deal with duty table
			BatchTM.dutyJobTask(casId);
		}
		logger.info("duty job finish class id:"+casId);
	}

}
