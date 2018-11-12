package com.digilog.meerkat.model.dfsGenerator.semimaster.Import;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSItemModel;

public class DFSAttributeImportModel {
private ArrayList<DFSItemModel> items;
	
	@XmlElement(name = "item")
	public ArrayList<DFSItemModel> getDFSItemList() {
		return items;
	}
	
	public void setDFSItemList(ArrayList<DFSItemModel> items) {
		this.items=items;
	}

}
