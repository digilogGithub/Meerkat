package com.digilog.meerkat.model.dfsGenerator.crawler;

import javafx.collections.ObservableList;

public class DFSMappingListModel {
	
	private String name;
	private ObservableList<String> dfsNextAttributeList;
	private ObservableList<String> dfsContextList;
	
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public ObservableList<String> getDFSNextAttributeList() {
		return dfsNextAttributeList;
	}
	
	public void setDFSNextAttributeList(ObservableList<String> dfsNextAttributeList) {
		this.dfsNextAttributeList=dfsNextAttributeList;
	}
	
	public ObservableList<String> getDFSContextList() {
		return dfsContextList;
	}
	
	public void setDFSContextList(ObservableList<String> dfsContextList) {
		this.dfsContextList=dfsContextList;
	}

}
