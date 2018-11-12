package com.digilog.meerkat.DFSGeneratorController.XMLController.Export;

import com.digilog.meerkat.DFSGeneratorController.semimaster.DFSSemimasterController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSCrawlGathererWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemimasterWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.view.RootGeneralConfigViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSGeneratorXMLExportController {
	
	private DFSCrawlGathererWrapperExportModel crawler;
	private DFSCrawlGathererWrapperExportModel gatherer;
	private DFSSemimasterController dfsSemimasterController;
	private DFSGeneratorXMLExportFileController expFilectl;

	
	public DFSGeneratorXMLExportController() {	
		crawler = new DFSCrawlGathererWrapperExportModel();
		gatherer = new DFSCrawlGathererWrapperExportModel();
		dfsSemimasterController = new DFSSemimasterController();
		expFilectl = new DFSGeneratorXMLExportFileController();
	}

	public DFSSemimasterWrapperExportModel createDFSXMLFile(DFSGeneratorAndDatabaseListModel databaseListModel, DFSGeneratorXMLInfoModel dfsXMLInfoModel) {
		String databaseName = dfsXMLInfoModel.getDatabaseName();
		String crawlerFileName = dfsXMLInfoModel.getCrawlerFileName();
		String gathererFileName = dfsXMLInfoModel.getGathererFileName();
		DFSSemimasterWrapperExportModel semimaster = new DFSSemimasterWrapperExportModel();
		ObservableList<DFSDefineTableModel> l_DFSDefineTableData = FXCollections.observableArrayList();
		ObservableList<DFSDatatagExportModel> c_dfsdatatags = FXCollections.observableArrayList();
		ObservableList<DFSDatatagExportModel> g_dfsdatatags = FXCollections.observableArrayList();
		
		ObservableList<DFSDefineTableModel> DFSDefineTableData = databaseListModel.getDfsGeneratorMainController().getController().getDFSDefineTableData();
		ObservableList<DFSDatatagExportModel> dfsdatatags = databaseListModel.getDfsGeneratorMainController().getController().getDfsdatatags();
		ObservableList<DFSVariableItemModel> SemiMappingInitData = RootGeneralConfigViewController.SemiMasterItemInitData;
		
		try {
			for(int i=0; i<DFSDefineTableData.size(); i++) {
				if(DFSDefineTableData.get(i).getContentBoolean())
					l_DFSDefineTableData.add(DFSDefineTableData.get(i).clone());
			}
			
			
			for(int i=0; i<l_DFSDefineTableData.size(); i++) {
				for(int j=0; j<dfsdatatags.size(); j++)
					if(l_DFSDefineTableData.get(i).getData_tag_name().equals(dfsdatatags.get(j).getData_tag_name()))
						c_dfsdatatags.add(dfsdatatags.get(j).clone());
			} 
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		File recordsDir = new File(System.getProperty("user.home"), ".myApplicationName/records");
//		if (! recordsDir.exists()) {
//		    recordsDir.mkdirs();
//		}
	//
//		// ...
	//
//		FileChooser chooser = new FileChooser();
//		chooser.setInitialDirectory(recordsDir);
		
		// delete null column_name
		for(DFSDatatagExportModel tempDataTag : c_dfsdatatags) 
			for(DFSMethodExportModel tempMethod : tempDataTag.getDFSMethod())
				for(int i=0 ; i<tempMethod.getDFSVariables().getDFSVariableList().size(); i++)
					if(tempMethod.getDFSVariables().getDFSVariableList().get(i).getColumn_name() == null
							|| tempMethod.getDFSVariables().getDFSVariableList().get(i).getColumn_name().equals(""))
						tempMethod.getDFSVariables().getDFSVariableList().remove(i);
									
		semimaster = dfsSemimasterController.createXMLSemimaster(databaseName, l_DFSDefineTableData, c_dfsdatatags, SemiMappingInitData);
			
		for(int i=0; i<c_dfsdatatags.size(); i++) {
			DFSDatatagExportModel tempModel = new DFSDatatagExportModel();
			ObservableList<DFSMethodExportModel> tempMethodModel =FXCollections.observableArrayList();
			tempModel.setData_tag_name(c_dfsdatatags.get(i).getData_tag_name());
			try {
				tempMethodModel.add(c_dfsdatatags.get(i).getDFSMethod().get(2).clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempMethodModel.get(0).setName("GETDATA");
			tempModel.setDFSMethod(tempMethodModel);
			g_dfsdatatags.add(tempModel);
		}
		gatherer.setName(databaseName);
		gatherer.setDFSDatatags(g_dfsdatatags);

		expFilectl.crawlGathererExport(gathererFileName, gatherer);
		
		for(int i=0; i<c_dfsdatatags.size(); i++) {
			for(DFSDefineTableModel dtm : DFSDefineTableData) {
				if(c_dfsdatatags.get(i).getData_tag_name().equals(dtm.getData_tag_name())) {
					if(dtm.getTable_format().equals(DefineAtrribute.TABLE_FORMAT.get(0))) {
						ObservableList<DFSVariableModel> tempModel = FXCollections.observableArrayList();
						tempModel = c_dfsdatatags.get(i).getDFSMethod().get(2).getDFSVariables().getDFSVariableList();
						for (int j=0; j<tempModel.size(); j++)
							if(tempModel.get(j).getdfs_variable_name().equals(DefineAtrribute.UNPIVOT_VARIABLE_NAME.get(2)))
								tempModel.remove(j);
					}
				}
			}
		}
		
		crawler.setName(databaseName);
		crawler.setDFSDatatags(c_dfsdatatags);
		expFilectl.crawlGathererExport(crawlerFileName, crawler);
		
		return semimaster;
		// rollback
//		for(int i=0; i<c_dfsdatatags.size(); i++)
//			try {
//				c_dfsdatatags.get(i).getDFSMethod().set(2, g_dfsdatatags.get(i).getDFSMethod().get(0).clone());
//				c_dfsdatatags.get(i).getDFSMethod().get(2).setName("METADATA");
//			} catch (CloneNotSupportedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		if(dfsXMLInfo.isCreateEDLConfig())
//		{
//			xmlDBInfo.createDBInfoFile(dfsXMLInfo);
//			xmleDLConfig.createEDLWindowsConfigFile(dfsXMLInfo);
//			xmlLog4jConfig.createLog4j2File();
//		}	
	}
}
