package com.digilog.meerkat.model.dfsGenerator.crawler;

import javax.xml.bind.annotation.XmlAttribute;

public class DFSPartitionModel implements Cloneable {
	
	private String name;
	
	@XmlAttribute
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public DFSPartitionModel clone() throws CloneNotSupportedException {
		DFSPartitionModel cloneModel = (DFSPartitionModel) super.clone();
		return cloneModel;
	}

}
