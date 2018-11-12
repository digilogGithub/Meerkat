package com.digilog.meerkat.model.dfsGenerator.crawler.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSPartitionModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSPartitionsExportModel implements Cloneable {

	private String name;
	private ObservableList<DFSPartitionModel> dfspartitions;
	
	public DFSPartitionsExportModel() {
		dfspartitions = FXCollections.observableArrayList();
	}
	
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "dfspartitions")
	public ObservableList<DFSPartitionModel> getDFSPartitionList() {
		return dfspartitions;
	}
	public void setDFSPartitionList(ObservableList<DFSPartitionModel> dfspartitions) {
		this.dfspartitions = dfspartitions;
	}
	
	public DFSPartitionsExportModel clone() throws CloneNotSupportedException {
		DFSPartitionsExportModel cloneModel = (DFSPartitionsExportModel) super.clone();
		ObservableList<DFSPartitionModel> deepCloneModel = FXCollections.observableArrayList();
		for(DFSPartitionModel temp : dfspartitions)
				deepCloneModel.add(temp.clone());
		cloneModel.dfspartitions = deepCloneModel;
		return cloneModel;
	}
}
