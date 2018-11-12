package com.digilog.meerkat.view.DFSGenerator.xml;

import java.io.File;
import java.io.IOException;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.util.MessageDialog;
//import com.digilog.meerkat.view.generalConfiguration.GeneralConfigurationController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorXMLExportEditViewController {

	@FXML
	private TextField DatabaseNameField;
	@FXML
	private TextField CrawlerFileNameField;
	@FXML
	private TextField GathererFileNameField;

	@FXML
	private ComboBox<String> eDLDatabase;
	@FXML
	private TextField userIDField;
	@FXML
	private TextField passwordField;
	@FXML
	private TextField hostNameField;
	@FXML
	private TextField portField;
	@FXML
	private TextField SIDField;
	@FXML
	private TextField DatabaseInfoFileNameField;

	@FXML
	private Button Export_Button;
	@FXML
	private Button Cancel_Button;
	
	@FXML
	private Button Crawler_Browser_Button;
	@FXML
	private Button Gatherer_Browser_Button;
	@FXML
	private Button DBINFO_Browser_Button;

	private Stage dialogStage;

	private MessageDialog mDialog;
	private Alert messageLog;

	static boolean createXMLFile;
	private DFSGeneratorXMLInfoModel dfsGeneratorXMLInfoModel;
	public static String initDatabaseName;

	@FXML
	private void initialize() {
		dfsGeneratorXMLInfoModel = new DFSGeneratorXMLInfoModel();
		mDialog = new MessageDialog();
		eDLDatabase.getItems().setAll(DefineAtrribute.eDL_DATABASE_GROUP);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	private int setDB(String dbType) {
		
		int returnValue;
		
		switch (dbType) {
		case "Oracle":
			returnValue = 0;
			break;

		case "PostgreSQL":
			returnValue = 1;
			break;
			
		case "MySQL":
			returnValue = 2;
			break;
			
		default:
			returnValue = 3;
			break;
		}
		
		return returnValue;
	}
	
	@FXML
	private void handle_crawler_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(dfsGeneratorXMLInfoModel.getCrawlerFileName()).getAbsoluteFile().getParent()));
		CrawlerFileNameField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_gatherer_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(dfsGeneratorXMLInfoModel.getGathererFileName()).getAbsoluteFile().getParent()));
		GathererFileNameField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_dbInfo_browser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(new File(dfsGeneratorXMLInfoModel.getDatabaseInfoFileName()).getAbsoluteFile().getParent()));
		GathererFileNameField.setText(fileChooser.showSaveDialog(null).getPath());
	}
	
	@FXML
	private void handle_OK() {

		if (DatabaseNameField.getText() != null && !DatabaseNameField.getText().equals("")) {
			createXMLFile = true;
			dfsGeneratorXMLInfoModel.setDatabaseName(DatabaseNameField.getText());
			dfsGeneratorXMLInfoModel.setCrawlerFileName(CrawlerFileNameField.getText());
			dfsGeneratorXMLInfoModel.setGathererFileName(GathererFileNameField.getText());
			dfsGeneratorXMLInfoModel.setEDLDatabaseType(eDLDatabase.getSelectionModel().getSelectedItem().toString());
			dfsGeneratorXMLInfoModel.setUserID(userIDField.getText());
			dfsGeneratorXMLInfoModel.setPassword(passwordField.getText());
			dfsGeneratorXMLInfoModel.setHostName(hostNameField.getText());
			dfsGeneratorXMLInfoModel.setPort(portField.getText());
			dfsGeneratorXMLInfoModel.setSid(SIDField.getText());
			dfsGeneratorXMLInfoModel.setDatabaseInfoFileName(DatabaseInfoFileNameField.getText());
			dialogStage.close();
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR",
					"ERROR : Database Name isn't defined.", "Check database name field");
			messageLog.showAndWait();
		}
	}

	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}
	
	public void setInitConfig(DFSGeneratorXMLInfoModel dfsGeneratorXMLInfoModel) {
		try {
			this.dfsGeneratorXMLInfoModel = dfsGeneratorXMLInfoModel.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DatabaseNameField.setText(dfsGeneratorXMLInfoModel.getDatabaseName());
		CrawlerFileNameField.setText(dfsGeneratorXMLInfoModel.getCrawlerFileName());
		GathererFileNameField.setText(dfsGeneratorXMLInfoModel.getGathererFileName());
		eDLDatabase.getSelectionModel().select(setDB(dfsGeneratorXMLInfoModel.getEDLDatabaseType()));
		userIDField.setText(dfsGeneratorXMLInfoModel.getUserID());
		passwordField.setText("*1)");
		hostNameField.setText(dfsGeneratorXMLInfoModel.getHostName());
		portField.setText(dfsGeneratorXMLInfoModel.getPort());
		SIDField.setText(dfsGeneratorXMLInfoModel.getSid());
		DatabaseInfoFileNameField.setText(dfsGeneratorXMLInfoModel.getDatabaseInfoFileName());
	}

	public DFSGeneratorXMLInfoModel getDFSExportXMLInfoModel() {
		return dfsGeneratorXMLInfoModel;
	}

	public DFSGeneratorXMLInfoModel showExportXMLEditDialog(DFSGeneratorXMLInfoModel dfsGeneratorXMLInfoModel) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/xml/DFSGeneratorXMLExportEditView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Export DFS Config XML File");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorXMLExportEditViewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setInitConfig(dfsGeneratorXMLInfoModel);

			dialogStage.showAndWait();
			if (createXMLFile == true)
				return controller.getDFSExportXMLInfoModel();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
