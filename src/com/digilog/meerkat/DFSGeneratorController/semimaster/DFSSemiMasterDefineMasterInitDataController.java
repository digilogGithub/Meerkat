package com.digilog.meerkat.DFSGeneratorController.semimaster;

import java.util.ArrayList;
import java.util.Iterator;

import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.SimpleTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSCrawlGathererWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineDatatagInitItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemimasterWrapperImportModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSSemiMasterDefineMasterInitDataController {
	
	private ObservableList<DFSVariableItemModel> initData;
	private ObservableList<SimpleTableModel> typeData;
	private ObservableList<SimpleTableModel> levelData;
	private ObservableList<DFSDefineDatatagInitItemModel> DatatagListInitData;
	private ObservableList<DFSVariableItemModel> l_variable;
	
	public DFSSemiMasterDefineMasterInitDataController() {
		
	}

	public ObservableList<DFSVariableItemModel> createSemiMasterAttributeInitData() {
		initData = FXCollections.observableArrayList();
		initData.add(new DFSVariableItemModel(null,true,"LOT",null,null, "lot"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(0)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null,true,"WAFER",null,null,"Wafer"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(0)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, true,"PROCESS",null,null,"Process"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(1), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, false,"STEP",null,null,"Step"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(1), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, false, "DEVICE",null,null,"Product"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(0),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, false, "EQUIPMENT",null,null,"Equip"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(0),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, false,"CHAMBER",null,null,"Chamber"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(0),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, false,"RECIPE",null,null,"Recipe"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(0),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, true,"RECIPE_STEP",null,null,"Recipe Step"
				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, true,"Xaxis",null,null,"X Axis"
				,DefineAtrribute.VARIABLE_TYPE.get(1),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, true,"Yaxis",null,null,"Y Axis"
				,DefineAtrribute.VARIABLE_TYPE.get(1),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, true,"DEFECT_X",null,null,"DefectX"
				,DefineAtrribute.VARIABLE_TYPE.get(1),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, true,"DEFECT_Y",null,null,"DefectY"
				,DefineAtrribute.VARIABLE_TYPE.get(1),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, false,"TIMESTAMP",null,null,"Time Stamp"
				,DefineAtrribute.VARIABLE_TYPE.get(2),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(0),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
		initData.add(new DFSVariableItemModel(null, true,"TRACETIME",null,null,"Trace Time"
				,DefineAtrribute.VARIABLE_TYPE.get(2),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
				,DefineAtrribute.ROLE_TYPE.get(0), DefineAtrribute.PIVOT_TYPE.get(0),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
//		initData.add(new DFSVariableItemModel(null, false,"WAFER_SITE",null,null,"Site"
//				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
//				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
//		initData.add(new DFSVariableItemModel(null, false,"OPERATOR",null,null,"Operator"
//				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
//				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
//		initData.add(new DFSVariableItemModel(null, false,"MASK",null,null,"Mask"
//				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
//				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
//		initData.add(new DFSVariableItemModel(null, false,"LOWYIELD",null,null,"Low Yield"
//				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
//				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
//		initData.add(new DFSVariableItemModel(null, false,"REPAIRED",null,null,"Repaired"
//				,DefineAtrribute.VARIABLE_TYPE.get(0),DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE.get(1)
//				,DefineAtrribute.ROLE_TYPE.get(2), DefineAtrribute.PIVOT_TYPE.get(1),null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));

		return initData;
	}
	
	
	public ObservableList<String> createImportSemiMasterSortList(DFSSemimasterWrapperImportModel semimaster) {

		ObservableList<String> sortList = FXCollections.observableArrayList();

		for(DFSItemModel tempModel : semimaster.getContext().getDFSItemList())
			sortList.add(tempModel.getName());
		
		for(DFSItemModel tempModel : semimaster.getAttribute().getDFSItemList())
			sortList.add(tempModel.getName());
			
		return sortList;
	}
	
	public ObservableList<String> createSemiMasterinitSortList(ObservableList<DFSVariableItemModel> semiMasterItemInitData) {

		ObservableList<String> sortList = FXCollections.observableArrayList();

		for(DFSVariableItemModel tempModel : semiMasterItemInitData)
			sortList.add(tempModel.getName());
		
		for(DFSVariableItemModel tempModel : semiMasterItemInitData)
			sortList.add(tempModel.getName());
			
		return sortList;
	}
	
	public ObservableList<DFSVariableItemModel> createImportSemiMasterAttributeInitData(ObservableList<DFSCrawlGathererWrapperExportModel> crawlerModels) {
		
		initData = FXCollections.observableArrayList();
		ObservableList<DFSVariableModel> tempVariable = FXCollections.observableArrayList();
		
		for(DFSCrawlGathererWrapperExportModel tempModel : crawlerModels) {
			for(DFSDatatagExportModel tempTaglevel : tempModel.getdfsdatatags()) {
				tempVariable = tempTaglevel.getDFSMethod().get(1).getDFSVariables().getDFSVariableList();
				for(int i=0; i<tempVariable.size(); i++) {
					DFSVariableModel tempVariModel = tempVariable.get(i);
					initData.add(new DFSVariableItemModel(null, false, tempVariModel.getdfs_variable_name()
							,tempVariModel.getColumn_name(), tempVariModel.getTable_name(),null
							, tempVariModel.getVariable_type(), tempVariModel.getVariable_group()
							,tempVariModel.getRole(),tempVariModel.getPivot(),null
							,tempVariModel.getSummarization(), tempVariModel.getGroupby()
							,tempVariModel.getExclude_condition(), tempVariModel.getTotime_javaformat()
							,tempVariModel.getTotime(), tempVariModel.getTimetochar()
							,tempVariModel.getNumbertochar()));
				}
				
				tempVariable = tempTaglevel.getDFSMethod().get(0).getDFSVariables().getDFSVariableList();
				for(int i=0; i<tempVariable.size(); i++) {
					DFSVariableModel tempVariModel = tempVariable.get(i);
					initData.add(new DFSVariableItemModel(null, false, tempVariModel.getdfs_variable_name()
							,tempVariModel.getColumn_name(), tempVariModel.getTable_name(),null
							, tempVariModel.getVariable_type(), tempVariModel.getVariable_group()
							,tempVariModel.getRole(),tempVariModel.getPivot(),null
							,tempVariModel.getSummarization(), tempVariModel.getGroupby()
							,tempVariModel.getExclude_condition(), tempVariModel.getTotime_javaformat()
							,tempVariModel.getTotime(), tempVariModel.getTimetochar()
							,tempVariModel.getNumbertochar()));
				}
				
				tempVariable = tempTaglevel.getDFSMethod().get(2).getDFSVariables().getDFSVariableList();
				for(int i=0; i<tempVariable.size(); i++) {
					DFSVariableModel tempVariModel = tempVariable.get(i);
					if(!"PARAMETER".equals(tempVariModel.getVariable_group()))
					initData.add(new DFSVariableItemModel(null, false, tempVariModel.getdfs_variable_name()
							,tempVariModel.getColumn_name(), tempVariModel.getTable_name(),null
							, tempVariModel.getVariable_type(), tempVariModel.getVariable_group()
							,tempVariModel.getRole(),tempVariModel.getPivot(),null
							,tempVariModel.getSummarization(), tempVariModel.getGroupby()
							,tempVariModel.getExclude_condition(), tempVariModel.getTotime_javaformat()
							,tempVariModel.getTotime(), tempVariModel.getTimetochar()
							,tempVariModel.getNumbertochar()));
				}
			}
		}
		
		int initSize=initData.size();
		
		for(int i=0; i<initSize; i++) {
			for(int j=i+1; j<initSize; j++) 
				if(initData.get(i).getName().equals(initData.get(j).getName())) {
					initData.remove(j);
					initSize--;
					j--;
				}
		}	
		return initData;
	}
	
	public ObservableList<SimpleTableModel> createSemiMasterTypeInitData() {
		typeData = FXCollections.observableArrayList();
		typeData.add(new SimpleTableModel("PROCESS"));
		typeData.add(new SimpleTableModel("ETEST"));
		typeData.add(new SimpleTableModel("METROLOGY"));
		typeData.add(new SimpleTableModel("SORT"));
		typeData.add(new SimpleTableModel("TRACKING"));
		typeData.add(new SimpleTableModel("RECIPE"));
		return typeData;
	}
	
	public ObservableList<SimpleTableModel> createSemiMasterLevelInitData() {
		levelData = FXCollections.observableArrayList();
		levelData.add(new SimpleTableModel("LOT"));
		levelData.add(new SimpleTableModel("WAFER"));
		levelData.add(new SimpleTableModel("MAP"));
		levelData.add(new SimpleTableModel("TRACE"));
		return levelData;
	}
	
	public ObservableList<DFSDefineDatatagInitItemModel> createSemiMasterDatatagListInitData() {
		DatatagListInitData = FXCollections.observableArrayList();
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("TRACKING","WAFER",createVariableSet(DefineAtrribute.TRACKING_WAFER)));
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("PROCESS","WAFER",createVariableSet(DefineAtrribute.PROCESS_WAFER)));
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("PROCESS","TRACE",createVariableSet(DefineAtrribute.PROCESS_TRACE, "TRACE")));
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("MTROLOGY","WAFER",createVariableSet(DefineAtrribute.METROLOGY_WAFER)));
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("SORT","WAFER",createVariableSet(DefineAtrribute.SORT_WAFER)));
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("SORT","MAP",createVariableSet(DefineAtrribute.SORT_MAP)));
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("ETEST","WAFER",createVariableSet(DefineAtrribute.ETEST_WAFER)));
		DatatagListInitData.add(new DFSDefineDatatagInitItemModel("ETEST","MAP",createVariableSet(DefineAtrribute.ETEST_MAP)));
		return DatatagListInitData;
	}
	
	public ObservableList<DFSVariableItemModel> createVariableSet(ObservableList<String> variableList) {	
		l_variable = FXCollections.observableArrayList();
		Iterator<String> itr = variableList.iterator();	
		while(itr.hasNext()) {
			String variableName = itr.next().toString();
			for(int i=0 ; i<initData.size(); i++) {
				if(initData.get(i).getName().equals(variableName))
					try {
						l_variable.add(initData.get(i).clone());
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
			}
		}
		return l_variable;
	}
	
	public ObservableList<DFSVariableItemModel> createVariableSet(ObservableList<String> variableList, String level) {	
		l_variable = FXCollections.observableArrayList();
		Iterator<String> itr = variableList.iterator();	

		while(itr.hasNext()) {
			String variableName = itr.next().toString();
			for(int i=0 ; i<initData.size(); i++) {
				if(initData.get(i).getName().equals(variableName))
					try {
						switch (level) {
						case "TRACE":
							if(initData.get(i).getName().equals("RECIPE"))
								l_variable.add(new DFSVariableItemModel(null
										,initData.get(i).getNotOptional()
										,initData.get(i).getName()
										,null,null
										,initData.get(i).getAlias()
										,initData.get(i).getVariable_type()
										,initData.get(i).getVariable_group()
										,DefineAtrribute.ROLE_TYPE.get(0)
										,DefineAtrribute.PIVOT_TYPE.get(0)
										,null,null,DefineAtrribute.GROUPBY_TYPE.get(1),null,null,null,null,null));
							else
								l_variable.add(initData.get(i).clone());
							break;

						default:
							l_variable.add(initData.get(i).clone());
						}
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
			}
		}
		return l_variable;
	}
}
