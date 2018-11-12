package com.digilog.meerkat.model.dfsGenerator.crawler.export;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DFSDatatagExportModel implements Cloneable {
	private String data_tag_name;	
	private ObservableList<DFSMethodExportModel> dfsmethods;

	public DFSDatatagExportModel() {
		dfsmethods=FXCollections.observableArrayList();
	}
	
	// data_tag_name
	@XmlAttribute (name="name")
	public String getData_tag_name() {
		return data_tag_name;
	}

	public void setData_tag_name(String data_tag_name) {
		this.data_tag_name=data_tag_name;
	}
	

	@XmlElement(name = "dfsmethod")
	public ObservableList<DFSMethodExportModel> getDFSMethod() {
		return dfsmethods;
	}
	
	public void setDFSMethod(ObservableList<DFSMethodExportModel> dfsmethods) {
		this.dfsmethods=dfsmethods;
	}
	
	public DFSDatatagExportModel clone() throws CloneNotSupportedException {
		DFSDatatagExportModel cloneMedel = (DFSDatatagExportModel) super.clone();
		ObservableList<DFSMethodExportModel> deepCloneModel = FXCollections.observableArrayList();
		for(DFSMethodExportModel temp : dfsmethods)
				deepCloneModel.add(temp.clone());
		cloneMedel.dfsmethods = deepCloneModel;
		return cloneMedel;
	}
}