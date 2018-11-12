package com.digilog.meerkat.view.DFSGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.attribute.SQLStatements;
import com.digilog.meerkat.model.dfsGenerator.DynamicTableModel;
import com.digilog.meerkat.util.MessageDialog;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class DFSGeneratorPreviewTableDataController {

	private MessageDialog mDialog = new MessageDialog();
	private Alert messageLog;

	private TableView<ObservableList<Object>> tableView;
	private DynamicTableModel dynaminTableModel;
	private ObservableList<ObservableList<Object>> tableDataSet = FXCollections.observableArrayList();
	private ObservableList<String> columnNames = FXCollections.observableArrayList();

	// String catPath =
	// "/Users/digilog/Documents/workspace/Meerkat/png/cat.png";
	// String numPath =
	// "/Users/digilog/Documents/workspace/Meerkat/png/INFINITE2.jpg";
	// String timePath =
	// "/Users/digilog/Documents/workspace/Meerkat/png/time.png";

	public TableView<ObservableList<Object>> getPriviewRawData(Connection connDB, String l_tableName) {

		try {
			String sql = SQLStatements.selectTablePreviewData + l_tableName + " where rownum <= 100";
			PreparedStatement pstmt;
			ResultSet res;
			pstmt = connDB.prepareStatement(sql);
			res = pstmt.executeQuery();
			ResultSetMetaData rsmd = res.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();

			for (int i = 0; i < numberOfColumns; i++) {
				columnNames.add(res.getMetaData().getColumnName(i + 1));
			}

			while (res.next()) {
				ObservableList<Object> row = FXCollections.observableArrayList();
				for (int i = 1; i <= numberOfColumns; i++) {
					row.add(res.getString(i));
				}
				tableDataSet.add(row);
			}

			tableView = new TableView<>();
			dynaminTableModel = new DynamicTableModel(columnNames, tableDataSet);

			for (int i = 0; i < dynaminTableModel.getNumColumns(); i++) {
				TableColumn<ObservableList<Object>, Object> column = new TableColumn<>(
						dynaminTableModel.getColumnName(i));
				int columnIndex = i;

				// TableColumn<ObservableList<Object>, Object> column = new
				// TableColumn<>();
				// Image cat = new Image(new FileInputStream(catPath));
				// Image num = new Image(new FileInputStream(numPath));
				// Image time = new Image(new FileInputStream(timePath));
				//
				// ImageView iconImageView1 = new ImageView(cat);
				// ImageView iconImageView2 = new ImageView(num);
				// ImageView iconImageView3 = new ImageView(time);
				// iconImageView1.setFitHeight(17);
				// iconImageView1.setPreserveRatio(true);
				// iconImageView2.setFitHeight(17);
				// iconImageView2.setPreserveRatio(true);
				// iconImageView3.setFitHeight(17);
				// iconImageView3.setPreserveRatio(true);
				//
				// ObservableList<ImageView> ai=
				// FXCollections.observableArrayList();
				// ai.add(iconImageView1);
				// ai.add(iconImageView2);
				// ai.add(iconImageView3);
				//
				// ComboBox<ImageView> type = new ComboBox<ImageView>();
				// type.setItems(ai);
				// type.setMaxSize(50, 25);
				// type.setPrefSize(50, 25);
				// type.setMinSize(50, 25);
				//
				// Label columnName = new
				// Label(dynaminTableModel.getColumnName(i));
				// HBox headerGraphic = new HBox();
				//
				// HBox.setHgrow(columnName, Priority.ALWAYS);
				// HBox.setHgrow(type, Priority.NEVER);
				// headerGraphic.maxWidth(HBox.USE_COMPUTED_SIZE);
				// headerGraphic.maxHeight(HBox.USE_COMPUTED_SIZE);
				// headerGraphic.minWidth(HBox.USE_COMPUTED_SIZE);
				// headerGraphic.minHeight(HBox.USE_COMPUTED_SIZE);
				// headerGraphic.setPrefWidth(HBox.USE_COMPUTED_SIZE);
				// headerGraphic.setPrefHeight(HBox.USE_COMPUTED_SIZE);
				// headerGraphic.setAlignment(Pos.CENTER_LEFT);
				// headerGraphic.getChildren().addAll(columnName, type);
				// columnName.prefWidthProperty().bind(headerGraphic.widthProperty());
				//
				// column.setGraphic(headerGraphic);
				// headerGraphic.prefWidthProperty().bind(column.widthProperty());
				// column.minWidthProperty().bind(columnName.widthProperty());

				column.setCellValueFactory(
						cellData -> new SimpleObjectProperty<>(cellData.getValue().get(columnIndex)));
				tableView.getColumns().add(column);
			}

			AnchorPane.setTopAnchor(tableView, 5.0);
			AnchorPane.setLeftAnchor(tableView, 10.0);
			AnchorPane.setRightAnchor(tableView, 10.0);
			AnchorPane.setBottomAnchor(tableView, 10.0);
			tableView.getItems().setAll(dynaminTableModel.getData());

			return tableView;

		} catch (Exception e) {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "DATABASE ERROR", "SQL ERROR",
					e.getMessage());
			messageLog.showAndWait();
			return null;
		}

	}

}
