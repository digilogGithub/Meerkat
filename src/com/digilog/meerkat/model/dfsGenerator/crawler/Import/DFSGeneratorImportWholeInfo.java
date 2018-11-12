package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineInitModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLAllInfoModel;

import javafx.collections.ObservableList;

public class DFSGeneratorImportWholeInfo {
	
	private DFSGeneratorXMLAllInfoModel dfsXMLALLInfo;
	private ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList;
	private DFSDefineInitModel semiMasterInitData;
	
	public DFSGeneratorImportWholeInfo(DFSGeneratorXMLAllInfoModel dfsXMLALLInfo, DFSDefineInitModel semiMasterInitData, ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList) {
		this.dfsXMLALLInfo = dfsXMLALLInfo;
		this.databaseSourceModelList = databaseSourceModelList;
		this.semiMasterInitData = semiMasterInitData;
	}
	
	public DFSGeneratorXMLAllInfoModel getDfsXMLALLInfo() {
		return dfsXMLALLInfo;
	}
	public void setDfsXMLALLInfo(DFSGeneratorXMLAllInfoModel dfsXMLALLInfo) {
		this.dfsXMLALLInfo = dfsXMLALLInfo;
	}
	
	public DFSDefineInitModel getSemiMasterInitData() {
		return semiMasterInitData;
	}

	public void setSemiMasterInitData(DFSDefineInitModel semiMasterInitData) {
		this.semiMasterInitData = semiMasterInitData;
	}

	public ObservableList<DFSGeneratorAndDatabaseListModel> getDatabaseSourceModelList() {
		return databaseSourceModelList;
	}
	public void setDatabaseSourceModelList(ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList) {
		this.databaseSourceModelList = databaseSourceModelList;
	}

}
