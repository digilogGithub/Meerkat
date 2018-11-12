package com.digilog.meerkat.view.DFSGenerator;

import java.io.IOException;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDetailAddVariableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSTempDetailVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.util.MessageDialog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorAddVariableController {

	@FXML
	private TextField DFSDataTagNameField;
	@FXML
	private TextField VariableNameField;
	@FXML
	private TextField ColumnNameField;
	@FXML
	private TextField tableNameField;
	@FXML
	private TextField timeJAVAFormatField;
	@FXML
	private TextField totimeField;
	@FXML
	private TextField numbertocharField;
	@FXML
	private TextField timetocharField;
	@FXML
	private TextField summarizationField;
	@FXML
	private TextField exclude_conditionField;

	@FXML
	private ComboBox<String> variable_type;
	@FXML
	private ComboBox<String> vairable_group;
	@FXML
	private ComboBox<String> role;
	@FXML
	private ComboBox<String> pivot;
	@FXML
	private ComboBox<String> group_by;

	@FXML
	private CheckBox notOptional;
	@FXML
	private CheckBox all;
	@FXML
	private CheckBox nextattribute;
	@FXML
	private CheckBox contextlist;
	@FXML
	private CheckBox metadata;

	@FXML
	private Button OK_Button;
	@FXML
	private Button Cancel_Button;

	private Stage dialogStage;
	private DFSDetailAddVariableModel returnAddVariableModel;
	private DFSTempDetailVariableModel tempDetailVariables;

	// Data tag name dup check dialogBox
	private MessageDialog mDialog;
	private Alert messageLog;

	@FXML
	private void initialize() {
		mDialog = new MessageDialog();
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public DFSGeneratorAddVariableController() {
		returnAddVariableModel = new DFSDetailAddVariableModel();
		tempDetailVariables = new DFSTempDetailVariableModel();
	}

	public void setAddDefineVariable(String DFSDataTagName, String currentTableView) {
		DFSDataTagNameField.setText(DFSDataTagName);
		VariableNameField.setText(null);
		ColumnNameField.setText(null);
		tableNameField.setText(tempDetailVariables.getMetaDataVariables().get(0).getTable_name());
		timeJAVAFormatField.setText(tempDetailVariables.getMetaDataVariables().get(0).getTotime_javaformat());
		timetocharField.setText(tempDetailVariables.getMetaDataVariables().get(0).getTimetochar());
		totimeField.setText(tempDetailVariables.getMetaDataVariables().get(0).getTotime());
		numbertocharField.setText(tempDetailVariables.getMetaDataVariables().get(0).getNumbertochar());
		summarizationField.setText(null);
		exclude_conditionField.setText(null);

		variable_type.getItems().setAll(DefineAtrribute.VARIABLE_TYPE);
		variable_type.getSelectionModel().select(0);
		vairable_group.getItems().setAll(DefineAtrribute.VARIABLE_GROUP_TYPE);
		vairable_group.getSelectionModel().select(1);
		role.getItems().setAll(DefineAtrribute.ROLE_TYPE);
		role.getSelectionModel().select(1);
		pivot.getItems().setAll(DefineAtrribute.PIVOT_TYPE);
		pivot.getSelectionModel().select(1);
		group_by.getItems().setAll(DefineAtrribute.GROUPBY_TYPE);
		group_by.getSelectionModel().select(1);

		all.setSelected(false);
		switch (currentTableView) {
		case "nextAttribute":
			nextattribute.setSelected(true);
			break;

		case "contextList":
			contextlist.setSelected(true);
			break;

		case "metaData":
			metadata.setSelected(true);
			break;

		default:
			nextattribute.setSelected(false);
			contextlist.setSelected(false);
			metadata.setSelected(false);
			break;
		}
	}

	@FXML
	private void handle_Ok() {

		boolean notOpt = notOptional.isSelected();
		// String DFSDataTagName = DFSDataTagNameField.getText();
		String VariableName = VariableNameField.getText();
		String ColumnName = ColumnNameField.getText();
		String tableName = tableNameField.getText();
		String timeJAVAFormat = timeJAVAFormatField.getText();
		String timetochar = timetocharField.getText();
		String totime = totimeField.getText();
		String numbertochar = numbertocharField.getText();
		String summarization = summarizationField.getText();
		String exclude_condition = exclude_conditionField.getText();

		String vt = variable_type.getSelectionModel().getSelectedItem().toString();
		String vg = vairable_group.getSelectionModel().getSelectedItem().toString();
		String rl = role.getSelectionModel().getSelectedItem().toString();
		String pi = pivot.getSelectionModel().getSelectedItem().toString();
		String gb = group_by.getSelectionModel().getSelectedItem().toString();

		String checkReturn = "true";
		
		if(VariableName == null) {
			checkReturn = "name";
		} else if (ColumnName == null) {
			checkReturn = "ColumnName";
		} else {
			checkReturn = checkName(VariableName, ColumnName);
		}
		
		if (checkReturn.equals("true")) {

			DFSVariableModel dfsVariable = new DFSVariableModel(notOpt, VariableName, ColumnName, tableName, vt, vg, rl,
					pi, summarization, gb, exclude_condition, timeJAVAFormat, totime, timetochar, numbertochar);

			returnAddVariableModel.setDfsVariable(dfsVariable);
			returnAddVariableModel.setAll(all.isSelected());
			returnAddVariableModel.setNextattribute(nextattribute.isSelected());
			returnAddVariableModel.setContextlist(contextlist.isSelected());
			returnAddVariableModel.setMetadata(metadata.isSelected());

			dialogStage.close();
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR", "ERROR : "+checkReturn,
					"Check name, column name");
			messageLog.showAndWait();
		}

	}

	public String checkName(String name, String columnName) {
		String exists = "true";

		if (all.isSelected()) {
			for (int i = 0; i < tempDetailVariables.getMetaDataVariables().size(); i++)
				if (name.equals(tempDetailVariables.getMetaDataVariables().get(i).getdfs_variable_name())
						|| columnName.equals(tempDetailVariables.getMetaDataVariables().get(i).getColumn_name())) {
					exists = "NEXTATTRIBUTE";
					break;
				}

			for (int i = 0; i < tempDetailVariables.getContextListVariable().size(); i++)
				if (name.equals(tempDetailVariables.getContextListVariable().get(i).getdfs_variable_name())
						|| columnName.equals(tempDetailVariables.getContextListVariable().get(i).getColumn_name())) {
					exists = "CONTEXTLIST";
					break;
				}

			for (int i = 0; i < tempDetailVariables.getMetaDataVariables().size(); i++)
				if (name.equals(tempDetailVariables.getMetaDataVariables().get(i).getdfs_variable_name())
						|| columnName.equals(tempDetailVariables.getMetaDataVariables().get(i).getColumn_name())) {
					exists = "METADATA";
					break;
				}
		}

		if (nextattribute.isSelected()) {
			for (int i = 0; i < tempDetailVariables.getNextAttributeVariables().size(); i++)
				if (name.equals(tempDetailVariables.getMetaDataVariables().get(i).getdfs_variable_name())
						|| columnName.equals(tempDetailVariables.getMetaDataVariables().get(i).getColumn_name())) {
					exists = "NEXTATTRIBUTE";
					break;
				}
		}

		if (contextlist.isSelected()) {
			for (int i = 0; i < tempDetailVariables.getContextListVariable().size(); i++)
				if (name.equals(tempDetailVariables.getContextListVariable().get(i).getdfs_variable_name())
						|| columnName.equals(tempDetailVariables.getContextListVariable().get(i).getColumn_name())) {
					exists = "CONTEXTLIST";
					break;
				}
		}

		if (metadata.isSelected()) {
			for (int i = 0; i < tempDetailVariables.getMetaDataVariables().size(); i++)
				if (name.equals(tempDetailVariables.getMetaDataVariables().get(i).getdfs_variable_name())
						|| columnName.equals(tempDetailVariables.getMetaDataVariables().get(i).getColumn_name())) {
					exists = "METADATA";
					break;
				}
		}

		return exists;
	}

	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}

	public DFSDetailAddVariableModel getAddVariableModel() {
		return returnAddVariableModel;
	}

	@FXML
	private void handle_check_all() {
		if (all.isSelected()) {
			nextattribute.setSelected(false);
			contextlist.setSelected(false);
			metadata.setSelected(false);
		}
	}

	@FXML
	private void handle_check_nextAttribute() {
		if (nextattribute.isSelected()) {
			all.setSelected(false);
		}
	}

	@FXML
	private void handle_check_contextList() {
		if (contextlist.isSelected()) {
			all.setSelected(false);
		}
	}

	@FXML
	private void handle_check_metaData() {
		if (metadata.isSelected()) {
			all.setSelected(false);
		}
	}

	public void setDetailVariables(DFSTempDetailVariableModel tempDetailVariables) {
		this.tempDetailVariables = tempDetailVariables;
	}

	public DFSDetailAddVariableModel showAddVariableDialog(String DFSDataTagName, String currentTableView,
			DFSTempDetailVariableModel tempDetailVariables) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/DFSGeneratorAddVariableView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Define Add Variable");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorAddVariableController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDetailVariables(tempDetailVariables);
			controller.setAddDefineVariable(DFSDataTagName, currentTableView);


			dialogStage.showAndWait();
			return controller.getAddVariableModel();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
