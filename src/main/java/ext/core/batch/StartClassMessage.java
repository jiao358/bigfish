package ext.core.batch;

public class StartClassMessage {
	private String year;
	private String month;
	private String day;
	private int hour;
	private int min;
	private String dayWeek;
	
	private final String group = "class";
	private int identify;
	private int total;
	
	
	
	
	@Override
	public String toString() {
		return "StartClassMessage [year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", min="
				+ min + ", dayWeek=" + dayWeek + ", group=" + group + ", identify=" + identify + ", total=" + total
				+ "]";
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getDayWeek() {
		return dayWeek;
	}
	public void setDayWeek(String dayWeek) {
		this.dayWeek = dayWeek;
	}
	public String getGroup() {
		return group;
	}

	public int getIdentify() {
		return identify;
	}
	public void setIdentify(int identify) {
		this.identify = identify;
	}

	
	
	
	
	
}
