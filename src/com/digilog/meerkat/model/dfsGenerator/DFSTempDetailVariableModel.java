package com.digilog.meerkat.model.dfsGenerator;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

import javafx.collections.ObservableList;

public class DFSTempDetailVariableModel {
	
	ObservableList<DFSVariableModel> nextAttributeVariables;
	ObservableList<DFSVariableModel> contextListVariable;
	ObservableList<DFSVariableModel> metaDataVariables;
	
	public ObservableList<DFSVariableModel> getNextAttributeVariables() {
		return nextAttributeVariables;
	}
	public void setNextAttributeVariables(ObservableList<DFSVariableModel> nextAttributeVariables) {
		this.nextAttributeVariables = nextAttributeVariables;
	}
	public ObservableList<DFSVariableModel> getContextListVariable() {
		return contextListVariable;
	}
	public void setContextListVariable(ObservableList<DFSVariableModel> contextListVariable) {
		this.contextListVariable = contextListVariable;
	}
	public ObservableList<DFSVariableModel> getMetaDataVariables() {
		return metaDataVariables;
	}
	public void setMetaDataVariables(ObservableList<DFSVariableModel> metaDataVariables) {
		this.metaDataVariables = metaDataVariables;
	}
	
}
