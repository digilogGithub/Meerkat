package com.digilog.meerkat.util;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSVariableModelCopyController {
	
	public DFSVariableModelCopyController() {
		
	}
	
	public ObservableList<DFSVariableModel> copyDFSVariableModelList(ObservableList<DFSVariableModel> DFSMappingCopyTableData) {
		
		ObservableList<DFSVariableModel> dfsVariables = FXCollections.observableArrayList();
		DFSVariableModel tempDataModel = new DFSVariableModel(); 
		
		for (int i=0; i<DFSMappingCopyTableData.size(); i++)
		{
			tempDataModel = DFSMappingCopyTableData.get(i);
			dfsVariables.add(new DFSVariableModel(tempDataModel.getContentBoolean(),tempDataModel.getdfs_variable_name(),tempDataModel.getColumn_name(), tempDataModel.getTable_name()
					, tempDataModel.getVariable_type(),
					tempDataModel.getVariable_group(), tempDataModel.getRole(),
					tempDataModel.getPivot(), tempDataModel.getSummarization(), tempDataModel.getGroupby(), tempDataModel.getExclude_condition(),
					tempDataModel.getTotime_javaformat(), tempDataModel.getTotime(), tempDataModel.getTimetochar(), tempDataModel.getNumbertochar()));
		}
		return dfsVariables;
	}

}
