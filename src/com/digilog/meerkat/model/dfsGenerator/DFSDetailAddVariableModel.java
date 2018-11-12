package com.digilog.meerkat.model.dfsGenerator;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

public class DFSDetailAddVariableModel {
	
	private DFSVariableModel dfsVariable;
	
	private boolean all;
	private boolean nextattribute;
	private boolean contextlist;
	private boolean metadata;
	
	public DFSVariableModel getDfsVariable() {
		return dfsVariable;
	}
	public void setDfsVariable(DFSVariableModel dfsVariable) {
		this.dfsVariable = dfsVariable;
	}
	
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
	}
	
	public boolean isNextattribute() {
		return nextattribute;
	}
	public void setNextattribute(boolean nextattribute) {
		this.nextattribute = nextattribute;
	}
	
	public boolean isContextlist() {
		return contextlist;
	}
	public void setContextlist(boolean contextlist) {
		this.contextlist = contextlist;
	}
	
	public boolean isMetadata() {
		return metadata;
	}
	public void setMetadata(boolean metadata) {
		this.metadata = metadata;
	}
}
