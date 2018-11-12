package com.digilog.meerkat.model.dfsGenerator;

import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class DFSAttributeMappingStorgeModel {
	
	private ObservableList<DFSMethodExportModel> DFSMappingMethodData;
	private TableView<ObservableList<Object>> previewTableView;
	private TableView<ObservableList<Object>> DPIRTableView;
	
	public DFSAttributeMappingStorgeModel() {
		DFSMappingMethodData = null;
		previewTableView = null;
		DPIRTableView = null;
	}
	
	public ObservableList<DFSMethodExportModel> getDFSMappingMethodData() {
		return DFSMappingMethodData;
	}
	

	public TableView<ObservableList<Object>> getPreviewTableView() {
		return previewTableView;
	}
	
	public TableView<ObservableList<Object>> getDPIRTableView() {
		return DPIRTableView;
	}
	
	public void setDFSMappingMethodData(ObservableList<DFSMethodExportModel> DFSMappingMethodData) {
		this.DFSMappingMethodData=DFSMappingMethodData;
	}
	
	public void setPreviewTableView(TableView<ObservableList<Object>> previewTableView) {
		this.previewTableView=previewTableView;
	}
	
	public void setDPIR_TableView(TableView<ObservableList<Object>> DPIRTableView) {
		this.DPIRTableView=DPIRTableView;
	}
}
