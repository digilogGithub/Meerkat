package com.digilog.meerkat.DFSGeneratorController.crawler;

import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSPartitionModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSPartitionsExportModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSParationsController {

	public DFSPartitionsExportModel createInitPartitionParent(DFSDefineTableModel dfsDefineTableModel) {

		DFSPartitionsExportModel partitionsParent = new DFSPartitionsExportModel();
		ObservableList<DFSPartitionModel> partitions = FXCollections.observableArrayList();

		partitionsParent.setName("PARTITION");
		partitionsParent.setDFSPartitionList(partitions);

		return partitionsParent;
	}
}
