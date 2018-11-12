package com.digilog.meerkat.view;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.DBcontroller.database.DatabaseDAO;
import com.digilog.meerkat.DFSGeneratorController.semimaster.DFSSemiMasterDefineMasterInitDataController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.attribute.SQLStatements;
import com.digilog.meerkat.model.dfsGenerator.DFSDatabaseConnectionModel;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.model.dfsGenerator.SimpleTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSGeneratorImportWholeInfo;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineDatatagInitItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineInitModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLAllInfoModel;
import com.digilog.meerkat.util.MessageDialog;
import com.digilog.meerkat.util.SearchIndex;
import com.digilog.meerkat.view.DFSGenerator.DFSGeneratorMainViewController;
import com.digilog.meerkat.view.DFSGenerator.semiMaster.DFSGeneratorSemiMasterDefineController;
import com.digilog.meerkat.view.DFSGenerator.xml.DFSGeneratorXMLExportInitViewController;
import com.digilog.meerkat.view.DFSGenerator.xml.DFSGeneratorXMLExportProgressViewController;
import com.digilog.meerkat.view.DFSGenerator.xml.DFSGeneratorXMLImportViewController;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;

public class RootGeneralConfigViewController {

	private MessageDialog mDialog = new MessageDialog();;
	private Alert messageLog;

	@FXML
	private GridPane mainFrameGridPane;
	@FXML
	private MenuBar menuViewBar;
	@FXML
	private VBox mainMenuVBox;
	@FXML
	private AnchorPane mainViewAnchorPane;
	@FXML
	private VBox generalConfigurationView;
	@FXML
	private Button generalConfigurationMB;
	@FXML
	private Button autoLorderMB;
	@FXML
	private Button preInspectionDataReportMB;
	@FXML
	private TitledPane dfsGeneratorTitledPane;
	@FXML
	private Button SEMIMasterSB;

	@FXML
	private TableView<DFSGeneratorAndDatabaseListModel> databaseSourceView;
	@FXML
	private TableColumn<DFSGeneratorAndDatabaseListModel, Boolean> exportBooleanColumn;
	@FXML
	private TableColumn<DFSGeneratorAndDatabaseListModel, String> databaseNameColumn;
	@FXML
	private Button logWatcherMB;
	@FXML
	private Menu themeView;
	@FXML
	private MenuItem defaultTheme;
	@FXML
	private MenuItem chicBlack;
	@FXML
	private MenuItem NewfromTemplate;
	@FXML
	private MenuItem DeleteMenu;
	@FXML
	private MenuItem about;
	
	@FXML
	private MenuItem eDLExportXmlMenu;
	@FXML
	private MenuItem eDLImportXmlMenu;

	@FXML
	private TableView<DFSDatabaseConnectionModel> DFSDatabaseTableView;
	@FXML
	private TableColumn<DFSDatabaseConnectionModel, String> statusColumn;
	@FXML
	private TableColumn<DFSDatabaseConnectionModel, String> databaseSourceNameColumn;
	@FXML
	private TableColumn<DFSDatabaseConnectionModel, String> databaseTypeColumn;
	@FXML
	private TableColumn<DFSDatabaseConnectionModel, String> userNameColumn;
	@FXML
	private TableColumn<DFSDatabaseConnectionModel, String> hostNameColumn;
	@FXML
	private TableColumn<DFSDatabaseConnectionModel, String> portColumn;
	@FXML
	private TableColumn<DFSDatabaseConnectionModel, String> dbiColumn;
	@FXML
	private ContextMenu addDFGConfigMenu;
	@FXML
	private MenuItem addSelectedItemsToDFGConfig;
	@FXML
	private MenuItem preInspectionDataReport;
	@FXML
	private ComboBox<String> database;
	@FXML
	private TextField databaseSourceNameField;
	@FXML
	private TextField hostNameField;
	@FXML
	private TextField portField;
	@FXML
	private TextField sidField;
	@FXML
	private TextField userIDField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private CheckBox passwordSave;
	@FXML
	private CheckBox addAndConnect;
	@FXML
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button testButton;
	@FXML
	private Button connectButton;
	@FXML
	private Button disconnectButton;
	@FXML
	private Label connectionTestResultMessage;

	@FXML
	private CheckBox eDataLyzerBasicConfig;
	@FXML
	private TextField eDLHomePathField;
	@FXML
	private Button eDLHomeBrowseButton;
	@FXML
	private TextField eDataRealmWindowsConfigPathField;
	@FXML
	private Button eDataRealmWindowsConfigButton;
	@FXML
	private TextField DFSGHomePathField;
	@FXML
	private Button DFSGHomeBrowseButton;
	@FXML
	private TextField pg_defaultPathField;
	@FXML
	private Button pg_defaultBrowseButton;
	@FXML
	private TextField log4j2PathField;
	@FXML
	private Button log4j2BrowseButton;
	@FXML
	private ComboBox<String> LogLevelBox;
	@FXML
	private TextField logFileNameField;
	@FXML
	private Button logFileButton;

