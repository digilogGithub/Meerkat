package com.digilog.meerkat.view.DFSGenerator.databaseSource;

import java.io.IOException;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.model.dfsGenerator.DFSDatabaseConnectionModel;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorSelectDatabaseSourceViewController {
	
//	private MessageDialog mDialog;
//	private Alert messageLog;
	
	private Stage dialogStage;
	
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
	private Button OK_Button;
	@FXML
	private Button Cancel_Button;
	
//	private ObservableList<DFSDatabaseConnectionModel> dfsConnectionModels;
	
	@FXML
	private void initialize() {
//		mDialog = new MessageDialog();
//		dfsConnectionModels = FXCollections.observableArrayList();
		
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
		
		DFSDatabaseTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	@FXML
	private void handle_OK_Button() {
		
		for(DFSDatabaseConnectionModel temp : DFSDatabaseTableView.getSelectionModel().getSelectedItems())
			System.out.println(temp.getDatasourceName());

	}
	
	@FXML
	private void handle_Cancel_Button() {
		dialogStage.close();
	}

	private void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	private void setSelectDatabaseSource() {
//		DFSDatabaseTableView.setItems(GeneralConfigurationController.dfsConnectionModels);
	}
	
//	private ObservableList<DFSDatabaseConnectionModel> getDatabaseConnectionModel() {
//		return null;
//	}
	
	
	public ObservableList<DFSDatabaseConnectionModel> showAddDatabaseSourceDialog() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/databaseSource/DFSGeneratorSelectDatabaseSourceView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Scene scene = new Scene(page);
			Stage dialogStage = new Stage();
			dialogStage.setTitle("ADD DATABASE SOURCE FOR eDdataLyzer");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			dialogStage.setScene(scene);

			DFSGeneratorSelectDatabaseSourceViewController controller = loader.getController();
			
			controller.setDialogStage(dialogStage);
			controller.setSelectDatabaseSource();

			dialogStage.showAndWait();
			
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
