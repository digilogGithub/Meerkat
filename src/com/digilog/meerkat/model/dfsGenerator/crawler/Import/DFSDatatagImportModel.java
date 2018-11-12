package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class DFSDatatagImportModel implements Cloneable {
	private String data_tag_name;
	private ArrayList<DFSMethodImportModel> dfsmethods;

	public DFSDatatagImportModel() {

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
	public ArrayList<DFSMethodImportModel> getDFSMethod() {
		return dfsmethods;
	}
	
	public void setDFSMethod(ArrayList<DFSMethodImportModel> dfsmethods) {
		this.dfsmethods=dfsmethods;
	}
	
	public DFSDatatagImportModel clone() throws CloneNotSupportedException {
		DFSDatatagImportModel cloneMedel = (DFSDatatagImportModel) super.clone();
		ArrayList<DFSMethodImportModel> deepCloneModel = new ArrayList<>();
		for(DFSMethodImportModel temp : dfsmethods)
				deepCloneModel.add(temp.clone());
		cloneMedel.dfsmethods = deepCloneModel;
		return cloneMedel;
	}

}
