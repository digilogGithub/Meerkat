package com.digilog.meerkat.view.DFSGenerator.semiMaster;

import java.io.IOException;
import java.util.Iterator;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineDatatagInitItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineInitModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.util.MessageDialog;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorSemiMasterDataTagDefineController {

	@FXML
	private TableView<DFSVariableItemModel> semi_define_datatag_TableView;
	@FXML
	private TableColumn<DFSVariableItemModel, Number> datatagNumberColumn;

	@FXML
	private TableColumn<DFSVariableItemModel, Boolean> datatagNotOptionalColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> datatagNameColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> datatagAliasColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> datatagVariable_typeColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> datatagVariable_groupColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> datatagRoleColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> datatagPivotColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> datatagDescriptionColumn;

	@FXML
	private TableView<DFSVariableItemModel> semi_define_list_TableView;
	@FXML
	private TableColumn<DFSVariableItemModel, Number> listNumberColumn;
	@FXML
	private TableColumn<DFSVariableItemModel, String> listNameColumn;

	@FXML
	private Label type_level_Label;

	@FXML
	private Button OK_Button;
	@FXML
	private Button Cancel_Button;

	@FXML
	private Button add_Button;
	@FXML
	private Button sub_Button;

	private Stage dialogStage;
	private DFSDefineInitModel tempSemiMasterAllInitData;
	private ObservableList<DFSVariableItemModel> tempSemiMasterInitListData;
	private ObservableList<DFSVariableItemModel> tempSemiMasterTagListData;

	static boolean SEMI_UPDATE_CHECK;
	int datatagIdx;

	// Data tag name dup check dialogBox
	private MessageDialog mDialog;
	private Alert messageLog;

	@FXML
	private void initialize() {
		mDialog = new MessageDialog();
		tempSemiMasterAllInitData = new DFSDefineInitModel();
		tempSemiMasterInitListData = FXCollections.observableArrayList();
		tempSemiMasterTagListData = FXCollections.observableArrayList();
		SEMI_UPDATE_CHECK = false;
		// datatagIdx = -1;

		datatagNumberColumn.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(semi_define_datatag_TableView.getItems().indexOf(column.getValue())));
		datatagNotOptionalColumn.setCellValueFactory(cellData -> cellData.getValue().notOptionalProperty());
		datatagNotOptionalColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null, false));

		datatagNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		datatagNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		datatagAliasColumn.setCellValueFactory(cellData -> cellData.getValue().aliasProperty());
		datatagAliasColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		datatagVariable_typeColumn.setCellValueFactory(cellData -> cellData.getValue().variable_typeProperty());
		datatagVariable_typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.VARIABLE_TYPE));
		datatagVariable_groupColumn.setCellValueFactory(cellData -> cellData.getValue().variable_groupProperty());
		datatagVariable_groupColumn
				.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE));
		datatagRoleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
		datatagRoleColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.ROLE_TYPE));
		datatagPivotColumn.setCellValueFactory(cellData -> cellData.getValue().pivotProperty());
		datatagPivotColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DefineAtrribute.PIVOT_TYPE));
		datatagDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		datatagDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		listNumberColumn.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(semi_define_list_TableView.getItems().indexOf(column.getValue())));
		listNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		listNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void handle_OK() {
		if (semi_define_datatag_TableView.getItems().size() > 0) {
			SEMI_UPDATE_CHECK = true;
			dialogStage.close();
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_WARNING, "DEFINE DATATAG ERROR",
					"ERROR : Add DataTag Define Variables.", "There should be at least one variable in DataTag List");
			messageLog.showAndWait();
		}
	}

	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}


	public DFSDefineInitModel showDefineSemiMasterDatatagAddDialog(DFSDefineInitModel SemiMasterAllInitData,
			String SemiMasterType, String SemiMasterLevel, boolean addMode) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					MeerkatMainApp.class.getResource("view/DFSGenerator/semiMaster/DFSGeneratorSemiMasterDataTagDefineView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("SEMIMaster Config Define");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(DFSGeneratorSemiMasterDefineController.dialogStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorSemiMasterDataTagDefineController controller = loader.getController();

			controller.setDialogStage(dialogStage);
			controller.setDatatagTitle(SemiMasterType, SemiMasterLevel);
			tempSemiMasterAllInitData = controller.setDataList(SemiMasterAllInitData, SemiMasterType, SemiMasterLevel,addMode);

			dialogStage.showAndWait();

			if (SEMI_UPDATE_CHECK == true) {
				tempSemiMasterAllInitData.setSemiMasterItemInitData(
						FXCollections.observableArrayList(SemiMasterAllInitData.getSemiMasterItemInitData()));
				return tempSemiMasterAllInitData;
			} else
				return SemiMasterAllInitData;

		} catch (IOException e) {
			e.printStackTrace();
			return SemiMasterAllInitData;
		}
	}

	public DFSDefineInitModel setDataList(DFSDefineInitModel SemiMasterAllInitData, String SemiMasterType,
			String SemiMasterLevel, boolean addMode) {
		tempSemiMasterAllInitData.setSemiMasterItemInitData(
				FXCollections.observableArrayList(SemiMasterAllInitData.getSemiMasterItemInitData()));
		tempSemiMasterAllInitData.setSemiDatatagListInitData(
				setSemiMasterDatatagInitListData(SemiMasterAllInitData.getSemiDatatagListInitData()));
		tempSemiMasterInitListData = tempSemiMasterAllInitData.getSemiMasterItemInitData();
		if (addMode == false) {
			for (int i = 0; i < tempSemiMasterAllInitData.getSemiDatatagListInitData().size(); i++) {
				String typeName = tempSemiMasterAllInitData.getSemiDatatagListInitData().get(i).getTypeName();
				String levelName = tempSemiMasterAllInitData.getSemiDatatagListInitData().get(i).getLevelName();
				if ((SemiMasterType + SemiMasterLevel).equals(typeName + levelName)) {
					tempSemiMasterTagListData = tempSemiMasterAllInitData.getSemiDatatagListInitData().get(i)
							.getDFSSemiVariableModels();
					for (int j = 0; j < tempSemiMasterTagListData.size(); j++) {
						String tempName = tempSemiMasterTagListData.get(j).getName();
						for (int k = 0; k < tempSemiMasterInitListData.size(); k++) {
							if (tempName.equals(tempSemiMasterInitListData.get(k).getName()))
								tempSemiMasterInitListData.remove(k);
						}
					}
				}
			}
		} else {
			DFSDefineDatatagInitItemModel tempAddDatatagList = new DFSDefineDatatagInitItemModel(SemiMasterType,
					SemiMasterLevel, tempSemiMasterTagListData);
			tempSemiMasterAllInitData.getSemiDatatagListInitData().add(tempAddDatatagList);
		}
		semi_define_list_TableView.setItems(tempSemiMasterInitListData);
		semi_define_datatag_TableView.setItems(tempSemiMasterTagListData);
		return tempSemiMasterAllInitData;
	}

	public void setDatatagTitle(String type, String level) {
		type_level_Label.setText(type + "   X   " + level);
	}

	public ObservableList<DFSDefineDatatagInitItemModel> setSemiMasterDatatagInitListData(
			ObservableList<DFSDefineDatatagInitItemModel> SemiDatatagListData) {

		ObservableList<DFSDefineDatatagInitItemModel> clone_tempSemiMasterInitListData = FXCollections
				.observableArrayList();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			clone_tempSemiMasterInitListData.add(new DFSDefineDatatagInitItemModel(typeName, levelName, tempData));
		}
		return clone_tempSemiMasterInitListData;
	}

	@FXML
	public void handleAddDefineButton() {
		int selectedIndex = semi_define_list_TableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			DFSVariableItemModel temp = new DFSVariableItemModel(null,
					tempSemiMasterInitListData.get(selectedIndex).getNotOptional(),
					tempSemiMasterInitListData.get(selectedIndex).getName(),
					tempSemiMasterInitListData.get(selectedIndex).getColumn_name(),
					tempSemiMasterInitListData.get(selectedIndex).getTable_Name(),
					tempSemiMasterInitListData.get(selectedIndex).getAlias(),
					tempSemiMasterInitListData.get(selectedIndex).getVariable_type(),
					tempSemiMasterInitListData.get(selectedIndex).getVariable_group(),
					tempSemiMasterInitListData.get(selectedIndex).getRole(),
					tempSemiMasterInitListData.get(selectedIndex).getPivot(),
					tempSemiMasterInitListData.get(selectedIndex).getDescription(),
					tempSemiMasterInitListData.get(selectedIndex).getSummarization(),
					tempSemiMasterInitListData.get(selectedIndex).getGroupby(),
					tempSemiMasterInitListData.get(selectedIndex).getExclude_condition(),
					tempSemiMasterInitListData.get(selectedIndex).getTotime_javaformat(),
					tempSemiMasterInitListData.get(selectedIndex).getTotime(),
					tempSemiMasterInitListData.get(selectedIndex).getTimetochar(),
					tempSemiMasterInitListData.get(selectedIndex).getNumbertochar());
			tempSemiMasterTagListData.add(temp);
			tempSemiMasterInitListData.remove(selectedIndex);
		}
	}

	@FXML
	public void handleRemoveDefineButton() {
		int selectedIndex = semi_define_datatag_TableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			try {
				tempSemiMasterInitListData.add(tempSemiMasterTagListData.get(selectedIndex).clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempSemiMasterTagListData.remove(selectedIndex);
		}
	}
}
