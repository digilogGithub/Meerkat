package com.digilog.meerkat.model.dfsGenerator.semimaster.export;

import javax.xml.bind.annotation.XmlElement;

import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSItemModel;

import javafx.collections.ObservableList;

//@XmlType(propOrder={"seq", "name", "alias" ,"variable_type"})
public class DFSContextModel {
	
	private ObservableList<DFSItemModel> items;
	
	@XmlElement(name = "item")
	public ObservableList<DFSItemModel> getDFSItemList() {
		return items;
	}
	
	public void setDFSItemList(ObservableList<DFSItemModel> items) {
		this.items=items;
	}
 
}
