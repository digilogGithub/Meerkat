package com.digilog.meerkat.model.dfsGenerator.semimaster;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSDefineInitModel implements Cloneable{
	
	private ObservableList<DFSVariableItemModel> semiMasterItemInitData;
	private ObservableList<DFSDefineDatatagInitItemModel> semiDatatagListInitData;
	private ObservableList<String> sortList;
	
	public DFSDefineInitModel() {
		semiMasterItemInitData = FXCollections.observableArrayList();
		semiDatatagListInitData = FXCollections.observableArrayList();
		sortList = FXCollections.observableArrayList();
	}
	
	public DFSDefineInitModel(ObservableList<DFSVariableItemModel> semiMasterItemInitData, ObservableList<DFSDefineDatatagInitItemModel> semiDatatagListInitData ) {
		this.semiMasterItemInitData=semiMasterItemInitData;
		this.semiDatatagListInitData=semiDatatagListInitData;
	}
	
	public DFSDefineInitModel(ObservableList<String> sortList, ObservableList<DFSVariableItemModel> semiMasterItemInitData ,ObservableList<DFSDefineDatatagInitItemModel> semiDatatagListInitData ) {
		this.sortList=sortList;
		this.semiMasterItemInitData=semiMasterItemInitData;
		this.semiDatatagListInitData=semiDatatagListInitData;
	}

	
	public ObservableList<String> getSortList() {
		return sortList;
	}

	public void setSortList(ObservableList<String> sortList) {
		this.sortList = sortList;
	}

	public ObservableList<DFSVariableItemModel> getSemiMasterItemInitData() {
		return semiMasterItemInitData;
	}

	public void setSemiMasterItemInitData(ObservableList<DFSVariableItemModel> semiMasterItemInitData) {
		this.semiMasterItemInitData = semiMasterItemInitData;
	}

	public ObservableList<DFSDefineDatatagInitItemModel> getSemiDatatagListInitData() {
		return semiDatatagListInitData;
	}

	public void setSemiDatatagListInitData(ObservableList<DFSDefineDatatagInitItemModel> semiDatatagListInitData) {
		this.semiDatatagListInitData = semiDatatagListInitData;
	}
	
	public DFSDefineInitModel clone() throws CloneNotSupportedException {
		DFSDefineInitModel initData = (DFSDefineInitModel) super.clone();	
		return initData;	
	}
	

}
