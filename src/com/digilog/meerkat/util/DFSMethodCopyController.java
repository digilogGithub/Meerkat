package com.digilog.meerkat.util;

import com.digilog.meerkat.model.dfsGenerator.DFSDetailConfigResultModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSVariablesExportModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSMethodCopyController {
	
	

	public DFSDetailConfigResultModel createDFSMethodCopy(ObservableList<DFSMethodExportModel> dfsMethodModelBackup) {
		
		DFSVariableModelCopyController clt = new DFSVariableModelCopyController();
		DFSDetailConfigResultModel detailConfigBackupModel = new DFSDetailConfigResultModel();
		
		ObservableList<DFSVariableModel> next = FXCollections.observableArrayList();
		ObservableList<DFSVariableModel> context = FXCollections.observableArrayList();
		ObservableList<DFSVariableModel> meta = FXCollections.observableArrayList();
		
		DFSVariablesExportModel nextBack = new DFSVariablesExportModel();	
		DFSVariablesExportModel contextBack = new DFSVariablesExportModel();	
		DFSVariablesExportModel metaBack = new DFSVariablesExportModel();
	
		nextBack = dfsMethodModelBackup.get(0).getDFSVariables();
		contextBack = dfsMethodModelBackup.get(1).getDFSVariables();
		metaBack = dfsMethodModelBackup.get(2).getDFSVariables();
				
		meta = clt.copyDFSVariableModelList(metaBack.getDFSVariableList());			
		
		// nextattribute
		for (int i=0; i<nextBack.getDFSVariableList().size(); i++) {
			boolean exist = false;
			for ( int j=0; j<metaBack.getDFSVariableList().size(); j++) {
				if(nextBack.getDFSVariableList().get(i) == metaBack.getDFSVariableList().get(j)) {
					DFSVariableModel tempDataModel = meta.get(j);
					next.add(tempDataModel);
					exist = true; 
					break;
				}
			}
			if(exist==false)
				try {
					next.add(copyVariable(nextBack.getDFSVariableList().get(i).clone()));
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		// contextlist
		for (int i=0; i<contextBack.getDFSVariableList().size(); i++) {
			boolean exist = false;
			for ( int j=0; j<metaBack.getDFSVariableList().size(); j++) {
				if(contextBack.getDFSVariableList().get(i) == metaBack.getDFSVariableList().get(j)) {
					DFSVariableModel tempDataModel = meta.get(j);
					context.add(tempDataModel);
					exist = true; 
					break;
				}
			}
			if(exist==false)
				try {
					context.add(copyVariable(contextBack.getDFSVariableList().get(i).clone()));
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		detailConfigBackupModel.setNextVariableModels(next);
		detailConfigBackupModel.setContextListVariableModels(context);
		detailConfigBackupModel.setMetaDataVariableModels(meta);

		return detailConfigBackupModel;
	}
	
	public DFSVariableModel copyVariable(DFSVariableModel tempDataModel) {
		DFSVariableModel variable =new DFSVariableModel(tempDataModel.getContentBoolean(),tempDataModel.getdfs_variable_name(),tempDataModel.getColumn_name(), tempDataModel.getTable_name()
				, tempDataModel.getVariable_type(),
				tempDataModel.getVariable_group(), tempDataModel.getRole(),
				tempDataModel.getPivot(), tempDataModel.getSummarization(), tempDataModel.getGroupby(), tempDataModel.getExclude_condition(),
				tempDataModel.getTotime_javaformat(), tempDataModel.getTotime(), tempDataModel.getTimetochar(), tempDataModel.getNumbertochar());	
		return variable;
	}
}
