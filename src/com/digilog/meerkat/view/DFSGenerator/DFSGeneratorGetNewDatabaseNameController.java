package com.digilog.meerkat.view.DFSGenerator;

import java.io.IOException;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.util.MessageDialog;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorGetNewDatabaseNameController {
	
	@FXML
	private TextField databaseSourceNameField;
	@FXML
	private Button OK_Button;
	@FXML
	private Button Cancel_Button;
	
	private Stage dialogStage;
	static boolean checkCondition;
	private ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList;

	// Data tag name dup check dialogBox
//	private MessageDialog mDialog;
//	private Alert messageLog;

	@FXML
	private void initialize() {
//		mDialog = new MessageDialog();
		checkCondition = true;	
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	@FXML
	private void handle_Ok() {	
			if(databaseSourceNameField.getText()!=null || !"".equals(databaseSourceNameField.getText())) {
				for(DFSGeneratorAndDatabaseListModel temp : databaseSourceModelList ) {
					if(databaseSourceNameField.getText().equals(temp.getDatabaseSource())) {
						checkCondition = false;
						break;
					}
				}
				if(checkCondition)
					dialogStage.close();
			} else {
				System.out.println("need name");
			}
	}
	
	@FXML
	private void handle_Cancel() {
		checkCondition = false;
		dialogStage.close();
	}

	public String get_addName() {
		return databaseSourceNameField.getText();
	}
	
	public void setInitData(ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList) {
		this.databaseSourceModelList = databaseSourceModelList;
	}
	
	public String showGetDatabaseNameSourceDialog(ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList ) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/DFSGeneratorGetNewDatabaseName.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Define Database Source Name");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorGetNewDatabaseNameController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setInitData(databaseSourceModelList);
			
			dialogStage.showAndWait();
			System.out.println(checkCondition);
			
			if(checkCondition)
				return controller.get_addName();
			else 
				return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
