package com.digilog.meerkat.model.dfsGenerator;

import javafx.beans.property.SimpleStringProperty;

public class SimpleTableModel {

	SimpleStringProperty name;
	SimpleStringProperty common;

	public SimpleTableModel(String name, String common) {
		this.name = new SimpleStringProperty(name);
		this.common = new SimpleStringProperty(common);
	}
	
	public SimpleTableModel(String table_Name) {
		this.name = new SimpleStringProperty(table_Name);
	}

	// table name
	public String getName() {
		return name.get();
	}

	public void setName(String table_Name) {
		this.name.set(table_Name);
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	// common getter and setter
	public String getCommon() {
		return common.get();
	}

	public void setCommon(String common) {
		this.common.set(common);
	}

	public SimpleStringProperty commonProperty() {
		return common;
	}

}
