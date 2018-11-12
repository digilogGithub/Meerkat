package com.digilog.meerkat.view.DFSGenerator.semiMaster;

import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.SimpleTableModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineDatatagInitItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineInitModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.util.MessageDialog;
import com.digilog.meerkat.view.RootGeneralConfigViewController;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorSemiMasterDefineController {
	@FXML
	private TableView<DFSVariableItemModel> semi_define_context_TableView;
	@FXML
	private TableColumn<DFSVariableItemModel, Number> contextNumberColumn;
	// @FXML
	// private TableColumn<DFSVariableItemModel, Color> colorColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, Boolean> contextNotOptionalColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> contextNameColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> contextAliasColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> contextVariable_typeColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> contextVariable_groupColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> contextRoleColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> contextDescriptionColumn;

	@FXML
	private TableView<DFSVariableItemModel> semi_define_descriptor_TableView;
	@FXML
	private TableColumn<DFSVariableItemModel, Number> descriptorNumberColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, Boolean> descriptorNotOptionalColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> descriptorNameColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> descriptorAliasColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> descriptorVariable_typeColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> descriptorVariable_groupColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> descriptorRoleColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> descriptorDescriptionColumn;

	@FXML
	private TableView<DFSVariableItemModel> semi_define_attribute_TableView;
	@FXML
	private TableColumn<DFSVariableItemModel, Number> attributeNumberColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, Boolean> attributeNotOptionalColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> attributeNameColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> attributeAliasColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> attributeVariable_typeColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> attributeVariable_groupColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> attributeRoleColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> attributeDescriptionColumn;

	@FXML
	private TableView<SimpleTableModel> semi_define_type_TableView;
	@FXML
	private TableColumn<SimpleTableModel, String> typeNameColumn;
	@FXML
	private TableView<SimpleTableModel> semi_define_level_TableView;
	@FXML
	private TableColumn<SimpleTableModel, String> levelNameColumn;

	@FXML
	private TableView<DFSDefineDatatagInitItemModel> semi_define_list_TableView;
	@FXML
	private TableColumn<DFSDefineDatatagInitItemModel, Number> listNumberColumn;
	@FXML
	private TableColumn<DFSDefineDatatagInitItemModel, String> type_NameColumn;
	@FXML
	private TableColumn<DFSDefineDatatagInitItemModel, String> level_NameColumn;

	@FXML
	private Label typeLabel;
	@FXML
	private Label xLabel;
	@FXML
	private Label levelLabel;

	@FXML
	private Button UP_Button;
	@FXML
	private Button Down_Button;
	@FXML
	private Button Add_Button;
	@FXML
	private Button Delete_Button;
	@FXML
	private Button Define_DataTag_Button;
	@FXML
	private Button Edit_Button;
	@FXML
	private Button Delete_List_Button;
	@FXML
	private Button Load_Button;
	@FXML
	private Button Save_Button;
	@FXML
	private Button OK_Button;
	@FXML
	private Button Cancel_Button;

	static Stage dialogStage;
	private DFSGeneratorSemiMasterDataTagDefineController dfsgsdatatag;
	private DFSGeneratorSemiMasterAddAttributeVariableController addVariableData;
	private DFSDefineInitModel tempSemiMasterAllInitData;
	private ObservableList<DFSVariableItemModel> tempSemiMasterInitData;
	private ObservableList<DFSVariableItemModel> tempSemiContextInitData;
	private ObservableList<DFSVariableItemModel> tempSemiDescriptorInitData;
	private ObservableList<DFSVariableItemModel> tempSemiAttributeInitData;
	private ObservableList<DFSDefineDatatagInitItemModel> tempSemiDatatagListData;
	static boolean SEMI_UPDATE_CHECK;
	static boolean callCheck;
	int tempMasterNum;
	int contextNum;
	int descriptorNum;
	int attributeNum;

	private MessageDialog mDialog;
	private Alert messageLog;

	@FXML
	private void initialize() {
		dfsgsdatatag = new DFSGeneratorSemiMasterDataTagDefineController();
		addVariableData = new DFSGeneratorSemiMasterAddAttributeVariableController();
		mDialog = new MessageDialog();
		tempSemiMasterAllInitData = new DFSDefineInitModel();
		tempSemiMasterInitData = FXCollections.observableArrayList();
		tempSemiContextInitData = FXCollections.observableArrayList();
		tempSemiDescriptorInitData = FXCollections.observableArrayList();
		tempSemiAttributeInitData = FXCollections.observableArrayList();
		tempSemiDatatagListData = FXCollections.observableArrayList();

		SEMI_UPDATE_CHECK = false;
		callCheck = false;

		contextNumberColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Number>(
				semi_define_context_TableView.getItems().indexOf(cellData.getValue())));

		// contextAliasColumn.setCellFactory(colo)
		// colorColumn.setCellFactory(tablecell);
		// colorColumn.setCellValueFactory(new
		// PropertyValueFactory<>(Color.web("#CCCCCC")));
		// colorColumn.setCellFactory(ColorTableCell::new);
		contextNotOptionalColumn.setCellValueFactory(cellData -> cellData.getValue().notOptionalProperty());
		contextNotOptionalColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));

		contextNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		contextNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		contextAliasColumn.setCellValueFactory(cellData -> cellData.getValue().aliasProperty());
		contextAliasColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		contextVariable_typeColumn.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		contextVariable_typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		contextVariable_groupColumn.setCellValueFactory(cellData -> cellData.getValue().variable_groupProperty());
		contextVariable_groupColumn
				.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE));
		contextRoleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
		contextRoleColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.ROLE_TYPE));
		contextDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		contextDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		descriptorNumberColumn.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(
				semi_define_descriptor_TableView.getItems().indexOf(column.getValue())));

		descriptorNotOptionalColumn.setCellValueFactory(cellData -> cellData.getValue().notOptionalProperty());
		descriptorNotOptionalColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));

		descriptorNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		descriptorNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		descriptorAliasColumn.setCellValueFactory(cellData -> cellData.getValue().aliasProperty());
		descriptorAliasColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		descriptorVariable_typeColumn.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		descriptorVariable_typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		descriptorVariable_groupColumn.setCellValueFactory(cellData -> cellData.getValue().variable_groupProperty());
		descriptorVariable_groupColumn
				.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE));
		descriptorRoleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
		descriptorRoleColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.ROLE_TYPE));
		descriptorDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		descriptorDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		attributeNumberColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Number>(
				semi_define_attribute_TableView.getItems().indexOf(cellData.getValue())));
		attributeNotOptionalColumn.setCellValueFactory(cellData -> cellData.getValue().notOptionalProperty());
		attributeNotOptionalColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));

		attributeNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		attributeNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		attributeAliasColumn.setCellValueFactory(cellData -> cellData.getValue().aliasProperty());
		attributeAliasColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		attributeVariable_typeColumn.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		attributeVariable_typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		attributeVariable_groupColumn.setCellValueFactory(cellData -> cellData.getValue().variable_groupProperty());
		attributeVariable_groupColumn
				.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE));
		attributeRoleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
		attributeRoleColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.ROLE_TYPE));
		attributeDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		attributeDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		typeNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		typeNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		levelNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		levelNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		listNumberColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Number>(
				semi_define_list_TableView.getItems().indexOf(cellData.getValue())));
		type_NameColumn.setCellValueFactory(cellData -> cellData.getValue().typeNameProperty());
		type_NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		level_NameColumn.setCellValueFactory(cellData -> cellData.getValue().levelNameProperty());
		level_NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	public void setDialogStage(Stage dialogStage) {
		DFSGeneratorSemiMasterDefineController.dialogStage = dialogStage;
	}

	@FXML
	private void handle_UP() {
		int selectedIdx = semi_define_attribute_TableView.getSelectionModel().getSelectedIndex();
		if (selectedIdx > 0) {
			RootGeneralConfigViewController.sortList.clear();
			DFSVariableItemModel currentModel = semi_define_attribute_TableView.getSelectionModel().getSelectedItem();
			tempSemiMasterAllInitData.getSemiMasterItemInitData().set(selectedIdx + 2,
					tempSemiMasterAllInitData.getSemiMasterItemInitData().get(selectedIdx + 1));
			tempSemiMasterAllInitData.getSemiMasterItemInitData().set(selectedIdx + 1, currentModel);
			tempSemiAttributeInitData.set(selectedIdx, tempSemiAttributeInitData.get(selectedIdx - 1));
			tempSemiAttributeInitData.set(selectedIdx - 1, currentModel);
			RootGeneralConfigViewController.sortList.clear();
			for (DFSVariableItemModel current : tempSemiAttributeInitData)
				RootGeneralConfigViewController.sortList.add(current.getName());
			semi_define_attribute_TableView.getSelectionModel().select(selectedIdx - 1);
		}
	}

	@FXML
	private void handle_Down() {
		int selectedIdx = semi_define_attribute_TableView.getSelectionModel().getSelectedIndex();
		if (selectedIdx >= 0 && selectedIdx < semi_define_attribute_TableView.getItems().size() - 1) {
			DFSVariableItemModel currentModel = semi_define_attribute_TableView.getSelectionModel().getSelectedItem();
			tempSemiMasterAllInitData.getSemiMasterItemInitData().set(selectedIdx + 2,
					tempSemiMasterAllInitData.getSemiMasterItemInitData().get(selectedIdx + 3));
			tempSemiMasterAllInitData.getSemiMasterItemInitData().set(selectedIdx + 3, currentModel);
			tempSemiAttributeInitData.set(selectedIdx, tempSemiAttributeInitData.get(selectedIdx + 1));
			tempSemiAttributeInitData.set(selectedIdx + 1, currentModel);
			RootGeneralConfigViewController.sortList.clear();
			for (DFSVariableItemModel current : tempSemiAttributeInitData)
				RootGeneralConfigViewController.sortList.add(current.getName());
			semi_define_attribute_TableView.getSelectionModel().select(selectedIdx + 1);
		}
	}

	@FXML
	private void handle_Add() {
		addSemiMasterInitData();
	}

	@FXML
	private void handle_Delete() {
		deleteSemiMasterInitData();
	}

	@FXML
	private void handle_Define_DataTag() {
		if (typeLabel.getText() != "" && levelLabel.getText() != "") {
			boolean existList = false;
			for (int i = 0; i < tempSemiMasterAllInitData.getSemiDatatagListInitData().size(); i++) {
				String typeName = tempSemiMasterAllInitData.getSemiDatatagListInitData().get(i).getTypeName();
				String levelName = tempSemiMasterAllInitData.getSemiDatatagListInitData().get(i).getLevelName();
				if ((typeLabel.getText() + levelLabel.getText()).equals(typeName + levelName)) {
					existList = true;
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DEFINE ADD ERROR",
							typeLabel.getText() + "  X  " + levelLabel.getText() + " : EXISTS IN DATATAG DEFIND LIST.",
							"There is Selected Datatag in Datatag Define List.\nIf you want to edit it, push OK");
					Optional<ButtonType> result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						tempSemiMasterAllInitData = dfsgsdatatag.showDefineSemiMasterDatatagAddDialog(
								tempSemiMasterAllInitData, typeLabel.getText(), levelLabel.getText(), false);
						break;
					}
				}
			}

			if (existList == false) {
				tempSemiMasterAllInitData = dfsgsdatatag.showDefineSemiMasterDatatagAddDialog(tempSemiMasterAllInitData,
						typeLabel.getText(), levelLabel.getText(), true);
				semi_define_list_TableView.setItems(tempSemiMasterAllInitData.getSemiDatatagListInitData());
			}
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "DEFINE ADD ERROR", "No seleted items",
					"Type & Level should be selected");
			messageLog.showAndWait();
		}
	}

	@FXML
	private void handle_Edit() {
		int selected = semi_define_list_TableView.getSelectionModel().getSelectedIndex();
		if (selected >= 0) {
			callCheck = false;
			String typeName = semi_define_list_TableView.getItems().get(selected).getTypeName();
			String levelName = semi_define_list_TableView.getItems().get(selected).getLevelName();
			tempSemiMasterAllInitData = dfsgsdatatag.showDefineSemiMasterDatatagAddDialog(tempSemiMasterAllInitData,
					typeName, levelName, false);
			semi_define_list_TableView.setItems(tempSemiMasterAllInitData.getSemiDatatagListInitData());
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "EDIT MODE ERROR",
					"ERROR : There is no selected DataTag Define List.", "DataTag List should be selected ;)");
			messageLog.showAndWait();
		}
	}

	@FXML
	private void handle_Delete_List() {
		deleteSemiMasterListData();
	}

	public void deleteSemiMasterListData() {
		int selectedIdx = semi_define_list_TableView.getSelectionModel().getSelectedIndex();
		if (selectedIdx >= 0) {
			String typeName = semi_define_list_TableView.getSelectionModel().getSelectedItem().getTypeName();
			String levelName = semi_define_list_TableView.getSelectionModel().getSelectedItem().getLevelName();
			tempSemiDatatagListData = tempSemiMasterAllInitData.getSemiDatatagListInitData();
			for (int i = 0; i < tempSemiMasterAllInitData.getSemiDatatagListInitData().size(); i++) {
				if (typeName.equals(tempSemiDatatagListData.get(i).getTypeName())
						&& levelName.equals(tempSemiDatatagListData.get(i).getLevelName())) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DELETE ATTRIBUTE VARIABLE DATA",
							"Delete " + typeName + " X " + levelName + " in DataTag Define List", "Are you sure?");
					Optional<ButtonType> result = messageLog.showAndWait();
					if (result.get().getButtonData() == ButtonType.OK.getButtonData()) {
						tempSemiDatatagListData.remove(i);
						semi_define_list_TableView.setItems(tempSemiDatatagListData);
					}
					break;
				}
			}
		}
	}

	@FXML
	private void handle_Load() {
		// TODO Auto-generated catch block
	}

	@FXML
	private void handle_Save() {
		// TODO Auto-generated catch block
	}

	@FXML
	private void handle_OK() {
		SEMI_UPDATE_CHECK = true;
		dialogStage.close();
	}

	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}

	@FXML
	private void handle_contextTable_click() {
		semi_define_descriptor_TableView.getSelectionModel().clearSelection();
		semi_define_attribute_TableView.getSelectionModel().clearSelection();
	}

	@FXML
	private void handle_descriptorTable_click() {
		semi_define_context_TableView.getSelectionModel().clearSelection();
		semi_define_attribute_TableView.getSelectionModel().clearSelection();
	}

	@FXML
	private void handle_attributeTable_click() {
		semi_define_descriptor_TableView.getSelectionModel().clearSelection();
		semi_define_context_TableView.getSelectionModel().clearSelection();
	}

	@FXML
	private void handle_type_click() {

		typeLabel.setText(semi_define_type_TableView.getSelectionModel().getSelectedItem().getName());
		if (semi_define_type_TableView.getSelectionModel().getSelectedIndex() >= 0
				&& semi_define_level_TableView.getSelectionModel().getSelectedIndex() >= 0)
			xLabel.setText("X");
	}

	@FXML
	private void handle_level_click() {
		levelLabel.setText(semi_define_level_TableView.getSelectionModel().getSelectedItem().getName());
		if (semi_define_type_TableView.getSelectionModel().getSelectedIndex() >= 0
				&& semi_define_level_TableView.getSelectionModel().getSelectedIndex() >= 0)
			xLabel.setText("X");
	}

	public ObservableList<DFSVariableItemModel> getDFSDefineItemModelData() {
		return tempSemiMasterInitData;
	}

	public DFSDefineInitModel getDFSDefineInitModelData() {
		return tempSemiMasterAllInitData;
	}

	public void setDFSDefineInitModelData() {
		tempSemiMasterAllInitData.setSemiDatatagListInitData(tempSemiDatatagListData);
		tempSemiMasterAllInitData.setSemiMasterItemInitData(tempSemiMasterInitData);
	}

	public DFSDefineInitModel showDefineSemiMasterDialog(DFSDefineInitModel SemiMasterAllInitData,
			ObservableList<SimpleTableModel> SemiMasterTypeInitData,
			ObservableList<SimpleTableModel> SemiMasterLevelInitData) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/semiMaster/DFSGeneratorSemiMasterDefineView.fxml"));
			SplitPane page = (SplitPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("SEMIMaster Config Define");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorSemiMasterDefineController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSemiMasterAttributeEdit(SemiMasterAllInitData.getSemiMasterItemInitData());
			controller.setSemiMasterTypeLevelInitList(SemiMasterTypeInitData, SemiMasterLevelInitData);
			controller.setSemiMasterDatatagInitListData(SemiMasterAllInitData.getSemiDatatagListInitData());
			controller.setDFSDefineInitModelData();

			dialogStage.showAndWait();

			if (SEMI_UPDATE_CHECK == true) {
				return controller.getDFSDefineInitModelData();
			} else
				return SemiMasterAllInitData;

		} catch (IOException e) {
			e.printStackTrace();
			return SemiMasterAllInitData;
		}
	}

	public void setSemiMasterAttributeEdit(ObservableList<DFSVariableItemModel> SemiMasterInitData) {

		tempMasterNum = 0;
		contextNum = 0;
		descriptorNum = 0;
		attributeNum = 0;
		Iterator<DFSVariableItemModel> itr = SemiMasterInitData.iterator();
		while (itr.hasNext()) {
			DFSVariableItemModel itrModel = (DFSVariableItemModel) itr.next();
			DFSVariableItemModel tempModel = new DFSVariableItemModel(null, itrModel.getNotOptional(),
					itrModel.getName(), itrModel.getColumn_name(), itrModel.getTable_Name(), itrModel.getAlias(),
					itrModel.getVariable_type(), itrModel.getVariable_group(), itrModel.getRole(), itrModel.getPivot(),
					itrModel.getDescription(), itrModel.getSummarization(), itrModel.getGroupby(),
					itrModel.getExclude_condition(), itrModel.getTotime_javaformat(), itrModel.getTotime(),
					itrModel.getTimetochar(), itrModel.getNumbertochar());
			createSemiMasterInitDataList(tempModel);
			tempSemiMasterInitData.add(tempModel);
		}

		semi_define_context_TableView.setItems(tempSemiContextInitData);
		semi_define_descriptor_TableView.setItems(tempSemiDescriptorInitData);
		semi_define_attribute_TableView.setItems(tempSemiAttributeInitData);
	}

	public void setSemiMasterTypeLevelInitList(ObservableList<SimpleTableModel> SemiMasterTypeInitData,
			ObservableList<SimpleTableModel> SemiMasterLevelInitData) {

		semi_define_type_TableView.setItems(SemiMasterTypeInitData);
		semi_define_level_TableView.setItems(SemiMasterLevelInitData);
	}

	public void createSemiMasterInitDataList(DFSVariableItemModel tempModel) {

		String groupName = tempModel.getVariable_group();
		String roleName = tempModel.getRole();

		switch (groupName) {
		case "CONTEXT":
			tempSemiContextInitData.add(tempModel);
			break;

		case "ATTRIBUTE":
			tempSemiAttributeInitData.add(tempModel);
			if (roleName.equals("DESCRIPTOR")) {
				tempSemiDescriptorInitData.add(tempModel);
			}
			break;

		default:
			break;
		}
	}

	public void addSemiMasterInitData() {
		DFSVariableItemModel temp = addVariableData.showAddVariableDialog(tempSemiMasterInitData);
		if (temp != null) {
			createSemiMasterInitDataList(temp);
			tempSemiMasterInitData.add(temp);
			tempSemiMasterAllInitData.setSemiMasterItemInitData(tempSemiMasterInitData);
		}
	}

	public void deleteSemiMasterInitData() {

		if (semi_define_context_TableView.getSelectionModel().getSelectedIndex() >= 0) {
			String selectedName = semi_define_context_TableView.getSelectionModel().getSelectedItem().getName();
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DELETE ATTRIBUTE VARIABLE DATA",
					"Delete attribute data in Context List",
					"If selected variable is linked, linked variables will be deleted,too.\nAre you sure?");
			Optional<ButtonType> result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData())
				deleteData(selectedName);
		}

		if (semi_define_descriptor_TableView.getSelectionModel().getSelectedIndex() >= 0) {
			String selectedName = semi_define_descriptor_TableView.getSelectionModel().getSelectedItem().getName();
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DELETE ATTRIBUTE VARIABLE DATA",
					"Delete attribute data in Descriptor List",
					"If selected variable is linked, linked variables will be deleted,too.\nAre you sure?");
			Optional<ButtonType> result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData())
				deleteData(selectedName);
		}

		if (semi_define_attribute_TableView.getSelectionModel().getSelectedIndex() >= 0) {
			String selectedName = semi_define_attribute_TableView.getSelectionModel().getSelectedItem().getName();
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_CONFIRM, "DELETE ATTRIBUTE VARIABLE DATA",
					"Delete attribute data in Attribute List",
					"If selected variable is linked, linked variables will be deleted,too.\nAre you sure?");
			Optional<ButtonType> result = messageLog.showAndWait();
			if (result.get().getButtonData() == ButtonType.OK.getButtonData())
				deleteData(selectedName);
		}
	}

	public void deleteData(String selectedName) {

		for (int i = 0; i < tempSemiContextInitData.size(); i++) {
			String dataName = tempSemiContextInitData.get(i).getName();
			if (selectedName.equals(dataName))
				tempSemiContextInitData.remove(i);
		}

		for (int i = 0; i < tempSemiDescriptorInitData.size(); i++) {
			String dataName = tempSemiDescriptorInitData.get(i).getName();
			if (selectedName.equals(dataName))
				tempSemiDescriptorInitData.remove(i);
		}

		for (int i = 0; i < tempSemiAttributeInitData.size(); i++) {
			String dataName = tempSemiAttributeInitData.get(i).getName();
			if (selectedName.equals(dataName))
				tempSemiAttributeInitData.remove(i);
		}

		for (int i = 0; i < tempSemiMasterInitData.size(); i++) {
			String dataName = tempSemiMasterInitData.get(i).getName();
			if (selectedName.equals(dataName))
				tempSemiMasterInitData.remove(i);
		}
	}

	public void setSemiMasterDatatagInitListData(ObservableList<DFSDefineDatatagInitItemModel> SemiDatatagListData) {

		Iterator<DFSDefineDatatagInitItemModel> itr = SemiDatatagListData.iterator();

		while (itr.hasNext()) {
			DFSDefineDatatagInitItemModel temp = itr.next();

			ObservableList<DFSVariableItemModel> tempData = FXCollections.observableArrayList();
			String typeName = temp.getTypeName();
			String levelName = temp.getLevelName();
			for (int i = 0; i < temp.getDFSSemiVariableModels().size(); i++) {
				try {
					DFSVariableItemModel data = temp.getDFSSemiVariableModels().get(i).clone();
					tempData.add(data);
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
			tempSemiDatatagListData.add(new DFSDefineDatatagInitItemModel(typeName, levelName, tempData));
		}
		semi_define_list_TableView.setItems(SemiDatatagListData);
	}
}
