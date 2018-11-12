package com.digilog.meerkat.view.DFSGenerator.xml;

import java.io.IOException;
import java.text.DecimalFormat;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExportController;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExportDBInfoController;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExportFileController;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExportLog4j2Controller;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Export.DFSGeneratorXMLExporteDLWindowsConfigController;
import com.digilog.meerkat.DFSGeneratorController.semimaster.DFSSemimasterController;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemimasterWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DBInfoConfigModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLAllInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.EDataRealmConfigModel;
import com.digilog.meerkat.model.dfsGenerator.xml.export.ExportCommonViewModel;
import com.digilog.meerkat.view.RootGeneralConfigViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorXMLExportProgressViewController {

	private Stage dialogStage;
	static boolean createXMLFile;
	double totalFileCnt = 0;
	double progressStart = 0;

	@FXML
	private TreeTableView<ExportCommonViewModel> dfsFileListTreeView;
	@FXML
	private TreeTableColumn<ExportCommonViewModel, String> databaseSourceTagNameTreeColumn;
	@FXML
	private TreeTableColumn<ExportCommonViewModel, String> AliasTreeColumn;
	@FXML
	private TreeTableColumn<ExportCommonViewModel, Boolean> dfsDoneTreeColumn;

	@FXML
	private TableView<ExportCommonViewModel> configFileListTableView;
	@FXML
	private TableColumn<ExportCommonViewModel, String> configListTableColumn;
	@FXML
	private TableColumn<ExportCommonViewModel, String> filePathTableColumn;
	@FXML
	private TableColumn<ExportCommonViewModel, Boolean> configDoneTableColumn;
	@FXML
	private CheckBox onlyDFS;
	
	@FXML
	private Button Back_Button;
	@FXML
	private Button Export_Button;
	@FXML
	private Button Cancel_Button;
	@FXML
	private Label xmlProgressPer;
	@FXML
	private ProgressBar xmlProgressBar;

	private DFSGeneratorXMLAllInfoModel dfsCreateXMLAllInfo;
	private ExportCommonViewModel createSEMIMASTER;
	private TreeItem<ExportCommonViewModel> root;
	private ObservableList<ExportCommonViewModel> onlyDFSconfigList;
	private ObservableList<ExportCommonViewModel> allConfigList;
	private ObservableList<DFSSemimasterWrapperExportModel> semiModels;
	private DFSGeneratorXMLExportFileController expFilectl;

	static boolean allDone;
	static boolean backward;
	DecimalFormat df;

	public DFSGeneratorXMLExportProgressViewController() {
		semiModels = FXCollections.observableArrayList();
		expFilectl = new DFSGeneratorXMLExportFileController();
	}

	private void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void initialize() {
		databaseSourceTagNameTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ExportCommonViewModel, String> cellData) -> cellData.getValue().getValue().databaseSourceProperty());
		databaseSourceTagNameTreeColumn.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		AliasTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ExportCommonViewModel, String> cellData) -> cellData.getValue().getValue().propertyProperty());
		AliasTreeColumn.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		dfsDoneTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ExportCommonViewModel, Boolean> cellData) -> cellData.getValue().getValue().doneProperty());
		dfsDoneTreeColumn.setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(dfsDoneTreeColumn));

		configListTableColumn.setCellValueFactory(cellData -> cellData.getValue().databaseSourceProperty());
		configListTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		filePathTableColumn.setCellValueFactory(cellData -> cellData.getValue().propertyProperty());
		filePathTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		configDoneTableColumn.setCellValueFactory(cellData -> cellData.getValue().doneProperty());
		configDoneTableColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));

//		onlyDFS.setSelected(true);
//		configFileListTableView.setDisable(true);
		df = new DecimalFormat("#");
	}

	@FXML
	private void handle_onlyDFS() {
		if (onlyDFS.isSelected()) {
//			configFileListTableView.setDisable(true);
			configFileListTableView.setItems(onlyDFSconfigList);
		} else {
//			configFileListTableView.setDisable(false);
			configFileListTableView.setItems(allConfigList);
		}
	}

