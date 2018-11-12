package com.digilog.meerkat.DFSGeneratorController.crawler;

import com.digilog.meerkat.DFSGeneratorController.DFSInitDataController;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSVariablesExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSVariablesController {
	
	private DFSInitDataController dfsInitDataController = new DFSInitDataController();
	
	public DFSVariablesExportModel createInitVariableParent(String dfs_method, DFSDefineTableModel dfsDefineTableModel) {

		DFSVariablesExportModel variableParent = new DFSVariablesExportModel();
		ObservableList<DFSVariableModel> variables = FXCollections.observableArrayList();
		variableParent.setName("VARIABLE");
		variableParent.setDFSVariableList(variables);
		return variableParent;
	}

	public DFSVariablesExportModel createInitVariableParent(String dfs_method, DFSDefineTableModel dfsDefineTableModel, ObservableList<DFSVariableItemModel> tempVariableItemModel) {

		DFSVariablesExportModel variableParent = new DFSVariablesExportModel();
		ObservableList<DFSVariableModel> variables = FXCollections.observableArrayList();
		
		variables = dfsInitDataController.createDFSInitData(dfsDefineTableModel, tempVariableItemModel);

		variableParent.setName("VARIABLE");
		variableParent.setDFSVariableList(variables);
		return variableParent;
	}
}
