package com.digilog.meerkat.DFSGeneratorController.crawler;

import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSTablesExportModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSTablesController {

	public DFSTablesExportModel createInitTableParent(DFSDefineTableModel dfsDefineTableModel) {

		String tableName;
		
		DFSTablesExportModel tablesParent = new DFSTablesExportModel();
		ObservableList<DFSTableModel> tables = FXCollections.observableArrayList();
		
		DFSTableModel tableModel = new DFSTableModel();
		tableName = dfsDefineTableModel.getTable_Name();
		tableModel.setName(tableName);
		tableModel.setPrefix("");
		tableModel.setPostfix("");
		tableModel.setJoin("");
		tableModel.setCondition("");
		tables.add(tableModel);
		
		tablesParent.setName("TABLE");
		tablesParent.setDFSTableList(tables);

		return tablesParent;
	}

}
