package com.digilog.meerkat.view.DFSGenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.DFSGeneratorController.DFSMappingController;
import com.digilog.meerkat.DFSGeneratorController.crawler.DFSDatatagController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.attribute.SQLStatements;
import com.digilog.meerkat.model.dfsGenerator.DFSAttributeMappingStorgeModel;
import com.digilog.meerkat.model.dfsGenerator.DFSDatabaseConnectionModel;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSDetailConfigResultModel;
import com.digilog.meerkat.model.dfsGenerator.SimpleTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineInitModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.util.DFGVarableCheckNotOpt;
import com.digilog.meerkat.util.DFSMethodCopyController;
import com.digilog.meerkat.util.MessageDialog;
import com.digilog.meerkat.view.RootGeneralConfigViewController;
import com.digilog.meerkat.view.DFSGenerator.crawler.DFSGeneratorTableDetailConfigEditController;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;


public class DFSGeneratorMainViewController {

	// private DatabaseDAO databaseDAO;
	public Connection connDB;
	private String databaseSourceSelfTag;
	private MessageDialog mDialog;
	private Alert messageLog;
	private AnchorPane dfsGeneratorMainView;
	private DFSGeneratorMainViewController controller;

	// create Crawler instance
	private ObservableList<DFSDatatagExportModel> dfsdatatags;

	@FXML
	private TextField searchTableName;
	@FXML
	private Button searchTableButton;
	@FXML
	private Button addDefineTableButton;
	@FXML
	private Button removeDefineTableButton;
	@FXML
	private Button DetailConfigEditButton;
	@FXML
	private Button searchCoulmnButtom;
	@FXML
	private Button runButton;

	@FXML
	private ChoiceBox<String> selectRun;
	@FXML
	private TextField searchColumnName;

	@FXML
	private ContextMenu contextMenu;
	@FXML
	private MenuItem previewData;
	@FXML
	private MenuItem previewDPIR;
	@FXML
	private SeparatorMenuItem SepMenu;
	@FXML
	private MenuItem CopyNPaste;
	@FXML
	private Menu Define;
	@FXML
	private MenuItem Done;
	@FXML
	private MenuItem Undone;

	// Search Table Set
	@FXML
	private TableView<SimpleTableModel> searchTableView;
	@FXML
	private TableColumn<SimpleTableModel, String> tableNameColumn;
	@FXML
	private TableColumn<SimpleTableModel, String> defineDateColumn;

	private ObservableList<SimpleTableModel> searchTableData;

	// Define table Set
	@FXML
	private TableView<DFSDefineTableModel> DFSDefineTableView;
	@FXML
	private TableColumn<DFSDefineTableModel, String> defineDataTagNameColumn;
	@FXML
	private TableColumn<DFSDefineTableModel, String> defineAliasNameColumn;
	@FXML
	private TableColumn<DFSDefineTableModel, String> defineTableNameColumn;
	@FXML
	private TableColumn<DFSDefineTableModel, String> defineTypeColumn;
	@FXML
	private TableColumn<DFSDefineTableModel, String> defineLevelColumn;
	@FXML
	private TableColumn<DFSDefineTableModel, Boolean> defineDoneColumn;

	private DFSMappingController DFSAtrributeMapClt;
	private DFSGeneratorAddTableController addTableCtl;
	private ObservableList<DFSDefineTableModel> DFSDefineTableData;

	// DFS VariableTable Set
	@FXML
	private TableView<DFSVariableModel> DFSVariableTableView;
	@FXML
	private TableColumn<DFSVariableModel, String> variableNameColumn;
	@FXML
	private TableColumn<DFSVariableModel, String> mappingColumn;
	@FXML
	private TableColumn<DFSVariableModel, String> typeColumn;
	@FXML
	private TableColumn<DFSVariableModel, Boolean> useColumn;

	private ObservableList<DFSMethodExportModel> tempDFSMethodData;
	private DFSGeneratorTableDetailConfigEditController DFSDetailConfigEditController;
	private DFSMethodCopyController dfsMethodCopyController;

