package ext.core.domain;

import java.util.List;

public class Datagrid {
	private long totoal ;
	private List rows;
	public long getTotoal() {
		return totoal;
	}
	public void setTotoal(long totoal) {
		this.totoal = totoal;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