	public static String appDataPath;
	public static String eDLHomePath;
	public static String eDataRealmConfigPath;
	public static String DFSGHomePath;
	public static String pg_defaultPath;
	public static String LogLevel;
	public static String log4j2FileNamePath;
	public static String logFileNamePath;

	private DatabaseDAO databaseDAO;
	private Connection connDB;
	public static ObservableList<DFSDatabaseConnectionModel> dfsConnectionModels;
	private DFSDatabaseConnectionModel dfsConnectionModel;
	private AnchorPane dfsGeneratorMainView;
	private String databaseSourceName;
	private DFSGeneratorImportWholeInfo dfsXMLWholeInfo;
	public static ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList;
	private DFSGeneratorXMLAllInfoModel dfsXMLAllInfo;
	


	
	// semimaster session
	private DFSGeneratorSemiMasterDefineController semiDefineController;
	private DFSSemiMasterDefineMasterInitDataController semiInitDataController;
	private DFSGeneratorMainViewController dfsGeneratorMainViewController;
	private ObservableList<SimpleTableModel> SemiMasterTypeInitData;
	private ObservableList<SimpleTableModel> SemiMasterLevelInitData;
	
	private ObservableList<DFSDefineDatatagInitItemModel> SemiDatatagListInitData;
	public static ObservableList<DFSVariableItemModel> SemiMasterItemInitData;
	public static DFSDefineInitModel SemiMasterInitData;
	public static ObservableList<String> sortList;
	

	
	// xml
	private DFSGeneratorXMLExportInitViewController dfsExportViewctl;

	// DatabaseSource

	public RootGeneralConfigViewController() {
		dfsXMLAllInfo = new DFSGeneratorXMLAllInfoModel(true);
		dfsConnectionModels = FXCollections.observableArrayList();
		databaseSourceView = new TableView<DFSGeneratorAndDatabaseListModel>();
		databaseDAO = new DatabaseDAO();
		eDLHomePath = System.getenv("APPDATA") + "\\BISTel";
		eDataRealmConfigPath = eDLHomePath + "\\eDataRealm\\conf\\eDataRealm\\eDataRealmConfigForWindows.xml";
		DFSGHomePath = eDLHomePath + "\\eDataRealm\\DFSG_TEMP";
		pg_defaultPath = DefineAtrribute.TEMP_PG_DEFAULT_PATH;
		log4j2FileNamePath = eDLHomePath + "\\eDataRealm\\conf\\Log\\log4j2.xml";
		LogLevel = DefineAtrribute.LOG4J2_LEVEL.get(4);
		logFileNamePath = DefineAtrribute.TEMP_eDL_LOG_PATH;
		semiDefineController = new DFSGeneratorSemiMasterDefineController();
		dfsExportViewctl = new DFSGeneratorXMLExportInitViewController();
	}

	@FXML
	private void initialize() {
		statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		databaseSourceNameColumn.setCellValueFactory(cellData -> cellData.getValue().datasourceNameProperty());
		databaseSourceNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		databaseTypeColumn.setCellValueFactory(cellData -> cellData.getValue().databaseTypeProperty());
		databaseTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userIDProperty());
		userNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		hostNameColumn.setCellValueFactory(cellData -> cellData.getValue().hostNameProperty());
		hostNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		portColumn.setCellValueFactory(cellData -> cellData.getValue().portProperty());
		portColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		dbiColumn.setCellValueFactory(cellData -> cellData.getValue().dbiProperty());
		dbiColumn.setCellFactory(TextFieldTableCell.forTableColumn());

//		exportBooleanColumn.setCellValueFactory(cellData -> cellData.getValue().exportProperty());
//		exportBooleanColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));
		exportBooleanColumn.setCellValueFactory(cellData -> cellData.getValue().exportProperty());
		exportBooleanColumn.setCellFactory(CheckBoxTableCell.forTableColumn(new Callback<Integer, ObservableValue<Boolean>>() {
		    @Override
		    public ObservableValue<Boolean> call(Integer param) {
		    	doneCheck(databaseSourceModelList.get(param).isExport(), param);
//		    	System.out.println(databaseSourceModelList.get(param).isExport()+param.toString());
		        return databaseSourceModelList.get(param).exportProperty();
		    }
		}));
		databaseNameColumn.setCellValueFactory(cellData -> cellData.getValue().databaseSourceProperty());
		databaseNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		DFSDatabaseTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		database.getItems().setAll(DefineAtrribute.DATABASE_GROUP);
		database.getSelectionModel().select(0);
		databaseSourceNameField.setText("PoCDB");
		// hostNameField.setText("192.168.8.131");
//		 hostNameField.setText("192.168.50.48");
		hostNameField.setText("localhost");
		portField.setText("1521");
		sidField.setText("orcl");
		// 1
//		userIDField.setText("yms");
		 userIDField.setText("bistel");
//		userIDField.setText("mobis");
		passwordField.setText("bistel01");

