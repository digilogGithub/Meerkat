package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class DFSVariablesImportModel implements Cloneable {
	private String name;
	private ArrayList<DFSVariableImportModel> dfsVariables;

	@XmlAttribute (name = "name")
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@XmlElement(name = "dfsvariable")
	public ArrayList<DFSVariableImportModel> getDFSVariableList() {
		return dfsVariables;
	}
	
	public void setDFSVariableList(ArrayList<DFSVariableImportModel> dfsVariables) {
		this.dfsVariables=dfsVariables;
	}
	
	public DFSVariablesImportModel clone() throws CloneNotSupportedException {
		DFSVariablesImportModel cloneModel = (DFSVariablesImportModel) super.clone();
		ArrayList<DFSVariableImportModel> deepCloneModel = new ArrayList<>();
		for(DFSVariableImportModel temp : dfsVariables)
			deepCloneModel.add(temp.clone());
		cloneModel.dfsVariables = deepCloneModel;
		return cloneModel;
	}
}
