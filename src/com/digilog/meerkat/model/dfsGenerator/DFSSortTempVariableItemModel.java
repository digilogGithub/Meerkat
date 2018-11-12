package com.digilog.meerkat.model.dfsGenerator;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

public class DFSSortTempVariableItemModel implements Cloneable{
	
	private String name;
	private DFSVariableModel variable;
	
	public DFSSortTempVariableItemModel(String name, DFSVariableModel variable) {
		this.name=name;
		this.variable=variable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DFSVariableModel getVariable() {
		return variable;
	}

	public void setVariable(DFSVariableModel variable) {
		this.variable = variable;
	}
	
	public DFSSortTempVariableItemModel clone() throws CloneNotSupportedException {
		DFSSortTempVariableItemModel cloneData = (DFSSortTempVariableItemModel) super.clone();
		return cloneData;
	}
}
