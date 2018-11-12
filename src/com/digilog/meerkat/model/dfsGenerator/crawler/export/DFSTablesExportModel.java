package com.digilog.meerkat.model.dfsGenerator.crawler.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSTableModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSTablesExportModel implements Cloneable{
	
	private String name;
	private ObservableList<DFSTableModel> dfsTables;
	
	public DFSTablesExportModel() {
		dfsTables = FXCollections.observableArrayList();
	}

	@XmlAttribute
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@XmlElement(name = "dfstable")
	public ObservableList<DFSTableModel> getDFSTableList() {
		return dfsTables;
	}
	
	public void setDFSTableList(ObservableList<DFSTableModel> dfsTables) {
		this.dfsTables=dfsTables;
	}
	
	public DFSTablesExportModel clone() throws CloneNotSupportedException {
		DFSTablesExportModel cloneModel = (DFSTablesExportModel) super.clone();
		ObservableList<DFSTableModel> deepCloneModel = FXCollections.observableArrayList();
		for(DFSTableModel temp : dfsTables)
				deepCloneModel.add(temp.clone());
		cloneModel.dfsTables = deepCloneModel;
		return cloneModel;
	}

}
