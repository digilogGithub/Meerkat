package com.digilog.meerkat.view.DFSGenerator;

import java.io.IOException;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineDatatagInitItemModel;
import com.digilog.meerkat.util.MessageDialog;
import com.digilog.meerkat.view.RootGeneralConfigViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorAddTableController {
	@FXML
	private TextField DFSDataTagNameField;
	@FXML
	private TextField aliasNameField;
	@FXML
	private TextField tableNameField;
	@FXML
	private TextField timeJAVAFormatField;
	@FXML
	private TextField timeFormatField;

	@FXML
	private ComboBox<String> tableFormat;
	@FXML
	private ComboBox<String> type;
	@FXML
	private ComboBox<String> level;

	@FXML
	private Button Cancel;
	@FXML
	private Button OK;

	private Stage dialogStage;
	private String databaseSource;
	private DFSDefineTableModel tempDefineTableModel;
	private ObservableList<String> datatagInitList;
//	private TableView<DFSDefineTableModel> checkDefineTable;

	// Data tag name dup check dialogBox
	private MessageDialog mDialog;
	private Alert messageLog;

	@FXML
	private void initialize() {
		mDialog = new MessageDialog();
		datatagInitList = FXCollections.observableArrayList();
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setDatabaseSource(String databaseSourceName) {
		this.databaseSource = databaseSourceName;
	}

	public void setAddDefineTable(String tableName, TableView<DFSDefineTableModel> defineTableView, ObservableList<DFSDefineDatatagInitItemModel> semiDatatagListInitData) {
		tableFormat.getItems().setAll(DefineAtrribute.TABLE_FORMAT);		
		DFSDataTagNameField.setText(tableName);
		aliasNameField.setText(tableName);
		tableNameField.setText(tableName);
		timeJAVAFormatField.setText("yyyy-MM-dd HH:mm:ss.sss");
		timeFormatField.setText("YYYY-MM-DD HH24:MI:SS.FF3");
		type.getItems().setAll(DefineAtrribute.TYPE);
		level.getItems().setAll(DefineAtrribute.LVEL_TYPE);
		
		tableFormat.getSelectionModel().select(0);
		type.getSelectionModel().select(1);
		level.getSelectionModel().select(1);

		for(DFSDefineDatatagInitItemModel itr : semiDatatagListInitData) {
			String type = itr.getTypeName();
			String level = itr.getLevelName();
			datatagInitList.add(type+level);
		}	
		
//		checkDefineTable = defineTableView;
	}

	@FXML
	private void handleAddTableOk() {

		boolean checkCondition = false;
		String databaseSourceName = null;
		String tagOrAlias = null;

		for (String datatagInitTypeLevel : datatagInitList) {
			System.out.println(datatagInitTypeLevel+"    "+type.getSelectionModel().getSelectedItem().toString()+level.getSelectionModel().getSelectedItem().toString());
			if (datatagInitTypeLevel.equals(type.getSelectionModel().getSelectedItem().toString()+level.getSelectionModel().getSelectedItem().toString())) {
				checkCondition = true;
				break;
			}
		}

		if (!DFSDataTagNameField.getText().equals("") && !aliasNameField.getText().equals("") && checkCondition) {
			for(DFSGeneratorAndDatabaseListModel tempTagModel : RootGeneralConfigViewController.databaseSourceModelList) {
				if (tempTagModel.getDfsGeneratorMainController().getController().getDFSDefineTableData().size() > 0) {
					for (DFSDefineTableModel tempDatatag : tempTagModel.getDfsGeneratorMainController().getController().getDFSDefineTableData())  {
						if (DFSDataTagNameField.getText().equals(tempDatatag.getData_tag_name())) {
							databaseSourceName = tempDatatag.getDBsource();
							tagOrAlias = "tag";
							checkCondition = false;
							break;
						} else if (aliasNameField.getText().equals(tempDatatag.getAlias_name())) {
							databaseSourceName = tempDatatag.getDBsource();
							checkCondition = false;
							break;
						}
					}
				}
			}
			if (checkCondition) {
				// convert time format for eDL
				String toTime = "TO_TIMESTAMP(@VALUE,'" + timeFormatField.getText() + "')";
				String timeToChar = "TO_CHAR(@VALUE,'" + timeFormatField.getText() + "')";
				String numberToChar = "TO_CHAR(@VALUE)";

				tempDefineTableModel = new DFSDefineTableModel(
						tableFormat.getSelectionModel().getSelectedItem().toString(), databaseSource, DFSDataTagNameField.getText(),
						aliasNameField.getText(), tableNameField.getText(),
						type.getSelectionModel().getSelectedItem().toString(),
						level.getSelectionModel().getSelectedItem().toString(), timeJAVAFormatField.getText(), toTime,
						timeToChar, numberToChar, false);
				dialogStage.close();
			} else {
				if (tagOrAlias != null) {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR INFO",
							"DATATAG NAME DUPLICATE ERROR", "There is a duplicated DataTag Name in DFS Define List\n\n"
									+ "Duplicated DataTag Name : "+databaseSourceName+" / "+DFSDataTagNameField.getText());
				} else {
					messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "ERROR INFO",
							"ALIAS NAME DUPLICATE ERROR", "There is a duplicated Alias Name in DFS Define List\n\n"
									+ "Duplicated Alias Name : " +databaseSourceName+" / "+aliasNameField.getText());
				}
				messageLog.showAndWait();
			}
		} else if (checkCondition) {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "DEFINE DATATAG ERROR",
					"Not Define DataTag Name or Alias Name", "DataTag name and Alias name should be defined.");
			messageLog.showAndWait();
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "DEFINE DATATAG ERROR",
					"Not Define Type & Level.",
					type.getSelectionModel().getSelectedItem().toString() + " & "
							+ level.getSelectionModel().getSelectedItem().toString()
							+ " isn't defined\nCheck Semimaster DataTag Define List.");
			messageLog.showAndWait();
		}
	}

	@FXML
	private void handleAddTableCancel() {
		dialogStage.close();
	}

	public DFSDefineTableModel getTempDefineTableModel() {
		return tempDefineTableModel;
	}

	public DFSDefineTableModel showAddTableDialog(String databaseSourceName, String tableName, TableView<DFSDefineTableModel> defineTableView
			, ObservableList<DFSDefineDatatagInitItemModel> semiDatatagListInitData ) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/DFSGeneratorAddTablelView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Define Add Table");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorAddTableController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDatabaseSource(databaseSourceName);
			controller.setAddDefineTable(tableName, defineTableView, semiDatatagListInitData);

			dialogStage.showAndWait();

			return controller.getTempDefineTableModel();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
