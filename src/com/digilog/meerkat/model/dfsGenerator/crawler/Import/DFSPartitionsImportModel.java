package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSPartitionModel;

public class DFSPartitionsImportModel implements Cloneable {
	
	private String name;
	private ArrayList<DFSPartitionModel> dfspartitions;
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "dfspartitions")
	public ArrayList<DFSPartitionModel> getDFSPartitionList() {
		return dfspartitions;
	}
	public void setDFSPartitionList(ArrayList<DFSPartitionModel> dfspartitions) {
		this.dfspartitions = dfspartitions;
	}
	
	public DFSPartitionsImportModel clone() throws CloneNotSupportedException {
		DFSPartitionsImportModel cloneModel = (DFSPartitionsImportModel) super.clone();
		ArrayList<DFSPartitionModel> deepCloneModel = new ArrayList<>();
		for(DFSPartitionModel temp : dfspartitions)
				deepCloneModel.add(temp.clone());
		cloneModel.dfspartitions = deepCloneModel;
		return cloneModel;
	}

}
