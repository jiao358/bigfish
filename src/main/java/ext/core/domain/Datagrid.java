package ext.core.domain;

import java.util.List;

public class Datagrid {
	private long total ;
	private List rows;

	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
