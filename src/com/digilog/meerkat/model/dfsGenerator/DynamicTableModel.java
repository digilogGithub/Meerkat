package com.digilog.meerkat.model.dfsGenerator;

import javafx.collections.ObservableList;

public class DynamicTableModel {
	private final ObservableList<String> columnNames;
	private final ObservableList<ObservableList<Object>> tableDataSet;
	// private ObjectProperty<DEFINE_TYPE> content3;

	public DynamicTableModel(ObservableList<String> columnNames, ObservableList<ObservableList<Object>> tableData) {
		this.columnNames = columnNames;
		this.tableDataSet = tableData;
	}

	public int getNumColumns() {
		return columnNames.size();
	}

	public String getColumnName(int index) {
		return columnNames.get(index);
	}

	public int getNumRows() {
		return tableDataSet.size();
	}

	public Object getData(int column, int row) {
		return tableDataSet.get(row).get(column);
	}

	public ObservableList<ObservableList<Object>> getData() {
		return tableDataSet;
	}
	
	// public DEFINE_TYPE getContent3() {
		// return content3.get();
		// }
		//
		// public void setContent3(DEFINE_TYPE content3) {
		// this.content3.set(content3);
		// }
		//
		// public ObjectProperty<DEFINE_TYPE> content3Property() {
		// return content3;
		// }
}