		eDLHomePathField.setText(eDLHomePath);
		eDataRealmWindowsConfigPathField.setText(eDataRealmConfigPath);
		DFSGHomePathField.setText(DFSGHomePath);
		pg_defaultPathField.setText(pg_defaultPath);

		LogLevelBox.getItems().setAll(DefineAtrribute.LOG4J2_LEVEL);
		LogLevelBox.getSelectionModel().select(4);
		log4j2PathField.setText(log4j2FileNamePath);
		logFileNameField.setText(logFileNamePath);
		eDataLyzerBasicConfig.setSelected(true);
		eDLHomePathField.setDisable(true);
		eDataRealmWindowsConfigPathField.setDisable(true);
		DFSGHomePathField.setDisable(true);
		pg_defaultPathField.setDisable(true);
		LogLevelBox.setDisable(true);
		logFileNameField.setDisable(true);
		log4j2PathField.setDisable(true);
		eDLHomeBrowseButton.setDisable(true);
		eDataRealmWindowsConfigButton.setDisable(true);
		DFSGHomeBrowseButton.setDisable(true);
		pg_defaultBrowseButton.setDisable(true);
		log4j2BrowseButton.setDisable(true);
		logFileButton.setDisable(true);
		connectButton.setDisable(true);
		disconnectButton.setDisable(true);
		preInspectionDataReport.setDisable(true);

		databaseSourceModelList = FXCollections.observableArrayList();