//	@FXML
//	private void handle_mode() {
//		if (mode_Button.isSelected()) {
//			mode_Button.setText("Create Mode");
//			configFileListTableView.setItems(createModelList);		
//		} else {
//			mode_Button.setText("Modify & Add Mode");
//			File file = new File(RootGeneralConfigViewController.eDataRealmConfigPath);
//			if(file.exists()) {
//				createImportConfigInfo(file.getPath());
//				configFileListTableView.setItems(modifyModelList);
//			}
//			else
//				System.out.println("NO");
			
			
			
//			configFileListTableView.setItems(null); //config all load window, semi,		
//		}
//	}
	
//	private void createImportConfigInfo(String eDataRealmConfigFileName) {
//		DFSGeneratorXMLImportController realmConfigController = new DFSGeneratorXMLImportController();
//		EDataRealmConfigModel realmConfig = realmConfigController.eDataRealmConfigImport(eDataRealmConfigFileName);
//		dfsModifyXMLAllInfo.setEDataRealmFileName(eDataRealmConfigFileName);
//		dfsModifyXMLAllInfo.set
//		modifyModelList = FXCollections.observableArrayList();
//		modifyModelList.add(new ExportCommonViewModel("eDataRealm Config For Windows", eDataRealmConfigFileName, false));
//		modifyModelList.add(new ExportCommonViewModel("Log4j2", RootGeneralConfigViewController.log4j2FileNamePath, false));
//		modifyModelList.add(new ExportCommonViewModel("eDataLayzer Log", RootGeneralConfigViewController.logFileNamePath, false));
////		for (DFSGeneratorXMLInfoModel tempModel : dfsCreateXMLAllInfo.getDfsGeneratorXMLInfoModel())
////			createModelList.add(new ExportCommonViewModel(tempModel.getDatabaseName(), tempModel.getDatabaseInfoFileName(), false));
//		
//		for(EDataRealmConfigModel tempModel : realmConfig.getItem()) {
//			if("MASTER_CONFIGURATIONS".equals(tempModel.getName())) {
//				System.out.println((tempModel.getItem().get(0).getValue()));
//				dfsModifyXMLAllInfo.setSEMIFileName(tempModel.getItem().get(0).getValue());
//			}
//			else if("DFS".equals(tempModel.getName())) {
//				for(EDataRealmConfigModel temp : tempModel.getItem()) {
//					if("DATA_CRAWLER".equals(temp.getName())) {
//						if(temp.getItem().size()>0)
//							for(EDataRealmConfigModel crawler : temp.getItem())
//								System.out.println(crawler.getName());
//					} else if("DATA_GATHERER".equals(temp.getName())) {
//						if(temp.getItem().size()>0)
//							for(EDataRealmConfigModel gatherer : temp.getItem())
//								System.out.println(gatherer.getName());
//					}
//				}
//			} else if("DBINFO".equals(tempModel.getName())) {
//					if(tempModel.getItem().size()>0)
//						for(EDataRealmConfigModel dbInfo : tempModel.getItem())
//							System.out.println(dbInfo.getName());
//			}
//				
//		}
//	}

	@FXML
	private void handle_Back() {
		dialogStage.close();
	}

	@FXML
	private void handle_Cancel() {
		backward = false;
		dialogStage.close();
	}

	@FXML
	private void handle_Export() {
		if (allDone)
			dialogStage.close();
		else {
			createXMLFile = true;
			executeExportXML();
			Export_Button.setText("Done");
			Cancel_Button.setDisable(true);
			Back_Button.setDisable(true);
			allDone = true;
		}
	}

	public boolean showExportXMLDialog(DFSGeneratorXMLAllInfoModel dfsXMLAllInfo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					MeerkatMainApp.class.getResource("view/DFSGenerator/xml/DFSGeneratorXMLExportProgressView.fxml"));
			GridPane page = (GridPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Execute Export DFS Config XML File");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorXMLExportProgressViewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setInitConfig(dfsXMLAllInfo);

			dialogStage.showAndWait();
			if (createXMLFile == true) {
				dfsXMLAllInfo.setAllDone(true);
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return backward;
	}

	public void executeExportXML() {
		int progressPer = 0;
		for (DFSGeneratorAndDatabaseListModel databaseListModel : RootGeneralConfigViewController.databaseSourceModelList) {
			if (databaseListModel.isExport()) {
				for (DFSGeneratorXMLInfoModel dfsXMLInfoModel : dfsCreateXMLAllInfo.getDfsGeneratorXMLInfoModel())
					if (databaseListModel.getDatabaseSource().equals(dfsXMLInfoModel.getDatabaseName())) {
						DFSSemimasterWrapperExportModel tempSemiModel = new DFSSemimasterWrapperExportModel();
						DFSGeneratorXMLExportController dfsXMLExportController = new DFSGeneratorXMLExportController();
						tempSemiModel = dfsXMLExportController.createDFSXMLFile(databaseListModel, dfsXMLInfoModel);
						semiModels.add(tempSemiModel);
						for (TreeItem<ExportCommonViewModel> tempModel : root.getChildren())
							if (dfsXMLInfoModel.getDatabaseName().equals(tempModel.getValue().getDatabaseSource())) {
								tempModel.getValue().setDone(true);
								for (TreeItem<ExportCommonViewModel> temp : tempModel.getChildren()) {
									temp.getValue().setDone(true);
									xmlProgressPer.setText(":  " + df.format((++progressPer / totalFileCnt) * 100) + "%");
									xmlProgressBar.setProgress(++progressStart / totalFileCnt);
								}
							}
						break;
					}
			}
		}

		DFSSemimasterWrapperExportModel semimaster = new DFSSemimasterWrapperExportModel();
		DFSSemimasterController semiXMLMergeController = new DFSSemimasterController();
		semimaster = semiXMLMergeController.createXMLMergeSemimaster(dfsCreateXMLAllInfo, semiModels);
		expFilectl.semimasterExport(dfsCreateXMLAllInfo.getSEMIFileName(), semimaster);
		root.getValue().setDone(true);
		
		DFSGeneratorXMLExporteDLWindowsConfigController eDLRealmConfigCtl = new DFSGeneratorXMLExporteDLWindowsConfigController();
		EDataRealmConfigModel eDLConfigXML = eDLRealmConfigCtl.createEDLWindowsConfigFile(dfsCreateXMLAllInfo);
		expFilectl.eDLConfigExport(dfsCreateXMLAllInfo.getEDataRealmFileName(), eDLConfigXML);
		
		// TODO
		DFSGeneratorXMLExportDBInfoController dbInfoConfigCtl = new DFSGeneratorXMLExportDBInfoController();
		for(DFSGeneratorXMLInfoModel tempModel : dfsCreateXMLAllInfo.getDfsGeneratorXMLInfoModel()) {
			DBInfoConfigModel dbInfo = dbInfoConfigCtl.createDBInfoFile(tempModel);
			expFilectl.dbInfoExport(tempModel.getDatabaseInfoFileName(), dbInfo);
		}
		
		DFSGeneratorXMLExportLog4j2Controller logCtl = new DFSGeneratorXMLExportLog4j2Controller();
		logCtl.createLog4j2File();
		
		
		
		
		xmlProgressPer.setText(":  " + df.format((++progressPer / totalFileCnt) * 100) + "%");
		xmlProgressBar.setProgress(++progressStart / totalFileCnt);
	}

	public void setInitConfig(DFSGeneratorXMLAllInfoModel dfsXMLAllInfo) {
		dfsCreateXMLAllInfo = new DFSGeneratorXMLAllInfoModel(dfsXMLAllInfo.isCreateMode(), dfsXMLAllInfo.isMarkInitData(),
				dfsXMLAllInfo.isCreateXMLFile(), dfsXMLAllInfo.isCreateEDLConfig(), dfsXMLAllInfo.getSEMIFileName(), dfsXMLAllInfo.getEDataRealmFileName());
		for (DFSGeneratorAndDatabaseListModel tempModel : RootGeneralConfigViewController.databaseSourceModelList) {
			if (tempModel.isExport()) {
				for(DFSGeneratorXMLInfoModel tempXMLInfo : dfsXMLAllInfo.getDfsGeneratorXMLInfoModel()) {
					if(tempModel.getDatabaseSource().equals(tempXMLInfo.getDatabaseName()))
						dfsCreateXMLAllInfo.getDfsGeneratorXMLInfoModel().add(tempXMLInfo);
				}
			
			}
		}
		
		createXMLFile = false;
		allDone = false;
		backward = true;
		createSEMIMASTER = new ExportCommonViewModel("SEMIMASTER", "", false);
		root = new TreeItem<>(createSEMIMASTER);
		ExportCommonViewModel level1;
		ExportCommonViewModel level2;

		int exportListCount = RootGeneralConfigViewController.databaseSourceModelList.size();
		int exportCheckCount = 0;
		for (DFSGeneratorAndDatabaseListModel tempModel : RootGeneralConfigViewController.databaseSourceModelList) {
			if (tempModel.isExport()) {
				exportCheckCount++;
				level1 = new ExportCommonViewModel(tempModel.getDatabaseSource(), null, false);
				TreeItem<ExportCommonViewModel> parentNode = new TreeItem<>(level1);
				if (tempModel.getDfsGeneratorMainController().getController().getDFSDefineTableData().size() > 0) {
					int datatagTotalCnt = tempModel.getDfsGeneratorMainController().getController()
							.getDFSDefineTableData().size();
					int datatagExportCnt = 0;
					for (DFSDefineTableModel tempChild : tempModel.getDfsGeneratorMainController().getController()
							.getDFSDefineTableData())
						if (tempChild.getContentBoolean() == true) {
							level2 = new ExportCommonViewModel(tempChild.getData_tag_name(), tempChild.getAlias_name(),
									false);
							parentNode.getChildren().add(new TreeItem<>(level2));
							datatagExportCnt++;
						}
					if (parentNode.getChildren().size() > 0) {
						parentNode.getValue().setProperty("Data Tag : " + datatagExportCnt + " / " + datatagTotalCnt);
						totalFileCnt += datatagExportCnt;
						root.getChildren().add(parentNode);
						parentNode.setExpanded(true);
					}
				}
			}
		}

		onlyDFSconfigList = FXCollections.observableArrayList();
		onlyDFSconfigList.add(new ExportCommonViewModel("eDataRealm Config For Windows", dfsCreateXMLAllInfo.getEDataRealmFileName(), false));
		onlyDFSconfigList.add(new ExportCommonViewModel("SEMIMASTER Conifg", dfsCreateXMLAllInfo.getSEMIFileName(), false));
		for (DFSGeneratorXMLInfoModel tempModel : dfsCreateXMLAllInfo.getDfsGeneratorXMLInfoModel()) {
			onlyDFSconfigList.add(new ExportCommonViewModel(tempModel.getDatabaseName()+"Crawler",tempModel.getCrawlerFileName(),false));
			onlyDFSconfigList.add(new ExportCommonViewModel(tempModel.getDatabaseName()+"Gatherer",tempModel.getGathererFileName(),false));
		}
		
		allConfigList = FXCollections.observableArrayList();
		allConfigList.add(new ExportCommonViewModel("eDataRealm Config For Windows", dfsCreateXMLAllInfo.getEDataRealmFileName(), false));
		allConfigList.add(new ExportCommonViewModel("SEMIMASTER Conifg", dfsCreateXMLAllInfo.getSEMIFileName(), false));
		for (DFSGeneratorXMLInfoModel tempModel : dfsCreateXMLAllInfo.getDfsGeneratorXMLInfoModel()) {
			allConfigList.add(new ExportCommonViewModel(tempModel.getDatabaseName()+"Crawler",tempModel.getCrawlerFileName(),false));
			allConfigList.add(new ExportCommonViewModel(tempModel.getDatabaseName()+"Gatherer",tempModel.getGathererFileName(),false));
		}
		allConfigList.add(new ExportCommonViewModel("Log4j2", RootGeneralConfigViewController.log4j2FileNamePath, false));
		allConfigList.add(new ExportCommonViewModel("eDataLayzer Log", RootGeneralConfigViewController.logFileNamePath, false));	
		for (DFSGeneratorXMLInfoModel tempModel : dfsCreateXMLAllInfo.getDfsGeneratorXMLInfoModel())
			allConfigList.add(new ExportCommonViewModel(tempModel.getDatabaseName(), tempModel.getDatabaseInfoFileName(), false));
		
		configFileListTableView.setItems(allConfigList);
		root.getValue().setProperty("Data Source : " + exportCheckCount + " / " + exportListCount+ "    Total File : " + df.format(++totalFileCnt));
		root.setExpanded(true);
		dfsFileListTreeView.setRoot(root);
	}
}
