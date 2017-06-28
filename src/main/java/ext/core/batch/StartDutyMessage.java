package ext.core.batch;

public class StartDutyMessage {
	private int classId;
	private final String group = "duty";
	private String cron;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getGroup() {
		return group;
	}
	
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	
	
	
}
