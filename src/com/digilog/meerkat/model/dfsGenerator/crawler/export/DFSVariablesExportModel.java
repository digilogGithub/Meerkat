package com.digilog.meerkat.model.dfsGenerator.crawler.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSVariablesExportModel implements Cloneable {
	private String name;
	private ObservableList<DFSVariableModel> dfsVariables;
	
	public DFSVariablesExportModel() {
		dfsVariables = FXCollections.observableArrayList();
	}

	@XmlAttribute
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@XmlElement(name = "dfsvariable")
	public ObservableList<DFSVariableModel> getDFSVariableList() {
		return dfsVariables;
	}
	
	public void setDFSVariableList(ObservableList<DFSVariableModel> dfsVariables) {
		this.dfsVariables=dfsVariables;
	}
	
	public DFSVariablesExportModel clone() throws CloneNotSupportedException {
		DFSVariablesExportModel cloneModel = (DFSVariablesExportModel) super.clone();
		ObservableList<DFSVariableModel> deepCloneModel = FXCollections.observableArrayList();
		for(DFSVariableModel temp : dfsVariables)
			deepCloneModel.add(temp.clone());
		cloneModel.dfsVariables = deepCloneModel;
		return cloneModel;
	}
}
