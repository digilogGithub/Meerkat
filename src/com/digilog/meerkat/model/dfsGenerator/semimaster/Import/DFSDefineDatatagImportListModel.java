package com.digilog.meerkat.model.dfsGenerator.semimaster.Import;

import java.util.ArrayList;
import java.util.List;

public class DFSDefineDatatagImportListModel implements Cloneable {
	String type;
	String level;
	List<String> variableList;
	
	public DFSDefineDatatagImportListModel(String type, String level) {
		this.type=type;
		this.level=level;
		variableList = new ArrayList<String>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<String> getVariableList() {
		return variableList;
	}

	public void setVariableList(List<String> variableList) {
		this.variableList = variableList;
	}
	
	public DFSDefineDatatagImportListModel clone() throws CloneNotSupportedException {
		DFSDefineDatatagImportListModel clone = (DFSDefineDatatagImportListModel) super.clone();
		List<String> cloneDeep = new ArrayList<String>();
		for(String name : variableList)
			cloneDeep.add(name);
		clone.variableList = cloneDeep;
		return clone;
	}
}
