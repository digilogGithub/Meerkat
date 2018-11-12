package com.digilog.meerkat.DFSGeneratorController.crawler;

import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSDatatagController {
	
	private DFSMethodController createMethod;
	
	public DFSDatatagController()	{
		createMethod = new DFSMethodController();
	}
	
	public DFSDatatagExportModel createDFSDatatag(DFSDefineTableModel dfsDefineTableModel, ObservableList<DFSVariableItemModel> tempVariableItemModel) {
	
		DFSDatatagExportModel datatag = new DFSDatatagExportModel();			
		datatag.setData_tag_name(dfsDefineTableModel.getData_tag_name());
			
		ObservableList<DFSMethodExportModel> methods = FXCollections.observableArrayList();
		methods = createMethod.createDFSMethod(dfsDefineTableModel, tempVariableItemModel);
		
		datatag.setDFSMethod(methods);
		
		return datatag;
	}
}
