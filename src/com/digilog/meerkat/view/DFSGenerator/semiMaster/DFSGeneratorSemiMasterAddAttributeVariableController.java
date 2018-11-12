package com.digilog.meerkat.view.DFSGenerator.semiMaster;

import java.io.IOException;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.util.MessageDialog;

import javafx.collections.ObservableList;
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

public class DFSGeneratorSemiMasterAddAttributeVariableController {
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField aliasField;
	@FXML
	private ComboBox<String> variable_type;
	@FXML
	private ComboBox<String> vairable_group;
	@FXML
	private ComboBox<String> role;
	@FXML
	private ComboBox<String> pivot;
	@FXML
	private TextField descriptionField;
	@FXML
	private CheckBox notOptionalCheckBox;


	@FXML
	private Button OK_Button;
	@FXML
	private Button Cancel_Button;

	private Stage dialogStage;
	private ObservableList<DFSVariableItemModel> tempSemiMasterInitData;
	private DFSVariableItemModel returnAddVariableModel;

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

//	public DFSGeneratorAddVariableController() {
//		returnAddVariableModel = new DFSVariableItemModel();
//	}

	
	public void setAddDefineVariable(ObservableList<DFSVariableItemModel> tempSemiMasterInitData) {
		this.tempSemiMasterInitData=tempSemiMasterInitData;
		nameField.setText(null);
		aliasField.setText(null);
		variable_type.getItems().setAll(DefineAtrribute.VARIABLE_TYPE);
		variable_type.getSelectionModel().select(0);
		vairable_group.getItems().setAll(DefineAtrribute.SEMI_VARIABLE_GROUP_TYPE);
		vairable_group.getSelectionModel().select(1);
		role.getItems().setAll(DefineAtrribute.ROLE_TYPE);
		role.getSelectionModel().select(2);
		pivot.getItems().setAll(DefineAtrribute.PIVOT_TYPE);
		pivot.getSelectionModel().select(0);
		descriptionField.setText(null);
		notOptionalCheckBox.setSelected(false);
	}

	@FXML
	private void handle_Ok() {

		boolean exist = false;
		String checkName = null;
//		String checkAlias = null;
		String name = nameField.getText();
		String alias = aliasField.getText();
		String vt = variable_type.getSelectionModel().getSelectedItem().toString();
		String vg = vairable_group.getSelectionModel().getSelectedItem().toString();
		String rl = role.getSelectionModel().getSelectedItem().toString();
		String pv = pivot.getSelectionModel().getSelectedItem().toString();
		String description = descriptionField.getText();
		
		if(name != null && !name.equals("") && alias != null && !alias.equals("")) {
			for(DFSVariableItemModel temp : tempSemiMasterInitData) {
				if(name.equals(temp.getName())) {
					checkName = "Name";
					exist = true;
					break;
				} else if (alias.equals(temp.getAlias())) {
//					checkAlias = "Alias";
					exist = true;
					break;
				}
			}
			
			if(exist == false) {
				returnAddVariableModel = new DFSVariableItemModel(null,notOptionalCheckBox.isSelected()
						, name
						,null
						,null
						, alias
						, vt
						, vg
						, rl
						, pv
						, description
						, null, DefineAtrribute.GROUPBY_TYPE.get(1), null, null, null, null, null);
				dialogStage.close();
			} else {
				if(checkName != null) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED", "Name of Variable is duplicated.",name+" name already exists.");
					messageLog.showAndWait();
				} else {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR : DUPLICATED", "Alias of variable is duplicated.",alias+" alias already exists.");
					messageLog.showAndWait();
				}
			}
			
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ADD ATTRIBUTE ERROR", "Not Define Name or Alias","Name and Alias should be defined.");
			messageLog.showAndWait();
		}
	}

	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}

	public DFSVariableItemModel getAddVariableModel() {
		return returnAddVariableModel;
	}

	public DFSVariableItemModel showAddVariableDialog(ObservableList<DFSVariableItemModel> tempSemiMasterInitData) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/semiMaster/DFSGeneratorSemiMasterAddAttributeVariableView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Define Add Variable");
			dialogStage.initModality(Modality.WINDOW_MODAL);

			dialogStage.initOwner(DFSGeneratorSemiMasterDefineController.dialogStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorSemiMasterAddAttributeVariableController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setAddDefineVariable(tempSemiMasterInitData);

			dialogStage.showAndWait();
//			return null;
			return controller.getAddVariableModel();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
