package com.digilog.meerkat.model.dfsGenerator.xml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSGeneratorXMLAllInfoModel implements Cloneable{
	
	private boolean markInitData;
	private boolean exitSaveFile;
	private boolean allDone;
	private boolean createXMLFile;
	private boolean createEDLConfig;
	private boolean createMode;
	private String SEMIFileName;
	private String eDataRealmFileName;
	
	private ObservableList<DFSGeneratorXMLInfoModel> dfsGeneratorXMLInfoModel;
	
	public DFSGeneratorXMLAllInfoModel() {
		dfsGeneratorXMLInfoModel = FXCollections.observableArrayList();
	}
	
	public DFSGeneratorXMLAllInfoModel(boolean markInitData) {
		this.markInitData = markInitData;
		dfsGeneratorXMLInfoModel = FXCollections.observableArrayList();
	}
	public DFSGeneratorXMLAllInfoModel(boolean createMode, boolean markInitData, boolean createXMLFile, boolean createEDLConfig
			, String SEMIFileName
			, String eDataRealmFileName) {
		this.createMode = createMode;
		this.markInitData = markInitData;
		this.createXMLFile = createXMLFile;
		this.createEDLConfig = createEDLConfig;
		this.SEMIFileName = SEMIFileName;
		this.eDataRealmFileName = eDataRealmFileName;
		dfsGeneratorXMLInfoModel = FXCollections.observableArrayList();
	}
	
	public boolean isCreateMode() {
		return createMode;
	}

	public void setCreateMode(boolean createMode) {
		this.createMode = createMode;
	}
	
	public boolean isExitSaveFile() {
		return exitSaveFile;
	}

	public void setExitSaveFile(boolean exitSaveFile) {
		this.exitSaveFile = exitSaveFile;
	}

	public boolean isMarkInitData() {
		return markInitData;
	}

	public void setMarkInitData(boolean markInitData) {
		this.markInitData = markInitData;
	}
	
	public boolean isAllDone() {
		return allDone;
	}

	public void setAllDone(boolean allDone) {
		this.allDone = allDone;
	}
	
//	public boolean isAllCancel() {
//		return allCancel;
//	}
//
//	public void setAllCancel(boolean allCancel) {
//		this.allCancel = allCancel;
//	}

	public boolean isCreateXMLFile() {
		return createXMLFile;
	}

	public void setCreateXMLFile(boolean createXMLFile) {
		this.createXMLFile = createXMLFile;
	}

	public boolean isCreateEDLConfig() {
		return createEDLConfig;
	}

	public void setCreateEDLConfig(boolean createEDLConfig) {
		this.createEDLConfig = createEDLConfig;
	}

	public String getSEMIFileName() {
		return SEMIFileName;
	}

	public void setSEMIFileName(String sEMIFileName) {
		SEMIFileName = sEMIFileName;
	}

	public String getEDataRealmFileName() {
		return eDataRealmFileName;
	}

	public void setEDataRealmFileName(String eDataRealmFileName) {
		this.eDataRealmFileName = eDataRealmFileName;
	}

	public ObservableList<DFSGeneratorXMLInfoModel> getDfsGeneratorXMLInfoModel() {
		return dfsGeneratorXMLInfoModel;
	}

	public void setDfsGeneratorXMLInfoModel(ObservableList<DFSGeneratorXMLInfoModel> dfsGeneratorXMLInfoModel) {
		this.dfsGeneratorXMLInfoModel = dfsGeneratorXMLInfoModel;
	}
	
	public DFSGeneratorXMLAllInfoModel clone() throws CloneNotSupportedException {
		DFSGeneratorXMLAllInfoModel cloneModel = (DFSGeneratorXMLAllInfoModel) super.clone();
		ObservableList<DFSGeneratorXMLInfoModel> deepCloneModel = FXCollections.observableArrayList();
		for(DFSGeneratorXMLInfoModel temp : dfsGeneratorXMLInfoModel)
			deepCloneModel.add(temp.clone());
		cloneModel.dfsGeneratorXMLInfoModel = deepCloneModel;
		return cloneModel;
	}
}
