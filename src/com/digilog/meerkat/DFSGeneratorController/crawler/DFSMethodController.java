package com.digilog.meerkat.DFSGeneratorController.crawler;

import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSPartitionsExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSTablesExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSVariablesExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.util.DFSVerifyMethod;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSMethodController {

	private DFSTablesController createInitDFSTables;
	private DFSParationsController createInitDFSPartitions;
	private DFSVariablesController createInitDFSVariaebleData;
	
	private ObservableList<DFSVariableModel> nextVariableModels;
	private ObservableList<DFSVariableModel> contextListVariableModels;
	private ObservableList<DFSVariableModel> metaDataVariableModels;
	private DFSVerifyMethod vm = new DFSVerifyMethod();
	
	DFSMethodController()	{	
		createInitDFSTables = new DFSTablesController();
		createInitDFSPartitions = new DFSParationsController();
		createInitDFSVariaebleData = new DFSVariablesController();
		nextVariableModels = FXCollections.observableArrayList();
		contextListVariableModels = FXCollections.observableArrayList();
		metaDataVariableModels = FXCollections.observableArrayList();
	}
	public ObservableList<DFSMethodExportModel> createDFSMethod(DFSDefineTableModel dfsDefineTableModel, ObservableList<DFSVariableItemModel> tempVariableItemModel) {
		
		ObservableList<DFSVariableModel> DFSMappingMetaTableData = FXCollections.observableArrayList();
		DFSMethodExportModel method = new DFSMethodExportModel();	
			
		ObservableList<DFSMethodExportModel> methods = FXCollections.observableArrayList();
		
		method = createInitNextAttribute("NEXTATTRIBUTE", dfsDefineTableModel);
		methods.add(method);
		
		method = createInitContextlist("CONTEXTLIST", dfsDefineTableModel);
		methods.add(method);
		
		method = createInitMetadata("METADATA", dfsDefineTableModel, tempVariableItemModel);
		methods.add(method);
		
		DFSMappingMetaTableData = method.getDFSVariables().getDFSVariableList();
		
		for ( int i=0; i<DFSMappingMetaTableData.size(); i++)
		{
			boolean contextList = false;
			contextList = vm.verifyContextList(DefineAtrribute.DFS_METHOD.get(0), DFSMappingMetaTableData.get(i));
			if(contextList) {
				System.out.println(DFSMappingMetaTableData.get(i).getdfs_variable_name());
				nextVariableModels.add(DFSMappingMetaTableData.get(i));
			}
			
				
		}
		
		for ( int i=0; i<DFSMappingMetaTableData.size(); i++)
		{
			boolean contextList = false;
			contextList = vm.verifyContextList(DefineAtrribute.DFS_METHOD.get(1), DFSMappingMetaTableData.get(i));
			if(contextList)
				contextListVariableModels.add(DFSMappingMetaTableData.get(i));
		}
		
		for ( int i=0; i<DFSMappingMetaTableData.size(); i++)
		{
			metaDataVariableModels.add(DFSMappingMetaTableData.get(i));
		}

		
		methods.get(0).getDFSVariables().setDFSVariableList(nextVariableModels);
		methods.get(1).getDFSVariables().setDFSVariableList(contextListVariableModels);
		methods.get(2).getDFSVariables().setDFSVariableList(metaDataVariableModels);
		
		methods.get(0).getDFSVariables().getDFSVariableList().size();
		
		return methods;
		
	}
	
	
	private DFSMethodExportModel createInitNextAttribute(String dfs_method, DFSDefineTableModel dfsDefineTableModel) {

		DFSMethodExportModel next = new DFSMethodExportModel();
		
		DFSTablesExportModel tableParent;
		DFSPartitionsExportModel partitions;
		DFSVariablesExportModel variables;
		
		next.setName(dfs_method);
		next.setHint("");
		next.setTemptable("");
		next.setTemptable_keycolumn("");
				
		tableParent = createInitDFSTables.createInitTableParent(dfsDefineTableModel);
		next.setDFSTables(tableParent);
		
		partitions = createInitDFSPartitions.createInitPartitionParent(dfsDefineTableModel);
		next.setDFSPartitions(partitions);
		
		variables = createInitDFSVariaebleData.createInitVariableParent(dfs_method,dfsDefineTableModel);
		next.setDFSVariables(variables);
		return next;
	}
	
	private DFSMethodExportModel createInitContextlist(String dfs_method, DFSDefineTableModel dfsDefineTableModel) {
		DFSMethodExportModel context = new DFSMethodExportModel();
		
		DFSTablesExportModel tableParent;
		DFSPartitionsExportModel partitions;
		DFSVariablesExportModel variables;
		
		context.setName(dfs_method);
		context.setHint("");
		context.setTemptable("");
		context.setTemptable_keycolumn("");
		
		tableParent = createInitDFSTables.createInitTableParent(dfsDefineTableModel);
		context.setDFSTables(tableParent);
		
		partitions = createInitDFSPartitions.createInitPartitionParent(dfsDefineTableModel);
		context.setDFSPartitions(partitions);
		
		variables = createInitDFSVariaebleData.createInitVariableParent(dfs_method, dfsDefineTableModel);
		context.setDFSVariables(variables);
		
		return context;
	}
	
	private DFSMethodExportModel createInitMetadata(String dfs_method, DFSDefineTableModel dfsDefineTableModel, ObservableList<DFSVariableItemModel> tempVariableItemModel) {
		DFSMethodExportModel meta = new DFSMethodExportModel();
		DFSTablesExportModel tableParent;
		DFSPartitionsExportModel partitions;
		DFSVariablesExportModel variables;
		
		meta.setName(dfs_method);
		meta.setHint("");
		meta.setTemptable("");
		meta.setTemptable_keycolumn("");
		
		tableParent = createInitDFSTables.createInitTableParent(dfsDefineTableModel);
		meta.setDFSTables(tableParent);
		
		partitions = createInitDFSPartitions.createInitPartitionParent(dfsDefineTableModel);
		meta.setDFSPartitions(partitions);
		
		variables = createInitDFSVariaebleData.createInitVariableParent(dfs_method,dfsDefineTableModel,tempVariableItemModel);
		meta.setDFSVariables(variables);
		
		return meta;
	}
}
