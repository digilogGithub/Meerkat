package com.digilog.meerkat.DFSGeneratorController.crawler;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

import javafx.scene.control.TableView;

public class DFSSearchTableColumnController {
	
	public void searchTableColumn(TableView<DFSVariableModel> targetTableView, String ColumnName) {
		
	}
	
	public void searchTableColumnContent(TableView<DFSVariableModel> targetTableView, String Content) {
		
		int searchIndex = -1;
		for(int i=0; i<targetTableView.getItems().size(); i++)
			if(Content.equals(targetTableView.getItems().get(i).getColumn_name()))
					searchIndex = i;
		targetTableView.getSelectionModel().select(searchIndex);
		targetTableView.scrollTo(searchIndex);
	}

}
