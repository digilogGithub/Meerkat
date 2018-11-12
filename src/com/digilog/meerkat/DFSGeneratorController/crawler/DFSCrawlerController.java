package com.digilog.meerkat.DFSGeneratorController.crawler;

import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSCrawlGathererWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DFSCrawlerController {
	
	private DFSCrawlGathererWrapperExportModel crawler;
//	private DFSDatatagController createDatatag;
	private ObservableList<DFSDatatagExportModel> dfsdatatags;
//	private LinkedHashMap<String, DFSAttributeMappingStorgeModel> l_DFSMappingTableData;
	
	public DFSCrawlerController(){
		crawler = new DFSCrawlGathererWrapperExportModel();
//		l_DFSMappingTableData = new LinkedHashMap<String, DFSAttributeMappingStorgeModel>();
		dfsdatatags = FXCollections.observableArrayList();
//		createDatatag = new DFSDatatagController();
	}
	
	public DFSCrawlGathererWrapperExportModel createXMLCrawler(DFSDatatagExportModel dfsDatatagModel) {
        dfsdatatags.add(dfsDatatagModel);               
        crawler.setDFSDatatags(dfsdatatags);
		return crawler;
	}

}
