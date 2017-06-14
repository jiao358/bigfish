package ext.core.domain;

import java.util.List;

import ext.datasource.entity.SModule;

public class FontModule {
	private SModule parent;
	private List<SModule> childrens;
	public SModule getParent() {
		return parent;
	}
	public void setParent(SModule parent) {
		this.parent = parent;
	}
	public List<SModule> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<SModule> childrens) {
		this.childrens = childrens;
	}
	
	
	
}
