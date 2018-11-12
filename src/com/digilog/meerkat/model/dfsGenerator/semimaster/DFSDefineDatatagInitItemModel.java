package com.digilog.meerkat.model.dfsGenerator.semimaster;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSDefineDatatagInitItemModel implements Cloneable {

	private SimpleStringProperty typeName;
	private SimpleStringProperty levelName;
	private ObservableList<DFSVariableItemModel> variables;
	
	public DFSDefineDatatagInitItemModel() {
		typeName = new SimpleStringProperty();
		levelName = new SimpleStringProperty();
		variables = FXCollections.observableArrayList();
	}

	public DFSDefineDatatagInitItemModel(String typeName, String levelName,ObservableList<DFSVariableItemModel> variables) {
		this.typeName = new SimpleStringProperty(typeName);
		this.levelName = new SimpleStringProperty(levelName);
		this.variables = variables;
	}

	// type name
	public String getTypeName() {
		return typeName.get();
	}

	public void setTypeName(String typeName) {
		this.typeName.set(typeName);
	}

	public SimpleStringProperty typeNameProperty() {
		return typeName;
	}

	// level name
	public String getLevelName() {
		return levelName.get();
	}

	public void setLevelName(String levelName) {
		this.levelName.set(levelName);
	}

	public SimpleStringProperty levelNameProperty() {
		return levelName;
	}
	
	public ObservableList<DFSVariableItemModel> getDFSSemiVariableModels() {
		return variables;
	}
	
	public void setDFSSemiVariableModels(ObservableList<DFSVariableItemModel> variables) {
		this.variables=variables;
	}
	
	public DFSDefineDatatagInitItemModel clone() throws CloneNotSupportedException {
		DFSDefineDatatagInitItemModel cloneModel = (DFSDefineDatatagInitItemModel) super.clone();
		ObservableList<DFSVariableItemModel> cloneDeep = FXCollections.observableArrayList();
		for(DFSVariableItemModel temp : cloneModel.getDFSSemiVariableModels())
			cloneDeep.add(temp.clone());
		cloneModel.variables =cloneDeep;
		return cloneModel;	
	}
}