		passwordSave.setSelected(true);
		addAndConnect.setSelected(true);

	}
	@FXML
	private void handle_showDefaultTheme() {
		mainFrameGridPane.getStylesheets().setAll("file:resources/css/modena.css");
//		mainFrameGridPane.getStylesheets().setAll(getClass().getResource("file:resources/css/modena.css").toExternalForm());
	}
	
	@FXML
	private void handle_showChicBlackheme() {
		mainFrameGridPane.getStylesheets().setAll("file:resources/css/chicBlackView.css");
		
	}
	
	@FXML
	private void handle_deleteDatabaseSource() {
		int selectedIdx = databaseSourceView.getSelectionModel().getSelectedIndex();
		if(selectedIdx >= 0) {
			String name = databaseSourceView.getSelectionModel().getSelectedItem().getDatabaseSource();
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DATABASE SOURCE", "DELETE DATABASE SOURCE",
					name+" database source will be deleted, Are you sure?");
			Optional<ButtonType> result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
				for(int i=0; i<databaseSourceModelList.size(); i++) {
					if(name.equals(databaseSourceModelList.get(i).getDatabaseSource())) {
						databaseSourceModelList.get(i).setDfsDatabaseConnectionModel(null);
						databaseSourceModelList.get(i).setDfsGeneratorMainController(null);
						databaseSourceModelList.remove(i);
						mainViewAnchorPane.getChildren().clear();
						mainViewAnchorPane.getChildren().add(generalConfigurationView);
						break;
					}	
				}
			}
		}
	}
	
	@FXML
	private void handle_eDLHomePath_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(eDLHomePathField.getText()).getAbsoluteFile().getParent()));
		eDLHomePathField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_eDataRealmWindowsConfigPath_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(eDataRealmWindowsConfigPathField.getText()).getAbsoluteFile().getParent()));
		eDataRealmWindowsConfigPathField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_DFSGHomePath_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(DFSGHomePathField.getText()).getAbsoluteFile().getParent()));
		DFSGHomePathField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_pg_defaultPath_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(pg_defaultPathField.getText()).getAbsoluteFile().getParent()));
		pg_defaultPathField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_log4j2FileNamePath_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(log4j2PathField.getText()).getAbsoluteFile().getParent()));
		log4j2PathField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_logFileNamePath_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(logFileNameField.getText()).getAbsoluteFile().getParent()));
		logFileNameField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_DFSxmlImport() {
		semiInitDataController = new DFSSemiMasterDefineMasterInitDataController();
		DFSGeneratorXMLImportViewController dfsXMLImportCtl = new DFSGeneratorXMLImportViewController();
		dfsXMLWholeInfo = dfsXMLImportCtl.showImportXMLDialog();
		if(dfsXMLWholeInfo!=null) {
			sortList = dfsXMLWholeInfo.getSemiMasterInitData().getSortList();
			SemiMasterInitData = dfsXMLWholeInfo.getSemiMasterInitData();
			databaseSourceModelList.clear();
			databaseSourceModelList = dfsXMLWholeInfo.getDatabaseSourceModelList();
			dfsConnectionModels.clear();
			for(DFSGeneratorAndDatabaseListModel tempModel : databaseSourceModelList) {
				dfsConnectionModels.add(tempModel.getDfsDatabaseConnectionModel());
			}
			dfsXMLAllInfo = dfsXMLWholeInfo.getDfsXMLALLInfo();
			if(SemiMasterInitData.getSemiMasterItemInitData().size()>0) {
				SemiMasterTypeInitData = FXCollections.observableArrayList();
				SemiMasterTypeInitData = semiInitDataController.createSemiMasterTypeInitData();
				SemiMasterLevelInitData = FXCollections.observableArrayList();
				SemiMasterLevelInitData = semiInitDataController.createSemiMasterLevelInitData();
				SemiMasterItemInitData = FXCollections.observableArrayList();
				SemiMasterItemInitData = SemiMasterInitData.getSemiMasterItemInitData();
				databaseSourceView.setItems(databaseSourceModelList);
				DFSDatabaseTableView.setItems(dfsConnectionModels);
				SEMIMasterSB.setDisable(false);
				dfsGeneratorTitledPane.expandedProperty().set(true);
				connectButton.setDisable(false);
				disconnectButton.setDisable(false);
				databaseSourceNameField.setText(null);
				database.getSelectionModel().select(null);
				userIDField.setText(null);
				passwordField.setText(null);
				hostNameField.setText(null);
				portField.setText(null);
				sidField.setText(null);
			}
		}
	}
	
	public void setDFSGeneratorMainView(String databaseSourceName) {
		if (databaseSourceName != null) {
			for (DFSGeneratorAndDatabaseListModel temp : databaseSourceModelList)
				if (databaseSourceName.equals(temp.getDatabaseSource())) {
					dfsGeneratorMainView = temp.getDfsGeneratorMainController().getDFSGeneratorMainView();
					break;
				}
			dfsGeneratorMainView = setAnchorPaneMax(dfsGeneratorMainView);
			mainViewAnchorPane.getChildren().clear();
			mainViewAnchorPane.getChildren().add(dfsGeneratorMainView);
		}
	}
	
	@FXML
	private void handle_DFSxmlExport() {
		
		DFSGeneratorXMLAllInfoModel dfsXMLAllInfoClone = new DFSGeneratorXMLAllInfoModel(true);
		boolean exportExist = false;
		if (databaseSourceView.getItems().size() > 0)
			for (int i = 0; i < databaseSourceView.getItems().size(); i++)
				if (databaseSourceView.getItems().get(i).isExport()) {
					exportExist = true;
					break;
				}
		
			if (exportExist) {
				if (!dfsXMLAllInfo.isMarkInitData()) {
					try {
						dfsXMLAllInfoClone = dfsXMLAllInfo.clone();
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
				}

				Boolean loopContinue = true;
				while (loopContinue) {
					dfsXMLAllInfoClone = dfsExportViewctl.showExportXMLDialog(dfsXMLAllInfoClone);
					if (dfsXMLAllInfoClone != null && dfsXMLAllInfoClone.isCreateXMLFile()) {
						DFSGeneratorXMLExportProgressViewController expProController = new DFSGeneratorXMLExportProgressViewController();
						loopContinue = expProController.showExportXMLDialog(dfsXMLAllInfoClone);
						if (!loopContinue) {
							if (dfsXMLAllInfoClone.isAllDone()) {
								dfsXMLAllInfo = dfsXMLAllInfoClone;
								dfsXMLAllInfo.setAllDone(false);
								dfsXMLAllInfo.setMarkInitData(false);
								loopContinue = false;
							} else {
								dfsXMLAllInfoClone = null;
								loopContinue = false;
							}

						}
					} else if (dfsXMLAllInfoClone != null && dfsXMLAllInfoClone.isExitSaveFile()) {
						dfsXMLAllInfo = dfsXMLAllInfoClone;
						dfsXMLAllInfo.setMarkInitData(false);
						loopContinue = false;
					} else {
						dfsXMLAllInfoClone = null;
						loopContinue = false;
					}
				}
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "EXPORT WARING",
						"EXPORT DATABASE SOURCE WARING", "There is no export database source checked.");
				messageLog.showAndWait();
		}
	}

	@FXML
	public void showGeneralConfiguration() {
		mainViewAnchorPane.getChildren().clear();
		mainViewAnchorPane.getChildren().add(generalConfigurationView);
	}

	@FXML
	public void handle_realtime_change_dataBaseSource() {
		if (DFSDatabaseTableView.getItems().size() > 0) {
			for (int i = 0; i < DFSDatabaseTableView.getItems().size(); i++)
				if (DFSDatabaseTableView.getItems().get(i).getDatasourceName()
						.equals(databaseSourceNameField.getText())) {
					DFSDatabaseTableView.getSelectionModel().clearSelection();
					DFSDatabaseTableView.getSelectionModel().select(i);
					connectButton.setDisable(false);
					disconnectButton.setDisable(false);
					break;
				} else {
					connectButton.setDisable(true);
					disconnectButton.setDisable(true);
				}
		}
	}

	public AnchorPane setAnchorPaneMax(AnchorPane targetAnchorPane) {
		AnchorPane.setTopAnchor(targetAnchorPane, 0.2);
		AnchorPane.setLeftAnchor(targetAnchorPane, 0.2);
		AnchorPane.setRightAnchor(targetAnchorPane, 0.2);
		AnchorPane.setBottomAnchor(targetAnchorPane, 0.2);
		return targetAnchorPane;
	}

	private void doneCheck(Boolean isSelected, int idx) {
		Boolean mappingDone = true;
		if (isSelected) {
			String l_databaseName = databaseSourceView.getItems().get(idx).getDatabaseSource();
			for (DFSGeneratorAndDatabaseListModel tempModel : databaseSourceModelList) {
				if (l_databaseName.equals(tempModel.getDatabaseSource())) {
					for (DFSDefineTableModel templevel1 : tempModel.getDfsGeneratorMainController().getController()
							.getDFSDefineTableData()) {
						if (templevel1.getContentBoolean()) {
							mappingDone = false;
							break;
						}
					}
				}
			}
			if (mappingDone) {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "DEFINE DATATAG WARING",
						"DATABASESOURCE DEFINE DATATAG WARING", l_databaseName + " : There is no Data tag done.");
				messageLog.show();
				databaseSourceView.getItems().get(idx).setExport(false);
			}
		}
	}

	
	public void createDFSGeneratorSEMIMasterInitData() {
		if(SemiMasterInitData != null) {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "SEMIMASTER", "Semimaster Config has been loaded",
					"Change new Semimaster config, Are you sure?");
			Optional<ButtonType> result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
				semiInitDataController = new DFSSemiMasterDefineMasterInitDataController();
				SemiMasterTypeInitData = FXCollections.observableArrayList();
				SemiMasterTypeInitData = semiInitDataController.createSemiMasterTypeInitData();
				SemiMasterLevelInitData = FXCollections.observableArrayList();
				SemiMasterLevelInitData = semiInitDataController.createSemiMasterLevelInitData();
				SemiMasterItemInitData = FXCollections.observableArrayList();
				SemiMasterItemInitData = semiInitDataController.createSemiMasterAttributeInitData();
				sortList = semiInitDataController.createSemiMasterinitSortList(SemiMasterItemInitData);
				SemiDatatagListInitData = FXCollections.observableArrayList();
				SemiDatatagListInitData = semiInitDataController.createSemiMasterDatatagListInitData();
				SemiMasterInitData = new DFSDefineInitModel(SemiMasterItemInitData, SemiDatatagListInitData);
				SEMIMasterSB.setDisable(false);
				dfsGeneratorTitledPane.expandedProperty().set(true);
			}
		} else {
			semiInitDataController = new DFSSemiMasterDefineMasterInitDataController();
			SemiMasterTypeInitData = FXCollections.observableArrayList();
			SemiMasterTypeInitData = semiInitDataController.createSemiMasterTypeInitData();
			SemiMasterLevelInitData = FXCollections.observableArrayList();
			SemiMasterLevelInitData = semiInitDataController.createSemiMasterLevelInitData();
			SemiMasterItemInitData = FXCollections.observableArrayList();
			SemiMasterItemInitData = semiInitDataController.createSemiMasterAttributeInitData();
			sortList = semiInitDataController.createSemiMasterinitSortList(SemiMasterItemInitData);
			SemiDatatagListInitData = FXCollections.observableArrayList();
			SemiDatatagListInitData = semiInitDataController.createSemiMasterDatatagListInitData();
			SemiMasterInitData = new DFSDefineInitModel(SemiMasterItemInitData, SemiDatatagListInitData);
			//TODO
			sortList = DefineAtrribute.DEFAULT_SORT_LIST;
			SEMIMasterSB.setDisable(false);
			dfsGeneratorTitledPane.expandedProperty().set(true);
		}
	}

	@FXML
	public void showSEMIMasterDifineView() {
		SemiMasterInitData = semiDefineController.showDefineSemiMasterDialog(SemiMasterInitData, SemiMasterTypeInitData,
				SemiMasterLevelInitData);
	}

	@FXML
	public void createNewDFSGeneratorFromTemplate() {
		createDFSGeneratorSEMIMasterInitData();
	}

	@FXML
	public void showSelectedDFSGenerator() {
		int selectedIdx = databaseSourceView.getSelectionModel().getSelectedIndex();
		if (selectedIdx >= 0) {
			String l_databaseName = databaseSourceView.getSelectionModel().getSelectedItem().getDatabaseSource();
			setDFSGeneratorMainView(l_databaseName);
		}
	}