	// Preview Table Data Set
	@FXML
	private SplitPane splitPane;
	@FXML
	private AnchorPane splitAnchorTable;
	@FXML
	private TableView<ObservableList<Object>> previewTableView;
	// to do DPIR
	// private TableView<ObservableList<Object>> DPIR_TableView;

	private DFSGeneratorPreviewTableDataController preTable;

	// DFSDefineDataMapping
	private HashMap<String, DFSAttributeMappingStorgeModel> DFSMappingTableData;
	private DFGVarableCheckNotOpt checkNotOpt;

	private DFSDefineInitModel SemiMasterInitData;
//	private ObservableList<DFSVariableItemModel> SemiMasterItemInitData;
	public static ObservableList<String> sortList;


	// selected Index
	int selectedDefineTableIndex;
	int selectedVairableTableIndex;
	int selectedPreviewTableIndex;

	public DFSGeneratorMainViewController() {

		mDialog = new MessageDialog();
		dfsdatatags = FXCollections.observableArrayList();
		DFSDetailConfigEditController = new DFSGeneratorTableDetailConfigEditController();
		dfsMethodCopyController = new DFSMethodCopyController();
		searchTableData = FXCollections.observableArrayList();
		DFSDefineTableData = FXCollections.observableArrayList();
		tempDFSMethodData = FXCollections.observableArrayList();
		DFSAtrributeMapClt = new DFSMappingController();
		addTableCtl = new DFSGeneratorAddTableController();
		checkNotOpt = new DFGVarableCheckNotOpt();

		previewTableView = new TableView<ObservableList<Object>>();
		// to do DPIR
		// DPIR_TableView = new TableView<ObservableList<Object>>();

		// mapping data
		DFSMappingTableData = new HashMap<String, DFSAttributeMappingStorgeModel>();
		sortList = DefineAtrribute.DEFAULT_SORT_LIST;
	}

