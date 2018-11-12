package com.digilog.meerkat.view.DFSGenerator.xml;

import java.io.File;
import java.io.IOException;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLAllInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.export.ExportCommonViewModel;
import com.digilog.meerkat.view.RootGeneralConfigViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorXMLExportInitViewController {

	private Stage dialogStage;

	@FXML
	private TextField SEMIFileNameField;
	@FXML
	private Button SEMI_Browser_Button;

	@FXML
	private TextField eDLCONFIGFileNameField;
	@FXML
	private Button eDLCONFIG_Browser_Button;

	@FXML
	private Button reset_Button;
	@FXML
	private Label modeLabel;
	@FXML
	private Button importMerge_Button;
	@FXML
	private Button Next_Button;
	@FXML
	private Button Exit_Button;
	@FXML
	private Button Cancel_Button;

	@FXML
	private TreeTableView<ExportCommonViewModel> dfsPathTableView;
	@FXML
	private TreeTableColumn<ExportCommonViewModel, String> databaseSourceNameTreeColumn;
	@FXML
	private TreeTableColumn<ExportCommonViewModel, String> modeTreeColumn;
	@FXML
	private TreeTableColumn<ExportCommonViewModel, String> filePathTreeColumn;
	@FXML
	private MenuItem dfsPathTableViewEditMenu;

	@FXML
	private TableView<DFSGeneratorXMLInfoModel> dbInfoTableView;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> modeColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> databaseSourceNameColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> databaseTypeColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> userNameColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> hostNameColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> passwordColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> portColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> dbiColumn;
	@FXML
	private TableColumn<DFSGeneratorXMLInfoModel, String> dBInfoPahtColumn;
	@FXML
	private MenuItem dbInfoTableViewEditMenu;

	static boolean saveXMLFile;
	private String eDLCONFIG_HOME;
	private String eDataRealm_HOME;
	private String SEMI_HOME;
	private String DFSCONFIG_HOME;
	private String DBINFO_HOME;
	private DFSGeneratorXMLAllInfoModel dfsGeneratorXMLAllInfoModel;
	private DFSGeneratorXMLInfoModel dfsGeneratorXMLInfoModel;
	private ObservableList<DFSGeneratorXMLInfoModel> dfsGeneratorXMLInfoModels;
	private ObservableList<DFSGeneratorXMLInfoModel> dfsGeneratorXMLInfoModelsClone;
	private DFSGeneratorXMLExportEditViewController dfsGeneratorXMLExportEditViewController;
	private ExportCommonViewModel SEMIMASTER;
	private TreeItem<ExportCommonViewModel> root;
	private String databaseSourceName;
	private String crawlerPath;
	private String gatherePath;
	private FileChooser fileChooser;
//	private File file;

	private void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void initialize() {
		saveXMLFile = false;
		fileChooser = new FileChooser();
		eDLCONFIG_HOME = RootGeneralConfigViewController.eDLHomePath + "\\eDataRealm\\conf\\";
		SEMIMASTER = new ExportCommonViewModel(null, "SEMIMASTER", "");
		root = new TreeItem<>(SEMIMASTER);

		dfsGeneratorXMLAllInfoModel = new DFSGeneratorXMLAllInfoModel();
		dfsGeneratorXMLInfoModel = new DFSGeneratorXMLInfoModel();
		dfsGeneratorXMLInfoModels = FXCollections.observableArrayList();
		dfsGeneratorXMLInfoModelsClone = FXCollections.observableArrayList();
		dfsGeneratorXMLExportEditViewController = new DFSGeneratorXMLExportEditViewController();
		
		databaseSourceNameTreeColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<ExportCommonViewModel, String> cellData) -> cellData.getValue()
						.getValue().databaseSourceProperty());
		databaseSourceNameTreeColumn.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		modeTreeColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<ExportCommonViewModel, String> cellData) -> cellData.getValue()
						.getValue().modeProperty());
		modeTreeColumn.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		filePathTreeColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<ExportCommonViewModel, String> cellData) -> cellData.getValue()
						.getValue().propertyProperty());
		filePathTreeColumn.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());

		modeColumn.setCellValueFactory(cellData -> cellData.getValue().modeProperty());
		modeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		databaseSourceNameColumn.setCellValueFactory(cellData -> cellData.getValue().databaseNameProperty());
		databaseSourceNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		databaseTypeColumn.setCellValueFactory(cellData -> cellData.getValue().eDLDatabaseTypeProperty());
		databaseTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userIDProperty());
		userNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		passwordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
		passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		hostNameColumn.setCellValueFactory(cellData -> cellData.getValue().hostNameProperty());
		hostNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		portColumn.setCellValueFactory(cellData -> cellData.getValue().portProperty());
		portColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		dbiColumn.setCellValueFactory(cellData -> cellData.getValue().sidProperty());
		dbiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		dBInfoPahtColumn.setCellValueFactory(cellData -> cellData.getValue().databaseInfoFileNameProperty());
		dBInfoPahtColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}


	@FXML
	private void handle_reset() {
		dfsPathTableView.setRoot(null);
		dbInfoTableView.getItems().clear();
		root = new TreeItem<>(SEMIMASTER);
		dfsGeneratorXMLAllInfoModel = new DFSGeneratorXMLAllInfoModel();
		dfsGeneratorXMLInfoModels = FXCollections.observableArrayList();
		dfsGeneratorXMLInfoModelsClone = FXCollections.observableArrayList();
		dfsGeneratorXMLAllInfoModel.setAllDone(false);
		dfsGeneratorXMLAllInfoModel.setCreateEDLConfig(false);
		dfsGeneratorXMLAllInfoModel.setCreateXMLFile(false);
		dfsGeneratorXMLAllInfoModel.setExitSaveFile(false);
		dfsGeneratorXMLAllInfoModel.setMarkInitData(true);
		setInitData(dfsGeneratorXMLAllInfoModel);	
	}
	
	@FXML
	private void handle_importMergeMode() {
//		file = new File(RootGeneralConfigViewController.eDataRealmConfigPath);
//		fileChooser.setInitialDirectory(new File(file.getAbsoluteFile().getParent()));
//		file = fileChooser.showOpenDialog(null);
//		if (file != null) {
//			DFSGeneratorXMLImportController realmConfigController = new DFSGeneratorXMLImportController();
//			dfsGeneratorXMLAllInfoModel.setEDataRealmFileName(file.getPath());
//			EDataRealmConfigModel realmConfig = realmConfigController.eDataRealmConfigImport(file.getPath());
//			setMergeData(realmConfig);
//			modeLabel.setText("Import & Merge");
//		} 
	}
	


