package ext.core.batch;

import java.util.concurrent.ArrayBlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class JobConfigTM implements Runnable {
	private final static Logger logger = LogManager.getLogger(JobConfigTM.class.getName());
	@Override
	public void run() {
		ArrayBlockingQueue<StartClassMessage> queue  = BatchTM.getQueue();
		while(true){
			try {
				StartClassMessage scm = queue.take();
				
				
				
			} catch (InterruptedException e) {
				logger.error("execute scm error",e);
			}
			
			
		}
	}

}
