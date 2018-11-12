package com.digilog.meerkat.view.DFSGenerator.crawler;

import java.io.IOException;
import java.util.Optional;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.DFSGeneratorController.crawler.DFSSearchTableColumnController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSDetailAddVariableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSDetailConfigResultModel;
import com.digilog.meerkat.model.dfsGenerator.DFSTempDetailVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.util.DFSVariableModelCopyController;
import com.digilog.meerkat.util.MessageDialog;
import com.digilog.meerkat.view.DFSGenerator.DFSGeneratorAddVariableController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorTableDetailConfigEditController {
	private DFSVariableModelCopyController variableCopy;
	private ObservableList<DFSVariableModel> nextVariableModels;
	private ObservableList<DFSVariableModel> contextListVariableModels;
	private ObservableList<DFSVariableModel> metaDataVariableModels;
	private DFSSearchTableColumnController searchColumn = new DFSSearchTableColumnController();
	private DFSGeneratorAddVariableController addVariableController;
	private DFSDetailAddVariableModel returnAddVariableModel = new DFSDetailAddVariableModel();
	private DFSDetailConfigResultModel detailConfigResultModel = new DFSDetailConfigResultModel();
	private Optional<ButtonType> result;

	@FXML
	private TextField DFSDataTagNameField;
	@FXML
	private TextField aliasNameField;
	@FXML
	private TextField timeFormatField;
	@FXML
	private TextField tableFormatField;
	@FXML
	private TextField typeLevelField;
	@FXML
	private TextField serachColumnField;

	@FXML
	private Button searchButton;
	@FXML
	private Button timeFormatChangeButton;
	@FXML
	private Button addVariableButton;
	@FXML
	private Button deleteVariableButton;
	@FXML
	private Button OK_Button;
	@FXML
	private Button Cancel_Button;
	@FXML
	private ComboBox<String> timeFormatSelectedCombo;

	@FXML
	private TreeTableView<DFSMethodExportModel> DFSMethod_treeTableView;
	@FXML
	private TreeTableColumn<DFSMethodExportModel, String> hint;
	@FXML
	private TreeTableColumn<DFSMethodExportModel, String> temptable;
	@FXML
	private TreeTableColumn<DFSMethodExportModel, String> temptable_keycolumn;
	@FXML
	private TreeTableColumn<DFSMethodExportModel, String> prefix;
	@FXML
	private TreeTableColumn<DFSMethodExportModel, String> postfix;
	@FXML
	private TreeTableColumn<DFSMethodExportModel, String> join;
	@FXML
	private TreeTableColumn<DFSMethodExportModel, String> condition;

	@FXML
	private TableView<DFSVariableModel> DFS_NEXTATTRIBUTE_TableView;
	@FXML
	private TableColumn<DFSVariableModel, Boolean> n_useColumn;
	@FXML
	private TableColumn<DFSVariableModel, String> n_dfs_variable_name;
	@FXML
	private TableColumn<DFSVariableModel, String> n_column_name;
	@FXML
	private TableColumn<DFSVariableModel, String> n_table_name;
	@FXML
	private TableColumn<DFSVariableModel, String> n_variable_type;
	@FXML
	private TableColumn<DFSVariableModel, String> n_variable_group;
	@FXML
	private TableColumn<DFSVariableModel, String> n_role;
	@FXML
	private TableColumn<DFSVariableModel, String> n_pivot;
	@FXML
	private TableColumn<DFSVariableModel, String> n_summarization;
	@FXML
	private TableColumn<DFSVariableModel, String> n_groupby;
	@FXML
	private TableColumn<DFSVariableModel, String> n_exclude_condition;
	@FXML
	private TableColumn<DFSVariableModel, String> n_totime_javaformat;
	@FXML
	private TableColumn<DFSVariableModel, String> n_totime;
	@FXML
	private TableColumn<DFSVariableModel, String> n_timetochar;
	@FXML
	private TableColumn<DFSVariableModel, String> n_numbertochar;

	@FXML
	private TableView<DFSVariableModel> DFS_CONTEXTLIST_TableView;
	@FXML
	private TableColumn<DFSVariableModel, Boolean> c_useColumn;
	@FXML
	private TableColumn<DFSVariableModel, String> c_dfs_variable_name;
	@FXML
	private TableColumn<DFSVariableModel, String> c_column_name;
	@FXML
	private TableColumn<DFSVariableModel, String> c_table_name;
	@FXML
	private TableColumn<DFSVariableModel, String> c_variable_type;
	@FXML
	private TableColumn<DFSVariableModel, String> c_variable_group;
	@FXML
	private TableColumn<DFSVariableModel, String> c_role;
	@FXML
	private TableColumn<DFSVariableModel, String> c_pivot;
	@FXML
	private TableColumn<DFSVariableModel, String> c_summarization;
	@FXML
	private TableColumn<DFSVariableModel, String> c_groupby;
	@FXML
	private TableColumn<DFSVariableModel, String> c_exclude_condition;
	@FXML
	private TableColumn<DFSVariableModel, String> c_totime_javaformat;
	@FXML
	private TableColumn<DFSVariableModel, String> c_totime;
	@FXML
	private TableColumn<DFSVariableModel, String> c_timetochar;
	@FXML
	private TableColumn<DFSVariableModel, String> c_numbertochar;

	@FXML
	private TableView<DFSVariableModel> DFS_METADATA_TableView;
	@FXML
	private TableColumn<DFSVariableModel, Boolean> m_useColumn;
	@FXML
	private TableColumn<DFSVariableModel, String> m_dfs_variable_name;
	@FXML
	private TableColumn<DFSVariableModel, String> m_column_name;
	@FXML
	private TableColumn<DFSVariableModel, String> m_table_name;
	@FXML
	private TableColumn<DFSVariableModel, String> m_variable_type;
	@FXML
	private TableColumn<DFSVariableModel, String> m_variable_group;
	@FXML
	private TableColumn<DFSVariableModel, String> m_role;
	@FXML
	private TableColumn<DFSVariableModel, String> m_pivot;
	@FXML
	private TableColumn<DFSVariableModel, String> m_summarization;
	@FXML
	private TableColumn<DFSVariableModel, String> m_groupby;
	@FXML
	private TableColumn<DFSVariableModel, String> m_exclude_condition;
	@FXML
	private TableColumn<DFSVariableModel, String> m_timeAndNumberFormat;
	@FXML
	private TableColumn<DFSVariableModel, String> m_totime_javaformat;
	@FXML
	private TableColumn<DFSVariableModel, String> m_totime;
	@FXML
	private TableColumn<DFSVariableModel, String> m_timetochar;
	@FXML
	private TableColumn<DFSVariableModel, String> m_numbertochar;

	@FXML
	private ContextMenu nextAttributeMenu;
	@FXML
	private MenuItem nextAdd;
	@FXML
	private Menu nextDeleteMenu;
	@FXML
	private MenuItem nextDelete;
	@FXML
	private MenuItem nextAllLinkedDelete;
	@FXML
	private SeparatorMenuItem nextSepMenu;
	@FXML
	private Menu nextCopyMenu;
	@FXML
	private MenuItem nextCopyToContext;
	@FXML
	private MenuItem nextCopyToMeta;
	@FXML
	private Menu nextUnlinkMenu;
	@FXML
	private MenuItem nextSeletedVariable;
	@FXML
	private MenuItem nextAllVariables;

	@FXML
	private ContextMenu contextMenu;
	@FXML
	private MenuItem conAdd;
	@FXML
	private Menu conDeleteMenu;
	@FXML
	private MenuItem conDelete;
	@FXML
	private MenuItem conAllLinkedDelete;
	@FXML
	private SeparatorMenuItem conSepMenu;
	@FXML
	private Menu conCopyMenu;
	@FXML
	private MenuItem conCopyToNext;
	@FXML
	private MenuItem conCopyToMeta;
	@FXML
	private Menu conUnlinkMenu;
	@FXML
	private MenuItem conSeletedVariable;
	@FXML
	private MenuItem conAllVariables;

	@FXML
	private ContextMenu metaDataMenu;
	@FXML
	private MenuItem metaAdd;
	@FXML
	private Menu metaDeleteMenu;
	@FXML
	private MenuItem metaDelete;
	@FXML
	private MenuItem metaAllLinkedDelete;
	@FXML
	private SeparatorMenuItem metaSepMenu;
	@FXML
	private Menu metaCopyMenu;
	@FXML
	private MenuItem metaCopyToNext;
	@FXML
	private MenuItem metaCopyToContext;

	// check dialogBox
	private MessageDialog mDialog;
	private Alert messageLog;
	private Stage dialogStage;

	private String currentTableView;

	public DFSGeneratorTableDetailConfigEditController() {
		variableCopy = new DFSVariableModelCopyController();
		nextVariableModels = FXCollections.observableArrayList();
		contextListVariableModels =FXCollections.observableArrayList();
		metaDataVariableModels = FXCollections.observableArrayList();
		addVariableController = new DFSGeneratorAddVariableController();
		currentTableView = "metaData";
	}

	@FXML
	private void initialize() {

		mDialog = new MessageDialog();
		timeFormatSelectedCombo.getItems().setAll(DefineAtrribute.TIME_FORMAT);

		n_useColumn.setCellValueFactory(cellData -> cellData.getValue().contentBooleanProperty());
		n_useColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));
		n_dfs_variable_name.setCellValueFactory(cellData -> cellData.getValue().dfs_variable_nameProperty());
		n_dfs_variable_name.setCellFactory(TextFieldTableCell.forTableColumn());
		n_column_name.setCellValueFactory(cellData -> cellData.getValue().column_nameProperty());
		n_column_name.setCellFactory(TextFieldTableCell.forTableColumn());
		n_table_name.setCellValueFactory(cellData -> cellData.getValue().table_nameProperty());
		n_table_name.setCellFactory(TextFieldTableCell.forTableColumn());
		n_variable_type.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		n_variable_type.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		n_variable_group.setCellValueFactory(cellData -> cellData.getValue().variable_groupProperty());
		n_variable_group.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_GROUP_TYPE));
		n_role.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
		n_role.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.ROLE_TYPE));
		n_pivot.setCellValueFactory(cellData -> cellData.getValue().pivotProperty());
		n_pivot.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.PIVOT_TYPE));
		n_summarization.setCellValueFactory(cellData -> cellData.getValue().summarizationProperty());
		n_summarization.setCellFactory(TextFieldTableCell.forTableColumn());
		n_groupby.setCellValueFactory(cellData -> cellData.getValue().groupbyProperty());
		n_groupby.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.GROUPBY_TYPE));
		n_exclude_condition.setCellValueFactory(cellData -> cellData.getValue().exclude_conditionProperty());
		n_exclude_condition.setCellFactory(TextFieldTableCell.forTableColumn());
		n_totime_javaformat.setCellValueFactory(cellData -> cellData.getValue().totime_javaformatProperty());
		n_totime_javaformat.setCellFactory(TextFieldTableCell.forTableColumn());
		n_totime.setCellValueFactory(cellData -> cellData.getValue().totimeProperty());
		n_totime.setCellFactory(TextFieldTableCell.forTableColumn());
		n_timetochar.setCellValueFactory(cellData -> cellData.getValue().timetocharProperty());
		n_timetochar.setCellFactory(TextFieldTableCell.forTableColumn());
		n_numbertochar.setCellValueFactory(cellData -> cellData.getValue().numbertocharProperty());
		n_numbertochar.setCellFactory(TextFieldTableCell.forTableColumn());

		c_useColumn.setCellValueFactory(cellData -> cellData.getValue().contentBooleanProperty());
		c_useColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));
		c_dfs_variable_name.setCellValueFactory(cellData -> cellData.getValue().dfs_variable_nameProperty());
		c_dfs_variable_name.setCellFactory(TextFieldTableCell.forTableColumn());
		c_column_name.setCellValueFactory(cellData -> cellData.getValue().column_nameProperty());
		c_column_name.setCellFactory(TextFieldTableCell.forTableColumn());
		c_table_name.setCellValueFactory(cellData -> cellData.getValue().table_nameProperty());
		c_table_name.setCellFactory(TextFieldTableCell.forTableColumn());
		c_variable_type.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		c_variable_type.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		c_variable_group.setCellValueFactory(cellData -> cellData.getValue().variable_groupProperty());
		c_variable_group.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_GROUP_TYPE));
		c_role.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
		c_role.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.ROLE_TYPE));
		c_pivot.setCellValueFactory(cellData -> cellData.getValue().pivotProperty());
		c_pivot.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.PIVOT_TYPE));
		c_summarization.setCellValueFactory(cellData -> cellData.getValue().summarizationProperty());
		c_summarization.setCellFactory(TextFieldTableCell.forTableColumn());
		c_groupby.setCellValueFactory(cellData -> cellData.getValue().groupbyProperty());
		c_groupby.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.GROUPBY_TYPE));
		c_exclude_condition.setCellValueFactory(cellData -> cellData.getValue().exclude_conditionProperty());
		c_exclude_condition.setCellFactory(TextFieldTableCell.forTableColumn());
		c_totime_javaformat.setCellValueFactory(cellData -> cellData.getValue().totime_javaformatProperty());
		c_totime_javaformat.setCellFactory(TextFieldTableCell.forTableColumn());
		c_totime.setCellValueFactory(cellData -> cellData.getValue().totimeProperty());
		c_totime.setCellFactory(TextFieldTableCell.forTableColumn());
		c_timetochar.setCellValueFactory(cellData -> cellData.getValue().timetocharProperty());
		c_timetochar.setCellFactory(TextFieldTableCell.forTableColumn());
		c_numbertochar.setCellValueFactory(cellData -> cellData.getValue().numbertocharProperty());
		c_numbertochar.setCellFactory(TextFieldTableCell.forTableColumn());

		m_useColumn.setCellValueFactory(cellData -> cellData.getValue().contentBooleanProperty());
		m_useColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));
		m_dfs_variable_name.setCellValueFactory(cellData -> cellData.getValue().dfs_variable_nameProperty());
		m_dfs_variable_name.setCellFactory(TextFieldTableCell.forTableColumn());
		m_column_name.setCellValueFactory(cellData -> cellData.getValue().column_nameProperty());
		m_column_name.setCellFactory(TextFieldTableCell.forTableColumn());
		m_table_name.setCellValueFactory(cellData -> cellData.getValue().table_nameProperty());
		m_table_name.setCellFactory(TextFieldTableCell.forTableColumn());
		m_variable_type.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		m_variable_type.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		m_variable_group.setCellValueFactory(cellData -> cellData.getValue().variable_groupProperty());
		m_variable_group.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_GROUP_TYPE));
		m_role.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
		m_role.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.ROLE_TYPE));
		m_pivot.setCellValueFactory(cellData -> cellData.getValue().pivotProperty());
		m_pivot.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.PIVOT_TYPE));
		m_summarization.setCellValueFactory(cellData -> cellData.getValue().summarizationProperty());
		m_summarization.setCellFactory(TextFieldTableCell.forTableColumn());
		m_groupby.setCellValueFactory(cellData -> cellData.getValue().groupbyProperty());
		m_groupby.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.GROUPBY_TYPE));
		m_exclude_condition.setCellValueFactory(cellData -> cellData.getValue().exclude_conditionProperty());
		m_exclude_condition.setCellFactory(TextFieldTableCell.forTableColumn());
		m_totime_javaformat.setCellValueFactory(cellData -> cellData.getValue().totime_javaformatProperty());
		m_totime_javaformat.setCellFactory(TextFieldTableCell.forTableColumn());
		m_totime.setCellValueFactory(cellData -> cellData.getValue().totimeProperty());
		m_totime.setCellFactory(TextFieldTableCell.forTableColumn());
		m_timetochar.setCellValueFactory(cellData -> cellData.getValue().timetocharProperty());
		m_timetochar.setCellFactory(TextFieldTableCell.forTableColumn());
		m_numbertochar.setCellValueFactory(cellData -> cellData.getValue().numbertocharProperty());
		m_numbertochar.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}

	@FXML
	private void handle_OK() {
		detailConfigResultModel.setSetCheck(true);
		detailConfigResultModel.setNextVariableModels(nextVariableModels);
		detailConfigResultModel.setContextListVariableModels(contextListVariableModels);
		detailConfigResultModel.setMetaDataVariableModels(metaDataVariableModels);
		dialogStage.close();
	}

	@FXML
	private void handle_mouse_nextAdd() {
		handle_AddVariable();
	}

	@FXML
	private void handle_mouse_nextDelete() {
		handle_deleteVariable();
	}
	
	@FXML
	private void handle_mouse_nextAllLinkedDelete() {
		int selectedIdx = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedIndex();
		if(selectedIdx >=0 ) {
//			String name = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			handle_allLinkedDeleteVariable(DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedItem());
		}
		else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : NO SELECT VARIABLES",
					"Variable isn't selected.", "Select variable to be deleted.");
			messageLog.showAndWait();
		}
	}
	

	@FXML
	private void handle_mouse_nextCopyToContext() {
		int selectedNextTableIndex = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedIndex();
		if (selectedNextTableIndex >= 0) {
			String name = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();

			if (!checkExistVariable(name, contextListVariableModels)) {
				for (int i = 0; i < nextVariableModels.size(); i++) {
					if (name.equals(nextVariableModels.get(i).getdfs_variable_name())) {
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM ADD VARIABLE",
								name + " variable add to CONTEXTLIST", "Are you sure?");
						result = messageLog.showAndWait();
						if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
							contextListVariableModels
									.add(nextVariableModels.get(i));
						}
						break;
					}
				}
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED",
						"Selected variable is duplicated.", "There is selected variable in CONTEXTLIST");
				messageLog.showAndWait();
			}
		}
	}

	@FXML
	private void handle_mouse_nextCopyToMETA() {
		int selectedNextTableIndex = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedIndex();
		if (selectedNextTableIndex >= 0) {
			String name = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();

			if (!checkExistVariable(name, metaDataVariableModels)) {
				for (int i = 0; i < nextVariableModels.size(); i++) {
					if (name.equals(nextVariableModels.get(i).getdfs_variable_name())) {
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM ADD VARIABLE",
								name + " variable add to METADATA", "Are you sure?");
						result = messageLog.showAndWait();
						if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
							metaDataVariableModels
									.add(nextVariableModels.get(i));
						}
						break;
					}
				}
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED",
						"Selected variable is duplicated.", "There is selected variable in METADATA");
				messageLog.showAndWait();
			}
		}
	}

	@FXML
	private void handle_unlink_nextSelectedVariable() {
		int selectedNextTableIndex = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedIndex();
		if (selectedNextTableIndex >= 0) {
			String name = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			for (int i = 0; i < nextVariableModels.size(); i++) {
				if (name.equals(nextVariableModels.get(i).getdfs_variable_name())) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM UNLINK VARIABLE",
							name + " variable unlink in NEXTATTRIBUTE", "Are you sure?");
					result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						DFSVariableModel tempDataModel = nextVariableModels.get(i);
						DFSVariableModel variableModel = new DFSVariableModel(tempDataModel.getContentBoolean(),
								tempDataModel.getdfs_variable_name(), tempDataModel.getColumn_name(),
								tempDataModel.getTable_name(), tempDataModel.getVariable_type(),
								tempDataModel.getVariable_group(), tempDataModel.getRole(), tempDataModel.getPivot(),
								tempDataModel.getSummarization(), tempDataModel.getGroupby(),
								tempDataModel.getExclude_condition(), tempDataModel.getTotime_javaformat(),
								tempDataModel.getTotime(), tempDataModel.getTimetochar(),
								tempDataModel.getNumbertochar());
						nextVariableModels.set(i, variableModel);
						break;
					}
				}
			}
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : NO SELECT",
					"There is no selected variable.", null);
			messageLog.showAndWait();
		}

	}

	@FXML
	private void handle_unlink_nextAllVariable() {
		handle_unlink_allVariable("NEXTATTRIBUTE", nextVariableModels);	
	}

	@FXML
	private void handle_mouse_conDelete() {
		handle_deleteVariable();
	}
	
	@FXML
	private void handle_mouse_conAllLinkedDelete() {
		int selectedIdx = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedIndex();
		if(selectedIdx >=0 ) {
//			String name = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			
			handle_allLinkedDeleteVariable(DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedItem());
		}
		else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : NO SELECT VARIABLES",
					"Variable isn't selected.", "Select variable to be deleted.");
			messageLog.showAndWait();
		}
	}
	
	@FXML
	private void handle_unlink_conSelectedVariable() {
		int selectedNextTableIndex = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedIndex();
		if (selectedNextTableIndex >= 0) {
			String name = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			for (int i = 0; i < contextListVariableModels.size(); i++) {
				if (name.equals(contextListVariableModels.get(i).getdfs_variable_name())) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM UNLINK VARIABLE",
							name + " variable unlink in CONTEXTLIST", "Are you sure?");
					result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						DFSVariableModel tempDataModel = contextListVariableModels.get(i);
						DFSVariableModel variableModel = new DFSVariableModel(tempDataModel.getContentBoolean(),
								tempDataModel.getdfs_variable_name(), tempDataModel.getColumn_name(),
								tempDataModel.getTable_name(), tempDataModel.getVariable_type(),
								tempDataModel.getVariable_group(), tempDataModel.getRole(), tempDataModel.getPivot(),
								tempDataModel.getSummarization(), tempDataModel.getGroupby(),
								tempDataModel.getExclude_condition(), tempDataModel.getTotime_javaformat(),
								tempDataModel.getTotime(), tempDataModel.getTimetochar(),
								tempDataModel.getNumbertochar());
						contextListVariableModels.set(i, variableModel);
						break;
					}
				}
			}
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : NO SELECT",
					"There is no selected variable.", null);
			messageLog.showAndWait();
		}

	}

	@FXML
	private void handle_unlink_conAllVariable() {
		handle_unlink_allVariable("CONTEXTLIST", contextListVariableModels);
	}

	@FXML
	private void handle_mouse_conCopyToNext() {
		int selectedContextTableIndex = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedIndex();
		if (selectedContextTableIndex >= 0) {
			String name = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			if (!checkExistVariable(name, nextVariableModels)) {
				for (int i = 0; i < contextListVariableModels.size(); i++) {
					if (name.equals(contextListVariableModels.get(i).getdfs_variable_name())) {
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM ADD VARIABLE",
								name + " variable add to CONTEXTLIST", "Are you sure?");
						result = messageLog.showAndWait();
						if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
							nextVariableModels
									.add(contextListVariableModels.get(i));
						}
						break;
					}
				}
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED",
						"Selected variable is duplicated.", "There is selected variable in NEXTATTRIBUTE");
				messageLog.showAndWait();
			}
		}
	}

	@FXML
	private void handle_mouse_conCopyToMETA() {
		int selectedContextTableIndex = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedIndex();
		if (selectedContextTableIndex >= 0) {
			String name = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			if (!checkExistVariable(name, metaDataVariableModels)) {
				for (int i = 0; i < contextListVariableModels.size(); i++) {
					if (name.equals(contextListVariableModels.get(i).getdfs_variable_name())) {
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM ADD VARIABLE",
								name + " variable add to METADATA", "Are you sure?");
						result = messageLog.showAndWait();
						if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
							metaDataVariableModels
									.add(contextListVariableModels.get(i));
						}
						break;
					}
				}
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED",
						"Selected variable is duplicated.", "There is selected variable in METADATA");
				messageLog.showAndWait();
			}
		}
	}

	@FXML
	private void handle_mouse_metaAdd() {
		handle_AddVariable();
	}

	@FXML
	private void handle_mouse_metaDelete() {
		handle_deleteVariable();
	}
	
	@FXML
	private void handle_mouse_metaAllLinkedDelete() {
		int selectedIdx = DFS_METADATA_TableView.getSelectionModel().getSelectedIndex();
		if(selectedIdx >=0 ) {
//			String name = DFS_METADATA_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			handle_allLinkedDeleteVariable(DFS_METADATA_TableView.getSelectionModel().getSelectedItem());
		}
		else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : NO SELECT VARIABLES",
					"Variable isn't selected.", "Select variable to be deleted.");
			messageLog.showAndWait();
		}
	}
	

	@FXML
	private void handle_mouse_metaCopyToNext() {
		int selectedMetaDataTableIndex = DFS_METADATA_TableView.getSelectionModel().getSelectedIndex();
		if (selectedMetaDataTableIndex >= 0) {
			String name = DFS_METADATA_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			if (!checkExistVariable(name, nextVariableModels)) {
				for (int i = 0; i < metaDataVariableModels.size(); i++) {
					if (name.equals(metaDataVariableModels.get(i).getdfs_variable_name())) {
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM ADD VARIABLE",
								name + " variable add to NEXTATTRIBUTE", "Are you sure?");
						result = messageLog.showAndWait();
						if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
							nextVariableModels
									.add(metaDataVariableModels.get(i));
						}
						break;
					}
				}
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED",
						"Selected variable is duplicated.", "There is selected variable in NEXTATTRIBUTE");
				messageLog.showAndWait();
			}
		}
	}

	@FXML
	private void handle_mouse_metaCopyToContext() {
		int selectedMetaDataTableIndex = DFS_METADATA_TableView.getSelectionModel().getSelectedIndex();
		if (selectedMetaDataTableIndex >= 0) {
			String name = DFS_METADATA_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			if (!checkExistVariable(name, contextListVariableModels)) {
				for (int i = 0; i < metaDataVariableModels.size(); i++) {
					if (name.equals(metaDataVariableModels.get(i).getdfs_variable_name())) {
						messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM ADD VARIABLE",
								name + " variable add to CONTEXTLIST", "Are you sure?");
						result = messageLog.showAndWait();
						if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
							contextListVariableModels
									.add(metaDataVariableModels.get(i));
						}
						break;
					}
				}
			} else {
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED",
						"Selected variable is duplicated.", "There is selected variable in CONTEXTLIST");
				messageLog.showAndWait();
			}
		}
	}

	@FXML
	private void handle_AddVariable() {

		DFSTempDetailVariableModel tempDetailVariables = new DFSTempDetailVariableModel();
		tempDetailVariables.setNextAttributeVariables(nextVariableModels);
		tempDetailVariables.setContextListVariable(contextListVariableModels);
		tempDetailVariables.setMetaDataVariables(metaDataVariableModels);

		returnAddVariableModel = addVariableController.showAddVariableDialog(DFSDataTagNameField.getText(),
				currentTableView, tempDetailVariables);
		//
		if (returnAddVariableModel.isAll()) {
			nextVariableModels.add(returnAddVariableModel.getDfsVariable());
			contextListVariableModels.add(returnAddVariableModel.getDfsVariable());
			metaDataVariableModels.add(returnAddVariableModel.getDfsVariable());
		} else {
			if (returnAddVariableModel.isNextattribute()) {
				nextVariableModels.add(returnAddVariableModel.getDfsVariable());
			}

			if (returnAddVariableModel.isContextlist()) {
				contextListVariableModels.add(returnAddVariableModel.getDfsVariable());
			}

			if (returnAddVariableModel.isMetadata()) {
				metaDataVariableModels.add(returnAddVariableModel.getDfsVariable());
			}
		}

	}
	
	private void handle_unlink_allVariable(String name, ObservableList<DFSVariableModel> orgVariableModel) {
		
		ObservableList<DFSVariableModel> tempVariableModel = FXCollections.observableArrayList();
		if (orgVariableModel.size() > 0) {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM UNLINK VARIABLE",
					"All variable unlink in " + name + ".", "Are you sure?");
			result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
				
				for (int i = 0; i < orgVariableModel.size(); i++) {
					tempVariableModel = variableCopy.copyDFSVariableModelList(orgVariableModel);
				}
				
//				orgVariableModel = tempVariableModel;
				switch (name) {
				case "NEXTATTRIBUTE":
					nextVariableModels = tempVariableModel;
					DFS_NEXTATTRIBUTE_TableView.setItems(nextVariableModels);
					break;

				case "CONTEXTLIST":
					contextListVariableModels = tempVariableModel;
					DFS_CONTEXTLIST_TableView.setItems(contextListVariableModels);
					break;

				default: // METADATA
					metaDataVariableModels = tempVariableModel;
					DFS_METADATA_TableView.setItems(metaDataVariableModels);
					break;
				}
			}
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "NO VARIABLE IN LIST",
					"There is no variable.", "Check " + name + " list.");
			messageLog.showAndWait();
		}
	}

	
	private void handle_allLinkedDeleteVariable(DFSVariableModel deleteVariableInstance) {
		int nextIdx = -1;
		int conIdx = -1;
		int metaIdx = -1;
		
		String name = deleteVariableInstance.getdfs_variable_name();
		String next = "";
		String context = "";
		String meta = "";
		
		for (int i = 0; i < nextVariableModels.size(); i++) {
			if (deleteVariableInstance == nextVariableModels.get(i)) {
				nextIdx = i;
				next = "NEXTATTRIBUTE  ";
				break;
			}
		}

		for (int i = 0; i < contextListVariableModels.size(); i++) {
			if (deleteVariableInstance == contextListVariableModels.get(i)) {
				conIdx = i;
				context = "CONTEXTLIST  ";
				break;
			}
		}

		for (int i = 0; i < metaDataVariableModels.size(); i++) {
			if (deleteVariableInstance == metaDataVariableModels.get(i)) {
				metaIdx = i;
				meta = "METADATA  ";
				break;
			}
		}
				
		messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM DELETE VARIABLE",
				"delete " + name + " variable in "+next+context+meta, "Are you sure?");
		result = messageLog.showAndWait();
		
		if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {	
			if(nextIdx>=0)
				nextVariableModels.remove(nextIdx);
			if(conIdx>=0)
				contextListVariableModels.remove(conIdx);
			if(metaIdx>=0)
				metaDataVariableModels.remove(metaIdx);
		}
	}

	@FXML
	private void handle_deleteVariable() {
		int selectedNextTableIndex = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedIndex();
		int selectedContextTableIndex = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedIndex();
		int selectedMetaTableIndex = DFS_METADATA_TableView.getSelectionModel().getSelectedIndex();

		if (selectedNextTableIndex >= 0) {
			String name = DFS_NEXTATTRIBUTE_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			for (int i = 0; i < nextVariableModels.size(); i++) {
				if (name.equals(nextVariableModels.get(i).getdfs_variable_name())) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM DELETE VARIABLE",
							"delete " + name + " variable in NEXTATTRIBUTE", "Are you sure?");
					result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						nextVariableModels.remove(i);
					}
					break;
				}
			}

		} else if (selectedContextTableIndex >= 0) {
			String name = DFS_CONTEXTLIST_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();
			for (int i = 0; i < contextListVariableModels.size(); i++) {
				if (name.equals(contextListVariableModels.get(i).getdfs_variable_name())) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM DELETE VARIABLE",
							"delete " + name + " variable in CONTEXTLIST", "Are you sure?");
					result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						contextListVariableModels.remove(i);
					}
					break;
				}
			}

		} else if (selectedMetaTableIndex >= 0) {
			String name = DFS_METADATA_TableView.getSelectionModel().getSelectedItem().getdfs_variable_name();

			for (int i = 0; i < metaDataVariableModels.size(); i++) {
				if (name.equals(metaDataVariableModels.get(i).getdfs_variable_name())) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "CONFIRM DELETE VARIABLE",
							"delete " + name + " variable in METADATA", "Are you sure?");
					result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						metaDataVariableModels.remove(i);
					}
					break;
				}
			}
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "NO SELECTED VARIABLE",
					"There is no selected variable.", "Select variable which you want to delete.");
			messageLog.showAndWait();
		}
	}

	@FXML
	private void handle_timeFormatChange() {

		if (timeFormatField.getText() != null && !timeFormatField.getText().equals("") 
				&& timeFormatSelectedCombo.getSelectionModel().getSelectedIndex()>=0) {
			String timeFormat = "";
			timeFormat = (timeFormatSelectedCombo.getSelectionModel().getSelectedItem().toString()).replace(" ", "");
			changeTimeFormat(timeFormat, nextVariableModels);
			changeTimeFormat(timeFormat, contextListVariableModels);
			changeTimeFormat(timeFormat, metaDataVariableModels);
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : TIME FORMAT",
					"Select time format to be changed.", "Check, select time format.");
			messageLog.showAndWait();
		}
	}

	private void changeTimeFormat(String timeFormat, ObservableList<DFSVariableModel> variableModel) {
		int cnt = variableModel.size();
		if (cnt >= 0) {
			switch (timeFormat) {
			case "TOTIME_JAVAFORMAT":
				for (int i = 0; i < cnt; i++) {
					variableModel.get(i).setTotime_javaformat(timeFormatField.getText());
				}
				break;

			case "TOTIME":
				for (int i = 0; i < cnt; i++) {
					variableModel.get(i).setTotime(timeFormatField.getText());
				}
				break;

			case "TIMETOCHAR":
				for (int i = 0; i < cnt; i++) {
					variableModel.get(i).setTimetochar(timeFormatField.getText());
				}
				break;

			case "NUMBERTOCHAR":
				for (int i = 0; i < cnt; i++) {
					variableModel.get(i).setNumbertochar(timeFormatField.getText());
				}
				break;
			default:
				messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : TIME FORMAT",
						"Select time format to be changed.", "Check, select time format.");
				messageLog.showAndWait();
				break;
			}
		}
	}

	@FXML
	private void handle_searchColumn() {
		searchColumn.searchTableColumnContent(DFS_METADATA_TableView, serachColumnField.getText());
	}

	private boolean checkExistVariable(String name, ObservableList<DFSVariableModel> variableModel) {
		for (int i = 0; i < variableModel.size(); i++)
			if (name.equals(variableModel.get(i).getdfs_variable_name())) {
				return true;
			}
		return false;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public DFSDetailConfigResultModel getDetailConfigResultModel() {
		return detailConfigResultModel;
	}

	public DFSDetailConfigResultModel showDetailEditDialog(int DFSDefineTableDatandex, ObservableList<DFSDefineTableModel> DFSDefineTables,
			DFSDetailConfigResultModel dfsMethodModel) {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					MeerkatMainApp.class.getResource("view/DFSGenerator/crawler/DFSGeneratorTableDetailConfigEditView.fxml"));
			VBox page = (VBox) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Detail Config Editer");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorTableDetailConfigEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDetailConfigEdit(DFSDefineTables.get(DFSDefineTableDatandex), dfsMethodModel);

			dialogStage.showAndWait();

			return controller.getDetailConfigResultModel();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setDetailConfigEdit(DFSDefineTableModel DFSDefineTable, DFSDetailConfigResultModel dfsMethodModel) {

		DFSDataTagNameField.setText(DFSDefineTable.getData_tag_name());
		aliasNameField.setText(DFSDefineTable.getAlias_name());
		typeLevelField.setText(DFSDefineTable.getType() + " X " + DFSDefineTable.getLevel());
		tableFormatField.setText(DFSDefineTable.getTable_format());
		
		nextVariableModels = dfsMethodModel.getNextVariableModels();
		contextListVariableModels = dfsMethodModel.getContextListVariableModels();
		metaDataVariableModels = dfsMethodModel.getMetaDataVariableModels();
				

		DFS_NEXTATTRIBUTE_TableView.setItems(nextVariableModels);
		DFS_CONTEXTLIST_TableView.setItems(contextListVariableModels);
		DFS_METADATA_TableView.setItems(metaDataVariableModels);

//		DFS_NEXTATTRIBUTE_TableView.setColumnResizePolicy((param) -> true);
//		DFS_CONTEXTLIST_TableView.setColumnResizePolicy((param) -> true);
//		DFS_METADATA_TableView.setColumnResizePolicy((param) -> true);
	}

	@FXML
	private void handle_nextAttributeTable_click() {
		DFS_CONTEXTLIST_TableView.getSelectionModel().clearSelection();
		DFS_METADATA_TableView.getSelectionModel().clearSelection();
		currentTableView = "nextAttribute";
	}

	@FXML
	private void handle_contextListTable_click() {
		DFS_NEXTATTRIBUTE_TableView.getSelectionModel().clearSelection();
		DFS_METADATA_TableView.getSelectionModel().clearSelection();
		currentTableView = "contextList";
	}

	@FXML
	private void handle_metaDataTable_click() {
		DFS_NEXTATTRIBUTE_TableView.getSelectionModel().clearSelection();
		DFS_CONTEXTLIST_TableView.getSelectionModel().clearSelection();
		currentTableView = "metaData";
	}
}
