package com.digilog.meerkat.util;

import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemiDatatagImportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemimasterWrapperImportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSAttributeModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSContextModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSDescriptorExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemiDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemimasterWrapperExportModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArrayListToObservableList {
	
	public DFSSemimasterWrapperExportModel semiConverter(DFSSemimasterWrapperImportModel semimasterCurrenttVer) {
		
		DFSSemimasterWrapperExportModel tempSemi = new DFSSemimasterWrapperExportModel();
		tempSemi.setContext(new DFSContextModel());
		tempSemi.getContext().setDFSItemList(FXCollections.observableArrayList());
		tempSemi.setAttribute(new DFSAttributeModel());
		tempSemi.getAttribute().setDFSItemList(FXCollections.observableArrayList());
		tempSemi.setDescriptor(new DFSDescriptorExportModel());
		tempSemi.getDescriptor().setDFSItemList(FXCollections.observableArrayList());
		tempSemi.setDatatag(FXCollections.observableArrayList());
		for(DFSItemModel tempContext : semimasterCurrenttVer.getContext().getDFSItemList())
			tempSemi.getContext().getDFSItemList().add(tempContext);
		for(DFSItemModel tempAttribute : semimasterCurrenttVer.getAttribute().getDFSItemList())
			tempSemi.getAttribute().getDFSItemList().add(tempAttribute);
		for(DFSItemModel tempDescriptor : semimasterCurrenttVer.getDescriptor().getDFSItemList())
			tempSemi.getDescriptor().getDFSItemList().add(tempDescriptor);
		for(DFSSemiDatatagImportModel tempDatatag : semimasterCurrenttVer.getDatatag()) {
			
			ObservableList<DFSItemModel> dfsItems = FXCollections.observableArrayList();
			for(DFSItemModel tempItem : tempDatatag.getItems())
				dfsItems.add(tempItem);
			
			DFSSemiDatatagExportModel tempSemiDatatag = new DFSSemiDatatagExportModel();	
			tempSemiDatatag.setEnabled(tempDatatag.getEnabled());
			tempSemiDatatag.setName(tempDatatag.getName());
			tempSemiDatatag.setAlias(tempDatatag.getAlias());
			tempSemiDatatag.setType(tempDatatag.getType());
			tempSemiDatatag.setLevel(tempDatatag.getLevel());
			tempSemiDatatag.setDatasource(tempDatatag.getDatasource());
			tempSemiDatatag.setDfs_query_by(tempDatatag.getDfs_query_by());
			tempSemiDatatag.setSort_by_attributekey(tempDatatag.getSort_by_attributekey());
			tempSemiDatatag.setDesc(tempDatatag.getDesc());
			tempSemiDatatag.setItems(dfsItems);
			
			tempSemi.getDatatag().add(tempSemiDatatag);
		}
		return tempSemi;
	}

}
