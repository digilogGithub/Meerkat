package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSTableModel;

public class DFSTablesImportModel {
	
	private String name;
	private ArrayList<DFSTableModel> dfsTables;
	

	@XmlAttribute
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@XmlElement(name = "dfstable")
	public ArrayList<DFSTableModel> getDFSTableList() {
		return dfsTables;
	}
	
	public void setDFSTableList(ArrayList<DFSTableModel> dfsTables) {
		this.dfsTables=dfsTables;
	}
	
	public DFSTablesImportModel clone() throws CloneNotSupportedException {
		DFSTablesImportModel cloneModel = (DFSTablesImportModel) super.clone();
		ArrayList<DFSTableModel> deepCloneModel = new ArrayList<>();
		for(DFSTableModel temp : dfsTables)
				deepCloneModel.add(temp.clone());
		cloneModel.dfsTables = deepCloneModel;
		return cloneModel;
	}

}
