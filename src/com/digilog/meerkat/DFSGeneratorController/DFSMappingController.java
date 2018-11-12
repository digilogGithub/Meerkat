package com.digilog.meerkat.DFSGeneratorController;

import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.view.DFSGenerator.DFSGeneratorMainViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class DFSMappingController {

	private ObservableList<DFSVariableModel> DFSTempTableData;

	public DFSMappingController() {

	}

	public ObservableList<DFSVariableModel> getDFSMappingSortDataModel(ObservableList<DFSMethodExportModel> tempDFSMethodData) {

		DFSTempTableData = FXCollections.observableArrayList();
		
		if(tempDFSMethodData.get(0).getDFSVariables().getDFSVariableList().size() > 0)
			for (DFSVariableModel content : tempDFSMethodData.get(0).getDFSVariables().getDFSVariableList())
				DFSTempTableData.add(content);

		if(tempDFSMethodData.get(1).getDFSVariables().getDFSVariableList().size() > 0)
			for (DFSVariableModel content : tempDFSMethodData.get(1).getDFSVariables().getDFSVariableList()) {
				boolean exist = false;
				for (DFSVariableModel next : DFSTempTableData) 
					if(content.getdfs_variable_name().equals(next.getdfs_variable_name()))
					{
						exist = true;
						break;
					}
				if(exist==false)
					DFSTempTableData.add(content);
			}
		
		if(tempDFSMethodData.get(2).getDFSVariables().getDFSVariableList().size() > 0)
			for (DFSVariableModel content : tempDFSMethodData.get(2).getDFSVariables().getDFSVariableList()) {
				boolean exist = false;
				for (DFSVariableModel next : DFSTempTableData)
					if(content.getdfs_variable_name().equals(next.getdfs_variable_name()))
					{
						exist = true;
						break;
					}
				if(exist==false)
					DFSTempTableData.add(content);
			}
		
		
		ObservableList<DFSVariableModel> sort_variables = FXCollections.observableArrayList();
		ObservableList<DFSVariableModel> notList_variables = FXCollections.observableArrayList();
		
		for (String name : DFSGeneratorMainViewController.sortList) {
			for (DFSVariableModel next : DFSTempTableData) {
				if(name.equals(next.getdfs_variable_name())) {
					sort_variables.add(next);
					break;
				}
			}
		}
		
		for(DFSVariableModel next : DFSTempTableData) {
			boolean exist= false;
			DFSVariableModel tempModel = next;
			for(DFSVariableModel sort : sort_variables)
				if(next.getdfs_variable_name().equals(sort.getdfs_variable_name())) {
					exist = true;
					break;
				}
				
			if(exist==false) {
				notList_variables.add(tempModel);
			}
		}
		
		for(DFSVariableModel notList : notList_variables)
			sort_variables.add(notList);
		
		DFSTempTableData = sort_variables;
		return DFSTempTableData;		
	}

	public boolean setDFSMappingDataModel(String table_format, String table_name, String mappingColumnName,
			int selectedVairableTableIndex, ObservableList<DFSMethodExportModel> tempDFSMethodData) {

		ObservableList<DFSVariableModel> l_metaTableData = tempDFSMethodData.get(2).getDFSVariables()
				.getDFSVariableList();
		ObservableList<DFSVariableModel> DFSMappingMetaTableData = getDFSMappingSortDataModel(tempDFSMethodData);

		DFSVariableModel DFSMappingTempDataModel = DFSMappingMetaTableData.get(selectedVairableTableIndex);

		boolean replaceName = false;
		int initSeq = DFSMappingMetaTableData.size();
		if (table_format.equals(DefineAtrribute.TABLE_FORMAT.get(1))) {
			if (DFSMappingTempDataModel.getVariable_group().equals("CONTEXT")
					|| DFSMappingTempDataModel.getVariable_group().equals("ATTRIBUTE")) {
				if (DFSMappingMetaTableData.get(selectedVairableTableIndex).getdfs_variable_name().equals("STEP"))
					DFSMappingMetaTableData.get(selectedVairableTableIndex).setTable_name(table_name);
				replaceName = true;	
				DFSMappingMetaTableData.get(selectedVairableTableIndex).setColumn_name(mappingColumnName);
				for (int i = 0; i < initSeq; i++) {
					if (i != selectedVairableTableIndex) {
						DFSMappingTempDataModel = DFSMappingMetaTableData.get(i);
						if (mappingColumnName.equals(DFSMappingTempDataModel.getColumn_name())) 							
							if (DFSMappingTempDataModel.getVariable_group().equals("PARAMETER")) {
								for (int j = 0; j < l_metaTableData.size(); j++)
									if (DFSMappingMetaTableData.get(i) == l_metaTableData.get(j))
										l_metaTableData.remove(j);
								break;
							} else if (DFSMappingTempDataModel.getdfs_variable_name().equals("STEP")) {
								DFSMappingTempDataModel.setColumn_name("'NA'");
								DFSMappingTempDataModel.setTable_name("");
								break;
							} else {
								DFSMappingTempDataModel.setColumn_name(null);
							}
					}
				}
			}
		} else {
			if (DFSMappingMetaTableData.get(selectedVairableTableIndex).getdfs_variable_name().equals("STEP"))
				DFSMappingMetaTableData.get(selectedVairableTableIndex).setTable_name(table_name);
			
			DFSMappingMetaTableData.get(selectedVairableTableIndex).setColumn_name(mappingColumnName);
			replaceName = true;
			for (int i = 0; i < initSeq; i++) {
				if (i != selectedVairableTableIndex) {
					DFSMappingTempDataModel = DFSMappingMetaTableData.get(i);
					if (mappingColumnName.equals(DFSMappingTempDataModel.getColumn_name())) 					
						if (DFSMappingTempDataModel.getdfs_variable_name().equals("STEP")) {
							DFSMappingTempDataModel.setColumn_name("'NA'");
							DFSMappingTempDataModel.setTable_name("");
							break;
						} else {
							DFSMappingTempDataModel.setColumn_name(null);
						}
				}
			}
		}
		
		return replaceName;
	}

	public void setDFSMappingDataModel(DFSDefineTableModel defineTable, DFSDatatagExportModel datatatag,
			ObservableList<DFSMethodExportModel> tempDFSMethodData, TableView<ObservableList<Object>> previewTableView) {

		ObservableList<DFSVariableModel> l_MetaTableData = tempDFSMethodData.get(2).getDFSVariables().getDFSVariableList();
		ObservableList<DFSVariableModel> DFSMappingMetaTableData = getDFSMappingSortDataModel(tempDFSMethodData);

		for (int i = 0; i < previewTableView.getColumns().size(); i++) {

			Boolean notExistDFSVariableTableView = true;
			String table_name = defineTable.getTable_Name();
			String time_javaFormat = defineTable.getTotime_javaformat();
			String toTime = defineTable.getTotime();
			String timeToChar = defineTable.getTimetochar();
			String numberToChar = defineTable.getNumbertochar();

			String previewTableViewColumnName = previewTableView.getColumns().get(i).getText();

			for (DFSVariableModel dfm : DFSMappingMetaTableData) {
				if (previewTableViewColumnName.equals(dfm.getColumn_name())) {
					notExistDFSVariableTableView = false;
					break;
				}
			}

			if (notExistDFSVariableTableView) {
				l_MetaTableData.add(new DFSVariableModel(false, previewTableViewColumnName,
						previewTableViewColumnName, table_name, DefineAtrribute.VARIABLE_TYPE.get(1),
						DefineAtrribute.VARIABLE_GROUP_TYPE.get(2), DefineAtrribute.ROLE_TYPE.get(2),
						DefineAtrribute.PIVOT_TYPE.get(0), null, DefineAtrribute.GROUPBY_TYPE.get(1), null,
						time_javaFormat, toTime, timeToChar, numberToChar));
			}
		}
	}
}
