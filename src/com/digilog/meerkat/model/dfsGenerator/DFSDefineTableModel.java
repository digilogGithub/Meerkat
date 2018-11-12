package com.digilog.meerkat.model.dfsGenerator;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class DFSDefineTableModel implements Cloneable {
	private SimpleStringProperty table_format;
	private SimpleStringProperty datasource;
	private SimpleStringProperty data_tag_name;
	private SimpleStringProperty alias_name;
	private SimpleStringProperty table_Name;
	private SimpleStringProperty type;
	private SimpleStringProperty level;
	private SimpleStringProperty totime_javaformat;
	private SimpleStringProperty totime;
	private SimpleStringProperty timetochar;
	private SimpleStringProperty numbertochar;
	private SimpleBooleanProperty contentBoolean;

	public DFSDefineTableModel() {

	}

	public DFSDefineTableModel(String table_format, String datasource, String data_tag_name, String alias_name, String table_Name,
			String type, String level		
			, String totime_javaformat, String totime, String timetochar, String numbertochar,
			boolean contentBoolean) {
		this.table_format = new SimpleStringProperty(table_format);
		this.datasource = new SimpleStringProperty(datasource);
		this.data_tag_name = new SimpleStringProperty(data_tag_name);
		this.alias_name = new SimpleStringProperty(alias_name);
		this.table_Name = new SimpleStringProperty(table_Name);
		this.type = new SimpleStringProperty(type);
		this.level = new SimpleStringProperty(level);
		this.totime_javaformat = new SimpleStringProperty(totime_javaformat);
		this.totime = new SimpleStringProperty(totime);
		this.timetochar = new SimpleStringProperty(timetochar);
		this.numbertochar = new SimpleStringProperty(numbertochar);
		this.contentBoolean = new SimpleBooleanProperty(contentBoolean);
	}

	// table format - internal value
	public String getTable_format() {
		return table_format.get();
	}

	public void setDTable_format(String table_format) {
		this.table_format.set(table_format);
	}

	public SimpleStringProperty table_formatProperty() {
		return table_format;
	}

	// data_tag_name
	public String getData_tag_name() {
		return data_tag_name.get();
	}

	public void setData_tag_name(String data_tag_name) {
		this.data_tag_name.set(data_tag_name);
	}

	public SimpleStringProperty data_tag_nameProperty() {
		return data_tag_name;
	}

	// alias_name
	public String getAlias_name() {
		return alias_name.get();
	}

	public void setAlias_name(String alias_name) {
		this.alias_name.set(alias_name);
	}

	public SimpleStringProperty alias_nameProperty() {
		return alias_name;
	}

	// table name
	public String getTable_Name() {
		return table_Name.get();
	}

	public void setTable_Name(String table_Name) {
		this.table_Name.set(table_Name);
	}

	public SimpleStringProperty table_NameProperty() {
		return table_Name;
	}

	// type
	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.set(type);
	}

	public SimpleStringProperty typeProperty() {
		return type;
	}

	// level_type
	public String getLevel() {
		return level.get();
	}

	public void setLevel(String level) {
		this.level.set(level);
	}

	public SimpleStringProperty levelProperty() {
		return level;
	}

//	 datasource
	public String getDBsource() {
		return datasource.get();
	}

	public void setDBsource(String datasource) {
		this.datasource.set(datasource);
	}

	public SimpleStringProperty DBsourceProperty() {
		return datasource;
	}

	// totime_javaformat
	public String getTotime_javaformat() {
		return totime_javaformat.get();
	}

	public void setTotime_javaformat(String totime_javaformat) {
		this.totime_javaformat.set(totime_javaformat);
	}

	public SimpleStringProperty totime_javaformatProperty() {
		return totime_javaformat;
	}

	// totime
	public String getTotime() {
		return totime.get();
	}

	public void setTotime(String totime) {
		this.totime.set(totime);
	}

	public SimpleStringProperty totimeProperty() {
		return totime;
	}

	// timetochar
	public String getTimetochar() {
		return timetochar.get();
	}

	public void setTimetochar(String timetochar) {
		this.timetochar.set(timetochar);
	}

	public SimpleStringProperty timetocharProperty() {
		return timetochar;
	}

	// numbertochar
	public String getNumbertochar() {
		return numbertochar.get();
	}

	public void setNumbertochar(String numbertochar) {
		this.numbertochar.set(numbertochar);
	}

	public SimpleStringProperty numbertocharProperty() {
		return numbertochar;
	}

	// contentBoolean getter and setter
	public boolean getContentBoolean() {
		return contentBoolean.get();
	}

	public void setContentBoolean(boolean contentBoolean) {
		this.contentBoolean.set(contentBoolean);
	}

	public SimpleBooleanProperty contentBooleanProperty() {
		return contentBoolean;
	}
	
	public DFSDefineTableModel clone() throws CloneNotSupportedException {
		DFSDefineTableModel cloneModel = (DFSDefineTableModel) super.clone();
		return cloneModel;	
	}

}