//	@FXML
//	public void addDFSGeneratorDatabaseSource() {
//		// if(GeneralConfigurationController.dfsConnectionModels.size()>0) {
//		// selectDatabaseSourceController.showAddDatabaseSourceDialog();
//		// } else {
//		// messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR,
//		// "ERROR", "No select","");
//		// messageLog.showAndWait();
//		// }
//	}

	@FXML
	public void handle_DFSDatabaseTableView_click() {
		if (DFSDatabaseTableView.getSelectionModel().getSelectedItems().size() == 1) {
			addButton.setDisable(false);
			int selectedIdx = DFSDatabaseTableView.getSelectionModel().getSelectedIndex();
			if (selectedIdx >= 0) {
				SearchIndex idx = new SearchIndex();
				DFSDatabaseConnectionModel tempModel = DFSDatabaseTableView.getItems().get(selectedIdx);
				connectButton.setDisable(false);
				disconnectButton.setDisable(false);
				preInspectionDataReport.setDisable(false);
				databaseSourceNameField.setText(tempModel.getDatasourceName());
				database.getSelectionModel()
						.select(idx.getIdx(DefineAtrribute.DATABASE_GROUP, tempModel.getDatabaseType()));
				userIDField.setText(tempModel.getUserID());
				passwordField.setText(tempModel.getPassword());
				hostNameField.setText(tempModel.getHostName());
				portField.setText(tempModel.getPort());
				sidField.setText(tempModel.getDbi());
			}
		} else {
			if (DFSDatabaseTableView.getSelectionModel().getSelectedItems().size() > 1)
				addButton.setDisable(true);
			connectButton.setDisable(true);
			disconnectButton.setDisable(true);
			preInspectionDataReport.setDisable(true);
		}
	}

	@FXML
	private void setEDLBasicConfig() {
		if (eDataLyzerBasicConfig.isSelected()) {
			eDLHomePathField.setDisable(true);
			eDataRealmWindowsConfigPathField.setDisable(true);
			DFSGHomePathField.setDisable(true);
			pg_defaultPathField.setDisable(true);
			LogLevelBox.setDisable(true);
			logFileNameField.setDisable(true);
			log4j2PathField.setDisable(true);
			eDLHomeBrowseButton.setDisable(true);
			eDataRealmWindowsConfigButton.setDisable(true);
			DFSGHomeBrowseButton.setDisable(true);
			pg_defaultBrowseButton.setDisable(true);
			log4j2BrowseButton.setDisable(true);
			logFileButton.setDisable(true);
			eDLHomePath = eDLHomePathField.getText();
			eDataRealmConfigPath = eDataRealmWindowsConfigPathField.getText();
			pg_defaultPath = pg_defaultPathField.getText();
			DFSGHomePath = DFSGHomePathField.getText();
			LogLevel = LogLevelBox.getSelectionModel().getSelectedItem().toString();
			log4j2FileNamePath = log4j2PathField.getText();
			logFileNamePath = logFileNameField.getText();
		} else {
			eDLHomePathField.setDisable(false);
			eDataRealmWindowsConfigPathField.setDisable(false);
			DFSGHomePathField.setDisable(false);
			pg_defaultPathField.setDisable(false);
			LogLevelBox.setDisable(false);
			log4j2PathField.setDisable(false);
			logFileNameField.setDisable(false);
			eDLHomeBrowseButton.setDisable(false);
			eDataRealmWindowsConfigButton.setDisable(false);
			DFSGHomeBrowseButton.setDisable(false);
			pg_defaultBrowseButton.setDisable(false);
			log4j2BrowseButton.setDisable(false);
			logFileButton.setDisable(false);
		}
	}

	public void refreshConnection(String databaseSouceName) {
		for (int i = 0; i < DFSDatabaseTableView.getItems().size(); i++)
			if (databaseSouceName.equals(DFSDatabaseTableView.getItems().get(i).getDatasourceName())) {
				DFSDatabaseTableView.getSelectionModel().select(i);
				handle_ConnectButton();
			}
	}
	
	@FXML
	private void handle_disconnect() throws SQLException {
		int selectedIdx = DFSDatabaseTableView.getSelectionModel().getSelectedIndex();
		if (selectedIdx >= 0) {
			DFSDatabaseConnectionModel tempModel = DFSDatabaseTableView.getItems().get(selectedIdx);
			if(tempModel.getConnection() != null)
				tempModel.getConnection().close();
			tempModel.setStatus("N");
		}
	}
	
	@FXML
	private void handle_ConnectButton() {

		int selectedIdx = DFSDatabaseTableView.getSelectionModel().getSelectedIndex();
		boolean update = true;
		if (selectedIdx >= 0) {
			DFSDatabaseConnectionModel tempModel = DFSDatabaseTableView.getItems().get(selectedIdx);
			if (!tempModel.getDatabaseType().equals(database.getSelectionModel().getSelectedItem().toString())
					|| !tempModel.getUserID().equals(userIDField.getText())
					|| !tempModel.getHostName().equals(hostNameField.getText())
					|| !tempModel.getPort().equals(portField.getText())
					|| !tempModel.getDbi().equals(sidField.getText())) {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DUP ERROR", "overwrite",
						"Are you sure?");
				Optional<ButtonType> result = messageLog.showAndWait();
				if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
					tempModel.setDatabaseType(database.getSelectionModel().getSelectedItem().toString());
					tempModel.setUserID(userIDField.getText());
					tempModel.setPassword(passwordField.getText());
					tempModel.setHostName(hostNameField.getText());
					tempModel.setPort(portField.getText());
					tempModel.setDbi(sidField.getText());
				} else
					update = false;
			}
			if (update) {
				connect(tempModel);
//				try {
//					if (tempModel.getConnection() != null)
//						tempModel.getConnection().close();
//					databaseDAO = databaseDAO.getOraInstance(database.getSelectionModel().getSelectedItem().toString(),
//							hostNameField.getText(), portField.getText(), sidField.getText(), userIDField.getText(),
//							passwordField.getText());
//					connDB = databaseDAO.connectTest(SQLStatements.dbConn, null);
//
//					if (connDB != null) {
//						tempModel.setConnection(connDB);
//						tempModel.setStatus("Y");
//					} else {
//						tempModel.setStatus("N");
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			}
		} else {
			System.out.println("no select");
		}
	}
	
	private void connect(DFSDatabaseConnectionModel tempModel) {
		try {
			if (tempModel.getConnection() != null)
				tempModel.getConnection().close();
			databaseDAO = databaseDAO.getOraInstance(database.getSelectionModel().getSelectedItem().toString(),
					hostNameField.getText(), portField.getText(), sidField.getText(), userIDField.getText(),
					passwordField.getText());
			connDB = databaseDAO.connectTest(SQLStatements.dbConn, null);

			if (connDB != null) {
				tempModel.setConnection(connDB);
				tempModel.setStatus("Y");
				setRefleshConnection(tempModel);
			} else {
				tempModel.setStatus("N");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handle_TestButton() {
		databaseDAO = databaseDAO.getOraInstance(database.getSelectionModel().getSelectedItem().toString(),
				hostNameField.getText(), portField.getText(), sidField.getText(), userIDField.getText(),
				passwordField.getText());
		connDB = databaseDAO.connectTest(SQLStatements.dbConnTest, "TEST");
		if(connDB == null)
			for(int i=0; i<dfsConnectionModels.size(); i++)
				if(databaseSourceNameField.getText().equals(dfsConnectionModels.get(i).getDatasourceName()))
				{	messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "Connection", "connection",
							"Are you sure?");
					Optional<ButtonType> result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						connect(dfsConnectionModels.get(i));
						break;
					} else {
						dfsConnectionModels.get(i).setStatus("N");
						break;
					}
				}
	}

	@FXML
	private void handle_AddButton() {
		String mesagge = null;
		DFSDatabaseConnectionModel tempModel = new DFSDatabaseConnectionModel();
		boolean dupNameContinue = false;
		boolean reconnection = true;
		
		if (databaseSourceNameField.getText() == null || databaseSourceNameField.getText().equals(""))
			mesagge = "DB Source Name";
		else if (userIDField.getText() == null || userIDField.getText().equals(""))
			mesagge = "uer";
		else if (hostNameField.getText() == null || hostNameField.getText().equals(""))
			mesagge = "host Name";
		else if (portField.getText() == null || portField.getText().equals(""))
			mesagge = "port";
		else if (sidField.getText() == null || sidField.getText().equals(""))
			mesagge = "DB i";

		if (mesagge == null) {
			if (DFSDatabaseTableView.getItems().size() > 0) {
				for (int i = 0; i < DFSDatabaseTableView.getItems().size(); i++) {
					tempModel = DFSDatabaseTableView.getItems().get(i);
					if (tempModel.getDatasourceName().equals(databaseSourceNameField.getText())) {
						dupNameContinue = true;
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DUP ERROR", "overwrite",
								"Are you sure?");
						Optional<ButtonType> result = messageLog.showAndWait();
						if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
							tempModel.setDatasourceName(databaseSourceNameField.getText());
							tempModel.setDatabaseType(database.getSelectionModel().getSelectedItem().toString());
							tempModel.setUserID(userIDField.getText());
							tempModel.setPassword(passwordField.getText());
							tempModel.setHostName(hostNameField.getText());
							tempModel.setPort(portField.getText());
							tempModel.setDbi(sidField.getText());
							break;
						} else {
							reconnection = false;
							break;
						}
					}
				}
			}
			if (!dupNameContinue) {
				String password = null;
				if (passwordSave.isSelected())
					password = passwordField.getText();
				dfsConnectionModel = new DFSDatabaseConnectionModel(null, "N", databaseSourceNameField.getText(),
						database.getSelectionModel().getSelectedItem().toString(), userIDField.getText(), password,
						hostNameField.getText(), portField.getText(), sidField.getText(), null);
				dfsConnectionModels.add(dfsConnectionModel);
				tempModel = dfsConnectionModel;
			}
			
			DFSDatabaseTableView.setItems(dfsConnectionModels);
	
			if (addAndConnect.isSelected() && reconnection) {
				for (int i = 0; i < DFSDatabaseTableView.getItems().size(); i++)
					if (databaseSourceNameField.getText().equals(tempModel.getDatasourceName())) {
						connect(tempModel);
						setRefleshConnection(tempModel);
						break;
					}
			} 
//			else {
//				tempModel.setStatus("N");
//				try {
//					if(tempModel.getConnection() != null)
//						tempModel.getConnection().close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		} else
			System.out.println(mesagge);
	}
	
	private void setRefleshConnection(DFSDatabaseConnectionModel tempModel) {
		if(databaseSourceModelList.size()>0) 
			for(DFSGeneratorAndDatabaseListModel tempDatabase : databaseSourceModelList)
				if(tempModel.getDatasourceName().equals(tempDatabase.getDatabaseSource())) {
					tempDatabase.getDfsGeneratorMainController().getController().setRefleshConnection();
						break;
				}
	}

	@FXML
	private void handle_SelectedItemsToDFGConfig() {
		for (DFSDatabaseConnectionModel temp : DFSDatabaseTableView.getSelectionModel().getSelectedItems())
			createDFSGenerator(temp);
		if (SemiMasterInitData == null) {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "SEMIMASTER", "Semimaster Config hasn't been loaded yet",
					"New config from Semimaster template or later?");
			Optional<ButtonType> result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
				createDFSGeneratorSEMIMasterInitData();
			}
		}
		if (DFSDatabaseTableView.getSelectionModel().getSelectedItems().size()>1)
			DFSDatabaseTableView.getSelectionModel().clearSelection();

	}

	public void createDFSGenerator(DFSDatabaseConnectionModel dfsDatabaseConnectionModel) {
		databaseSourceName = dfsDatabaseConnectionModel.getDatasourceName();
		boolean updateOrCancel = false;
		if (databaseSourceName != null) {
			for (int i = 0; i < databaseSourceModelList.size(); i++) {
				if (databaseSourceModelList.get(i).getDatabaseSource().equals(databaseSourceName)) {
					updateOrCancel = true;
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "DUP ERROR",
							databaseSourceName + " EXISTS.", " check");
					messageLog.showAndWait();
					break;
				}
			}
			if (!updateOrCancel) {
				dfsGeneratorMainViewController = new DFSGeneratorMainViewController();
				dfsGeneratorMainViewController.createDFSGeneratorMainView(databaseSourceName
						,dfsDatabaseConnectionModel.getConnection(),null,null);
				databaseSourceModelList.add(new DFSGeneratorAndDatabaseListModel(false, false, dfsDatabaseConnectionModel,
						dfsGeneratorMainViewController));
				dfsGeneratorTitledPane.expandedProperty().set(true);
				databaseSourceView.setItems(databaseSourceModelList);
			}
		}
	}

	@FXML
	private void handle_deleteButton() {
		int selectedIdx = DFSDatabaseTableView.getSelectionModel().getSelectedIndex();
		if (selectedIdx >= 0) {
			databaseSourceName = DFSDatabaseTableView.getItems().get(selectedIdx).getDatasourceName();
			for (int i = 0; i < dfsConnectionModels.size(); i++)
				if (dfsConnectionModels.get(i).getDatasourceName().equals(databaseSourceName)) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "delete", databaseSourceName,
							"Are you sure?");
					Optional<ButtonType> result = messageLog.showAndWait();
					// disconnect connection
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						dfsConnectionModels.remove(i);
						DFSDatabaseTableView.getSelectionModel().clearSelection();
						if (dfsConnectionModels.size() < 1) {
							connectButton.setDisable(true);
							disconnectButton.setDisable(true);
						}
						break;
					}
				}

		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR", "No select", "");
			messageLog.showAndWait();
		}
	}

}