	@FXML
	private void initialize() {

		searchTableName.setText("*");
		tableNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		defineDateColumn.setCellValueFactory(cellData -> cellData.getValue().commonProperty());

		defineDataTagNameColumn.setCellValueFactory(cellData -> cellData.getValue().data_tag_nameProperty());
		defineAliasNameColumn.setCellValueFactory(cellData -> cellData.getValue().alias_nameProperty());
		defineTableNameColumn.setCellValueFactory(cellData -> cellData.getValue().table_NameProperty());
		defineTypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
		defineLevelColumn.setCellValueFactory(cellData -> cellData.getValue().levelProperty());
		defineDoneColumn.setCellValueFactory(cellData -> cellData.getValue().contentBooleanProperty());
		defineDoneColumn.setCellFactory(CheckBoxTableCell.forTableColumn(new Callback<Integer, ObservableValue<Boolean>>() {
		    @Override
		    public ObservableValue<Boolean> call(Integer param) {
		    	doneCheck(DFSDefineTableData.get(param).getContentBoolean(), param);
		        return DFSDefineTableData.get(param).contentBooleanProperty();
		    }
		}));

		variableNameColumn.setCellValueFactory(cellData -> cellData.getValue().dfs_variable_nameProperty());
		mappingColumn.setCellValueFactory(cellData -> cellData.getValue().column_nameProperty());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		useColumn.setCellValueFactory(cellData -> cellData.getValue().contentBooleanProperty());

		defineAliasNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		mappingColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		useColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));

		selectRun.getItems().setAll(DefineAtrribute.RUN_GROUP);
		selectRun.getSelectionModel().selectFirst();
		
		
		
	}
	

	private void doneCheck(Boolean isSelected, int idx ) {
		Boolean mappingDone = true;
		if(isSelected) {
			String l_data_tag_name = DFSDefineTableView.getItems().get(idx).getData_tag_name();
			tempDFSMethodData = DFSMappingTableData.get(l_data_tag_name).getDFSMappingMethodData();
			for(DFSVariableModel tempModel : DFSAtrributeMapClt.getDFSMappingSortDataModel(tempDFSMethodData))
				if((tempModel.getContentBoolean() && ((tempModel.getColumn_name() == null || "".equals(tempModel.getColumn_name())))
						|| ("TIMESTAMP".equals(tempModel.getdfs_variable_name()) &&  
								(tempModel.getColumn_name() == null || "".equals(tempModel.getColumn_name()))))) {
					mappingDone = false;
					DFSDefineTableView.getSelectionModel().select(idx);
					handleDefineTableClickController();	
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "DEFINE ERROR",
							DFSDefineTableView.getSelectionModel().getSelectedItem().getData_tag_name() +" DATATAG MAPPING ERROR",
							tempModel.getdfs_variable_name() + " : Not Optional Variable Mapping isn't done.");
					messageLog.show(); 
					DFSDefineTableView.getItems().get(idx).setContentBoolean(false);				
					break;
				}
			if(mappingDone) {
				DFSDefineTableView.getItems().get(idx).setContentBoolean(true);
			}
		}
		DFSDefineTableView.setItems(DFSDefineTableData);
	}

	// DFSGeneratorMainViewController
	public void createDFSGeneratorMainView(String databaseSourceSelfTag, Connection connDB
			, ObservableList<DFSDefineTableModel> DFSDefineTableData
			, ObservableList<DFSDatatagExportModel> dfsdatatags
//			, ObservableList<DFSVariableItemModel> SemiMappingInitData 
			) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/DFSGeneratorMainView.fxml"));
			dfsGeneratorMainView = (AnchorPane) loader.load();
			controller = loader.getController();
			controller.setDatabaseSourceSelfTag(databaseSourceSelfTag);
			controller.setConnection(connDB);
			if(DFSDefineTableData != null)
				controller.setDFSDefineTableData(DFSDefineTableData);
			if(dfsdatatags != null)
				controller.setDfsdatatags(dfsdatatags);
//			if(SemiMappingInitData != null)
//				controller.setSemiMasterItemInitData(SemiMappingInitData);
			controller.setController(controller);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setController(DFSGeneratorMainViewController controller) {
		this.controller=controller;
	}

	public DFSGeneratorMainViewController getController() {
		return controller;
	}
	
	public void setDatabaseSourceSelfTag(String databaseSourceSelfTag) {
		this.databaseSourceSelfTag = databaseSourceSelfTag;
	}

	public String getDatabaseSourceSelfTag() {
		return databaseSourceSelfTag;
	}

	public Connection getConnection() {
		return connDB;
	}

	public void setConnection(Connection connDB) {
		this.connDB = connDB;
	}
	
	@FXML
	public void setRefleshConnection()	{
		for (DFSDatabaseConnectionModel tempModel : RootGeneralConfigViewController.dfsConnectionModels)
			if (databaseSourceSelfTag.equals(tempModel.getDatasourceName()) && tempModel.getStatus().equals("Y")) {
				if (connDB != tempModel.getConnection()) {
					connDB = tempModel.getConnection();
					break;
				}
			}
	}

	public AnchorPane getDFSGeneratorMainView() {
		return dfsGeneratorMainView;
	}

	public ObservableList<DFSDefineTableModel> getDFSDefineTableData() {
		return DFSDefineTableData;
	}
	
	public ObservableList<DFSDatatagExportModel> getDfsdatatags() {
		return dfsdatatags;
	}
	
