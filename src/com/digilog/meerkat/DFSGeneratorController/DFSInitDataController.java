package com.digilog.meerkat.DFSGeneratorController;

import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSSortTempVariableItemModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.view.DFSGenerator.DFSGeneratorMainViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSInitDataController {
	private String table_format;
	private String table_name;
	private String time_javaFormat;
	private String toTime;
	private String timeToChar;
	private String numberToChar;
	private ObservableList<DFSVariableModel> variables;
	private ObservableList<DFSSortTempVariableItemModel> tempSortVariables;

	public DFSInitDataController() {

	}

	public ObservableList<DFSVariableModel> createDFSInitData(DFSDefineTableModel dfsDefineTableModel,
			ObservableList<DFSVariableItemModel> tempVariableItemModel) {
		this.table_format = dfsDefineTableModel.getTable_format();
		this.table_name = dfsDefineTableModel.getTable_Name();
		this.time_javaFormat = dfsDefineTableModel.getTotime_javaformat();
		this.toTime = dfsDefineTableModel.getTotime();
		this.timeToChar = dfsDefineTableModel.getTimetochar();
		this.numberToChar = dfsDefineTableModel.getNumbertochar();

		tempSortVariables = FXCollections.observableArrayList();
		variables = FXCollections.observableArrayList();

		setDFSInitData(tempVariableItemModel);
		return variables;
	}

	public void setDFSInitData(ObservableList<DFSVariableItemModel> tempVariableItemModel) {

		for (String name : DFSGeneratorMainViewController.sortList)
			tempSortVariables.add(new DFSSortTempVariableItemModel(name, null));

		ObservableList<DFSVariableModel> l_variables = FXCollections.observableArrayList();

		for (int i = 0; i < tempVariableItemModel.size(); i++) {
			boolean exists = false;
			for (int j = 0; j < tempSortVariables.size(); j++) {
				String name = tempSortVariables.get(j).getName();
				if (name.equals(tempVariableItemModel.get(i).getName())) {
					exists = true;
					String stepName = null;
					String orgTableName = table_name;
					if (tempVariableItemModel.get(i).getName().equals("STEP")) {
						stepName = "'NA'";
						orgTableName = "";
					}
					tempSortVariables.get(j).setVariable(new DFSVariableModel(
							tempVariableItemModel.get(i).getNotOptional(), tempVariableItemModel.get(i).getName(),
							stepName, orgTableName, tempVariableItemModel.get(i).getVariable_type(),
							tempVariableItemModel.get(i).getVariable_group(), tempVariableItemModel.get(i).getRole(),
							tempVariableItemModel.get(i).getPivot(), null, tempVariableItemModel.get(i).getGroupby(),
							null, time_javaFormat, toTime, timeToChar, numberToChar));
					break;
				}
			}
			if (exists == false)
				l_variables.add(new DFSVariableModel(tempVariableItemModel.get(i).getNotOptional(),
						tempVariableItemModel.get(i).getName(), null, table_name,
						tempVariableItemModel.get(i).getVariable_type(),
						tempVariableItemModel.get(i).getVariable_group(), tempVariableItemModel.get(i).getRole(),
						tempVariableItemModel.get(i).getPivot(), null, tempVariableItemModel.get(i).getGroupby(), null,
						time_javaFormat, toTime, timeToChar, numberToChar));
		}

		for (int i = 0; i < tempSortVariables.size(); i++) {
			if (tempSortVariables.get(i).getVariable() != null)
				variables.add(tempSortVariables.get(i).getVariable());
		}
		
		if(table_format.equals(DefineAtrribute.TABLE_FORMAT.get(0))) {
			variables.add(new DFSVariableModel(true,DefineAtrribute.UNPIVOT_VARIABLE_NAME.get(0),null,table_name,
					DefineAtrribute.VARIABLE_TYPE.get(0),
					DefineAtrribute.VARIABLE_GROUP_TYPE.get(2), DefineAtrribute.ROLE_TYPE.get(2),
					DefineAtrribute.PIVOT_TYPE.get(1), null, DefineAtrribute.GROUPBY_TYPE.get(1), null,
					time_javaFormat, toTime, timeToChar, numberToChar));
			variables.add(new DFSVariableModel(true,DefineAtrribute.UNPIVOT_VARIABLE_NAME.get(1),null,table_name,
					DefineAtrribute.VARIABLE_TYPE.get(0),
					DefineAtrribute.VARIABLE_GROUP_TYPE.get(2), DefineAtrribute.ROLE_TYPE.get(2),
					DefineAtrribute.PIVOT_TYPE.get(1), null, DefineAtrribute.GROUPBY_TYPE.get(1), null,
					time_javaFormat, toTime, timeToChar, numberToChar));
			variables.add(new DFSVariableModel(true,DefineAtrribute.UNPIVOT_VARIABLE_NAME.get(2), null,table_name,
					DefineAtrribute.VARIABLE_TYPE.get(1),
					DefineAtrribute.VARIABLE_GROUP_TYPE.get(2), DefineAtrribute.ROLE_TYPE.get(2),
					DefineAtrribute.PIVOT_TYPE.get(1), null, DefineAtrribute.GROUPBY_TYPE.get(1), null,
					time_javaFormat, toTime, timeToChar, numberToChar));
		}
			
		for (int i = 0; i < l_variables.size(); i++) {
			variables.add(l_variables.get(i));
		}
	}
}
