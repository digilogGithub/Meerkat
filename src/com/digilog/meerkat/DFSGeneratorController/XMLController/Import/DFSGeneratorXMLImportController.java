package com.digilog.meerkat.DFSGeneratorController.XMLController.Import;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExportDBInfoController;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExportLog4j2Controller;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExporteDLWindowsConfigController;
import com.digilog.meerkat.DFSGeneratorController.semimaster.DFSSemimasterController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSCrawlGathererWrapperImportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemiDatatagImportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemimasterWrapperImportModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DBInfoConfigModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.EDataRealmConfigModel;
import com.digilog.meerkat.util.MessageDialog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class DFSGeneratorXMLImportController {
	
	private MessageDialog mDialog = new MessageDialog();;
	private Alert messageLog;

	private ObservableList<DFSDefineTableModel> l_DFSDefineTableData;
	private ObservableList<DFSDatatagExportModel> c_dfsdatatags;
	private ObservableList<DFSDatatagExportModel> g_dfsdatatags;
	private DFSCrawlGathererWrapperImportModel crawler;
	private DFSCrawlGathererWrapperImportModel gatherer;
	private DFSSemimasterWrapperImportModel semimaster;
//	private DFSSemimasterController dfsSemimasterController;
	private DFSGeneratorXMLCrawlerImportController dfsGeneratorCrawlerImportController;
	private DFSGeneratorXMLSemimasterController dfsGeneratorSemimasterImportController;
	private DFSGeneratorXMLExportDBInfoController xmlDBInfo;
	private DFSGeneratorXMLExporteDLWindowsConfigController xmleDLConfig;
	private DFSGeneratorXMLExportLog4j2Controller xmlLog4jConfig;

	public DFSGeneratorXMLImportController() {
		crawler = new DFSCrawlGathererWrapperImportModel();
		gatherer = new DFSCrawlGathererWrapperImportModel();
		semimaster = new DFSSemimasterWrapperImportModel();
//		dfsSemimasterController = new DFSSemimasterController();
		dfsGeneratorCrawlerImportController = new DFSGeneratorXMLCrawlerImportController();
		dfsGeneratorSemimasterImportController = new DFSGeneratorXMLSemimasterController();
		l_DFSDefineTableData = FXCollections.observableArrayList();
		c_dfsdatatags = FXCollections.observableArrayList();
		g_dfsdatatags = FXCollections.observableArrayList();
		xmlDBInfo = new DFSGeneratorXMLExportDBInfoController();
		xmleDLConfig = new DFSGeneratorXMLExporteDLWindowsConfigController();
		xmlLog4jConfig = new DFSGeneratorXMLExportLog4j2Controller();
	}

	public void importDFSXMLFile(DFSGeneratorXMLInfoModel dfsXMLInfo,
			ObservableList<DFSDefineTableModel> DFSDefineTableData, ObservableList<DFSDatatagExportModel> dfsdatatags,
			ObservableList<DFSVariableItemModel> SemiMappingInitData) {
//		if (dfsXMLInfo.isCreateEDLConfig())
//			;
//		// String dataBaseName = dfsXMLInfo.getDatabaseName();
//		String semiConfigFileName = dfsXMLInfo.getSEMIFileName();
//		String crawlerFileName = dfsXMLInfo.getCrawlerFileName();
//		String gathererFileName = dfsXMLInfo.getGathererFileName();
//
//		semimaster = semimasterImport(semiConfigFileName);
//		// gatherer =
//		// dfsGeneratorCrawlerImportController.crawlerImport(gathererFileName);
//		// crawler =
//		// dfsGeneratorCrawlerImportController.crawlerImport(crawlerFileName);
//
//		DFSDefineTableData.clear();
//		for (DFSSemiDatatagImportModel temp : semimaster.getDatatag()) {
//			if (temp.getDatasource() != null || !"".equals(temp.getDatasource()))
//				DFSDefineTableData.add(new DFSDefineTableModel(null, temp.getDatasource(), temp.getName(),
//						temp.getAlias(), null, temp.getType(), temp.getLevel(), null, null, null, null, true));
//		}

		// System.out.println(semimaster.getDatatag().get(0).getName());
		// System.out.println();
		// System.out.println();
		// semimaster.getDatatag()
		// for()
		// l_DFSDefineTableData.

		// try {
		// for(int i=0; i<DFSDefineTableData.size(); i++) {
		// if(DFSDefineTableData.get(i).getContentBoolean())
		// l_DFSDefineTableData.add(DFSDefineTableData.get(i).clone());
		// }
		//
		//
		// for(int i=0; i<l_DFSDefineTableData.size(); i++) {
		// for(int j=0; j<dfsdatatags.size(); j++)
		// if(l_DFSDefineTableData.get(i).getData_tag_name().equals(dfsdatatags.get(j).getData_tag_name()))
		// c_dfsdatatags.add(dfsdatatags.get(j).clone());
		// }
		// } catch (CloneNotSupportedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// File recordsDir = new File(System.getProperty("user.home"),
		// ".myApplicationName/records");
		// if (! recordsDir.exists()) {
		// recordsDir.mkdirs();
		// }
		//
		// // ...
		//
		// FileChooser chooser = new FileChooser();
		// chooser.setInitialDirectory(recordsDir);

		// // delete null column_name
		// for(DFSDatatagModel tempDataTag : c_dfsdatatags)
		// for(DFSMethodModel tempMethod : tempDataTag.getDFSMethod())
		// for(int i=0 ;
		// i<tempMethod.getDFSVariables().getDFSVariableList().size(); i++)
		// if(tempMethod.getDFSVariables().getDFSVariableList().get(i).getColumn_name()
		// == null
		// ||
		// tempMethod.getDFSVariables().getDFSVariableList().get(i).getColumn_name().equals(""))
		// tempMethod.getDFSVariables().getDFSVariableList().remove(i);
		//
		// semimaster =
		// dfsSemimasterController.createXMLSemimaster(databaseName,
		// l_DFSDefineTableData, c_dfsdatatags, SemiMappingInitData);
		// dfsGeneratorSemimasterExportController.SemimasterExport(semiConfigFilename,
		// semimaster);
		//
		// for(int i=0; i<c_dfsdatatags.size(); i++) {
		// DFSDatatagModel tempModel = new DFSDatatagModel();
		// ObservableList<DFSMethodModel> tempMethodModel
		// =FXCollections.observableArrayList();
		// tempModel.setData_tag_name(c_dfsdatatags.get(i).getData_tag_name());
		// try {
		// tempMethodModel.add(dfsdatatags.get(i).getDFSMethod().get(2).clone());
		// } catch (CloneNotSupportedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// tempMethodModel.get(0).setName("GETDATA");
		// tempModel.setDFSMethod(tempMethodModel);
		// g_dfsdatatags.add(tempModel);
		// }
		// gatherer.setName(databaseName);
		// gatherer.setDFSDatatags(g_dfsdatatags);
		//
		// dfsGeneratorCrawlerExportController.CrawlerExport(gathererFileName,
		// gatherer);
		//
		// for(int i=0; i<c_dfsdatatags.size(); i++) {
		// for(DFSDefineTableModel dtm : DFSDefineTableData) {
		// if(c_dfsdatatags.get(i).getData_tag_name().equals(dtm.getData_tag_name()))
		// {
		// if(dtm.getTable_format().equals(DefineAtrribute.TABLE_FORMAT.get(0)))
		// {
		// ObservableList<DFSVariableModel> tempModel =
		// FXCollections.observableArrayList();
		// tempModel =
		// c_dfsdatatags.get(i).getDFSMethod().get(2).getDFSVariables().getDFSVariableList();
		// for (int j=0; j<tempModel.size(); j++)
		// if(tempModel.get(j).getdfs_variable_name().equals(DefineAtrribute.UNPIVOT_VARIABLE_NAME.get(2)))
		// tempModel.remove(j);
		// }
		// }
		// }
		// }
		//
		// crawler.setName(databaseName);
		// crawler.setDFSDatatags(c_dfsdatatags);
		// dfsGeneratorCrawlerExportController.CrawlerExport(crawlerFileName,
		// crawler);
		//
		// // rollback
		//// for(int i=0; i<c_dfsdatatags.size(); i++)
		//// try {
		//// c_dfsdatatags.get(i).getDFSMethod().set(2,
		// g_dfsdatatags.get(i).getDFSMethod().get(0).clone());
		//// c_dfsdatatags.get(i).getDFSMethod().get(2).setName("METADATA");
		//// } catch (CloneNotSupportedException e) {
		//// // TODO Auto-generated catch block
		//// e.printStackTrace();
		//// }
		// if(dfsXMLInfo.isCreateEDLConfig())
		// {
		// xmlDBInfo.createDBInfoFile(dfsXMLInfo);
		// xmleDLConfig.createEDLWindowsConfigFile(dfsXMLInfo);
		// xmlLog4jConfig.createLog4j2File();
		// }
	}

	public EDataRealmConfigModel eDataRealmConfigImport(String eDataRealmConfigFileName) {
		try {
			eDataRealmConfigFileName = eDataRealmConfigFileName.replace("%appdata%", System.getenv("APPDATA"));
			EDataRealmConfigModel eDataRealmConfig = new EDataRealmConfigModel();
			JAXBContext context = JAXBContext.newInstance(EDataRealmConfigModel.class);
			Unmarshaller u = context.createUnmarshaller();

			eDataRealmConfig = (EDataRealmConfigModel) u.unmarshal(new File(eDataRealmConfigFileName));
			return eDataRealmConfig;

		} catch (JAXBException e) {
			showErrorMessage(e.toString());
			return null;
		}
	}
	
	public DFSCrawlGathererWrapperImportModel crawlGathererConfigImport(String crawlGathereConfigFileName) {
		try {
			crawlGathereConfigFileName = crawlGathereConfigFileName.replace("%appdata%", System.getenv("APPDATA"));
			DFSCrawlGathererWrapperImportModel crawkGatgererConfig = new DFSCrawlGathererWrapperImportModel();
			JAXBContext context = JAXBContext.newInstance(DFSCrawlGathererWrapperImportModel.class);
			Unmarshaller u = context.createUnmarshaller();

			crawkGatgererConfig = (DFSCrawlGathererWrapperImportModel) u.unmarshal(new File(crawlGathereConfigFileName));
			return crawkGatgererConfig;

		} catch (JAXBException e) {
			showErrorMessage(e.toString());
			return null;
		}

	}

	
	public DBInfoConfigModel dbInfoConfigImport(String dbInfoConfigFileName) {
		try {

			dbInfoConfigFileName = dbInfoConfigFileName.replace("%appdata%", System.getenv("APPDATA"));
			DBInfoConfigModel dbInfoConfig = new DBInfoConfigModel();
			JAXBContext context = JAXBContext.newInstance(DBInfoConfigModel.class);
			Unmarshaller u = context.createUnmarshaller();

			dbInfoConfig = (DBInfoConfigModel) u.unmarshal(new File(dbInfoConfigFileName));
			return dbInfoConfig;

		} catch (JAXBException e) {
//			e.printStackTrace();
			showErrorMessage(e.toString());
			return null;
		}

	}

	public DFSSemimasterWrapperImportModel semimasterImport(String semiConfigFileName) {
		try {
			semiConfigFileName = semiConfigFileName.replace("%appdata%", System.getenv("APPDATA"));
			DFSSemimasterWrapperImportModel semimaster = new DFSSemimasterWrapperImportModel();
			JAXBContext context = JAXBContext.newInstance(DFSSemimasterWrapperImportModel.class);
			Unmarshaller u = context.createUnmarshaller();

			// semiConfigFileName = semiConfigFileName.replaceAll("\\\\",
			// "\\\\\\\\");
			// File tFile = new File(semiConfigFileName);

			semimaster = (DFSSemimasterWrapperImportModel) u.unmarshal(new File(semiConfigFileName));
			return semimaster;

		} catch (JAXBException e) {
//			e.printStackTrace();
			showErrorMessage(e.toString());
			return null;
		}

	}
	
	private void showErrorMessage(String message) {
		messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "IMPORT XML FILE ERROR",
				message, "");
		messageLog.showAndWait();
	}

}