//	public ObservableList<DFSVariableItemModel> getSemiMasterItemInitData() {
//		return SemiMasterItemInitData;
//	}
	
	public void setDFSDefineTableData(ObservableList<DFSDefineTableModel> DFSDefineTableData) {
		this.DFSDefineTableData=DFSDefineTableData;
		DFSDefineTableView.setItems(DFSDefineTableData);
	}
	
	public void setDfsdatatags(ObservableList<DFSDatatagExportModel> dfsdatatags) {
		this.dfsdatatags=dfsdatatags;
		for(DFSDatatagExportModel tempModel : dfsdatatags) {
			tempDFSMethodData = tempModel.getDFSMethod();
			DFSAttributeMappingStorgeModel tempDFSAttributeData = new DFSAttributeMappingStorgeModel();
			tempDFSAttributeData.setDFSMappingMethodData(tempDFSMethodData);
			DFSMappingTableData.put(tempModel.getData_tag_name(),tempDFSAttributeData);
		}
	}
	
//	public void setSemiMasterItemInitData(ObservableList<DFSVariableItemModel> SemiMappingInitData) {
//		this.SemiMasterItemInitData=SemiMappingInitData;
//	}
	
	@FXML
	public void handleSearchTableButton() {
		if (connDB != null) {
			try {
				String sql = SQLStatements.selectTableNameList + searchTableName.getText().toUpperCase() + "')";
				PreparedStatement pstmt;
				ResultSet res;
				pstmt = connDB.prepareStatement(sql);
				res = pstmt.executeQuery();
				// stmt.close();
				ResultSetMetaData rsmd = res.getMetaData();
				int numberOfColumns = rsmd.getColumnCount();

				// tableView reset
				searchTableView.getItems().removeAll(searchTableData);
				while (res.next()) {
					for (int i = 1; i <= numberOfColumns; i++) {
						searchTableData.add(new SimpleTableModel(res.getObject(i).toString(), "TEST DEFINE"));
					}
				}
				res.close();
				pstmt.close();
				searchTableView.setItems(searchTableData);
			} catch (SQLException e) {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "DATABASE ERROR", "SQL ERROR",
						e.getMessage());
				messageLog.showAndWait();
			}
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "DATABASE ERROR",
					"DATABASE CONNECTION ERROR",
					"Please, Check \n(TAB) General Configuration -> (Button) Connection Test.");
			messageLog.showAndWait();
		}
	}

	@FXML
	public void handleDetailConfigEditButton() {

		int SelectedIdx = DFSDefineTableView.getSelectionModel().getSelectedIndex();
		int dfsdatatagsIndex = -1;
		int DFSDefineTableDatandex = -1;

		if (SelectedIdx >= 0 && DFSDefineTableView.getSelectionModel().getSelectedItem().getData_tag_name() != null) {
			String data_tag_name = DFSDefineTableView.getSelectionModel().getSelectedItem().getData_tag_name();

			for (int i = 0; i < dfsdatatags.size(); i++)
				if (data_tag_name.equals(dfsdatatags.get(i).getData_tag_name()))
					dfsdatatagsIndex = i;

			for (int i = 0; i < DFSDefineTableData.size(); i++)
				if (data_tag_name.equals(DFSDefineTableData.get(i).getData_tag_name()))
					DFSDefineTableDatandex = i;

			DFSDetailConfigResultModel detailConfigBackupModel = new DFSDetailConfigResultModel();
			DFSDetailConfigResultModel detailConfigResultModel = new DFSDetailConfigResultModel();

			detailConfigBackupModel = dfsMethodCopyController
					.createDFSMethodCopy(DFSMappingTableData.get(data_tag_name).getDFSMappingMethodData());
			detailConfigResultModel = DFSDetailConfigEditController.showDetailEditDialog(DFSDefineTableDatandex,
					DFSDefineTableData, detailConfigBackupModel);

			if (detailConfigResultModel.isSetCheck()) {
				dfsdatatags.get(dfsdatatagsIndex).getDFSMethod().get(0).getDFSVariables()
						.setDFSVariableList(detailConfigResultModel.getNextVariableModels());
				dfsdatatags.get(dfsdatatagsIndex).getDFSMethod().get(1).getDFSVariables()
						.setDFSVariableList(detailConfigResultModel.getContextListVariableModels());
				dfsdatatags.get(dfsdatatagsIndex).getDFSMethod().get(2).getDFSVariables()
						.setDFSVariableList(detailConfigResultModel.getMetaDataVariableModels());
			}

			DFSVariableTableView.setItems(DFSAtrributeMapClt.getDFSMappingSortDataModel(tempDFSMethodData));
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR", "ERROR : DataTag isn't selected",
					"DataTag should be selected in DataTag List");
			messageLog.showAndWait();
		}
	}

	@FXML
	public void handleAddDefineTableButton() {

		SemiMasterInitData = RootGeneralConfigViewController.SemiMasterInitData;
		if (SemiMasterInitData != null) {
			int selectedIndex = searchTableView.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {

				// create new DFSDefineTableModel
				DFSDefineTableModel dfsDefineTableModel = new DFSDefineTableModel();

				DFSAttributeMappingStorgeModel tempDFSAttributeData = new DFSAttributeMappingStorgeModel();
				TableView<ObservableList<Object>> initPreviewTableView = null;
				TableView<ObservableList<Object>> initDPIR_TableView = null;

				dfsDefineTableModel = addTableCtl.showAddTableDialog(databaseSourceSelfTag,
						searchTableView.getItems().get(selectedIndex).getName(), DFSDefineTableView,
						SemiMasterInitData.getSemiDatatagListInitData());

				// create new DFSDatatagModel
				if (dfsDefineTableModel != null) {
					String data_tag_name = dfsDefineTableModel.getData_tag_name();
					String typeLevel = dfsDefineTableModel.getType() + dfsDefineTableModel.getLevel();
					DFSDatatagExportModel dfsDatatagModel = new DFSDatatagExportModel();
					DFSDatatagController dfsDatatagController = new DFSDatatagController();
					ObservableList<DFSVariableItemModel> tempVariableItemModel = FXCollections.observableArrayList();

					for (int i = 0; i < SemiMasterInitData.getSemiDatatagListInitData().size(); i++) {
						String semiTypeLevel = SemiMasterInitData.getSemiDatatagListInitData().get(i).getTypeName()
								+ SemiMasterInitData.getSemiDatatagListInitData().get(i).getLevelName();
						if (typeLevel.equals(semiTypeLevel))
							tempVariableItemModel = FXCollections.observableArrayList(
									SemiMasterInitData.getSemiDatatagListInitData().get(i).getDFSSemiVariableModels());
					}
					dfsDatatagModel = dfsDatatagController.createDFSDatatag(dfsDefineTableModel, tempVariableItemModel);
					
					dfsdatatags.add(dfsDatatagModel);

					tempDFSMethodData = dfsDatatagModel.getDFSMethod();

					tempDFSAttributeData.setDFSMappingMethodData(tempDFSMethodData);
					tempDFSAttributeData.setPreviewTableView(initPreviewTableView);
					tempDFSAttributeData.setDPIR_TableView(initDPIR_TableView);
					DFSMappingTableData.put(data_tag_name, tempDFSAttributeData);

					DFSDefineTableData.add(dfsDefineTableModel);
					searchTableView.getItems().remove(selectedIndex);
					DFSDefineTableView.setItems(DFSDefineTableData);
					DFSDefineTableView.getSelectionModel().select(DFSDefineTableView.getItems().size() - 1);
					DFSVariableTableView.setItems(DFSAtrributeMapClt.getDFSMappingSortDataModel(tempDFSMethodData));
					splitAnchorTable.getChildren().setAll();
				}
			}
		} else {
			
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "SEMIMASTER ERROR", "Need to load Semimaster Config.",
					"(Menu) DFS Generator -> Semimaster Config");
			messageLog.showAndWait();
		}
	}


	@FXML
	private void handlePreviewTableViewClickController() {

		previewTableView.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					if (!DFSDefineTableView.getSelectionModel().getSelectedItem().getContentBoolean()) {
						String data_tag_name = DFSDefineTableView.getSelectionModel().getSelectedItem()
								.getData_tag_name();
						String table_name = DFSDefineTableView.getSelectionModel().getSelectedItem().getTable_Name();
						String table_format = DFSDefineTableView.getSelectionModel().getSelectedItem()
								.getTable_format();

						int dfsVarableTableSize = DFSVariableTableView.getItems().size();
						selectedPreviewTableIndex = previewTableView.getFocusModel().getFocusedCell().getColumn();
						selectedVairableTableIndex = DFSVariableTableView.getSelectionModel().getSelectedIndex();

						if (selectedPreviewTableIndex >= 0 && selectedVairableTableIndex >= 0
								&& data_tag_name != null) {

							String mappingColumnName = previewTableView.getColumns().get(selectedPreviewTableIndex)
									.getText();

							boolean replaceName = false;
							if (selectedVairableTableIndex < dfsVarableTableSize) {
								replaceName = DFSAtrributeMapClt.setDFSMappingDataModel(table_format, table_name,
										mappingColumnName, selectedVairableTableIndex, tempDFSMethodData);
								DFSVariableTableView
										.setItems(DFSAtrributeMapClt.getDFSMappingSortDataModel(tempDFSMethodData));
							}

							if (selectedVairableTableIndex < dfsVarableTableSize - 1 && replaceName)
								DFSVariableTableView.getSelectionModel().select(selectedVairableTableIndex + 1);
							else if (!(selectedVairableTableIndex < dfsVarableTableSize - 1))
								DFSVariableTableView.getSelectionModel().clearSelection();

						}
					} else {
						String data_tag_name = DFSDefineTableView.getSelectionModel().getSelectedItem()
								.getData_tag_name();
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "DATATAG DONE",
								"SELECTED DATATAG IS DONE", "Selected Datatag is done : " + data_tag_name);
						messageLog.showAndWait();
					};
				}
			}
		});
	}

	@FXML
	private void handleRunButtonController() {
		if (DFSDefineTableView.getSelectionModel().getSelectedIndex() >= 0
				&& !DFSDefineTableView.getSelectionModel().getSelectedItem().getContentBoolean()) {
			String selectMode = selectRun.getSelectionModel().getSelectedItem().trim().replaceAll(" ", "");
			DFSDatatagExportModel datatatag = new DFSDatatagExportModel();
			DFSDefineTableModel defineTable = new DFSDefineTableModel();
			Optional<ButtonType> result;

			String data_tag_name = DFSDefineTableView.getSelectionModel().getSelectedItem().getData_tag_name();
			String table_format = DFSDefineTableView.getSelectionModel().getSelectedItem().getTable_format();

			ObservableList<DFSVariableModel> l_metaTableData = tempDFSMethodData.get(2).getDFSVariables()
					.getDFSVariableList();
			ObservableList<DFSVariableModel> temp = DFSAtrributeMapClt.getDFSMappingSortDataModel(tempDFSMethodData);

			for (DFSDatatagExportModel tempDatatag : dfsdatatags)
				if (data_tag_name.equals(tempDatatag.getData_tag_name()))
					datatatag = tempDatatag;

			for (DFSDefineTableModel tempDefineTable : DFSDefineTableData)
				if (data_tag_name.equals(tempDefineTable.getData_tag_name()))
					defineTable = tempDefineTable;

			// "GetPARA", "ResetALL", "ResetDEF", "ResetPARA"
			switch (selectMode) {

			case "ResetALL":
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM RESET ALL MAPPING",
						"Reset all mapping variables.", "Are you sure?");
				result = messageLog.showAndWait();
				if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
					int initSeq = temp.size();
					for (int i = 0; i < initSeq; i++) {
						if (temp.get(i).getVariable_group().equals("PARAMETER")) {
							if (table_format.equals(DefineAtrribute.TABLE_FORMAT.get(1))) {
								int jinit = l_metaTableData.size();
								for (int j = 0; j < jinit; j++)
									if (temp.get(i) == l_metaTableData.get(j)) {
										l_metaTableData.remove(j);
										temp.remove(i);
										--j;
										--jinit;
										--i;
										--initSeq;
										break;
									}
							} else
								temp.get(i).setColumn_name(null);
						} else if (temp.get(i).getdfs_variable_name().equals("STEP")) {
							temp.get(i).setColumn_name("'NA'");
							temp.get(i).setTable_name("");
						} else
							temp.get(i).setColumn_name(null);
					}
				}
				break;

			case "ResetSemiMaster":
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM RESET ATTRIBUTE MAPPING",
						"Reset attribute mapping variables.", "Are you sure?");
				result = messageLog.showAndWait();
				if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
					int initSeq = temp.size();
					for (int i = 0; i < initSeq; i++) {
						if (temp.get(i).getdfs_variable_name().equals("STEP"))
							temp.get(i).setColumn_name("'NA'");
						else if (temp.get(i).getVariable_group().equals("CONTEXT")
								|| temp.get(i).getVariable_group().equals("ATTRIBUTE"))
							temp.get(i).setColumn_name(null);
					}
				}
				break;

			case "ResetParameters":
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM RESET PARAMETERS MAPPING",
						"Reset Parameters mapping variables.", "Are you sure?");
				result = messageLog.showAndWait();
				if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
					int initSeq = temp.size();
					for (int i = 0; i < initSeq; i++) {
						if (temp.get(i).getVariable_group().equals("PARAMETER")) {
							if (table_format.equals(DefineAtrribute.TABLE_FORMAT.get(1))) {
								int jinit = l_metaTableData.size();
								for (int j = 0; j < jinit; j++)
									if (temp.get(i) == l_metaTableData.get(j)) {
										l_metaTableData.remove(j);
										temp.remove(i);
										--j;
										--jinit;
										--i;
										--initSeq;
										break;
									}
							} else {
								temp.get(i).setColumn_name(null);
							}
						}
					}
				}
				break;

			case "AutoMapping":

				break;
			default: // GetPARA
				if (table_format.equals(DefineAtrribute.TABLE_FORMAT.get(1))) {
					boolean allDone = false;
					allDone = checkNotOpt.checkNotOptController(temp);
					if (allDone == true)
						DFSAtrributeMapClt.setDFSMappingDataModel(defineTable, datatatag, tempDFSMethodData,
								previewTableView);
					else {
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING,
								"DEFINE NOT OPTIONAL VARIABLES ERROR",
								"Not optional variables aren't defined mapping column",
								"Please, check variables' Not Opt column.");
						messageLog.showAndWait();
					}
				} else {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "GET PARAMETER WARNING",
							"PIVOT(ORACLE) TABLE FORMAT", "Get Parameter function doesn't work in PIVOT table format.");
					messageLog.showAndWait();
				}
			}
			DFSVariableTableView.getItems().clear();
			DFSVariableTableView.setItems(DFSAtrributeMapClt.getDFSMappingSortDataModel(tempDFSMethodData));
		} else {
			if (DFSDefineTableView.getSelectionModel().getSelectedIndex() >= 0) {
				String data_tag_name = DFSDefineTableView.getSelectionModel().getSelectedItem().getData_tag_name();
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "DATATAG DONE",
						"SELECTED DATATAG IS DONE", "Selected Datatag is done : " + data_tag_name);
				messageLog.showAndWait();
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "SELECT ERROR", "NO SELECT DATATAG",
						"Check, select Datatag in list");
				messageLog.showAndWait();
			}
		}
	}

	@FXML
	private void handleDefineTableClickController() {

		int selectedDefineTableIndex = DFSDefineTableView.getSelectionModel().getSelectedIndex();
		// check previous instance exist and call instance
		if (selectedDefineTableIndex >= 0) {
			String l_data_tag_name = DFSDefineTableView.getItems().get(selectedDefineTableIndex).getData_tag_name();
			if (DFSMappingTableData.get(l_data_tag_name) != null) {
				tempDFSMethodData = DFSMappingTableData.get(l_data_tag_name).getDFSMappingMethodData();
				DFSVariableTableView.setItems(DFSAtrributeMapClt.getDFSMappingSortDataModel(tempDFSMethodData));
				if (DFSMappingTableData.get(l_data_tag_name).getPreviewTableView() != null) {
					previewTableView = DFSMappingTableData.get(l_data_tag_name).getPreviewTableView();
					splitAnchorTable.getChildren().setAll(previewTableView);
				} else {
					splitAnchorTable.getChildren().setAll();
				}
			}
		}

	}

	// get db table data
	@FXML
	public void handle_getPreviewData() {
		int selectedDefineTableIndex = DFSDefineTableView.getSelectionModel().getSelectedIndex();
		if (selectedDefineTableIndex >= 0) {
			// get table name
			String l_tableName = DFSDefineTableView.getItems().get(selectedDefineTableIndex).getTable_Name();
			String datatagName = DFSDefineTableView.getItems().get(selectedDefineTableIndex).getData_tag_name();
			preTable = new DFSGeneratorPreviewTableDataController();
		
			previewTableView = preTable.getPriviewRawData(connDB, l_tableName);

			// create mapping dynamicTable instance
			previewTableView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					handlePreviewTableViewClickController();
				}
			});

			DFSMappingTableData.get(datatagName).setPreviewTableView(previewTableView);
			// }
			splitAnchorTable.getChildren().setAll(previewTableView);
			previewTableView.prefWidthProperty().bind(splitAnchorTable.widthProperty());
			previewTableView.prefHeightProperty().bind(splitAnchorTable.heightProperty());
			previewTableView.getSelectionModel().setCellSelectionEnabled(true);

		}
	}

	// DFSVariable select item cancel
	@FXML
	private void handleDFSVariableCancelController() {

		DFSVariableTableView.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ESCAPE)) {
					DFSVariableTableView.getSelectionModel().clearSelection();
				}
			}
		});
	}

	@FXML
	public void handleRemoveDefineTableButton() {

		boolean continueConfirm = false;
		boolean exists = false;
		int selectedIndex = DFSDefineTableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "WARING INFO",
					"DFS SETTING TABLE DELETE!", "Are you OK?");
			Optional<ButtonType> result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
				if (searchTableView.getItems().size() > 0) {
					continueConfirm = true;
					for (int i = 0; i < searchTableView.getItems().size(); i++) {
						if (DFSDefineTableData.get(selectedIndex).getTable_Name()
								.equals(searchTableView.getItems().get(i).getName())) {
							messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM INFO",
									"SELECTED TABLE DUPLICATE",
									"There is a duplicated table in DFS Define Table List.\nDelete the duplicated table list.\n Continue?");
							Optional<ButtonType> answer = messageLog.showAndWait();
							if (answer.get().getButtonData() == ButtonType.OK.getButtonData()) {
								continueConfirm = true;
								exists = true;
							} else {
								continueConfirm = false;
								break;
							}
						}
					}
				}
			} else {
				continueConfirm = false;
			}

			if (continueConfirm) {
				String l_data_tag_name = DFSDefineTableView.getItems().get(selectedIndex).getData_tag_name();
				if (!exists)
					searchTableData.add(
							new SimpleTableModel(DFSDefineTableView.getItems().get(selectedIndex).getTable_Name(), ""));

				DFSDefineTableView.getItems().remove(selectedIndex);
				DFSMappingTableData.remove(l_data_tag_name);
				DFSVariableTableView.getItems().clear();
				splitAnchorTable.getChildren().setAll();
				for (int i = 0; i < dfsdatatags.size(); i++) {
					if (l_data_tag_name.equals(dfsdatatags.get(i).getData_tag_name()))
						dfsdatatags.remove(i);
				}
				searchTableView.setItems(searchTableData);
			}
		}
	}
}