//	private void setMergeData(EDataRealmConfigModel realmConfig) {
//		dfsGeneratorXMLAllInfoModel.setCreateMode(false);
//		for(DFSGeneratorXMLInfoModel tempModel : dfsGeneratorXMLInfoModelsClone)
//			tempModel.setMode("new");
//	main : for (EDataRealmConfigModel tempModel : realmConfig.getItem()) {
//			if ("MASTER_CONFIGURATIONS".equals(tempModel.getName())) {
//				dfsGeneratorXMLAllInfoModel.setSEMIFileName(tempModel.getItem().get(0).getValue().replace("%appdata%",System.getenv("appdata")));
//				file = new File(tempModel.getItem().get(0).getValue().replace("%appdata%",System.getenv("appdata")));
//				if(file.exists()) {
//					SEMIMASTER.setMode("I&M");
//					DFSSemimasterWrapperExportModel currentSemimaster = new DFSSemimasterWrapperExportModel();
//					DFSSemimasterController semiXMLMergeController = new DFSSemimasterController();
//					currentSemimaster = semiXMLMergeController.createXMLMergeSemimaster(dfsGeneratorXMLAllInfoModel, null);
//					
//					if(currentSemimaster.getDatatag().size()>0) {
//						List<String> dupList = new ArrayList<>();
//						for(DFSSemiDatatagExportModel temp : currentSemimaster.getDatatag()) {
//							for(DFSGeneratorAndDatabaseListModel tempTagModel : RootGeneralConfigViewController.databaseSourceModelList)
//								if (tempTagModel.getDfsGeneratorMainController().getController().getDFSDefineTableData().size() > 0) {
//									for (DFSDefineTableModel tempDatatag : tempTagModel.getDfsGeneratorMainController().getController().getDFSDefineTableData())
//										if (tempDatatag.getContentBoolean() == true) {
//											if(temp.getName().equals(tempDatatag.getData_tag_name()))
//												dupList.add(tempTagModel.getDatabaseSource()+","+tempDatatag.getData_tag_name()+","+tempDatatag.getAlias_name()
//												+","+temp.getDatasource()+","+temp.getName()+","+temp.getAlias());
//											else if(temp.getAlias().equals(tempDatatag.getAlias_name()))
//												dupList.add(tempTagModel.getDatabaseSource()+","+tempDatatag.getData_tag_name()+","+tempDatatag.getAlias_name()
//												+","+temp.getDatasource()+","+temp.getName()+","+temp.getAlias());
//										}		
//									}
//						}
//						
//						if(dupList.size()>0) {
//							for(String dup : dupList)
//								System.out.println(dup);
//							dupList = dupList.stream().distinct().collect(Collectors.toList());
//							for(String dup : dupList)
//								System.out.println("distinct : " + dup);
//						}
//							
//					}
//						
//					
//				} else {
//					
//				}
//				continue;
//			} else if ("DFS".equals(tempModel.getName())) {
//				for (EDataRealmConfigModel temp : tempModel.getItem()) {
//					if ("DATA_CRAWLER".equals(temp.getName())) {
//						if (temp.getItem().size() > 0)
//							for (EDataRealmConfigModel crawler : temp.getItem()) {
//								for (DFSGeneratorXMLInfoModel info : dfsGeneratorXMLInfoModelsClone) {
//									if (crawler.getName().equals(info.getDatabaseName())) {
//										info.setMode("I&M");
//										info.setCrawlerFileName(crawler.getItem().get(0).getValue().replace("%appdata%",System.getenv("appdata")));
//										break;
//									}
//								}
//							}				
//					} else if ("DATA_GATHERER".equals(temp.getName())) {
//						if (temp.getItem().size() > 0)
//							for (EDataRealmConfigModel gatherer : temp.getItem())
//								for (DFSGeneratorXMLInfoModel info :dfsGeneratorXMLInfoModelsClone) {
//									System.out.println(gatherer.getName());
//									System.out.println(info.getDatabaseName());
//									if (gatherer.getName().equals(info.getDatabaseName())) {
//										info.setGathererFileName(gatherer.getItem().get(0).getValue().replace("%appdata%",System.getenv("appdata")));
//										break;
//									}
//								}
//					}
//				}
//			} else if ("DBINFO".equals(tempModel.getName())) {
//				if (tempModel.getItem().size() > 0)
//					for (EDataRealmConfigModel dbInfo : tempModel.getItem())
//						for (DFSGeneratorXMLInfoModel info : dfsGeneratorXMLInfoModelsClone)
//							if (dbInfo.getName().equals(info.getDatabaseName())) {
//								info.setDatabaseInfoFileName(dbInfo.getItem().get(0).getValue().replace("%appdata%",System.getenv("appdata")));
//							}
//				
//			}
//		}
//
//			for (DFSGeneratorXMLInfoModel tempDB : dfsGeneratorXMLInfoModelsClone) {
//				if(tempDB.getMode().equals("I&M")) {
//					String dbInfoString = null;
//					file = new File(tempDB.getDatabaseInfoFileName().replace("%appdata%",System.getenv("appdata")));
//					DFSGeneratorXMLImportController dbConfigController = new DFSGeneratorXMLImportController();
//					if(file.exists()) {
//						DBInfoConfigModel dbConfig = dbConfigController.dbInfoConfigImport(file.getPath());
//						for (DBInfoConfigModel info : dbConfig.getItem()) {
//							if ("URL".equals(info.getName())) {
//								dbInfoString = info.getValue();
//								String dbInfo[]=dbInfoString.split(":");
//								tempDB.setEDLDatabaseType(dbInfo[1].substring(0, 1).toUpperCase() + dbInfo[1].substring(1).toLowerCase());
//								tempDB.setHostName(dbInfo[3].replace("@",""));
//								tempDB.setPort(dbInfo[4]);
//								tempDB.setSid(dbInfo[5]);
//							}
//							else if ("USER_NAME".equals(info.getName())) {
//								tempDB.setUserID(info.getValue());
//								break;
//							}
//						}
//					} else {
//						System.out.println(file.getPath()+" no file");
//					}
//				}
//			}
//		setShowUI(dfsGeneratorXMLAllInfoModel, dfsGeneratorXMLInfoModelsClone, root);
//	}


	private void setInitData(DFSGeneratorXMLAllInfoModel dfsXMLAllInfoInput) {

		setSemiAndeDLConfigHomePath();
		setCrawlerGathererHomePath();
		setDBInfoHomePath();

		dfsXMLAllInfoInput.setExitSaveFile(false);
		if(!dfsXMLAllInfoInput.isCreateMode())
			modeLabel.setText("Import");
		if (dfsXMLAllInfoInput.isMarkInitData()) {
			modeLabel.setText("Create New");
			String semiconfigFile = SEMI_HOME + "SEMIMasterConfig.xml";
			String eDataRealmXConfigFile = eDataRealm_HOME + "eDataRealmConfigForWindows.xml";
			dfsGeneratorXMLAllInfoModel.setCreateMode(true);
			dfsGeneratorXMLAllInfoModel.setSEMIFileName(semiconfigFile);
			dfsGeneratorXMLAllInfoModel.setEDataRealmFileName(eDataRealmXConfigFile);
			dfsGeneratorXMLAllInfoModel.setDfsGeneratorXMLInfoModel(FXCollections.observableArrayList());
		} else {
			dfsGeneratorXMLAllInfoModel = dfsXMLAllInfoInput;
			SEMIFileNameField.setText(dfsGeneratorXMLAllInfoModel.getSEMIFileName());
			eDLCONFIGFileNameField.setText(dfsGeneratorXMLAllInfoModel.getEDataRealmFileName());
		}

		for (DFSGeneratorAndDatabaseListModel tempModel : RootGeneralConfigViewController.databaseSourceModelList) {
			if (tempModel.isExport()) {
				databaseSourceName = tempModel.getDatabaseSource();
				boolean markInitData = true;
				if (dfsGeneratorXMLAllInfoModel.getDfsGeneratorXMLInfoModel() != null
						&& dfsGeneratorXMLAllInfoModel.getDfsGeneratorXMLInfoModel().size() > 0) {
					for (DFSGeneratorXMLInfoModel tempLevel : dfsGeneratorXMLAllInfoModel.getDfsGeneratorXMLInfoModel()) {
						if (databaseSourceName.equals(tempLevel.getDatabaseName())) {
							crawlerPath = tempLevel.getCrawlerFileName();
							gatherePath = tempLevel.getGathererFileName();
							dfsGeneratorXMLInfoModels.add(tempLevel);
							markInitData = false;
							break;
						}
					}
					if (markInitData) {
						setDFSGeneratorXMLInfoModel(tempModel);
						crawlerPath = DFSCONFIG_HOME + tempModel.getDatabaseSource() + "Crawler.xml";
						gatherePath = DFSCONFIG_HOME + tempModel.getDatabaseSource() + "Gatherer.xml";
					}
				} else {
					setDFSGeneratorXMLInfoModel(tempModel);
					crawlerPath = DFSCONFIG_HOME + tempModel.getDatabaseSource() + "Crawler.xml";
					gatherePath = DFSCONFIG_HOME + tempModel.getDatabaseSource() + "Gatherer.xml";
				}

				TreeItem<ExportCommonViewModel> temp = createTreeViewItem(databaseSourceName, crawlerPath, gatherePath, tempModel.isImported());
				temp.setExpanded(true);
				root.getChildren().add(temp);
			}
		}
		for (DFSGeneratorXMLInfoModel temp : dfsGeneratorXMLInfoModels) {
			try {
				dfsGeneratorXMLInfoModelsClone.add(temp.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}

		setShowUI(dfsGeneratorXMLAllInfoModel, dfsGeneratorXMLInfoModelsClone, root);
	}
	

	private void setShowUI(DFSGeneratorXMLAllInfoModel dfsGeneratorXMLAllInfoModel, ObservableList<DFSGeneratorXMLInfoModel> dfsGeneratorXMLInfoModels, TreeItem<ExportCommonViewModel> root) {
		root.setExpanded(true);
		SEMIFileNameField.setText(dfsGeneratorXMLAllInfoModel.getSEMIFileName());
		eDLCONFIGFileNameField.setText(dfsGeneratorXMLAllInfoModel.getEDataRealmFileName());
		dfsPathTableView.setRoot(root);
		for(DFSGeneratorXMLInfoModel tempModel : dfsGeneratorXMLInfoModels)
			tempModel.setPassword("*1)");
		dbInfoTableView.setItems(dfsGeneratorXMLInfoModels);
		for(DFSGeneratorXMLInfoModel tempModel : dfsGeneratorXMLInfoModels)
			setTreeView(tempModel);
		
	}

	
	private void setTreeView(DFSGeneratorXMLInfoModel dfsGeneratorXMLInfoModel) {
		for (int i = 0; i < root.getChildren().size(); i++) {
			if (dfsGeneratorXMLInfoModel.getDatabaseName().equals(root.getChildren().get(i).getValue().getDatabaseSource())) {
				root.getChildren().get(i).getValue().setMode(dfsGeneratorXMLInfoModel.getMode());
				root.getChildren().get(i).getChildren().get(0).getValue().setProperty(dfsGeneratorXMLInfoModel.getCrawlerFileName());
				root.getChildren().get(i).getChildren().get(0).getValue().setMode(dfsGeneratorXMLInfoModel.getMode());
				root.getChildren().get(i).getChildren().get(1).getValue().setProperty(dfsGeneratorXMLInfoModel.getGathererFileName());
				root.getChildren().get(i).getChildren().get(1).getValue().setMode(dfsGeneratorXMLInfoModel.getMode());
				break;
			}
		}
	}
	private void setDFSGeneratorXMLInfoModel(DFSGeneratorAndDatabaseListModel tempModel) {
		dfsGeneratorXMLInfoModels.add(new DFSGeneratorXMLInfoModel(false, "new", tempModel.getDatabaseSource(),
				DFSCONFIG_HOME + tempModel.getDatabaseSource() + "Crawler.xml",
				DFSCONFIG_HOME + tempModel.getDatabaseSource() + "Gatherer.xml",
				tempModel.getDfsDatabaseConnectionModel().getDatabaseType(),
				tempModel.getDfsDatabaseConnectionModel().getUserID(), "*1)",
				tempModel.getDfsDatabaseConnectionModel().getHostName(),
				tempModel.getDfsDatabaseConnectionModel().getPort(), tempModel.getDfsDatabaseConnectionModel().getDbi(),
				DBINFO_HOME + tempModel.getDatabaseSource() + "INFO.xml"));
	}

	@FXML
	private void handle_semi_browser() {
		String semiDir = SEMI_HOME;
		semiDir = semiDir.replaceAll("\\\\", "\\/");
		fileChooser.setInitialDirectory(new File(semiDir));
		String path = fileChooser.showSaveDialog(null).getPath();
		if (path != null)
			dfsGeneratorXMLAllInfoModel.setSEMIFileName(path);
		SEMIFileNameField.setText(dfsGeneratorXMLAllInfoModel.getSEMIFileName());
	}

	@FXML
	private void handle_eDLCONFIG_browser() {
		String eDataRealmDir = eDataRealm_HOME;
		eDataRealmDir = eDataRealmDir.replaceAll("\\\\", "\\/");
		fileChooser.setInitialDirectory(new File(eDataRealmDir));
		String path = fileChooser.showSaveDialog(null).getPath();
		if (path != null)
			dfsGeneratorXMLAllInfoModel.setEDataRealmFileName(path);
		eDLCONFIGFileNameField.setText(dfsGeneratorXMLAllInfoModel.getEDataRealmFileName());
	}

	@FXML
	private void handle_dfsPathTableViewEdit() {
		int selectedIdx = dfsPathTableView.getSelectionModel().getSelectedIndex();
		if (selectedIdx > 0) {

			dbInfoTableView.getSelectionModel().clearSelection();

			if (selectedIdx % 3 == 1) {
				databaseSourceName = dfsPathTableView.getTreeItem(selectedIdx).getValue().getDatabaseSource();
			} else {
				databaseSourceName = dfsPathTableView.getTreeItem(selectedIdx).getParent().getValue()
						.getDatabaseSource();
			}

			for (DFSGeneratorXMLInfoModel tempModel : dbInfoTableView.getItems())
				if (databaseSourceName.equals(tempModel.getDatabaseName()))
					dfsGeneratorXMLInfoModel = tempModel;
			DFSGeneratorXMLInfoModel tempModel = new DFSGeneratorXMLInfoModel();
			tempModel = dfsGeneratorXMLExportEditViewController.showExportXMLEditDialog(dfsGeneratorXMLInfoModel);
			if (tempModel != null) {
				dfsGeneratorXMLInfoModel = tempModel;
				setTreeView(dfsGeneratorXMLInfoModel);
			}

		} else if (selectedIdx == 0)
			System.out.println("GO TO SEMI");
	}

	@FXML
	private void handle_dbInfoTableViewEdit() {
		int selectedIdx = dbInfoTableView.getSelectionModel().getSelectedIndex();
		if (selectedIdx >= 0) {
			dfsPathTableView.getSelectionModel().clearSelection();
			String databaseSourceName = dbInfoTableView.getItems().get(selectedIdx).getDatabaseName();

			for (DFSGeneratorXMLInfoModel tempModel : dbInfoTableView.getItems())
				if (databaseSourceName.equals(tempModel.getDatabaseName()))
					dfsGeneratorXMLInfoModel = tempModel;

			DFSGeneratorXMLInfoModel tempModel = new DFSGeneratorXMLInfoModel();
			tempModel = dfsGeneratorXMLExportEditViewController.showExportXMLEditDialog(dfsGeneratorXMLInfoModel);
			if (tempModel != null) {
				dfsGeneratorXMLInfoModel = tempModel;
				setTreeView(dfsGeneratorXMLInfoModel);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private TreeItem<ExportCommonViewModel> createTreeViewItem(String datasourceName, String crawlerPath,
			String gatherePath, boolean imported) {
		
		String mode="new";
		if(imported) 
			mode="import";
		
		ExportCommonViewModel parent = new ExportCommonViewModel(mode, datasourceName, "");
		ExportCommonViewModel crawler = new ExportCommonViewModel(mode, datasourceName + "Crawler", crawlerPath);
		ExportCommonViewModel gathere = new ExportCommonViewModel(mode, datasourceName + "Gatherer", gatherePath);
		TreeItem<ExportCommonViewModel> parentNode = new TreeItem<>(parent);
		parentNode.getChildren().addAll(new TreeItem<>(crawler), new TreeItem<>(gathere));
		return parentNode;
	}

	private void setSemiAndeDLConfigHomePath() {
		SEMI_HOME = eDLCONFIG_HOME + "MasterConfig\\";
		eDataRealm_HOME = eDLCONFIG_HOME + "eDataRealm\\";
	}

	private void setCrawlerGathererHomePath() {
		DFSCONFIG_HOME = eDLCONFIG_HOME + "DFSConfig\\";
	}

	private void setDBInfoHomePath() {
		DBINFO_HOME = eDLCONFIG_HOME + "Database\\";
	}

	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}

	@FXML
	private void handle_Exit() {
		saveXMLFile = true;
		dfsGeneratorXMLAllInfoModel.setCreateXMLFile(false);
		dfsGeneratorXMLAllInfoModel.setExitSaveFile(true);
		dfsGeneratorXMLAllInfoModel.setSEMIFileName(SEMIFileNameField.getText());
		dfsGeneratorXMLAllInfoModel.setEDataRealmFileName(eDLCONFIGFileNameField.getText());
		dfsGeneratorXMLAllInfoModel.setDfsGeneratorXMLInfoModel(dfsGeneratorXMLInfoModels);
		dialogStage.close();
	}

	@FXML
	private void handle_Next() {
		saveXMLFile = true;
		dfsGeneratorXMLAllInfoModel.setCreateXMLFile(true);
		dfsGeneratorXMLAllInfoModel.setSEMIFileName(SEMIFileNameField.getText());
		dfsGeneratorXMLAllInfoModel.setEDataRealmFileName(eDLCONFIGFileNameField.getText());
		dfsGeneratorXMLAllInfoModel.setDfsGeneratorXMLInfoModel(dfsGeneratorXMLInfoModels);
		dialogStage.close();
	}

	private DFSGeneratorXMLAllInfoModel getDFSGeneratorXMLAllInfoModel() {
		return dfsGeneratorXMLAllInfoModel;
	}

	public DFSGeneratorXMLAllInfoModel showExportXMLDialog(DFSGeneratorXMLAllInfoModel dfsXMLAllInfoClone) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/xml/DFSGeneratorXMLExportInitView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Export DFS Config XML File");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorXMLExportInitViewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setInitData(dfsXMLAllInfoClone);

			dialogStage.showAndWait();

			if (saveXMLFile == true)
				return controller.getDFSGeneratorXMLAllInfoModel();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
