package ext.core.batch;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ext.util.helper.BigCont;

public class StartClassJob implements Job{
	private final static Logger logger = LogManager.getLogger(StartClassJob.class.getName());
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		StartClassMessage scm = (StartClassMessage) job.getJobDetail().getJobDataMap().get(BigCont.SCMESSAGE);
		logger.info("start the class start job:"+scm);
		int casId = scm.getIdentify();
		BatchTM.updateCasState(casId);;
		logger.info("class start job finish. class id :" + scm.getIdentify());
		
	}

}
