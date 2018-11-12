package com.digilog.meerkat.model.dfsGenerator;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSDetailConfigResultModel {
	
	private boolean setCheck;
	private  ObservableList<DFSVariableModel> nextVariableModels;
	private  ObservableList<DFSVariableModel> contextListVariableModels;
	private  ObservableList<DFSVariableModel> metaDataVariableModels;
	
	public DFSDetailConfigResultModel() {
		setCheck = false;
		nextVariableModels = FXCollections.observableArrayList();
		contextListVariableModels = FXCollections.observableArrayList();
		metaDataVariableModels = FXCollections.observableArrayList();
	}

	public boolean isSetCheck() {
		return setCheck;
	}

	public void setSetCheck(boolean setCheck) {
		this.setCheck = setCheck;
	}

	public  ObservableList<DFSVariableModel> getNextVariableModels() {
		return nextVariableModels;
	}

	public void setNextVariableModels( ObservableList<DFSVariableModel> nextVariableModels) {
		this.nextVariableModels = nextVariableModels;
	}

	public  ObservableList<DFSVariableModel> getContextListVariableModels() {
		return contextListVariableModels;
	}

	public void setContextListVariableModels( ObservableList<DFSVariableModel> contextListVariableModels) {
		this.contextListVariableModels = contextListVariableModels;
	}

	public  ObservableList<DFSVariableModel> getMetaDataVariableModels() {
		return metaDataVariableModels;
	}

	public void setMetaDataVariableModels( ObservableList<DFSVariableModel> metaDataVariableModels) {
		this.metaDataVariableModels = metaDataVariableModels;
	}

}
